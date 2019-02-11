<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
 <head>
 <title>学习卡管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
 <%@ include file="/common/admin_meta.jsp" %>
 <link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script type="text/javascript">	
$(document).ready(function(){    
      	 
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   
		 
   //$("#checkboxall").click(function(){
	     
     //   if($("#checkboxall").attr("checked")=="checked"){
      //  	$("input[name='ids']").attr("checked",$(this).attr("checked"));
      //  }else {
       //   $("input[name='ids']").removeAttr("checked");
       //  }
//   });
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
	   $("#genTime03").datetimepicker({
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
	   $("#genTime04").datetimepicker({
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
       //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/lcard/manage/lcard!batchDelete.action";
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

</script>
  </head>
  <body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="lcardlist" name="menu" />
	<jsp:param value="lcard" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">学习卡管理</a></li>
     <li class="active">学习卡列表</li>
    </ol>
   <div class="dr-page-header">
     <h3>学习卡列表</h3>
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
<form id="mainForm" name="mainForm" action="lcard.action" class="form-inline dr-form-inline" method="post" enctype="multipart/form-data">
   <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
   <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
   <input type="hidden" name="page.order" id="order" value="${page.order}" />
   <div class="form-group">
						<label class="control-label"> 创建日期</label>
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
						<label class="control-label"> 有效期</label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime03">
							<input type="text" value="${param['filter_GED_genTime']}" name="filter_GED_genTime" id="filter_GED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">-</label>
					</div>
					<div class="form-group" style="width:250px;">
						<div class="input-group date" id="genTime04">
							<input type="text" value="${param['filter_LED_genTime']}" name="filter_LED_genTime" id="filter_LED_genTime" readonly="readonly" class="form-control input-sm" style="width:100%;" /> <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span>
							</span> <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span>
							</span>
						</div>
					</div>
   <div class="form-group">
				<label>卡号</label>
                <input name="cardNumber" class="form-control input-sm" value="${param['cardNumber']}" />
			</div>
   <div class="form-group">
				<label>发布状态</label>
                <s:select name="filter_EQB_publish" cssClass="form-control input-sm" list="#{'--全部--':'','发布':'True','未发布':'False'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_publish">
		        </s:select>
			</div>
   <div class="form-group">
                <button class="btn btn-default btn-sm" >
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
                 <button class="btn btn-primary btn-sm" type="button"  name="Submit4" >
                 <span class="glyphicon glyphicon-plus"></span>
                                            批量发布
                </button>
            </div>
  
</form>


<form name="deleteForm" id="deleteForm" action="lcard.action" method="post">
<div class="panel panel-default">
      <div class="btn-toolbar dr-btn-toolbar">
    <span class="fl">
	    <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
        </button>
        <button class="btn btn-primary btn-sm" type="button"  name="Submit3" onclick="window.location='lcard!input.action'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增学习卡
        </button>
        </span>
  </div>



  <table class="table table-bordered dr-table-bordered" style="font-size: 14px;">
   <thead>
    <tr>
      <td width="2%" class="tt_noline"><input type="checkbox" id="checkboxall"/></td>
      
      <th width="15%" >卡号</th>
      <th width="10%" >面值</th>
      <th width="15%" >创建日期</th>
      <th width="10%" >序号</th>
      <th width="10%" >是否发布</th>
      <th width="10%" >是否已用</th>
      <th width="13%" >有效期</th>
      <th width="12%">操作</th>
    </tr>
    </thead>
   <tbody>
    <s:iterator value="page.result" status="stat">
    <tr>
      <td><input type="checkbox" name="ids" value="${id}" /></td>
      
      <td>${cardNumber}</td>
      <td>${facePrice}</td>
      <td>&nbsp;<s:date name="curDate"  format="yyyy.MM.dd"/></td>	
      <td>${orderNumber}</td>
      <td><s:if test="publish">是</s:if> <s:else>否</s:else></td>
      <td><s:if test="userd">是</s:if> <s:else>否</s:else></td>
      <td>&nbsp;<s:date name="passDate"  format="yyyy.MM.dd"/></td>
      <td>
      <a href="${ctx}/lcard/manage/lcard!input.action?id=${id}" class="btn btn-primary btn-sm">
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
<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</section>
</div><!--dr-wrapper结束-->
	    	
</body>
</html>