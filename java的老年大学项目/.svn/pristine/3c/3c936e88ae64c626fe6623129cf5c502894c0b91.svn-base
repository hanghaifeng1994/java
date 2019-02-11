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
import java.util.List;

import cn.common.lib.util.ResourceUtil;
import cn.common.lib.vo.LabelValue;

/**
 * 
 * 预定义的一级栏目.
 * 
 * @author fangyong
 * @version 1.0
 * @since 2010-11-24
 */
public class OneCategorys
{
    // 教育动态
    public static final String     JYDT          = "jydt";

    // 学习中心
    public static final String     XXZX          = "xxzx";

    // 实践探索
    public static final String     SJTS          = "sjts";

    // 互动交流
    public static final String     HDJL          = "hdjl";

    // 学习联盟
    public static final String     XXLM          = "xxlm";

    // 栏目列表
    public static List<LabelValue> categorysList = new ArrayList<LabelValue>();

    static
    {
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.jydt", "教育动态"), JYDT));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.xxzx", "学习中心"), XXZX));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.sjts", "实践探索"), SJTS));
        categorysList.add(new LabelValue(ResourceUtil.getValue(
                "onecategory.hdjl", "互动交流"), HDJL));
    }
}
