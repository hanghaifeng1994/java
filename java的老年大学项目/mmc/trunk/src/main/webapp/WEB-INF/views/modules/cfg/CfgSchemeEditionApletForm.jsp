<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>选择方案版本小程序</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});

            $.get("${ctx}/cfg/CfgApplet/getListJson?schmId=${entry.schmId}&schmEdtId=${entry.schmEdtId}",{}, function(data){
                if(!$.isArray(data))
                    return;
                var ele = $('#apltIds');
                if(ele.length == 0 || ele.length > 1)
                    return;

                var selIds = [];
                $.each(data, function (i, rec) {
                    if(rec.sel == "1"){
                        selIds.push(rec.APLT_ID);
					}
                    ele.append($('<option value="' + rec.APLT_ID + '" >' + rec.APLT_NAME + '</option>'));
                })
                ele.select2();
                /*for(var i=0; i<selIds.length; i++){
                    ele.select2('val', selIds[i]);
				}*/
                ele.select2('val', selIds);

            }, 'json');
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgSchemeEdition/" onclick="return lasySubmit(bakForm,this.href);">方案版本列表</a></li>
		<li class="active"><a href="javascript:void()">选择方案版本小程序</li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEdition/selAplet" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
        <form:hidden path="schmEdtId"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group ">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        ${entry.schmEdtName}
                    </div>
                </div>
                <div class="control-group ">
                    <label class="control-label">小程序：</label>
                    <div class="controls">
                        <select id="apltIds" name="apltIds" class="input-xlarge" noselect2="1" multiple="multiple" required="required" >

                        </select>
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>