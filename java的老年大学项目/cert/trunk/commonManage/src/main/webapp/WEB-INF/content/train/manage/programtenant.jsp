<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">   
$(document).ready(function(){   
	 if($("#success").text()!="")$("#div-success").show();
     if($("#error").text()!="")$("#div-error").show();   
      
	 $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     	$("input[name='ids']").attr("checked",$(this).attr("checked"));
		   }else{
		   		$("input[name='ids']").removeAttr("checked");
		   } 
	   });
	   
		//验证批量删除文章的列表非空与否
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!delete.action?ID=${id}";
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
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!delete.action";
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
		 
	   $("#hide").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!hide.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?',function(){
			    	   $("#deleteForm").submit();
					   document.getElementById("deleteForm").action = oaction;
			       });
		}); 
	
		$("#show").click(
				   function(){
					   var oaction = document.getElementById("deleteForm").action;
					   document.getElementById("deleteForm").action="${ctx }/train/manage/programs.action?show=true";
					   $("#deleteForm").submit();
					   document.getElementById("deleteForm").action = oaction;
		});
		 
	   $("#batchEnableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!publish.action";
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

	   $("#batchDisableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/train/manage/programs!canclePublish.action";
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
 		});  

	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		}

	 function changeTenant(obj){
			var tenantid = $(obj).val();
			//根据一级栏目获得二级栏目
				if(tenantid) {
					$.post("programs!changeTenant.excsec",{"tenantId":tenantid},function(data) {
						$("#itemcate option[value!='']").remove();
						var category = eval(data);
						if(category.length == 0) return;
						for(var i = 0 ;i < category.length ; i++) {
							$("#itemcate").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
						} 
					});
				}else {
					$("#itemcate option[value!='']").remove(); 
				}
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
	<jsp:param value="programslist" name="menu" />
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
	        <a href="#">培训项目管理</a>
	       </li>
	       <li class="active"><span>培训项目列表</span></li>
	    </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>培训项目列表<small>&nbsp;</small></h3>
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

<ul class="nav nav-tabs nav-justified">
 	<li><a href="programs.action">我的项目</a></li>
 	<s:if test="CurTenantID==null">
    <li class="active"><a href="programs.action?isCommon=common">租户项目</a></li>
    </s:if>
    <s:else>
    <li class="active"><a href="programtenant.action">大平台下发项目</a></li>
    </s:else>
</ul>

<div class="tab-content dr-tabs-panel">     
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="programtenant.action" method="post" >
			<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<s:if test="nowUser.super&&curTenantID==null">
				<div class="form-group">
			  	<label>租户</label>
			  	<s:select list="tenantLists" listKey="id" onchange="changeTenant(this)"
				value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
				headerKey="" 
				cssClass="form-control" name="tenantId"></s:select>
				</div>
			</s:if>
			<div class="form-group">
				<label>培训类型</label>
				<s:select id="itemcate" cssClass="form-control input-sm" list="ItemCategories" listKey="id" listValue="name"
			       value="@java.lang.Long@parseLong(#parameters.filter_EQL_itemCategory$id)" name="filter_EQL_itemCategory$id" 
			       theme="simple" headerValue="--全部--" headerKey="">
			    </s:select>
			</div>
			<div class="form-group">
				<label>项目名称</label>
                <input name="filter_LIKES_name" class="form-control input-sm" value="${param['filter_LIKES_name']}" />
			</div>
			<div class="form-group">
				 <label>项目代码</label>
                 <input name="filter_EQS_code" class="form-control input-sm" value="${param['filter_EQS_code']}" />
			</div>
			<div class="form-group">
				<label>发布状态</label>
                <s:select name="filter_EQB_published" cssClass="form-control input-sm" list="#{'--全部--':'','发布':'True','未发布':'False'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_published">
		        </s:select>
			</div>
			<div class="form-group">
                <button class="btn btn-default btn-sm" type="submit">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
            </div>
			</form>
		</div>
    <!--搜索模块end-->
    <!--订单列表-->
    	<form name="deleteForm" id="deleteForm" action="programs.action" method="post">
    	  <div class="panel panel-default">
			<!--<div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
           		</button>
				</div>
				<div class="btn-group">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.location='programs!input.action'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增培训项目
                </button>
				</div>
				<div class="btn-group">
				<button  name="Submit2" class="btn btn-primary btn-sm" type="button" id="batchEnableDown">
                <span class="glyphicon glyphicon-eye-open"></span>&nbsp;发布
                </button>
				</div>
				<div class="btn-group">
				<button name="Submit2" type="button" class="btn btn-default btn-sm"  id="batchDisableDown" >
				<span class="glyphicon glyphicon-eye-close"></span>&nbsp;取消发布
				</button>
				</div>
				<div class="btn-group">
				<button  name="Submit2" class="btn btn-primary btn-sm" type="button" id="hide">
                <span class="glyphicon glyphicon-eye-open"></span>&nbsp;隐藏
                </button>
				</div>
				<div class="btn-group">
				<button name="Submit2" type="button" class="btn btn-default btn-sm"  id="show" >
				<span class="glyphicon glyphicon-eye-close"></span>&nbsp;显示全部
				</button>
				</div>
			</div>
		    
			-->
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<!-- <th width="5%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th> -->
					<th width="15%" >项目名称</th>
					<th width="10%" >关联证书名称</th>
					<th width="14%">所属项目类型</th>
					<th width="7%">发布状态</th>
					<th width="7%">自主班级</th>
					<th width="7%">集体班级</th>
					<th width="8%">操作</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
			    <tr>
					<!-- <td class="white_bg"><input type="checkbox" name="ids"
							value="${programDTO.id}" /></td>-->
					<td class="white_bg"><a href="#">${programDTO.name}</a></td>
					<td class="white_bg">${programDTO.certName}</td>
					<td class="white_bg">&nbsp;${programDTO.itemCategoryName}</td>
					<td class="white_bg">&nbsp;${programDTO.statusStr}</td>
					<td class="white_bg">&nbsp;${programDTO.selfUnStartClazzCount}/${programDTO.selfOpenClazzCount}/${programDTO.selfCloseClazzCount}</td>
					<td class="white_bg">&nbsp;${programDTO.groupUnStartClazzCount}/${programDTO.groupOpenClazzCount}/${programDTO.groupCloseClazzCount}</td>
					<td class="white_bg">
					<a class="btn btn-primary btn-sm" target="_blank" href="${ctx}/clazz/manage/clazz.action?programId=${programDTO.id}&isdown=down"  type="button">
		            <span class="glyphicon glyphicon-user"></span> 班级
		            </a>
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