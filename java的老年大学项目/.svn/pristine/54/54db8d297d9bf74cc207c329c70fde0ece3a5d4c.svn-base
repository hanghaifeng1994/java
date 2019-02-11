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

import cn.common.lib.vo.LabelValue;

/**
 * 
 * 短信模板
 * 
 * @author len.sun
 * @version 1.0
 */
public class Mstemplate
{

    public static List<LabelValue> tempList = new ArrayList<LabelValue>();
    public static List<LabelValue> yytempList = new ArrayList<LabelValue>();
    
    public static final String kqtz = "您预约的#program#考试将在#addresstime#进行。"
    								   + "考试请带身份证，关注平台班级公告中发布的继教证"
    								   + "上交通知。由于校园车位有限，考试期间考生车辆不"
    								   + "允许进入校园，请各位合理安排出行，造成不便，敬请谅解。";
    
    
    public static final String kqtz_area = "#name#您好，您预约的#program#考试将在#addresstime#进行。" +
    									"考试请带身份证。由于校园车位有限，考试期间考生车辆不允许进入校园，" +
    									"请各位合理安排出行，造成不便，敬请谅解。";
    
    public static final String yytz = "您参加的#program#已经开放考试预约，请于#yytime#前，"
    		                           + "及早登录网站进行预约。";
    
    public static final String imptipes="接滁州市人社局紧急通知，#oldtime的考试调整至#newtime进行，"
    								   + "请预约在#oldtime考试的学员，"
    		                           + "于#newtime至滁州电大参加考试，考试时间段不变，给您"
    		                           + "造成的不便，敬请谅解";
    public static final String cctz = "您参加的#program##clazzName#，在#starttime#开放学习，"
    		                           + "请用身份证号作为用户名，后六位作为密码登录系统学习。"
    		                           + "祝您学习愉快！";
    public static final String englishtz = "您确认参加无锡市第二十届学生英语口语电视大赛#className#决赛，比赛将于#time#在#address#进行，请提前半小时到场。";
    
    public static final String jtClazztz="#name#，您已成功参加#program#培训，请登录#website#学习，用户名:#userName#，初始密码：#password#，祝您学习愉快！";
    
    public static final String tplexamId="29008";//考前通知
    public static final String tplexamIdArea="32150";//考前通知地区版本,带姓名给区县用的
	public static final String tplyyId="28931";//预约通知
	public static final String tplccId="30001";//开班通知
	public static final String tplcId="31673";//导入临时通知
	public static final String tplenglishId="36739";//英语竞赛通知
	public static final String tpljtclazzId="47566";//集体班级开班通知
	
    static
    {
    	tempList.add(new LabelValue(tplexamId, kqtz));
    	tempList.add(new LabelValue(tplyyId, yytz));
    	tempList.add(new LabelValue(tplccId, cctz));
    	tempList.add(new LabelValue(tplcId, imptipes));
    	tempList.add(new LabelValue(tplexamIdArea, kqtz_area));
    	tempList.add(new LabelValue(tpljtclazzId, jtClazztz));
    }
    static
    {
		yytempList.add(new LabelValue(tplyyId, yytz));
    }
    
    public static String getTempbyTpId(String tpId){
    	for(LabelValue lv:tempList){
    		if(lv.getValue().equals(tpId))
    			return lv.getLabel();
    	}
    	return null;
    }
}
