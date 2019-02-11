<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html> 
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线答疑管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>     


<script type="text/javascript" language="javascript">   
$(document).ready(function(){
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   

	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }
		   else{
		   $("input[name='ids']").removeAttr("checked");
			   } 
	   });
	
   $("#batchDelDown").click(
	   function(){
		   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/question/manage/onlinequestion!delete.action?objectId=${objectId}&type=${type}";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
   	   		});
	});
	
    $("#checkYesButton").click(
	   function(){
		   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/studycircle/manage/studycircle!check.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
  	   		});
	}); 
    $("#checkNoButton").click(
 		   function(){
 			   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/studycircle/manage/studycircle!nocheck.action";
 		       if(!checkSelect()) {
 		            b_alert("没有可操作记录,请勾选");
 		            return false;
 		       } 
 		      	b_confirm('您确定要进行此操作吗?', function() {
 					$("#deleteForm").submit();
 					document.getElementById("deleteForm").action = oaction;
 	  	   		});
 	}); 
 });  
function checkSelect() {
	var flag = false;
	$("input[name='ids']:checked").each(function(){
		flag = true;
	}); 
	return flag;
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
	<jsp:param value="studycirclemanage" name="menu" />
	<jsp:param value="studycircle" name="bigmenu" />
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
             <a href="#">在线答疑</a>
         </li>
       <li class="active"><span>在线答疑管理</span></li>
      </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>在线答疑管理<small>&nbsp;</small></h3>
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
   <div class="tab-content dr-tabs-panel">   
    <!--搜索模块-->
     <div class="dr-searchbar">
	   <form class="form-inline dr-form-inline"  id="mainForm" name="mainForm" action="onlinequestion.action?objectId=${objectId }" method="post">
	        <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	        <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	        <input type="hidden" name="page.order"	id="order" value="${page.order}" />
            
            <div class="form-group">
                <label>标题</label>
                <input style="width: 250px" name="title" type="text" placeholder="" class="form-control input-sm" value="${title }"/>
           	</div>
           <div class="form-group">
               	<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
           </div>
         
        </form>
		  </div>
    <!--搜索模块end-->
    
    	
    	<form name="deleteForm" id="deleteForm" action="article.action" method="post" class="form-inline dr-form-inline">
    		<div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
	            <div class="btn-group btn-group-sm">
					<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
	                	<span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
	                </button>
	            </div>
		    </div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="4%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
					<th width="15%" >标题</th>
					<th width="30%" >内容</th>
					<th width="10%" >创建者</th>
					<th width="10%" >创建时间</th>
					<th width="20%" >操作</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
				  <tr>
				  	 <td>
					   <input type="checkbox" name="ids" id="ids" value="${id}" />
					 </td>
					 <td title="${title}"><common:cut len="24" string="${title}" /></td>
					 <td title="${content}"><common:cut len="50" string="${content}" /></td>
					 <td>${createUser.name}</td>
					 <td>${createTimeStr }</td>
					 <td>
					 <a class="btn btn-primary btn-sm" type="button" href="${ctx }/question/manage/onlinequestion!answer.action?qid=${id}&objectId=${objectId}" target="_blank">
			             <span class="glyphicon glyphicon-edit"></span> 回复管理
			         </a>
					 <a class="btn btn-default btn-sm" type="button"  href="#" onclick="delRecord('onlinequestion!delete.action?ids=${id}&objectId=${objectId}');">
			             <span class="glyphicon glyphicon-trash"></span> 删除
			         </a>
					 </td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			
			<%@ include file="/common/turnpage.jsp"%>
			</div>
		</form>
		</div>
    <!--订单列表end-->
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