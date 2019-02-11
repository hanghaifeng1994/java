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
	   $(".batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/qualification!delete.action?parentId=${parentId}";
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
<a href="#" class="grey">基础数据管理 </a> &gt; <span class="deep_bule">专业技术职务管理</span></div>
<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<form id="mainForm" name="mainForm" action="qualification.action"
	method="post"><input type="hidden" name="page.pageNo"
	id="pageNo" value="${page.pageNo}" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" />
	 <input type="hidden" name="parentId" id="parentId" value="${parentId}" />
</form>

<div class="operation_list"><span class="fl"> <input
	name="Submit2" type="button" class="operation_btu2 batchDelDown" value="批量删除"
	id="batchDelDown" /> <input name="Submit3" type="button"
	class="operation_btu1" value="新增"
	onclick="window.location='qualification!input.action?parentId=${parentId}'" /> 
	<s:if test="parentId != null">
	<input name="Submit3" type="button" class="operation_btu1"
		value="返回上级资格" onclick="window.location.href='qualification!reback.action?parentId=${parentId}'" />(${advanceName})	
	</s:if>
	</span>
	</div>

<div>

<form name="deleteForm" id="deleteForm"
	action="qualification!delete.action" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="10%" class="tt_noline"><input type="checkbox"
			id="checkboxall" /></td>
		<s:if test="parentId != '' && parentId != null">
			<td width="10%" class="tt_line">分类名称</td>
			<td width="10%" class="tt_line">上级资格名称</td>
		</s:if>
		<s:else>
			<td width="10%" class="tt_line">资格名称</td>
		</s:else>
		<td width="10%" class="tt_line">资格等级</td>
		<td width="20%" class="tt_line">操作</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>

			<td class="white_bg"><input type="checkbox" name="ids"
				value="${id}" /></td>
			<s:if test="parentId != '' && parentId != null">
				<td title="${name}" class="white_bg"><common:cut len="20"
					string="${name}" />&nbsp;</td>
				<td title="${parent.name}" class="white_bg"><common:cut
					len="20" string="${parent.name}" />&nbsp;</td>
			</s:if>
			<s:else>
				<td title="${name}" class="white_bg"><common:cut len="20"
					string="${name}" />&nbsp;</td>
			</s:else>
			<td title="${qualificationLevel}" class="white_bg"><common:cut len="20"
				string="${qualificationLevel}" />&nbsp;</td>
			<td class="white_bg"><a
				href="${ctx }/train/manage/qualification!input.action?id=${id}&parentId=${parentId}">编辑</a>
			<s:if test="parentId != '' && parentId != null">
				<a href="#"
					onclick="delRecord('${ctx }/train/manage/qualification!delete.action?id=${id}&parentId=${parentId}');">删除</a>
			</s:if> <a href="${ctx }/train/manage/qualification.action?parentId=${id}">管理下级资格</a>
			</td>
		</tr>
	</s:iterator>
</table>
</form>
</div>


<div class="operation_list"> <%@ include file="/common/turnpage.jsp"%>
	</div>
	