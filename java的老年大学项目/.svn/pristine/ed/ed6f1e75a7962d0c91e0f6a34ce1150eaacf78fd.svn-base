package com.learnyeai.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.learnyeai.course.model.CrsCatalog;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 课程分类
 * @author twang
 */
@MyBatisDao
public interface CrsCatalogMapper extends BaseMapper<CrsCatalog> {
	
	List<CrsCatalog> queryManagePage(CrsCatalog cc);

	List<CrsCatalog> queryShowPage(CrsCatalog cc);
	
	public int countByParent(@Param("siteId") String siteId, @Param("parentId") String parentId);
}
