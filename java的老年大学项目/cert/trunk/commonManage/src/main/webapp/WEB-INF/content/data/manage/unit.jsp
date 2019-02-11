<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>单位管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script type="text/javascript">
    $(document).ready(function(){   

        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();   
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
		});

		
	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/data/manage/unit!batchDeleteed.action";
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
	<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
  <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="unitlist" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->  
  <section id="main" role="main"> 
  <div class="dr-container-fluid">

    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">基础数据管理</a></li>
     <li class="active">单位管理</li>
    </ol>
   <div class="dr-page-header">
     <h3>单位管理</h3>
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


<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<form id="mainForm" name="mainForm" action="unit.action" method="post">
   <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
   <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
   <input type="hidden" name="page.order" id="order" value="${page.order}" />
   <input type="hidden" name="parentId" id="parentId" value="${parentId}" />
</form>

<form name="deleteForm" id="deleteForm" action="unit!delete.action" method="post">
  <div class="panel panel-default"> 

  <div class="btn-toolbar dr-btn-toolbar">
            <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
      </button>
     
        <button class="btn btn-primary btn-sm" type="button" id="batchDelDown" name="Submit3" onclick="window.location='unit!input.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增
        </button>
	    
	<s:if test="parentId != null">
	   <button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location.href='unit!reback.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-backward"></span>
                    返回上级区划
        </button>
	    (${advanceName})
	</s:if>
    </div>


<table  class="table table-bordered dr-table-bordered">
	<tr>
		<td width="5%"><input type="checkbox"
			id="checkboxall" /></td>
		<td width="10%">单位名称</td>	
		<td width="10%">单位代码</td>
		<td width="10%">单位所属市</td>
		<td width="10%">单位所在区县</td>  	 
		<td width="20%">操作</td>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>

			<td><input type="checkbox" name="ids"
				value="${id}" /></td>		
				<td title="${name}"><common:cut len="20"
					string="${name}" />&nbsp;</td>
				<td title="${code}"><common:cut
					len="20" string="${code}" />&nbsp;</td>			
				<td title="${unitcity}"><common:cut len="20"
					string="${unitcity}" />&nbsp;</td>
				<td title="${unitarea}"><common:cut len="20"
					string="${unitarea}" />&nbsp;</td>
			<td class="white_bg">
			    
			<a href="${ctx }/data/manage/unit!input.action?id=${id}" class="btn btn-primary btn-sm" type="button">
			<span class="glyphicon glyphicon-edit"></span>
			编辑</a>

		    <s:if test="parentId != '' && parentId != null">
		    <a href="${ctx }/data/manage/unit!delete.action?id=${id}&parentId=${parentId}" class="btn btn-primary btn-sm" type="button">
			<span class="glyphicon glyphicon-trash"></span>
			删除</a>	
			</s:if> 
			<a href="${ctx }/data/manage/unit.action?parentId=${id}" class="btn btn-primary btn-sm" type="button">
			<span class="glyphicon glyphicon-forward"></span>
			管理下级区划</a>	
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
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