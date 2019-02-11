<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-信息预览</title>
<%@ include file="/common/admin_meta.jsp"%>
<script>
	
</script>
<style>
.pagenew h1 {
    display: block;
    font-size: 30px;
    line-height: 40px;
    text-align: center;
}
.pagenewf {
    background: none repeat scroll 0 0 #F2F2F2;
    border-top: 1px dotted #D2D2D2;
    height: 25px;
    line-height: 25px;
    margin: 25px 0;
    text-align: center;
}
.pagenew p {
    font-size: 14px;
    line-height: 28px;
    margin-bottom: 15px;
    text-align: left;
    text-indent: 20px;
}
element.style {
    font-family: 宋体;
    font-size: 12pt;
    line-height: 26pt;
    text-indent: 24pt;
}
</style>
</head>
<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end -->
<!-- container start -->
<div class="dr-wrapper">
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>信息内容管理 <small>&nbsp;预览信息内容</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    <!-- 信息 -->
    <div class="panel panel-default">
    <div class="pagenew">
      <h1>${article.title }</h1>
      <div class="pagenewf"><span class="color666">信息来源：  ${article.unit}</span> <span class="color999">发表时间：<s:date name="article.pubTime" format="yyyy.MM.dd HH:mm"/> </span> <span>字体大小【<a href="#" class="ablack">大</a>、<a href="#" class="ablack">中</a>、<a href="#" class="ablack">小</a>】</span></div>
      
   	${article.content}
    </div>
    </div>
    <!-- 信息 -->   
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
   <!--footer over-->
	</section>
</div>
<!-- container end -->

</body>
</html>