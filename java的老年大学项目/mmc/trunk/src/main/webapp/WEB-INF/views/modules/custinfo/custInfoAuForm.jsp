<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户信息管理</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/fileupload/js/vendor/jquery.ui.widget.js"></script>
	<script src="${ctxStatic}/fileupload/js/jquery.iframe-transport.js"></script>
	<script src="${ctxStatic}/fileupload/js/jquery.fileupload.js"></script>
	<link href="${ctxStatic}/zhisou/zsWidget.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/zhisou/nojs.js" type="text/javascript"></script>
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/custinfo/custInfo/auList">客户待审核列表</a></li>
		<li class="active"><a href="${ctx}/custinfo/custInfo/auForm?id=${custInfo.id}">客户审核信息
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="custInfo" action="${ctx}/custinfo/custInfo/audit" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<img class="preview single_img" src="${resourcePath}/${custInfo.photo}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="custName" readonly="true" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户类型：</label>
			<div class="controls">
				<input readonly="readonly" type="text" maxlength="200" class="input-xlarge " value="${fns:getConsLabel('CUST_TYPE',custInfo.custType,'')}" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<input readonly="readonly" id ="idCardNum"  name="idCardNum" value="${custExt.idCardNum}"  class="input-xlarge" type="text" maxlength="20"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证正面照:</label>
			<div class="controls">
				<img class="preview single_img" src="${resourcePath}/${custExt.idCardImg}">
				<%--<input type="hidden" name="idCardImg" value="${custExt.idCardImg}" />
				<input class="fileupload" id="idCardImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="idCardImg"	data-preview="true" data-rule-accept="image/*" />
			--%></div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证背面照:</label>
			<div class="controls">
				<img class="preview single_img" src="${resourcePath}${custExt.idCardBackImg}">
				<%--<input type="hidden" name="idCardBackImg" value="${custExt.idCardBackImg}" />
				<input class="fileupload" id="idCardBackImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="idCardBackImg"	data-preview="true" data-rule-accept="image/*" />
			--%></div>
		</div>
		<c:choose>
			<c:when test="${custInfo.custType=='1'}">
				<div class="control-group">
					<label class="control-label">驾驶证号：</label>
					<div class="controls">
						<input readonly="readonly" name="idCardNum" value="${custExt.driversCardNum}"  class="input-xlarge " type="text" maxlength="20"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">驾驶证正面照:</label>
					<div class="controls">
						<img class="preview single_img" src="${resourcePath}${custExt.driversCardImg}">
						<%--<input type="hidden" name="driversCardImg" value="${custExt.driversCardImg}" />
						<input class="fileupload" id="driversCardImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="driversCardImg"	data-preview="true" data-rule-accept="image/*" />
					--%></div>
				</div>
				<div class="control-group">
					<label class="control-label">驾驶证背面照:</label>
					<div class="controls">
						<img class="preview single_img" src="${resourcePath}${custExt.driversCardBackImg}">
						<%--<input type="hidden" name="driversCardBackImg" value="${custExt.driversCardBackImg}" />
						<input class="fileupload" id="driversCardBackImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="driversCardBackImg"	data-preview="true" data-rule-accept="image/*" />
					--%></div>
				</div>
			</c:when>
			<c:when test="${custInfo.custType=='3' or custInfo.custType=='4' or custInfo.custType=='5'or custInfo.custType=='6'}">
				<div class="control-group">
					<label class="control-label">公司名称：</label>
					<div class="controls">
						<input readonly="readonly" name="companyName" value="${custExt.companyName}"  class="input-xlarge " type="text" maxlength="20"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">公司门头照：</label>
					<div class="controls">
						<img class="preview single_img" src="${resourcePath}${custExt.companyImg}">
						<%--<input type="hidden" name="companyImg" value="${custExt.companyImg}" />
						<input class="fileupload" id="companyImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="companyImg"	data-preview="true" data-rule-accept="image/*" />
					--%></div>
				</div>
				<div class="control-group">
					<label class="control-label">营业证号：</label>
					<div class="controls">
						<input readonly="readonly" name="buisinessCardNum" value="${custExt.buisinessCardNum}"  class="input-xlarge " type="text" maxlength="20"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">营业执照照片:</label>
					<div class="controls">
						<img class="preview single_img" src="${resourcePath}${custExt.buisinessCardImg}">
						<%--<input type="hidden" name="buisinessCardImg" value="${custExt.buisinessCardImg}" />
						<input class="fileupload" id="buisinessCardImg-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="buisinessCardImg"	data-preview="true" data-rule-accept="image/*" />
					--%></div>
				</div>
				<div class="control-group">
					<label class="control-label">公司地址：</label>
					<div class="controls">
						<input readonly="readonly" name="companyAdress" value="${custExt.companyAdress}"  class="input-xlarge " type="text" maxlength="20"/>
					</div>
				</div>
			</c:when>
		</c:choose>
		<div class="control-group">
			<label class="control-label">审核：</label>
			<div class="controls">
				<form:select path="auditStatus" class="input-xlarge ">
					<form:options items="${fns:getConsList('AUDIT_STATUS2')}" itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审核意见：</label>
			<div class="controls">
				<form:input path="auditMsg"  htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="custinfo:custInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>