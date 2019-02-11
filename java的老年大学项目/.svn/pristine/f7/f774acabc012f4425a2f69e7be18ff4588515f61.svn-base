<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级学员-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.white_content {
	display: none;
	position: fixed;
	top: 27%;
	left: 35%;
	width: 400px;
	height: 210px;
	border-radius: 5px 5px 0 0;
	background-color: white;
	z-index: 1002;
	overflow: auto;
	text-align: center;
}
.up-header {
	border: 10px 0 #2285C7 outset;
	background-color: #2285C7;
	color: #E5F8FF;
	background-position: 0 -350px;
	font-size: 16px;
	height: 37px;
	line-height: 35px;
	padding: 0 20px;
	position: relative;
	text-align: left;
}
.up-box-bd {
	text-align: center;
	display: inline-block;
	background: none repeat scroll 0 0 #FFFFFF;
	border-radius: 0 0 5px 5px;
	line-height: 25px;
	padding: 10px 30px;
}
.lay-btn {
	margin-top: 20px;
	height: 30px;
	text-align: center;
}
.btn92,.btn92s {
	border-radius: 4px;
	color: #333333;
	display: inline-block;
	text-align: center;
}
.btn92 {
	width: 90px;
	border: 1px solid #CCCCCC;
	height: 28px;
	line-height: 28px;
}
.btn92s {
	width: 90px;
	background-color: #FF8000;
	color: #FFFFFF;
	height: 30px;
	line-height: 30px;
}
.btn92s:hover {
	background: #FF9B00;
	color: black;
}
a:link {
	text-decoration: none;
	color: balck;
}
a:active {
	text-decoration: blink;
}
a:visited {
	text-decoration: none;
	color: green;
}
</style>

<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<script src="${staticurl}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${staticurl}/js/bootstrap-typeahead.js"></script>
<script>  
	$(document).ready(function() {
		if('${threadName}' != ''){
			checkover();
			}
		var uplaodflag = $("#uplaodflag").val();
        if(uplaodflag == 'true'){
        	$("#div-success").show();
		  	$("#success").text("上传完成，请查看导入结果记录表。");
	    	$('#errorResult').show();
	    	$('#importnum').show();
	    	$("#uplaodflag").val("false");
        }
        //信息提示  
		if($("#success").text()!="")$("#div-success").show();
		if($("#error").text()!="")$("#div-error").show();
		 $("#checkboxall").click(function(){
			   if($("#checkboxall").attr("checked")=="checked"){
			     	$("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }else{
			   		$("input[name='ids']").removeAttr("checked");
			   } 
		   });
			//验证批量删除文章的列表非空与否
			   $("#batchDelDown").click(function(){
					   var oaction = document.getElementById("mainForm").action;
					  document.getElementById("mainForm").action="${ctx }/clazz/manage/clazz!batchDeletestudent.action";
				       if(!checkSelect()) {
				            b_alert("没有可操作记录,请勾选");
				            return false;
				       } 
				      b_confirm('您确定要进行此操作吗?', function() {
							$("#mainForm").submit();
							document.getElementById("mainForm").action = oaction;
			   	   		});
				 }); 
					    
					     
					  
		//信息提示  end
		$(".colorbox").colorbox({ width: "950", height:"100%" , close: "关闭", overlayClose: false,href:'clazz!mimportstudent.action?clazzid=${id}'});
		});	
		function deleteAll(){
			  var oaction = document.getElementById("mainForm").action;
			  document.getElementById("mainForm").action="${ctx }/clazz/manage/clazz!deleteAllstudent.action";
		      b_confirm('您确定要进行此操作吗?', function() {
					$("#mainForm").submit();
					document.getElementById("mainForm").action = oaction;
	   	   		});
		}
		 function checkSelect() {
				var flag = false;
				$("input[name='ids']:checked").each(function(){
					flag = true;
				}); 
				return flag;
			}
			 
	 function  checkupload(){
		 var upload = $("#upload").val();
         if(upload == "" || upload == null){
          b_alert("上传文件不能为空！");
          }else {
        	  $("#uploadForm").submit(); 
          }
    } 
	 function checkover(){
			$.ajax({
		        type: "POST",
		        url: "${ctx}/clazz/manage/clazz!isFinishSaveStudent2.action",
		        data: {
		        	"threadName":'${threadName}',
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
						 setTimeout("checkover()",1000);
					 }else{
						 var num = data.label.split("_");
						 $("#uplaodflag").val("true");
						 $("#sImportNum").val(num[0]);
						 $("#uImportNum").val(num[1]);
						 $("#mainForm").submit();   
				     } 
		        }
			});
		}
		
var names;
var ids;
var className;
function change(studentClazzId,clazzname){
	$("#curClazz").html(clazzname);
	$("#studentClazzId").val(studentClazzId);
    $("#confirm").css("display","block");
	$("#fade").css("display","block");	

	$.getJSON("${ctx}/clazz/manage/clazz!changeclazz.action",{"studentClazzId":studentClazzId},function(data){
		        $("#targetclazz option[value!='']").remove();
				var clazzname = eval(data);
				if(clazzname.length>0){
				 names=new Array(clazzname.length)
				 ids=new Array(clazzname.length)
				for(var i = 0 ;i < clazzname.length ; i++) {
					names[i]=clazzname[i].label;
					ids[i]=clazzname[i].value;
					$("#targetspan").show();
					$("#targetspan0").hide();
					$("#ok").show();
					$("#targetclazz").append("<option value='"+clazzname[i].value+"'>"+clazzname[i].label+"</option>");
				}
				}else{
					$("#ok").hide();
					$("#targetspan").hide();
					$("#targetspan0").show();
					}
                  
				$('#searchWords').typeahead({source: names,items:clazzname.length,minLength:0,hint: true,updater: function (item) {
				    //选择项之后的事件 ，item是当前选中的。
				    console.log(item);
				    className=item;
				    return item;
				}}) 
	});
}

function changeclazz()
{
	var index=-1;
	for(var x=0;x<names.length;x++){
		if(className==names[x])
			{
				index=x;
				break;
			}
	}
	if(index==-1)
	{
		alert('没有找到此班级，请重新输入！');
		return ;
	}
	//var targetclazzid = $("#targetclazz").val();
	var targetclazzid =ids[index];
	var studentClazzId = $("#studentClazzId").val();
		$.ajax({
			type:"POST",
			dataType: "text",
			url: "${ctx}/related/clazz!savechange.action",
			data: {targetclazzid:targetclazzid,studentClazzId:studentClazzId},
		    success: function(result){
			      if(result=='true'){
			            paysuccess();
			        }else{
			            alert('调换班级失败');
			        }
		      }
		});		
}

function cancel(){
	$("#confirm").css("display","none");
	$("#fade").css("display","none");
	
}
function paysuccess(){
	$("#confirm").css("display","none");
	$("#fade").css("display","none");
	window.location.reload();
}
</script>

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
     <h3>班级学员</h3>
   </div>
   <hr/>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
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
	     <li><a href="clazz!mcourse.action?id=${id }">班级课程</a></li>
	     <li class="active"><a href="clazz!mstudents.action?id=${id }">班级学员</a></li>
	     <li><a href="clazz!mmanager.action?id=${id }">班主任任命</a></li>
	     <s:if test='!clazzDTO.selfClass'>
		 <li><a href="clazz!mcost.action?id=${id }">费用结算</a></li>
	    </s:if>
       </ul>
    </div>

  </div>
<security:authorize ifAnyGranted="ROLE_用户管理">
<s:if test="!clazzDTO.selfClass&&clazzDTO.passed">
<form id="uploadForm" class="form-inline dr-form-inline mt10 ml5 mr5" action="clazz!msaveimport.action" method="post" enctype="multipart/form-data">
     <input	type="hidden" name="clazzid" value="${id}" />
     <input	type="hidden" name="id" value="${id}" />
     <input type="hidden" value="${phaseId}" name="phaseId" />
     <input	type="hidden" name="teachContentId" value="${teachContentId}" />
      <div class="dr-searchbar">
        <div class="form-group">
  		<label>下载数据文件包样本：
  		<a href="${ctx}/template/clazzstudent.xls"  target="_blank">导入样本.xls</a>
		</label>
		</div>
		<div class="form-group">
		<label >上传数据Excel文件</label>
		<input type="file" id="upload" name="upload" style="display: inline;" onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();"/>

		</div>
		<div class="form-group" id="uploadDiv">
		<button class="btn btn-primary btn-sm" type="button" id="Submit32" onclick="checkupload()">
		<span class="glyphicon glyphicon-open"></span>上传</button>
		</div>
		<div class="form-group ml30" id="uploadResult" style="display: none">
		<label>正在上传，请稍等、、、</label>
		</div>
		<div class="form-group ml30" id="errorResult" style="display: none">&nbsp;&nbsp;&nbsp;
		<label><a href="${uploadPath}" target="_blank">下载导入结果记录excel表格</a></label>
		</div>
		&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
	 </div>
</form>
<s:if test="unsuccesslist.size>0">		
   
   <div class="panel panel-default mt5 mb10 ml5 mr5">
		<div class="panel-heading"><label class="mt10 mb10" style="color:red;"> 未成功注册的学员 </label></div>
			<table class="table table-bordered dr-table-default">
				<thead>
				<tr>
					<th width="20%">用户名</th>
					<th width="20%">姓名</th>
					<th width="20%">身份证号</th>
					<th width="40%">失败描述</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="unsuccesslist" status="stat">
					<tr>
						<td style="color:red;">${userName}</td>
						<td style="color:red;">${name}</td>
						<td style="color:red;">${IDNo}</td>
						<td style="color:red;">${errorDesc}</td>
					</tr>
				</s:iterator>
			  </tbody>
			</table>
	</div>
</s:if> 
</s:if> 
</security:authorize>   
<form id="mainForm" name="mainForm"	action="clazz!mstudents.action" class="form-inline dr-form-inline" method="post">
	<input type="hidden" name="page2.pageNo" id="pageNo" value="${page2.pageNo}" />
	<input type="hidden" name="page2.orderBy" id="orderBy" value="${page2.orderBy}" />
	<input type="hidden" name="page2.order" id="order" value="${page2.order}" />
	<input type="hidden" id="uplaodflag" name="uplaodflag" value="${uplaodflag}"/>
	<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
	<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
	<input	type="hidden" name="id" id="id" value="${id}" />
	
   <div class="dr-searchbar mt10 mb10 ml5 mr5">
   <div class="form-group">
      <label>姓名</label>
      <input class="form-control input-sm" type="text" name="name" id="name" value="${name}"  />
   </div>  
      
   <div class="form-group">
     <label>身份证号</label>
     <input class="form-control input-sm" type="text"  name="idCard" id="idCard" value="${idCard}" />
   </div>
   
   <div class="form-group">
   <button class="btn btn-default btn-sm" type="submit" onclick="$('#pageNo').val(1);">
	<span class="glyphicon glyphicon-search"></span>
	搜索
	</button>
	</div>
   </div>

<div class="panel panel-default mt10 mb10 ml5 mr5">
	<div class="panel-heading">
	<div class="btn-toolbar dr-btn-toolbar">
	<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
           		</button>
				</div>
	<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="deleteAll();">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除全部学员
           		</button>
				</div>
	<div class="panel-toolbar text-right dr-slash-text small">
	   <span>报名学员共${count}人</span><!--
	   <s:if test="clazzDTO.passed">
	   <a class="colorbox blue" href="void(0);" target="_blank" > <strong><font color='red'>导入学员名单</font></strong></a>
	   </s:if>
	-->
	</div>
	</div>
	
	</div>
<table  class="table table-bordered dr-table-bordered">
  <thead>
	<tr>
	    <th width="2%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
		<th width="8%">姓名</th>
		<th width="2%">性别</th>
		<th width="10%">身份证号</th>
		<th width="8%">所在区划</th>
		<th width="8%">所在街道</th>
		<th width="8%">所在社区</th>
		<th width="10%">工作单位</th>
		<th width="10%">家庭地址</th>
		<th width="6%">QQ号码</th>
		<th width="10%">项目名称</th>
		<th width="6%">是否在线</th>	
		<th width="6%">审核状态</th>
		<th width="6%">联系方式</th>
		<th class="buleleft">操作</th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="page2.result" status="stat">
		<tr>
		    <td class="white_bg">
			  <input type="checkbox" name="ids" value="${student.id}" />
		    </td>
			<td>&nbsp;${student.name}</td>
			<td>&nbsp;${student.sexDesc}</td>
			<td>&nbsp;${student.idcard }</td>
			<td>&nbsp;${student.area}</td>
			<td>&nbsp;${student.street}</td>
			<td>&nbsp;${student.community}</td>
			<td>&nbsp;${student.unit}</td>
			<td>&nbsp;${student.address}</td>
			<td>&nbsp;${student.qq}</td>
			<td>&nbsp;${program.name}</td>
			<td>&nbsp;<s:if test="student.online">在线</s:if><s:else>离线</s:else></td>	
			<td>
			 <s:if test="!normal">
			<a style="color: white;" href="clazz!recheck.action?id=${clazzId}&&clazzid=${clazzId}"  type="button" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-edit"></span>
             &nbsp;审核</a>
			</s:if>
			<s:else>已审核</s:else>
			</td>
			<td>		
		     &nbsp;${student.mobilephone}
			</td>		
			<td>
            <s:if test="clazzDTO.open && normal">
            	<a href="javascript:void(0);" style="color: white;" class="btn btn-primary btn-sm" onclick="change('${id}','${clazzDTO.name}')">换班</a>
            </s:if>
            <a style="color: white;" href="${ctx}/user/manage/student!info.action?id=${studentId}" target="_blank" type="button" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-list-alt"></span>
             &nbsp;详细</a>
			<button class="btn btn-default btn-sm" type="button" onclick="delRecord('clazz!deletestudent.action?id=${clazzId}&studentid=${student.id }');">
              <span class="glyphicon glyphicon-trash"></span>
             &nbsp;删除
            </button>
             &nbsp;&nbsp;
			</td>
		</tr>
	</s:iterator>
	</tbody>
</table>
<s:set name="page" value="page2" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>	




</div>
</div>
</section>
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	    	
<div id="confirm" class="white_content" style="height:400px;">
<input  id="studentClazzId" type="hidden" value="${studentClazzId}"/>
<div class="up-header">调换班级</div>
<div class="up-box-bd">
<div style="text-align: left;margin-top: 10px"><span style="text-align: left;font-weight: bold">当前班级:</span>
<span id="curClazz" style="margin-left: 10px"></span></div>
<div style="text-align: left;"><span style="text-align: left;font-weight: bold;">目标班级:</span>
<span id="targetspan0" style="display: none;margin-left: 10px">该教学计划下仅有该一门课程开放！</span>
<span id="targetspan" style="display: none">
<select id="targetclazz" style="margin-left: 10px; display:None;">
<option value="">--选择班级--</option>
</select>

<input style="width:200px;margin-left: 10px; " type="text" id="searchWords" name="searchWords" class="" data-provide="typeahead" autocomplete="off" placeholder="请输入要搜索的班级">

</span></div>
<div class="lay-btn">
<a id="ok" class="btn92s" href="#" onclick="changeclazz()">确定</a>
<a id="cancel" class="btn92" href="javascript:" onclick="cancel()">取消</a>
</div>
</div>
</div>
<script>

</script>
</body>
</html>
