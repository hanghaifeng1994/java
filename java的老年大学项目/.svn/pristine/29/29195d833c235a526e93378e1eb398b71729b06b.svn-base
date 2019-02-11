package com.learnyeai.homework.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.homework.mapper.WkHomeworkMapper;
import com.learnyeai.homework.model.WkHomework;
import com.learnyeai.homework.model.WkHomeworkAttachment;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class WkHomeworkWyService extends WeyeBaseService<WkHomework> {

	@Resource
	private WkHomeworkMapper wkHomeworkMapper;
	@Resource
	private WkHomeworkAttachmentWyService wkHomeworkAttachmentWyService;

	@Override
	public BaseMapper<WkHomework> getMapper() {
		return wkHomeworkMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(WkHomework wh, String fileIds, String fileNames) {
		Map<String, Object> map = new HashMap();
		boolean isNew = false;
		if (StringUtils.isBlank(wh.getHwId())) {
			wh.setDelFlag("0");
			wh.setHwStatus("0");
			wh.setHwSubmitNum(0l);
			isNew = true;
		}
		super.save(wh);
		/**
		 * 保存到缓存
		 */
		wh = wkHomeworkMapper.selectByPrimaryKey(wh.getHwId());
		RedisUtil redis = RedisUtilFactory.getUtil("homework_homeworkDetail", WkHomework.class);
		redis.set(wh.getHwId(), wh);

		if (isNew&&StringUtils.isNotBlank(fileIds)) {// 有作业附件的话保存任务附件
			WkHomeworkAttachment atm = null;
			String[] fNames = fileNames.split(",");
			int i = 0;
			for (String fileId : fileIds.split(",")) {
				atm = new WkHomeworkAttachment();
				atm.setFileId(fileId);
				atm.setFileName(fNames[i++]);
				atm.setObjId(wh.getHwId());
				atm.setType(WkHomeworkAttachment.TYPE_HW);
				atm.setUploadTime(new Date());
				atm.setDelFlag("0");
				wkHomeworkAttachmentWyService.save(atm);
			}
		}

		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", wh.getHwId());
		return map;
	}

	@Transactional
	public Map<String, Object> deleteHw(WkHomework wh) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String hwId : wh.getHwId().split(",")) {
			WkHomework delOne = new WkHomework();
			delOne.setHwId(hwId);
			delOne.setDelFlag("1");
			int c = wkHomeworkMapper.updateByPrimaryKeySelective(delOne);
			if (c > 0)
				num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Transactional
	public Map<String, Object> publish(WkHomework wh) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String hwId : wh.getHwId().split(",")) {
			WkHomework delOne = super.queryById(hwId);
			if (delOne != null) {
				delOne.setHwStatus(wh.getHwStatus());
				super.save(delOne);
				num++;
			}
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	public Object detail(String hwIds) {
		List<WkHomework> list = Lists.newArrayList();
		for (String hwId : hwIds.split(",")) {
			WkHomework resResource = wkHomeworkMapper.selectByPrimaryKey(hwId);
			if (resResource == null)
				continue;
			// 作业附件
			List<WkHomeworkAttachment> homeworkAttachments = wkHomeworkAttachmentWyService.queryHomeworkAttachment(hwId,
					WkHomeworkAttachment.TYPE_HW);
			resResource.setHomeworkAttachments(homeworkAttachments);
			list.add(resResource);
		}
		return list;
	}

	public Object homeworkDetail(String hwId) {
		WkHomework resResource = wkHomeworkMapper.selectByPrimaryKey(hwId);
		// 作业附件
		List<WkHomeworkAttachment> homeworkAttachments = wkHomeworkAttachmentWyService.queryHomeworkAttachment(hwId,
				WkHomeworkAttachment.TYPE_HW);
		resResource.setHomeworkAttachments(homeworkAttachments);
		return resResource;
	}

	@Cacheable(cacheNames = "homework_homeworkDetail", key = "#hwId")
	public WkHomework get(String hwId) {
		WkHomework homework = getMapper().selectByPrimaryKey(hwId);
		return homework;
	}

	@Transactional
	public MyPage<WkHomework> queryManagePage(WkHomework wh) {
		if (wh != null && wh.getPage() != null && wh.getRows() != null) {
			PageHelper.startPage(wh.getPage(), wh.getRows());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "createDate=0");
		MyPage<WkHomework> page = super.queryPage(wh, null);
		return page;
	}

	@Override
	protected Weekend<WkHomework> genSqlExample(WkHomework t, Map params) {
		Weekend<WkHomework> w = super.genSqlExample(t, params);
		WeekendCriteria<WkHomework, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getHwStatus())) {
			c.andEqualTo(WkHomework::getHwStatus, t.getHwStatus());
		}
		if (StringUtils.isNotBlank(t.getHwTitle())) {
			c.andLike(WkHomework::getHwTitle, "%" + t.getHwTitle() + "%");
		}
		if (StringUtils.isNotBlank(t.getSiteId())) {
			c.andIn(WkHomework::getSiteId, Arrays.asList(t.getSiteId().split(",")));
		}
		if (t.getSiteIds() != null) {
			c.andIn(WkHomework::getSiteId, t.getSiteIds());
		}
		w.and(c);
		return w;
	}
}
