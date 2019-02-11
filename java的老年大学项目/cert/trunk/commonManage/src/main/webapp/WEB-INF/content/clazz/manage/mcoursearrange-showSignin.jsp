<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>签到管理-班级课程-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<link href="${staticurl}/wx_js/css/jquery.dataTables.min.css" rel="stylesheet"/>
<script src="${staticurl}/wx_js/js/jquery.dataTables.min.js"></script>
<%
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
%> 
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>


<script>  
$(document).ready(function(){
    //信息提示  
	if($("#success").text()!="")$("#div-success").show();
	if($("#error").text()!="")$("#div-error").show();

	//$('#theTable').DataTable({
	//	scrollY: 250,
	//	scrollX: true,
	//	autoWidth: false,
	//	paging: false,
	//	searching: false,
	//	ordering: false,
	//	info: false
	//});
	
	  $("#handsign").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/mcoursearrange!saveSignin.action";
			     //  if(!checkSelect()) {
			    //	   b_alert("没有可操作记录,请勾选");
			     //       return false;
			    //   } 
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
};
</script>
</head>

<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
   <div class="dr-page-header">
     <h3>班级课程-签到列表</h3>
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
           课程"${course1.name}"签到列表
    </h3>

  </div><!--
  
  <div class="dr-searchbar" style="margin:5px 5px 5px 5px;">  
<form id="mainForm" name="mainForm" action="mcoursearrange!showSignin.action" method="post" class="form-inline dr-form-inline" >
  <input type="hidden" name="page.pageNo" id="pageNo" value="1" /> 
  <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
  <input type="hidden" name="page.order" id="order" value="${page.order}" />
   <input type="hidden" name="clazzid" value="${clazzid}"/>
 <input type="hidden" name="courseid" value="${courseid}"/>
  
  
   <div class="form-group">
      <label>姓名</label>
      <input class="form-control input-sm" type="text" name="filter_LIKES_name" value="${param['filter_LIKES_name']}" />
   </div>  
  
   <div class="form-group">
      <label>上课开始时间</label>
      <input class="form-control input-sm" type="text" name="filter_LED_startDate" value="${param['filter_LED_startDate']}" />
   </div>  
   
      <div class="form-group">
      <label>上课结束时间</label>
      <input class="form-control input-sm" type="text" name="filter_GED_endDate" value="${param['filter_GED_endDate']}" />
   </div> 
   <button type="submit" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-search"></span>&nbsp;搜索
   </button>

</form>
</div>
  
  
  
  
  --><form name="deleteForm" id="deleteForm" action="mcoursearrange!showSignin.action" method="post">
     <input type="hidden" name="clazzid" value="${clazzid}"/>
 <input type="hidden" name="courseid" value="${courseid}"/>
 
     <div class="btn-toolbar dr-btn-toolbar">
      	 
      <button name="Submit2" type="button" class="btn btn-primary" id="handsign" >
		<span class="glyphicon glyphicon-ok mr5"></span>&nbsp;保存签到
	  </button>

    </div>
 <div class="panel panel-default  mt10 mb10" style="overflow-x:auto;overflow-y:auto;width:100%;">
<table   class="table table-bordered dr-table-bordered" style="table-layout:fixed;" > 
  <tbody>
        
     <tr>    
      <th width="80px;">姓名/时间</th>
       <s:iterator value="arrangeSchedules"  status="stat2" >
         <th width="100px;"><s:property value="strDate"></s:property></th>
       
       </s:iterator>
     </tr>
     
      <s:iterator value="showsigninmap12" status="stat" id="entry">
          <tr>
          <td width="80px;"><s:property value="#entry.key"></s:property></td>
             <s:iterator value="#entry.value" status="stat1" id="entry1">
               
          	   <td width="100px;">
          	    <s:if test="#entry1.value==true">
          	        <input type="checkbox" name="ids" checked="checked" value=<s:property value="#entry1.key"/>></input>
          	    </s:if>
          	    <s:else>
          	     <input type="checkbox" name="ids" value=<s:property value="#entry1.key"/>></input><!--
          	     <s:property value="#entry1.key"/>
          	    --></s:else>
          	 
          	   </td>
             </s:iterator> 
          </tr> 
      </s:iterator>  
 </tbody>
</table>

</div>
</form>

</div>

</div>

</section>
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</body>
</html>
