<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
	<title>方案版本升级信息添加</title>
	<meta name="decorator" content="default"/>
    <script src="${ctxStatic}/jquery/plugin/jquery.form.js" type="text/javascript"></script>
    <script type="text/javascript">
		$(document).ready(function() {
            initJQueryFormValidator($("#inputForm"),{});
        });
        function checkdata() {
            var ret = $("#inputForm").valid();
//            return $("#inputForm").validate();
            return ret;
        }
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionUpdateInfo/add" method="post" class="form-search form-horizontal">
        <sys:message content="${message}"/>
		${paramCover.unCovered_Inputs}
        <form:hidden path="edtUpType"/>
        <form:hidden path="edtUpObjId"/>
        <div class="container-fluid">
			<div class="row">
                <div class="control-group span12">
                    <label class="control-label">方案版本：</label>
                    <div class="controls">
                        <c:if test="${entry.edtUpType==3}">
                            <form:select path="schmEdtId" cssClass="input-xlarge">
                                <form:options items="${edtList}" itemLabel="schmEdtName" itemValue="schmEdtId"/>
                            </form:select>
                        </c:if>
                        <c:if test="${entry.edtUpType!=3}">
                            <form:hidden path="schmEdtId"/>
                            <c:forEach items="${edtList}" var="edt" varStatus="status">
                                <%--<input type="hidden" name="schmEdtIds" value="${edt.schmEdtId}">--%>

                                ${edt.schmEdtName}<c:if test="${edtList.size() > 1 &&  status.index < edtList.size()-1}">，</c:if>

                            </c:forEach>
                        </c:if>

                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">升级类型：</label>
                    <div class="controls">
                            ${fns:getConsLabel('CFG_SCHEME_EDITION_UPDATE_INFO_TYPE', entry.edtUpType, '自定义')}

                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">版本名称：</label>
                    <div class="controls">
                        <form:input path="edtUpVerName" required="required"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-label">版本时间：</label>
                    <div class="controls">
                            <input id="edtUpVerDate" name="edtUpVerDate" type="text" readonly="readonly" maxlength="20" required="required"
                                   class="Wdate" value="<fmt:formatDate value="${entry.edtUpVerDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">升级内容：</label>
                    <div class="controls">
                            <form:textarea path="edtUpContent" cssClass="input-xxlarge" rows="8" required="required"/>
                    </div>
                </div>
			</div>
		</div>
	</form:form>
</body>
</html>