<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>配置模块</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cfg/CfgScheme/">方案列表</a></li>
		<li class="active"><a href="javascript:void(0)">配置模块</a></li>
	</ul>
	<div class="container-fluid breadcrumb">
		<div class="row-fluid span12">
			<span class="span4">行业方案名称: <b>${entry.schmName}</b></span>
			<span class="span4">行业: ${fns:getDictLabel( entry.schmIndustry,"Industry_type", "")}</span>
			<span class="span4">状态: ${fns:getConsLabel("ENABLE_DISABLE", entry.schmStatus, "")}</span>
		</div>
		<div class="row-fluid span8">
			<span class="span4">方案描述: ${entry.schmDesc}</span>
		</div>
	</div>
	<sys:message content="${message}"/>
	<div class="breadcrumb">
		<form id="assignForm" action="${ctx}/cfg/CfgScheme/addMdl" method="post" class="hide">
			<input type="hidden" name="id" value="${entry.schmId}"/>
			<input id="idsArr" type="hidden" name="idsArr" value=""/>
            ${paramCover.decodeInputs}
		</form>
		<input id="assignButton" class="btn btn-primary" type="submit" value="添加模块"/>
		<script type="text/javascript">
			$("#assignButton").click(function(){
				top.$.jBox.open("iframe:${ctx}/cfg/CfgScheme/selectMdl?id=${entry.schmId}", "配置模块",810,$(top.document).height()-240,{
					buttons:{"确定配置":"ok",  "关闭":true},submit:function(v, h, f){
						if (v=="ok"){
                            var nodes = h.find("iframe")[0].contentWindow.mdlTree.getCheckedNodes(true);
                            var idsArr = "";
                            for(var i=0; i<nodes.length; i++) {
                                idsArr = (idsArr + nodes[i].id) + (((i + 1)== nodes.length) ? '':',');
                            }
					    	// 执行保存
					    	loading('正在提交，请稍等...');
					    	$('#idsArr').val(idsArr);
					    	$('#assignForm').submit();
					    	return true;
						}
					}, loaded:function(h){
						$(".jbox-content", top.document).css("overflow-y","hidden");
					}
				});
			});
		</script>
	</div>
    <form id="listForm" method="post" action="${ctx}/cfg/CfgScheme/updateMdlSort?">
        ${paramCover.coveredInputs}
            <input type="hidden" name="schmId" value="${param.id}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>模块编码</th><th>模块名称</th><th>排序</th><shiro:hasPermission name="cfg:CfgScheme:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${mdlList}" var="mdl">
			<tr>
				<td>${mdl.mdlCode}</td>
				<td>${mdl.mdlName}</td>
                <td>
                    <shiro:hasPermission name="cfg:CfgScheme:edit">
                        <input type="hidden" name="mdlIds" value="${mdl.mdlId}"/>
                        <input name="sorts" type="text" value="${mdl.sort}" style="width:50px;margin:0;padding:0;text-align:center;">
                    </shiro:hasPermission><shiro:lacksPermission name="cfg:CfgScheme:edit">
                    ${mdl.sort}
                </shiro:lacksPermission>

                </td>
				<td>
					<a href="${ctx}/cfg/CfgScheme/delMdl?schmId=${param.id}&mdlId=${mdl.mdlId}"
					   onclick="return lasyConfirm('确认要删除方案模块吗？', reForm,this.href);">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

            <shiro:hasPermission name="cfg:CfgScheme:edit"><div class="form-actions pagination-left">
                <input type="submit"  class="btn btn-primary" value="保存排序"/>
            </div></shiro:hasPermission>
    </form>

	<form name="reForm" method="post">
		${paramCover.coveredInputs}
	</form>

</body>
</html>
