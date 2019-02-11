package com.learnyeai.resource.mapper;

import java.util.List;

import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
import com.learnyeai.resource.model.StdCustLearnResource;

/**
 * @Description: 客户学习资源
 * @author yl
 */
@MyBatisDao
public interface StdCustLearnResourceMapper extends BaseMapper<StdCustLearnResource> {
	public List<StdCustLearnResource> queryResourcePage(StdCustLearnResource lr);

}
