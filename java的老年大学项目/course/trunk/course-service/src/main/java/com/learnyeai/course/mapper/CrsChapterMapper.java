package com.learnyeai.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.learnyeai.course.model.CrsChapter;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

/**
 * @Description: 课程章节
 * @author twang
 */
@MyBatisDao
public interface CrsChapterMapper extends BaseMapper<CrsChapter> {
	public List<CrsChapter> queryByParent(@Param("csId") String csId, @Param("parentId") String parentId);

	@Select(value = "select count(*) from crs_chapter where CS_ID = #{csId} and PARENT_ID = #{parentId}")
	public int countByParent(@Param("csId") String csId, @Param("parentId") String parentId);

	@Select(value = "select count(*) from crs_chapter where CS_ID = #{csId} and PARENT_ID is null")
	public int countOneTree(@Param("csId") String csId);

}
