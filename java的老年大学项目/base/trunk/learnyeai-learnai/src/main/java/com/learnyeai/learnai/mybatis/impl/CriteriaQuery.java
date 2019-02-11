package com.learnyeai.learnai.mybatis.impl;

import com.learnyeai.learnai.mybatis.DBQuery;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis 通用查询类，非多线程安全
 *
 * @author wenin819@gmail.com
 */
public class CriteriaQuery implements DBQuery {

    /**
     * 排序条件
     */
    protected StringBuilder orderByClause;
    /**
     * 是否去重复
     */
    protected boolean distinct;
    /**
     * 查询条件
     */
    protected Criteria criteria;
    /**
     * 生成的查询条件片断
     */
    private List<String> sqlList = null;
    /**
     * 生成的查询条件对应的值
     */
    private List<Object> valueList = null;
    /**
     * 生成的查询条件结尾SQL
     */
    private StringBuilder postSql = null;


    /**
     * 选择条件
     */
    private StringBuilder selectClause;
    /**
     * 表条件
     */
    private StringBuilder fromClause;


    public CriteriaQuery() {
        this.criteria = Criteria.newAndCriteria(this);
    }

    /**
     * 获取当前Order By查询条件
     * @return
     */
    public String getOrderByClause() {
        return null == orderByClause ? null : orderByClause.toString();
    }

    /**
     * 增加选择条件
     * @param filedName
     * @return
     */
    public CriteriaQuery addSelect(String filedName) {
        if (null == selectClause) {
            selectClause = new StringBuilder(filedName);
        } else {
            selectClause.append(", ");
            selectClause.append(filedName);
        }
        return this;
    }

    /**
     * 设置选择条件
     * @param filedNames 选择条件
     * @return
     */
    public CriteriaQuery setSelects(String... filedNames) {
        selectClause = null;
        if(null == filedNames || filedNames.length == 0) {
            return this;
        }
        for (String filedName : filedNames) {
            addSelect(filedName);
        }
        return this;
    }

    /**
     * 增加表条件
     * @param tableName
     * @return
     */
    public CriteriaQuery addFrom(String tableName) {
        if (null == fromClause) {
            fromClause = new StringBuilder(tableName);
        } else {
            fromClause.append(", ");
            fromClause.append(tableName);
        }
        return this;
    }

    /**
     * 设置表条件
     * @param tableNames 表条件
     * @return
     */
    public CriteriaQuery setFroms(String... tableNames) {
        fromClause = null;
        if(null == tableNames || tableNames.length == 0) {
            return this;
        }
        for (String tableName : tableNames) {
            addFrom(tableName);
        }
        return this;
    }

    /**
     * 增加排序
     * @param filedName 字段名
     * @param isAsc 是否正序
     * @return
     */
    public CriteriaQuery addOrder(String filedName, boolean isAsc) {
        if (null == orderByClause) {
            orderByClause = new StringBuilder(filedName);
        } else {
            orderByClause.append(", ");
            orderByClause.append(filedName);
        }
        orderByClause.append(isAsc ? " ASC" : " DESC");
        return this;
    }

    /**
     * 设置排序条件
     * @param filedNames 字段集合
     * @param isAscs 排序类型集合
     * @return
     */
    public CriteriaQuery setOrders(String[] filedNames, boolean[] isAscs) {
        orderByClause = null;
        if(null == filedNames || filedNames.length == 0) {
            return this;
        }
        Assert.isTrue(null != isAscs && isAscs.length == filedNames.length, "filedNames与isAscs传参不一致");
        for (int i = 0; i < filedNames.length; i++) {
            addOrder(filedNames[i], isAscs[i]);
        }
        return this;
    }

    /**
     * 对结果是否相同值合并处理
     * @return
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 设置是否对结果相同值合并处理
     * @param distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 创建And子查询条件
     * @return
     */
    public Criteria createAndCriteria() {
        return criteria.createAndCriteria();
    }

    /**
     * 创建Or子查询条件
     * @return
     */
    public Criteria createOrCriteria() {
        return criteria.createOrCriteria();
    }

    /**
     * 清空查询条件
     */
    public void clear() {
        criteria = Criteria.newAndCriteria(this);
    }

    /**
     * 更改通知方法，方便子查询条件更改后告知当前查询条件，方便进行重新自动拼装Sql
     */
    public void notifyChange() {
        postSql = null;
        sqlList = null;
        valueList = null;
    }

    /**
     * 进行查询Sql和值的拼装
     */
    protected void buildSql() {
        postSql = new StringBuilder();
        sqlList = new ArrayList<String>();
        valueList = new ArrayList<Object>();
        criteria.genSql(null, sqlList, valueList, postSql);
    }

    @Override
    public String getSelectClause() {
        return null == selectClause ? null : selectClause.toString();
    }

    @Override
    public String getFromClause() {
        return null == fromClause ? null : fromClause.toString();
    }

    @Override
    public String[] getWhereSqls() {
        if (null == sqlList) {
            buildSql();
        }
        return sqlList.toArray(new String[sqlList.size()]);
    }

    @Override
    public Object[] getWhereValues() {
        if (null == valueList) {
            buildSql();
        }
        return valueList.toArray();
    }

    @Override
    public String getWhereEndSql() {
        if (null == postSql) {
            buildSql();
        }
        return postSql.toString();
    }

    /**
     * 得到Where查询条件的Sql，变量用问题占位
     * @return
     */
    public String getWhereSql() {
        return StringUtils.arrayToDelimitedString(getWhereSqls(), "?") +
                (null != getWhereValues() && getWhereValues().length == getWhereSqls().length ? "?" : "")
                + getWhereEndSql();
    }
}
