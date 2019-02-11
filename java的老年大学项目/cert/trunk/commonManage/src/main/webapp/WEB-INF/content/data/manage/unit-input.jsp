<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script>  
	$(document).ready(function() {
		<s:if test="id != null">
		$('#area_id option:selected').val("${unitarea}");
		</s:if>
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		
 		 		$("#form1").validate({
 			rules: {
 			name: {required: true,maxlength: 50},  
 			code:{required: true},
 			unitcity:{required: true}
		},
 			messages: {
 				name: {
 					required: "请输入单位名称",
 					maxlength: "分类名称最多为50个字符,请重新输入"
 				},
 				code:
				{required: "请输入单位代码"
 					}
				,unitcity:
				{
					required: "请输入单位所在市"
				} 
 			},
			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
		    onfocusin: function(element) { $(element).valid(); },
	        success: function(label) { 
 		        //alert($(label).parent().attr("id"))
				var e = $(label).parent().attr("id").split("_")[1];
				//$(label).parent().attr("class")
				var oclass=$("#validate_"+e).attr("class");
				if(oclass && oclass.indexOf("form-group")>-1)
					oclass = "form-group";
				else
					oclass="";
	        	$("#validate_"+e).attr("class",oclass+" has-success")     
	    		$(label).remove();
	        },
	        errorPlacement: function(error, element) { 
 				//alert("errorPlacement") 
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

	//根据市获得区县
	function changecity(){
		var city = $("#city_id").val();
		$("#area_id option[value!='']").remove();
		if(city) {
			$.post("${ctx}/data/manage/unit!getAreaLists.excsec",{"unitCity":city},function(data) {
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#area_id option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					$("#area_id").append("<option value='"+practiceUnit[i].label+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}
	
	}	
</script>
</head>

<body>
	<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
  <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="unitlist" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->  
  <section id="main" role="main"> 
  <div class="dr-container-fluid">

    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">基础数据管理</a></li>
     <li class="active"><s:if test="id == null">新增</s:if><s:else>编辑</s:else>单位</li>
    </ol>
   <div class="dr-page-header">
     <h3><s:if test="id == null">新增</s:if><s:else>编辑</s:else>单位</h3>
   </div>
   <hr/>
	
<form id="form1" action="unit!save.action" method="post" class="form-horizontal dr-form-bordered" >
    <input type="hidden" name="id" value="${id}" cssClass="tipbox"/>
    <input id="parentId" name="parentId" type="hidden" value="${parentId}" size="30"/>

   <div class="form-group" id="validate_name">
    <label class="col-md-2 control-label">单位名称<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${name}" id="name" name="name" class="form-control"/>
		
    </div>
    <span id="error_name" class="help-block"></span>
  </div>

   <div class="form-group" id="validate_code">
    <label class="col-md-2 control-label">单位代码<span class="text-danger">*</span></label>
    <div class="col-md-3">
	    <input type="text" value="${code}" id="code" name="code" class="form-control"/>
		
    </div>
    <span id="error_code" class="help-block"></span>
  </div>

   <div class="form-group" id="validate_unitcity">
    <label class="col-md-2 control-label">单位所属市<span class="text-danger">*</span></label>
    <div class="col-md-3">
	  <s:select onchange="changecity()"  cssClass="form-control" list="citysLists" listKey="name"  listValue="name" name="unitcity" value="unitcity" id="city_id" theme="simple" headerKey="" headerValue="--所在市--"/>
    </div>
    <span id="error_unitcity" class="help-block"></span>
  </div>

   <div class="form-group" id="validate_unitarea">
    <label class="col-md-2 control-label">单位所属区县</label>
    <div class="col-md-3">
	    <s:select cssClass="form-control" list="areasLists" listKey="name"  listValue="name" name="unitarea" value="unitarea" id="area_id" theme="simple" headerKey="" headerValue="--所在区县--"/>
		
    </div>
    <span id="error_unitarea" class="help-block"></span>
  </div>

   <s:if test='advanceName!=""'>
	<div class="form-group" >
    <label class="col-md-2 control-label">上级区划</label>
    <div class="col-md-3">
	    ${advanceName}
    </div>
  </div>
	</s:if>
  <div class="panel-footer">
    <div class="row">
       <div class="col-md-offset-2 col-md-10">
            <button name="Submit32" type="submit" class="btn btn-primary" >
 			 <span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
 			<button onclick="window.location.href='unit.action?pid=${pid}'" type="button"class="btn btn-default" >
			 <span class="glyphicon glyphicon-remove"></span>&nbsp;取消</button>
         
       </div>
      
    </div>
  </div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
</body>
</html>
