package com.learnyeai.learnai.mybatis.impl;

import com.learnyeai.learnai.mybatis.DBQuery;
import com.learnyeai.learnai.mybatis.utils.SqlTokenizer;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * SQL查询实现类
 * @author 李超（lc3@yitong.com.cn）
 */
public class SimpleSqlQuery implements DBQuery {

    private boolean distinct;
    private String selectClause;
    private String fromClause;
    private String[] whereSqls;
    private Object[] whereValues;
    private String whereEndSql;
    private String orderByClause;

    public SimpleSqlQuery(String sql) {
        this(sql, null);
    }


    public SimpleSqlQuery(String sql, Object[] values) {
        if(null != values && (values.length == 1 && null == values[0] ||
                values.length == 0)) {
            // 对于只有一个空值的参数将忽略
            values = null;
        }
        this.whereValues = values;

        if(null == sql) {
            sql = "";
        } else {
            sql = sql.trim();
        }

        SqlTokenizer st = new SqlTokenizer(sql);
        String keyword = st.nextClauseKeyword();
        String whereSql = sql.substring(0, st.getPrevOffset());
        while(null != keyword) {
            keyword = keyword.toLowerCase();
            int offset = st.getOffset();
            String nextKeyword = st.nextClauseKeyword();
            String clause = sql.substring(offset, st.getPrevOffset()).trim();
            if("select".equals(keyword)) {
                selectClause = clause;
                if(clause.toLowerCase().contains("distinct")) {
                    distinct = true;
                }
            } else if("from".equals(keyword)) {
                fromClause = clause;
            } else if("where".equals(keyword)) {
                whereSql = clause;
            } else if("order".equals(keyword)) {
                if(clause.length() > 3) {   // 去掉"order by"中的"by"
                    orderByClause = clause.replaceFirst("^\\s*[Bb][Yy]", "").trim();
                }
            }
            keyword = nextKeyword;
        }

        this.whereSqls = whereSql.split("\\?");
        if(null == values) {    // 为null时不检验参数个数
            this.whereEndSql = "";
        } else if(this.whereSqls.length == values.length) {
            this.whereEndSql = "";
        } else {
            Assert.isTrue(this.whereSqls.length - 1 == values.length, "SQL和参数不一致");
            this.whereEndSql = whereSqls[whereSqls.length - 1];
        }
    }

    @Override
    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public String[] getWhereSqls() {
        return whereSqls;
    }

    @Override
    public Object[] getWhereValues() {
        return whereValues;
    }

    @Override
    public String getWhereEndSql() {
        return whereEndSql;
    }

    @Override
    public String getOrderByClause() {
        return orderByClause;
    }

    @Override
    public String getSelectClause() {
        return selectClause;
    }

    @Override
    public String getFromClause() {
        return fromClause;
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
