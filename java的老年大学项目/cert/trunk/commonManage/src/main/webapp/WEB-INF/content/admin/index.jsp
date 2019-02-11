<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>业务管理-<%@ include file="/common/title.jsp"%></title>
<%@ include file="/common/admin_meta.jsp"%>

<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		window.domain = "localhost";
	});

	function iFrameHeight() {
		var ifm = document.getElementById("mainFrame");
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
		}
	}
</script>
</head>
<body>
	<!--header start-->
	<jsp:include page="/common/adminHeader.jsp">
		<jsp:param value="index" name="menu" />
	</jsp:include>


	<!--header over-->

	<!--正文开始-->
	<div class="dr-wrapper">
		<!--正文左边开始-->
		<jsp:include page="/common/adminLeft.jsp">
			<jsp:param value="courselist" name="menu" />
			<jsp:param value="course" name="bigmenu" />
		</jsp:include>
		<!--正文右边开始-->
		<section id="main" role="main">
			<div class="dr-container-fluid" style="padding-top:200px; ">
				<center>
					<h3>欢迎进入后台管理</h3>
					<h3>轻松管理从这里开始</h3>
				</center>
			</div>
			<!--header start-->
			<jsp:include page="/common/adminFooter.jsp">
				<jsp:param value="index" name="menu" />
			</jsp:include>
			<!--header end-->
		</section>
		</section>
		<!--the end of main-->
	</div>
	<!--正文结束-->

	<script type="text/javascript">
		
	</script>
</body>
</html>