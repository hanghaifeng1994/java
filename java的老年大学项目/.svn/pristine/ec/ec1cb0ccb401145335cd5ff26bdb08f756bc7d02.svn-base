<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>品牌列表<%@ include file="/common/title.jsp"%></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		if ($("#success").text() != ""){
			$("#div-success").show();
		}
		if ($("#error").text() != "")
			$("#div-error").show();
		$("#checkboxall").click(function() {
			if ($("#checkboxall").attr("checked") == "checked") {
				$("input[name='ids']").attr("checked", $(this).attr("checked"));
			} else {
				$("input[name='ids']").removeAttr("checked");
			}
		});

		$("#batchDelDown").click(function() {
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action = "${ctx }/brand/manage/brand!delete.action";
			if (!checkSelect()) {
				b_alert('没有可操作记录,请勾选');
				return false;
			}

			b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
			});
			//if(!confirm('您确定要进行此操作吗?')) return  false;

			//$("#deleteForm").submit();
			//document.getElementById("deleteForm").action = oaction;
		});
	});

	function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function() {
			flag = true;
		});
		return flag;
	}
</script>
</head>
<body>
	<!--header start-->
	<jsp:include page="/common/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!--header over-->

	<!--正文开始-->
	<div class="dr-wrapper">
		<!--正文左边开始-->
		<jsp:include page="/common/adminLeft.jsp">
			<jsp:param value="brandlist" name="menu" />
			<jsp:param value="brand" name="bigmenu" />
		</jsp:include>
		<!--the end of left-->
		<!--正文右边开始-->
		<section id="main" role="main">

		<div class="dr-container-fluid">
			<ol class="dr-breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span> <a
					href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
				</li>
				<li class="active">品牌管理</li>
			</ol>

			<div class="dr-page-header">
				<h3>品牌列表</h3>
			</div>
			<hr />

			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none;">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="success"><s:actionmessage theme="simple" /></span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none;">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="error"><s:actionerror theme="simple" /></span>
			</div>
			<!--信息提示 end-->

			<div class="tab-content dr-tabs-panel">
				<form class="form-inline dr-form-inline" id="mainForm" name="mainForm"
					action="${ctx}/brand/manage/brand.action" method="post">
					<div class="dr-searchbar">
						<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
						<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
						<input type="hidden" name="page.order" id="order" value="${page.order}" />

						<div class="form-group">
							<label>品牌名称</label>
							<input name="brandName" type="text" class="form-control input-sm" value="${brandName }" />
						</div>
						<div class="form-group">
							<button class="btn btn-default btn-sm"
								onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
								<span class="glyphicon glyphicon-search"></span>
								搜索
							</button>
						</div>
					</div>
				</form>
				<form name="deleteForm" id="deleteForm" action="brand.action" method="post">
					<div class="panel panel-default">
						<div class="btn-toolbar dr-btn-toolbar">
							<div class="btn-group">
								<button class="btn btn-default btn-sm" type="button" name="Submit2" id="batchDelDown">
									<span class="glyphicon glyphicon-trash"></span>
									批量删除
								</button>
							</div>
							<div class="btn-group">
								<button class="btn btn-primary btn-sm" type="button" name="Submit3"
									onclick="window.location='brand!input.action?tabFlag=isMy'">
									<span class="glyphicon glyphicon-plus"></span>
									新增品牌
								</button>
							</div>

						</div>
					</div>
					<table class="table table-bordered dr-table-default">
						<tr>
							<th width="10%">
								<input type="checkbox" id="checkboxall" />
							</th>
							<th width="50%">
								品牌名称
								<!--<i class="dr-sorting-desc"></i>-->
							</th>
							<th width="20%">操作</th>
						</tr>
						<s:iterator value="page.result" status="stat">
							<tr>
								<td>
									<input type="checkbox" name="ids" id="ids" value="${brandId}" />
								</td>
								<td title="${name}">
									<common:cut len="30" string="${name}" />
								</td>
								<td>
								<button class="btn btn-primary btn-sm" type="button" onclick="window.location='${ctx }/brand/manage/brand!input.action?brandId=${brandId}'">
					             <span class="glyphicon glyphicon-edit"></span>
					                                    	编辑
					            </button>
								
								</td>
							</tr>
						</s:iterator>
					</table>
					<%@ include file="/common/turnpage.jsp"%>
			</div>
			</form>
		</div>
	</div>

	<!--footer start-->
	<jsp:include page="/common/adminFooter.jsp">
		<jsp:param value="index" name="menu" />
	</jsp:include>
	<!--footer over-->
	</section>
	<!--正文结束-->
	</div>
	<script>
		jQuery(document).ready(function() {
			TreeView.init();
		});

		$(".expand").mouseover(function() {
			$(this).stop();
			$(this).animate({
				right : 0
			}, 400);
		})
		$(".expand").mouseout(function() {
			$(this).stop();
			$(this).animate({
				right : -400
			}, 400);
		})
	</script>
</body>
</html>