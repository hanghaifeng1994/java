<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
<s:if test="errorList.size>0">
	<div>
	<ul>
	<s:iterator value="errorList" status="stat" id="error">
		<li><s:property value="error"/></li>
	</s:iterator>
	</ul>
	</div>
</s:if>
<s:else>
	验证通过
</s:else>
</body>
</html>
