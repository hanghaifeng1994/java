<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">   
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
	   $("#batchDelDown").click(function(){
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action="${ctx }/cert/manage/cert!delete.action";
			if(!checkSelect()) {
			        b_alert("没有可操作记录,请勾选");
			        return false;
			} 
			   b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	   	   	   });
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
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="certlist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
		</li>
		<li>
		<a href="#">培训项目管理</a>
		</li>
		<li class="active"><span>证书列表</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>证书列表<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
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
    <!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
		<form id="mainForm" name="mainForm" action="cert.action" method="post" class="form-inline dr-form-inline">
			<input type="hidden" name="page.pageNo" id="pageNo" value="1"/>
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/>
			<input type="hidden" name="page.order" id="order" value="${page.order}"/>
			
		</form>		
    <!--列表-->
    		<form name="deleteForm" id="deleteForm" action="cert.action" method="post" class="form-inline dr-form-inline">
    	    <div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group">
				<button  name="Submit22" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
                </button>
				</div>
				<div class="btn-group">
				<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="window.location='cert!input.action'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增证书
                </button>
				</div>
			</div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<td ><input type="checkbox" id="checkboxall" /></td>
					<th>证书名称</th>
					<th>证书编码</th>
					<th>证书模板名称</th>		
					<th>发证单位</th>
					<s:if test="nowUser.super"><th width="20%">来自</th></s:if>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
				<tr>
					<td class="white_bg"><input type="checkbox" name="ids" value="${id}" /></td>
					<td class="white_bg">${name}</td>
					<td class="white_bg">${code}</td>			
					<td class="white_bg">${certTemplateName}</td>
					<td class="white_bg">${unit}</td>
					<s:if test="nowUser.super"><td >${tenantName}</td></s:if>
					<td class="white_bg">
					<a class="btn btn-primary btn-sm" href="cert!input.action?id=${id}&typeId=${typeId}"  type="button">
					<span class="glyphicon glyphicon-edit"></span>
					编辑
					</a>
					<a class="btn btn-default btn-sm"  type="button" onclick="delRecord('cert!delete.action?ids=${id }');">
					<span class="glyphicon glyphicon-trash"></span>
					删除
					</a>
					</td>
				</tr>
				</s:iterator>
				</tbody>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
  		     </div>
			</form>
    <!--订单列表end-->
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
	</section>
</div>
<!-- container end -->
</body>
</html>