<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
request.setAttribute("isShzx",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","isShzx"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训项目-后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@include file="/common/admin_meta.jsp"%>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  
<script type="text/javascript" language="javascript">   
function disblock(obj)
{
	if($(obj).val()!="True")
		$(".tmp").hide();
	else
		$(".tmp").show();
}
$(document).ready(function() {
    $("#startDate").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0          
   }); 
 $("#closeDate").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0          
  }); 
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
	$("#haveCertificateTrue").attr("checked",true);
	//聚焦第一个输入框
	//$("#name").focus();
	//为registerForm注册validate函数
	$("#inputForm").validate({
		rules: {
		itemid: {
			required: true
		}
		,name: {
			required: true,
			maxlength: 20
		}  
		,code:
		{
			required: true
		}
		,groupPhone:
		{
			required: true
		}
		,descr:
		{
			required: true
		}
		,phaseNum:
		{
			required: true,
			number:true,
			min:true 
		}
		,hours:
		{
			required: true,
			number:true  
		}
		//,pic:
		//{
			//required: true
		//}
		,tenantId:{
			required: true
		}
		,totalPrice:{
			required: true,
			number:true,
			maxlength: 10
		}},
		messages: {
			itemid: {
				required: "请选择项目类型"
			}
			,name: {
				required: "请输入项目名称",
				maxlength: "项目名称最多为20个字符,请重新输入"
			}
			,code:
			{
				required: "请输入项目编号"
			} 
			,groupPhone:
			{
				required: "请输入项目联系电话"
			} 
			,descr:
			{
				required: "请输入项目介绍"
			}  
			,phaseNum:
			{
				required: "请输入阶段数",
				number:"请输入数字",
				min:"项目若多次使用，请填写大于1的合适阶段数"
			} 
			,hours:
			{
				required: "请输入学分",
				number:"请输入数字"
			} 
			//,pic:
			//{
				//required: "选择项目图片"
			//}
			,tenantId:{
				required: "请选择租户"
			} 
			,totalPrice:{
				required: "请填写付费总金额",
				number:"请输入数字",
				maxlength: "数字长度不能超过10位数"
			}
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
        errorElement: "strong" 
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

function uploadpic(){
	$("#iframePic").show();
	$("#col-md").attr("class","col-md-10");
}

function saveEditorPic(avatarname){
	var picPath = "<common:prop name="traincore.uploadpath.url" propfilename=""/>"+avatarname
	$("#pic").val(avatarname);
	$("#cruPic").attr("src",picPath);
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
}

function closex(){
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
}

function changeTenant(obj){
	var tenantid = $(obj).val();
	//根据一级栏目获得二级栏目
	if(tenantid) {
		$.post("programs!changeTenant.excsec",{"tenantId":tenantid},function(data) {
			$("#item option[value!='']").remove();
			var category = eval(data);
			if(category.length == 0) return;
			for(var i = 0 ;i < category.length ; i++) {
				$("#item").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
			} 
		});
	}else {
		$("#item option[value!='']").remove(); 
	}
}

function selectType(){
	 var s = $("#beforeSignuped option:selected").val();
	 if(s==1){
		 $("#signUpType").show();
	 }else{
		 $("#signUpType").hide();
	 }
}

function selectTotalPay(){
	var s = $("#totalPay option:selected").val();
	 if(s==1){
		 $("#totalPayType").show();
	 }else{
		 $("#totalPayType").hide();
	 }
}

function selectCertstandard(){
	 var s = $("#cert option:selected").val();
	 if(s==""){
		$("#certstandard").hide();	
	 }else{
		$("#certstandard").show(); 
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
	<jsp:param value="input-programs" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
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
		<a href="#">培训项目管理</a>
		</li>
		<li class="active"><span>新增培训项目</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>新增培训项目<small>&nbsp;</small></h3>
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
    	<form id="inputForm" name="inputForm" action="programs!save.action" method="post" class="form-horizontal dr-form-bordered" role="form" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${id}" />
		<div class="dr-form-title clearfix">
		<div class="col-md-12">
		<h4 class="text-primary">培训项目基本信息</h4>
		</div>
		</div>
		
		<div class="form-group" id="validate_itemid">
		<label class="col-md-2 control-label">项目类型<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<s:select cssClass="form-control" placeholder="" 
		list="itemCategories" listKey="id" listValue="name" theme="simple" name="itemid" id="item" value="itemCategory.id">
        </s:select>
		</div>
        <span class="help-block" id="error_itemid"></span>
		</div>
		
		<div class="form-group" id="validate_name">
		<label class="col-md-2 control-label">项目名称<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${name}" id="name" name="name" class="form-control"></input>
		</div>
		<span class="help-block" id="error_name"></span>
		</div>
		
		<div class="form-group" id="validate_code">
		<label class="col-md-2 control-label">项目代码<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${code}" id="code" name="code"  class="form-control"></input>
		</div>
		<span class="help-block" id="error_code" ></span>
		</div>
		
		<div class="form-group" id="validate_descr">
		<label class="col-md-2 control-label">项目介绍<span class="text-danger">*</span>
		</label>
		<div class="col-md-5">
		<textarea rows="6" cols="116" name="descr"  class="form-control" style="resize: none;">${descr}</textarea>
		</div>
		<span id="error_descr" class="help-block" ></span>
		</div>
		<div class="form-group" id="validate_groupPhone">
		<label class="col-md-2 control-label">项目联系号码<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${groupPhone}" id="groupPhone" name="groupPhone" class="form-control"></input>
		</div>
		<span class="help-block" id="error_groupPhone"></span>
		</div>
		<div class="form-group">
		<label class="col-md-2 control-label">是否在移动段显示</label>
		<div class="col-md-3">
		<s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="mobileshow" theme="simple" headerKey="" 
		value="1" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="mobileshow"></s:select>	
	    </div>	
		</div>
		
		<div class="form-group">
        <label class="col-md-2 control-label">是否总体付费</label>	
		<div class="col-md-3">
		<s:select list="#{'0':'否','1':'是'}" listKey="key" listValue="value" name="totalPay" theme="simple" headerKey="" 
		value="0" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectTotalPay()" id="totalPay"></s:select>	
	    </div>
	    <div id="totalPayType" style="display:none;">
	    <label class="col-md-2 control-label">付费总金额</label>	
	    <div class="col-md-3">
		<input type="text" value="${totalPrice}" id="totalPrice" name="totalPrice"  class="form-control"></input>
		</div>
		<span id="error_totalPrice" class="help-block" ></span>
	    </div>
	    </div>
		
		<div class="form-group">
        <label class="col-md-2 control-label">是否预报名</label>	
		<div class="col-md-3">
		<s:select list="#{'0':'否','1':'是'}" listKey="key" listValue="value" name="beforeSignuped" theme="simple" headerKey="" 
		value="beforeSignuped" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="beforeSignuped"></s:select>	
	    </div>
	    <div id="signUpType" style="display:none;">
	    <label class="col-md-2 control-label">预报名类型</label>	
	    <div>
		<s:select list="#{'1':'固定预报名','2':'额满预报名'}" listKey="key" listValue="value" name="beforeSignupType" theme="simple" headerKey="" 
		value="beforeSignupType" cssClass="form-control input-sm" cssStyle="width:200px"></s:select>	
		</div>
	    </div>
	    </div>
	    
	    	
	    <div class="form-group">
		<label class="col-md-2 control-label">项目是否需要审核</label>
		<div class="col-md-3">
		<s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="shenhe" theme="simple" headerKey="" 
		value="shenhe" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="shenhe"></s:select>	
	    </div>	
		</div>
		 
	       
	    <div class="form-group" id="validate_phaseNum">
		<label class="col-md-2 control-label">项目阶段数<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${phaseNum}" id="phaseNum" name="phaseNum"  class="form-control"></input>
		</div>
		<span class="help-block" id="error_phaseNum" ></span>
		</div>
		
		<c:if test="${fn:contains(currentTenant.contents,'english')}">
		<div class="form-group" id="validate_phaseNum">
		<label class="col-md-2 control-label">竞赛合格线
		</label>
		<div class="col-md-3">
		<input type="text" value="${trainingPrograms.hegescore}" id="hegescore" name="hegescore"  class="form-control"></input>
		</div>
		<span class="help-block" id="error_phaseNum" ></span>
		</div>
		
	    <div class="form-group" >
	       <label class="col-md-2 control-label">开放时间起自</label>
	       <div class="input-group date col-md-3" id="startDate"  style="padding-left: 15px;float: left;margin-right: 5px;">
	          <input type="text"  value='<s:date name="trainingPrograms.startDate" format="yyyy-MM-dd"></s:date>' readonly="readonly"
				 name="startDate" class="form-control" /> 
			  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
		      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>			  
	       </div>
	        <span id="error_startDate" class="help-block"></span>
	    </div>
	    <div class="form-group" >
	       <label class="col-md-2 control-label">开放时间截止</label>
	       <div class="input-group date col-md-3" id="closeDate" style="padding-left: 15px;float: left;margin-right: 5px;">
	         <input type="text"  value='<s:date name="trainingPrograms.closeDate" format="yyyy-MM-dd"></s:date>'  readonly="readonly"
				 name="closeDate" class="form-control" />
				    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
		            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	         
	       </div>
	       <span id="error_closeDate" class="help-block"></span>
	    </div>  
        </c:if>
        
		<div class="form-group" id="validate_hours">
		<label class="col-md-2 control-label">完成学时要求<span class="text-danger">*</span>
		</label>
		<div class="col-md-2">
		<div class="input-group">
		<input type="text" value="${hours}" id="hours" name="hours" class="form-control"/>
		<span class="input-group-addon" style="width:50px;">学时</span> 
		</div>
		</div>
		<span id="error_hours" class="help-block"></span>
		</div>
		
		<div class="form-group" id="validate_pic">
		<label class="col-md-2 control-label">项目图片<span class="text-danger">*</span>
		</label>
		<div class="col-md-2" id="col-md">
		 <input id="pic" name="pic" type="hidden" value="${pic}"/>
     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
		 <span class="glyphicon glyphicon-open mr5"></span>上传图片
		 </button>&nbsp;&nbsp;(190x110)
		 <div  style="display: none;" id="iframePic" >
		 <iframe src="${ctx}/train/manage/programs!uploadphoto.excsec?picfileFileName=${pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
		 </div>
		 <div class="img-thumbnail mt10">
         <img id="cruPic" alt="190x110" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${pic}" style="width:190px; height:110px;"/>
       </div>
		</div>
		<span id="error_pic" class="help-block"></span>
		</div>
		
		<div class="form-group">
		<label class="col-md-2 control-label">关联证书
		</label>
		<div class="col-md-2">
		<s:select list="certs" listKey="id"  listValue="name" name="certid" theme="simple" value="cert.id"
			  headerKey="" headerValue="请选择关联的项目证书" cssClass="form-control" id="cert" onchange="selectCertstandard()">
	    </s:select>
		</div>
		<div id="certstandard" class="col-md-8" style="display:none;">
			<div class="col-md-6">
			    <label class="col-md-6 control-label">证书生成标准</label>	
				<s:select list="#{'1':'单阶段完成','2':'项目完成'}" listKey="key" listValue="value" name="certstandard" theme="simple" headerKey="" 
				value="certstandard" cssClass="form-control" cssStyle="width:150px" ></s:select>	
			</div>
			<div class="col-md-6">
				<label class="col-md-6 control-label">证书生成条件</label>
				<s:if test="#request.iswxeduopen=='true'">	
				<s:select list="#{'1':'考核标准达到要求','0':'学时达到要求'}" listKey="key" listValue="value" name="finishcondition" theme="simple" headerKey="" 
				value="1" cssClass="form-control" cssStyle="width:150px" ></s:select>	
				</s:if>
				<s:else>
				<s:select list="#{'0':'学时达到要求','1':'考核标准达到要求'}" listKey="key" listValue="value" name="finishcondition" theme="simple" headerKey="" 
				value="0" cssClass="form-control" cssStyle="width:150px" ></s:select>	
				</s:else>
		    </div>
	    </div>
	    
		</div>
		
		<div class="panel-footer">
		<div class="row">
		<div class="col-md-offset-2 col-md-10">
		 	<button name="Submit32" type="submit" class="btn btn-primary btn-sm" onclick="checkedError()">
			<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
			</button> 
			<button onclick="window.location.href='programs.action?iscommon=${iscommon}'" type="button" class="btn btn-default btn-sm">
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