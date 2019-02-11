package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 创建题库的时候，判断是否有本商户的题型，否则都要初始化一个，支持单选，多选，判断，填空
 *
 * @author twang
 */
public class TestingItemTypes extends BaseEntity {

    /**
    * 题型ID
    */
    @Id
    @Column(name = "ITEM_TYPE_ID")
    private String itemTypeId;

    /**
     * 题型名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 题型code(ms/dx/pd/tk)
     */
    @Column(name = "ITEM_TYPE")
    private String itemType;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;

    public String getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(String itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_ITEM_TYPES";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String itemTypeId = "ITEM_TYPE_ID";  // 题型ID
        public static String name = "NAME";  // 题型名称
        public static String itemType = "ITEM_TYPE";  // 题型code(dx/dx/pd/tk)
        public static String mchtId = "MCHT_ID";  // 商户id

    }
}
