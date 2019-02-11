<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${programDTO.name}教学内容<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />

<script>  
	$(document).ready(function() {
	    if($("#success").text()!="")$("#div-success").show();
	    if($("#error").text()!="")$("#div-error").show();
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
 		//$("#name").focus();
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

	function delTeachContent(id){
 		var oaction = document.getElementById("deleteForm").action;
 		document.getElementById("deleteForm").action="${ctx }/train/manage/teachcontent!delete.action?id="+id+"&programId=${programId}";
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
	   	});
 	}
</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>
<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--正文开始-->
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">

<div class="dr-page-header">
<h3>
<label style="margin-right: 10px;">${programDTO.name}</label>项目管理
</h3>
</div>
<hr />
   <!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
	 	<li><a href="programs!minput.action?id=${programId}">培训项目属性设置</a></li>
        <li><a style="cursor: pointer;" href="phase.action?programId=${programId}">项目阶段</a></li>
        <li class="active"><a style="cursor: pointer;" href="teachcontent.action?programId=${programId}&menu=menu">教学内容设置</a></li>
        <li><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>                
</div>
<div class="tab-content dr-tabs-panel">
	<div class="panel-body row">
		<table class="table table-bordered dr-table-default">
			<tr>
				<th>培训项目名称</th>
				<td>${programDTO.name }</td>
				<th>培训项目代码</th>
				<td>${programDTO.code }</td>
				<th>毕业学分要求</th>
				<td>${programDTO.hours }学分</td>
			</tr>
		</table>
		<form name="deleteForm" id="deleteForm" action="teachcontent.action"method="post">
			<div class="panel panel-default">
				<div class="btn-toolbar dr-btn-toolbar">
					<button class="btn btn-primary btn-sm" type="button"
					onclick="window.location='teachcontent!input.action?programId=${programId}'">
					<span class="glyphicon glyphicon-plus"></span>
					新增教学内容
					</button>
				</div>
				<table class="table table-bordered dr-table-default">
				<tr>
					<th width="20%">名称</th>
					<th>版本号</th>
					<th>必修</th>
					<th>选修</th>
					<th>总计</th>
					<th width="25%">操作</th>
				</tr>
				<s:iterator value="page.result" status="stat">
					<tr>
						<td>${name}</td>
						<td>第${version}版</td>
						<td>${mustPublicCount }门(${mustPublicLength }课时)</td>
						<td>${selectPublicCount }门(${selectPublicLength }课时)</td>
						<td >${teachcontentCoursesCount }门(${teachcontentCoursesLength }课时)</td>
						<td >
						<div class="btn-group">
						<a class="btn btn-primary btn-sm"
							href="teachcontent!input.action?id=${id}&programId=${programId}">
							<span class="glyphicon glyphicon-cog"></span>&nbsp;修改</a>
						</div>
						<div class="btn-group">
						<a class="btn btn-primary btn-sm"
							href="teachcontent!info.action?id=${id }&programId=${programId}&t=m">
							<span class="glyphicon glyphicon-cog"></span>&nbsp;管理</a>
						</div>
						
						<div class="btn-group">
						<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="delTeachContent(${id})">
		                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
		           		</button>
						</div>
						</td>
					</tr>
				</s:iterator>
				</table>
				<%@ include file="/common/turnpage.jsp"%>
			</div>
		</form>
	</div>

<!--<div class="panel-body row">
<table class="table table-bordered dr-table-default">
	<tr>
		<th>模块</th>
		<th width="20%">教学内容名称</th>
		<th>版本号</th>
		<th>必修</th>
		<th>选修</th>
		<th>总计</th>
		<th>操作</th>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>${name}</td>
			<td>第${version}版</td>
			<td>${mustPublicCount }门(${mustPublicLength }课时)</td>
			<td>${SelectPublicCount }门(${SelectPublicLength }课时)</td>
			<td >${PlanCoursesCount }门(${PlanCoursesLength }课时)</td>
			<td >
			<div class="btn-group">
			<a class="btn btn-primary btn-sm"
				href="programs!teachplan.action?planid=${id }&itemid=${trainingPrograms.id}&t=m">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;管理</a>
			</div>
			<div class="btn-group">
			<a href="#" class="btn btn-default  btn-sm"
				onclick="delRecord('${ctx }/train/manage/programs!teachplandelete.action?id=${id }&itemid=${itemid }&menu=menu');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
			
			</div>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
--><!--<form id="form1" action="teachcontent!save.action?programId=${programDTO.id}" method="post">
	<input type="hidden" name="id" value="${id}" /> 
	<input type="hidden" name="programId" value="${programDTO.id}" /> 
	<input type="hidden" name="menu" value="menu" /> 

<table style="margin-bottom: 5px;margin-left: 10px;">
	<tr>
		<s:if test="id==null">
		<td>
		名称
		</td>
		<td>&nbsp;</td>
		<td>
		<input type="text" value="${teachContentName}" name="name" class="form-control"/>
		</td>
		<td>&nbsp;</td>
		<td>
		<div class="btn-group">
		<button name="Submit32" type="submit" class="btn btn-primary">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;新增教学内容</button>
		</div>
		</td>
		</s:if>
		<s:if test="t!=null">
		<td>
		<div class="btn-group">
		<button class="btn btn-primary">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;添加新课程</button>
		</div>
		</td>
		<td>
        <button class="btn btn-primary"
				onclick="window.location='programs!teachplan.action?itemid=${itemid}&menu=menu'">
		<span class="glyphicon glyphicon-backward"></span>返回计划列表</button>
		</td>
		</s:if>
		<td>
		</td>
		<td style="padding-left: 20px;">
		<button name="Submit321" onclick="window.opener=null;window.open('','_self');window.close();"
			class="btn btn-default">
			<span class="glyphicon glyphicon glyphicon-remove-circle"></span>&nbsp;关闭
		</button>
		</td>
	</tr>
</table>

</form>
-->
</div>
</div>
</section>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>