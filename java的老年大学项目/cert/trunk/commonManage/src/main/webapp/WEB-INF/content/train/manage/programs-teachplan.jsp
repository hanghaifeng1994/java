<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理${trainingPrograms.name}教学计划<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
%> 
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script>  
   function addcourse(){
	b_IframeLevel("${currentTenant.doname}/train/manage/programs!addcourse.action?planid=${planid}",1050,400,tst);
    };
  function tst(){window.location.reload();};
	$(document).ready(function() {
		$("#edithour").click(function(){
			
				if($("#edithour2").attr("class")=='glyphicon glyphicon-cog')
				{
					$("#currence").removeAttr("disabled");
					$(this).html('<span class="glyphicon glyphicon-ok" id="edithour2"></span>&nbsp;保存');
					return false;
				}
				$.get("${ctx}/related/teachplan!saveteachplancurrency.action", {id:$("#curplanid").val(),currence:$("#currence").val()}, function (data){
						if(data.teachplan=='ok')b_alert('保存学币成功!');
						$("#currence").attr("disabled","disabled");
						$("#edithour").html('<span class="glyphicon glyphicon-cog" id="edithour2"></span>&nbsp;设置');
				});
		});

		$("#editpercent").click(function(){
			if($("#editpercent2").attr("class")=='glyphicon glyphicon-cog')
			{
				$("#percent").removeAttr("disabled");
				$(this).html('<span class="glyphicon glyphicon-ok" id="edithour2"></span>&nbsp;保存');
				return false;
			}
			$.get("${ctx}/related/teachplan!saveteachplanpercent.action", {id:$("#curplanid_01").val(),percent:$("#percent").val()}, function (data){
					if(data.teachplan=='ok')b_alert('设置退单学分要求成功!');
					$("#percent").attr("disabled","disabled");
					$("#editpercent").html('<span class="glyphicon glyphicon-cog" id="edithour2"></span>&nbsp;设置');
			});
		});

		$("#planbut").click(function(){
			if($("#planbut2").attr("class")=="glyphicon glyphicon-eye-open")
			{
				$.get("${ctx}/related/teachplan!open.action", {id:${teachPage.result[0].id}}, function (data){
					if(data.teachplan=='ok'){
						b_alert('计划开放成功!');
						$("#planbut").html('<span class="glyphicon glyphicon-eye-close" id="planbut2"></span>&nbsp;关闭计划');
					}
				});

			}
			if($("#planbut2").attr("class")=="glyphicon glyphicon-eye-close")
			{
				$.get("${ctx}/related/teachplan!close.action", {id:${teachPage.result[0].id}}, function (data){
					if(data.teachplan=='ok'){
						b_alert('计划关闭成功!');
						$("#planbut").html('<span class="glyphicon glyphicon-eye-open" id="planbut2"></span>&nbsp;开放计划');
					}
				});
			}
		});
		
	    　//$(".colorbox").colorbox({ onClosed:function(){window.location.reload(); },width: "90%", height:"95%" , close: "关闭", overlayClose: false,href:'programs!addcourse.action?planid=${planid}'}); <!--调用colorbox，大括号里面是指定该colorbox的属性。。在文章结尾会列出ColorBox的常用属性-->

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
</script>
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
<label style="margin-right: 10px;">${trainingPrograms.name}</label>项目管理
</h3>
</div>
<hr />

<div class="bs-example">
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li class="active"><a style="cursor: pointer;" href="programs!teachplans.action?itemid=${itemid}&menu=menu">教学计划设置</a></li>
        <li><a href="programs!minput.action?id=${itemid}">培训项目属性设置</a></li>
        <!--<li><a href="programs!studentlog.action?id=${itemid}">学员培训记录查询</a></li>
        --><li><a href="${staticurl}/clazz/manage/clazz.action?programsid=${itemid}">项目班级</a></li>
    </ul>                
</div>

<div class="tab-content dr-tabs-panel">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="13%">项目类型</th>
		<td>${trainingPrograms.name }(${trainingPrograms.catName })</td>
		<th width="13%">培训项目代码</th>
		<td width="39%">${trainingPrograms.code }</td>		
	</tr>
	<tr>
		<th>计划名称</th>
		<td width="35%">${teachPage.result[0].name}</td>
		<th width="13%">是否开放</th>
		<td width="39%">
		<s:if test="teachPage.result[0].open">
		<button class="btn btn-default  btn-sm" id="planbut" style=" vertical-align:middle;">
		<span class="glyphicon glyphicon-eye-close" id="planbut2"></span>&nbsp;关闭计划</button>
		</s:if>
		<s:else>
		<button class="btn btn-primary btn-sm" id="planbut" style=" vertical-align:middle;">
		<span class="glyphicon glyphicon-eye-open" id="planbut2"></span>&nbsp;开放计划</button>
		</s:else>
		</td>
	</tr>
	<tr>
		<th>项目学分要求</th>
		<td>${trainingPrograms.hours}学分</td>
		<th>计划学币要求</th>
		<td><div><div style="float: left;">
		<div class="input-group">
		<input disabled="disabled" type="text" id="currence" style="width: 80px;" class="form-control"
			 value="${teachPage.result[0].currence }"/>
		<span class="input-group-addon" style="width:50px;">学币</span> 
		</div>
		<input
			type="hidden" value="${teachPage.result[0].id }" id="curplanid"/>
		</div>
		<button type="button" class="btn btn-primary btn-sm ml10" id="edithour" style=" vertical-align:middle;">
		<span class="glyphicon glyphicon-cog" id="edithour2"></span>&nbsp;修改</button>
		</div>
        </td>
	</tr>
	<tr>
		<th>学制</th>
		<td>${trainingPrograms.xuezhi } 年</td>
		<th>退单学分限制</th>
		<td><div style="float: left;">
		<div class="input-group">
		<input type="text" id="percent" style="width: 80px" class="form-control"
			disabled="disabled" value="${teachPage.result[0].percent }"/>
			<span class="input-group-addon" style="width:53px;">%</span>
		</div>
		<input type="hidden" value="${teachPage.result[0].id }" id="curplanid_01" />
		</div>
		<button type="button" class="btn btn-primary btn-sm" id="editpercent" style="vertical-align:middle;margin-left: 10px;">
		<span class="glyphicon glyphicon-cog" id="editpercent2"></span>&nbsp;修改</button>	
        </td>
	</tr>
</table>
</div>
</div>

<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="20%">教学计划年度</th>
		<!--<th>模块</th>-->
		<th >教学计划名称</th>
		<th >必修</th>
		<th >选修</th>
		<th >总计</th>
	</tr>
	<s:iterator value="teachPage.result" status="stat">
		<tr>
			<td>${year}年<font color="red"></font></td>
			<td>${teachPage.result[0].name}<font color="red"></font></td>
			<!--<td>必修课</td>-->
			<td>${mustPublicCount }门(${mustPublicLength }课时)</td>
			<td>${SelectPublicCount }门(${SelectPublicLength }课时)</td>
			<td >${PlanCoursesCount }门(${PlanCoursesLength }课时)</td>
		</tr>
		<!--<tr>
			<td>选修课</td>
			<td>${mustSpecialCount }门(${mustSpecialLength }课时)</td>
			<td>${SelectSpecialCount }门(${SelectSpecialLength }课时)</td>
		</tr>-->
	</s:iterator>
</table>
</div>
</div>

<form id="mainForm" name="mainForm" action="programs!teachplan.action" class="form-inline dr-form-inline"
	method="post">
	<input type="hidden" name="page.pageNo"	id="pageNo" value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="t" id="order" value="${t}" /> <input
	type="hidden" name="planid" id="order" value="${planid}" /> <input
	type="hidden" name="itemid" id="order" value="${itemid}" /> <input
	type="hidden" name="menu" id="menu" value="menu" />

<!--<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
	<tr>
		<td width="30%">课程模块<s:checkboxlist
			name="filter_EQI_course$courseModel" list="#{'必修课':1,'选修课':2}"
			theme="simple" listKey="value" listValue="key"
			value="@java.lang.Integer@parseInt(#parameters.filter_EQI_course$courseModel)">
		</s:checkboxlist>
		</td>
		<td width="30%">课程属性<s:checkboxlist name="filter_EQI_courseProp"
			list="#{'必修':2,'选修':1}" theme="simple" listKey="value"
			listValue="key"
			value="@java.lang.Integer@parseInt(#parameters.filter_EQI_courseProp)"></s:checkboxlist></td>
			
			

		<td rowspan="2"><input type="submit" value="查询" class="operation_btu1" /></td>
			<td style="border-left:solid 2px #dfdfdf; " align="right">学分要求 <input type="text" id="hours" style="width: 80px"
			disabled="disabled" value="${teachPage.result[0].hours }" /> 学分/年 <input
			type="hidden" value="${teachPage.result[0].id }" id="curplanid" />
		<input type="button" value="修改" id="edithour" style=" vertical-align:middle; "
			class="operation_btu1" /></td>
	</tr>
</table>
</div>
</div>-->

 
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
    <tr >
    <td  colspan="5" width="30%">
	 <div class="form-group">
     <label>课程属性&nbsp;&nbsp;</label><s:select list="#{'2':'必修','1':'选修'}" listKey="key" listValue="value" name="filter_EQI_courseProp" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.filter_EQI_courseProp)" cssClass="form-control input-sm"></s:select>
     </div>
     <div class="form-group">
   <button class="btn btn-default btn-sm" type="submit">
	<span class="glyphicon glyphicon-search"></span>
	搜索
	</button>
	</div>
   
	</td>
    </tr>
	<tr>
		<th >课程名称</th>
		<th width="20%">课程代码</th>
		<th width="10%">课程学分</th>
		<!--<th>模块</th>-->
		<th width="10%">属性</th>
		<th width="35%">操作</th>
	</tr>
	<s:iterator value="planCoursePage.result" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;${course.serialNo}</td>
			<td>&nbsp;${course.studylength}</td>
			<!--<td>&nbsp;${course.courseModelString }</td>-->
			<td>&nbsp;${coursePropString }</td>
			<td><a href="#" class="btn btn-default  btn-sm"
				onclick="delRecord('${ctx }/plancourse/manage/plancourse!delete.action?ids=${id }&itemid=${itemid }&planid=${planid }&menu=menu');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除（不影响已有班级）</a>
				&nbsp;<a href="#" class="btn btn-default  btn-sm"
				onclick="delRecord('${ctx }/plancourse/manage/plancourse!delete.action?ids=${id }&itemid=${itemid }&planid=${planid }&affectExistClazz=true&menu=menu');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除（影响已有班级）</a></td>
		</tr>
	</s:iterator>
</table>
</div>
</div>

</form>

<table style="margin-bottom: 5px;margin-left: 10px;">
	<tr>
		<td class="tdll">&nbsp;</td>
		<td>
		<button class="btn btn-primary btn-sm"  onclick="addcourse()">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;添加新课程</button>
		</td>
		<td>&nbsp;</td>
		<td>
         <button class="btn btn-primary btn-sm"
				onclick="window.location='programs!teachplans.action?itemid=${itemid}&menu=menu'">
		<span class="glyphicon glyphicon-backward"></span>&nbsp;返回计划列表</button>
		</td>
		<td>
			<!--<input type="button" value="添加新课程" class="operation_btu1 colorbox" />
		--></td>
		
		<td class="tdll" style="padding-left: 20px;">
		<button name="Submit321" onclick="window.opener=null;window.open('','_self');window.close();"
			class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon glyphicon-remove-circle"></span>&nbsp;关闭
		</button>
		</td>
	</tr>
</table>

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