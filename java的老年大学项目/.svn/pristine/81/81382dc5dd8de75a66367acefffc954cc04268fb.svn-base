<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>优惠规则明细管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include
			file="/common/title.jsp"%></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>

</head>

<script src="${ctx }/js/page/jquery.pagination.js" type="text/javascript"></script>
<link href="${ctx }/js/page/pagination.css" rel="stylesheet" type="text/css" />

<body>
	<!--adminHeader开始-->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--adminHeader结束-->
	<div class="dr-wrapper">
		<!--adminLeft结束-->
		<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
			<jsp:param value="couponlist" name="menu" />
			<jsp:param value="coupon" name="bigmenu" />
		</jsp:include>
		<!--adminLeft结束-->
		<section id="main" role="main">
			<div class="dr-container-fluid">
				<ol class="dr-breadcrumb">
					<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a
						href="#">平台首页</a></li>
					<li><a href="#">优惠码规则管理</a></li>
					<li class="active">优惠规则明细管理</li>
				</ol>
				<div class="dr-page-header">
					<h3>优惠规则明细管理</h3>
				</div>
				<hr>
				<!--信息提示-->
				<div class="alert alert-success alert-dismissable" id="div-success"
					style="display: none">
					<button class="close" type="button" data-dismiss="alert"
						aria-hidden="true">×</button>
					<span id="success"><s:actionmessage theme="simple" /></span>
				</div>
				<div class="alert alert-danger alert-dismissable" id="div-error"
					style="display: none">
					<button class="close" type="button" data-dismiss="alert"
						aria-hidden="true">×</button>
					<span id="error"><s:actionerror theme="simple" /></span>
				</div>
				<!--信息提示 end-->
				<s:if test="nowUser.tenantId==null">
					<!--大门户优惠规则明细看到的 -->
					<ul class="nav nav-tabs nav-justified">
						<li
							class="<s:if test="tabFlag2==null||tabFlag2==''">active</s:if>"><a
							href="manager.action">大平台优惠规则明细 </a></li>
						<li class="<s:if test="tabFlag2=='other'">active</s:if>"><a
							href="manager.action?tabFlag2=other">租户优惠规则明细</a></li>
					</ul>
				</s:if>
				<div class="tab-content dr-tabs-panel">
					<form id="mainForm" name="mainForm" action="manager.action"
						method="post" class="form-inline dr-form-inline"
						enctype="multipart/form-data">
						<input type="hidden" name="page.pageNo" id="pageNo" value="1" /> <input
							type="hidden" name="page.orderBy" id="orderBy"
							value="${page.orderBy}" /> <input type="hidden" name="page.order"
							id="order" value="${page.order}" /> <input type="hidden"
							name="tabFlag2" id="tabFlag2" value="${tabFlag2}" /> <input
							type="hidden" id="sImportNum" name="sucessImportNum"
							value="${sucessImportNum}" /> <input type="hidden"
							id="uImportNum" name="unSucessImportNum"
							value="${unSucessImportNum}" /> <input type="hidden" id="flag"
							name="flag" value="" />
						<security:authorize ifAnyGranted="ROLE_用户管理">
							<div class="dr-searchbar">
								<div id="uploadDiv" style="display: inline;">
									<div class="form-group">
										<label>下载数据文件包样本： <a
											href="${ctx}/template/manager.xls" target="_blank">导入样本.xls</a>
										</label>
									</div>
									<div class="form-group">
										<label>上传数据Excel文件</label> <input type="file" id="upload"
											name="upload" style="display: inline;"
											onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();" />
									</div>
									<div class="form-group">
										<button class="btn btn-primary btn-sm" type="button"
											onclick="checkupload()">
											<span class="glyphicon glyphicon-open"></span>上传
										</button>
									</div>
								</div>
								<div class="form-group ml30" id="uploadResult"
									style="display: none">
									<label>正在上传，请稍等、、、</label>
								</div>

								<div class="form-group ml30" id="errorResult"
									style="display: none">
									&nbsp;&nbsp;&nbsp; <label><a href="${uploadPath}"
										target="_blank">下载导入结果记录excel表格</a></label>
								</div>
								&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label
										id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span
									class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
							</div>
						</security:authorize>
					</form>

					<form name="deleteForm" id="deleteForm" action="manager.action"
						method="post">
						<div class="panel panel-default">
							<div class="btn-toolbar dr-btn-toolbar">
								<span class="fl">
									<button class="btn btn-default btn-sm" type="button"
										id="batchDelDown" name="Submit2">
										<span class="glyphicon glyphicon-trash"></span> 批量删除
									</button>
									<button class="btn btn-primary btn-sm" type="button" rel="rewrite"
										name="Submit3" url="coupon!detailinput.action?cid=$cid"
										onclick="window.location=$(this).attr('url')">
										<span class="glyphicon glyphicon-plus"></span> 新增优惠规则明细
									</button>
								</span>
							</div>
		<script type="text/x-handlebars-template" id="listTemplate">
				{{#each data}}
<tr>
											<td><input type="checkbox" name="ids"
												value="{{coupon_detail_id}}" /></td>
											<td>&nbsp;{{discount_price}}</td>
											<td>&nbsp;{{min_price}}</td>
											<td>&nbsp;{{max_price}}</td>
											<td>&nbsp;{{status_str}}</td>
											<td><a
												href="${ctx}/coupon/manage/coupon!detailmodify.action?id={{coupon_detail_id}}&cid={{coupon_id}}"
												class="btn btn-primary btn-sm"> <span
													class="glyphicon glyphicon-edit"></span>&nbsp;编辑
											</a>

<a
												href="${ctx}/coupon/manage/coupon.action"
												class="btn btn-primary btn-sm"> <span
													class="glyphicon glyphicon-edit"></span>&nbsp;返回规则列表
											</a>

 </td>
										</tr>
				{{/each}}
			</script>
							<table class="table table-bordered dr-table-bordered"
								style="font-size: 14px;">
								<thead>
									<tr>
										<td width="5%" class="tt_noline"><input type="checkbox"
											id="checkboxall" /></td>
										<th width="10%">优惠金额</th>
										<th width="10%">优惠金额起</th>
										<th width="14%">优惠金额止</th>
										<th width="6%">状态</th>
										<s:if test="tabFlag2!='other'">
											<th width="15%">操作</th>
										</s:if>
									</tr>
								</thead>
								<tbody id="list">
									<s:iterator value="page.result" status="stat">
										<tr>
											<td><input type="checkbox" name="ids"
												value="${shopuser_id}" /></td>
											<td>&nbsp;${name}</td>
											<td>&nbsp;${mobile}</td>
											<td>&nbsp;${roleStr}</td>
											<td>&nbsp;${statusStr}</td>

											<td><a
												href="${ctx}//manage/coupon!detailinput.action?id=${shopuser_id}"
												class="btn btn-primary btn-sm"> <span
													class="glyphicon glyphicon-edit"></span>&nbsp;编辑
											</a> </td>

										</tr>
									</s:iterator>
								</tbody>
							</table>
							<%@ include file="/common/turnpage.jsp"%>
							
									<div class="M-box  dr-panel-footer"></div>
							
							
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

<script type="text/javascript">
params.payload.tenant_id='${tenantId}';
var selectids="";
function checkSelect() {
	var flag = false;
	$("input[name='ids']:checked").each(function(){
		flag = true;
		selectids+=$(this).val()+","
	}); 
	return flag;
}

function init(){
	params.payload.coupon_id=api.p('id');
	 $("*[rel='rewrite']").each(function (){
         $(this).attr("url",$(this).attr("url").replace("$cid",params.payload.coupon_id));
         })
	api.loadpage('${ctx}','SellApiWeb/api/manage/couponDetail/couponDetailList.do','listTemplate','list',init)
}

$(function(){
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }
		   else{
		   $("input[name='ids']").removeAttr("checked");
			   } 
	   });
	init();
	
	$("#batchDelDown").click(function (){
		   if(!checkSelect()) {
			   	b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
		   
		   
		   b_confirm('您确定要进行此操作吗?', function() {
		params.payload.coupon_detail_id=selectids;
		api.exec('${ctx}',"SellApiWeb/api/manage/couponDetail/del.do",init)
		   });
	})
});
</script>

</body>
</html>