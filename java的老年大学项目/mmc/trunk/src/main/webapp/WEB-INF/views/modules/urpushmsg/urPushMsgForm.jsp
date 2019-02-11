<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推送消息管理</title>
	<meta name="decorator" content="default"/>
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

			/****为下拉框添加change事件****/
			$("#pmPushType").bind("change",function(){
				var value = $(this).val();
				if(value==1){
					$('#chooseTheme').hide();
					$('#chooseCust').show();
				}else if(value==2){
					$('#chooseCust').hide();
					$('#chooseTheme').show();
				}else if(value==3){
					$('#chooseCust').hide();
					$('#chooseTheme').hide();
				}
			});
			/*********选择推送类型**********/
			/*$("#pmComType").bind("change",function(){
				var value = $(this).val();
				if(value==1){
					$('#chooseType1').show();
					$('#chooseType').hide();
					$('#chooseType2').hide();
					$('#chooseType3').hide();
					$('#chooseType4').hide();
				}else if(value==2){
					$('#chooseType1').hide();
					$('#chooseType').hide();
					$('#chooseType2').show();
					$('#chooseType3').hide();
					$('#chooseType4').hide();
				}else if(value==3){
					$('#chooseType1').hide();
					$('#chooseType').hide();
					$('#chooseType2').hide();
					$('#chooseType3').show();
					$('#chooseType4').hide();
				}else if(value==4){
					$('#chooseType1').hide();
					$('#chooseType').hide();
					$('#chooseType2').hide();
					$('#chooseType3').hide();
					$('#chooseType4').show();
				}
			});*/

			$("#pmType").bind("change",function(){
				var value = $(this).val();
				if(value==1){
					$('#chooseTime').hide();
				}else if(value==2){
					$('#chooseTime').show();
				}
			});

		});

		function queryUser(){
			$.jBox.open($('#settimemessage').html(), "选择接收人",450,500,{buttons:false});
			var checklist = $("#jbox input[name=idchecked]");
			var isok = idlx//选中后的复选框----id
			for(var i=0;i<checklist.length;i++){
				for(var j=0;j<isok.length;j++){
					if(checklist[i].value == isok[j]){
						checklist[i].checked = true;
					}
				}
			}
		};
		/*****选择接收人提交*******/
		var idlx =[];
		function settimemessamebuttom(){
			idlx.length=0//清空数组
			var $id = $("input[name=idchecked]:checked");
			$.each($id,function(i,k){
				idlx.push($(this).val());
			});
			$('#pmRecieveCust').val(idlx);
			$.ajax({
				type:"POST",
				url:"${ctx}/urpushmsg/urPushMsg/queryUser",
				data:{idlx:$('#pmRecieveCust').val()},
				success:function(data){
					$("#pmRecieveCustName").val(data);
				}

			})

			/*		---------------获取多个checkbox的id值到数组ids ------------------------*/
			if(idlx.length==0){
				$.jBox.tip('请先勾选记录？', 'warning');
				return false;
			}else {
				$.jBox.tip("已成功选择了"+idlx.length+"个接收人！", 'warning');
				$.jBox.close();
				return false;
			}
		}
		/****选择接收人取消******/
		function clearUser(){
			$('#pmRecieveCust').val("");
			$('#pmRecieveCustName').val("");
		}

		function cancelbutton(){
			idlx.length=0//清空数组
			$.jBox.close();
			return false;
		}
	</script>
</head>
<body>

	<div id="settimemessage" style="display: none">
		<sys:message content="${message}"/>
		<table id="contentTable1" class="table table-striped table-bordered table-condensed">
			<thead><tr><th>选择</th><th>姓名</th><th>手机号</th></thead>
			<tbody>
			<c:forEach items="${list}" var="custInfo">
				<tr>
					<td><input type="checkbox" id="idchecked"  name="idchecked"  value="${custInfo.custId}">
					<input type="hidden" id="custName"  name="custName"   value="${custInfo.custName}"></td>
					<td>${custInfo.custName}</td>
					<td>${custInfo.phone}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div style="float: right;font-size: 15px;padding-top: 5px;padding-right: 20px;">
			<input type="button"  class="btn btn-primary"    value="取消" onclick="cancelbutton()">
			<input  type="button"   id="selectpeople" onclick="settimemessamebuttom()"  class="btn btn-primary" name="selectpeople" value="提交"/>
		</div>
		<div class="pagination">${page}</div>
	</div>

	<ul class="nav nav-tabs">
		<li><a href="${ctx}/urpushmsg/urPushMsg/">推送消息列表</a></li>
		<li class="active"><a href="${ctx}/urpushmsg/urPushMsg/form?id=${urPushMsg.id}">推送消息
		<tags:autoFormLabel editPermission="urpushmsg:urPushMsg:edit" id="${urPushMsg.id}" />
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="urPushMsg" action="${ctx}/urpushmsg/urPushMsg/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">消息来源：</label>
			<div class="controls">
				<form:select path="pmComType" class="input-medium">
					<%--<form:option value="" label="--请选择--"/>--%>
					<form:options items="${fns:getConsList('MSG_COM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<%--<div class="control-group">
			<label class="control-label">平台：</label>
			<div class="controls">
				<form:input path="ptId" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">消息内容：</label>
			<div class="controls">
				<form:textarea path="pmContent" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge" required="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务类型：</label>
			<div class="controls" id="chooseType" style="display: block">
				<form:select path="pmServiceType" class="input-xlarge" >
					<%--<form:option value="" label="--请选择--"/>--%>
					<form:options items="${fns:getConsList('PM_SERVICE_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			<%--<div class="controls" id="chooseType1" style="display: none">
				<form:select path="pmServiceType" class="input-xlarge" >
					<form:options items="${fns:getConsList('XT_MSG_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			<div class="controls" id="chooseType2"  style="display: none">
				<form:select path="pmServiceType" class="input-xlarge">
					<form:options items="${fns:getConsList('CL_MSG_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			<div class="controls" id="chooseType3" style="display: none">
				<form:select path="pmServiceType" class="input-xlarge" >
					<form:options items="${fns:getConsList('DD_MSG_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
			<div class="controls" id="chooseType4" style="display: none">
				<form:select path="pmServiceType" class="input-xlarge" >
					<form:options items="${fns:getConsList('CD_MSG_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>--%>
		</div>
		<div class="control-group" >
			<label class="control-label">对像id：</label>
			<div class="controls">
				<form:input path="pmRelObjId" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参数：</label>
			<div class="controls">
				<form:input path="pmParams" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型：</label>
			<div class="controls">
				<form:select path="pmType" class="input-medium">
					<form:options items="${fns:getConsList('PM_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group" style="display:block" id="chooseTime">
			<label class="control-label">推送时间：</label>
			<div class="controls">
				<input name="pmPushDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${urPushMsg.pmPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false,minDate:'%y-%M-%d'});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">推送消息类型：</label>
			<div class="controls">
				<form:select path="pmPushType" class="input-medium">
					<form:options items="${fns:getConsList('PM_PUSH_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group"  style="display: none" id="chooseCust">
			<label class="control-label">接收消息人：</label>
			<div class="controls">
				<input type="hidden" name="pmRecieveCust" id="pmRecieveCust" value="${urPushMsg.pmRecieveCust}"/>
				<form:textarea path="pmRecieveCustName" htmlEscape="false"  rows="4" maxlength="2000" class="input-xxlarge "/>
				<a href="javascript:" onclick="queryUser();"  class="btn">添加</a>
				<a href="javascript:" onclick="clearUser();" class="btn">清除</a>
			</div>
		</div>
		<div class="control-group"  style="display: none" id="chooseTheme">
			<label class="control-label">主题：</label>
			<div class="controls">
				<form:input path="pmTheme" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="urpushmsg:urPushMsg:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>