<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","traincore.webapp.url"));
request.setAttribute("manageUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","manage.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 
<html>
<head>
<title>新增书籍<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
    <%@ include file="/common/admin_meta.jsp"%>
    <script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
	<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>

 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	<link rel="stylesheet" href="${ctx}/jcrop_zh/css/jquery.Jcrop.css" type="text/css" />
    <script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/jcrop_zh/js/jquery.Jcrop.js"></script>
	<link href="${staticurl}/css/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${staticurl}/js/layer.js" type="text/javascript"></script>
    <script src="${ctx}/js/cutpic.js" type="text/javascript"></script>        
    
<script>
		$(document).ready(function() {
	        if($("#success").text()!="")$("#div-success").show();
	        if($("#error").text()!="")$("#div-error").show();
	        $("#free_starttime").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0,
				
					 }); 
			 $("#pubDate").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0
				 
					 }); 
			$("#cbTime").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0
			}); 	 
				
			 $("#free_endtime").datetimepicker({
				 format: 'yyyy-mm-dd',
				 language:'zh-CN',
				 weekStart: 1,
				 autoclose: 1,
				 todayHighlight: 1,
				 startView: 2,
				 minView: 2,
				 forceParse: 0
			
					 }); 
			 				            
			//$("#validDate").datepick({dateFormat: 'yy-mm-dd'});
			//$("#pubDate").datepick({dateFormat: 'yy-mm-dd'});
			//$("#free_starttime").datepick({dateFormat: 'yy-mm-dd'});
			//$("#free_endtime").datepick({dateFormat: 'yy-mm-dd'});
			//聚焦第一个输入框
			$("#name").focus();

			// tree初始化
            var o = {
                    showcheck: true,          
                    //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                    theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
    				isfolder:false,
    				iscascade: false, //是否选中节点后向下遍历
                    isbubble: true //是否选中节点后向上上溯
                    //onnodeclick:function(item){alert(item.text);}
            };
            o.data = ${catTreeData};
            $("#navigation").treeview(o);
            
			//为inputForm注册validate函数
			//jQuery.validator.addMethod("isStudylen", function(value, element) {
				//	if(element.checked)
					//		if($("#finishedLearnedLen").val()<=0)return false;    
				//	return true;
		  		//}, "书籍完成时长必须大于0");

			//	jQuery.validator.addMethod("isCoverrate", function(value, element) {
				//	if(element.checked)
					//		if($("#finishedCoverageRate").val()<=0)return false;    
				//	return true;
		  		//}, "书籍完成覆盖率必须大于0");

			//jQuery.validator.addMethod("isScore", function(value, element) {
				//if(element.checked)
					//	if($("#neededFinishedScore").val()<=0)return false;    
				//return true;
			//}, "书籍完成要求的合格分必须大于0");

			//jQuery.validator.addMethod("isFinishedneed", function(value, element) {
				//if(!$('form #studyneed').is(':checked') && !$('form #rateneed').is(':checked') && !$('form #scoreneed').is(':checked'))
		  			//return false;
		  		//return true;
			//}, "必须设置一种书籍完成条件");
			
			jQuery.validator.addMethod("compareDate", function(value, element, param) {
 			var startDate = jQuery(param).val();
			if(startDate!=''){
            var date1 = new Date(parseInt(Date.parse(startDate.replace("/\-/g", "/")),10));
            var date2 = new Date(parseInt(Date.parse(value.replace("/\-/g", "/")),10));
            if(value=='' && startDate=='')return true;
            else
            return date1 < date2;
			}else return true;
 	  }, "结束时间必须大于开始时间");
		 	  
			$("#inputForm").validate({
				rules: {
				    name: {
						required: true,
						remote: "product!checkName.excsec?oldName="+encodeURIComponent('${name}')
					},
					serialNo: {
						remote: "product!checkProductSerialNo.excsec?oldSerialNo="+encodeURIComponent('${serialNo}')
					},
					validDate: {
						required: true
					},	
					productModel: {
						required: true
					},
					productPermission:{
						required: true
					},
					free_endtime:{
						compareDate:"#free_starttime2"
					},
					subject:{
						required: true
					},			
					productType: {
						required: true
					},			
					price: {
						required: true,
						number:true
					},
					studylength: {
						required: true,
						number:true
					},				
					examNum: {
						required: true,
						number:true
					},
					homeworkNum: {
						required: true,
						number:true
					},
					studyTime: {
						number:true
					},
					autor: {
						required: true
					},
					cbUnit: {
						required: true
					},
					cbTime: {
						required: true
					}
				},
				messages: {
					name: {
						required:"请输入书籍名称",
						remote: "书籍名称已存在"
					},
					serialNo: {
						remote: "书籍代码已存在"
					},
					validDate: {
						required:"请输入书籍有效期"
					},	
					productModel: {
						required:"请选择书籍属性"
					},
					productPermission:{
						required:"请设置书籍权限"
					},
					subject:{
						required: "请输入书籍介绍"
					},		
					productType: {
						required:"请选择书籍类型"
					},	
					price:{
						required:"请输入书籍价格",
						number:"书籍价格只能是数字"
					},
					studylength:{
						required:"请输入书籍可得学分",
						number:"书籍可得学分只能是数字"
					},	
					examNum:{
						required:"请输入考试次数",
						number:"考试次数只能是数字"
					},	
					homeworkNum:{
						required:"请输入作业数量",
						number:"作业数量只能是数字"
					},
					studyTime:{
						number:"书籍学习时长只能是数字"
					},
					autor:{
						required:"请输入作者"
					},
					cbUnit:{
						required:"请输入出版社"
					},
					cbTime:{
						required:"请输入出版时间"
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
					//var e = $(label).parent().attr("id").split("_")[1];
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
				submitHandler: function(form) {
	                var s=$("#navigation").getTSVs();
	                if(s !=null){
						$("#checkCats").val(s.join(","));
		            }
					form.submit();
				}			
			});
			window.domain="localhost"; 
		});
		
		function iFrameHeight() {
			var ifm= document.getElementById("main");
			
			var subWeb = document.frames ? document.frames["main"].document : ifm.contentDocument;  
			if(ifm != null && subWeb != null) {
			   ifm.height = subWeb.body.scrollHeight;
			}   
		}
        function sel(){
	        var zt = document.getElementsByName("productModel");
	        for(var i=0;i<zt.length;i++){
	        	if(zt[i].checked&&zt[i].value==3) 
		        	{
		        	$("#price").val("0.0");
		        	$('#price').attr('disabled',"true");
		        	}
	        	else{
	        		$('#price').removeAttr('disabled');
		        	}
	        	}
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
function close(){
	$("#iframePic").hide();
	$("#col-md").attr("class","col-md-2");
}
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="input-product" name="menu" />
	<jsp:param value="product" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">书籍资源库管理</a>
</li>
<li class="active"><s:if test="id==null">新增</s:if><s:else>编辑</s:else>书籍</li>
</ol>

<div class="dr-page-header">
<h3>
<s:if test="id==null">新增</s:if><s:else>编辑</s:else>书籍
</h3>
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
<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="product!save.action" method="post" enctype="multipart/form-data">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>
<input id="id" name="finishedneed" type="hidden" value="" size="30"/>
<input id="id" name="tabFlag" type="hidden" value="${tabFlag}" size="30"/>

<div class="dr-form-title clearfix">
<div class="col-md-12">
<h4 class="text-primary">书籍基本信息</h4>
</div>
</div>
<div class="form-group" id="validate_name">
     <label class="col-md-2 control-label">书籍名称<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="name" value="${name}" type="text" class="form-control"/>
     </div>
     <span class="help-block" id="error_name"></span>
</div>

<div class="form-group" id="validate_serialNo">
     <label class="col-md-2 control-label">书籍代码</label>
     <div class="col-md-3">
     <input name="serialNo" value="${serialNo}" type="text" class="form-control"/>
     <span class="help-block">（不填则系统生成）</span>
     </div>
     <span class="help-block" id="error_serialNo"></span>
</div>

<div class="form-group" id="validate_price">
    <label class="col-md-2 control-label">价格<span class="text-danger">*</span></label>
    <div class="col-md-3"><input name="price" value="${price}" type="text" class="form-control" id="price"/>
    </div>
    <span class="help-block" id="error_price"></span>
</div> 

<div class="form-group" id="validate_productModel">
    <label class="col-md-2 control-label">书籍性质<span class="text-danger">*</span></label>
    <div class="col-md-5 mt5">
    <s:radio cssClass="ml5 mr5" onchange="sel()" cssStyle="font-weight: normal;" list="#{1:'收费书籍',3:'免费书籍'}" value="productModel"  name="productModel" theme="simple"></s:radio>
    <span class="text-danger" id="error_productModel"></span>
</div>
</div>

<div class="form-group" id="validate_autor">
     <label class="col-md-2 control-label">作者<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="autor" value="${autor}" type="text" class="form-control"/>
     </div>
     <span class="help-block" id="error_autor"></span>
</div>

<div class="form-group" id="validate_cbUnit">
     <label class="col-md-2 control-label">出版社<span class="text-danger">*</span></label>
     <div class="col-md-3">
     <input name="cbUnit" value="${cbUnit}" type="text" class="form-control"/>
     </div>
     <span class="help-block" id="error_cbUnit"></span>
</div>

<div class="form-group">
    <label class="col-md-2 control-label">出版时间</label>
    <div class="input-group date col-md-3"  id="cbTime" style="padding-left: 15px;float: left;margin-right: 5px;"> 
    <input type="text"  value="<s:date name="cbTime" format="yyyy-MM-dd" />"
			readonly="readonly" name="cbTime" class="form-control" />
	    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>
	
	<span class="text-danger" id="error_pubDate"></span>
</div>
   
<div class="form-group">
    <label class="col-md-2 control-label">发布时间</label>
    <div class="input-group date col-md-3"  id="pubDate" style="padding-left: 15px;float: left;margin-right: 5px;"> 
    <input type="text"  value="<s:if test="id==null">${nowtime}</s:if><s:else><s:date name="pubDate" format="yyyy-MM-dd" /></s:else>"
			readonly="readonly" name="pubDate" class="form-control" />
	    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	   <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	</div>
	
	<span class="text-danger" id="error_pubDate"></span>
</div>
<div class="form-group" id="validate_checkCats">
    <label class="col-md-2 control-label">所属分类</label>
    <div class="col-md-3">
		<div id="tree" style="width:250px;height:250px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
			<ul id="navigation">
			</ul>
			<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
		</div>
		<span class="help-block" id="error_checkCats"></span>
    </div>
  </div>  
   
  <!-- 
  <div>
    <div class="divll">书籍类型</div>
    <div><div style="float: left;"><s:radio list="#{0:'普通',1:'scorm'}" value="productType"  name="productType" theme="simple"></s:radio></div><div style="padding-left: 10px;"><span class="text-danger" id="error_productType"></span></div></div>
  </div>  
  -->
  
<div class="form-group">
    <label class="col-md-2 control-label">书籍封面</label>
    <div class="col-md-2" id="col-md">
      <input id="pic" name="pic" type="hidden" value="${pic}"/>
     	 <button class="btn btn-primary btn-sm" type="button" onclick="uploadpic()">
		 <span class="glyphicon glyphicon-open mr5"></span>上传图片
		 </button>&nbsp;&nbsp;(90x120)
		 <div  style="display: none;" id="iframePic" >
		 <iframe src="${ctx}/product/manage/product!uploadphoto.excsec?picfileFileName=${pic}" frameborder="0" width="100%" height="810" scrolling="no"></iframe>
		 </div>
        <div class="img-thumbnail mt10">
         <img id="cruPic" alt="90x120" data-src="holder.js/140x140" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${pic}" style="width:90px; height:120px;"/>
       </div>
    </div>
</div>
  
<div class="form-group" id="validate_subject">
    <label class="col-md-2 control-label">书籍介绍<span class="text-danger">*</span></label>
    <div class="col-md-8">
        <textarea name="subject" cols="60" rows="3" class="form-control">${subject}</textarea>
         <script type="text/javascript">
        
			createCkEditor("${ctx}/fckeditor/","subject",700,320,"Basic",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
		</script>
    </div>
    <br/>
	<span class="help-block" id="error_subject"></span>
</div>

 	<div class="form-group">
		<label class="col-md-2 control-label">是否在移动段显示</label>
		<div class="col-md-3">
		<s:select list="#{'1':'否','0':'是'}" listKey="key" listValue="value" name="mobileshow" theme="simple" headerKey="" 
		value="mobileshow" cssClass="form-control input-sm" cssStyle="width:60px" onchange="selectType()" id="mobileshow"></s:select>	
	    </div>	
	</div>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">	
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
        </button>
        <s:if test="curTenantID==null">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='product.action?tabFlag=${tabFlag}'">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
        </button>
        </s:if>
        <s:else>
        <button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='product!productTenant.action?tabFlag=${tabFlag}'">
        <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
        </button>
        </s:else>
</div>
</div>
</div>

</form>
</div>
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
