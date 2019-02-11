<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
request.setAttribute("isShzx",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","isShzx"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短信管理-后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@include file="/common/admin_meta.jsp"%>
<script src="${ctx}/layer/layer.js"></script>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">   
$(document).ready(function() {
	$("#yyTime").datetimepicker({
		 customFormat: "yyyy-mm-dd",
		 format: "yyyy-mm-dd",
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0
	}); 
	
	if('${id}'!=null||'${id}'!=''){
		$("#serviceType option[value='${serviceType}']").attr("selected","selected");
		$("#program option[value='${programId}']").attr("selected","selected");
		$("#yyTime").val('${batchDate}');
		 selectType();
		 countUcc($("#program"));
	}
	if(${serviceType}!=2) {
		$("#validate_telephoneStr").hide();
		$("#validate_program").show();
	}
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
	$("#inputForm").validate({
		rules: {
		/* 	telephoneStr:{
			mscontent: true
			} */
		},
		messages: {
		/* 	telephoneStr:{
				required: "请输入短信内容"
			} */
		},
		onsubmit: function(element) { $(element).valid(); },
		onfocusout: function(element) { $(element).valid(); },			
		onkeyup: function(element) { $(element).valid(); },
	    onfocusin: function(element) { $(element).valid(); },
        success: function(label) { 
		var e = $(label).parent().attr("id").split("_")[1];
		var oclass=$("#validate_"+e).attr("class");
		if(oclass && oclass.indexOf("form-group")>-1)
			oclass = "form-group";
		else
			oclass="";
       	$("#validate_"+e).attr("class",oclass+" has-success")     
   		$(label).remove();
        },
        errorPlacement: function(error, element) { 
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name")); 
				var oclass=$("#validate_"+element.attr("name")).attr("class");
				if(oclass && oclass.indexOf("form-group")>-1)
					oclass = "form-group";
				else
					oclass="";
	        	$("#validate_"+element.attr("name")).attr("class",oclass+" has-error");    
	        }	
	        else{
            	error.insertAfter(element);   
	        }       
        },
	    invalidHandler: function(form, validator) {  //不通过时回调
			$(".error").each(function(i){
				var id = $(this).parent().attr("id");
				if(id && id.indexOf("_")>0){
				    var f = id.split("_")[1];
					var oclass=$("#validate_"+f).attr("class");
					if(oclass && oclass.indexOf("form-group")>-1)
						oclass = "form-group";
					else
						oclass="";
				    $("#validate_"+f).attr("class",oclass+" has-success")
				    $(this).remove();
				}
			});
	    } ,
        errorElement: "strong" ,
		submitHandler : function(form) { //表单提交句柄,为一回调函数，带一个参数：form  
			 var s = $("#serviceType option:selected").val();
				if(s==0){
					if ($.trim($("#yyTime").val()) == "") {
							alert("请输入预约时间!");
							return false;
					}
				}
				form.submit(); //提交表单   
			}
	});
});

function checkedError(){
	$(".error").each(function(i){
		if($(this).text() != ""){
			var e = $(this).parent().attr("id").split("_")[1];
	   		$("#validate_"+e).attr("class","form-group has-error")
	    }
	});
}
function gettemp(){
	 var tpv = $("#tpId option:selected").text();
	 if(tpv!='选择模板'){
		 $("#yycontent").html(tpv); 
	 }else{
		 $("#yycontent").html('');
	 }

}

function selectType(){
	 var s = $("#serviceType option:selected").val();
	 if(s==0){
		 $("#validate_program").show();
		 $("#validate_yycontent").show();
		 $("#validate_temp").show();
		 $("#validate_content").hide();
		 $("#validate_impcontent").hide();
		 $("#validate_telephoneStr").hide();
		 $("#validate_examcontent").hide();
		 $("#validate_yyTime").show();
	 }
	 if(s==1){
		 $("#validate_program").show();
		 $("#validate_examcontent").show();
		 $("#validate_impcontent").hide();
		 $("#validate_temp").hide();
		 $("#validate_content").hide();
		 $("#validate_telephoneStr").hide();
		 $("#validate_yycontent").hide();
		 $("#validate_yyTime").hide();
	 }
	 if(s==4){
		 $("#validate_program").show();
		 $("#validate_impcontent").show();
		 $("#validate_examcontent").hide();
		 $("#validate_temp").hide();
		 $("#validate_content").hide();
		 $("#validate_telephoneStr").hide();
		 $("#validate_yycontent").hide();
		 $("#validate_yyTime").hide();
		 $("#validate_program").hide();
		 $("#validate_usernameStr").hide();
	 }
}

function countUcc(obj){
	if($(obj).val()!="") {
		$.post("mspush!countUcc.action",{"pid":$(obj).val(),"type":$("#serviceType").val()},function(data) {
			 //layer.tips('目标人数'+data+'人', $("#program") , {guide: 3, time:0}); 
			 var s = $("#serviceType option:selected").val();
			 if(s==0){
			 $("#programTips").html('预约人数'+data+'人');
			 }else if(s==1){
			 $("#programTips").html('排考人数'+data+'人');
			 }
		});
	}else {
		//layer.tips('暂未选择项目', $("#program") , {guide: 3, time:0}); 
		$("#programTips").html('暂未选择项目')
	}
}
</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="mspushlist" name="menu" />
	<jsp:param value="mspush" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
		</li>
		<li>
		<a href="#">短信管理</a>
		</li>
		<li class="active"><span>新增短信</span></li>
		</ol> 
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>新增短信<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
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
    <!--表单模块-->
    	<div class="panel panel-default">
    	<form id="inputForm" name="inputForm" action="mspush!save.action" method="post" class="form-horizontal dr-form-bordered" role="form" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${id}" />
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">短信基本信息</h4>
		</div>
		</div>   
		
		<div class="form-group">
		<label class="col-md-2 control-label">业务类型</label>
		<div class="col-md-3">
		<s:select list="#{'0':'预约提醒','1':'考前提醒','4':'导入提醒'}" listKey="key" listValue="value" name="type" theme="simple" headerKey="" 
		value="value" cssClass="form-control input-sm" cssStyle="width:180px;" onchange="selectType();"  id="serviceType"></s:select>	
	    </div>	
		</div>
		
		<div class="form-group">
		<label class="col-md-2 control-label">指定模板</label>
		<div class="col-md-3">
			<input name="zdmbId" id="zdmbId" value="${tpId}" class="form-control"/>
		</div>
		<span>优先使用指定模板</span>
	    </div>
		
		<div class="form-group" id="validate_temp" style="display: none;" >
		<label class="col-md-2 control-label">短信模板</label>
		<div class="col-md-3">
		<s:select list="tempList" listKey="value" listValue="label" name="tpId" theme="simple" headerKey=""  headerValue="选择模板"
		value="value" cssClass="form-control input-sm" cssStyle="width:250px;"  id="tpId" onchange="gettemp();"></s:select>	
	    </div>
		</div>
		
		<div class="form-group" id="validate_examcontent" style="display: none;">
		<label class="col-md-2 control-label">短信内容<span class="text-danger">*</span>
		</label>
		<div class="col-md-5">
		<textarea rows="4" cols="116" readonly="readonly" class="form-control" style="resize: none;">您预约的#program#培训考试将在#addresstime#进行。考试请带身份证，关注平台班级公告中发布的继教证上交通知,由于校园车位有限，考试期间考生车辆不允许进入校园，请各位合理安排出行，造成不便，敬请谅解。
		</textarea>
		</div>
		<span id="error_content" class="help-block" ></span>
		</div>
		
		<div class="form-group" id="validate_yycontent" style="display: none;">
		<label class="col-md-2 control-label">短信内容<span class="text-danger">*</span>
		</label>
		<div class="col-md-5">
		<textarea id="yycontent" name="yycontent" readonly="readonly" rows="4" cols="116"  class="form-control" style="resize: none;">
		</textarea>
		</div>
		<span id="error_content" class="help-block" ></span>
		</div>
		
		<div class="form-group" id="validate_impcontent" style="display: none;">
		<label class="col-md-2 control-label">短信内容<span class="text-danger">*</span>
		</label>
		<div class="col-md-5">
		<textarea readonly="readonly" rows="4" cols="116"  class="form-control" style="resize: none;">接滁州市人社局紧急通知，#oldtime的考试调整至#newtime进行，请预约在#oldtime考试的学员，于#newtime至滁州电大参加考试，考试时间段不变，给您造成的不便，敬请谅解
		</textarea>
		</div>
		<span id="error_content" class="help-block" ></span>
		</div>
		
		<div class="form-group" id="validate_usernameStr">
		<label class="col-md-2 control-label">学员用户名<span class="text-danger"></span>
		</label>
		<div class="col-md-5">
		<textarea rows="4" cols="116" name="usernameStr"  class="form-control" style="resize: none;">${usernameStr}</textarea>
		</div>
		<span>多个用户名用“，”隔开，例如“test001,test002”</span>
		<span id="error_usernameStr" class="help-block" ></span>
		</div>
		
		<div class="form-group" id="validate_program" style="display:none;">
		<label class="col-md-2 control-label">所属项目</label>
		<div class="col-md-3">
		<s:select list="programs" listKey="id" listValue="name" name="programId" theme="simple" headerKey=""  headerValue="选择项目"
		value="id" cssClass="form-control input-sm" cssStyle="width:250px;"  id="program" onchange="countUcc(this);"></s:select>	
	    </div>
	    <div class="col-md-3" id="programTips"></div>
		</div>
		
		<div class="form-group" id="validate_yyTime" >
		<label class="col-md-2 control-label">预约时间<span class="text-danger">*</span> </label>
		<div class="col-md-3">
			<input name="yyTime" id="yyTime" value="${yyTime}" class="form-control" readonly/>
		</div>
		<span id="error_yyTime" class="help-block"></span>
	    </div>
		
		
		<div class="panel-footer">
		<div class="row">
		<div class="col-md-offset-2 col-md-10">
		 	<button name="Submit32" type="submit" class="btn btn-primary btn-sm" onclick="checkedError()">
			<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
			</button> 
			<button onclick="window.location.href='mspush.action?iscommon=${iscommon}'" type="button" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-remove"></span>&nbsp;取消
			</button>
		</div>
		</div>
		</div>
	    </form>
	    </div>
    <!--表单模块end-->
    
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
	<!--footer over-->
	</section>
</div>
<!-- container end -->
</body>
</html>