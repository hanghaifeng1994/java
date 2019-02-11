package com.drcl.traincore.util;

/**
 * 生成关系表id主键
 * @author sli
 * create date 2015-1-28 下午05:24:59
 */
public class ModelIdKeyUtil
{
    /**
     * 生成用户班级课程id
     * @author hli
     * @param userId
     * @param clazzId
     * @param courseId
     * @return
     */
    public static String generateUserClazzCourseIdKey(Long userId,Long clazzId,Long courseId){
    	if(clazzId == null)
    		return userId +"_"+"null"+"_"+courseId;
    	return userId +"_"+clazzId+"_"+courseId;
    }
    
   /* *//**
     * 生成班级课程id
     * @param clazzId
     * @param courseId
     * @return
     *//*
    private String generateClazzCourseIdKey(Long clazzId,Long courseId){
    	return clazzId+"_"+courseId;
    }*/
    
    /**
     * 生成课程租户id
     * @param courseId
     * @param manageTenantId
     * @param userTenantId
     * @return
     */
    public static String generateCourseTenantIdKey(Long courseId,Long manageTenantId,Long userTenantId){
    	StringBuffer id = new StringBuffer(courseId+"");
    	if(manageTenantId == null)
    		id.append("_null");
    	else id.append("_"+manageTenantId);
    	if(userTenantId == null)
    		id.append("_null");
        else id.append("_"+userTenantId);
    	return id.toString();
    }
    
    /**
     * 生成班主任id
     * @author hli
     * @param userId
     * @param clazzId
     * @param courseId
     * @return
     */
    public static String generateHeaderClazzIdKey(Long userId,Long clazzId){
    	return userId +"_"+clazzId;
    }  
    
    /**
     * 生成项目租户id
     * @param programId
     * @param manageTenantId
     * @param useTenantId
     * @return
     */
    public static String generateProgramTenantIdKey(Long programId,Long manageTenantId,Long useTenantId){
    	StringBuffer id = new StringBuffer(programId+"");
    	if(manageTenantId == null)
    		id.append("_null");
    	else id.append("_"+manageTenantId);
    	if(useTenantId == null)
    		id.append("_null");
        else id.append("_"+useTenantId);
    	return id.toString();
    }
       
    /**
     * 生成用户班级id
     * @author hli
     * @param studentId
     * @param clazzId
     * @return
     */
    public static String generateStudentClazzIdKey(Long studentId,Long clazzId){
    	return studentId+"_"+clazzId;
    }
           
    /**
     * 生成用户阶段id
     * @author hli
     * @param userId
     * @param phaseId
     * @return
     */
    public static String generateUserPhaseIdKey(Long userId,Long phaseId){
    	return userId+"_"+phaseId;
    }
    
    /**
     * 生成用户项目课程id
     * @author hli
     * @param userId
     * @param programsId
     * @return
     */
    public static String generateUserProgramsIdKey(Long userId,Long programsId){
    	return userId+"_"+programsId;
    }
    
    /**
     * 生成用户考评结果id
     * @author hli
     * @param userId
     * @param programsId
     * @return
     */
    public static String generateUserCheckResultKey(Long userId,Long programsCheckId,Long clazzId){
    	return userId+"_"+programsCheckId+"_"+clazzId;
    }
    
    /**
     * 生成用户考评详细id
     * @author hli
     * @param userId
     * @param programsId
     * @return
     */
    public static String generateUserCheckDetailKey(Long userId,String code,String usercheckresultId){
    	return userId+"_"+code+"_"+usercheckresultId;
    }
    
}
