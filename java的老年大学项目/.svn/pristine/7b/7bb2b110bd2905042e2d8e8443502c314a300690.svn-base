<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息发布管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>

<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>  

<script type="text/javascript" language="javascript">
function review()
{
	var action=$("#inputForm").attr("action");
	var target=$("#inputForm").attr("target");
	$("#inputForm").attr("action","article!review.action");
	$("#inputForm").attr("target","_blank");
	$("#inputForm").get(0).submit();
	$("#inputForm").attr("action",action);
	$("#inputForm").attr("target",target);
}

function getUrlParam(name){
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var r = window.location.search.substr(1).match(reg);  //匹配目标参数
  if (r!=null) return unescape(r[2]); return null; //返回参数值
} 

function gotohome(){
	location.href="${ctx}/news/manage/article!newchecked.action";
}
$(document).ready(function(){
	var fr = getUrlParam('fr');
	$("#fr").val(fr);
	if(fr!=""&&fr=="newscheck"){
		$("#adminleft").val("articlecheck");
		$("#incy").hide();
		$("#chcy").show();
	}
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show(); 


	 $("#pubTime").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
			 }); 
	//$("#pubTime").datepick({dateFormat: 'yy-mm-dd'});
	
	$("#oneCats").change(function(){
		$("#twoCats option[value!='']").remove();
		 $.get("${ctx}/related/articlecategory!categories.action", {catid:$(this).val()}, function (data){
			 var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#twoCats").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
				if(cattwo!=null&&cattwo!="")
				{
					$("#twoCats").val(cattwo);
					$("#twoCats").change();
					$('#h_checkcats').val(cattwo);
				}
		});
	});

	$("#twoCats").change(function(){
		$("#threeCats option[value!='']").remove();
		 $.get("${ctx}/related/articlecategory!categories.action", {catid:$(this).val()}, function (data){
			 var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#threeCats").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}

				if(catthree!=null&&catthree!="")
				{
					$("#threeCats").val(catthree);
					$('#th_checkcats').val(catthree);
				}
		});
	});
	
	//聚焦第一个输入框
	$("#username").focus();

	//初始化分类
	initcat();
	$("#inputForm").validate({
		rules: {
			title: {
				required: true,
				maxlength:100,
				 remote: {
                       type: "POST",
                       url: "${ctx}/related/article!checktitle.action",
                       data: {
                           random: Math.random(),
                           title: function() { return $("#title").val(); },
                           oldtitle:  function() { return $("#oldtitle").val(); }
                       }
                   }
			},
			unit: {
				maxlength:30
			},
			checkCats: {
				required: true
			},
			twocheckCats: {
				required: true
			},
			content: {
				required: true
			},
			pubTime:{
				required: true	
			}
		},
		messages: {
			title:{
				required:"请输入标题",
				maxlength:"标题字数不能大于100个字符",
				remote:"已存在相同标题,请修改"
			},
			unit:{
				maxlength:"单位字数不能大于30个字符"
			},
			content:{
				required:"请输入内容"
			}
			,
			pubTime:{
				required:"请输入发布时间"
			}
			,
			checkCats:{
				required:"请选择一级分类"
			}
			,
			twocheckCats:{
				required:"请选择二级分类"
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

var catone;
var cattwo;
var catthree;
function initcat()
{
	var catStr='${catstr}';
	if(catStr!="")
	{
		 var m = catStr.split(",");
		 catone=m[1];
		 cattwo=m[2];
		 catthree=m[3];
		 //changeOneCat($("#tenantId"));
		 $("#oneCats").val(catone);
		 $("#oneCats").change();	
	}
}

function changeOneCat(obj){

	//根据一级栏目获得二级栏目

			$.post("${ctx}/news/manage/article!getOneCat.excsec",function(data) {
				var category = eval(data);
				$("#oneCats option[value!='']").remove(); 
				if(category.length == 0) return;
				for(var i = 0 ;i < category.length ; i++) {
					if(catone==category[i].value)
						$("#oneCats").append("<option selected='selected' value='"+category[i].value+"'>"+category[i].label+"</option>");
					else
						$("#oneCats").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
				} 
				$("#twoCats option[value!='']").remove();
				$("#threeCats option[value!='']").remove();
				$("#oneCats").change();	
			});
		
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
	<jsp:param  value="article" name="menu" />
	<jsp:param value="message" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="#">平台首页</a>
		</li>
		<li>
		<a href="#">信息发布管理</a>
		</li>
		<li class="active"><span ><s:if test="id==null">发布</s:if><s:else>编辑</s:else>信息</span></li>
		</ol>
	<!--/breadcrumb-->
	
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>信息发布管理<small>&nbsp;</small></h3>
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
    <!--表单-->
    	<div class="panel panel-default">
    		<form id="inputForm" name="inputForm" action="article!save.action" method="post" enctype="multipart/form-data" 
    		class="form-horizontal dr-form-bordered" role="form">
    		<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
    		<input type="hidden" name="fr" id="fr" value="" />
    		<input id="id" name="id" type="hidden" value="${id}" size="30" />
    		<div class="dr-form-title clearfix">
    		  <div class="col-md-12">
    		    <h4 class="text-primary">基本信息</h4>
    		  
    		  </div>
    		
    		</div>
    		<!--
    	   <s:if test="nowUser.super">
		      <div class="form-group" id="validate_tenantId">
			    <label class="col-md-2 control-label">租户<span class="text-danger">*</span></label>
			    <div class="col-md-3">
			      <s:select list="tenantLists" listKey="id" onchange="changeOneCat(this)"
					value="tenantId" listValue="name" theme="simple"
					cssClass="form-control" name="tenantId" headerValue="--选择租户--"
					headerKey=""></s:select>
		        </div>
		        <span class="help-block" id="error_tenantId"></span>
		     </div>
		    </s:if>
		    <s:else><input type="hidden" id="tenantId" name="tenantId" value="${nowUser.tenantId}"/></s:else>
		    -->
    		<div class="form-group" id="validate_title">
			<label class="col-md-2 control-label">
			信息标题
			<span class="text-danger">*</span>
			</label>
			<div class="col-md-3">
			<input name="title" value="${title}" type="text" id="title"	class="form-control"/>
			<input type="hidden" value="${title}" id="oldtitle"></input>
			</div>
			<span class="help-block" id="error_title"></span>
			</div>
			
			<div class="form-group" id="validate_focusFlag">
			<label class="col-md-2 control-label">是否标红
			</label>
			<div class="col-md-2">
			<div class="input-group">
			<input name="titlered" class="titlered" id="titlered" type="radio" value="false" <s:if test="titlered!=true">checked</s:if> />否&nbsp;&nbsp;
       	 	<input name="titlered" class="titlered" id="titlered" type="radio" value="true" <s:if test="titlered==true">checked</s:if>/>是&nbsp;&nbsp;
			</div>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">
			单位
			</label>
			<div class="col-md-3">
			<input name="unit" value="${unit}" type="text"	class="form-control dr-dib"/>
			</div>
			</div>
			<div class="form-group">
			<label class="col-md-2 control-label">
			新闻来源
			</label>
			<div class="col-md-3">
			<input name="fromSource" value="${fromSource}" type="text"	class="form-control dr-dib" />
			</div>
			</div>
			<div class="form-group">
			<label class="col-md-2 control-label">
			作者
			</label>
			<div class="col-md-3">
			<input name="author" value="${author}" type="text" class="form-control dr-dib"/>
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">
			链接
			</label>
			<div class="col-md-3">
			<input name="link" value="${link}" type="text" class="form-control dr-dib" />
			</div>
			</div>

			<div class="form-group" id="validate_checkCats">
			<label  class="col-md-2 control-label">所属分类
			<span class="text-danger">*</span>
			</label>
			<div class="col-md-10">
			<table style="font-size:14px;">
			<tr>
              <td><s:select list="oneCats" listKey="id" listValue="name"
					headerKey="" headerValue="选择一级分类" theme="simple" id="oneCats"
					name="checkCats" cssClass="form-control input-sm" cssStyle="float:left;">
					</s:select>
	
				</td>
				<td> 
				<select id="twoCats" name="checkCats" class="form-control input-sm">
					<option value="">选择二级分类</option>
		    	</select>

				</td>  
		 		<td> 
		 		<select id="threeCats" name="checkCats" class="form-control input-sm">
			  		<option value="">选择三级分类</option>
		    	</select>
		    	</td>
			   	<td> <span class="help-block" id="error_checkCats"  ></span></td>
			  	<td> <span class="help-block" id="error_twocheckCats" ></span></td>
		    </tr>
		    </table>
		    </div>
			</div>
			
			<s:if test="currentTenant.contents=='/xs'">
			<div class="form-group" id="validate_checkCats">
			<label  class="col-md-2 control-label">所属社区
			</label>
			<div class="col-md-10">
				<select id="xssq" class="form-control input-sm" name="xssq" style="width:200px;">
					<option value="">无</option>
					<option value="azcszx" <s:if test="xssq=='azcszx'">selected="selected"</s:if>>安镇成社中心</option>
					<option value="dbtcszx" <s:if test="xssq=='dbtcszx'">selected="selected"</s:if>>东北塘成社中心</option>
					<option value="dxcszx" <s:if test="xssq=='dxcszx'">selected="selected"</s:if>>东港成社中心</option>
					<option value="dtcszx" <s:if test="xssq=='dtcszx'">selected="selected"</s:if>>东亭成社中心</option>
					<option value="ehcszx" <s:if test="xssq=='ehcszx'">selected="selected"</s:if>>鹅湖成社中心</option>
					<option value="hqcszx" <s:if test="xssq=='hqcszx'">selected="selected"</s:if>>厚桥成社中心</option>
					<option value="xbcszx" <s:if test="xssq=='xbcszx'">selected="selected"</s:if>>锡北成社中心</option>
					<option value="yjcszx" <s:if test="xssq=='yjcszx'">selected="selected"</s:if>>羊尖成社中心</option>
					<option value="ylcszx" <s:if test="xssq=='ylcszx'">selected="selected"</s:if>>云林成社中心</option>
				</select>
		    </div>
			</div>
			</s:if>
			
			<div class="form-group" id="validate_pubTime">
			<label class="col-md-2 control-label">
			发布时间
			<span class="text-danger">*</span>
			</label>
			<div class="input-group date col-md-3" id="pubTime"  style="padding-left: 15px;float: left;">
			<input type="text" value="<s:date name="pubTime" format="yyyy-MM-dd"/>" name="pubTime" readonly="readonly" class="form-control input-sm"/>
			<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
			</div>
			<span class="help-block" id="error_pubTime" ></span>
			</div>
			
			<div class="form-group" id="validate_content">
			<label class="col-md-2 control-label">信息内容
			<span class="text-danger">*</span>
			</label>
			<div class="col-md-10">
			<textarea class="form-control" rows="3" name="content" id="content">${content}</textarea>
			<script type="text/javascript">
			createCkEditor("${ctx}/fckeditor/","content",700,320,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
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
					$('#error_content').hide();
			    else
			    	$('#error_content').show();
			   }
			</script>
			<!--<ckfinder:setupCKEditor basePath="/ahstudy-webapp/ckfinder/" editor="content" />
			<ckeditor:replace replace="content" basePath="/ahstudy-webapp/ckeditor/" />
            
			
			<script type="text/javascript">
			//createCkEditor("${ctx}/fckeditor/","content",600,380,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
			function FCKeditor_OnComplete(editorInstance) { 
				//IE,搜狗浏览器的
				if(document.all){
					editorInstance.EditorDocument.attachEvent("onkeyup", editor_keyup); 
				}else{//火狐浏览器
					editorInstance.EditorDocument.addEventListener('keyup', editor_keyup,false) ;
				}
			}
			function getLength()
			{
				return $("#content").val().length;
			}
			function editor_keyup(e) 
			   { 
			    if(getLength()>0)
					$('#error_content').hide();
			    else
			    	$('#error_content').show();
			   }
			</script>-->
			</div>
			<span class="help-block" id="error_content" style="margin-left: 220px;"></span>
			</div>

			<div class="form-group">
			<label class="col-md-2 control-label">
			附件
			</label>
			<div class="col-md-10">
			<input id="uploadAttachments" name="uploadAttachments" value="" type="file" class="txtinput02 fl" />
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">配图</label>
			<div class="col-md-10">
			<input id="uploadPic" name="uploadPic" value="" type="file"  />
			<div class="img-thumbnail mt10">
			  	<img alt="700x260" src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>/${imgname}"
				title="${name}" alt="${name}" width="700" height="260"/>
			</div>
			</div>
			</div>
			
			<div class="panel-footer">
		    	<div class="row">
					<div class="col-md-offset-2 col-md-10">
						<button class="btn btn-primary"  type="submit" name="Submit32">
						<span  class="glyphicon glyphicon-ok"></span>&nbsp;保存
						</button>
						<button name="Submit32" type="button" onclick="review()" class="btn btn-primary" >
						<span class="glyphicon glyphicon-list-alt"></span>&nbsp;预览
						</button>
						<button id="incy" type="button" class="btn btn-default" onclick="window.location.href='article.action?isMy=${isMy}'">
						<span class="glyphicon glyphicon-remove" ></span>&nbsp;取消
						</button>
						<button id="chcy" type="button" style="display: none;" class="btn btn-default" onclick="gotohome();">
						<span class="glyphicon glyphicon-remove" ></span>&nbsp;取消
						</button>
					</div>
				</div>
			</div>
    		</form>
    	</div>
    <!--表单end-->
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