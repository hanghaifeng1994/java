package com.learnyeai.course.mapper;

import java.util.List;

import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

/**
 * @Description: 课程
 * @author twang
 */
@MyBatisDao
public interface CrsCourseMapper extends BaseMapper<CrsCourse> {
	List<CrsCourse> queryManagePage(CrsCourse cs);

	List<CrsCourse> queryShowPage(CrsCourse cs);

	List<CrsCourse> queryMainPage(CrsCourse cs);
	
	
}
