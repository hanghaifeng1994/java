<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>配置功能包</title>
    <meta name="decorator" content="default"/>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/cfg/CfgSchemeEdition/" onclick="return ">方案版本列表</a></li>
    <li class="active"><a href="javascript:void(0)">配置功能包</a></li>
</ul>
<div class="container-fluid breadcrumb">
    <div class="row-fluid span12">
        <span class="span4">方案版本: <b>${entry.schmEdtName}</b></span>
        <span class="span4">行业方案: ${schm.schmName}</span>
    </div>
</div>
<sys:message content="${message}"/>
<div class="breadcrumb">
    <form id="assignForm" action="${ctx}/cfg/CfgSchemeEdition/assignPkg" method="post" class="hide">
        <input type="hidden" name="id" value="${entry.schmEdtId}"/>
        <input id="pkgIds" type="hidden" name="pkgIds" value=""/>
        <input id="mdlIds" type="hidden" name="mdlIds" value=""/>
        ${paramCover.decodeInputs}
    </form>
    <input id="assignButton" class="btn btn-primary" type="submit" value="添加功能包"/>
    <script type="text/javascript">
        $("#assignButton").click(function(){
            top.$.jBox.open("iframe:${ctx}/cfg/CfgSchemeEdition/selectPkg?id=${entry.schmEdtId}", "添加功能包",810,$(top.document).height()-240,{
                buttons:{"确定添加":"ok",  "关闭":true},submit:function(v, h, f){
                    var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
                    var ids = h.find("iframe")[0].contentWindow.ids;
                    //nodes = selectedTree.getSelectedNodes();
                    if (v=="ok"){
                        var nodes = h.find("iframe")[0].contentWindow.zTreeObj.getCheckedNodes(true);
                        var idsArr = "";
                        var mdlIds = "";
                        for(var i=0; i<nodes.length; i++) {
                            idsArr = (idsArr + nodes[i].id) + (((i + 1)== nodes.length) ? '':',');
                            mdlIds = (mdlIds + nodes[i].pId) + (((i + 1)== nodes.length) ? '':',');
                        }
                        // 执行保存
                        loading('正在提交，请稍等...');
                        $('#pkgIds').val(idsArr);
                        $('#mdlIds').val(mdlIds);
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
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead><tr><th>功能包</th><th>模块</th><th>类型</th><th>状态</th><th>年价格</th><th>月价格</th><shiro:hasPermission name="sys:user:edit"><th>操作</th></shiro:hasPermission></tr></thead>
    <tbody>
    <c:forEach items="${pkgList}" var="it">
        <tr>
            <td><a href="${ctx}/cfg/CfgSchmEdtPackage/form?id=${it.edtPkgId}&pkgName=${it.pkgName}&mdlName=${it.mdlName}&schmEdtName=${entry.schmEdtName}"
                   onclick="return lasySubmit(reForm,this.href);">${it.pkgName}</a></td>
            <td>${it.mdlName}</td>
            <td>${fns:getConsLabel("CFG_SCHM_EDT_PACKAGE_TYPE", it.edtPkgType, "基础包")}</td>
            <td>${fns:getConsLabel("CFG_SCHM_EDT_PACKAGE_STATUS", it.edtPkgStatus, "未启用")}</td>
            <td>${it.edtPkgYearPrice}</td>
            <td>${it.edtPkgMonthPrice}</td>
            <shiro:hasPermission name="cfg:CfgSchemeEdition:edit"><td>
                <c:if test="${it.edtPkgStatus !=1}">
                <a href="${ctx}/cfg/CfgSchmEdtPackage/enable?edtPkgId=${it.edtPkgId}"
                   onclick="return lasyConfirm('启用后不能修改版本功能包类型，确认要启用吗？',reForm,this.href);">启用</a>
                </c:if>
                <a href="${ctx}/cfg/CfgSchmEdtPackage/form?id=${it.edtPkgId}&pkgName=${it.pkgName}&mdlName=${it.mdlName}&schmEdtName=${entry.schmEdtName}"
                   onclick="return lasySubmit(reForm,this.href);">修改</a>
                <a href="${ctx}/cfg/CfgSchmEdtPackage/delete?id=${it.edtPkgId}"
                   onclick="return lasyConfirm('确认要删除功能包吗？', reForm,this.href);">删除</a>

            </td></shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form name="reForm" method="post">
    ${paramCover.coveredInputs}
</form>
</body>
</html>
