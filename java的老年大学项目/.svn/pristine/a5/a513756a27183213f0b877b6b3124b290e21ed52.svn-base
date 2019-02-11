<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息栏目分类管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">   
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
})
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
		<jsp:param value="module" name="menu" />
		<jsp:param value="system" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
			<li><span class="glyphicon glyphicon-home"></span><a href="#">平台首页</a></li>
			<li class="active"><span>功能模块设置</span></li>
		</ol>
        <div class="dr-page-header">
            <h3>功能模块设置<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
		<!--信息提示-->
		<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
			<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
			<span id="success"><s:actionmessage  theme="simple"/></span>
		</div>
		<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
			<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
			<span id="error"><s:actionerror theme="simple"/></span>
		</div>
		<div class="tab-content dr-tabs-panel">
			<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="moduleconfig.action" method="post">
		 		<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
		    	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
		     	<input type="hidden" name="page.order" id="order" value="${page.order}" /> 
		     	<input type="hidden" name="parentId" id="parentId" value="${parentId}" />
      
			  	<%-- <div class="dr-searchbar">
					<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id" headerValue="--大平台--" headerKey="" value="tenantId" listValue="name" theme="simple" cssClass="form-control" name="tenantId" id="tenantId"></s:select>
					</div>
					<div class="form-group">
						<button class="btn btn-default btn-sm" type="submit">
							<span class="glyphicon glyphicon-search"></span>
				 			搜索
						</button>
					</div>
			  	</div> --%>
			</form>
	
			<form name="deleteForm" id="deleteForm" action="moduleconfig.action" method="post">
			    <div class="panel panel-default">
		    		<!-- <div class="btn-toolbar dr-btn-toolbar">
			    		<div class="btn-group">
							<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="addModule();">
			                	<span class="glyphicon glyphicon-plus"></span>&nbsp;新增
			                </button>
						</div>
			    	</div> -->
			    	
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="20%">租户</th>
					<th width="30%">操作</th>
				</tr>
				</thead>
				<tbody>
				<tr>
			      <td>大平台</td>
			      <td>
			      <a href="${ctx}/module/manage/moduleconfig!input.action?tenantId=" class="btn btn-primary btn-sm">
			      <span class="glyphicon glyphicon-edit"></span>&nbsp;功能模块配置</a>
			      </td>
			    </tr>
			    <s:iterator value="page.result" status="stat" >
			    <tr>
			      <td>${logo}</td>
			      <td>
			      <a href="${ctx}/module/manage/moduleconfig!input.action?tenantId=${id}" class="btn btn-primary btn-sm">
			      <span class="glyphicon glyphicon-edit"></span>&nbsp;功能模块配置</a>
			      </td>
			    </tr>
			    </s:iterator> 
				</tbody>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
			</div>
			</form>
		</div>
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




<script>
	function addModule(){
		var tenantId = $("#tenantId").val();
		window.location='moduleconfig!input.action?tenantId='+tenantId;
	}
</script>

</body>
</html>