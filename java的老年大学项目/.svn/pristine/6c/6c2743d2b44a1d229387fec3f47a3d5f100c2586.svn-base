package com.drcl.traincore.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.common.lib.springside.orm.ExtPropertyFilter;

/**
 * @author sli create date 2015-1-14 上午11:39:20
 */
public class PropertyFilterUtil {

	/**
	 * @author hli
	 * @param className
	 *            ：查询的model名称
	 * @param filters
	 *            ：过滤条件
	 * @return
	 */
	public static String appendFilter(String QHL, List<ExtPropertyFilter> filters) {
		StringBuffer hql = new StringBuffer();
		hql.append(QHL);
		for (ExtPropertyFilter e : filters) {
			if (e.getExtMatchType().name().equals(ExtPropertyFilter.MatchType.LIKE.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " like '%" + e.getMatchValue() + "%'");
				} else {
					hql.append(" and " + e.getPropertyName() + " like '%" + e.getMatchValue() + "%'");
				}
			}
			if (e.getExtMatchType().name().equals(ExtPropertyFilter.ExtMatchType.EQ.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " = " + e.getMatchValue());
				} else {
					hql.append(" and " + e.getPropertyName() + " = " + e.getMatchValue());
				}
			}
			if (e.getExtMatchType().name().equals(ExtPropertyFilter.ExtMatchType.GE.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " >= " + e.getMatchValue());
				} else {
					hql.append(" and " + e.getPropertyName() + " >= " + e.getMatchValue());
				}
			}

			if (e.getExtMatchType().name().equals(ExtPropertyFilter.ExtMatchType.GT.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " > " + e.getMatchValue());
				} else {
					hql.append(" and " + e.getPropertyName() + " > " + e.getMatchValue());
				}
			}

			if (e.getExtMatchType().name().equals(ExtPropertyFilter.ExtMatchType.LE.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " <= " + e.getMatchValue());
				} else {
					hql.append(" and " + e.getPropertyName() + " <= " + e.getMatchValue());
				}
			}

			if (e.getExtMatchType().name().equals(ExtPropertyFilter.ExtMatchType.LT.toString())) {
				if (StringUtils.isNotBlank(e.getJoinPropertyName())) {
					hql.append(" and " + e.getJoinPropertyName() + "." + e.getPropertyName() + " < " + e.getMatchValue());
				} else {
					hql.append(" and " + e.getPropertyName() + " < " + e.getMatchValue());
				}
			}
		}
		return hql.toString();
	}
}
