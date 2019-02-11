<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/admin_meta.jsp" %>
<html>
<head>

<title>权威师资推荐<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if></title>
<script type="text/javascript">
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
	 //验证批量删除文章的列表非空与否
	   $("#batchrecommendFormDown").click(
		  		   function(){
		  			   var oaction = document.getElementById("deleteForm").action;
		  			   document.getElementById("deleteForm").action="${ctx }/teacherrecommend/manage/teacherrecommend!recommend.action";
		  		       if(!checkSelect()) {
		  		            b_alert("没有可操作记录,请勾选");
		  		            return false;
		  		       } 
		  		      b_confirm('您确定要进行此操作吗?', function() {
		  					$("#deleteForm").submit();
		  					document.getElementById("deleteForm").action = oaction;
		  	  	   		});
	
    });  


	    
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		}
    });
	 function del(id){
		  	var oaction = document.getElementById("recommendForm").action;
		  	alert(id)
		  	 document.getElementById("recommendForm").action="${ctx }/teacherrecommend/manage/teacherrecommend!delete.action?id="+id;

		  	 b_confirm('您确定要进行此操作吗?', function() {
		  		$("#recommendForm").submit();
		  		document.getElementById("recommendForm").action = oaction;
		     });

		 };
</script>
</head>
<body>
 <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="teacherrecommend" name="menu" />
	<jsp:param value="courserecommend" name="bigmenu" />
    </jsp:include>

  <section id="main" role="main"> 
  <div class="dr-container-fluid">

  <ol class="dr-breadcrumb">
    <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a> </li>
    <li><a href="#">推荐管理</a></li>
    <li class="active">权威师资推荐管理</li>
  </ol>
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
<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->

  <form id="recommendForm" name="recommendForm"  class="form-inline dr-form-inline" action="teacherrecommend.action" method="post">
  	<div class="panel panel-default">
	<div class="btn-toolbar dr-btn-toolbar">
     <p>已推荐主讲老师</p>
     </div>

<table class="table table-bordered dr-table-bordered">
	<tr>

		<td width="10%" >课程名称</td>
		<td width="10%" >主讲老师姓名</td>
		<td width="30%" >简介</td>
		<td width="20%" >编辑</td>
	</tr>
	<s:iterator value="page2.result" status="stat">
		<tr>

			<td>${simpleCourseStr}</td>
			<td>${teacherName}</td>
			<td>${description }</td>
            <td>
					<a class="btn btn-primary btn-sm" href="${ctx }/teacherrecommend/manage/teacherrecommend!moveUp.action?id=${id}&orderNum=${sortnum}">
					<span class="glyphicon glyphicon-arrow-up"></span>
					上移
					</a>
					<a class="btn btn-default btn-sm"  href="${ctx }/teacherrecommend/manage/teacherrecommend!moveDown.action?id=${id}&orderNum=${sortnum}">
					<span class="glyphicon glyphicon-arrow-down"></span>
					下移
					</a>	
					<a class="btn btn-default btn-sm" type="button" id="batchdeleteFormDown" href="#" onclick="del(${id});">
					<span class="glyphicon glyphicon-trash"></span>
					删除
					</a>
            
            </td>
		</tr>
	</s:iterator>
</table>

</div>
</form>

<br />

  
      
      <div class="dr-searchbar"> 
      <form id="mainForm" name="mainForm"  class="form-inline dr-form-inline" action="teacherrecommend.action" method="post">
      <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
      <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
      <input type="hidden" name="page.order" id="order" value="${page.order}" />
    <div class="form-group">
      <label>课程名称</label>
      <input class="form-control input-sm" type="text" name="courseStr" value="${courseStr }" />
   </div>  
     
       <div class="form-group">
      <label>教师名</label>
      <input class="form-control input-sm" type="text" name="teachername" value="${teachername}" />
   </div>   
   <button type="submit" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-search"></span>&nbsp;搜索
   </button>
   </form>
   </div>


<form name="deleteForm" id="deleteForm" action="teacherrecommend.action" method="post" class="form-inline dr-form-inline">
   <div class="panel panel-default">
   <div class="btn-toolbar dr-btn-toolbar">
       	<button name="Submit3" type="button" class="btn btn-default btn-sm"id="batchrecommendFormDown" > 
		  <span class="glyphicon glyphicon-save"></span>&nbsp;添加至推荐
		</button>
     </div>
   <table class="table table-bordered dr-table-bordered">
	<tr>
		<td width="5%" ><input type="checkbox" id="checkboxall" /></td>
		<td width="20%" >课程名称</td>
		<td width="20%" >主讲老师照片</td>
		<td width="20%" >主讲老师姓名</td>
		<td width="20%" >职称</td>
		<td width="20%" >单位</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td>
				<input type="checkbox" name="ids" id="ids" value="${id}" />
			</td>
			<td>${courseStr}</td>
			<td>
			<img width="70" height="90" src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/${pic}"/>
			</td>
			<td>${name}</td>
			<td>${professional }</td>
			<td>${organization }</td>

		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%> 
</div>
</form>
</div>

	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</section>
</div>

</body>
</html>