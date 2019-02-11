package com.learnyeai.homework.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.homework.mapper.WkHomeworkMarkHistoryMapper;
import com.learnyeai.homework.model.WkHomeworkMarkHistory;
import com.learnyeai.learnai.support.BaseMapper;

/**
 *
 * @author twang
 */
@Service
public class WkHomeworkMarkHistoryWyService extends WeyeBaseService<WkHomeworkMarkHistory> {

    @Resource
    private WkHomeworkMarkHistoryMapper wkHomeworkMarkHistoryMapper;

    @Override
    public BaseMapper<WkHomeworkMarkHistory> getMapper() {
        return wkHomeworkMarkHistoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
	public WkHomeworkMarkHistory queryLastUnPublish(String uhId) {
    	WkHomeworkMarkHistory mh = new WkHomeworkMarkHistory();
    	mh.setUhScoreStatus("0");
    	mh.setUhId(uhId);
    	mh = super.queryOne(mh);
    	return mh;
    }
}
