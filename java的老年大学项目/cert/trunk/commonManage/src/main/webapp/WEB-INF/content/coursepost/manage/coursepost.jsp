<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>课程点评管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
 <%@ include file="/common/admin_meta.jsp" %>
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

	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/coursepost/manage/coursepost!delete.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			      // if(!confirm('您确定要进行此操作吗?')) return  false;
	
				 //  $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
			 }); 	


	   $("#display").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/coursepost/manage/coursepost!display.action";
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
				 //  document.getElementById("deleteForm").action = oaction;
			 }); 


	   $("#undisplay").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/coursepost/manage/coursepost!undisplay.action";
			       if(!checkSelect()) {
			    	   b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });

			       
			     //  if(!confirm('您确定要进行此操作吗?')) return  false;
	
				//   $("#deleteForm").submit();
				 //  document.getElementById("deleteForm").action = oaction;
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
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="coursepostlist" name="menu" />
	<jsp:param value="coursepost" name="bigmenu" />
    </jsp:include>

  <section id="main" role="main"> 
  <div class="dr-container-fluid">

  <ol class="dr-breadcrumb">
    <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a> </li>
    <s:if test="#request.isqlxx=='true'">
    	  <li><a href="#">课程学习评价管理</a></li>
    </s:if>
    <s:else>
  		  <li><a href="#">课程点评管理</a></li>
    </s:else>
    <li class="active">课程点评管理</li>
  </ol>
      <div class="dr-page-header">
     <h3>课程点评管理</h3>
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


    <s:if test="nowUser.tenantId==null">
      <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="coursepost.action?isMy=true">我的课程点评</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="coursepost.action?isMy=false">其他租户课程点评</a></li>
     </ul>
    </s:if>
     <div class="tab-content dr-tabs-panel">  
<!--信息提示 end-->

<div class="dr-searchbar">  
<form id="mainForm" name="mainForm" action="coursepost.action" method="post" class="form-inline dr-form-inline">
  <input type="hidden" name="page.pageNo" id="pageNo" value="1" /> 
  <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
  <input type="hidden" name="page.order" id="order" value="${page.order}" />
  <input type="hidden" name="isMy" id="isMy" value="${isMy}" />
  
   <div class="form-group">
      <label>课程名称</label>
      <input class="form-control input-sm" type="text" name="filter_LIKES_course$name" value="${param['filter_LIKES_course$name']}" />
   </div>  
  
   <div class="form-group">
      <label>评论人姓名和单位</label>
      <input class="form-control input-sm" type="text" name="filter_LIKES_name" value="${param['filter_LIKES_name']}" />
   </div>  
  
   <div class="form-group">
      <label>内容</label>
      <input class="form-control input-sm" type="text" name="filter_LIKES_content" value="${param['filter_LIKES_content']}" />
   </div> 
   <div class="form-group">
                <label>状态</label>
                <s:select list="#{'待审核':'0','审核通过':'1','审核不通过':'2'}"
			    listKey="value" value="(#parameters.filter_EQI_display)" name="filter_EQI_display" listValue="key" headerKey=""
			    headerValue="全部" theme="simple" cssClass="form-control input-sm" cssStyle="width:117px">
			    </s:select>
    </div>
       <s:if test="nowUser.tenantId==null">
               <s:if test="!isMy">
               <div class="form-group">
			  	<label>租户</label>
			  	<s:select list="tenantLists" listKey="id" onchange="changeOneCat(this)"
				value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
				headerKey="" cssClass="form-control" name="tenantId"></s:select>
			  </div>
			  </s:if>

            </s:if>

   <button onclick="$('#pageNo').val('1');document.mainForm.submit();" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-search"></span>&nbsp;搜索
   </button>

</form>
</div>

<form name="deleteForm" id="deleteForm"action="coursepost.action" method="post">
<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
  <div class="panel panel-default">
  <s:if test="isMy">
     <div class="btn-toolbar dr-btn-toolbar">
       	<button name="Submit2" type="button" class="btn btn-default btn-sm"id="batchDelDown" > 
		  <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
		</button>
	    <button name="Submit3" type="button"
		  class="btn btn-primary btn-sm" id="display" >
		  <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;审核通过
		</button> 
	     <button name="Submit3" type="button" 
		class="btn btn-default btn-sm" id="undisplay" >
		<span class="glyphicon glyphicon-thumbs-down"></span>&nbsp;审核不通过
		</button>
     </div>
</s:if>

<table class="table table-bordered dr-table-bordered">
	<thead>
	   <tr>
	    <s:if test="isMy">
		<th width="3%"><input type="checkbox" id="checkboxall" /></th>
		</s:if>
		<th  width="5%">评价</th>
		<th>评论内容</th>
		<th width="15%">课程名称</th>
		<th width="9%">评论日期</th>
		<th width="15%">评论人</th>
		<th width="9%">审核状态</th>
		<s:if test="nowUser.super"><th width="15%">来自</th></s:if>
		<th width="14%">操作</th>
	   </tr>
	 </thead>
	 <tbody>
	<s:iterator value="page.result" status="stat">
	<tr>   
	        <s:if test="isMy">
			<td >
			  <input type="checkbox" name="ids" value="${id}" />
			</td>
			</s:if>
			<td>${star}星</td>
			<td >${content}</td>
			<td >${courseName}</td>
			<td ><s:date name="postdate" format="yyyy.MM.dd" /></td>
			<td >&nbsp;${commentUser.name},${commentUser.unit}</td>
			<td >&nbsp;${displayStr}</td>
			<s:if test="nowUser.tenantId==null"><td>${tenantName}</td></s:if>
			<td >
			   <s:if test="isMy">
				<a href="${ctx}/coursepost/manage/coursepost!input.action?id=${id}" target="_blank" type="button" class="btn btn-primary btn-sm">
                    <span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a>
				 <button class="btn btn-default btn-sm" type="button" name="Submit2" onclick="delRecord('${ctx }/coursepost/manage/coursepost!delete.action?ids=${id}');">
                  <span class="glyphicon glyphicon-trash"></span>
                                                删除
                </button>
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
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</section>
</div>
</body>
</html>