package com.learnyeai.schoolclass.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

import javax.annotation.Resource;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.api.service.CtUserCertApiService;
import com.learnyeai.schoolclass.api.vo.CtUserCertVo;
import com.learnyeai.schoolclass.mapper.ClzStudentClazzMapper;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.model.ClzClazzCourse;
import com.learnyeai.schoolclass.model.ClzClazzTest;
import com.learnyeai.schoolclass.model.ClzStudentClazz;
import com.learnyeai.schoolclass.model.ClzUserClazzCourse;
import com.learnyeai.tools.common.BeanUtils;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class ClzStudentClazzWyService extends WeyeBaseService<ClzStudentClazz> {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ClzStudentClazzMapper clzStudentClazzMapper;
	@Resource
	private ClzClazzWyService clzClazzWyService;
	@Resource
	private ClzClazzCourseWyService clzClazzCourseWyService;
	@Resource
	private ClzUserClazzCourseWyService clzUserClazzCourseWyService;
	@Resource
	private ClzClazzBatchWyService clzClazzBatchWyService;
	@Resource
	private CtUserCertApiService ctUserCertApiService;
	@Resource
	private ClzClazzTestWyService clzClazzTestWyService;
	@Autowired
	private BaseInfoDao baseInfoDao;

	@Value("${cert.url}")
	private String certUrl;

	@Override
	public BaseMapper<ClzStudentClazz> getMapper() {
		return clzStudentClazzMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public Object signuped(ClzStudentClazz sc) {
		List<ClzStudentClazz> list = new ArrayList<ClzStudentClazz>();
		for (String czId : sc.getCzId().split(",")) {
			ClzStudentClazz obj = new ClzStudentClazz();
			obj.setNormal("1");
			obj.setCustId(sc.getCustId());
			obj.setCzId(czId);
			ClzStudentClazz result = super.queryOne(obj);
			if (result == null) {
				obj.setNormal("0");
				list.add(obj);
			} else {
				list.add(result);
			}
		}
		return list;
	}

	/**
	 * 前台个人报名 save 开头的自动事务管理，注解好像淌起作用
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> saveSignup(Map params) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String custId = (String) BeanUtils.getProperty(params, "custId");
		String czId = (String) BeanUtils.getProperty(params, "czId");
		String csId = (String) BeanUtils.getProperty(params, "csId");
		String addCourse = (String) BeanUtils.getProperty(params, "addCourse");// 是否加入课程
		String userAuth = (String) BeanUtils.getProperty(params, "userAuth");
		ClzClazz clazz = clzClazzWyService.queryById(czId);
		if (clazz == null) {
			result.put("status", "0");
			result.put("msg", "班级不存在!");
			return result;
		}
		List<ClzClazzCourse> clazzCourses = new ArrayList<ClzClazzCourse>();
		if ("1".equals(addCourse)) {// 所有班级课程
			ClzClazzCourse clazzCourse = new ClzClazzCourse();
			clazzCourse.setCzId(czId);
			clazzCourse.setDelFlag("0");
			if (StringUtils.isNotBlank(csId)) {// 没有传课程id就全选
				clazzCourse.setCsId(csId);
			}
			clazzCourses = clzClazzCourseWyService.queryList(clazzCourse, null);
			/*
			 * if (clazzCourses == null || clazzCourses.size() < 1) {//可以不报课程
			 * result.put("status", "0"); result.put("msg", "至少选择一门课程!"); return result; }
			 */
		} else if ("2".equals(addCourse)) {// 所有班级课程中的必修课程
			ClzClazzCourse clazzCourse = new ClzClazzCourse();
			clazzCourse.setCzId(czId);
			clazzCourse.setDelFlag("0");
			clazzCourse.setCsType(2);// 必修课程
			if (StringUtils.isNotBlank(csId)) {// 没有传课程id就全选
				clazzCourse.setCsId(csId);
			}
			clazzCourses = clzClazzCourseWyService.queryList(clazzCourse, null);
		}

		CustInfoVo cust = baseInfoDao.queryCustInfo(custId);
		// 取班级id
		String siteId = clazz.getSiteId();
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_SITE, siteId);
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT, clazz.getMchtId());
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT_SCHEME, clazz.getMchtSchmId());
		if ("1".equals(clazz.getCzChargeMode())) {// 1免费报名不生成批次
			boolean success = this.saveStudentClazz(cust, clazz, siteId, "1",userAuth); // 学生班级报名
			if (success) {
				success = clzUserClazzCourseWyService.saveUserClazzCourse(cust, clazz, clazzCourses, siteId, "1");
				if (success) {
					clzClazzWyService.updateJoinupNum(czId, 1);
					result.put("status", "3");
					result.put("msg", "报名成功");
					return result;
				}
			} else {
				result.put("status", "0");
				result.put("msg", "报名失败");
				return result;
			}
		} else if ("2".equals(clazz.getCzChargeMode())) {
			boolean success = this.saveStudentClazz(cust, clazz, siteId, "0",userAuth); // 学生班级报名
			if (success) {
				success = clzUserClazzCourseWyService.saveUserClazzCourse(cust, clazz, clazzCourses, siteId, "0");
				if (success) {
					Map<String, String> map = clzClazzBatchWyService.saveClazzBatch(cust, clazz, clazzCourses, siteId,
							"0", true);
					if ("0".equals(map.get("status"))) {
						result.put("status", "1");
						result.put("msg", "待支付");
						result.put("orderId", map.get("orderId"));
						result.put("orderNo", map.get("orderNo"));
						return result;
					}
				} else {
					result.put("status", "0");
					result.put("msg", "报名失败");
					return result;
				}
			} else {
				result.put("status", "0");
				result.put("msg", "报名失败");
				return result;
			}
		} else if ("3".equals(clazz.getCzChargeMode())) {
			boolean success = this.saveStudentClazz(cust, clazz, siteId, "0",userAuth); // 学生班级报名
			if (success) {
				success = clzUserClazzCourseWyService.saveUserClazzCourse(cust, clazz, clazzCourses, siteId, "0");
				if (success) {
					Map<String, String> map = clzClazzBatchWyService.saveClazzBatch(cust, clazz, clazzCourses, siteId,
							"0", false);
					if ("0".equals(map.get("status"))) {
						result.put("status", "1");
						result.put("msg", "待支付");
						result.put("orderId", map.get("orderId"));
						result.put("orderNo", map.get("orderNo"));
						return result;
					}
				} else {
					result.put("status", "0");
					result.put("msg", "报名失败");
					return result;
				}
			} else {
				result.put("status", "0");
				result.put("msg", "报名失败");
				return result;
			}
		}

		result.put("status", "3");
		result.put("msg", "报名成功");
		return result;
	}

	@Transactional
	public Map<String, Object> saveOrderformQueue(String userId, String czId, String batchId, String orderId)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		ClzClazz clazz = clzClazzWyService.queryById(czId);
		if (clazz == null) {
			result.put("status", "0");
			result.put("msg", "班级不存在!");
			return result;
		}
		String siteId = clazz.getSiteId();
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_SITE, siteId);
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT, clazz.getMchtId());
		ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT_SCHEME, clazz.getMchtSchmId());

		this.updateStudentClazz(userId, czId);// 更新学生班级状态
		clzClazzBatchWyService.updateClazzBatch(batchId);// 更新批次状态
		clzUserClazzCourseWyService.updateUserClazzCourse(userId, czId, siteId);// 更新用户课程状态
		result.put("status", "1");
		result.put("msg", "更新用户报名班级状态成功");
		return result;
	}

	@Transactional
	public boolean saveStudentClazz(CustInfoVo cust, ClzClazz clazz, String siteId, String normal,String userAuth) {
		ClzStudentClazz studentClazz = new ClzStudentClazz();
		studentClazz.setCustId(cust.getCustId());
		studentClazz.setCzId(clazz.getCzId());
		studentClazz = super.queryOne(studentClazz);
		if (studentClazz == null) {
			studentClazz = new ClzStudentClazz();
			studentClazz.setCustId(cust.getCustId());
			studentClazz.setCzId(clazz.getCzId());
			studentClazz.setCustNickname(cust.getCustName());
			studentClazz.setCzCerted(clazz.getCzCerted());
			studentClazz.setExamScore(new BigDecimal(0d));
			studentClazz.setStudylengthFinished("0");
			studentClazz.setMustStudylengthFinished("0");
			studentClazz.setSelStudylengthFinished("0");
			studentClazz.setExamScoreFinished("0");
			studentClazz.setFinished("0");
			studentClazz.setProcess(BigDecimal.valueOf(0d));
			studentClazz.setSingupDate(new Date());
			studentClazz.setCerted("0");
			studentClazz.setSiteId(siteId);
			studentClazz.setNormal(normal);
			studentClazz.setUserAuth(userAuth);
		}
		if ("1".equals(normal)) {// 预防正式的再次报名变成非正式的了
			studentClazz.setNormal(normal);
		}
		super.save(studentClazz);
		return true;
	}

	public boolean updateStudentClazz(String userId, String czId) {
		ClzStudentClazz studentClazz = new ClzStudentClazz();
		studentClazz.setCustId(userId);
		studentClazz.setCzId(czId);
		studentClazz = super.queryOne(studentClazz);
		if (!"1".equals(studentClazz.getNormal())) {
			studentClazz.setNormal("1");
		}
		super.updateBySelect(studentClazz);
		return true;
	}

	public MyPage<ClzStudentClazz> queryShowPage(ClzStudentClazz sc) {
		ClzStudentClazz studentClazz = new ClzStudentClazz();
		studentClazz.setCzId(sc.getCzId());
		studentClazz.setNormal("1");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "singupDate=0");
		MyPage<ClzStudentClazz> page = super.queryPage(studentClazz, params);
		return page;
	}

	public MyPage<ClzStudentClazz> queryUserClazzPage(ClzStudentClazz sc) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "singupDate=0");
		sc.setNormal("1");
		MyPage<ClzStudentClazz> page = super.queryPage(sc, params);
		ClzClazz clazz = null;
		for (ClzStudentClazz studentClazz : page.getList()) {
			clazz = clzClazzWyService.queryById(studentClazz.getCzId());
			studentClazz.setCzName(clazz.getCzName());
		}
		return page;
	}

	public Object importStudent() {
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userId", "82f66b6689fc4a2bacbc3294e06b40c2");
			data.put("certId", "1");
			JSONObject jsonData = new JSONObject();
			CustInfoVo cust = baseInfoDao.queryCustInfo("82f66b6689fc4a2bacbc3294e06b40c2");
			jsonData.put("idcard", "1234");
			jsonData.put("unit", "333333");
			jsonData.put("name", cust.getCustName());
			jsonData.put("mobilePhone", "1338761234");
			jsonData.put("program", "班级");
			jsonData.put("score", 20);
			jsonData.put("phase", DateUtils.formatDate(new Date(), "yyyy"));
			jsonData.put("year", DateUtils.formatDate(new Date(), "yyyy"));
			jsonData.put("month", DateUtils.formatDate(new Date(), "MM"));
			jsonData.put("day", DateUtils.formatDate(new Date(), "dd"));
			data.put("jsonData", jsonData.toJSONString());
			String json = postCert(certUrl + "/cert/usercertoffline/saveUserCert", data);
			logger.debug(json);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 批量添加学员(不加课程)
	 * @param czId 班级id
	 * @param studentIds 学员id数组
	 * @return 新加入学员数量
	 */
	@Transactional
	public int batchAddStudent(String czId, String studentIds[]){
		ClzStudentClazz pp = new ClzStudentClazz();
		pp.setCzId(czId);

		ClzStudentClazz o = new ClzStudentClazz();
		o.setCzId(czId);
		o.setCerted("0");
		o.setNormal("1");
		o.setSingupDate(Calendar.getInstance().getTime());
		int addNum = 0;
		for(String id : studentIds){
			o.setCustId(id);
			pp.setCustId(id);
			// 先判断是否存在
			List<ClzStudentClazz> list = queryList(pp, null);
			if(list.size() > 0){
				continue;
			}

			save(o);
			addNum++;
		}

		// 更新班级人员数量
		clzClazzWyService.updateJoinupNum(czId, addNum);
		return addNum;
	}


	/**
	 * 课程完成时更新学生班级
	 * 
	 * @param custId
	 * @param czId
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean saveFinishStudentClazz(String custId, String czId) {
		logger.debug("开始更新学生班级数据.custId={}|czId={}", custId, czId);
		ClzClazz clazz = clzClazzWyService.queryById(czId);
		ClzStudentClazz studentClazz = new ClzStudentClazz();
		studentClazz.setCustId(custId);
		studentClazz.setCzId(czId);
		studentClazz.setNormal("1");
		studentClazz = super.queryOne(studentClazz);
		if (studentClazz == null)
			return false;
		if ("1".equals(studentClazz.getFinished()))
			return true;
		ClzUserClazzCourse ucc = new ClzUserClazzCourse();
		ucc.setCustId(custId);
		ucc.setCzId(czId);
		ucc.setNormal("1");
		List<ClzUserClazzCourse> uccs = clzUserClazzCourseWyService.queryList(ucc, null);
		if (uccs == null || uccs.size() < 1)
			return false;
		logger.debug("完成的学生班级课程 uccs.size={}", uccs.size());
		double studylength = clazz.getStudylength().doubleValue();
		double mustStudylength = clazz.getMustStudylength().doubleValue();
		double selStudylength = clazz.getSelStudylength().doubleValue();
		double actStudylength = 0d;// 实际学时
		double actMustStudylength = 0d;// 实际学时
		double actSelStudylength = 0d;// 实际学时
		double actExamScore = studentClazz.getExamScore() == null ? 0d : studentClazz.getExamScore().doubleValue();// 实际测验得分
		double examScore = clazz.getExamScore() == null ? 0d : studentClazz.getExamScore().doubleValue();// 班级要求学时
		int csNum = uccs.size();
		int finishedNum = 0;
		for (ClzUserClazzCourse obj : uccs) {
			if ("1".equals(obj.getLcsFinished())) {
				actStudylength += obj.getCsStudylength().doubleValue();
				if (obj.getCsType().intValue() == ClzUserClazzCourse.MUST_COURSE) {
					actMustStudylength += obj.getCsStudylength().doubleValue();
				}
				if (obj.getCsType().intValue() == ClzUserClazzCourse.SEL_COURSE) {
					actSelStudylength += obj.getCsStudylength().doubleValue();
				}
				finishedNum++;
			}
		}
		logger.debug("统计实际学时数据.actStudylength={}|actMustStudylength={}|actSelStudylength={}", actStudylength,
				actMustStudylength, actSelStudylength);
		double p = finishedNum / csNum;
		BigDecimal process = BigDecimal.valueOf(p);
		process.setScale(1, BigDecimal.ROUND_HALF_UP);
		studentClazz.setProcess(process);
		if (actStudylength >= studylength) {
			studentClazz.setStudylengthFinished("1");
		}
		if (actMustStudylength >= mustStudylength) {
			studentClazz.setMustStudylengthFinished("1");
		}
		if (actSelStudylength >= selStudylength) {
			studentClazz.setSelStudylengthFinished("1");
		}
		if (actExamScore >= examScore) {
			studentClazz.setExamScoreFinished("1");
		}
		if ("1".equals(studentClazz.getExamScoreFinished()) && "1".equals(studentClazz.getStudylengthFinished())
				&& "1".equals(studentClazz.getMustStudylengthFinished())
				&& "1".equals(studentClazz.getSelStudylengthFinished())) {// 学员班级完成
			logger.debug("学员班级完成");
			studentClazz.setFinished("1");
			studentClazz.setFinishedDate(new Date());
			studentClazz.setProcess(BigDecimal.valueOf(1d));
			if (StringUtils.isNotEmpty(clazz.getCtId()) && "0".equals(studentClazz.getCerted())) {// 发消息生成证书
				logger.debug("班级完成，达到班级证书要求，调用生成证书接口.userId={}|certID={}", studentClazz.getCustId(), clazz.getCtId());
				/*
				 * CtUserCertVo ctUserCertVo = new CtUserCertVo();
				 * ctUserCertVo.setUcUserId(studentClazz.getCustId());
				 * ctUserCertVo.setCtId(clazz.getCtId());
				 * ctUserCertVo.setUcProgram(clazz.getCzName());
				 * ctUserCertVo.setUcScore(actStudylength + "");
				 * ctUserCertVo.setUcYear(DateUtils.formatDate(new Date(), "yyyy")); CustInfoVo
				 * cust = baseInfoDao.queryCustInfo(custId);
				 * ctUserCertVo.setUcIdcard(cust.getIdcarNo());
				 * ctUserCertVo.setUcUnit(cust.getOffice());
				 * ctUserCertVo.setUcName(cust.getCustName());
				 * ctUserCertVo.setSiteId(studentClazz.getSiteId()); Map<String, Object> certMap
				 * = ctUserCertApiService.saveUserCertApi(ctUserCertVo);
				 * if("0".equals(certMap.get("status").toString())) {
				 * studentClazz.setUcId(certMap.get("ucId").toString()); }
				 */
				try {
					Map<String, String> data = new HashMap<String, String>();
					data.put("userId", studentClazz.getCustId());
					data.put("certId", clazz.getCtId());
					JSONObject jsonData = new JSONObject();
					CustInfoVo cust = baseInfoDao.queryCustInfo(custId);
					jsonData.put("idcard", cust.getIdcarNo());
					jsonData.put("unit", cust.getOffice());
					jsonData.put("name", cust.getCustName());
					jsonData.put("mobilePhone", cust.getPhone());
					jsonData.put("program", clazz.getCzName());
					jsonData.put("score", actStudylength);
					jsonData.put("phase", DateUtils.formatDate(new Date(), "yyyy"));
					jsonData.put("year", DateUtils.formatDate(new Date(), "yyyy"));
					jsonData.put("month", DateUtils.formatDate(new Date(), "MM"));
					jsonData.put("day", DateUtils.formatDate(new Date(), "dd"));
					data.put("jsonData", jsonData.toJSONString());
					String json = postCert(certUrl + "/cert/usercertoffline/saveUserCert", data);
					logger.debug("生成证书返回数据. ");
					JSONObject object = JSONObject.parseObject(json);
					if (object.getInteger("status") == 1) {
						studentClazz.setUcId(object.getString("id"));
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			clzStudentClazzMapper.updateByPrimaryKeySelective(studentClazz);
			return true;
		} else {
			logger.debug("学员班级未完成");
			clzStudentClazzMapper.updateByPrimaryKeySelective(studentClazz);
			return false;
		}
	}

	private String postCert(String url, Map<String, String> map) throws ClientProtocolException, IOException {
		String result = "";
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);

		// 装填参数
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		// 设置参数到请求对象中
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
		// 设置header信息
		// 指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		// 执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// 获取结果实体
		// 判断网络连接状态码是否正常(0--200都数正常)
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result = EntityUtils.toString(response.getEntity(), "utf-8");
		}
		// 释放链接
		response.close();

		return result;
	}

	@Transactional
	public Map<String, Object> saveTestingQueue(String custId, String tsId, double score, Date updateDate)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		ClzClazzTest clazzTest = new ClzClazzTest();
		clazzTest.setTsId(tsId);
		List<ClzClazzTest> clazzTests = clzClazzTestWyService.queryList(clazzTest, null);
		for (ClzClazzTest ct : clazzTests) {
			ClzStudentClazz studentClazz = new ClzStudentClazz();
			studentClazz.setCustId(custId);
			studentClazz.setCzId(ct.getCzId());
			studentClazz.setNormal("1");
			studentClazz = super.queryOne(studentClazz);
			if (studentClazz == null) {
				continue;
			}
			studentClazz.setExamScore(new BigDecimal(score));
			if ("1".equals(studentClazz.getFinished())) {// 已完成的学生班级更新下成绩就行了
				clzStudentClazzMapper.updateByPrimaryKeySelective(studentClazz);
				map.put("status", 1);
				map.put("msg", "处理成功.");
				return map;
			}
			ClzClazz clazz = clzClazzWyService.queryById(ct.getCzId());
			double examScore = clazz.getExamScore() == null ? 0d : clazz.getExamScore().doubleValue();
			if (!"1".equals(studentClazz.getExamScore()) && score >= examScore) {
				studentClazz.setExamScoreFinished("1");
				if ("1".equals(studentClazz.getExamScoreFinished()) && "1".equals(studentClazz.getStudylengthFinished())
						&& "1".equals(studentClazz.getMustStudylengthFinished())
						&& "1".equals(studentClazz.getSelStudylengthFinished())) {// 学员班级完成
					logger.debug("学员班级完成");
					studentClazz.setFinished("1");
					studentClazz.setFinishedDate(new Date());
					studentClazz.setProcess(BigDecimal.valueOf(1d));
					clzStudentClazzMapper.updateByPrimaryKeySelective(studentClazz);
					if (StringUtils.isNotEmpty(clazz.getCtId()) && "0".equals(studentClazz.getCerted())) {// 发消息生成证书
						double actStudylength = clzUserClazzCourseWyService.sumStudylength(custId,
								studentClazz.getCzId());
						logger.debug("班级完成，达到班级证书要求，调用生成证书接口");
						CtUserCertVo ctUserCertVo = new CtUserCertVo();
						ctUserCertVo.setUcUserId(studentClazz.getCustId());
						ctUserCertVo.setCtId(clazz.getCtId());
						ctUserCertVo.setUcProgram(clazz.getCzName());
						ctUserCertVo.setUcScore(actStudylength + "");
						ctUserCertVo.setUcYear(DateUtils.formatDate(new Date(), "yyyy"));
						CustInfoVo cust = baseInfoDao.queryCustInfo(studentClazz.getCustId());
						ctUserCertVo.setUcIdcard(cust.getIdcarNo());
						ctUserCertVo.setUcUnit(cust.getOffice());
						ctUserCertVo.setUcName(cust.getCustName());
						ctUserCertVo.setSiteId(studentClazz.getSiteId());
						ctUserCertApiService.saveUserCertApi(ctUserCertVo);
					}
				} else {
					clzStudentClazzMapper.updateByPrimaryKeySelective(studentClazz);
				}
			}
		}
		map.put("status", 1);
		map.put("msg", "处理成功.");
		return map;
	}

	public Map<String,Object> GetUserAuth(IBusinessContext ctx){
        List<ClzStudentClazz> clazzs= super.queryList(null,ctx.getParamMap());
        if(clazzs.size()>0){
          String auth=  (clazzs.get(0)).getUserAuth();
            return MapUtil.newMap("userAuth",auth);
        }else {
            return MapUtil.newMap("msg","此用户没有加入该班级");
        }
    }

	@Override
	protected Weekend<ClzStudentClazz> genSqlExample(ClzStudentClazz t, Map params) {
		Weekend<ClzStudentClazz> w = super.genSqlExample(t, params);
		WeekendCriteria<ClzStudentClazz, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCzId())) {
			if (t.getCzId().contains(",")) {
				c.andIn(ClzStudentClazz::getCzId, Arrays.asList(t.getCzId().split(",")));
			} else {
				c.andEqualTo(ClzStudentClazz::getCzId, t.getCzId());
			}
		}
		if (StringUtils.isNotBlank(t.getCustId())) {
			c.andEqualTo(ClzStudentClazz::getCustId, t.getCustId());
		}
		if (StringUtils.isNotBlank(t.getCerted())) {
			c.andEqualTo(ClzStudentClazz::getCerted, t.getCerted());
		}
		if (StringUtils.isNotBlank(t.getNormal())) {
			c.andEqualTo(ClzStudentClazz::getNormal, t.getNormal());
		}
		if (StringUtils.isNotBlank(t.getFinished())) {
			c.andEqualTo(ClzStudentClazz::getFinished, t.getFinished());
		}
		if (StringUtils.isNotBlank(t.getCzCerted())) {
			c.andEqualTo(ClzStudentClazz::getCzCerted, t.getCzCerted());
		}
		w.and(c);
		return w;
	}

}
