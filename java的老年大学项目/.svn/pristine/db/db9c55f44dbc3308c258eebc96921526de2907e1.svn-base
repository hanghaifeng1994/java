<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url.inner"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<link href="${staticurl}/css/admin_change.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    $(document).ready(function(){
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
		});
		
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!delete.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
				  // $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
			 }); 	
	   $("#batchpublicDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!publish.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
			 }); 	

	   $("#batchUnpublicDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!unpublish.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				   //$("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
			 }); 	
		 
    });
    
	function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
     
    function addtutor(){
     	var ids = "";//取得用户选择的辅导老师用户id集合字符串,","号分隔
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			ids +=","+$(this).val();
		}); 
		parent.ajaxAddTutors(ids);
     }

     function closewindow(){
      	var ids = "";//取得用户选择的辅导老师用户id集合字符串,","号分隔
 		parent.closewindow();
     }
</script>
</head>
<body>
<!--正文开始-->
<div>
<section id="main" role="main">
<div style="background-color:#f5f5f5; padding:10px;box-shadow: 0 -8px 6px 4px rgba(0, 0, 0, 0.2);">
<div class="dr-form-title clearfix" style="padding: 5px 0px;">
<div class="col-md-12">
<h4 class="text-primary">请从辅导老师列表中选择</h4>
</div>
</div>


  <!--查询条件 -->
  <div class="dr-searchbar">
  <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/product/manage/tutor!tutorUsers.action" method="post">
  <input type="hidden" name="page.pageNo" id="pageNo" value="1"/>
  <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
  <input type="hidden" name="page.order" id="order" value="${page.order}"/>
  <input type="hidden" name="id" id="order" value="${id}"/>
  <input type="hidden" name="tenantId" value="${tenantId}"/>
  <input type="hidden" name="tutorUserIds" value="${tutorUserIds}"/>

      <div class="form-group" style="width: 200px;display: inline">
       <label>姓名</label>
       <input style="display: inline" name="name" type="text" class="form-control input-sm" value="${name}"/>
      </div>

      <div class="form-group"  style="width: 250px;display: inline">
       <label> 用户名 </label>
       <input style="display: inline" name="username" type="text" class="form-control input-sm" value="${username}"/>
      </div>

      <div class="form-group" style="display: inline">
        <button name="Submit" class="btn btn-default btn-sm" type="submit">
        <span class="glyphicon glyphicon-search"></span>
                       搜索
        </button>
      </div>

  </form>
</div>
<div class="tab-content dr-tabs-panel">
<form name="deleteForm" id="deleteForm" action="${ctx}/product/manage/tutor!tutorUsers.action" method="post">
<input type="hidden" name="tenantId" value="${tenantId}"/>

  <table class="table table-bordered dr-table-default">
    <tr>
      <th width="10%">
      <input type="checkbox" id="checkboxall" />全选</th>
      <th>用户名</th>
      <th>姓名</th>
      <th>身份证</th>
      <th>单位</th>
    </tr>
    <s:iterator value="page.result">
    <tr>
      <td>
      <s:if test="!checked">
      <input type="checkbox" name="ids" id="ids_${userDTO.id}"	value="${userDTO.id}" />
      </s:if>
      <s:else>
    	  已选
      </s:else>
      </td>
      <td>${userDTO.username}</td>
      <td>${userDTO.name}</td>
      <td>${userDTO.idcard}</td>
      <td title="${userDTO.unit }"><common:cut len="20" string="${userDTO.unit}" /></td>
    </tr>
    </s:iterator>
  </table>
  <!--   -->
  <div class="dr-panel-footer"> 
  <%@ include file="/common/turnpage.jsp"%>
  </div>
  <div class="operation_list0">
  
    <center>
     <div class="btn-group">
        <button name="Submit32" class="btn btn-primary btn-sm" type="button" onclick="addtutor();">
        <span class="glyphicon glyphicon-plus"></span>
                      确认添加
        </button>
      </div>
      <div class="btn-group">
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="closewindow();">
        <span class="glyphicon glyphicon-remove-circle"></span>
                      取 消
        </button>
      </div>      
    </center>
    </div>
    </form>
  </div>  
  </div>
  </section>
</div>
<!--正文结束-->
</body>
</html>
