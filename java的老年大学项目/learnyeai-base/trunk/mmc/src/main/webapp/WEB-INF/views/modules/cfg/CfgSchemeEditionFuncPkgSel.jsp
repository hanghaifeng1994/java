<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>选择方案模块</title>
    <meta name="decorator" content="blank"/>
    <%@include file="/WEB-INF/views/include/treeview.jsp" %>
    <script type="text/javascript">

        var zTreeObj;//zTree对像

        // 初始化
        $(document).ready(function(){
            zTreeObj = $.fn.zTree.init($("#zTree"), setting, selectNodes);

            // 不选择父节点
            zTreeObj.setting.check.chkboxType = { "Y" : "s", "N" : "s" };
            zTreeObj.expandAll(true);
        });

        var setting = {check:{enable:true,nocheckInherit:false},view:{selectedMulti:false},
            data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
                zTreeObj.checkNode(node, !node.checked, true, true);
                return false;
            }}};


        var selectNodes =[
            <c:forEach items="${list}" var="it">
            {id:"${it.pkgId}",
                pId:"${it.pId}",
                name:"${it.pkgName}",
                nocheck:${it.pId=='0'? 'true':'false'}
            },
            </c:forEach>];
    </script>
</head>
<body>
<div id="assignRole" class="row-fluid span12">

    <div class="span3">
        <p>待选功能包：</p>
        <div id="zTree" class="ztree"></div>
    </div>
</div>
</body>
</html>
