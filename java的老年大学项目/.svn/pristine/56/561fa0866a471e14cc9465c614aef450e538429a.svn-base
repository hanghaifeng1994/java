<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("user",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","user.webapp.url"));
request.setAttribute("course",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","course.webapp.url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>基础数据<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
	<%@ include file="/common/meta.jsp" %>
    <link href="${staticurl}/css/master.css" rel="stylesheet" type="text/css"/>
	<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
	<script src="${staticurl}/js/table.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $(document).ready(function(){          
		   $("#checkboxall").click(function(){
			     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			});
	    });

    </script>	
</head>
<body>
  	<!-- 正文内容 start -->
 		<div id="content"> 
    		<div class="right_shell"> 
				<h2 class="mb10 box_solid_bottom">基础数据管理 </h2>	
				<form id="mainForm" action="basedata.action" method="post">
					<div class="top_serach_box">
	    				<span>名称： <input type="text" id="name" name="name" value="${param['name']}" size="30"/></span>
	    				<span>类型：<s:select  list="dataTypeList" listKey="value" listValue="label" id="datatype" name="datatype"  value="#parameters.datatype" cssStyle="width:150px"   theme="simple"  headerKey="" headerValue="--选择--"/></span>
						<p class=" box_dotline_top clearb"><button type="submit">搜索</button></p>  
	    			</div>
					<button id="btnCreate" type="button" onclick="window.location.href='basedata!input.action'">新增</button>
					<div id="message" style="line-height: 35px;">
						<s:actionmessage theme="custom" cssClass="tipbox"/>
					</div>
	    			<table class="tablebox mt10">
	    				<tr>
	    					<th width="5%"><input id="checkboxall" name="checkboxall" type="checkbox" /></th>
	    					<th>名称</th>
	    					<th>类型</th>
	    					<th>操作</th>
	    				</tr>
	    				<s:iterator value="page.result">
		    				<tr>
		    					<td><input type="checkbox" id="ids" name="ids" value="${id}"/></td>
		    					<td>${name}</td>
		    					<td>${typeName}</td>
		    					<td>
		    						<a href="basedata!input.action?id=${id}" >修改</a>   
		    						<a href="javaScript:delRecord('basedata!delete.action?id=${id}');">删除</a>
		    					</td>
		    				</tr>
	    				</s:iterator>
	    			</table>
	        		<p class="box_dotline_top"></p>
					<%@ include file="/common/turnpage.jsp"%>
				</form>
    		</div>
    		
   			 <!-- 右侧内容 end --> 
    		<p class=" del_float"></p>
  		</div>
  		<!-- 正文内容 end --> 
</body>
</html>
