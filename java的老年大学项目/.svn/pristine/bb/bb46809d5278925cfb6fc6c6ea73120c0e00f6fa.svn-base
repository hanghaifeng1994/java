package com.learnyeai.schoolclass.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.schoolclass.mapper.ClzStudentBatchMapper;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.model.ClzClazzBatch;
import com.learnyeai.schoolclass.model.ClzStudentBatch;
import com.learnyeai.schoolclass.model.ClzStudentClazz;

/**
 *
 * @author twang
 */
@Service
public class ClzStudentBatchWyService extends WeyeBaseService<ClzStudentBatch> {

	@Resource
	private ClzStudentBatchMapper clzStudentBatchMapper;
	
	@Resource
	private  ClzStudentClazzWyService clzStudentClazzWyService;

	@Override
	public BaseMapper<ClzStudentBatch> getMapper() {
		return clzStudentBatchMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public boolean saveStudentBatch(ClzClazzBatch batch, List<CustInfoVo> custs, ClzClazz clazz) {
		ClzStudentBatch studentBatch = new ClzStudentBatch();
		studentBatch.setBatchId(batch.getBatchId());
		List<ClzStudentBatch> list = super.queryList(studentBatch, null);
		for (ClzStudentBatch delObj : list) {
			super.delete(delObj);
		}
		for (CustInfoVo cust : custs) {
			ClzStudentBatch sb = new ClzStudentBatch();
			sb.setBatchId(batch.getBatchId());
			sb.setCustId(cust.getCustId());
			sb.setCzId(clazz.getCzId());
			ClzStudentClazz studentClazz = new ClzStudentClazz();
			studentClazz.setCustId(cust.getCustId());
			studentClazz.setCzId(clazz.getCzId());
			studentClazz = clzStudentClazzWyService.queryOne(studentClazz);
			sb.setScId(studentClazz.getScId());
			super.save(sb);
		}
		return true;
	}
}
