<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序版本管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
        var apletList = ${apletList};
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
            $('#schmId').change(function () {
                var schmId = $(this).val();
                $('#apltId').empty();
                var d1 = [];
                var val = apletList.length > 0 ? apletList[0].APLT_ID : '';
                for(var i=0; i<apletList.length; i++) {
                    var rec = apletList[i];
                    if(schmId != rec.SCHM_ID)
                        return;
                    d1.push({id:rec.APLT_ID, text:rec.APLT_NAME});
                    $('#apltId').append($('<option value="' + rec.APLT_ID + '" >' + rec.APLT_NAME + '</option>'));
                }
                if(d1.length == 0){
                    d1.push({id:'', text:''});
                }

//                $('#apltId').select2("destroy");
                /*$('#apltId').select2({
                    data: d1,
                    language: "zh-CN",
                });*/


//                $("#apltId").val('请选择').trigger("change");
//                $('#apltId').val('').trigger("change");
            });
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgAppletVersion/" onclick="return lasySubmit(bakForm,this.href);">小程序版本列表</a></li>
		<li class="active"><a href="javascript:void()">
		小程序版本<tags:autoFormLabel editPermission="cfg:CfgAppletVersion:edit" id="${entry.apltVerId}" /></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgAppletVersion/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="apltVerId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group ">
                    <label class="control-label">行业方案：</label>
                    <div class="controls">
                        <wey:schemeSelect nameValue="schmId" idValue="schmId" val="${param.SCHM_ID}" isAll="0" cssClass="input-xlarge"></wey:schemeSelect>

                    </div>
                </div>
                <div class="control-group ">
                    <label class="control-label">小程序：</label>
                    <div class="controls">
                        <select id="apltId" name="apltId" class="input-xlarge" noselect2="1" required="required"></select>
                    </div>
                </div>
                <div class="control-group ">
                    <label class="control-label">版本号：</label>
                    <div class="controls">
                            <form:input path="apltVerName" required="required" />
                    </div>
                </div>
                <div class="control-group ">
                    <label class="control-label">模版ID：</label>
                    <div class="controls">
                        <form:input path="apltVerTemplateId" required="required" />
                    </div>
                </div>
                <div class="control-group ">
                    <label class="control-label">自动上线：</label>
                    <div class="controls">
                        <form:select path="apltVerAutoOnline" cssClass="input-medium">
                            <form:options items="${fns:getConsList('CFG_APPLET_VERSION_ONLINE')}" itemLabel="label" itemValue="value"></form:options>
                        </form:select>
                    </div>
                </div>
                <%--<div class="control-group ">
                    <label class="control-label">上传包：</label>
                    <div class="controls">
                        <form:input path="apltVerZipPath" />
                    </div>
                </div>--%>
                <div class="control-group">
                    <label class="control-label">版本描述：</label>
                    <div class="controls">
                            <form:textarea path="apltVerDesc" cssClass="input-xxlarge" rows="10" required="required" />
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgAppletVersion:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>