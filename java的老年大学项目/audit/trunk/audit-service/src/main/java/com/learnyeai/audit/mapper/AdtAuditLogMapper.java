package com.learnyeai.audit.mapper;

import com.learnyeai.audit.model.AdtAuditLog;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.Map;

/**
 * @Description: 审核日志
 * @author yl
 */
@MyBatisDao
public interface AdtAuditLogMapper extends BaseMapper<AdtAuditLog> {
    String queryPageByIds(Map<String, Object> map);
}
