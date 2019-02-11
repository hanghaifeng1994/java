<%@ page contentType="text/html;charset=UTF-8"%>





<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<%
	request.setAttribute("noticeSyncInfoSystem",PropertyUtils.getPropertyWithConfigName("systemSwitch.properties","noticeSyncInfoSystem.open"));
%> 
<script type="text/javascript" language="javascript">
$(document).ready(function(){
	
	$.ajaxSetup({
		  async: false
	});
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
			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!delete.action?isMy=${isMy}";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       } 
		       b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	   	   		});
		       if(!confirm('您确定要进行此操作吗?')) return  false;

			  $("#deleteForm").submit();
			  document.getElementById("deleteForm").action = oaction;
		});
		
	 function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
 $("#batchPubDown").click(
		   function(){
			   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!pub.action?isMy=${isMy}";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       } 
		       b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	   	   		});
		       //if(!confirm('您确定要进行此操作吗?')) return  false;

			   //$("#deleteForm").submit();
			   //document.getElementById("deleteForm").action = oaction;
		}); 
	    $("#batchCancelPubDown").click(
	 		   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!cancelPub.action?isMy=${isMy}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		       b_confirm('您确定要进行此操作吗?', function() {
	 					$("#deleteForm").submit();
	 					document.getElementById("deleteForm").action = oaction;
	 	   	   		});
	 		       //if(!confirm('您确定要进行此操作吗?')) return  false;

	 			  // $("#deleteForm").submit();
	 			   //document.getElementById("deleteForm").action = oaction;
	 	}); 

	    $("#batchTopDown").click(
		   function(){
			   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!top.action?isMy=${isMy}";
		       if(!checkSelect()) {
		            b_alert("没有可操作记录,请勾选");
		            return false;
		       }
		       b_confirm('您确定要进行此操作吗?', function() {
					$("#deleteForm").submit();
					document.getElementById("deleteForm").action = oaction;
	   	   		}); 
		       //if(!confirm('您确定要进行此操作吗?')) return  false;

			   //$("#deleteForm").submit();
			  // document.getElementById("deleteForm").action = oaction;
		});
		
	    $("#batchCancelTopDown").click(
	 		   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!cancelTop.action?isMy=${isMy}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		      b_confirm('您确定要进行此操作吗?', function() {
	 					$("#deleteForm").submit();
	 					document.getElementById("deleteForm").action = oaction;
	 	   	   		});
	 		       //if(!confirm('您确定要进行此操作吗?')) return  false;

	 			  // $("#deleteForm").submit();
	 			  // document.getElementById("deleteForm").action = oaction;
	 		}); 

	    $("#batchImpDown").click(
	 		   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!imp.action?isMy=${isMy}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		      b_confirm('您确定要进行此操作吗?', function() {
	 					$("#deleteForm").submit();
	 					document.getElementById("deleteForm").action = oaction;
	 	   	   		});
	 		       //if(!confirm('您确定要进行此操作吗?')) return  false;

	 			   //$("#deleteForm").submit();
	 			   //document.getElementById("deleteForm").action = oaction;
	 		});
		
	    $("#batchCancelImpDown").click(
		 		   function(){
		 			   var oaction = document.getElementById("deleteForm").action;
		 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!cancelImp.action?isMy=${isMy}";
		 		       if(!checkSelect()) {
		 		            b_alert("没有可操作记录,请勾选");
		 		            return false;
		 		       } 
		 		      b_confirm('您确定要进行此操作吗?', function() {
		 					$("#deleteForm").submit();
		 					document.getElementById("deleteForm").action = oaction;
		 	   	   		});
		 		      // if(!confirm('您确定要进行此操作吗?')) return  false;

		 			  // $("#deleteForm").submit();
		 			   //document.getElementById("deleteForm").action = oaction;
		 		});	

	    $("#batchCancelSignup").click(
			   function(){
	 			   var oaction = document.getElementById("deleteForm").action;
	 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!cancelSignup.action?isMy=${isMy}";
	 		       if(!checkSelect()) {
	 		            b_alert("没有可操作记录,请勾选");
	 		            return false;
	 		       } 
	 		       b_confirm('您确定要进行此操作吗?', function() {
	 		    	   var noticeIds=null;
			    	   $("input[name='ids']:checked").each(function(){
					   	if(noticeIds==null)
								noticeIds = $(this).val();
							else noticeIds += "," + $(this).val();
						}) 
						b_IframeLevel("${ctx}/news/manage/notice!issued.action?isIssue=false&tabFlag=isMy&noticeIds="+noticeIds,550,400,function(){window.reload();});
	     			   document.getElementById("deleteForm").action = oaction;
	 	 	   		});
	 		});

	     $("#batchSignup").click(
	     		   function(){
	     			   var oaction = document.getElementById("deleteForm").action;

	     			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!signup.action?isMy=${isMy}";
	     		       if(!checkSelect()) {
	     		            b_alert("没有可操作记录,请勾选");
	     		            return false;
	     		       } 
	     		       b_confirm('您确定要进行此操作吗?', function() {
	     		    	   var noticeIds=null;
	    		    	   $("input[name='ids']:checked").each(function(){
	    				   	if(noticeIds==null)
	    							noticeIds = $(this).val();
	    						else noticeIds += "," + $(this).val();
	    					}) 
	    					b_IframeLevel("${ctx}/news/manage/notice!issued.action?isIssue=true&tabFlag=isMy&noticeIds="+noticeIds,550,400,function(){window.reload();});
	     					//$("#deleteForm").submit();
	     					//document.getElementById("deleteForm").action = oaction;
		     			    //$("#deleteForm").submit();
		     			   document.getElementById("deleteForm").action = oaction;
	     	 	   		});
	     		});
	    $("#batchsyncDown").click(
		 		   function(){
		 			   var oaction = document.getElementById("deleteForm").action;
		 			   var noticeSyncInfoSystem = ${noticeSyncInfoSystem};
		 			   document.getElementById("deleteForm").action="${ctx }/news/manage/notice!sync.action?isMy=${isMy}";
		 		       if(!checkSelect()) {
		 		            b_alert("没有可操作记录,请勾选");
		 		            return false;
		 		       } 
		 		       if(noticeSyncInfoSystem=='false') {
		 		    	  	b_alert("系统设置不允许同步到信息系统");
		 		    	  	return false;
			 		   }
		 		       b_confirm('您确定要进行此操作吗?', function() {
		 					$("#deleteForm").submit();
		 					document.getElementById("deleteForm").action = oaction;
		 	   	   		});
		 		     // if(!confirm('您确定要进行此操作吗?')) return  false;

		 			  //$("#deleteForm").submit();
		 			  //document.getElementById("deleteForm").action = oaction;
		 		}); 
		
 });
function noticedisplay(id){
	var type = 0;
	if($("#notice_display_"+id).attr("displaytype")=='nodisplay'){
		type = 1;
	}
	$.post("${ctx }/news/manage/notice!isdisplay.excsec?noticeDisplayId="+id+"&displaytype="+type+"&cuurentenantId=${cuurentenantId}",function(data) {
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
	<jsp:param value="notice" name="menu" />
	<jsp:param value="message" name="bigmenu" />
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
		<a href="#">信息发布管理</a>
		</li>
		<li class="active"><span>公告管理</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>公告管理<small>&nbsp;</small></h3>
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
    <s:if test="nowUser.tenantId==null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy&&!isTenant'>active</s:if><s:else></s:else>" ><a href="notice.action?isMy=true">大平台公告</a></li>
		 <li class="<s:if test='isMy&&isTenant'>active</s:if><s:else></s:else>"><a href="notice.action?isMy=true&isTenant=true">租户的公告</a></li>
    </ul>
    </s:if>
    <s:else>
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="notice.action?isMy=true">我的公告</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="noticetenant.action?isMy=false&issignup=true">下发的公告</a></li>
     </ul>
    </s:else>
    <div class="tab-content dr-tabs-panel">
        <!--表单模块-->
	    <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="notice.action" method="post">
	       <input type="hidden" name="page.pageNo" id="pageNo" value="1" /> 
		   <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
		   <input type="hidden" name="page.order" id="order" value="${page.order}" />
           <input type="hidden" name="isMy" id="isMy" value="${isMy}" />
           <input type="hidden" name="issignup" id="issignup" value="${issignup}" />
<s:if test="nowUser.tenantId==null">
<s:if test="!isMy">
  <div class="dr-searchbar">
	<div class="form-group">
  	<label>租户</label>
  	<s:select list="tenantLists" listKey="id" headerValue="--选择租户--" headerKey="" value="tenantId" listValue="name" theme="simple" 
	cssClass="form-control" name="tenantId"></s:select>
	</div>
	<div class="form-group">
		<button class="btn btn-default btn-sm" type="submit">
			<span class="glyphicon glyphicon-search"></span>
 			搜索
		</button>
	</div>
  </div>
  </s:if>
</s:if>
</form>
    <!--表单模块end-->
    

    <!--订单列表-->
    	
    		<form name="deleteForm" id="deleteForm" action="notice.action" method="post" class="form-inline dr-form-inline">
    		<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
    		<div class="panel panel-default">
    		<s:if test="isMy&&!isTenant">
			<div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group btn-group-sm">
		       	<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
                </button>
		        </div>
				<div class="btn-group btn-group-sm">
		       	<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="window.location='notice!input.action?isMy=${isMy}'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增公告
                </button>
		        </div>
		       
		        <c:if test="${noticeSyncInfoSystem}">  
			        <div class="btn-group btn-group-sm">
			        <button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchsyncDown">
			        <span class="glyphicon glyphicon-transfer"></span>&nbsp;同步
			        </button>
			        </div>		        
		        </c:if>
		        
		        <div class="btn-group btn-group-sm">
		        <button name="Submit2" class="btn btn-default btn-sm" type="button" id="batchCancelTopDown">
		        <span class="glyphicon glyphicon-hand-down"></span>&nbsp;取消置顶
		        </button>
		        
		        <button name="Submit2" class="btn btn-default btn-sm" type="button" id="batchCancelPubDown">
		        <span class="glyphicon glyphicon-bullhorn"></span>&nbsp;取消发布
         		</button>
		       
		        <button name="Submit2" class="btn btn-default btn-sm" type="button" id="batchCancelImpDown">
		        <span class="glyphicon glyphicon-star-empty"></span>&nbsp;取消重要公告
		        </button>
		        
		         <s:if test="nowUser.tenantId==null">
			        <button name="Submit2" class="btn btn-default btn-sm" type="button" id="batchCancelSignup">
			        	<span class="glyphicon glyphicon-hand-down"></span>&nbsp;取消下发
			        </button>
			        </s:if>
		        </div>
		        
		        <div class="btn-group btn-group-sm">
		        <button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchTopDown">
		        <span class="glyphicon glyphicon-hand-up"></span>&nbsp;置顶
      			</button>
		       
		        <button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchPubDown">
		        <span class="glyphicon glyphicon-bullhorn"></span>&nbsp;发布
		        </button>
		      
		        <button name="Submit2" class="btn btn-primary btn-sm" type="button" id="batchImpDown">
		        <span class="glyphicon glyphicon-star"></span>&nbsp;重要公告
		        </button>
		        
		        <s:if test="nowUser.tenantId==null">
			        <button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchSignup">
			        	<span class="glyphicon glyphicon-hand-up"></span>&nbsp;下发
			        </button>
			        </s:if>
		        </div>
				
		        <!--
		        <div class="btn-group">
		        <button name="Submit2" class="btn btn-primary btn-sm" type="button"  id="batchsyncDown">
		        <span class="glyphicon glyphicon-transfer"></span>&nbsp;同步
		        </button>
		        </div>
		        -->
		    </div>
		    </s:if>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
				    <s:if test="isMy&&!isTenant">
				     <td>
					 <input type="checkbox" id="checkboxall" />
					</td>
					</s:if>
					<th>标题</th>
					<th>来自于</th>
					<th>发布日期</th>
					<th>是否置顶</th>
					<th>是否发布</th>
					<th>是否重要</th>
					<s:if test="nowUser.tenantId==null">
					<th width="8%" >是否下发</th>
					</s:if>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="page.result" status="stat">
					<tr>
					    <s:if test="isMy&&!isTenant"> 
						<td class="white_bg">
						  <input type="checkbox" name="ids" id="ids" value="${id}" />
						</td>
						</s:if>
						<td title="${title}" class="white_bg"><common:cut len="30" string="${title}" /></td>
						
						<td title="${tenantName}" class="white_bg">${tenantName}  </td>
						<td class="white_bg"><s:date name="createTime" format="yyyy.MM.dd" /></td>	
						<td title="${topStr}" class="white_bg"><common:cut len="30" string="${topStr}" /></td>
						<td title="${publishStr}" class="white_bg"><common:cut len="30" string="${publishStr}" /></td>
						<td title="${importantStr}" class="white_bg"><common:cut len="30" string="${importantStr}" /></td>
						<s:if test="nowUser.tenantId==null">
					       <td><s:if test="issignup">已下发</s:if> <s:else>未下发</s:else></td>
					    </s:if>
						<td class="white_bg">
						<s:if test="isMy&&!isTenant">
						  <a class="btn btn-primary btn-sm" type="button"  href="${ctx }/news/manage/notice!input.action?id=${id}&isMy=${isMy}">
						  <span class="glyphicon glyphicon-edit"></span>
						   &nbsp;编辑
						   </a>
						   <a class="btn btn-default btn-sm" type="button" href="#" onclick="delRecord('notice!delete.action?ids=${id}&isMy=${isMy}');">
						   <span class="glyphicon glyphicon-trash"></span>
						     删除
						   </a>
						</s:if> 
						 <s:if test="nowUser.tenantId!=null">
							<s:if test="issignup">
								<c:if test="${!display}">
								 <a class="btn btn-default btn-sm" type="button" id="notice_display_${id}" displaytype="nodisplay" onclick="noticedisplay(${id});">
								  <span class="glyphicon glyphicon-edit"></span>
								   &nbsp;隐藏
								   </a> 
								</c:if>
								<c:if test="${display}">
								 <a class="btn btn-primary btn-sm" type="button" id="notice_display_${id}" displaytype="display" onclick="noticedisplay(${id});">
								  <span class="glyphicon glyphicon-trash"></span>
								   &nbsp;显示
								   </a>
								</c:if>
							</s:if>
						 </s:if>
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