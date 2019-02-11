<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
 <head>
 <title>集考考场资源管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<script type="text/javascript">	
$(document).ready(function(){    
      	 
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
				   document.getElementById("deleteForm").action="${ctx }/focus/manage/focusresource!batchDelete.action";
			       if(!checkSelect()) {
			    	   b_alertx("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirmx('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
		   }); 	
		 
     });

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
     function isEditor(id){
     	var oaction = document.getElementById("deleteForm").action;
    	document.getElementById("deleteForm").action="${ctx }/focus/manage/focusresource!input.action?id="+id;
    	$("#deleteForm").submit();
   		document.getElementById("deleteForm").action = oaction;
    		/* $.ajax({
    	        type: "POST",
    	        url: "${ctx}/focus/manage/focusresource!isEditor.action",
    	        data: {
    	        	"id": id
    			},
    			dataType:"json" ,
    	        success: function(data) {
    				 if(data.value=="true"){
    					b_alertx("考场已经安排,不可以编辑");
			            return false;
    				 }else{
    					 var oaction = document.getElementById("deleteForm").action;
    					   document.getElementById("deleteForm").action="${ctx }/focus/manage/focusresource!input.action?id="+id;
    					   $("#deleteForm").submit();
   						 document.getElementById("deleteForm").action = oaction;
    			     } 
    	        }
    		}); */
    	}
</script>
  </head>
  <body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="focusresource" name="menu" />
	<jsp:param value="focus" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">集考考场资源管理</a></li>
     <li class="active">集考考场资源列表</li>
    </ol>
   <div class="dr-page-header">
     <h3>集考考场资源列表</h3>
   </div>
   <hr>
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
<form id="mainForm" name="mainForm" action="focusresource.action" class="form-inline dr-form-inline" method="post" enctype="multipart/form-data">
   <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
   <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
   <input type="hidden" name="page.order" id="order" value="${page.order}" />

   <!--
   <div class="form-group">
     <label>代码</label>
     <input class="form-control input-sm" type="text"  name="filter_LIKES_code" id="code" value="${param['filter_LIKES_code']}">
   </div>
   -->
  
</form>


<form name="deleteForm" id="deleteForm" action="focusresource.action" method="post">
<div class="panel panel-default">
      <div class="btn-toolbar dr-btn-toolbar">
    <span class="fl">
	    <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
        </button>
        <button class="btn btn-primary btn-sm" type="button"  name="Submit3" onclick="window.location='focusresource!input.action'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增资源
        </button>
        </span>
  </div>



  <table class="table table-bordered dr-table-bordered" style="font-size: 14px;">
   <thead>
    <tr>
      <td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall"/></td>
   	  <th width="30%" >考场名称</th>
   	  <th width="10%" >考场编码</th>
      <th width="30%" >考场地址</th>
      <th width="20%" >座位数量</th>
      <th width="20%">操作</th>
    </tr>
    </thead>
   <tbody>
    <s:iterator value="page.result" status="stat">
    <tr>
      <td><input type="checkbox" name="ids" value="${id}" /></td>
 	  <td>${resName}</td>
 	  <td>${code}</td>
      <td>${resAddress}</td>
      <td>${resCount}</td>
      <td>
      <a href="#" onclick="isEditor('${id}')" class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
      </td>
    </tr>
    </s:iterator> 
    </tbody>
  </table>
  <%@ include file="/common/turnpage.jsp"%> 
  
</div>
</form>
</div>
<!--dr-container-fluid结束-->
<!--footer start-->
<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="index" name="menu"/>
</jsp:include>    	
<!--footer over-->
</section>
</div><!--dr-wrapper结束-->

</body>
</html>