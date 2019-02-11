package com.learnyeai.resource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
import com.learnyeai.resource.model.ResCategory;

/**
 * @Description: 资源分类
 * @author twang
 */
@MyBatisDao
public interface ResCategoryMapper extends BaseMapper<ResCategory> {

	List<ResCategory> queryManagePage(ResCategory rc);

	List<ResCategory> queryShowPage(ResCategory rc);

	public int countByParent(@Param("siteId") String siteId, @Param("parentId") String parentId);

}
