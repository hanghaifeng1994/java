<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本历史查看</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<%--<li><a href="${ctx}/cfg/CfgSchemeEditionHis/" onclick="return lasySubmit(bakForm,this.href);">方案版本历史列表</a></li>--%>
		<li class="active"><a href="javascript:void()">
		方案版本历史</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionHis/save" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">方案版本名称：</label>
                    <div class="controls">
                        ${entry.schmEdtName}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">功能包：</label>
                    <div class="controls">
                        <c:forEach items="${pkList}" var="it" varStatus="status">
                            ${it.pkgName}<c:if test="${pkList.size() > 1 &&  status.index < pkList.size()-1}">，</c:if>
                        </c:forEach>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本级别：</label>
                    <div class="controls">
                            ${entry.schmEdtGrade}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">上线时间：</label>
                    <div class="controls">
                            ${fns:formatDate(entry.createDate, "yyyy-MM-dd HH:mm:ss")}
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本描述：</label>
                    <div class="controls">
                            ${entry.schmEdtDesc}
                    </div>
                </div>
                <%--<div class="control-group span6">
                    <label class="control-label">图片：</label>
                    <div class="controls">
                            <form:input path="schmEdtPhoto" />
                    </div>
                </div>--%>
                <div class="control-group span12">
                    <label class="control-label">版本升级备注：</label>
                    <div class="controls">
                        ${entry.schmEdtHisRemark}
                    </div>
                </div>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
    <form name="bakForm" method="post">
		${paramCover.decodeInputs}
    </form>
</body>
</html>