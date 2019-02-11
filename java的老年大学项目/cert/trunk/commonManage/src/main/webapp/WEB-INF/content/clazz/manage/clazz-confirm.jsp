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
 			},
 			messages: {
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入班级代码"
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
<h2 class="ll">审核班级申请</h2>

</div>
<div class="detailbox">
<div id="message"><s:actionmessage theme="custom"
	cssClass="tipbox" /></div>
<form id="form1" action="clazz!save.action" method="post">
<input type="hidden" name="id" value="${id}" />
<input type="hidden" value="${flag }" name="flag" />
<input type="hidden" value="check" name="fromPage" />
<div id="news_edit" class="form input mb20">
<ul>
	<li><label style="width: 100px;"> 项目类型<cite>*</cite>&nbsp;
	</label> ${clazz.itemCategoryName } <span class="ml10 font999"> </span></li>

	<li><label style="width: 100px;"> 培训项目名称<cite>*</cite>&nbsp;
	</label> ${clazz.trainingProgramsName }</li>

	<li><label style="width: 100px;"> 年度教学计划 <cite>*</cite>&nbsp;
	</label> ${clazz.planName}<span class="ml10 font999"></span></li>

	<li><label style="width: 100px;">培训项目代码<cite>*</cite>&nbsp;
	</label> ${clazz.trainingProgramsCode }<span class="ml10 font999"> <strong
		id="error_name"></strong> </span></li>

	<li><label style="width: 100px;">班级名称<cite>*</cite>&nbsp;
	</label> ${clazz.name }<span class="ml10 font999"> <strong
		id="error_name"></strong> </span></li>

	<li><label style="width: 100px;"> 班级代码<cite>*</cite>&nbsp;
	</label> ${clazz.code }<span class="ml10 font999"> <strong
		id="error_code"></strong> </span></li>

	<li><label style="width: 100px;">班级类型<cite>*</cite>&nbsp;
	</label> ${clazz.modelString }</li>

	<li><label style="width: 100px;">班级人数<cite>*</cite>&nbsp;
	</label> 0</li>
	<li><label style="width: 100px;">班级开放时间<cite>*</cite>&nbsp;
	</label> ${clazz.startDate }</li>
	<li><label style="width: 100px;">选课数量<cite>*</cite>&nbsp;
	</label> ${clazz.courseCount}</li>
</ul>
</div>
</form>
</div>
</div>
</div>
<p>&nbsp;</p>
</body>
</html>
