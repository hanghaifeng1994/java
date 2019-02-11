package com.learnyeai.testing.mapper;

import com.learnyeai.testing.model.TestingStudentPaper;

import org.apache.ibatis.annotations.Param;

import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

/**
 * @Description: 学员某个卷子的对应记录
 * @author twang
 */
@MyBatisDao
public interface TestingStudentPaperMapper extends BaseMapper<TestingStudentPaper> {
	public Integer queryTestNum(TestingStudentPaper obj);

	public double queryMaxScore(@Param("studentUserId") String studentUserId, @Param("tsId") String tsId);

	public double querySumScore(@Param("studentUserId") String studentUserId, @Param("tsId") String tsId);
}
