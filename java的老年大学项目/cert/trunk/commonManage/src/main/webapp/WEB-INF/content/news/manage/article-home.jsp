<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>JSSTUDY-ONLINE证书管理</title>
	<%@ include file="/common/meta.jsp" %>
	<link href="${ctx }/css/backend.css" rel="stylesheet" type="text/css" /> 
	<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
	<script src="${staticurl}/js/table.js" type="text/javascript"></script> 
	<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet"/>
	<script src="${staticurl}/js/validate/jquery.validate.js" type="text/javascript"></script>
	<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
	 
</head>
<body>   
<!--the beginning of 中间-->
 <!--the beginning of 头部--><!--the beginning of 导航--><!--the beginning of 中间-->
        <div id="content">
            <div class="box"> 
			<form id="form1" name="form1" action="note!save.action" method="post">  
				<input type="hidden" name="id" value="${id}" />
                <div class="title">
                    <h2 class="ll"><s:if test="type==1">公告</s:if><s:if test="type==2">培训广场</s:if><s:if test="type==3">常见问题</s:if>详细</h2>
                </div>
                <div class="detailbox">
                	<div class="n_status " style="margin-right: 10px;float: right;">
                	 	<label>
                            	发布人
                        </label> ${articleConfig.publisherName }
                        <label style="margin-left: 8px;">
                            	发布日期
                        </label><s:date name="articleConfig.pubTime" format="yyyy.MM.dd"/>
                	</div>
                	<p>&nbsp;</p>
                	<p>&nbsp;</p> 
                    <div> 
                    <table border="0" width="100%">
                    	<tr><td style="width: 10%;vertical-align: top;margin-top: 20px;"><label>标题</label></td><td>${articleConfig.title }</td></tr>
                    	<tr height="18px"><td colspan="2">&nbsp;</td></tr>
                    	<tr><td style="vertical-align: top;"><label>内容</label></td><td>${articleConfig.content }</td></tr>
                    </table> 
                	</div>
                	</div>	
                </form>
            </div>
        </div>
        <p>&nbsp;</p>   
</body>
</html>
