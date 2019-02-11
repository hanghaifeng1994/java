<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>江苏学习在线管理后台-backend.js-study.cn</title>
<%@ include file="/common/meta.jsp"%>
<link href="${ctx }/css/backend.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<script>  
	$(document).ready(function() {
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
			,descr:
			{
				required: true
			}
			,xuezhi:
			{
				required: true
			}
			,hours:
			{
				required: true
			}
			,pic:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入项目名称",
 					maxlength: "项目名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入项目编号"
				} 
				,descr:
				{
					required: "请输入项目介绍"
				} 
				,xuezhi:
				{
					required: "请输入学制"
				} 
				,hours:
				{
					required: "请输入学分"
				} 
				,pic:
				{
					required: "选择一个项目图片"
				} 
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});
</script>
</head>

<body>
<!--the beginning of 头部-->
<!--the beginning of 导航-->
<!--the beginning of 中间-->

<div id="content">
<div class="box">
<div class="title">
<h2 class="ll">教学计划设置</h2>
</div>
<div class="detailbox">
<div id="message"><s:actionmessage theme="custom"
	cssClass="tipbox" /></div>
<form id="form1" action="programs!save.action" method="post"><input
	type="hidden" name="id" value="${id}" />
<div id="news_edit" class="form input mb20">
<ul>
	<li><label style="width: 95px;"> 项目类型&nbsp; </label> ${itemcategory.Name }<span
		class="ml10 font999"> </span></li>


	<li><label style="width: 95px;"> 培训项目名称&nbsp; </label> ${name}</li>

	<li><label style="width: 95px;"> 培训项目代码&nbsp; </label>
	${code}
	<span
		class="ml10 font999"> <strong id="error_code"></strong> </span></li>

	<li><label style="width: 95px;"> 学制&nbsp; </label>
	${trainingPrograms.xuezhi }
	 <span
		class="ml10 font999"> <strong id="error_descr"></strong> </span></li>
	<li><label style="width: 95px;">毕业时要求&nbsp; </label> ${trainingPrograms.hours} 学分/年<span
		class="ml10 font999"> </span></li>



	<li><input type="hidden" name="enable" value="true" /></li>

</ul>
</div>
<div class="tc" style="text-align: left; width:120px; float: left;"><input
	class="button01" type="submit" value="新增教学计划" /> </div>
</form>
</div>
</div>
</div>
<p>&nbsp;</p>
</body>
</html>
