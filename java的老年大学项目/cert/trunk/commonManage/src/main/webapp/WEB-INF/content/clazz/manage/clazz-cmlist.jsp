<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
<script type="text/javascript">
	<!--
    $(document).ready(function(){    
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
	   });

	   //验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action?ID=${id}";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
	   }); 

	   //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/clazz!delete.action?flag=${flag}";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
	   }); 	
				 
	   $("#batchEnableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!enable.action";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 

	   $("#batchDisableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!disable.action";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 
    });  
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		}
-->
	 
	</script>
<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;
<a href="#" class="grey">班级管理</a> &gt; <span class="deep_bule">班级列表</span></div>


<form id="mainForm" name="mainForm" action="clazz.action" method="post">

<div class="greytab">
<ul>
	<li
		class="<s:if test='flag!="group"'>greytab_on</s:if><s:else>greytab_no</s:else>"><a
		href="clazz.action">自主班级</a></li>
	<li
		class="<s:if test='flag=="group"'>greytab_on</s:if><s:else>greytab_no</s:else>"><a
		href="clazz.action?flag=group">集体班级</a></li>

</ul>
</div>
	<input type="hidden" name="page.pageNo" id="pageNo"	value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input	type="hidden" name="flag" id="order" value="${flag}" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="user_search">
	<tr>

		<td width="9%">
		<span style="white-space: nowrap">班级名称</span>
		</td>
		<td width="18%"><input name="filter_LIKES_name"
			class="txt_input mr10" value="${param['filter_LIKES_name']}" /></td>
		<td width="9%"><span style="white-space: nowrap">班级代码</span></td>
		<td width="18%"><input name="filter_LIKES_code"
			value="${param['filter_LIKES_code']}" class="txt_input mr10" /></td>
	
		<td width="27%" colspan="2"><span style="white-space: nowrap">状态: <s:checkboxlist name="state"
			list="#{'开放':1,'未开始':0,'结束':2}" theme="simple" listKey="value"
			listValue="key"
			value="state">
		</s:checkboxlist></span> <input type="hidden" name="programsid" value="${programsid }"
			id="hiddenprogramsid" /> <input type="hidden" name="planid"
			value="${planid }" id="hiddenplanid" /></td>
			<td rowspan="2">
			<input type="submit" value="查询"
			class="search_btu mr5" />
			</td>
	</tr>
	<tr>

		<td>培训类型</td>
		<td width="18%"><s:select list="ItemCategories" listKey="id"
			listValue="name" theme="simple" name="itemid" headerKey=""
			headerValue="请选择培训类型"></s:select></td>
		<td>培训项目</td>
		<td width="18%"><s:select list="TrainingProgramses" listKey="id"
			listValue="name"
			value="@java.lang.Long@parseLong(#parameters.filter_EQL_trainingPrograms$id)"
			name="filter_EQL_trainingPrograms$id" theme="simple"
			headerValue="请选择培训项目" headerKey="" id="programsid"></s:select></td>
		<td><span style="white-space: nowrap">教学计划</span></td>
		<td width="18%"><s:select list="TeachPlanes" listKey="id"
			listValue="name"
			value="@java.lang.Long@parseLong(#parameters.filter_EQL_teachPlan$id)"
			name="filter_EQL_teachPlan$id" theme="simple"
			headerValue="--请选择教学计划--" headerKey="" id="planid"></s:select></td>
	
	</tr>

</table>
</form>

<form name="deleteForm" id="deleteForm" action="item!delete.action"
	method="post">
	<!-- 
<div class="operation_list"><span class="fl"> <input
	name="Submit2" type="button" class="operation_btu2" value="批量删除"
	id="batchDelDown" /> <input name="Submit3" type="button"
	class="operation_btu1"
	value="<s:if test='flag=="group"'>新增集体班级</s:if><s:else>新增自主班级</s:else>"
	onclick="window.location='clazz!input.action<s:if test='flag=="group"'>?flag=group</s:if>'" /></span>
</div>
 -->
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="5%" class="tt_noline"><input type="checkbox"
			id="checkboxall" /></td>
		<td width="13%" class="tt_line">培训项目</td>
		<td width="13%" class="tt_line">年度教学计划</td>
		<td width="18%" class="tt_line">班级名称</td>
		<td width="13%" class="tt_line">班级代码</td>
		<td width="13%" class="tt_line">学员数</td>
		<td width="10%" class="tt_line">班级状态</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg"><input type="checkbox" name="ids" value="${id}" /></td>
			<td class="white_bg">${trainingPrograms.name}</td>
			<td class="white_bg">${teachPlan.name}</td>
			<td class="white_bg">${name}</td>
			<td class="white_bg">${code}</td>
			<td class="white_bg">${studentCount }</td>
			<td class="white_bg">${StateStr}</td>
		</tr>
	</s:iterator>

</table>
</div>
<div class="operation_list">
<%@ include file="/common/turnpage.jsp"%></div>
</form>