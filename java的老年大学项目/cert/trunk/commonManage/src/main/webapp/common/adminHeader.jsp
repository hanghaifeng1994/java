<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.date.DateUtils"%>
<%@page import="java.util.Date"%>
<%@page import="cn.common.lib.util.web.RequestUtils"%>
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<link rel="shortcut icon" type="image/png" href="${ctx}/images/browser_logo.png">
<script type="text/javascript"> 
	function changeRole(obj){		
	   window.location.href="${ctx}/admin/index.action?curRoleId="+obj.value;
	}
</script>
<!--header start-->
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="navbar-header ml10">
	<img src="${ctx}/images/manage.png" style="float:left; padding-top: 6px;width:48px;height:38px" />
	<a class="navbar-brand" href="${mainUrl}/index.action" style="padding-left: 1px;">系统 - 后台管理</a>
	</div>
	<div class="collapse navbar-collapse" id="admin_menu">
	<ul class="nav navbar-nav navbar-right dr-nav-toolbar">
		   <li class="mr20">
            	  <a data-original-title="退出" data-toggle="tooltip" data-placement="bottom" class="logout" href="<common:prop name="cas.securityContext.logoutUrl" propfilename="application.properties"/>?from=${appFullCtx}/logoutSuccess.jsp"><span class="glyphicon glyphicon-off"></span></a>
            </li>
    </ul>
	</div>
</div>

