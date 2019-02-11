<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/related.js" type="text/javascript"></script>
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
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!delete.action?ID=${id}";
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
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!delete.action";
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
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!publish.action";
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
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!canclePublish.action";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 

	   $("#hide").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!hide.action";
			       if(!checkSelect()) {
			            alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   $("#deleteForm").submit();
				   document.getElementById("deleteForm").action = oaction;
			 }); 

	   $("#show").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs.action?show=true";
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
<a href="#" class="grey">培训项目管理</a> &gt; <span class="deep_bule">培训项目列表</span></div>


<form id="mainForm" name="mainForm" action="programs.action"
	method="post"><input type="hidden" name="page.pageNo"
	id="pageNo" value="${page.pageNo}" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="user_search">
	<tr>
		<td width="10%">项目名称</td>
		<td width="20%"><input name="filter_LIKES_name"
			class="txt_input mr10" value="${param['filter_LIKES_name']}" /></td>
		<td width="10%">项目代码</td>
		<td width="20%"><input name="filter_EQS_code"
			class="txt_input mr10" value="${param['filter_EQS_code']}" /></td>
		<td rowspan="2"><input type="submit" value="查询"
			class="search_btu mr5" /></td>
	</tr>
	<tr>
		<td>前台报名</td>
		<td><s:select name="filter_EQB_enable"
			list="#{'--全部--':'','开放':'True','不开放':'False'}" theme="simple"
			listKey="value" listValue="key" value="#parameters.filter_EQB_enable">
		</s:select></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>

</form>

<form name="deleteForm" id="deleteForm" action="item!delete.action"
	method="post">
<div class="operation_list"><span class="fl"> 
	<input name="Submit2" type="button" class="operation_btu2" value="批量删除" id="batchDelDown" /> 
	<s:if test="curTenantID==null">
	<input name="Submit3" type="button" class="operation_btu1" value="新增培训项目" onclick="window.location='programs!input.action'" />
	</s:if>
	<input name="Submit2" type="button" class="operation_btu2" value="开放" id="batchEnableDown" id="batchDelDown" /> 
	<input name="Submit2" type="button" class="operation_btu2" value="不开放" id="batchDisableDown" id="batchDelDown" /> 
	<input name="Submit4" type="button" class="operation_btu2" value="隐藏"  id="hide"/> 
	<input name="Submit5" type="button" class="operation_btu1" value="显示全部"  id="show"/> 
</span></div>
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="5%" class="tt_noline"><input type="checkbox"
			id="checkboxall" /></td>
		<td width="20%" class="tt_line">项目名称</td>
		<td width="13%" class="tt_line">项目代码</td>
		<td width="13%" class="tt_line">所属项目类型</td>
		<td width="13%" class="tt_line">前台报名</td>
		<td width="8%" class="tt_line">自主班级</td>
		<td width="8%" class="tt_line">集体班级</td>
		<td width="20%" class="tt_line">操作</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg"><input type="checkbox" name="ids"
				value="${id}" /></td>
			<td class="white_bg"><a href="#">${name} ${cityStr}</a></td>
			<td class="white_bg">${code}</td>
			<td class="white_bg">&nbsp;${catName}</td>
			<td class="white_bg">&nbsp;${statusStr}</td>
			<td class="white_bg">&nbsp;${selfClazzCount}</td>
			<td class="white_bg">&nbsp;${groupClazzCount}</td>
			<td class="white_bg">
				<a href="programs!updateOrder.action?id=${id}&direction=up">上移</a>
				<a href="programs!updateOrder.action?id=${id}&direction=down">下移</a>
				<a target="_blank" href="programs!minput.action?id=${id}">属性</a>
				<a target="_blank" href="programs!phaseList.action?itemid=${id}">教学计划</a>
				<a target="_blank" href="programs!studentlog.action?id=${id}">学员</a>		
			</td>
		</tr>
	</s:iterator>

</table>
</div>
<div class="operation_list"><%@ include file="/common/turnpage.jsp"%></div>
</form>