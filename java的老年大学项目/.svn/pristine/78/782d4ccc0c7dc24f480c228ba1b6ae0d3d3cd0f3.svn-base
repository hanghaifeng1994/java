<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html> 
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息内容管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js" type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>     


<script type="text/javascript" language="javascript">   
$(document).ready(function(){
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   

    $("#filter_GED_pubTime").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	}); 
    $("#filter_LED_pubTime").datetimepicker({
		 format: 'yyyy-mm-dd',
		 language:'zh-CN',
		 weekStart: 1,
		 autoclose: 1,
		 todayHighlight: 1,
		 startView: 2,
		 minView: 2,
		 forceParse: 0,
	 }); 
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
		   document.getElementById("deleteForm").action="${ctx }/news/manage/article!delete.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
   	   		});
	});
	
    $("#batchRecommendDown").click(
	   function(){
		   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/news/manage/article!recommend.action?isMy=${isMy}";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
  	   		});
	}); 
    $("#batchCancelRecommendDown").click(
 		   function(){
 			   var oaction = document.getElementById("deleteForm").action;
 			   document.getElementById("deleteForm").action="${ctx }/news/manage/article!cancelRecommend.action?isMy=${isMy}";
 		       if(!checkSelect()) {
 		            b_alert("没有可操作记录,请勾选");
 		            return false;
 		       } 
 		      	b_confirm('您确定要进行此操作吗?', function() {
 					$("#deleteForm").submit();
 					document.getElementById("deleteForm").action = oaction;
 	  	   		});
 	}); 

    $("#batchPubDown").click(
		   function(){
			   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/news/manage/articletenant!pub.action?isMy=${isMy}&issignup=${issignup}";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       } 
		       b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	  	   		});
		}); 
	    $("#batchCancelPubDown").click(
	 		   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/articletenant!cancelPub.action?isMy=${isMy}&issignup=${issignup}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		      	b_confirm('您确定要进行此操作吗?', function() {
	 					$("#deleteForm").submit();
	 					document.getElementById("deleteForm").action = oaction;
	 	  	   		});
 	}); 

    $("#batchTopDown").click(
	   function(){
		   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/news/manage/article!top.action?isMy=${isMy}";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
 	   		});
	});
	
    $("#batchCancelTopDown").click(
 		   function(){
 			   var oaction = document.getElementById("deleteForm").action;
 			   document.getElementById("deleteForm").action="${ctx }/news/manage/article!cancelTop.action?isMy=${isMy}";
 		       if(!checkSelect()) {
 		            b_alert("没有可操作记录,请勾选");
 		            return false;
 		       } 
 		      b_confirm('您确定要进行此操作吗?', function() {
 					$("#deleteForm").submit();
 					document.getElementById("deleteForm").action = oaction;
 	  	   		});
 		}); 		

    $("#batchCancelSignup").click(
  		   function(){
  			   var oaction = document.getElementById("deleteForm").action;
  			   document.getElementById("deleteForm").action="${ctx }/news/manage/article!cancelSignup.action?isMy=${isMy}";
  		       if(!checkSelect()) {
  		            b_alert("没有可操作记录,请勾选");
  		            return false;
  		       } 
  		      b_confirm('您确定要进行此操作吗?', function() {
  					$("#deleteForm").submit();
  					document.getElementById("deleteForm").action = oaction;
  	  	   		});
  		}); 


    $("#batchSignup").click(
    		   function(){
    			   var oaction = document.getElementById("deleteForm").action;
    			   document.getElementById("deleteForm").action="${ctx }/news/manage/article!Signup.action?isMy=${isMy}";
    		       if(!checkSelect()) {
    		            b_alert("没有可操作记录,请勾选");
    		            return false;
    		       } 
    		       b_confirm('您确定要进行此操作吗?', function() {
    					$("#deleteForm").submit();
    					document.getElementById("deleteForm").action = oaction;
    	 	   		});
    		});
    $("#batchsyncDown").click(
	 		   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/article!sync.action?isMy=${isMy}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		      b_confirm('您确定要进行此操作吗?', function() {
	 					$("#deleteForm").submit();
	 					document.getElementById("deleteForm").action = oaction;
	 	  	   		});
	 		}); 	
    $("#articleonecategory").bind("change",function() {
		var catid = $(this).val();
		var tenantId = $('#tenantId').val();
		if(catid) {
			$.get("${ctx}/related/articlecategory!categories.action", {catid:$(this).val(),tenantid:tenantId}, function (data){
				$("#articletwocategory option[value!='']").remove();
				$("#articlethreecategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#articletwocategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#articletwocategory option[value!='']").remove();
			$("#articlethreecategory option[value!='']").remove();
		}
		$("#onecat").val(catid);
	});
	
	
	//chenbo 2012/8/18
	$("#articletwocategory").bind("change",function() {
		var catid = $(this).val();
		var tenantId = $('#tenantId').val();
		if(catid) {
			$.get("${ctx}/related/articlecategory!categories.action", {catid:$(this).val(),tenantid:tenantId}, function (data){
				$("#articlethreecategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#articlethreecategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#articlethreecategory option[value!='']").remove();
		}
		$("#twocat").val(catid);
	});
	
	//chenbo 2012/8/18
	$("#articlethreecategory").bind("change",function() {
		var catid = $(this).val();
		
		$("#threecat").val(catid);
	});		
	   
 });  
function checkSelect() {
	var flag = false;
	$("input[name='ids']:checked").each(function(){
		flag = true;
	}); 
	return flag;
}

function changeOneCat(obj){
	var tenantid = $(obj).val();
	//根据一级栏目获得二级栏目
		if(tenantid) {
			$.post("${ctx}/news/manage/article!getOneCat.excsec",{"tenantId":tenantid},function(data) {
				$("#articleonecategory option[value!='']").remove();
				var category = eval(data);
				$("#articleonecategory option[value!='']").remove(); 
				if(category.length == 0) return;
				for(var i = 0 ;i < category.length ; i++) {
					$("#articleonecategory").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
				} 
				$("#articletwocategory option[value!='']").remove();
				$("#articlethreecategory option[value!='']").remove();
			});
		}else {
			$("#articleonecategory option[value!='']").remove(); 
			$("#articletwocategory option[value!='']").remove();
			$("#articlethreecategory option[value!='']").remove();
		}
}
function noticedisplay(id){
	var type = 0;
	if($("#notice_display_"+id).attr("displaytype")=='nodisplay'){
		type = 1;
	}
	$.post("${ctx }/news/manage/article!isdisplay.excsec?articleDisplayId="+id+"&displaytype="+type+"&cuurentenantId=${cuurentenantId}",function(data) {
		if(data.value == 'true'){
			if($("#notice_display_"+id).attr("displaytype")=='nodisplay'){
				$("#notice_display_"+id).removeClass('btn-default');
				$("#notice_display_"+id).addClass('btn-primary');
				$("#notice_display_"+id).attr("displaytype","display");
				$("#notice_display_"+id).html('  <span class="glyphicon glyphicon-trash"></span>&nbsp显示');
			}else{
				$("#notice_display_"+id).removeClass('btn-primary');
				$("#notice_display_"+id).addClass('btn-default');
				$("#notice_display_"+id).attr("displaytype","nodisplay");
				$("#notice_display_"+id).html(' <span class="glyphicon glyphicon-edit"></span>&nbsp;隐藏');
			}
		}else{
			alert(data.label);
		}
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
	<jsp:param value="article" name="menu" />
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
       <li class="active"><span>信息内容管理</span></li>
      </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>信息内容管理<small>&nbsp;</small></h3>
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
          <ul class="nav nav-tabs nav-justified">
			     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="article.action?isMy=true">我的信息</a></li>
		         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="articletenant.action?isMy=false&issignup=true">下发的信息</a></li>
  		 </ul>
     <div class="tab-content dr-tabs-panel">   
    <!--搜索模块-->
     <div class="dr-searchbar">
	   <form class="form-inline dr-form-inline"  id="mainForm" name="mainForm" action="articletenant.action" method="post">
	        <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	        <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	        <input type="hidden" name="page.order"	id="order" value="${page.order}" />
            <input type="hidden" name="isMy" id="isMy" value="${isMy}" />
            <input type="hidden" name="issignup" id="issignup" value="${issignup}" />
             
             <div class="form-group">
                <label>发布状态</label>
                <s:select list="#{'已发布':'true','未发布':'false'}"
			    listKey="value" value="display" name="display" listValue="key" headerKey=""
			    headerValue="全部" theme="simple" cssClass="form-control input-sm" cssStyle="width:117px">
			    </s:select>
               </div>
              <div class="form-group">
                <label>图片新闻</label>
                <s:select list="#{'是':'true','否':'false'}" listKey="value" value="hasimg"
                 name="hasimg" listValue="key" headerKey="" headerValue="全部" theme="simple" 
                 cssClass="form-control input-sm" cssStyle="width:117px">
			    </s:select> 
              </div>
              <div class="form-group">
                 <label>首页推荐</label>
                 <s:select list="#{'是':'true','否':'false'}" listKey="value" value="recommend" name="recommend" 
                 listValue="key" headerKey="" headerValue="全部" theme="simple" cssClass="form-control input-sm" cssStyle="width:117px">
                 </s:select>
             </div>
            <div class="form-group">
                <label>标题</label>
                <input style="width: 118px" name="title" type="text" placeholder="" class="form-control input-sm" value="${title}"/>
           </div>
            <div class="form-group">
               	<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
           </div>
         
        </form>
		  </div>
    <!--搜索模块end-->
    <!--订单列表-->
    		<form name="deleteForm" id="deleteForm" action="articletenant.action" method="post" class="form-inline dr-form-inline">
    		 <input type="hidden" name="isMy" id="isMy" value="${isMy}" />
    		<div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
	      		<div class="btn-group btn-group-sm">
	      			<button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchPubDown">
			        	<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;发布
	      			</button>
	      	    </div>
	            <div class="btn-group btn-group-sm">
	       			<button name="Submit2" class="btn btn-default btn-sm" type="button" id="batchCancelPubDown">
			        	<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;取消发布
	         		</button>
	       		</div>
		    </div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="4%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
					<th width="15%" >资讯标题</th>
					<th width="5%" >来自于</th>
					<th width="10%" >所属一级分类</th>
					<th width="10%" >所属下级分类</th>
					<th width="7%" >发布日期</th>
					<th width="8%" >图片新闻</th>
					<th width="5%" >推荐</th>
					<th width="6%" >置顶</th>
					<th width="8%" >发布状态</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
				  <tr>
				      <td>
					   <input type="checkbox" name="ids" id="ids" value="${id}" />
					 </td>
					 <td title="${article.title}"><common:cut len="24" string="${article.title}" /></td>
					 <td title="${article.tenantName}">${article.tenantName}</td>
					 <td>${article.firstCatname}</td>
					 <td>${article.catname}</td>
					 <td><s:date name="article.pubTime" format="yyyy.MM.dd" /></td>
					 <td>
					 <s:if test="article.hasimg"><a target="_blank" href="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>/${article.imgname}">图片</a></s:if>
					 <s:else>--</s:else>
					 </td>
					 <td><s:if test="article.recommend">是</s:if> <s:else>否</s:else></td>
					 <td><s:if test="article.zhiding">是</s:if> <s:else>否</s:else></td>
					 <td><s:if test="display">已发布</s:if> <s:else>未发布</s:else></td>
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