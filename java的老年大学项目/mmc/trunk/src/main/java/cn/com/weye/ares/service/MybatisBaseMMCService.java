package cn.com.weye.ares.service;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zpz on 2017/12/1.
 */
public abstract class MybatisBaseMMCService<E> extends MybatisBaseService<E> {
    @Override
    protected final DBQuery genSqlQuery(E params) {
        DBQuery q = super.genSqlQuery(params);
        return genSqlQuery(params, WebUtils.getRequest(), q);
    }
    protected DBQuery genSqlQuery(E entity, HttpServletRequest request, DBQuery query) {
        return query;
    }
}
