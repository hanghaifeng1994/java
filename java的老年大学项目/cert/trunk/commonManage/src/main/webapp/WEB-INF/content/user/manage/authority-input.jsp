<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>

<html>
 <head>
    <title>权限管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
    <%@ include file="/common/admin_meta.jsp" %>
	<script>
		$(document).ready(function() { 

			//聚焦第一个输入框
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name: {
						required: true,
						maxlength:10
					}
				},
				messages: {
					name:{
						required:"请输入名称",
						maxlength:"字数小于10位"
					}
			
				},
				errorPlacement: function(error, element) {   
			        if (document.getElementById("error_"+element.attr("name")))  {
			            error.appendTo("#error_"+element.attr("name"));  
			        }
			        else       
			            error.insertAfter(element);   
			    }				
			});

		});
	</script>
	
</head>
<body>	

<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="authoritylist" name="menu" />
	<jsp:param value="manager" name="bigmenu" />
    </jsp:include>
   <!--adminLeft结束-->  
 
  <section id="main" role="main">
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">权限管理</a></li>
     <li class="active">
       <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>权限
     </li>
    </ol>
    
   <div class="dr-page-header">
     <h3> 
      <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>权限
     </h3>
   </div>
   <hr/>

<div class="panel panel-default">
<form id="inputForm" name="inputForm" action="authority!save.action" method="post" class="form-horizontal dr-form-bordered">
    <input id="id" name="id" type="hidden" value="${id}" size="30"/>
    <input id="parentId" name="parentId" type="hidden" value="${parentId}" size="30"/>
    <div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">      
	       <s:if test="id == null">新增</s:if>
           <s:else>编辑</s:else>权限</h4>
	  </div>
	</div>
    
   <div class="form-group" id="validate_name">
    <label class="col-md-3 control-label">名称<span class="admin_red">*</span></label>
    <div class="col-md-3">
       <input id="name" name="name" value="${name}" type="text" class="form-control" />
    </div>
    <span id="error_name" class="help-block"></span>
  </div>
  
    <div class="form-group">
    <label class="col-md-3 control-label">是否开放<span class="admin_red">*</span></label>
    <div class="col-md-3"><div style="float: left;">
    <s:radio list="#{true:'是',false:'否'}" value="opened"  name="opened" theme="simple" ></s:radio>
    </div></div>
  </div>

   <div class="panel-footer">
   <div class="row">
    <div class="col-md-offset-3 col-md-10">
	 <button class="btn btn-primary"  name="Submit32" type="submit">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     <button class="btn btn-default" onclick="window.location.href='authority.action?parentId=${parentId }&rnd=${rnd}'" type="button">
       <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
     </button>
     </div>
      </div>
     </div>
 
</form>
</div>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->

</section>
</div>
</body>
</html>