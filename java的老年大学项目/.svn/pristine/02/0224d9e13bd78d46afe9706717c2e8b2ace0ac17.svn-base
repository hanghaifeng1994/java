<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>选择方案模块</title>
	<meta name="decorator" content="blank"/>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">

		var mdlTree;//zTree已选择对象

		// 初始化
		$(document).ready(function(){
            mdlTree = $.fn.zTree.init($("#mdlTree"), setting, selectNodes);
		});

        var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
            data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
                mdlTree.checkNode(node, !node.checked, true, true);
                return false;
            }}};


		var selectNodes =[
			<c:forEach items="${selList}" var="mdl">
			{id:"${mdl.mdlId}",
				pId:"0",
				name:"${mdl.mdlName}"},
			</c:forEach>];
	</script>
</head>
<body>
	<div id="assignRole" class="row-fluid span12">

		<div class="span3">
			<p>待选模块：</p>
			<div id="mdlTree" class="ztree"></div>
		</div>
	</div>
</body>
</html>
