//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: fangyong
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package com.drcl.traincore.contants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.common.lib.util.ResourceUtil;
import cn.common.lib.vo.LabelValue;

/**
 * 
 * 预定义的二级栏目.
 * 
 * @author fangyong
 * @version 1.0
 * @since 2010-11-24
 */
public class TwoCategorys
{
    // 新闻焦点
    public static final String     XWJD       = "xwjd";

    // 理论研究
    public static final String     LLYJ       = "llyj";

    // 政策导航
    public static final String     ZCDH       = "zcdh";

    // 培训广场
    public static final String     PXGC       = "pxgc";

    // 社区风采
    public static final String     SQFC       = "sqfc";

    // 志愿者行动
    public static final String     ZYZXD      = "zyzxd";

    // 专家团队
    public static final String     ZJTD       = "zjtd";

    // 一级栏目,教育动态
    public static final String     JYDT       = "jydt";

    // 一级栏目,学习中心
    public static final String     XXZX       = "xxzx";

    // 一级栏目,实践探索
    public static final String     SJTS       = "sjts";

    // 一级栏目,互动交流
    public static final String     HDJL       = "hdjl";

    public static final int        CATE_ONE   = 1;

    public static final int        CATE_TWO   = 2;

    public static final int        CATE_THREE = 3;

    public static final int        CATE_FOUR  = 4;

    public static final int        CATE_FIVE  = 5;

    public static final int        CATE_SIX   = 6;

    public static final int        CATE_SEVEN = 7;

    // 栏目列表
    public static List<LabelValue> enumList   = new ArrayList<LabelValue>();

    static
    {
        enumList.add(new LabelValue(String.valueOf(CATE_ONE), XWJD));
        enumList.add(new LabelValue(String.valueOf(CATE_TWO), LLYJ));
        enumList.add(new LabelValue(String.valueOf(CATE_THREE), ZCDH));
        enumList.add(new LabelValue(String.valueOf(CATE_FOUR), PXGC));
        enumList.add(new LabelValue(String.valueOf(CATE_FIVE), SQFC));
        enumList.add(new LabelValue(String.valueOf(CATE_SIX), ZYZXD));
        enumList.add(new LabelValue(String.valueOf(CATE_SEVEN), ZJTD));
    }

    /**
     * 
     * 取得栏目
     * 
     * @since 2010-12-12
     * @author shanru.wu
     * @param code
     * @return
     */
    public static int getValue(String code)
    {
        for (LabelValue lv : enumList)
        {
            if (lv.getLabel().equals(code))
            {
                return Integer.parseInt(lv.getValue());
            }
        }
        return 0;
    }

    // 栏目列表
    public static List<LabelValue>    categorysList  = new ArrayList<LabelValue>();

    public static Map<String, String> twoCategoryMap = new HashMap<String, String>();

    public static Map<String, String> oneCategoryMap = new HashMap<String, String>();

    static
    {
        oneCategoryMap.put(JYDT, ResourceUtil.getValue("onecategory.jydt",
                "教育动态"));
        oneCategoryMap.put(XXZX, ResourceUtil.getValue("onecategory.xxzx",
                "学习中心"));
        oneCategoryMap.put(SJTS, ResourceUtil.getValue("onecategory.sjts",
                "实践探索"));
        oneCategoryMap.put(HDJL, ResourceUtil.getValue("onecategory.hdjl",
                "互动交流"));

        twoCategoryMap.put(XWJD, ResourceUtil.getValue("onecategory.xwjd",
                "新闻焦点"));
        twoCategoryMap.put(LLYJ, ResourceUtil.getValue("onecategory.llyj",
                "理论研究"));
        twoCategoryMap.put(ZCDH, ResourceUtil.getValue("onecategory.zcdh",
                "政策导航"));
        twoCategoryMap.put(PXGC, ResourceUtil.getValue("onecategory.pxgc",
                "培训广场"));
        twoCategoryMap.put(SQFC, ResourceUtil.getValue("onecategory.sqfc",
                "社区风采"));
        twoCategoryMap.put(ZYZXD, ResourceUtil.getValue("onecategory.zyzxd",
                "志愿者行动"));
        twoCategoryMap.put(ZJTD, ResourceUtil.getValue("onecategory.zjtd",
                "专家团队"));

        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.xwjd", "新闻焦点"), XWJD));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.llyj", "理论研究"), LLYJ));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.zcdh", "政策导航"), ZCDH));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.pxgc", "培训广场"), PXGC));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.sqfc", "社区风采"), SQFC));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.zyzxd", "志愿者行动"), ZYZXD));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.zjtd", "专家团队"), ZJTD));
    }
}
