<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
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
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
		});

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action";
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
	</script>
</head>

<body>


     <div class="dr-page-header">
       <h3>添加新课程</h3>
     </div>
     <hr />
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
   <div class="dr-searchbar"> 
   <form id="mainForm" action="clazz!outteachcontentcourse.action" method="post" class="form-inline dr-form-inline">
	<input type="hidden" name="page3.pageNo" id="pageNo" value="${page3.pageNo}" />
	<input type="hidden" name="page3.orderBy" id="orderBy" value="${page3.orderBy}" />
	<input type="hidden" name="page3.order" id="order" value="${page3.order}" />
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="teachContentId" value="${teachContentId}" />

      <div class="form-group">
            <label>课程分类: </label>
            <s:select list="oneCourseCategories" listKey="id" name="onecat" value="onecat"
			id="onecategory" listValue="name" headerKey="" cssClass="form-control input-sm" cssStyle="width:120px;"
			headerValue="一级分类" theme="simple"></s:select>
			
			<s:select list="twoCategories" listKey="id" cssClass="form-control input-sm" cssStyle="width:120px;"
			listValue="name" theme="simple" id="twocategory" headerKey=""
			headerValue="二级分类" value="twocat" name="twocat"></s:select>
		
		   <s:select list="threeCategories" listKey="id" cssClass="form-control input-sm" cssStyle="width:120px;"
			listValue="name" theme="simple" id="threecategory" headerKey=""
			headerValue="三级分类" value="threecat" name="threecat"></s:select>
      </div>
    <div class="form-group">
      <label>课程名称:</label>
      <input name="filter_LIKES_name" value="${param['filter_LIKES_name']}"  class="form-control input-sm" style="width: 200px;"/>
    </div>
    <div>
    <div class="form-group">
<label>教学方式</label>
<s:select name="filter_EQB_offline" cssClass="form-control input-sm" list="#{'--全部--':'','线下':'true','线上':'false'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_offline">
		        </s:select>
</div>
     <button class="btn btn-default btn-sm" type="submit">
     <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
   </button> 
   </div>
</form>
</div>
<form id="dataForm"	action="clazz!saveoutteachcontentcourse.action"	method="post">
  <input type="hidden" name="id" value="${id}" />
  <div class="panel panel-default">
  <table class="table table-bordered dr-table-bordered">
   <thead>
	 <tr>
		<th width="10%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
		<th width="10%">课程属性</th>		
		<th width="30%">课程名称</th>
		<th width="15%">课程代码</th>
		<th width="10%">课程学分</th>
		<th width="11%">教学方式</th>
		<th width="15%">课程来自</th>
	 </tr>
	</thead>
	<tbody>
	<s:iterator value="courseVOs" status="stat">
		<tr>
			<td><s:if test='!added'>
				<input type="checkbox" name="ids" value="${id}" />
			</s:if> <s:else>
			已添加
			</s:else></td>
			<td>${courseModelString}</td>				
			<td>${name}</td>
			<td>${serialNo}</td>
			<td>${studylength}</td>
			<td><s:if test="course.offline">线下</s:if><s:else>线上</s:else></td>
			<td>${course.tenant.name}</td>
		</tr>
	</s:iterator>
   </tbody>
</table>
<s:set name="page" value="page3" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
<div class="dr-panel-footer">
  <div class="form-group">
    <label>课程属性：</label>
    <s:select list="#{'2':'必修课','1':'选修课'}" theme="simple" cssClass="form-control input-sm"
			listKey="key" listValue="value" name="courseprop" headerKey=""></s:select>
  </div>
  <div class="row">
  <div class="text-center">
        <button class="btn btn-primary" type="submit" name="Submit32" onclick="return checksel();">
          <span class="glyphicon glyphicon-ok"></span>
                         确认添加
        </button> 
  </div>
  </div>
</div>
</div>
</form>

</body>
</html>
