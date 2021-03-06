package com.learnyeai.trainmanage.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 
 *
 * @author yl
 */
public class ClzSiteCategoryRel extends BaseEntity {

    /**
    * 
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;
    /**
    * 
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;

    /**
     * 
     */
    @Column(name = "SHOW_STATUS")
    private String showStatus;
    /**
     * 
     */
    @Column(name = "CAT_CRT_SITE_ID")
    private String catCrtSiteId;



    @Transient
    List<ClzSiteCategoryRel> list;

    public List<ClzSiteCategoryRel> getList(){
        return list;
    }
    public void setList(List<ClzSiteCategoryRel> list){ this.list = list;}



    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }
    public String getCatCrtSiteId() {
        return catCrtSiteId;
    }

    public void setCatCrtSiteId(String catCrtSiteId) {
        this.catCrtSiteId = catCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_SITE_CATEGORY_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 
        public static String catId = "CAT_ID";  // 
        public static String showStatus = "SHOW_STATUS";  // 
        public static String catCrtSiteId = "CAT_CRT_SITE_ID";  // 

    }
}
