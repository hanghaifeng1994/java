<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
 <%@ include file="/common/admin_meta.jsp" %>
<script type="text/javascript">
    $(document).ready(function(){   
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();   
		 
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
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

<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="authoritylist" name="menu" />
	<jsp:param value="student" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">权限管理</a></li>
     <li class="active">权限列表</li>
    </ol>
   <div class="dr-page-header">
     <h3>权限列表</h3>
   </div>
   <hr>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->

<form id="mainForm" name="mainForm" action="authority.action" method="post" class="form-inline dr-form-inline">
    <input type="hidden" name="page.pageNo" id="pageNo" value="1" /> 
    <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
    <input type="hidden" name="page.order" id="order" value="${page.order}" />
</form>

<form name="deleteForm" id="deleteForm" action="authority!delete.action" method="post">
 <div class="panel panel-default">
     <div class="btn-toolbar dr-btn-toolbar">
       <span class="fl">
        <button class="btn btn-primary btn-sm" type="button"  name="Submit3" onclick="window.location='authority!input.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增权限
        </button>
        </span>
        <s:if test="parentId != null">
	   <button class="btn btn-primary btn-sm" type="button" id="batchDelDown" name="Submit3" onclick="window.location.href='authority!reback.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-backward"></span>返回上级区划</button>
	</s:if>
    </div> 

  <table class="table table-bordered dr-table-bordered">

    <tr>
      <th width="17%" class="tt_line">名称</th>
      <th width="12%" class="tt_line">是否开放</th>
      <th width="12%" class="tt_line">操作</th>
    </tr>

    <s:iterator value="page.result" status="stat">
    <tr>
      <td class="white_bg">${name}</td>
      <td class="white_bg"><s:if test="opened==true">是</s:if><s:else>否</s:else></td>
      <td class="white_bg">
       <a href="authority!input.action?id=${id }&parentId=${parentId}" class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
       <a href="authority!delete.action?id=${id}&parentId=${parentId}" class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
      <a href="authority.action?parentId=${id}" class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-forward"></span>&nbsp;管理下级权限</a>

      </td>
    </tr>
    </s:iterator>
  </table>
  <%@ include file="/common/turnpage.jsp"%> 
</div>
</form>
</div>
    <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	</jsp:include>
</section>
</div>
</body>
</html>
