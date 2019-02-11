<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本历史管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascipt:void()">方案版本历史列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionHis/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">

			<li><label>版本名称：</label><form:input path="schmEdtName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>方案版本名称</th>
			<th>版本级别</th>
			<th>修改状态</th>
			<th>升级信息</th>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
                <td><a href="${ctx}/cfg/CfgSchemeEditionHis/view?isView=1&schmEdtHisId=${entity.schmEdtHisId}">${entity.schmEdtName}</a></td>

			<td>${entity.schmEdtGrade}</td>
				<td>
					${fns:getConsLabel('CFG_SCHEME_EDITION_MOD_STATUS', entity.schmEdtModStatus, '未修改')}
				</td>
			<shiro:hasPermission name="cfg:CfgSchemeEditionHis:edit"><td>
				<c:if test="${entity.schmEdtHisStatus==0}">
                <a href="javascript:void(0)"
                   onclick="return addUpdateIno('${entity.schmEdtHisId}','${entity.schmEdtId}');">添加版本升级信息</a>
				</c:if>
				<c:if test="${entity.schmEdtHisStatus!=0}">
					已添加
				</c:if>
            </td></shiro:hasPermission>
        </tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
    <form name="reForm" method="post">
		${paramCover.coveredInputs}
    </form>
	<script type="text/javascript">
        function addUpdateIno(edtUpObjId, schmEdtId){
            top.$.jBox.open("iframe:${ctx}/cfg/CfgSchemeEditionUpdateInfo/form?edtUpType=1&edtUpObjId="+edtUpObjId+"&schmEdtId="+ schmEdtId
				, "添加版本升级信息",810,$(top.document).height()-240,{
                buttons:{"确定":"ok",  "关闭":true},submit:function(v, h, f){
                    if (v=="ok"){
                        if(!h.find("iframe")[0].contentWindow.checkdata())
                            return false;
                        var pform = $(h.find("iframe")[0].contentWindow.document).find('#inputForm');
                        $('#updateInfoCon').empty();
                        pform.appendTo($('#updateInfoCon'));
                        $('#inputForm').ajaxSubmit({
                            success:function() {
                                $('#searchForm').submit();
                            },
                            beforeSubmit:function () {
                            },
                            error:function (aa,bb,cc,dd) {
                            },
                            dataType:'json'

                        });
                        return true;
                    }
                }, loaded:function(h){
                    $(".jbox-content", top.document).css("overflow-y","hidden");
                }
            });
            return false;
        }
	</script>
	<div id="updateInfoCon" style="display: none">

	</div>
</body>
</html>