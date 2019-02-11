<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isShzx",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","isShzx"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%>

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
	 	 
	function selectTenant(id){
		b_IframeLevel("${ctx}/train/manage/programs!selectTenant.action?id="+id,550,400,tst);
	}	
	function tst(){location.reload();}	 
	 
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
	        <a href="#">
	        <s:if test="#request.isqlxx=='true'">
                			课程学习管理
                		</s:if>
                		<s:else>
                			培训项目管理
                		</s:else>
	        </a>
	       </li>
	       <li class="active"><span>
	       <s:if test="#request.isqlxx=='true'">
                			学习课程列表
                		</s:if>
                		<s:else>
                			培训项目列表
                		</s:else>
	       </span></li>
	    </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>
            <s:if test="#request.isqlxx=='true'">
                			学习课程列表
                		</s:if>
                		<s:else>
                			     培训项目列表
                		</s:else>
            <small>&nbsp;</small></h3>
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
 	<s:if test="CurTenantID==null">
 	<li class="<s:if test='isCommon!="common"'>active</s:if><s:else></s:else>" ><a href="programs.action">大平台项目</a></li>
    <li class="<s:if test='isCommon=="common"'>active</s:if><s:else></s:else>"><a href="programs.action?isCommon=common">租户项目</a></li>
    </s:if>
    <s:else>
    <li class="<s:if test='isCommon!="common"'>active</s:if><s:else></s:else>" ><a href="programs.action">我的项目</a></li>
    <li class="<s:if test='isCommon=="common"'>active</s:if><s:else></s:else>"><a href="programtenant.action">大平台下发项目</a></li>
    </s:else>
</ul>

<div class="tab-content dr-tabs-panel">     
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="programs.action" method="post" >
			<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<input type="hidden" name="isCommon" id="isCommon" value="${isCommon}" />
			<input type="hidden" name="show" id="show" value="${show}" />
			<s:if test="CurTenantID==null&&isCommon=='common'">
					<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"
					value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
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
                <input name="programsname" class="form-control input-sm" value="${param['programsname']}" />
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
                <button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
            </div>
			</form>
		</div>
    <!--搜索模块end-->
    <!--订单列表-->
    	<form name="deleteForm" id="deleteForm" action="programs.action" method="post">
    	  <div class="panel panel-default">
    	   	<s:if test='isCommon!="common"'>
			<div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
           		</button>
				</div>
				
				<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'||#request.isHbfcjjOpen=='true'">
					<%-- <s:if test="curTenantID==null"> --%>
				      <div class="btn-group">
				      <button class="btn btn-primary btn-sm" type="button" onclick="window.location='programs!input.action'">
                      <span class="glyphicon glyphicon-plus"></span>&nbsp;新增培训项目
                      </button>
					 </div>
				     <%-- </s:if > --%>
				</s:if>
				
				<s:if test="#request.iswxeduopen=='true'||#request.isShzx=='true'">
					 
				      <div class="btn-group">
				      <button class="btn btn-primary btn-sm" type="button" onclick="window.location='programs!input.action'">
                      <span class="glyphicon glyphicon-plus"></span>&nbsp;新增培训项目
                      </button>
				</div>
				      
				</s:if>
				
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
		    </s:if>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
				    <s:if test='isCommon!="common"'>
					<th width="5%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
					</s:if>
					<th width="15%" >项目名称</th>
					<!-- 
					<th width="10%" >关联证书名称</th>
					-->
					<th width="14%">所属项目类型</th>
					<th width="7%">发布状态</th>
					<th width="15%" align="center">自主班级<br/>未开始/开放中/已结束</th>
					<th width="15%" align="center">集体班级<br/>未开始/开放中/已结束</th><!--
					<s:if test="nowUser.super"><th width="13%">来自</th></s:if>
					-->
					<s:if test='isCommon!="common"'>
					<th style="text-align:center;" width="37%">操作</th>
					</s:if>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
			    <tr>
			        <s:if test='isCommon!="common"'>
					<td class="white_bg">
					<input type="checkbox" name="ids" value="${id}" />
					</td>
					</s:if>
					<td class="white_bg"><a href="#">${name}</a></td>
					<!-- 
					<td class="white_bg">${certName}</td>
					-->
					<td class="white_bg">&nbsp;${itemCategoryName}</td>
					<td class="white_bg">&nbsp;${statusStr}</td>
					<td class="white_bg">&nbsp;${selfUnStartClazzCount}/${selfOpenClazzCount}/${selfCloseClazzCount}</td>
					<td class="white_bg">&nbsp;${groupUnStartClazzCount}/${groupOpenClazzCount}/${groupCloseClazzCount}</td>
					<!--<td >${tenantName}</td>
					-->
					<s:if test='isCommon!="common"'>
					<td class="white_bg">
					<a class="btn btn-primary btn-sm" type="button" href="programs!updateOrder.action?id=${id}&direction=up">上移</a>
				    <a class="btn btn-primary btn-sm" type="button" href="programs!updateOrder.action?id=${id}&direction=down">下移</a>
					<a class="btn btn-primary btn-sm" target="_blank" href="programs!minput.action?id=${id}"  type="button">
			        <span class="glyphicon glyphicon-info-sign"></span> 属性
			        </a>
				    <a class="btn btn-primary btn-sm" target="_blank" href="phase.action?programId=${id}"  type="button">
		            <span class="glyphicon glyphicon-list"></span>阶段
		            </a>
		            <a class="btn btn-primary btn-sm" target="_blank" href="teachcontent.action?programId=${id}"  type="button">
		            <span class="glyphicon glyphicon-list"></span>教学内容
		            </a>
				    <a class="btn btn-primary btn-sm" target="_blank" href="${ctx }/clazz/manage/clazz.action?programId=${id}"  type="button">
		            <span class="glyphicon glyphicon-user"></span> 班级
		            </a>
		            <s:if test="CurTenantID==null">
		            <a class="btn btn-primary btn-sm" target="_blank" onclick="selectTenant(${id})"  type="button">
		            <span class="glyphicon glyphicon-user"></span> 下发 ${currentTenant.contents }
		            </a>
		            </s:if>
		            <c:if test="${!fn:contains(currentTenant.contents,'english')}">
		           		 <a class="btn btn-primary btn-sm" target="_blank" href="${ctx}/train/manage/programscheck.action?programId=${id}"  type="button">
			           		 <span class="glyphicon glyphicon-user"></span>
		           		        <s:if test="#request.isqlxx=='true'">
		                			学习评价
		                		</s:if>
		                		<s:else>
		                			     考评标准
		                		</s:else> 
			            </a>
		            </c:if>
		            <s:if test="#request.isShzx=='true'&&shenhe==1">		            
		            <a class="btn btn-primary btn-sm" target="_blank" href="${ctx}/train/manage/programs!requireUcc.action?programid=${id}" type="button">
		            <span class="glyphicon glyphicon-user"></span>项目审核情况
		            </a>
		            </s:if>		             
				    </td>
				    </s:if>
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