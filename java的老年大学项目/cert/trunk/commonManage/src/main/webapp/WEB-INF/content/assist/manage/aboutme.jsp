<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
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
			   document.getElementById("deleteForm").action="${ctx }/assist/manage/aboutme!delete.action";
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
		
	 function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}
 });
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
	<jsp:param value="aboutme" name="menu" />
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
		<a href="#">培训项目管理</a>
		</li>
		<li class="active"><span>关于我们</span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>关于我们<small>&nbsp;</small></h3>
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
    <s:if test="nowUser.tenantId==null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="aboutme.action?isMy=true">我的关于我们</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="aboutme.action?isMy=false">其他租户关于我们</a></li>
    </ul>
    </s:if>
    <div class="tab-content dr-tabs-panel">

<!--信息提示 end-->
    <!--表单模块-->
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="aboutme.action" method="post">
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
    <!--表单模块end-->
    <!--订单列表-->
    		<form name="deleteForm" id="deleteForm" action="aboutme!delete.action?isMy=${isMy}" method="post" class="form-inline dr-form-inline">
    		<div class="panel panel-default">
    		<s:if test="isMy">
			<div class="btn-toolbar dr-btn-toolbar">
		        <div class="btn-group">
		        <button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
                </button>
		        </div>
		        <div class="btn-group">    	
				<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="window.location='aboutme!input.action?isMy=${isMy}'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增信息
                </button>
		        </div>
		    </div>
		    </s:if>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<td><input type="checkbox" id="checkboxall" /></td>
					<th>标题</th>
					<th>发布日期</th>
					<s:if test="nowUser.tenantId==null">
					<th>来自于</th>
					</s:if>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
					<s:iterator value="page.result" status="stat">
				<tr>
					<td ><input type="checkbox" name="ids" id="ids"
						value="${id}" /></td>
					<td title="${title}" ><common:cut len="30"
						string="${title}" /></td>
					<td ><s:date name="date" format="yyyy.MM.dd" /></td>	
						<s:if test="nowUser.tenantId==null">
						<td title="${tenantName}" class="white_bg">${tenantName}</td>
						</s:if>
					<td >
					<s:if test="isMy">
					<a class="btn btn-primary btn-sm" href="${ctx }/assist/manage/aboutme!moveUp.action?id=${id}&orderNum=${orderNum}&isMy=${isMy}">
					<span class="glyphicon glyphicon-arrow-up"></span>
					上移
					</a>
					<a class="btn btn-default btn-sm"  href="${ctx }/assist/manage/aboutme!moveDown.action?id=${id}&orderNum=${orderNum}&isMy=${isMy}">
					<span class="glyphicon glyphicon-arrow-down"></span>
					下移
					</a>	
					<a class="btn btn-primary btn-sm" href="${ctx }/assist/manage/aboutme!input.action?id=${id}&isMy=${isMy}">
					<span class="glyphicon glyphicon-edit"></span>
					编辑
					</a>
					<a class="btn btn-default btn-sm" type="button" href="#" onclick="delRecord('aboutme!delete.action?ids=${id}&isMy=${isMy}');">
					<span class="glyphicon glyphicon-trash"></span>
					删除
					</a>
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