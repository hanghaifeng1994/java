package com.learnyeai.resource.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.resource.mapper.StdCustLearnRecordMapper;
import com.learnyeai.resource.model.StdCustLearnRecord;

/**
 *
 * @author twang
 */
@Service
public class StdCustLearnRecordCatchService extends WeyeBaseService<StdCustLearnRecord> {

	@Resource
	private StdCustLearnRecordMapper stdCustLearnRecordMapper;

	@Override
	public BaseMapper<StdCustLearnRecord> getMapper() {
		return stdCustLearnRecordMapper;
	}

	@Value("${learnrecord.expiredTime}")
	private long expiredTime;

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Cacheable(cacheNames = "resource_resourceLearnRecord", key = "#key")
	public StdCustLearnRecord queryRecord(String key) {
		String[] keys = key.split("_");
		if (keys.length < 2)
			return null;
		StdCustLearnRecord learnRecord = new StdCustLearnRecord();
		learnRecord.setStudyUserId(keys[0]);
		learnRecord.setResId(keys[1]);
		Map<String, String> params = Maps.newHashMap();
		params.put("sorts", "startDate=0");
		List<StdCustLearnRecord> list = super.queryList(learnRecord, params);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@CachePut(value = "resource_resourceLearnRecord", key = "#key")
	public StdCustLearnRecord saveRecord(String key, StdCustLearnRecord learnRecord) {
		return learnRecord;
	}

	@CacheEvict(value = "resource_resourceLearnRecord", key = "#key")
	public void removeRecord(String key) {
	}

}
