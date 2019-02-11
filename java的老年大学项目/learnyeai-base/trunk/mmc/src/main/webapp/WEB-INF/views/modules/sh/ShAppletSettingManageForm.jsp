<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户方案小程序管理</title>
	<meta name="decorator" content="blank"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/sh/ShAppletSetting/saveApplets" method="post" class="form-horizontal">
		<form:hidden path="mchtId"/>
		<form:hidden path="mchtSchmId"></form:hidden>
		<sys:message content="${message}"/>
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>AppId</th>
								<th>AppSecret</th>
								<th>小程序名称</th>
								<th>小程序标识</th>
								<th>公众号appid</th>
								<th>公众号appsecrete</th>
								<th>公众号名称</th>
								<shiro:hasPermission name="sh:ShAppletSetting:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="dataList">
						</tbody>
						<shiro:hasPermission name="sh:ShAppletSetting:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#dataList', testDataChildRowIdx, testDataChildTpl);testDataChildRowIdx = testDataChildRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
	</form:form>
	<script type="text/template" id="testDataChildTpl">//<!--
						<tr id="dataList{{idx}}">
							<td class="hide">
								<input id="dataList{{idx}}_id" name="appletSettings[{{idx}}].id" type="hidden" value="{{row.appId}}"/>
								<input id="dataList{{idx}}_delFlag" name="appletSettings[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].appId" type="text" value="{{row.appId}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].appSecret" type="text" value="{{row.appSecret}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].appName" type="text" value="{{row.appName}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].appSigns" type="text" value="{{row.appSigns}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].publicNumAppid" type="text" value="{{row.publicNumAppid}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].publicNumAppsecrete" type="text" value="{{row.publicNumAppsecrete}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="dataList{{idx}}_name" name="appletSettings[{{idx}}].publicNumName" type="text" value="{{row.publicNumName}}" maxlength="100" class="input-small "/>
							</td>

							<shiro:hasPermission name="sh:ShAppletSetting:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#dataList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
	</script>
	<script type="text/javascript">
		var testDataChildRowIdx = 0, testDataChildTpl = $("#testDataChildTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
		$(document).ready(function() {
			var data = ${fns:toJson(appletList)};
			for (var i=0; i<data.length; i++){
				addRow('#dataList', testDataChildRowIdx, testDataChildTpl, data[i]);
				testDataChildRowIdx = testDataChildRowIdx + 1;
			}
		});
	</script>
</body>
</html>