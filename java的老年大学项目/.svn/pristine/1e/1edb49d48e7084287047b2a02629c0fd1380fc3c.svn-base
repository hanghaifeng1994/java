<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>批量导入书籍<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
    
	$("#inputForm").validate({
		rules: {
			uploadProduct: {
				required: true
			}
		},
		messages: {
			uploadProduct: {
				required: "请选择导入文件包"
			}
		},
		errorPlacement: function(error, element) {
			if (document.getElementById("error_" + element.attr("name"))) {
				error.appendTo("#error_" + element.attr("name"));
			} else error.insertAfter(element);
		},
		errorElement: "strong"
	});

})
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="product-import" name="menu" />
	<jsp:param value="product" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">书籍管理</a>
</li>
<li class="active">批量导入书籍</li>
</ol>

<div class="dr-page-header">
<h3>
批量导入书籍
</h3>
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
<form class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="product-import!save.action" method="post" enctype="multipart/form-data">
<div class="panel panel-default">

    <div>
    <div class="col-md-12">
    <h5 class="text-primary">上传批量书籍文件包,书籍类别对应的一级分类必须已经存在分别为（开放书籍、选修书籍、必修书籍）</h5>
    </div>
    </div>

<div class="dr-page-header" style="padding: 5px 18px;">
   下载数据文件包样本：<a class="btn btn-primary btn-sm" type="button" href="${ctx}/template/couseimport.xls" target="_blank"><span class="glyphicon glyphicon-save"></span>&nbsp;导入样本.xls</a>

</div>
    <div class="form-group">
      <label class="col-md-2 control-label" style="float: left;">选择文件<span class="text-danger">*</span></label>
      <div class="col-md-10 mt10">
      <input type="file" id="uploadProduct" name="uploadProduct" class="wjy" style="float: left;"/><span class="admin_woring_x" id="error_uploadProduct"></span>
      <button class="btn btn-primary btn-sm" type="submit">
      <span class="glyphicon glyphicon-open"></span>
		上 传
		</button>
     
      </div>
    </div>
</div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->
</body>
</html>
