<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${trainingPrograms.name}教学阶段<%@ include file="/common/title.jsp" %></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js"
	type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css"
	rel="stylesheet" />

<script>  
	$(document).ready(function() {
		$("#edithour").click(function(){
				if($(this).val()=="修改")
				{
					$("#hours").removeAttr("disabled");
					$(this).val('保存');
					return false;
				}
				 $.get("${ctx}/related/teachplan!saveteachplanhour.action", {id:$("#curplanid").val(),hour:$("#hours").val()}, function (data){
						if(data.teachplan=='ok')alert('保存年度学习计划成功!');
					});
			});
	    　　$(".colorbox").colorbox({ width: "100%", height:"100%" , close: "关闭", overlayClose: false,href:'programs!newcourse.action?planid=${planid}'}); <!--调用colorbox，大括号里面是指定该colorbox的属性。。在文章结尾会列出ColorBox的常用属性-->
		
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
 					required: "请输入项目名称",
 					maxlength: "项目名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入项目代码"
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
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="/common/adminHeader.jsp"%>
<div class="admin_tc">
<div class="seemore0">
<div class="ttu"><span class="admin_f14 admin_fw">${trainingPrograms.name}
项目管理</span><span class="light_black"></span></div>
<div class="tt_tab">
<ul id="tab">
	<li class="ttabon"><a
		href="programs!phase.action?itemid=${itemid }&menu=menu"
		class="tt_tabon">阶段设置</a></li>
	<li class="ttabno"><a
		href="programs!teachcontent.action?itemid=${itemid }"
		class="tt_tabon">教学内容设置</a></li>
	<li class="ttabno"><a href="programs!minput.action?id=${itemid }">培训项目属性设置</a></li>
	<li class="ttabno"><a
		href="programs!studentlog.action?id=${itemid }">学员培训记录查询</a></li>
</ul>
</div>

<table width="98%" align="center" bordercolor="#ACCEE8"
	class="admin_tab10" style="margin-top: 15px;">
	<tr>
		<td class="buleleft">培训项目名称</td>
		<td width="35%">${trainingPrograms.name }</td>
		<td width="13%" class="buleleft">培训项目代码</td>
		<td width="39%">${trainingPrograms.code }</td>
	</tr>
	<tr>
		<td class="buleleft">毕业学时要求</td>
		<td>${trainingPrograms.hours }学时</td>
	</tr>
</table>

<table width="98%" border="0" align="center" cellspacing="0"
	class="tabcleck">
	<tr>
		<td class="buleleft">阶段名称</td>
		<td class="buleleft">要求学时</td>
		<td class="buleleft">状态</td>
		<td class="buleleft">操作</td>
	</tr>
	<s:iterator value="PhasePage.result" status="stat">
		<tr>
			<td>${name}</td>
			<td>${hours}</td>
			<td>${openStr}</td>
			<td rowspan="2"><a
				href="programs!teachplan.action?planid=${id }&itemid=${trainingPrograms.id}&t=m">管理</a>
			<a href="#"
				onclick="delRecord('${ctx }/train/manage/programs!teachplandelete.action?id=${id }&itemid=${itemid }&menu=menu');">删除</a>
			</td>
		</tr>
	</s:iterator>
</table>

<form id="form1" action="programs!saveplan.action" method="post">
<input type="hidden" name="id" value="${id}" /> <input type="hidden"
	name="itemid" value="${trainingPrograms.id}" /> <input type="hidden"
	name="menu" value="menu" /> <input type="hidden" name="t" value="${t}" />

<table style="margin-bottom: 5px;">
	<tr>
		<td class="tdll">&nbsp;</td>
		<td><s:if test="planid==null">
		
	年	<s:select  list="years" theme="simple" name="year" listKey="value" listValue="label" headerKey="" headerValue="选择年"></s:select>	名称<input type="text" value="" name="planname" />
			<input name="Submit32" type="submit" class="operation_btu1"
				value="新增年度教学计划" />
		</s:if> <s:if test="t!=null">
			<input type="button" value="添加新课程" class="operation_btu1 colorbox" />
			<input type="button" value="返回计划列表" class="operation_btu1"
				onclick="window.location='programs!teachplan.action?itemid=${itemid}&menu=menu'" />

		</s:if></td>
		<td class="tdll" style="padding-left: 20px;"><input
			name="Submit321" type="button"
			onclick="window.opener=null;window.open('','_self');window.close();"
			class="operation_btu2" value="关 闭" /></td>
	</tr>
</table>

</form>
</div>
</div>
</body>
</html>