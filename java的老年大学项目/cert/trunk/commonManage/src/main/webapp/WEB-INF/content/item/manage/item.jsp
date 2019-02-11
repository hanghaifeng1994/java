<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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

		//验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/item/manage/item!delete.action?ID=${itemCategory.id}";
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

	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/item/manage/item!delete.action";
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
 });  
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
	}

	function delRecordcc(url){
	   var oaction = document.getElementById("deleteForm").action;
	   document.getElementById("deleteForm").action=""+url;
       b_confirm('您确定要进行此操作吗?', function() {
			$("#deleteForm").submit();
			document.getElementById("deleteForm").action = oaction;
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
	<jsp:param value="itemlist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
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
		<a href="#">
			<s:if test="#request.isqlxx=='true'">
                			课程学习管理
                		</s:if>
                		<s:else>
                			培训项目管理
                		</s:else>
		</a>
		</li>
		<li class="active"><span><s:if test="#request.isqlxx=='true'">课程类型列表</s:if><s:else>项目类型列表</s:else></span></li>
		</ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>
               <s:if test="#request.isqlxx=='true'">
                			课程类型列表
                		</s:if>
                		<s:else>
                			     项目类型列表
                		</s:else>
       
            <small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
    <!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
		<form id="mainForm" name="mainForm" action="item.action" method="post">
				<input type="hidden" name="page.pageNo" id="pageNo" value="1"/>
				<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/>
				<input type="hidden" name="page.order" id="order" value="${page.order}"/>
		</form>	
    <!--列表-->
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
    		<form name="deleteForm" id="deleteForm" action="item.action" method="post" class="form-inline dr-form-inline">
    		    <div class="dr-searchbar" >
				<s:if test="CurTenantID==null">
					<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"
					value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control" name="tenantId"></s:select>
					</div>
				</s:if>
				<div class="form-group">
					<button class="btn btn-default btn-sm" type="submit">
						<span class="glyphicon glyphicon-search"></span>
			 			搜索
					</button>
				</div>
				</div>
    		
    	    <div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
                </button>
				</div>
				<div class="btn-group">
				<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="window.location='item!input.action'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;
                		<s:if test="#request.isqlxx=='true'">
                			新建课程内容
                		</s:if>
                		<s:else>
                			新增项目类型
                		</s:else>
                </button>
				</div>
			</div>
		    
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<td><input type="checkbox" id="checkboxall" /></td>
					<th>项目类型名称</th>
					<th>项目类型代码</th>
					<th>项目数</th>
					<s:if test="CurTenantID==null"><th width="25%">来自</th></s:if>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
				<tr>
					<td><input type="checkbox" name="ids" value="${id}" /></td>
					<td>${nameStr}</td>
					<td>${code}</td>
					<td>
					<a href="${ctx }/train/manage/programs.action?filter_EQL_itemCategory$id=${id}">
					${programsCount}</a>
					</td>
					<s:if test="CurTenantID==null"><td >${tenant.name}</td></s:if>
					<td>
					<a class="btn btn-primary btn-sm" href="item!input.action?id=${Id}"  type="button">
					<span class="glyphicon glyphicon-edit"></span>
					编辑
					</a>
					<a class="btn btn-default btn-sm"  type="button" onclick="delRecordcc('${ctx }/item/manage/item!delete.action?ids=${id}');">
					<span class="glyphicon glyphicon-trash"></span>
					删除
					</a>
					<!--<a type="button" href="item!showinmenu.action?id=${Id}">${menuStr }</a>
					
					<s:if test='showinmenu'>
					<button type="button" class="btn btn-primary btn-sm" onclick="window.location.href='item!showinmenu.action?id=${Id}'">
					前台显示
					</button>
					</s:if>
					<s:else>
					<button type="button" class="btn btn-default btn-sm" onclick="window.location.href='item!showinmenu.action?id=${Id}'">
					前台未显
					</button>
					</s:else>-->
					
					<s:if test='showinmenu'>
					<a class="btn btn-default  btn-sm" type="button" href="item!showinmenu.action?id=${Id}">
					设为不显示
					</a>
					</s:if>
					<s:else>
					<a class="btn btn-primary btn-sm" type="button" href="item!showinmenu.action?id=${Id}">
					设为显示
					</a>
					</s:else>
					</td>
				</tr>
				</s:iterator>
				</tbody>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
     		</div>
			</form>
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