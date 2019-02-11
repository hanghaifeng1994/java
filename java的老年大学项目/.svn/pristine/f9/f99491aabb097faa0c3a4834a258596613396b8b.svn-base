package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 分类-相册关联表
 *
 * @author yl
 */
public class AbmCategoryPhotoRel extends BaseEntity {

    /**
    * 分类id
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;
    /**
    * 相册id
    */
    @Id
    @Column(name = "ABM_ID")
    private String abmId;


    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }

    public static class TF {

        public static String TABLE_NAME = "ABM_CATEGORY_PHOTO_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String catId = "CAT_ID";  // 分类id
        public static String abmId = "ABM_ID";  // 相册id

    }
}
