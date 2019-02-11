<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-班级课程<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<%
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
%> 
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>


<script>  

	function tst(){location.reload();}

	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();

        $("#startTime").datetimepicker({
        	pickDate: false,
        	language:'zh-CN',
        	minuteStep:30,
            format: 'hh:ii',
            startView:1,
            autoclose:true,
            maxView:1,
            forceParse: false        
         }); 
        $("#endTime").datetimepicker({
        	pickDate: false,
        	language:'zh-CN',
        	minuteStep:30,
            format: 'hh:ii',
            startView:1,
            autoclose:true,
            forceParse: false,
            maxView:1        
         }); 
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
        $("#endDate").datetimepicker({
			 format: 'yyyy-mm-dd',
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0   
       
        }); 
        
	})
	
	$(document).ready(function() {
       $("#optionsRadios1").click(function(){
           $("#week").show();
           $("#validate_startTime").show();
           $("#validate_endTime").show();
           $("#validate_startDate").show();
           $("#validate_endDate").show();
            
           });  
       $("#optionsRadios2").click(function(){
           $("#week").hide();
           $("#validate_startTime").hide();
           $("#validate_endTime").hide();
           $("#validate_startDate").hide();
           $("#validate_endDate").hide();
            
           });  

		
 		//为registerForm注册validate函数
 		$("#inputForm").validate({
 			rules: {
 			startTime: {
				required: true
			}  
			,endTime:
			{
				required: true
			},startDate:{
				required: true
		    },endDate:{
		    	required: true
			    }
 			},
 			messages: {
 				startTime: {
 					required: "请输入开始时间"
 				}
				,endTime:
				{
					required: "请输入结束时间",
					limtCompareTime: "#startTime1"
				} ,startDate:{
					required: "请输入开始日期"
				},endDate:{
					required: "请输入结束日期",
					limtCompareDate: "#endDate1"
				}
					
			
 			},
			onsubmit: function(element) { $(element).valid(); },
			onfocusout: function(element) { $(element).valid(); },			
			onkeyup: function(element) { $(element).valid(); },
		    onfocusin: function(element) { $(element).valid(); },
	        success: function(label) { 
		    	var divId = $(label).parent().attr("id");
		    	var startindex = divId.indexOf("_"); 
		    	var e = divId.substring(startindex+1);
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
</script>
<style type="text/css">

</style>
</head>

<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
   <div class="dr-page-header">
     <h3>班级课程-课表设置</h3>
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
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">
          ${classCourse.clazz.name}(${classCourse.course.name})-排课管理
    </h3>

  </div>

 <div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
    <div class="panel-heading">
     <h3 class="panel-title">已排课信息</h3>
     <div class="panel-toolbar text-right dr-slash-text small">
   </div>
  </div>
<form id="mainForm" name="mainForm"	action="mcoursearrange.action" class="form-inline dr-form-inline" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="clazzid" value="${clazzid}"/>
<input type="hidden" name="courseid" value="${courseid}"/>
<table  class="table table-bordered dr-table-bordered" style="width:98%;">
  <thead>
	<tr>
		<th >日期</th>
		<th >星期</th>
		<th >上午/下午</th>
		<th >开始时间</th>
		<th >结束时间</th>
		<th >操作</th>
		</tr>
  </thead>
  <tbody>
	<s:iterator value="page.result" status="stat">
		<tr>
		    <td>&nbsp;${strDate}</td>
			<td>&nbsp;${week}</td>
			<td>&nbsp;${amorpm}</td>
			<td>&nbsp;${strTimes}</td>
			<td>&nbsp;${strTimee}</td>
			<td><a href="${ctx }/clazz/manage/mcoursearrange!delete.action?ids=${id}&clazzid=${clazzid}&courseid=${courseid}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-trash"></span>删除</a></td>
		</tr>
	</s:iterator>
	</tbody>
</table>
</form>
<%@ include file="/common/turnpage.jsp"%>
</div> 
   

<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
 <form class="form-horizontal dr-form-bordered" id="inputForm" action="mcoursearrange!save.action" method="post" enctype="multipart/form-data" name="inputForm">
 <input type="hidden" name="clazzid" value="${clazzid}"/>
 <input type="hidden" name="courseid" value="${courseid}"/>

     <div class="dr-form-title clearfix">
         <div class="col-md-12">
         <h4 class="text-primary">增加排课</h4>
         </div>
     </div>

    <div class="form-group">
    <label class="col-md-2 control-label">排课方式<span class="text-danger">*</span></label>
           <div class="col-md-10">
               <div class="radio" style="float:left;margin-right: 30px;" id="speedarrange">
                  <label><input type="radio" checked="checked" value="option1" id="optionsRadios1" name="optionsRadios" />
                                                    快速排课
                  </label>
               </div>
               <div class="radio" id="import">
                  <label><input type="radio" value="option2" id="optionsRadios2" name="optionsRadios" />
                                                  手动导入课表
                  </label>
               </div>
           </div>
	</div>
	<div class="form-group" id="week">
       <label class="col-md-2 control-label">选择星期<span class="text-danger">*</span></label>
          <div class="col-md-10">
               <s:checkboxlist name="state" list="#{'星期一':1,'星期二':2,'星期三':3,'星期四':4,'星期五':5,'星期六':6,'星期日':7}"
            	theme="simple" listKey="value" listValue="key" value="state" cssClass="checkbox checkbox-inline"> 
            </s:checkboxlist>
              
          </div>
    </div>
	
    <div class="form-group" id="validate_startTime">
		<label class="col-md-2 control-label"  >选择开始时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-2" id="startTime" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control " type="text" value="<s:date name="startTime" format="hh:mm:ss" />"
			readonly="readonly" id="startTime1" name="startTime" class="dateinput" /> 
		  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	      <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_startTime"></span>
	</div>
	
     <div class="form-group" id="validate_endTime">
		<label class="col-md-2 control-label"  >选择结束时间<span class="text-danger">*</span></label>
		<div class="input-group date col-md-2" id="endTime" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control" type="text" value="<s:date name="endTime" format="hh:mm:ss" />"
			readonly="readonly" id="endTime1" name="endTime" class="dateinput" /> 
		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_endTime"></span>
	</div>
	
	
	<div class="form-group" id="validate_startDate">
		<label class="col-md-2 control-label"  >选择排课开始日期<span class="text-danger">*</span></label>
		<div class="input-group date col-md-2" id="startDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control" type="text" value="<s:date name="startDate" format="hh:mm:ss" />"
			readonly="readonly" id="startDate1" name="startDate" class="dateinput" /> 
		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_startDate"></span>
	</div>
    
    	<div class="form-group" id="validate_endDate">
		<label class="col-md-2 control-label"  >选择排课结束日期<span class="text-danger">*</span></label>
		<div class="input-group date col-md-2" id="endDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
		   <input class="form-control" type="text" value="<s:date name="endDate" format="hh:mm:ss" />"
			readonly="readonly" id="endDate1" name="endDate" class="dateinput" /> 
		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>	
		</div>
			<span class="help-block" id="error_endDate"></span>
	</div>  
    
	
	<div class="panel-footer">
         <div class="row">
	
	    <div class="col-md-offset-2 col-md-10">
		<button class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>
                    保存
        </button>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='clazz!mcourse.action?id=${clazzid}'">
        <span class="glyphicon glyphicon-remove"></span>
                     取消
        </button>
        </div>
        <div style="margin-left: 250px;color: red;"><p>*注意：保存后会删除以前的已排课信息</p></div>
        </div>
    </div>
</form>
</div>
</div>
</div>
</section>
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>
