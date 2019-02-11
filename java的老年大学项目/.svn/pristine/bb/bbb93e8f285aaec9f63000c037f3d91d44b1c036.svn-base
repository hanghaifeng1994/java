package com.learnyeai.schoolclass.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.schoolclass.mapper.ClzBatchCourseMapper;
import com.learnyeai.schoolclass.model.ClzBatchCourse;
import com.learnyeai.schoolclass.model.ClzClazzBatch;
import com.learnyeai.schoolclass.model.ClzClazzCourse;

/**
 *
 * @author twang
 */
@Service
public class ClzBatchCourseWyService extends WeyeBaseService<ClzBatchCourse> {

	@Resource
	private ClzBatchCourseMapper clzBatchCourseMapper;

	@Override
	public BaseMapper<ClzBatchCourse> getMapper() {
		return clzBatchCourseMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	/**
	 * 保存批次的课程，先删掉批下所有课程，再全部加上
	 * 
	 * @param batch
	 * @param clazzCourses
	 *            报名的班级课程
	 * @return
	 */
	@Transactional
	public boolean saveBatchCourse(ClzClazzBatch batch, List<ClzClazzCourse> clazzCourses) {
		ClzBatchCourse batchCourse = new ClzBatchCourse();
		batchCourse.setBatchId(batch.getBatchId());
		List<ClzBatchCourse> list = super.queryList(batchCourse, null);
		for (ClzBatchCourse delObj : list) {
			super.delete(delObj);
		}
		for (ClzClazzCourse clazzCourse : clazzCourses) {
			ClzBatchCourse bc = new ClzBatchCourse();
			bc.setBatchId(batch.getBatchId());
			bc.setCsId(clazzCourse.getCsId());
			bc.setCsAmount(clazzCourse.getCsAmount());
			bc.setCsStudylength(clazzCourse.getCsStudylength());
			bc.setCsType(clazzCourse.getCsType());
			super.save(bc);
		}
		return true;
	}
}
