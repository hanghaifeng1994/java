<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${trainingPrograms.name}阶段<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>
<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />

<script>  
	$(document).ready(function() {
		$('input[name="focusFlag"]').change(function(){
			if($(this).val()=="true"||$(this).val()==true){
				$("#validate_focusDemo").show();
				$("#validate_ipAddress").show();
			}else{
				$("#validate_focusDemo").hide();
				$("#validate_ipAddress").hide();
			}
		});
		$("#inputForm").validate({
			rules: {
			name: {
			required: true,
			maxlength: 20
			}  
			,hours:
			{
				required: true,
				number:true  
			}
			,year:
			{
				required: true,
				number:true  
			}
			,focusDemo:{
				maxlength: 120
			}
			,pubmustNum:{
				required: true,
				number:true
			},pubmustMaxNum{
				required: true,
				number:true
			}
			},
			messages: {
				name: {
					required: "请输入阶段名称",
					maxlength: "阶段名称最多为20个字符,请重新输入"
				}
				,hours:
				{
					required: "请输入学时",
					number:"请输入数字"
				}
				,year:
				{
					required: "请输入年度",
					number:"请输入数字"
				}
				,focusDemo:{
					maxlength: "最多为120个字符,请重新输入"
				}
				,pubmustNum{
					required: "请输入公需课数目",
					number:"请输入数字"
				},pubmustMaxNum{
					required: "请输入公需课数目",
					number:"请输入数字"
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
		        errorElement: "strong",
		        submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form  
		        	var v = $('input[name="focusFlag"]:checked').val();
                    if(v==true||v=="true"){
                    	if($.trim($("#focusDemo").val())==""){
                    		alert("请输入机考考试安排说明!");
                    		return false;
                    	}
                    }
                    form.submit();   //提交表单   
                }
		});
 	});
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
<label style="margin-right: 10px;">${trainingPrograms.name}</label>项目管理-新增阶段
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
        <li class="active"><a style="cursor: pointer;" href="phase.action?programId=${programId}&menu=menu">项目阶段</a></li>
        <li><a style="cursor: pointer;" href="teachcontent.action?programId=${programId}&menu=menu">教学内容设置</a></li>
        <!--<li><a href="programs!studentlog.action?id=${itemid}">学员培训记录查询</a></li>
        --><li><a href="${ctx}/clazz/manage/clazz.action?programId=${programId}">项目班级</a></li>
    </ul>                
</div>
<div class="tab-content dr-tabs-panel">
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
	<div class="panel panel-default">
	<form class="form-horizontal dr-form-bordered" name="inputForm" id="inputForm" action="phase!save.action"method="post">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="programId" value="${programId}" />
			
			<div class="dr-form-title clearfix">
			<div class="col-md-12">
			<h4 class="text-primary">阶段基本信息</h4>
			</div>
			</div>
				
			<div class="form-group" id="validate_name">
			<label class="col-md-2 control-label">阶段名称<span class="text-danger">*</span>
			</label>
			<div class="col-md-3">
			<input type="text" value="${name}" id="name" name="name" class="form-control"></input>
			</div>
			<span class="help-block" id="error_name"></span>
			</div>	
			
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
			
			<div class="form-group" id="validate_pubmustNum">
			<label class="col-md-2 control-label">公需课最少选修<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input type="text" value="<s:if test="pubmustNum==0">1</s:if><s:else>${pubmustNum}</s:else>" id="pubmustNum" name="pubmustNum" class="form-control"/>
			<span class="input-group-addon" style="width:50px;">门</span> 
			</div>
			</div>
			<span id="error_pubmustNum" class="help-block"></span>
			</div>
			
			<div class="form-group" id="validate_pubmustNum">
			<label class="col-md-2 control-label">公需课最多选修<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input type="text" value="${pubmustMaxNum}" id="pubmustMaxNum" name="pubmustMaxNum" class="form-control"/>
			<span class="input-group-addon" style="width:50px;">门</span>
			</div> (0为不限制)
			</div>
			<span id="error_pubmustNum" class="help-block"></span>
			</div>
			
			<div class="form-group" id="validate_year">
			<label class="col-md-2 control-label">阶段年度<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input type="text" value="${year}" id="year" name="year" class="form-control"/>
			<span class="input-group-addon" style="width:50px;">年</span> 
			</div>
			</div>
			<span id="error_year" class="help-block"></span>
			</div>
			
			<div class="form-group" id="validate_focusFlag">
			<label class="col-md-2 control-label">同一班级多次选课<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
       	 	<input name="multSel" class="focusFlag" id="multSel" type="radio" value="false" <s:if test="multSel!=true">checked</s:if> />否&nbsp;&nbsp;
			<input name="multSel" class="focusFlag" id="multSel" type="radio" value="true"  <s:if test="multSel==true">checked</s:if>/>是&nbsp;&nbsp;
			</div>
			</div>
			</div>
			
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			<div class="form-group" id="validate_focusFlag">
			<label class="col-md-2 control-label">是否集中机考<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input name="focusFlag" class="focusFlag" id="focusFlag" type="radio" value="false" <s:if test="focusFlag!=true">checked</s:if> />否&nbsp;&nbsp;
       	 	<input name="focusFlag" class="focusFlag" id="focusFlag" type="radio" value="true" <s:if test="focusFlag==true">checked</s:if>/>是&nbsp;&nbsp;
			</div>
			</div>
			</div>	
			
			<div class="form-group" id="validate_focusFlag">
			<label class="col-md-2 control-label">是否开放机考<span class="text-danger">*</span>
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input name="focusOpen" class="focusFlag" id="focusOpen" type="radio" value="false" <s:if test="focusOpen!=true">checked</s:if> />否&nbsp;&nbsp;
       	 	<input name="focusOpen" class="focusFlag" id="focusOpen" type="radio" value="true"  <s:if test="focusOpen==true">checked</s:if>/>是&nbsp;&nbsp;
			</div>
			</div>
			</div>		
			
			<div class="form-group" id="validate_ipAddress" <s:if test="focusFlag!=true">style="display:none;"</s:if>>
			<label class="col-md-2 control-label">限定IP地址
			</label>
			<div class="col-md-3">
			<input id="ipAddress" name="ipAddress" class="form-control" type="text" value="${ipAddress}" class="form-control"/>
			</div>
			<span class="help-block" id="error_ipAddress"></span>
			<div class="col-md-6">
			</div>
			</div>
			
			<div class="form-group" id="validate_focusDemo" <s:if test="focusFlag!=true">style="display:none;"</s:if>>
			<label class="col-md-2 control-label">机考考试安排说明<span class="text-danger"></span>
			</label>
			<div class="col-md-3">
			<textarea id="focusDemo" name="focusDemo" class="form-control" style="resize:none;">${focusDemo}</textarea>
			</div>
			<span class="help-block" id="error_focusDemo"></span>
			</div>
			</s:if>	
			
			<div class="form-group" id="validate_classDescr">
			<label class="col-md-2 control-label">班级提醒
			<span class="text-danger"></span>
			</label>
			<div class="col-md-10">
			<textarea class="form-control" rows="3" name="classDescr" id="classDescr">${classDescr}</textarea>
			<script type="text/javascript">
			createCkEditor("${ctx}/fckeditor/","classDescr",700,320,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
			function FCKeditor_OnComplete(editorInstance) { 
				//IE,搜狗浏览器的
				if(document.all){
					editorInstance.EditorDocument.attachEvent("onkeyup", editor_keyup); 
				}else{//火狐浏览器
					editorInstance.EditorDocument.addEventListener('keyup', editor_keyup,false) ;
				}
			}
			function editor_keyup(e) 
			   { 
			    if(getLength()>0)
					$('#error_classDescr').hide();
			    else
			    	$('#error_classDescr').show();
			   }
			</script>
			</div>
			<span class="help-block" id="error_classDescr" style="margin-left: 220px;"></span>
			</div>
			
			<div class="panel-footer">
			<div class="row">
			<div class="col-md-offset-2 col-md-10">
			 	<button name="Submit32" type="submit" class="btn btn-primary btn-sm" onclick="checkedError()">
				<span class="glyphicon glyphicon-ok"></span>&nbsp;保存
				</button> 
				<button onclick="window.location.href='phase.action?programId=${programId}'" type="button" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-remove"></span>&nbsp;取消
				</button>
			</div>
			</div>
			</div>
	</form>
	</div>
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