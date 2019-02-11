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
		<li><a href="${ctx}/custinfo/custInfo/">客户信息列表</a></li>
		<li class="active"><a href="${ctx}/custinfo/custInfo/form?id=${custInfo.id}">客户信息
		<tags:autoFormLabel editPermission="custinfo:custInfo:edit" id="${custInfo.id}" />
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="custInfo" action="${ctx}/custinfo/custInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<img class="preview single_img" src="${resourcePath}/${custInfo.photo}">
				<%--<input type="hidden" name="photo" value="${custInfo.photo}" />
				<input class="fileupload" id="shop-icon" type="file" data-url="${pageContext.request.contextPath}/resourceUpload" data-display-id="photo"	data-preview="true" data-rule-accept="image/*" />
				--%>	<%--<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>--%>
					<%--<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>--%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="custName" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户类型：</label>
			<div class="controls">
				<form:select path="custType" class="input-xlarge ">
					<form:options items="${fns:getConsList('CUST_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
				</form:select>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<input id ="idCardNum"  name="idCardNum" value="${custExt.idCardNum}"  class="input-xlarge" type="text" maxlength="20"/>
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
						<input name="idCardNum" value="${custExt.driversCardNum}"  class="input-xlarge " type="text" maxlength="20"/>
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
						<input name="companyName" value="${custExt.companyName}"  class="input-xlarge " type="text" maxlength="20"/>
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
						<input name="buisinessCardNum" value="${custExt.buisinessCardNum}"  class="input-xlarge " type="text" maxlength="20"/>
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
						<input name="companyAdress" value="${custExt.companyAdress}"  class="input-xlarge " type="text" maxlength="20"/>
					</div>
				</div>
			</c:when>
		</c:choose>

		<div class="control-group">
			<label class="control-label">邮箱：</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别：</label>
			<div class="controls">
				<form:select path="sex" class="input-xlarge ">
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户生日：</label>
			<div class="controls">
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${custInfo.birthday}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">金额：</label>
			<div class="controls">
				<form:input path="amount" htmlEscape="false" maxlength="15" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">冻结金额：</label>
			<div class="controls">
				<form:input path="freezingAmount" htmlEscape="false" maxlength="15" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">个性签名：</label>
			<div class="controls">
				<form:input path="sign" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">认证状态：</label>
			<div class="controls">
				<form:select path="custAuditStatus" class="input-xlarge ">
					<form:options items="${fns:getConsList('CUST_AUDIT_STATUS')}" itemLabel="label" itemValue="value" htmlEscape="false" disabled="true"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">积分：</label>
			<div class="controls">
				<form:input path="custScores" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">成交订单数：</label>
			<div class="controls">
				<form:input path="orderNum" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">评价数：</label>
			<div class="controls">
				<form:input path="evaluationNum" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布车源数：</label>
			<div class="controls">
				<form:input path="pubVcSourceNum" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布货源数：</label>
			<div class="controls">
				<form:input path="pubGdSourceNum" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总评分：</label>
			<div class="controls">
				<form:input path="evaluationScore" htmlEscape="false" maxlength="10" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户所在地址：</label>
			<div class="controls">
				<form:input path="custAreaName" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务介绍：</label>
			<div class="controls">
				<form:input path="businessDes" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>