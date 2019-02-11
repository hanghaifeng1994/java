package com.learnyeai.homework.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.homework.mapper.WkHomeworkAttachmentMapper;
import com.learnyeai.homework.model.WkHomeworkAttachment;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class WkHomeworkAttachmentWyService extends WeyeBaseService<WkHomeworkAttachment> {

	@Resource
	private WkHomeworkAttachmentMapper wkHomeworkAttachmentMapper;

	@Override
	public BaseMapper<WkHomeworkAttachment> getMapper() {
		return wkHomeworkAttachmentMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return true;
	}

	public List<WkHomeworkAttachment> queryHomeworkAttachment(String objId, String type) {
		WkHomeworkAttachment obj = new WkHomeworkAttachment();
		obj.setObjId(objId);
		obj.setType(type);
		obj.setDelFlag("0");
		return super.queryList(obj, null);
	}

	@Transactional
	public Map<String, Object> saveOrUpdate(WkHomeworkAttachment atm) {
		Map<String, Object> map = new HashMap();
		if (StringUtils.isBlank(atm.getAtmId())) {
			atm.setDelFlag("0");
		}
		atm.setUploadTime(new Date());
		super.save(atm);
		map.put("status", 0);
		map.put("msg", "保存成功!");
		map.put("id", atm.getAtmId());
		return map;
	}

	@Transactional
	public Map<String, Object> deleteAtm(WkHomeworkAttachment atm) {
		Map<String, Object> result = new HashMap();
		int num = 0;
		for (String atmId : atm.getAtmId().split(",")) {
			WkHomeworkAttachment delOne = new WkHomeworkAttachment();
			delOne.setAtmId(atmId);
			delOne.setDelFlag("1");
			int c = wkHomeworkAttachmentMapper.updateByPrimaryKeySelective(delOne);
			if(c>0) num++;
		}
		result.put("status", "0");
		result.put("num", num);
		return result;
	}

	@Override
	protected Weekend<WkHomeworkAttachment> genSqlExample(WkHomeworkAttachment t, Map params) {
		Weekend<WkHomeworkAttachment> w = super.genSqlExample(t, params);
		WeekendCriteria<WkHomeworkAttachment, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getObjId())) {
			c.andEqualTo(WkHomeworkAttachment::getObjId, t.getObjId());
		}
		if (StringUtils.isNotBlank(t.getType())) {
			c.andEqualTo(WkHomeworkAttachment::getType, t.getType());
		}
		w.and(c);
		w.setOrderByClause("UPLOAD_TIME asc");
		return w;
	}
}
