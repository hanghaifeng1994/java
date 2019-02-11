<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<!--<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
-->
<%@ include file="/common/admin_meta.jsp"%>

<script>  
	$(document).ready(function() {
 	});
</script>

</head>

<body>
<!--正文开始-->
<div class="dr-wrapper">
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">

<div class="panel panel-default">
<form id="form1" action="<s:if test="isIssue">course!courseIssued.action</s:if><s:else>course!cancelIssued.action</s:else>" method="post" class="form-horizontal dr-form-bordered" role="form">
<input type="hidden" name="courseIds" value="${courseIds}" />
<input type="hidden" name="tabFlag" value="${tabFlag}" />
<input type="hidden" name="isIssue" value="${isIssue}" />
<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">选择租户</h4>
</div>
</div>
<div class="form-group" id="validate_finishedneed">
    <s:iterator value="tenantCheckedVOs">
        <div class="checkbox ml10 col-md-10">
          <label>
         <input type="checkbox" <s:if test='isChecked'>checked="checked"</s:if> name="ids" id="ids"	value="${tenantDTO.id}" />
             ${tenantDTO.name}
          </label>
        </div>     
  		<div>
  		</div>
    </s:iterator>
 </div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">
    <div class="btn-group">
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>
        	确定
        </button>
    </div>
    <div class="btn-group">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='course.action?tabFlag=isMy'">
        <span class="glyphicon glyphicon-remove"></span>
                                取消
        </button>
    </div>
</div>
</div>
</div>
</form>
</div>
</div>
</section>
</div>
<!--正文结束-->
</body>
</html>
