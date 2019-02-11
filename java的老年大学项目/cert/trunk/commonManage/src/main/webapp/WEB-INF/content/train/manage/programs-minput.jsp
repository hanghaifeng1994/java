<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>${trainingPrograms.name} <s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
    <%@ include file="/common/admin_meta.jsp"%>	
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  
<script type="text/javascript">  
	function disblock(obj)
	{
		if($(obj).val()!="true"){
			$(".tmp").hide();
			$("#certificateName").val("");
			$("#certificateOrganization").val("");
		}else
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
		if($("#totalPay option:selected").val()==1){
			$("#totalPayType").show();
		}
		if($("#beforeSignuped option:selected").val()==1){
			$("#signUpType").show();
		}
		if($("#cert option:selected").val()!=""){
			$("#certstandard").show();
		}
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
		<s:if test="trainingPrograms.haveCertificate">
			$(".tmp").show();
		</s:if>
		<s:else>
			$(".tmp").hide();
		</s:else>
 		//聚焦第一个输入框
 		//$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			itemid: {
				required: true
			}
			,
 			name: {
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
 			,totalPrice:{
			required: true,
			number:true,
			maxlength: 10
			}},
 			messages: {
 				itemid: {
					required: "请选择项目类型"
				}
				,
 				name: {
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
					number: "请输入数字"
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
					//alert($(this).html())
				});
		    } ,
	        errorElement: "strong" 
 		});
 	});

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
        <li class="active"><a style="cursor: pointer;" href="programs!minput.action?id=${id }">培训项目属性设置</a></li>
        <li><a style="cursor: pointer;" href="phase.action?programId=${id}&menu=menu">项目阶段</a></li>
        <li><a style="cursor: pointer;" href="teachcontent.action?programId=${id}&menu=menu">教学内容设置</a></li>
        <!--<li><a href="programs!studentlog.action?id=${id }">学员培训记录查询</a></li>
        --><li><a href="${ctx}/clazz/manage/clazz.action?programId=${id}">项目班级</a></li>
    </ul>               
</div>
<div class="tab-content dr-tabs-panel">
  <form class="form-horizontal dr-form-bordered" id="form1" action="programs!save.action" method="post" enctype="multipart/form-data"> 
     <input type="hidden" name="id" value="${trainingPrograms.id}" />

     <div class="dr-form-title clearfix">
       <div class="col-md-12">
       <h4 class="text-primary">培训项目属性</h4>
      </div>
     </div>
     	
     	<div class="form-group" id="validate_itemid">
		<label class="col-md-2 control-label">项目类型<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<s:select cssClass="form-control" placeholder="" 
		list="ItemCategories" listKey="id" listValue="name" theme="simple" name="itemid" id="item" value="trainingPrograms.itemCategoryId">
        </s:select>
		</div>
        <span class="help-block" id="error_itemid"></span>
		</div>
     
		<div class="form-group" id="validate_name">
        <label class="col-md-2 control-label">项目名称<span class="text-danger">*</span></label>
        <div class="col-md-3">
        	<input type="text" value="${trainingPrograms.name}"
			name="name" id="name" class="form-control"/>
     	</div>
			<span class="help-block" id="error_name"></span>
     	</div>
	
		<div class="form-group" id="validate_code">
        <label class="col-md-2 control-label">项目代码<span class="text-danger">*</span></label>
        <div class="col-md-3">
        <input type="text" value="${trainingPrograms.code}" name="code"  class="form-control" />
		</div>
	    <span class="help-block" id="error_code"></span>
		</div>
	
		<div class="form-group" id="validate_descr">
        <label class="col-md-2 control-label">项目介绍<span class="text-danger">*</span></label>
        <div class="col-md-3">
        <textarea rows="5" cols="40" name="descr"  class="form-control" style="resize: none;">${trainingPrograms.descr}</textarea>
        </div>
        <span id="error_descr" class="help-block"></span>
        </div>
	    <div class="form-group" id="validate_groupPhone">
		<label class="col-md-2 control-label">项目联系号码<span class="text-danger">*</span>
		</label>
		<div class="col-md-3">
		<input type="text" value="${trainingPrograms.groupPhone}" id="groupPhone" name="groupPhone" class="form-control"></input>
		</div>
		<span class="help-block" id="error_groupPhone"></span>
		</div>
        <div class="form-group">
        <label class="col-md-2 control-label">是否总体付费</label>	
		<div class="col-md-3">
		<s:select list="#{'0':'否','1':'是'}" listKey="key" listValue="value" name="totalPay" theme="simple" headerKey="" 
		value="totalPay" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectTotalPay()" id="totalPay"></s:select>	
	    </div>
	    <div id="totalPayType" style="display:none;">
	    <label class="col-md-2 control-label">付费总金额</label>	
	    <div class="col-md-3">
		<input type="text" value="${trainingPrograms.totalPrice}" id="totalPrice" name="totalPrice"  class="form-control"></input>
		</div>
		<span id="error_totalPrice" class="help-block" ></span>
	    </div>
	    </div>
	 
	 	<div class="form-group">
		<label class="col-md-2 control-label">是否在移动段显示</label>
		<div class="col-md-3">
		<s:select list="#{'1':'否','0':'是'}" listKey="key" listValue="value" name="mobileshow" theme="simple" headerKey="" 
		value="mobileshow" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="mobileshow"></s:select>	
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
		<input type="text" value="${trainingPrograms.phaseNum}" id="phaseNum" name="phaseNum"  class="form-control"></input>
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
        <label class="col-md-2 control-label">毕业时要求<span class="text-danger">*</span></label>
		<div class="col-md-2">
		<div class="input-group"> 
		<input type="text" value="${trainingPrograms.hours}" id="hours" name="hours"   class="form-control"/>
		<span class="input-group-addon" style="width:50px;">学分</span>
        </div>
        </div>
			<span id="error_hours" class="help-block"></span>
        </div>
	 
	 
		<div class="form-group" id="validate_uploadPic">
        <label class="col-md-2 control-label">项目图片<span class="text-danger">*</span></label>
		<div class="col-md-2" id="col-md">
		 <input id="pic" name="pic" type="hidden" value="${trainingPrograms.pic}"/>
     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
		 <span class="glyphicon glyphicon-open mr5"></span>上传图片
		 </button>
		 <div  style="display: none;" id="iframePic" >
		 <iframe src="${ctx}/train/manage/programs!uploadphoto.excsec?picfileFileName=${trainingPrograms.pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
		 </div>
		<s:if test="trainingPrograms.pic!=null">
		<div class="img-thumbnail mt10">
         <img id="cruPic" alt="294x170" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${trainingPrograms.pic}" style="width:294px; height:170px;"/>
        </div>
        </s:if>
		</div>
		<span id="error_uploadPic" class="help-block"></span>
	    </div>
	
		<div class="form-group">
        <label class="col-md-2 control-label">关联证书</label>
		<div class="col-md-2">
	      <s:select list="certs" listKey="id"  listValue="name" name="certid" id="cert" theme="simple" value="trainingPrograms.certId" headerKey="" headerValue="请选择关联的项目证书" cssClass="form-control input-sm" cssStyle="width:250px" onchange="selectCertstandard()"></s:select>
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
				value="trainingPrograms.finishcondition" cssClass="form-control" cssStyle="width:150px" ></s:select>	
				</s:if>
				<s:else>
				<s:select list="#{'0':'学时达到要求','1':'考核标准达到要求'}" listKey="key" listValue="value" name="finishcondition" theme="simple" headerKey="" 
				value="trainingPrograms.finishcondition" cssClass="form-control" cssStyle="width:150px" ></s:select>	
				</s:else>	
		    </div>
	    </div>
		</div>
	
	<s:if test="trainingPrograms.cert.id!=null">
	
		<div class="form-group">
        <label class="col-md-2 control-label">自动发布证书</label>	
		<div class="col-md-3">
		<s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="autopubcert" theme="simple" headerKey="" value="autopubcert" cssClass="form-control input-sm" cssStyle="width:60px"></s:select>	
	    </div>
	    </div>
	</s:if>
	
<div class="panel-footer">
	<div class="row">
	<div class="col-md-offset-2 col-md-10">		
			<button class="btn btn-primary"  type="submit"  ><span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button> 		
			<button class="btn btn-default"  type="button"  onclick="window.opener=null;window.open('','_self');window.close();" ><span class="glyphicon glyphicon-remove-circle"></span>&nbsp;关闭</button> 
	</div>
	</div>
</div>		
	
 </form>
 </div>
 </div>
 </section>
 </div>
 <!--正文结束-->

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
