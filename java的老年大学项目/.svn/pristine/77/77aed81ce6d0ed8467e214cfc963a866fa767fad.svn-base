package com.learnyeai.schoolclass.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.CustInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.error.OrderExistException;
import com.learnyeai.schoolclass.model.ClzStudentClazz;
import com.learnyeai.schoolclass.service.ClzStudentClazzWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzStudentClazzController.BASE_URL)
public class ClzStudentClazzController extends BaseController<ClzStudentClazz> {
	public static final String BASE_URL = "/ClzStudentClazz/";
	@Autowired
	private BaseInfoDao baseInfoDao;

	@Autowired
	private ClzStudentClazzWyService clzStudentClazzWyService;

	@Override
	protected BaseService<ClzStudentClazz> getService() {
		return clzStudentClazzWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		ClzStudentClazz sc = clzStudentClazzWyService.convert2Bean(ctx.getParamMap());
		if ("signuped".equals(method)) {
			return clzStudentClazzWyService.signuped(sc);
		}else if ("signup".equals(method)) {
			Map<String, Object> result = new HashMap<String, Object>();
			try {
				result = clzStudentClazzWyService.saveSignup(ctx.getParamMap());
				return result;
			} catch (OrderExistException e) {
				result = new HashMap<String, Object>();
				result.put("status", "2");
				result.put("msg", "创建订单失败,已存在待付订单!");
				result.put("orderId", e.getOrderId());
				result.put("orderNo", e.getOrderNo());
				return result;
			} catch (Exception e) {
				result.put("status", "0");
				result.put("msg", "系统异常,报名失败!");
				return result;
			}
		}else if ("queryShowPage".equals(method)) {
			return rtnPageList4Report(clzStudentClazzWyService.queryShowPage(sc));
		}else if ("queryUserClazzPage".equals(method)) {
			return rtnPageList4Report(clzStudentClazzWyService.queryUserClazzPage(sc));
		}else if ("importStudent".equals(method)) {
			return clzStudentClazzWyService.importStudent();
		}else if(method.equals("batchAddStudent")){
			return batchAddStudent(ctx);
		}else if("GetUserAuth".equals(method)){
			return clzStudentClazzWyService.GetUserAuth(ctx);
		}

		return super.execute(ctx);
	}

	// 批量添加学员
	public Object batchAddStudent(IBusinessContext ctx){
		String czId = ctx.getParam("czId");
		String ids = ctx.getParam("ids");
		String[] idArr = ids.split(",");
		List<CustInfoVo> custList = new ArrayList<>();
		List<String> idList = new ArrayList<>();
		for(String id : idArr) {
			if(StringUtils.isBlank(id))
				continue;
			CustInfoVo cust = baseInfoDao.queryCustInfo(id);
			if(null != cust){
				custList.add(cust);
				idList.add(id);
			}
		}
		int addNum = 0;
		if(idList.size() > 0) {
			addNum = clzStudentClazzWyService.batchAddStudent(czId, idList.toArray(new String[idList.size()]));
		}

		Map rst = new HashMap();
		rst.put("newAddNum", addNum);

		return rst;

	}
}
