package com.learnyeai.schoolclass.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.schoolclass.api.service.CrsCourseApiService;
import com.learnyeai.schoolclass.api.service.OrdOrderformApiService;
import com.learnyeai.schoolclass.api.vo.CrsCourseVo;
import com.learnyeai.schoolclass.api.vo.OrdOrderformDetailVo;
import com.learnyeai.schoolclass.api.vo.OrdOrderformVo;
import com.learnyeai.schoolclass.error.OrderExistException;
import com.learnyeai.schoolclass.mapper.ClzClazzBatchMapper;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.model.ClzClazzBatch;
import com.learnyeai.schoolclass.model.ClzClazzCourse;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class ClzClazzBatchWyService extends WeyeBaseService<ClzClazzBatch> {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ClzClazzBatchMapper clzClazzBatchMapper;

	@Resource
	private ClzStudentBatchWyService clzStudentBatchWyService;

	@Resource
	private ClzBatchCourseWyService clzBatchCourseWyService;

	@Resource
	private OrdOrderformApiService ordOrderformApiService;

	@Resource
	private CrsCourseApiService crsCourseApiService;

	@Override
	public BaseMapper<ClzClazzBatch> getMapper() {
		return clzClazzBatchMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Override
	protected Weekend<ClzClazzBatch> genSqlExample(ClzClazzBatch t, Map params) {
		Weekend<ClzClazzBatch> w = super.genSqlExample(t, params);
		WeekendCriteria<ClzClazzBatch, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCzId())) {
			c.andEqualTo(ClzClazzBatch::getCzId, t.getCzId());
		}
		w.and(c);
		return w;
	}

	/**
	 * 前台人个用户报名
	 * 
	 * @param cust
	 * @param clazz
	 * @param clazzCourses
	 * @return
	 */
	@Transactional
	public Map<String, String> saveClazzBatch(CustInfoVo cust, ClzClazz clazz, List<ClzClazzCourse> clazzCourses,
			String siteId, String normal, boolean totalPay) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		ClzClazzBatch batch = new ClzClazzBatch();
		batch.setCzId(clazz.getCzId());
		batch.setBatchName(clazz.getCzName() + "_人个报名_" + cust.getCustName());
		batch.setBatchType(0);
		batch.setCustId(cust.getCustId());
		batch.setDelFlag("0");
		batch.setSingupDate(new Date());
		batch.setNormal(normal);
		super.save(batch);
		
		OrdOrderformVo orderform = new OrdOrderformVo();
		orderform.setUserId(cust.getCustId());
		orderform.setCzId(clazz.getCzId());
		orderform.setBatchId(batch.getBatchId());
		orderform.setCallbackUrl("");// 待定
		orderform.setName(clazz.getCzName() + "_人个报名_" + cust.getCustName());
		orderform.setUserName(cust.getCustName());
		orderform.setIdcard(cust.getIdcarNo());
		orderform.setSiteId(siteId);
		orderform.setPayAppType(OrdOrderformVo.PAY_APPTYPE_WEB);
		List<OrdOrderformDetailVo> details = new ArrayList<OrdOrderformDetailVo>();
		OrdOrderformDetailVo detail = null;
		double needPrice = 0d;
		for (ClzClazzCourse cc : clazzCourses) {
			logger.debug("开始调用课程详细服务接口csId={}",cc.getCsId());
			CrsCourseVo course = crsCourseApiService.queryCourseApi(cc.getCsId());
			if (course != null) {
				cc.setCsName(course.getCsName());
			}
			detail = new OrdOrderformDetailVo();
			detail.setItemId(cc.getCsId());
			detail.setItemname(cc.getCsName());
			detail.setItemnum(1);
			detail.setItemType(1);
			details.add(detail);
			needPrice += cc.getCsAmount().doubleValue();
		}
		if (totalPay) {
			needPrice = clazz.getCzTrainingFee().doubleValue();
		}
		orderform.setNeedPrice(needPrice);
		orderform.setRealPrice(needPrice);
		orderform.setDiscount(0d);
		orderform.setDetails(details);
		String jsonData = JSONObject.toJSONString(orderform);
		// 0:成功 1:异常 2:已存在待付订单号
		logger.debug("开始调用订单服务接口 jsonData= {}",jsonData);
		Map<String, Object> map = ordOrderformApiService.savePersonSignupOrderform(jsonData);
		String orderId = "";
		if ("0".equals(map.get("status").toString())) {// 订单生成成功
			orderId = map.get("orderId") + "";
			batch.setBatchId(orderId);
			super.save(batch);
			boolean success = clzBatchCourseWyService.saveBatchCourse(batch, clazzCourses);
			List<CustInfoVo> custs = new ArrayList<CustInfoVo>();
			custs.add(cust);
			if (success) {
				success = clzStudentBatchWyService.saveStudentBatch(batch, custs, clazz);
			}
			result.put("orderId", map.get("orderId").toString());
			result.put("orderNo", map.get("orderNo").toString());
			result.put("msg", map.get("msg").toString());
			result.put("status", map.get("status").toString());
		} else if ("1".equals(map.get("status").toString())) {
			throw new OrderExistException("已存在待付订单号!", map.get("orderId").toString(), map.get("orderNo").toString());
		} else {
			throw new Exception(map.get("msg").toString());
		}
		return result;
	}

	@Transactional
	public boolean updateClazzBatch(String batchId) {
		ClzClazzBatch batch = new ClzClazzBatch();
		batch.setBatchId(batchId);
		batch.setNormal("1");
		super.updateBySelect(batch);
		return true;
	}

}
