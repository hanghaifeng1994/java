package com.learnyeai.album.mapper;

import com.learnyeai.album.model.AbmAlbum;
import com.learnyeai.album.model.AbmSitePhotoRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.List;

/**
 * @Description: 站点-相册
 * @author yl
 */
@MyBatisDao
public interface AbmSitePhotoRelMapper extends BaseMapper<AbmSitePhotoRel> {
    List<AbmSitePhotoRel> queryPageExt(AbmSitePhotoRel abmSitePhotoRel);

    int deleteByAbmId(String abmId);

    int updateByAbmId(AbmAlbum ab);

    int updatePubStatusByAbmId(AbmSitePhotoRel ab);

}
