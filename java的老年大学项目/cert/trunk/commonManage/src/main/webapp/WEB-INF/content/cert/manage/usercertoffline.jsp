<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<html>
<head>
<title>用户证书查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if>
	<s:else><%@ include file="/common/title.jsp"%></s:else>
</title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" src="${ctx}/js/LodopFuncs.js?v=1.2">
	$
	{
		ctx
	}
</script>
<script type="text/javascript" src="${ctx}/js/certprint.js?v=1.2"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0
		pluginspage="${ctx}/js/install_lodop64.exe"></embed>
</object>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<link href="${ctx}/css/front/layer.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/layer.js" type="text/javascript"></script>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript">
	var random;
	//自定义照片上传
	function ajaxFileUpload() {
		var d = new Date();
		random = d.getTime();
		showLayer('dialog', 'dialog_content', "<span style='text-align:center'><img align='top' alt='正在上传...' src='${ctx}/css/back/image/loading.gif'/></span>");
		$.ajaxFileUpload({
			url : '${certapiurl}/cert/usercertoffline/manage/upload',//用于文件上传的服务器端请求地址
			data : {
				certId : $("#certId").val(),
				random : random
			},
			secureuri : false,//一般设置为false
			fileElementId : 'upload',//文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType : "jsonp", //跨域json请求一定是jsonp
			jsonp : "callback", //跨域请求的参数名，默认是callback
			jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			//dataType: 'json',//返回值类型 一般设置为json
			success : function(data, status) {
				closeLayer();//关闭提示层
				$("#uploadResult").hide();
				isFinishSaveImport();
			},
			error : function(data, status, e) {
				//b_alert(e);
			}
		})
		return false;
	}

	function isFinishSaveImport() {
		$.ajax({
			type : "post", //请求方式
			url : "${certapiurl}/cert/usercertoffline/manage/isFinishSaveImport",
			dataType : "jsonp", //跨域json请求一定是jsonp
			data : {
				random : random
			},
			jsonp : "callback", //跨域请求的参数名，默认是callback
			jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			success : function(data) {
				if (data.finish) {
					$("#uploadResult").hide();
					$("#downResultFile").attr("href", data.fileName);
					$("#errorResult").show();
					$("#importnum").show();
					$('#sucessImport').text(data.sucessImportNum);
					$('#uSucessImport').text(data.unSucessImportNum);
					var obj = document.getElementById('upload');
					obj.outerHTML = obj.outerHTML;
					$("#uploadDiv").show();
					init();
				} else {
					$("#uploadDiv").hide();
					$("#uploadResult").show();
					$("#importnum").show();
					$("#uploadResult").show();
					$('#sucessImport').text(data.sucessImportNum);
					$('#uSucessImport').text(data.unSucessImportNum);
					setTimeout('isFinishSaveImport()', 3000);
				}

			},
			error : function() {
				//请求出错处理

			}
		});
	}

	$(document).ready(function() {
		loadCerts();

		$("#checkboxall").click(function() {
			if ($("#checkboxall").attr("checked") == "checked") {
				$("input[name='ids']").attr("checked", $(this).attr("checked"));
			} else {
				$("input[name='ids']").removeAttr("checked");
			}
		});
		$("#batchPublishDown").click(function() {
			if (!checkSelect()) {
				b_alert("没有可操作记录,请勾选");
				return false;
			}
			var ids = "";
			$("input[name='ids']:checked").each(function() {
				ids += "," + $(this).val();
			});
			ids = ids.substr(1);
			b_confirm('您确定要进行此操作吗?', function() {
				$.ajax({
					type : "post", //请求方式
					url : "${certapiurl}/cert/usercertoffline/manage/publish",
					dataType : "jsonp", //跨域json请求一定是jsonp
					data : {
						ids : ids
					},
					jsonp : "callback", //跨域请求的参数名，默认是callback
					jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
					success : function(data) {
						init();
					},
					error : function() {
						//请求出错处理

					}
				});
			});
		});

		$("#batchUnPublishDown").click(function() {
			if (!checkSelect()) {
				b_alert("没有可操作记录,请勾选");
				return false;
			}
			var ids = "";
			$("input[name='ids']:checked").each(function() {
				ids += "," + $(this).val();
			});
			ids = ids.substr(1);
			b_confirm('您确定要进行此操作吗?', function() {
				$.ajax({
					type : "post", //请求方式
					url : "${certapiurl}/cert/usercertoffline/manage/unpublish",
					dataType : "jsonp", //跨域json请求一定是jsonp
					data : {
						ids : ids
					},
					jsonp : "callback", //跨域请求的参数名，默认是callback
					jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
					success : function(data) {
						init();
					},
					error : function() {
						//请求出错处理

					}
				});
			});
		});

		$("#printedButton").click(function() {
			$("#pagenum").val($('#pageNo').val());
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action = "${ctx }/cert/manage/usercertoffline!printed.action";
			if (!checkSelect()) {
				b_alert("没有可操作记录,请勾选");
				return false;
			}
			b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
			});
		});

		$("#unprintedButton").click(function() {
			$("#pagenum").val($('#pageNo').val());
			var oaction = document.getElementById("deleteForm").action;
			document.getElementById("deleteForm").action = "${ctx }/cert/manage/usercertoffline!unprinted.action";
			if (!checkSelect()) {
				b_alert("没有可操作记录,请勾选");
				return false;
			}
			b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
			});
		});

		$("#genTime01").datetimepicker({
			customFormat : "yyyy-mm-dd",
			format : "yyyy-mm-dd",
			language : 'zh-CN',
			weekStart : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
		});

		$("#genTime02").datetimepicker({
			customFormat : "yyyy-mm-dd",
			format : "yyyy-mm-dd",
			language : 'zh-CN',
			weekStart : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
		});

		if ("${export}" == true || "${export}" == "true") {
			$('#exportbut').hide();
			$('#exporttdbut').hide();
			$('#exportexcelbut').hide();
			checkover();
		}

		if ("${exporttd}" == true || "${exporttd}" == "true") {
			$('#exportbut').hide();
			$('#exporttdbut').hide();
			$('#exportexcelbut').hide();
			checkoverTd();
		}

		if ("${exportExcel}" == true || "${exportExcel}" == "true") {
			$('#exportbut').hide();
			$('#exporttdbut').hide();
			$('#exportexcelbut').hide();
			checkoverExcel();
		}
	});

	function init() {
		$("#checkboxall").removeAttr("checked");
		params.certId = $("#certId02").val();
		params.unit = $("#unit").val();
		params.name = $("#name").val();
		params.mobilePhone = $("#mobilePhone").val();
		params.certno = $("#certno").val();
		params.startTime = $("#startTime").val();
		params.endTime = $("#endTime").val();
		params.published = $("#published").val();
		api.loadpage('${certapiurl}/cert/usercertoffline/manage/list', 'listTemplate', 'list', init);
	}

	function loadCerts() {
		$.ajax({
			type : "post", //请求方式
			url : "${certapiurl}/cert/certoffline/manage/certlist",
			dataType : "jsonp", //跨域json请求一定是jsonp
			jsonp : "callback", //跨域请求的参数名，默认是callback
			jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			success : function(data) {
				$.each(data, function(i, v) {
					$("#certId").append("<option value=\""+v.id+"\">" + v.name + "</option");
					$("#certId02").append("<option value=\""+v.id+"\">" + v.name + "</option");
				});
				init();
			},
			error : function() {
				//请求出错处理

			}
		});
	}

	function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function() {
			flag = true;
		});
		return flag;
	}

	function downLoadPicture(id) {
		//文件导出中不在响应
		var form = $("<form id=\"downLoadPicture\">");
		form.attr("style", "display:none");
		form.attr("target", "");
		form.attr("method", "post");
		form.attr("action", "${certapiurl}/cert/usercertoffline/downloadUserCertOffline");
		var usercertId = $("<input />");
		usercertId.attr("type", "hidden");
		usercertId.attr("name", "id");
		usercertId.attr("value", id);
		form.append(usercertId);
		$("body").append(form);
		form.submit();
		$("#downLoadPicture").remove();
		//timer =  window.setInterval("isFinsh()",1000);
	}

	function download(id) {
		//alert($("#downloadcert_"+id).attr("href"));
		$("#downloadcert_" + id).attr("href", $("#downloadcert_" + id).attr("href") + "1");
		//alert($("#downloadcert_"+id).attr("href"));	
	}

	function printeds() {
		b_confirm('您确定要按查询条件更新导出状态吗?', function() {
			var ids = ""
			$("input[name='ids']:checked").each(function() {
				ids += "," + $(this).val();
			});
			if (ids != "")
				ids = ids.substr(1);
			$("#usercertids").val(ids);
			$('#printedStatus').val('1');
			$('#exportExcel').val('false');
			$('#export').val('false');
			document.mainForm.submit();
		});
	}

	function exportexcel() {
		var ids = ""
		$("input[name='ids']:checked").each(function() {
			ids += "," + $(this).val();
		});
		if (ids != "")
			ids = ids.substr(1);
		$("#usercertids").val(ids);
		$('#export').val('true');
		$('#exportExcel').val('false');
		$('#exporttd').val('false');
		document.mainForm.submit();
	}

	function exportexcel2() {
		var ids = ""
		$("input[name='ids']:checked").each(function() {
			ids += "," + $(this).val();
		});
		if (ids != "")
			ids = ids.substr(1);
		$("#usercertids").val(ids);
		$('#exportExcel').val('true');
		$('#export').val('false');
		$('#exporttd').val('false');
		document.mainForm.submit();
	}

	function exportexcel3() {
		var ids = ""
		$("input[name='ids']:checked").each(function() {
			ids += "," + $(this).val();
		});
		if (ids != "")
			ids = ids.substr(1);
		$("#usercertids").val(ids);
		$('#exporttd').val('true');
		$('#export').val('false');
		$('#exportExcel').val('false');
		document.mainForm.submit();
	}
	function checkover() {
		$.ajax({
			type : "POST",
			url : "usercert!isFinishExport.action",
			data : {
				"threadName" : '${threadName}',
				"fileName" : '${fileName}'
			},
			dataType : "json",
			success : function(data) {
				if (data.value == "false") {
					$('#downLoad').show();
					$('#d1').show();
					$('#d1').attr("href", "${ctx}/cert/manage/usercert!downloadUserCert.action?fileName=" + data.label + ".pdf");
					$('#font').hide();
					$('#exportbut').show();
					$('#exporttdbut').show();
					$('#exportexcelbut').show();
				} else {
					setTimeout('checkover()', 3000);
				}
			}
		});
	}

	function checkoverExcel() {
		$.ajax({
			type : "POST",
			url : "usercert!isFinishExportExcel.action",
			data : {
				"threadName" : '${threadName}',
				"fileName" : '${fileName}'
			},
			dataType : "json",
			success : function(data) {
				if (data.value == "false") {
					$('#downLoad').show();
					$('#d2').show();
					$('#d2').attr("href", "${ctx}/cert/manage/usercert!downloadUserCert.action?fileName=" + data.label + ".xls");
					$('#font').hide();
					$('#exportbut').show();
					$('#exporttdbut').show();
					$('#exportexcelbut').show();
				} else {
					setTimeout('checkoverExcel()', 3000);
				}
			}
		});
	}

	function checkoverTd() {
		$.ajax({
			type : "POST",
			url : "usercert!isFinishExport.action",
			data : {
				"threadName" : '${threadName}',
				"fileName" : '${fileName}'
			},
			dataType : "json",
			success : function(data) {
				if (data.value == "false") {
					$('#downLoad').show();
					$('#d3').show();
					$('#d3').attr("href", "${ctx}/cert/manage/usercert!downloadUserCert.action?fileName=" + data.label + ".pdf");
					$('#font').hide();
					$('#exportbut').show();
					$('#exporttdbut').show();
					$('#exportexcelbut').show();
				} else {
					setTimeout('checkoverTd()', 3000);
				}
			}
		});
	}

	function checkupload() {
		var upload = $("#upload").val();
		var certId = $("#certId").val();
		if (certId == "" || certId == null) {
			b_alert("请选择证书！");
		} else if (upload == "" || upload == null) {
			b_alert("上传文件不能为空！");
		} else {
			ajaxFileUpload();
		}
	}
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
		<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
			<jsp:param value="usercertoffline" name="menu" />
			<jsp:param value="programs" name="bigmenu" />
		</jsp:include>
		<!--adminLeft结束-->

		<section id="main" role="main">
		<div class="dr-container-fluid">
			<ol class="dr-breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a>
				</li>
				<li><a href="#" class="grey">培训项目管理</a>
				</li>
				<li class="active">用户证书查询</li>
			</ol>
			<div class="dr-page-header">
				<h3>用户证书查询</h3>
			</div>
			<hr />
			<!--信息提示-->
			<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="success">
					<s:actionmessage theme="simple" />
				</span>
			</div>
			<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
				<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
				<span id="error">
					<s:actionerror theme="simple" />
				</span>
			</div>
			<!--信息提示 end-->
			<form id="uploadForm" class="form-inline dr-form-inline mt10 ml5 mr5"
				action="${ctx }/cert/manage/usercertoffline.action" method="post" enctype="multipart/form-data">
				<div class="dr-searchbar">
					<div class="form-group">
						<label>
							下载数据文件包样本： <a href="${ctx}/template/usercertoffline.xls" target="_blank">导入样本.xls</a>
						</label>
					</div>
					<div class="form-group">
						<label>证书</label>
						<select name="certId" style="width: 150px; height: 30px;" id="certId"></select>
					</div>
					<div class="form-group">
						<label>上传数据Excel文件</label>
						<input type="file" id="upload" name="upload" style="display: inline;"
							onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();" />
					</div>
					<div class="form-group" id="uploadDiv">
						<button class="btn btn-primary btn-sm" type="button" id="Submit32" onclick="checkupload()">
							<span class="glyphicon glyphicon-open"></span>
							上传
						</button>
					</div>
					<div class="form-group ml30" id="uploadResult" style="display: none">
						<label>正在上传，请稍等、、、</label>
					</div>
					<div class="form-group ml30" id="errorResult" style="display: none">
						&nbsp;&nbsp;&nbsp;
						<label>
							<a href="" target="_blank" id="downResultFile">下载导入结果记录excel表格</a>
						</label>
					</div>
					&nbsp;&nbsp;
					<span id="importnum" style="display: none">
						<span>
							成功导入数据：
							<label id="sucessImport"></label>
						</span>
						&nbsp;&nbsp;
						<span class="ml10">
							未成功导入数据：
							<label id="uSucessImport"></label>
						</span>
					</span>
				</div>
			</form>
			<form id="mainForm" name="mainForm" action="${ctx}/cert/manage/usercertoffline.action"
				method="post" class="form-inline dr-form-inline">
				<div class="dr-searchbar">
					<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
					<input type="hidden" id="ctx" value="${ctx}" />
					<input type="hidden" name="export" id="export" />
					<input type="hidden" name="exporttd" id="exporttd" />
					<input type="hidden" name="exportExcel" id="exportExcel" />
					<input type="hidden" name="printedStatus" id="printedStatus" />
					<input type="hidden" name="usercertids" id="usercertids" value="" />
					<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}" />
					<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}" />
					<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}" />
					<input type="hidden" name="fileName" value="${fileName}" />

					<div class="form-group">
						<label>证书</label>
						<select name="certId" style="width: 150px; height: 30px;" id="certId02">
							<option value="">--全部--</option>
						</select>
					</div>
					<div class="form-group">
						<label class="control-label"> 生成时间 </label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime01">
							<input type="text" name="filter_GED_genTime" id="startTime" readonly="readonly"
								class="form-control input-sm" style="width:100%;" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-remove"></span>
							</span>
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">-</label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime02">
							<input type="text" name="filter_LED_genTime" id="endTime" readonly="readonly"
								class="form-control input-sm" style="width:100%;" />
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-remove"></span>
							</span>
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label>单位</label>
						<input name="unit" id="unit" class="form-control input-sm" />
					</div>
					<div class="form-group">
						<label>姓名</label>
						<input name="name" id="name" class="form-control input-sm" />
					</div>
					<div class="form-group">
						<label>手机号</label>
						<input name="mobilePhone" id="mobilePhone" class="form-control input-sm" />
					</div>
					<div class="form-group">
						<label>证书编号 </label>
						<input name="certno" id="certno" class="form-control input-sm" />
					</div>

					<div class="form-group">
						<label>发布状态</label>
						<s:select list="#{'已发布':'true','未发布':'false'}" listKey="value" name="filter_EQB_published"
							id="published" listValue="key" headerKey="" headerValue="全部" theme="simple"
							cssClass="form-control input-sm"></s:select>
					</div>
					<div class="form-group">
						<button name="Submit5" type="button"
							onclick="$('#pageNo').val('1');$('#exportExcel').val('false');$('#export').val('false');init();"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-search"></span>
							&nbsp;搜索
						</button>
					</div>
					<div class="form-group">
						<span style="font-size: 12px;">
							<span id="font"
								style="<s:if test="export||exportExcel"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
							<label class="ml10" id="downLoad" style="display: none">
								<a href="#" target="_blank" id="d1" download="abc.pdf" style="display: none;">用户证书pdf文件下载</a><a
									href="#" target="_blank" id="d3" download="abc.pdf" style="display: none;">套打证书pdf文件下载</a>
							</label>
						</span>
					</div>
				</div>
			</form>


			<form name="deleteForm" id="deleteForm" action="usercertoffline!delete.action" method="post">
				<div class="panel panel-default">
					<div class="btn-toolbar dr-btn-toolbar">
						<div class="btn-group">
							<button name="Submit22" type="button" id="batchPublishDown" class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-bullhorn"></span>
								&nbsp;批量发布
							</button>
						</div>
						<div class="btn-group">
							<button name="Submit23" type="button" id="batchUnPublishDown" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-bullhorn"></span>
								&nbsp;批量取消发布
							</button>
						</div>
					</div>
					<!-- 
<input name="Submit3" type="button" class="operation_btu1" value="发布课程" id="batchpublicDown" /> 
<input name="Submit3" type="button"	class="operation_btu2" value="取消发布" id="batchUnpublicDown" />
-->

					<table class="table table-bordered dr-table-bordered">
						<thead>
							<tr>
								<th width="3%">
									<input type="checkbox" id="checkboxall" />
								</th>
								<th width="8%">工作单位</th>
								<th width="8%">姓名</th>
								<th width="8%">手机号码</th>
								<th width="8%">证书编号</th>
								<th width="8%">身份证号码</th>
								<th width="8%">是否发布</th>
								<th width="12%">操作</th>
							</tr>
						</thead>
						<tbody id="list">
						</tbody>
					</table>
					<div class="M-box dr-panel-footer"></div>
				</div>
			</form>

		</div>
		<!--footer start--> <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
			<jsp:param value="index" name="menu" />
		</jsp:include> <!--footer over--> </section>
	</div>

	<script type="text/x-handlebars-template" id="listTemplate">
		 {{#if result}}	
			{{#each result}}
				<tr>
   		<td><input type="checkbox" name="ids" id="ids" value="{{id}}"/></td>
   		<td>{{unit}}</td>
   		<td>{{name}}</td>
   		<td>{{mobilePhone}}</td>
   		<td>{{certno}}</td>
   		<td>{{idcard}}</td>
   		<td>{{publishStr}}</td>
   		<td>
			<a class="btn btn-primary btn-sm" onclick="downLoadPicture({{id}})"  type="button">
					<span class="glyphicon glyphicon-eye-open"></span>
					下载证书
			</a>
   		</td>
   	</tr>
		{{/each}}
		{{/if}}
			</script>
</body>
</html>