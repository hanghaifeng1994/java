<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("user",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","user.webapp.url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>基础数据管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
	<%@ include file="/common/meta.jsp" %>
	<link href="${staticurl}/css/master.css" rel="stylesheet" type="text/css" />
	<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet"/>
	<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
	<script src="${staticurl}/js/validate/jquery.validate.js" type="text/javascript"></script>
	<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
	<script src="${staticurl}/js/related.js" type="text/javascript"></script> 
	<script type="text/javascript">
		$(document).ready(function() { 
			//聚焦第一个输入框
		
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					name: {
						required: true
					},
					datatype: {
						required: true
					}
				},
				messages: {
					name: {
						required:"请输入名称"
					},
					datatype:{
						required:"请选择类型"
					}
				}				
			});
		});

			
			
	</script>
</head>
<body>  
	<div id="content">
        	<!-- 右侧内容 start -->
	    <form id="inputForm" name="inputForm" action="basedata!save.action" method="post">
	    	<input id="id" name="id" type="hidden" value="${id}" size="30"/>
		    <div class="right_shell"> 
				<h2 class="mb10 box_solid_bottom"><s:if test="id==null||id==''">新增</s:if><s:else>修改</s:else>基础数据</h2>
		        <div id="a_1_box" style="display:block;">
			        <ul class="form_list">
			        	<li> 
			            	<span class="colorred">以下有*的内容为必填项：</span>
			            </li>
			            <li> 
			            	<label>名称<b>*</b></label><input id="name" name="name" value="${name}" type="text" size="30"/>
			            </li>
			            <li>
			             	<label>类型<b>*</b></label><s:select  list="dataTypeList" listKey="value" listValue="label" id="datatype" name="datatype"  value="datatype"  theme="simple" cssStyle="width:150px"  headerKey="" headerValue="--选择--"/>
			            </li>
			            <li>
			             	<label>备注</label>
			             	<textarea rows="3" cols="30" id="remark" name="remark">${remark}</textarea>
			           </li>
			        </ul>
			        <p class="box_dotline_top"></p>
					<p class="ml_100 mt5">
						<button type="submit" class="course_btn_orange">保存</button>   &nbsp;&nbsp; 
						<button class="course_btn_grey" type="button" onclick="location.href='basedata.action'">取消</button></p>
		        </div>
		    </div>
	    </form>
            
        </div>
    </body>
</html>
