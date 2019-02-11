<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案版本升级信息管理</title>
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
		<li class="active"><a href="javascipt:void()">方案版本升级信息列表</a></li>
		<shiro:hasPermission name="cfg:CfgSchemeEditionUpdateInfo:edit"><li><a href="javascript:void(0)" onclick="return addUpdateIno();">方案版本升级信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgSchemeEditionUpdateInfo/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>方案版本：</label>
				<wey:schmEdtionSelect nameValue="schmEdtId" idValue="schmEdtId" val="${entry.schmEdtId}" isAll="1" cssClass="input-medium"></wey:schmEdtionSelect>
			</li>

			<li><label>升级类型：</label>
				<form:select path="edtUpType" cssClass="input-medium">
					<form:option value="">全部</form:option>
					<form:options items="${fns:getConsList('CFG_SCHEME_EDITION_UPDATE_INFO_TYPE')}" itemValue="value" itemLabel="label"></form:options>
				</form:select>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>方案版本</th>
			<th>版本名称</th>
			<th>版本时间</th>
			<th>升级类型</th>
			<shiro:hasPermission name="cfg:CfgSchemeEditionUpdateInfo:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
				<td>${entity.schmEdtName}</td>
                <td><a href="${ctx}/cfg/CfgSchemeEditionUpdateInfo/view?edtUpId=${entity.edtUpId}">${entity.edtUpVerName}</a></td>

			<td><fmt:formatDate value="${entity.edtUpVerDate}" pattern="yyyy-MM-dd" /></td>
			<td>${fns:getConsLabel('CFG_SCHEME_EDITION_UPDATE_INFO_TYPE', entity.edtUpType, '自定义')}</td>
			<shiro:hasPermission name="cfg:CfgSchemeEditionUpdateInfo:edit"><td>
				<a href="${ctx}/cfg/CfgSchemeEditionUpdateInfo/view?edtUpId=${entity.edtUpId}">查看</a>

                <a href="${ctx}/cfg/CfgSchemeEditionUpdateInfo/delete?id=${entity.edtUpId}"
                   onclick="return lasyConfirm('确认要删除该方案版本升级信息吗？', reForm,this.href);">删除</a>
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
        function addUpdateIno(){
            top.$.jBox.open("iframe:${ctx}/cfg/CfgSchemeEditionUpdateInfo/form?edtUpType=3"
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