<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("ahstudyUrl", PropertyUtils
			.getPropertyWithConfigName("sysconfig.properties",
					"ahstudy.webapp.url"));
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp"%>
<title>首页<%@ include file="/common/title.jsp" %></title>
<meta content="index" name="menu" />
<link href="${staticurl}/css/master.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/ad.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.cycle.js"></script>
<script type="text/javascript" src="${ctx}/js/floatingAd.js"></script>
<!-- 飘窗 -->
<style>
/*下面是对联广告的css代码*/
.duilian{top:50px;position:absolute; width:102px; overflow:hidden; display:none;}
.duilian_left{ left:6px;}
.duilian_right{right:6px;}
.duilian_con{border:#CCC solid 1px; width:100px; height:300px; overflow:hidden;}
.duilian_close{ width:100%; height:24px; line-height:24px; text-align:center; display:block; font-size:13px; color:#555555; text-decoration:none;}
</style>
<script type="text/javascript">
function submit(classId){
	//$("#opageNo").text($("#opageNo").value());
	var opageNo = $("#opageNo").val();
	if(classId == 0){
		//alert("opageNo="+opageNo)
		$("#a0").attr("href","${ctx}/exportusersinfo.action?classId="+classId+"&opageNo="+opageNo);
		}
	if(classId == 1){
		//alert("opageNo="+opageNo)
		$("#a1").attr("href","${ctx}/exportusersinfo.action?classId="+classId+"&opageNo="+opageNo);
		}
	
}

</script>
</head>
<body>
<form action="" id="maininform">
<s:if test="export">
导出学员信息页数(默认从1开始)：<input type="text" id="opageNo" name="opageNo" value="${opageNo }"/>
<br />
<a id="a0" href="" onclick="submit(0)">导出缴费且没有报班的学员信息</a><br />
<a id="a1" href="" onclick="submit(1)">导出缴费且报班的学员信息</a><br />
</s:if><s:else>
超出总页数：${totalPages}<br />
<a href="${ctx}/exportusersinfo.action">返回</a>
</s:else>
</form>
</body>
</html>

