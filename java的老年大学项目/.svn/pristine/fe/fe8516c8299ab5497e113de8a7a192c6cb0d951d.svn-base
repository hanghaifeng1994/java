<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<html>
<head>
<title>证书头像审核-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script  type="text/javascript"  src="${ctx}/js/LodopFuncs.js?v=1.2">${ctx}</script>
<script  type="text/javascript"  src="${ctx}/js/certprint.js?v=1.2"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="${ctx}/js/install_lodop64.exe"></embed>
</object>
<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
<script type="text/javascript">
    $(document).ready(function(){
	   $("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
	   });	
   	   
   	   $("#checked").click(function(){
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!checked.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#unchecked").click(function(){
   	   	   var oaction = document.getElementById("deleteForm").action;
		   document.getElementById("deleteForm").action="${ctx }/cert/manage/usercert!unchecked.action";
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return false;
	       } 
    	   b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction; 
			}); 
   	   });
   	   
   	   $("#genTime01").datetimepicker({
	    	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
		}); 
	   $("#genTime02").datetimepicker({
		   	 customFormat: "yyyy-mm-dd",
			 format: "yyyy-mm-dd",
			 language:'zh-CN',
			 weekStart: 1,
			 autoclose: 1,
			 todayHighlight: 1,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
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
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="piccheck" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
  <!--adminLeft结束-->
   
    <section id="main" role="main"> 
    <div class="dr-container-fluid">
	<ol class="dr-breadcrumb">
		<li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
		<li><a href="#" class="grey">培训项目管理</a></li>
		<li class="active">证书头像审核</li>
	</ol>
   <div class="dr-page-header">
     <h3>证书头像审核 </h3>
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

<form id="mainForm" name="mainForm"	action="${ctx}/cert/manage/usercert!picCheck.action" method="post" class="form-inline dr-form-inline" >
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
<input type="hidden" id="ctx" value="${ctx}"/>
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="${export }" id="export"/>
<input type="hidden" name="exportExcel" value="${exportExcel }" id="exportExcel"/>
<input type="hidden" name="usercertids" id="usercertids" value=""/>

					<div class="form-group">
						<label class="control-label"> 生成时间 </label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime01">
							<input type="text" value="${param['filter_GED_genTime']}" name="filter_GED_genTime" id="filter_GED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">-</label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime02">
							<input type="text" value="${param['filter_LED_genTime']}" name="filter_LED_genTime" id="filter_LED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					
<div class="form-group">
	<label>证书名</label>
	<input name="filter_LIKES_name" class="form-control input-sm"  value="${param['filter_LIKES_name']}"/>
</div>
<div class="form-group">
	<label>项目</label>
	<input name="filter_LIKES_trainingPrograms$name" class="form-control input-sm" style="width: 150px;" value="${param['filter_LIKES_trainingPrograms$name']}" />
</div>
<div class="form-group">
	<label>用户名</label>
	<input name="filter_LIKES_username" class="form-control input-sm"  value="${param['filter_LIKES_username']}"/>
</div>

<div class="form-group">
	<label>姓名</label>
	<input name="userNick" class="form-control input-sm" value="${param['userNick']}"/>
</div>		
<div class="form-group">
	<label>审核状态</label>
	<s:select list="#{'未审核':'0','审核通过':'1','审核不通过':'2'}" listKey="value" value="(#parameters.filter_EQI_checked)"
			name="filter_EQI_checked" listValue="key" headerKey=""
			headerValue="全部" theme="simple" cssClass="form-control input-sm"></s:select>
</div>
<div class="form-group">
<button name="Submit5"  onclick="$('#pageNo').val('1');document.mainForm.submit();" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
</div>
<input type="hidden" id="onecat" name="onecat" value="${onecat }" />
<input type="hidden" id="twocat" name="twocat" value="${twocat }" />
<input type="hidden" id="threecat" name="threecat" value="${ threecat}"/>
</div>
</form>


<form name="deleteForm" id="deleteForm" action="usercert!checked.action"	method="post">
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<div class="btn-group">
<button name="Submit22"  type="button" class="btn btn-primary btn-sm" id="checked"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量审核通过</button>
</div>
<div class="btn-group">
<button name="Submit22"  type="button" class="btn btn-primary btn-sm" id="unchecked"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;批量审核不通过</button>
</div>
</div>
<!-- 
<input name="Submit3" type="button" class="operation_btu1" value="发布课程" id="batchpublicDown" /> 
<input name="Submit3" type="button"	class="operation_btu2" value="取消发布" id="batchUnpublicDown" />
-->

<table class="table table-bordered dr-table-bordered">
    <thead>
	<tr>
		<th width="3%"  ><input type="checkbox" id="checkboxall"/></th>
		<th width="18%" >证书名称</th>
		<th width="15%" >证书号</th>		
		<th width="15%" >用户名</th>
		<th width="10%"  >姓名</th>		
		<th width="10%"  >用户图像</th>
		<th width="10%"  >审核状态</th>
		<th width="12%" >操作</th>		
	</tr></thead>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids" value="${id}"/></td>
			<td title="${name}">
			<common:cut len="30" string="${name}"/>
			</td>
			<td>${certno}</td>				
			<td>${username}</td>
			<td>${realName}</td>			
			<td>
				<img width=90 height=90 src="<common:prop name="traincore.uploadpath.url" propfilename=""></common:prop>${user.avatarWithDefault}" />
			</td>
			<td>${checkedStr}</td>
			<td>
			<div class="btn-group">
               <button class="btn btn-default btn-sm" type="button" id="oper_${id}" style="padding: 5px 8px;">
               		审核
              </button>
              <button data-toggle="dropdown" class="btn btn-default btn-sm dropdown-toggle" type="button" style="height: 30px;padding: 5px">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
              </button>
              <ul role="menu" class="dropdown-menu">
              	<li>
              	<a href="usercert!checked.action?ids=${id }">审核通过</a>
              	</li>
              	<li>
              	<a href="usercert!unchecked.action?ids=${id }">审核不通过</a>
              	</li>
              </ul>
            </div>
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include	file="/common/turnpage.jsp"%>
</div>
</form>

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