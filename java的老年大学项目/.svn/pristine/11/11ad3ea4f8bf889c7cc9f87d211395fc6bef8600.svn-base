<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班主任任命-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/list2list.js" type="text/javascript"></script>
<script type="text/javascript">  
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
    $('#inputForm').submit(function() {
       $("#clazzmanager option").each(function() {
          $("#inputForm").append("<input type='checkbox' name='clazzmanagers' checked='checked'  style='display:none' value='" + $(this).val() + "'/>");
      })
   });

    jQuery("#moveright").click(function(){
		var num = 6;
		if (($("#clazzmanager option").length + $("#userPage option:selected").length) <= num){
			jQuery(this).listTolist("userPage","clazzmanager","append",false);
		}
		//else {
			//b_alert("最多"+num+"个班主任！");
		//}
		$("#userPage option:selected").each(function(){
			$(this).attr("selected","");
		});
	});

    jQuery("#delete").click(function(){
    	$("#clazzmanager option:selected").remove();
    });
});

</script>
<style type="text/css">
 .txtwb {
    border: 1px solid #CCCCCC;
    height: 80px;
    margin: 10px auto;
    width: 96%;
}

</style>
</head>
<body>
<!--页头部-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>

<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
    <div class="dr-page-header">
     <h3>班主任任命</h3>
   </div>
   <hr/>
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
<div class="panel panel-default mt10">
  <div class="panel-heading">
    <h3 class="panel-title">
       <s:if test='!clazzDTO.selfClass'>集体</s:if><s:else>自主</s:else>报名班级"${clazzDTO.name}"管理
    </h3>
    <div class="panel-toolbar">
       <ul class="nav nav-tabs pull-right">
         	<li><a href="clazz!minfo.action?id=${id }<s:if test='!clazzDTO.selfClass'>&flag=group</s:if>" >班级信息</a></li>
         	<li><a href="clazz!learningcount.action?id=${id }" >班级学情统计</a></li>
	     <!--<s:if test='!clazz.selfClass'>-->
	     <!--</s:if>-->
	     <li><a href="clazz!mcourse.action?id=${id }">班级课程</a></li>
	     
	    <li><a href="clazz!mstudents.action?id=${id }">班级学员</a></li>
	    <li class="active"><a href="clazz!mmanager.action?id=${id }">班主任任命</a></li>
	    <s:if test='!clazzDTO.selfClass'>
		   <li><a href="clazz!mcost.action?id=${id }">费用结算</a></li>
	    </s:if>
       </ul>
    </div>    
  </div>

<form id="mainForm" action="clazz!mmanager.action?id=${id}" method="post">
<input type="hidden" name="clazzid" value="${id}" />
<input type="hidden" name="page.pageNo" id="pageNo" value="1"/>
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}"/>

<div class="panel panel-default mt10 mb10 ml5 mr5">
   <div class="panel-heading">
     <h3 class="panel-title">班主任分配</h3>
     <div class="panel-toolbar text-right dr-slash-text small">
   </div>
  </div>
<table width="96%" class="table table-bordered dr-table-bordered">
	<tr>
		<td width="45%" valign="top">
		<s:select size="10"  cssClass="txtwb"
			id="clazzmanager" list="headerClazzList" listKey="username" listValue="nameplusidcard"  theme="simple">
		</s:select>
		<button class="btn btn-default" type="button" id="delete" name="Submit32222">
               <span class="glyphicon glyphicon-trash"></span>
                                      删除班主任
           </button> 
		</td>
		<td width="2%" valign="top">
		<a href="javascript:void(0)">
		<span id="moveright" class="glyphicon glyphicon-arrow-left" style="margin-top: 130px;" title="左移"></span>
		</a>
		</td>
		<td>
			<table>
			<tbody>
			<tr>
			<td width="3%" style="padding-right:5px">姓名</td>
			<td width="15%" style="padding-right:5px"><input style="display: inline"  name="name" type="text" class="form-control input-sm" value="${name}"/></td>
			<td width="4%" style="padding-right:5px">用户名</td>
			<td width="15%" style="padding-right:5px"><input style="display: inline" name="username" type="text" class="form-control input-sm" value="${username}"/></td>
			<td width="11%">
			<button name="Submit" class="btn btn-default btn-sm" type="submit">
	        <span class="glyphicon glyphicon-search"></span>
	                       搜索
	        </button>
			</td>
			</tr>
			</tbody>
			</table>
		<s:select size="10"  cssClass="txtwb"
			id="userPage" list="userPage.result" listKey="username" listValue="name+'('+idcard+')'"  theme="simple">
		</s:select> 
		<s:set name="page" value="userPage" scope="request"></s:set>
		<%@ include file="/common/turnpageClazzManager.jsp"%>
		</td>
		<!--<td width="50%" valign="top">
		<div>
		<label class="mt10 ml10">输入教师的身份证号<span style="color: #737373;">（必须是已注册的用户）</span></label>
		</div>
		<div>
		  <input type="text" id="idcard"  class="form-control dr-dib ml10"  style="width:200px;"/>
		  <button class="btn btn-primary" type="button" id="adduser">
              <span class="glyphicon glyphicon-plus"></span>
                                     添加
          </button>
		  <button class="btn btn-default ml10" type="button" id="removemanager">
              <span class="glyphicon glyphicon-trash"></span>
                                   删除
           </button>
         </div>
		</td>
	--></tr>
    <!--<tr style="line-height: 10px;width: 100%;">
	<td width="50"  colspan="2">
	<button class="btn btn-primary" type="button" onclick="saveManager(${id})">
      <span class="glyphicon glyphicon-ok"></span>
      保存班主任任命
   </button>
	<button class="btn btn-default" type="button" style="margin-left: 10px;" onclick="window.opener=null;window.open('','_self');window.close();">
       <span class="glyphicon glyphicon-remove-circle"></span>
                   关闭
    </button>
	</td>
	</tr>
--></table>
</div>
</form>
<form id="inputForm" action="clazz!savemanager.action" method="post">
<input type="hidden" name="clazzid" value="${id}" />
<input type="hidden" name="id" value="${id}" />
<table class="table table-bordered dr-table-bordered">
<tr style="line-height: 10px;width: 100%;">
	<td width="50"  colspan="2">
	<button class="btn btn-primary" type="submit">
      <span class="glyphicon glyphicon-ok"></span>
      保存班主任任命
   </button>
	<button class="btn btn-default" type="button" style="margin-left: 10px;" onclick="window.opener=null;window.open('','_self');window.close();">
       <span class="glyphicon glyphicon-remove-circle"></span>
                   关闭
    </button>
	</td>
</tr>
</table>
</form>
</div>
</div>
</section>
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>