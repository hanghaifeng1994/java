package com.learnyeai.interact.mapper;

import com.learnyeai.interact.model.IsItaLiked;
import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.List;
import java.util.Map;

/**
 * @Description: 点赞
 * @author yl
 */
@MyBatisDao
public interface ItaLikedBatchMapper extends BaseMapper<ItaLiked> {
    int saveBatch(ItaLiked liked);
    int updateBatch(ItaLiked liked);
}
