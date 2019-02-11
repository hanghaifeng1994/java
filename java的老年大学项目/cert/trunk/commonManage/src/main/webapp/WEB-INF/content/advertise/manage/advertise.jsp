<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>广告列表-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/advertise/manage/advertise!delete.action";
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
				  // document.getElementById("deleteForm").action = oaction;
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
	<jsp:param value="advertise" name="menu" />
	<jsp:param value="menuHead" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">

   <ol class="dr-breadcrumb">
        <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
        <li><a href="#">首页管理</a></li>
        <li class="active">广告列表</li>
   </ol>
      <div class="dr-page-header">
     <h3>广告列表 </h3>
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
       <s:if test="nowUser.tenantId==null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="advertise.action?isMy=true">大平台广告列表</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="advertise.action?isMy=false">租户广告列表</a></li>
    </ul>
    </s:if>
    <div class="tab-content dr-tabs-panel">
<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="advertise.action" method="post">
    <input type="hidden" name="page.pageNo" id="pageNo"value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy"id="orderBy" value="${page.orderBy}" /> 
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
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
	
	
	
	
	
<form name="deleteForm" id="deleteForm" action="advertise!delete.action" method="post">
<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
<div class="panel panel-default">	
  <s:if test="isMy">
  <div class="btn-toolbar dr-btn-toolbar">
          <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
      </button>
      <button name="Submit3" type="button"class="btn btn-primary btn-sm" 
	          onclick="window.location='advertise!input.action?isMy=${isMy}'">
		  <span class="glyphicon glyphicon-plus"></span>&nbsp;新增广告
	 </button>
  </div>
  </s:if>


<table class="table table-bordered dr-table-bordered">
	<thead>
	<tr>
		<th width="5%"  ><input type="checkbox" id="checkboxall" /></th>
		<th width="25%" >广告网址</th>
		<th width="15%" >广告名称</th>
		<th width="12%" >上传时间</th>
		<th width="8%" >状态</th>
		<s:if test="nowUser.tenantId==null">
		<th width="8%" > 来自</th>
		</s:if>
		<th width="25%" >操作</th>
	</tr>
	</thead>
	<s:iterator value="page.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" value="${id}" /></td>
			<td>${webSite}</td>
			<td>${name}</td>
			<td>
			<s:date name="updateTime" format="yyyy.MM.dd " />
			</td>
            <td >${StatusString}</td>
            <s:if test="nowUser.tenantId==null">
			<td >${tenantName} </td>
			</s:if>
			<td >
			<s:if test="isMy">
			<a href="${ctx }/advertise/manage/advertise!input.action?id=${id}&isMy=${isMy}">
				<button class="btn btn-primary btn-sm" type="button">
				    	<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑
				    </button></a>
			<s:if test="!advertised">
				<s:if test="type==5">
					<a href="${ctx }/advertise/manage/advertise!publishstudy.action?id=${id}&isMy=${isMy}">
						<button class="btn btn-primary btn-sm" type="button">
				    		<span class="glyphicon glyphicon-ok-circle"></span>&nbsp;启用
				    	</button></a>
				</s:if>
				<s:else>
					<a	href="${ctx }/advertise/manage/advertise!publishstudy.action?id=${id}&isMy=${isMy}">
						<button class="btn btn-primary btn-sm" type="button">
				    		<span class="glyphicon glyphicon-ok-circle"></span>&nbsp;启用
				        </button></a>
				</s:else>
			</s:if>
		    <s:else>
				   <a
					href="${ctx }/advertise/manage/advertise!unpublishstudy.action?id=${id}&isMy=${isMy}">
					<button class="btn btn-default btn-sm" type="button">
				    	<span class="glyphicon glyphicon-ban-circle"></span>&nbsp;停用
				    </button></a>
			</s:else>
			</s:if>
			</td>

		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</div>
    <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
</section>
</div>

</body>
</html>