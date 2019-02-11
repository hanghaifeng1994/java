<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script src="${staticurl}/js/related.js" type="text/javascript"></script>
<script type="text/javascript">
	function checksel(){
		if(checkSelect()==false)
		{
			alert('至少选择一门课程');
			return false;
		}
		return true;
	}
    $(document).ready(function(){
    	if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
        
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
			     $("input[name='ids']").attr("checked",$(this).attr("checked"));
				   }
			   else{
			   $("input[name='ids']").removeAttr("checked");
				   } 
	   });

	   //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			     //  if(!confirm('您确定要进行此操作吗?')) return  false;
	
				 //   $("#deleteForm").submit();
				 //  document.getElementById("deleteForm").action = oaction;
			 }); 	
    	});  
		function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		} 
</script>
</head>

<body>
     <section id="main" role="main"> 
      <div class="dr-container-fluid">
   <div class="dr-page-header">
     <h3>添加新课程到教学计划 </h3>
   </div>
   <hr/>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->

<form id="mainForm" action="programs!newcourse.action" method="post" class="form-inline dr-form-inline">
  <input type="hidden" name="coursePage.pageNo" id="pageNo" value="${coursePage.pageNo}" /> 
  <input type="hidden" name="coursePage.orderBy" id="orderBy" value="${coursePageorderBy}" />
  <input type="hidden" name="coursePage.order" id="order" value="${coursePage.order}" /> <input type="hidden" name="id" value="${id}" /> 
  <input type="hidden" name="planid" value="${planid}" />
  <div class="dr-searchbar"> 
     <div class="form-group">
       <label>课程分类:</label>
       <s:select list="oneCourseCategories" listKey="id" name="onecat" value="onecat"
			id="onecategory" listValue="name" headerKey="" headerValue="一级分类" cssClass="form-control input-sm"
			theme="simple"></s:select> 
		<s:select list="twoCategories" listKey="id" listValue="name" theme="simple" id="twocategory" cssClass="form-control input-sm"
			headerKey="" headerValue="二级分类" value="twocat" name="twocat">
	   </s:select>
	   <s:select list="threeCategories" listKey="id" listValue="name" cssClass="form-control input-sm"
			theme="simple" id="threecategory" headerKey="" headerValue="三级分类"
			value="threecat" name="threecat"></s:select>
     </div>
      <!--<div class="form-group">
        <label>课程类型:</label>
         <s:select list="#{'必修课':'1','选修课':'2','开放课':'3'}" 
			listKey="value" listValue="key" cssClass="form-control input-sm"
			value="@java.lang.Integer@parseInt(#parameters.filter_EQI_courseModel)"
			name="filter_EQI_courseModel" headerKey="" headerValue="--请选择课程类型--"></s:select>
      </div>-->
      <div class="form-group">
       <label>课程名称:</label>
       <input  name="filter_LIKES_name" value="${param['filter_LIKES_name']}" class="form-control input-sm" />
      </div>
      <button class="btn btn-default btn-sm" type="submit">
     <span class="glyphicon glyphicon-search"></span>
      &nbsp;查询
   </button> 
  </div>
</form>

<form id="dataForm" action="${ctx}/plancourse/manage/plancourse!savecourse.action" method="post" class="form-inline dr-form-inline">
  <input type="hidden" name="planid" value="${planid }"></input>
  <s:set name="page" value="coursePage" scope="request"></s:set> 
 <div class="panel panel-default">
<table class="table table-bordered dr-table-default">
  <thead>
	<tr>
		<th width="10%" class="tt_noline"><input type="checkbox"
			id="checkboxall" /></th>
		<!--<th width="10%" >课程属性</th>-->
		<th width="40%" >课程名称</th>
		<th width="20%" >课程代码</th>
		<th width="20%" >课程学分</th>
	</tr>
	</thead>
	<s:iterator value="courseVOs" status="stat">
		<tr>
			<td ><s:if test='!added'>
				<input type="checkbox" name="ids" value="${course.id}" />
			</s:if> <s:else>
			已添加
			</s:else></td>
			<!--<td >${course.courseModelString}</td>-->
			<td >${course.name}</td>
			<td >${course.serialNo}</td>
			<td >${course.studylength}</td>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
<div class="panel panel-default">
  <div class="form-group">
    <label>课程属性：</label>
    <s:select list="#{'必修课':'2','选修课':'1'}" theme="simple" cssClass="form-control input-sm"
			listKey="value" listValue="key" name="courseprop"></s:select>
  </div>
   <div class="form-group">
     <label>是否影响已有班级：</label>
     <s:radio list="#{true:'是',false:'否'}" value="false"
			name="affectExistClazz" theme="simple"></s:radio>
   </div>
    <button class="btn btn-primary" type="submit" onclick="return checksel();" name="Submit32">
     <span class="glyphicon glyphicon-ok"></span>
      &nbsp;确认添加
   </button> 
</div>


</form>
</div>
</section>
</body>
</html>
