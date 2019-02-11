package com.learnyeai.schoolclass.mapper;

import com.learnyeai.schoolclass.model.ClzUserClazzCourse;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 学员-班级-课程
 * @author twang
 */
@MyBatisDao
public interface ClzUserClazzCourseMapper extends BaseMapper<ClzUserClazzCourse> {
	/**
	 * 用户班级的完成总学时
	 * @param custId
	 * @param czId
	 * @return
	 */
	public Double sumStudylength(String custId, String czId);
}
