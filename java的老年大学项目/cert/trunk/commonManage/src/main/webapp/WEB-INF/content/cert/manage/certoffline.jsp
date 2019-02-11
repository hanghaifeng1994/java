<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>证书管理</title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		if ($("#success").text() != "")
			$("#div-success").show();
		if ($("#error").text() != "")
			$("#div-error").show();
			
		$("#checkboxall").click(function() {
			if ($("#checkboxall").attr("checked") == "checked") {
				$("input[name='ids']").attr("checked", $(this).attr("checked"));
			} else {
				$("input[name='ids']").removeAttr("checked");
			}
		});

		//验证批量删除文章的列表非空与否
		$("#batchDelDown").click(function() {
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action = "${ctx }/cert/manage/certoffline!delete.action";
			if (!checkSelect()) {
				b_alert("没有可操作记录,请勾选");
				return false;
			}
			b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
			});
		});
		
		init();
	});
	
	function delCert(id){
		b_confirm('您确定要进行此操作吗?', function() {
			$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certoffline/manage/del",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"ids":id
			    },    //请求参数
			    success: function(data) {
			    	location.href="${ctx}/cert/manage/certoffline.action";
			    },
			    error: function() {
			        //请求出错处理
			    }
			});			
		});
	}
	
	function init(){
		api.loadpage('${certapiurl}/cert/certoffline/manage/list','listTemplate','list', init);
	} 
	
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
	<!-- navbar start -->
	<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
		<jsp:param value="" name="menu" />
	</jsp:include>
	<!-- navbar end -->

	<!-- container start -->
	<div class="dr-wrapper">
		<!-- sidebar start -->
		<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
			<jsp:param value="certofflinelist" name="menu" />
			<jsp:param value="programs" name="bigmenu" />
		</jsp:include>
		<!-- sidebar end -->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<!--breadcrumb-->
			<ol class="dr-breadcrumb" style="">
				<li><span class="glyphicon glyphicon-home"></span> <a
					href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a></li>
				<li class="active"><span>证书管理</span>
				</li>
			</ol>
			<!--/breadcrumb-->
			<!--页面标题-->
			<div class="dr-page-header">
				<h3>
					证书列表<small>&nbsp;</small>
				</h3>
			</div>
			<hr></hr>
			<!--页面标题end-->
			<div class="panel panel-default">
				<div class="btn-toolbar dr-btn-toolbar">
					<div class="btn-group">
						<button name="Submit3" class="btn btn-primary btn-sm" type="button"
							onclick="window.location='certoffline!input.action'">
							<span class="glyphicon glyphicon-plus"></span>
							&nbsp;新增证书
						</button>
					</div>
				</div>
				<table class="table table-bordered dr-table-bordered">
					<thead>
						<tr>
							<th>证书名称</th>
							<th>证书编码</th>
							<th>证书模板名称</th>
							<th>发证单位</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="list">
					</tbody>
				</table>
				<div class="M-box dr-panel-footer"></div>
			</div>
		</div>
		<!--footer start--> 
		<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> <!--footer over--> </section>
	</div>
	<!-- container end -->
	
	<script type="text/x-handlebars-template" id="listTemplate">
			{{#if result}}	
			{{#each result}}
				<tr>
					<td class="white_bg">{{name}}</td>
					<td class="white_bg">{{code}}</td>			
					<td class="white_bg">{{certTemplateName}}</td>
					<td class="white_bg">{{unit}}</td>
					<td class="white_bg">
					<a class="btn btn-primary btn-sm" href="certoffline!input.action?id={{id}}&typeId={{typeId}}"  type="button">
					<span class="glyphicon glyphicon-edit"></span>
					编辑
					</a>
					<a class="btn btn-default btn-sm"  type="button" onclick="delCert({{id }});">
					<span class="glyphicon glyphicon-trash"></span>
					删除
					</a>
					</td>
				</tr>
			{{/each}}
			{{/if}}
			</script>
</body>
</html>