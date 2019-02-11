<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>配置版本价格</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
        function addPrice(){
            var schmEdtId =$("#id").val();
            window.location.href="${ctx}/cfg/CfgSchemeEditionPrice/form?schmEdtId="+schmEdtId;
        }
        function startOrForbiddenUse(edtPrcId,schmEdtId,edtPrcStatus){
            var count=$("#count").val();

            if(parseInt(count)>0 && edtPrcStatus=='0'){
                top.$.jBox.info("已存在启用价格，禁用后才可启用其他版本价格！");
			}else{
                window.location.href="${ctx}/cfg/CfgSchemeEditionPrice/startOrForbiddenUse?edtPrcId="+ edtPrcId+"&&schmEdtId="+ schmEdtId+"&&edtPrcStatus="+edtPrcStatus;
            }
        }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
	<li><a href="${ctx}/cfg/CfgSchemeEdition/" onclick="return ">方案版本列表</a></li>
	<li class="active"><a href="javascript:void(0)">价格配置</a></li>
</ul>
<sys:message content="${message}"/>
<div class="breadcrumb">
	<form id="priceForm" action="" method="post" class="hide">
		<input type="hidden" id="id" name="id" value="${schmEdtId}"/>
		<input type="hidden" id="count" value="${count}">
		${paramCover.decodeInputs}
	</form>
	<input id="priceButton" class="btn btn-primary" type="button" value="新增版本价格" onclick="addPrice();"/>
</div>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><th>名称</th>
	<th>年价格</th>
	<th>月价格</th>
	<th>门店数</th>
	<th>状态</th>
	<shiro:hasPermission name="cfg:CfgSchemeEditionPrice:edit"><th>操作</th></shiro:hasPermission>
	</thead>
	<tbody>
	<c:forEach items="${priList}" var="entity">
		<tr>
			<td><a href="${ctx}/cfg/CfgSchemeEditionPrice/form?isView=1&id=${entity.edtPrcId}">${entity.edtPrcName}</a></td>
			<td>${entity.edtPrcYearPrice}</td>
			<td>${entity.edtPrcMonthPrice}</td>
			<td>${entity.edtPrcStoreNum}</td>
			<td>
				<c:choose>
				<c:when test="${entity.edtPrcStatus eq '0'}">
				禁用
				</c:when>
				<c:when test="${entity.edtPrcStatus eq '1'}">
				启用
				</c:when>
				</c:choose>
			<shiro:hasPermission name="cfg:CfgSchemeEditionPrice:edit"><td>
                <c:choose>
                    <c:when test="${entity.edtPrcStatus eq '0'}">
                        <a onclick='startOrForbiddenUse("${entity.edtPrcId}","${entity.schmEdtId}","${entity.edtPrcStatus}");'>启用</a>
                        <a href="${ctx}/cfg/CfgSchemeEditionPrice/form?id=${entity.edtPrcId}" onclick="return lasySubmit(reForm,this.href);">修改</a>
                        <a href="${ctx}/cfg/CfgSchemeEditionPrice/delete?id=${entity.edtPrcId}&&schmEdtId=${entity.schmEdtId}"
                           onclick="return lasyConfirm('确认要删除该方案版本价格吗？', reForm,this.href);">删除</a>
                    </c:when>
                    <c:when test="${entity.edtPrcStatus eq '1'}">
                        <a  onclick='startOrForbiddenUse("${entity.edtPrcId}","${entity.schmEdtId}","${entity.edtPrcStatus}");'>禁用</a>
                    </c:when>
                </c:choose>
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