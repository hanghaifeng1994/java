<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小程序版本管理</title>
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
			<li class="active"><a href="javascipt:void()">小程序版本列表</a></li>
		<shiro:hasPermission name="cfg:CfgAppletVersion:edit"><li><a href="${ctx}/cfg/CfgAppletVersion/form" onclick="return lasySubmit(reForm,this.href);">小程序版本添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="entry" action="${ctx}/cfg/CfgAppletVersion/" method="post" class="searchForm breadcrumb form-search form-horizontal">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><span><label>行业方案：</label></span>
				<wey:schemeSelect nameValue="schmId" idValue="schmId" val="${entry.schmId}" isAll="1" cssClass="input-medium"></wey:schemeSelect>
			</li>
			<li><span><label>小程序appid：</label></span>
				<form:input path="apltAppId"/>
			</li>
			<li class="clearfix"></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			</li>

			<li class="clearfix"></li>
		</ul>
	</form:form>
    <sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<th>小程序</th>
			<th>版本号</th>
			<th>小程序appid</th>
			<th>方案</th>
			<th>代码模版ID</th>
			<th>上线类型</th>
			<th>上传数量</th>
			<th>审核数量</th>
			<th>发布数量</th>
			<th>升级信息</th>
			<%--<shiro:hasPermission name="cfg:CfgAppletVersion:edit"><th>操作</th></shiro:hasPermission></tr></thead>--%>
		<tbody>
		<c:forEach items="${page.list}" var="entity">
			<tr>
				<td>${entity.apltName}</td>
				<td><a href="${ctx}/cfg/CfgAppletVersion/form?isView=1&id=${entity.apltVerId}">${entity.apltVerName}</a></td>
				<td>${entity.apltAppId}</td>
				<td>${entity.schmName}</td>
				<td>${entity.apltVerTemplateId}</td>
			<td>${fns:getConsLabel('CFG_APPLET_VERSION_ONLINE', entity.apltVerAutoOnline, '未开启')}</td>
			<td>${entity.apltVerUploadNum}</td>
			<td>${entity.apltVerAuditNum}</td>
			<td>${entity.apltVerPubNum}</td>
				<td>
					<c:if test="${entity.apltVerStatus==0}">
						<a href="javascript:void(0)"
						   onclick="return addUpdateIno('${entity.apltVerId}');">添加版本升级信息</a>
					</c:if>
					<c:if test="${entity.apltVerStatus!=0}">
						已添加
					</c:if>
				</td>
			<%--<shiro:hasPermission name="cfg:CfgAppletVersion:edit"><td>
                <a href="${ctx}/cfg/CfgAppletVersion/form?id=${entity.apltVerId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgAppletVersion/delete?id=${entity.apltVerId}"
                   onclick="return lasyConfirm('确认要删除该小程序版本吗？', reForm,this.href);">删除</a>
            </td></shiro:hasPermission>--%>
        </tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
    <form name="reForm" method="post">
		${paramCover.coveredInputs}
    </form>
	<script type="text/javascript">
        function addUpdateIno(edtUpObjId){
            top.$.jBox.open("iframe:${ctx}/cfg/CfgSchemeEditionUpdateInfo/form?edtUpType=2&edtUpObjId="+edtUpObjId
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