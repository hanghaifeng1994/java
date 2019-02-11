package com.learnyeai.resource.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.resource.mapper.StdCustLearnResourceMapper;
import com.learnyeai.resource.model.ResResource;
import com.learnyeai.resource.model.StdCustLearnResource;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class StdCustLearnResourceWyService extends WeyeBaseService<StdCustLearnResource> {

	@Resource
	private StdCustLearnResourceMapper stdCustLearnResourceMapper;

	@Resource
	private StdCustLearnResourceCatchService stdCustLearnResourceCatchService;

	@Resource
	private StdConfigWyService stdConfigWyService;

	@Resource
	private ResResourceWyService resResourceWyService;

	@Autowired
	private RabbitSender rabbitSender;

	@Override
	public BaseMapper<StdCustLearnResource> getMapper() {
		return stdCustLearnResourceMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	/**
	 * 从缓存查询，没有新增
	 * 
	 * @param userId
	 * @param resId
	 * @return
	 */
	public StdCustLearnResource queryUserResource(String userId, String resId) {
		String key = userId + "_" + resId;
		StdCustLearnResource obj = stdCustLearnResourceCatchService.queryUserResource(key);
		if (obj == null) {
			obj = new StdCustLearnResource();
			obj.setCreateDate(new Date());
			obj.setStudyUserId(userId);
			obj.setResId(resId);
			obj.setStudyTime(0l);
			obj.setStudyNum(0l);
			obj.setStudyBreakpoint(0l);
			obj.setStudyFinished("0");
			super.save(obj);
		}
		return obj;
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(StdCustLearnResource learnResource) {
		Map<String, Object> map = new HashMap();
		for (String resId : learnResource.getResId().split(",")) {
			StdCustLearnResource obj = new StdCustLearnResource();
			obj.setStudyUserId(learnResource.getStudyUserId());
			obj.setResId(resId);
			obj = super.queryOne(obj);
			if (obj == null) {
				obj = new StdCustLearnResource();
				obj.setCreateDate(new Date());
				obj.setStudyUserId(learnResource.getStudyUserId());
				obj.setResId(resId);
				obj.setSource(learnResource.getSource());
				obj.setStudyTime(0l);
				obj.setStudyNum(0l);
				obj.setStudyBreakpoint(0l);
				obj.setStudyFinished("0");
				super.save(obj);
			}
		}
		map.put("status", 0);
		map.put("msg", "保存成功!");
		return map;
	}

	public MyPage<StdCustLearnResource> queryResourcePage(StdCustLearnResource learnResource, String orderType,
			String resinfo) {
		if (learnResource != null && learnResource.getPage() != null && learnResource.getRows() != null) {
			PageHelper.startPage(learnResource.getPage(), learnResource.getRows());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		String sorts = "studyFinished=1";
		if ("0".equals(orderType)) {
			sorts = "studyFinished=1";
		} else if ("1".equals(orderType)) {
			sorts = "updateDate=0";
		} else if ("2".equals(orderType)) {
			sorts = "createDate=1";
		} else if ("3".equals(orderType)) {
			sorts = "createDate=0";
		}
		params.put("sorts", sorts);
		MyPage<StdCustLearnResource> page = super.queryPage(learnResource, params);
		if (StringUtils.isNotBlank(resinfo) && "1".equals(resinfo)) {// 需要课程信息 n+1
			for (StdCustLearnResource obj : page.getList()) {
				ResResource resource = resResourceWyService.get(obj.getResId());
				obj.setResName(resource.getResName());
			}
		}
		return page;
	}

	public List<StdCustLearnResource> queryResources(StdCustLearnResource learnResource, String orderType,
			String resinfo) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sorts = "studyFinished=1";
		if ("0".equals(orderType)) {
			sorts = "studyFinished=1";
		} else if ("1".equals(orderType)) {
			sorts = "updateDate=0";
		} else if ("2".equals(orderType)) {
			sorts = "createDate=1";
		} else if ("3".equals(orderType)) {
			sorts = "createDate=0";
		}
		params.put("sorts", sorts);
		List<StdCustLearnResource> list = super.queryList(learnResource, params);
		if (StringUtils.isNotBlank(resinfo) && "1".equals(resinfo)) {// 需要课程信息 n+1
			for (StdCustLearnResource obj : list) {
				ResResource resource = resResourceWyService.get(obj.getResId());
				obj.setResName(resource.getResName());
			}
		}
		return list;
	}

	public MyPage<StdCustLearnResource> queryUserPage(StdCustLearnResource learnResource) {
		Map<String, String> params = Maps.newHashMap();
		params.put("sorts", "updateDate=0");
		MyPage<StdCustLearnResource> page = super.queryPage(learnResource, params);
		return page;
	}

	/**
	 * 给接口调用的
	 * 
	 * @param userIds
	 * @param resIds
	 * @param source
	 * @return
	 */
	@Transactional
	public boolean saveUserResourceApi(String userIds, String resIds, String siteId, int source) {
		Map<String, Object> map = new HashMap();
		for (String userId : userIds.split(",")) {
			for (String resId : resIds.split(",")) {
				StdCustLearnResource obj = new StdCustLearnResource();
				obj.setStudyUserId(userId);
				obj.setResId(resId);
				obj = super.queryOne(obj);
				if (obj == null) {
					obj = new StdCustLearnResource();
					obj.setCreateDate(new Date());
					obj.setStudyUserId(userId);
					obj.setResId(resId);
					obj.setSource(source);
					obj.setStudyTime(0l);
					obj.setStudyNum(0l);
					obj.setStudyBreakpoint(0l);
					obj.setStudyFinished("0");
					obj.setSiteId(siteId);
					super.save(obj);
				}
			}
		}
		return true;
	}

	/**
	 * 供接口调用，查缓存
	 * 
	 * @param userId
	 * @param resIds
	 * @return
	 */
	public List<StdCustLearnResource> queryUserResourcesApi(String userId, String resIds) {
		List<StdCustLearnResource> list = new ArrayList<StdCustLearnResource>();
		StdCustLearnResource obj = null;
		for (String resId : resIds.split(",")) {
			String key = userId + "_" + resId;
			obj = stdCustLearnResourceCatchService.queryUserResource(key);
			list.add(obj);
		}
		return list;
	}

	/**
	 * 接口里面加缓存了，不用再走缓存 n+1查询
	 * @param userId
	 * @param resId
	 * @return
	 */
	public StdCustLearnResource queryUserResourceApi(String userId, String resId) {
		StdCustLearnResource learnResource = new StdCustLearnResource();
		learnResource.setStudyUserId(userId);
		learnResource.setResId(resId);
		learnResource = super.queryOne(learnResource);
		return learnResource;
	}

	@Override
	protected Weekend<StdCustLearnResource> genSqlExample(StdCustLearnResource t, Map params) {
		Weekend<StdCustLearnResource> w = super.genSqlExample(t, params);
		WeekendCriteria<StdCustLearnResource, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getStudyUserId())) {
			c.andEqualTo(StdCustLearnResource::getStudyUserId, t.getStudyUserId());
		}
		if (StringUtils.isNotBlank(t.getResId())) {
			if (t.getResId().contains(",")) {
				c.andIn(StdCustLearnResource::getResId, Arrays.asList(t.getResId().split(",")));
			} else {
				c.andEqualTo(StdCustLearnResource::getResId, t.getResId());
			}
		}
		w.and(c);
		return w;
	}

	/*
	 * public void synRedisToDb() throws WeyeRabbitException { long time =
	 * expiredTime * 60 * 1000;// 超时时间 int success = 0, error = 0;
	 * System.out.println("synRedisToDb=>开始将用户资源学习时间从缓存同步到数据库"); RedisUtil redis =
	 * RedisUtilFactory.getUtil("resourceLearn", StdCustLearnResource.class);
	 * List<StdCustLearnResource> list = redis.getAll(); StdConfig config =
	 * stdConfigWyService.queryByItem("resourceCallbackTime"); Date lastUpdateTime =
	 * DateHelper.parseDate(config.getCgValue(), "yyyyMMddHHmmssSSS"); Date maxTime
	 * = lastUpdateTime; for (StdCustLearnResource obj : list) { if
	 * (obj.getUpdateDate().getTime() <= lastUpdateTime.getTime()) continue; if
	 * (obj.getUpdateDate().getTime() > maxTime.getTime()) { maxTime =
	 * obj.getUpdateDate(); } String key = obj.getStudyUserId() + "_" +
	 * obj.getResId(); int result = super.updateBySelect(obj); if (result == 0) {
	 * System.out.println("synRedisToDb=>保存到数据库错误|id=" + key); error++; continue; }
	 * // 发送消息到消息队列，去统计课程总的学习时间 ResourceMq mq = new ResourceMq(obj.getStudyUserId(),
	 * obj.getResId(), obj.getStudyTime(), obj.getUpdateDate()); RabbitMetaMessage
	 * msg = ResourceUtil.toParseRabbitMetaMessage(mq); rabbitSender.send(msg);
	 * 
	 * // 超时不再学习，清除缓存 为了不每次都查询 if (new Date().getTime() -
	 * obj.getUpdateDate().getTime() > time) {
	 * System.out.println("synRedisToDb=>超时不再学习，清除缓存|id=" + key);
	 * stdCustLearnResourceCatchService.removeUserResource(key); } success++; }
	 * config.setCgValue(DateFormatUtils.format(maxTime, "yyyyMMddHHmmssSSS"));
	 * stdConfigWyService.save(config);
	 * System.out.println("synRedisToDb=>结束将用户资源学习时间从缓存同步到数据库，同步成功数量=" + success +
	 * "|失败数量=" + error); }
	 */
}
