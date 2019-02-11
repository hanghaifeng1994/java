package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 学习小组分类-小组关联表
 *
 * @author yl
 */
public class SgpCategoryGroupRel extends BaseEntity {

    /**
    * 分类id
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;
    /**
    * 小组id
    */
    @Id
    @Column(name = "SGP_ID")
    private String sgpId;


    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getSgpId() {
        return sgpId;
    }

    public void setSgpId(String sgpId) {
        this.sgpId = sgpId;
    }

    public static class TF {

        public static String TABLE_NAME = "SGP_CATEGORY_GROUP_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String catId = "CAT_ID";  // 分类id
        public static String sgpId = "SGP_ID";  // 小组id

    }
}
