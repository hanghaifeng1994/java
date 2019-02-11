<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="common" uri="http://www.common.lib/tags/util"%>
<%@ taglib prefix="ckfinder" uri="http://cksource.com/ckfinder"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@page import="cn.common.lib.util.web.RequestUtils"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="appFullCtx" value="<%=RequestUtils.getWebURL(request)%>"/>
<%
	request.setAttribute("staticurl", PropertyUtils
			.getPropertyWithConfigName("sysconfig.properties",
					"static.url",request.getContextPath()));
%>