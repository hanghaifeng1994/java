<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
	request
			.setAttribute(
					"loginUrl",
					PropertyUtils
							.getPropertyWithConfigName(
									"application.properties",
									"cas.securityContext.casProcessingFilterEntryPoint.iloginUrl"));
	request.setAttribute("service", PropertyUtils
			.getPropertyWithConfigName("application.properties",
					"cas.securityContext.serviceProperties.service"));
	request.getSession().setAttribute("curRequestUrl",
			request.getParameter("from") + "${ctx}/index.action");
%>
<html>
<head>
<title>普通用户管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<script src="${staticurl}/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript">	
$(document).ready(function(){    
	if('${threadName}' != ''){
	checkover();
	}
	var flag = '${flag}';
    if(flag == 'true'){
    	$("#div-success").show();
	  	$("#success").text("上传完成，请查看导入结果记录表。");
    	$('#errorResult').show();
    	$('#importnum').show();
    	 $("#flag").val("false");
    }
      	 
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   
		 
   $("#checkboxall").click(function(){
	     
        if($("#checkboxall").attr("checked")=="checked"){
        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
        }else {
          $("input[name='ids']").removeAttr("checked");
         }
   });
	
       //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/user/manage/studentcz!batchDelete.action";
			       if(!checkSelect()) {
			    	   b_alertx("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirmx('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });

			      // if(!confirm('您确定要进行此操作吗?')) return  false;

				  // $("#deleteForm").submit();
				   //document.getElementById("deleteForm").action = oaction;
		   }); 	
		 
     });

function idcardcheck(){
    var idcard = $.trim($("#idcard").val());
    var checkidcard=idCardNoUtil.checkIdCardNo(idcard);
    if(idcard!=""){
    if(!checkidcard)  
      {  
  	  b_alertx("身份证输入不合法");  
          return  false;  
       } 
    } 
	}

function resetPassword(uid)
{
	//if(confirm('密码将重置成身份证后6位数字，确认操作吗?'))
		b_confirmx('密码将重置，确认操作吗?', function()
	{
		 $.post("student!resetPwd.action",{id:uid},function(result){
			    if(result.label=='true')
				   b_alertx('修改密码成功!新密码为'+result.value);
			    else
			    	b_alertx('修改密码失败，稍后重试,'+result); 
		 });
	});	
}
	 function checkSelect() {
		var flag1 = false;
		$("input[name='ids']:checked").each(function(){
			flag1 = true;
		}); 
		return flag1;
	}
		
     function  checkupload(){
          var upload = $("#upload").val();
          if(upload == "" || upload == null){
           b_alertx("上传文件不能为空！");
           }else {
        	   $("#mainForm").submit();   
           }
     } 

	 function checkover(){
			$.ajax({
		        type: "POST",
		        url: "${ctx}/user/manage/student!isFinishSaveStudent.action",
		        data: {
		        	"threadName": '${threadName}',
				},
				dataType:"json",
		        success: function(data) {
					 if(data.value=="true"){
						 var num = data.label.split("_");
						 $("#uploadDiv").hide();
						 $("#uploadResult").show();
						 $('#importnum').show();
						 $('#sucessImport').text(num[0]);
						 $('#uSucessImport').text(num[1]);
						 setTimeout('checkover()',1000);
					 }else{
						 var num = data.label.split("_");
						 $("#flag").val('true');
						 $("#sImportNum").val(num[0]);
						 $("#uImportNum").val(num[1]);
						 $("#mainForm").submit();   
				     } 
		        }
			});
		}

	 if(!document.domain.indexOf("localhost")<1){
	 		document.domain="zjzx.ah.cn";
		 }
		 function setlogin(html){
			 if(html!=null && html!=""){
			 	$("#ilogin_container").html(html);
			 }
	     }
		
	 function login(id){
			$.ajax({ 
				type: "post", 
				url : "${ctx}/user/manage/student!monilogin.action?id="+id, 
				dataType:'json',
		  		success: function(json){
			  		var loginUrl = '${loginUrl}?isInclude=true&renew=true&service='+json.label;
			  		$("#loginFrm").attr("src",loginUrl);
			  		$("#loginFrm").attr("target","_blank");
					var username = json.value.split("_")[0]
					var password = json.value.split("_")[1]	
                    setTimeout(function () {
                        document.forms["fm1"].elements["username"].value = username;
            			document.forms["fm1"].elements["password"].value = password;
            			document.forms["fm1"].submit();
                    }, 500);
		  		}
			});
		}
</script>
</head>
<body>
<jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
</jsp:include>
<div class="dr-wrapper"><jsp:include
	page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="studentlist" name="menu" />
	<jsp:param value="student" name="bigmenu" />
</jsp:include> <section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
	<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a
		href="#">平台首页</a></li>
	<li><a href="#">用户管理</a></li>
	<li class="active">普通用户管理</li>
</ol>
<div class="dr-page-header">
<h3>普通用户管理信息</h3>
</div>
<hr>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success"
	style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage theme="simple" /></span></div>
<div class="alert alert-danger alert-dismissable" id="div-error"
	style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple" /></span></div>
<!--信息提示 end--> <s:if test="nowUser.tenantId==null">
	<ul class="nav nav-tabs nav-justified">
		<s:if test=""></s:if>
		<li class="<s:if test="tabFlag2==null||tabFlag2==''">active</s:if>"><a
			href="student.action">所有普通用户</a></li>
		<li class="<s:if test="tabFlag2=='other'">active</s:if>"><a
			href="student!tenantUserList.action?tabFlag2=other">参与大平台学习的租户用户</a></li>
	</ul>
</s:if><s:else>
	<ul class="nav nav-tabs nav-justified">
		<s:if test=""></s:if>
		<!--<li class="<s:if test="tabFlag2==null||tabFlag2==''">active</s:if>" ><a href="student.action">注册于本租户用户</a></li>
    <li class="<s:if test="tabFlag2=='other'">active</s:if>"><a href="student!tenantUserList.action?tabFlag2=other">参与本租户学习的其他租户用户</a></li>-->
	</ul>
</s:else>
<div class="tab-content dr-tabs-panel">
<form id="mainForm" name="mainForm" action="studentcz.action"
	class="form-inline dr-form-inline" method="post"
	enctype="multipart/form-data">
	<input type="hidden"
	name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	 <input
	type="hidden" name="page.orderBy" id="orderBy"
	value="${page.orderBy}" />
	 <input type="hidden" name="page.order"
	id="order" value="${page.order}" /> 
	<input type="hidden"
	id="sImportNum" name="sucessImportNum" value="${sucessImportNum}" /> 
	<input
	type="hidden" id="uImportNum" name="unSucessImportNum"
	value="${unSucessImportNum}" />
	 <input type="hidden" id="flag"
	name="flag" value="" /> 
	<input type="hidden" name="tabFlag2"
	id="tabFlag2" value="${tabFlag2}" /> <!--  <s:if test="nowUser.tenantId==null">  
    <div class="dr-searchbar">
    <div class="form-group">
      <label>租户选择</label>
      <select class="form-control" name="tenantId2">
      <option value="admin">--选择租户--</option>
      <option <s:if test="tenantId2=='main'">selected="selected"</s:if> value="main">大平台</option>
      <s:iterator value="tenantLists">
      <option <s:if test="tenantId2==id">selected="selected"</s:if> value="${id}">${name}</option>
      </s:iterator></select>
   </div>  
   </div>
   </s:if>--> <security:authorize ifAnyGranted="ROLE_用户管理">
	<div class="dr-searchbar">
	<div id="uploadDiv" style="display: inline;">
	<div class="form-group"><label>下载数据文件包样本： <a
		href="${ctx}/template/student.xls" target="_blank">导入样本.xls</a> </label></div>
	<div class="form-group"><label>上传数据Excel文件</label> <input
		type="file" id="upload" name="upload" style="display: inline;"
		onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();" />
	</div>
	<div class="form-group">
	<button class="btn btn-primary btn-sm" type="button" id="Submit32"
		onclick="checkupload()"><span
		class="glyphicon glyphicon-open"></span>上传</button>
	</div>
	</div>
	<div class="form-group ml30" id="uploadResult" style="display: none">
	<label>正在上传，请稍等、、、</label></div>

	<div class="form-group ml30" id="errorResult" style="display: none">&nbsp;&nbsp;&nbsp;
	<label><a href="${uploadPath}" target="_blank">下载导入结果记录excel表格</a></label>
	</div>
	&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label
		id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span
		class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
	</div>
</security:authorize>
<div class="dr-searchbar">
<div class="form-group"><label>用户名</label> <input
	class="form-control input-sm" type="text" name="username" id="username"
	value="${username}"></div>

<div class="form-group"><label>姓名</label> <input
	class="form-control input-sm" type="text" name="name" value="${name}">
</div>

<div class="form-group"><label>身份证</label> <input
	class="form-control input-sm" type="text" name="idcard" id="idcard"
	value="${idcard}"></div>

<div class="form-group"><label>用户身份</label> <s:select
	list="#{'1':'学员','0':'注册用户'}" listKey="key" listValue="value"
	name="userRealtype" theme="simple" headerValue="--全部--" headerKey=""
	value="@java.lang.Integer@parseInt(#parameters.userRealtype)" cssClass="form-control input-sm"></s:select></div>

<div class="form-group">
<button class="btn btn-default btn-sm"
	onclick="$('#pageNo').val('1');document.mainForm.submit();"><span
	class="glyphicon glyphicon-search"></span> 搜索</button>
</div>
</div>
</form>


<form name="deleteForm" id="deleteForm" action="studentcz.action"
	method="post">
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<button class="btn btn-default btn-sm" type="button" id="batchDelDown"
	name="Submit2"><span class="glyphicon glyphicon-trash"></span>
批量删除</button>
</div>
<table class="table table-bordered dr-table-bordered"
	style="font-size: 14px;">
	<thead>
		<tr>
			<td width="1%" class="tt_noline"><input type="checkbox"
				id="checkboxall" /></td>
			<th width="10%">用户名</th>
			<th width="7%">姓名</th>
			<th width="9%">所在区划</th>
			<th width="10%">单位名称</th>
			<th width="14%">注册时间</th>
			<th width="7%">用户身份</th>
			<th width="5%">状态</th>
			<th width="21%">操作</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="page.result" status="stat">
			<tr>			 
			  <s:if test="%{userTenantId==null}">  
					<td></td>
				</s:if>
				<s:else>
					<td><input type="checkbox" name="ids" value="${userId}" /></td>
				</s:else>				
				<td><a href="student!info.action?id=${userId}" target="_blank">${username}</a></td>
				<td>${name}</td>
				<td>${area}</td>
				<td>${unit}</td>
				<td>&nbsp;<s:date name="createdate" format="yyyy.MM.dd HH:mm" />
				</td>
				<td>${studentType}</td>
				<td><s:if test="online==true">在线</s:if><s:else>离线</s:else></td>
				<s:if test="%{userTenantId==null}">
					<td><a
						href="${ctx}/user/manage/student!info.action?id=${userId}"
						target="_blank" class="btn btn-primary btn-sm"> <span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a> <a href="#"
						onclick="login(${userId})" class="btn btn-primary btn-sm">模拟登录</a>
					</td>
				</s:if>
				<s:else>
					<td><a
						href="${ctx}/user/manage/student!info.action?id=${userId}"
						target="_blank" class="btn btn-primary btn-sm"> <span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a> <a
						href="${ctx}/user/manage/student!modify.action?id=${userId}"
						class="btn btn-primary btn-sm"> <span
						class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a> <a href="#"
						onclick="resetPassword(${userId})" class="btn btn-primary btn-sm"><span
						class="glyphicon glyphicon-edit"></span>&nbsp;重置密码</a> 
						<security:authorize
						ifAnyGranted="ROLE_模拟登录">
							<a href="#" onclick="login(${userId})"
							class="btn btn-primary btn-sm">模拟登录</a>
						</security:authorize>
					</td>
				  </s:else>  
			</tr>
		</s:iterator>
	</tbody>
</table>
<%@ include file="/common/turnpage.jsp"%></div>
</form>
</div>
</div>
<div id="ilogin_container" style="display: none;"></div>
<script type="text/javascript">
   $(document).ready(function() {
   	  $('#ilogin_container').load('${loginUrl}?isInclude=true&renew=true&service=${service}', false); 
   })
</script> <!--dr-container-fluid结束--> <jsp:include
	page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="index" name="menu" />
</jsp:include> </section></div>
<!--dr-wrapper结束-->

</body>
</html>