<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短信管理-后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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
	<jsp:param value="mspushlist" name="menu" />
	<jsp:param value="mspush" name="bigmenu" />
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
	        <a href="#">短信管理 </a>
	       </li>
	       <li class="active"><span>短信列表</span></li>
	    </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>短信列表<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
	

<ul class="nav nav-tabs nav-justified">
 	<s:if test="CurTenantID==null">
 	<li class="<s:if test='isCommon!="common"'>active</s:if><s:else></s:else>" ><a href="mspush.action">大平台短信</a></li>
    <li class="<s:if test='isCommon=="common"'>active</s:if><s:else></s:else>"><a href="mspush.action?isCommon=common">租户短信</a></li>
    </s:if>
    <s:else>
    <li class="<s:if test='isCommon!="common"'>active</s:if><s:else></s:else>" ><a href="mspush.action">我的短信</a></li>
    </s:else>
</ul>

<div class="tab-content dr-tabs-panel">     
    <!--搜索模块-->
		<div class="dr-searchbar">
			<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="mspush.action" method="post" >
			<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
			<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
			<input type="hidden" name="page.order" id="order" value="${page.order}" />
			<input type="hidden" name="isCommon" id="isCommon" value="${isCommon}" />
			<s:if test="CurTenantID==null&&isCommon=='common'">
					<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"
					value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
			</s:if>

			<div class="form-group">
				<label>短信内容</label>
                <input name="searchContent" class="form-control input-sm" value="${param['searchContent']}" />
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
    	<form name="deleteForm" id="deleteForm" action="mspush.action" method="post">
    	  <div class="panel panel-default">
			<div class="btn-toolbar dr-btn-toolbar">
<!-- 				<div class="btn-group">
				<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchDelDown">
                <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
           		</button>
				</div> -->
				      <div class="btn-group">
				      <button class="btn btn-primary btn-sm" type="button" onclick="window.location='mspush!input.action'">
                      <span class="glyphicon glyphicon-plus"></span>&nbsp;新增短信
                      </button>
					 </div>
				
			</div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<th width="5%" class="tt_noline"><input type="checkbox" id="checkboxall" /></th>
					<th width="21%" >短信内容</th>
					<th width="7%" >业务类型</th>
					<th width="9%">时间</th>
					<th width="10%">所属项目/班级</th>
					<th width="7%">目标总人数</th>
					<th width="9%">发送成功人数</th>
					<th width="9%">发送失败人数</th>
					<th width="7%">短信状态</th>
					<th style="text-align:center;" width="15%">操作</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
			    <tr>
					<td class="white_bg">
					<input type="checkbox" name="ids" value="${id}" />
					</td>
					<td class="white_bg"><a href="mspush!mslist.action?id=${id}">${content}</a></td>
					<td class="white_bg">${typeStr}</td>
					<td class="white_bg"><s:date name="createDate" format="yyyy-MM-dd"></s:date></td>
					<s:if test="serviceType==3">
					<td class="white_bg">&nbsp;${clazzName}</td>
					</s:if><s:else>
					<td class="white_bg">&nbsp;
					<s:if test="programName!=null">
					${programName}</s:if><s:else>
					暂无项目
					</s:else>
					</td>
					</s:else>
					<td class="white_bg">&nbsp;${totalNum}</td>
					<td class="white_bg">&nbsp;${pushSucceed}</td>
					<td class="white_bg">&nbsp;${pushError}</td>
					<s:if test="statue==1">
					<td class="white_bg">&nbsp;已发送</td>
					</s:if>
					<s:if test="statue==0">
					<td class="white_bg">&nbsp;未发送</td>
					</s:if>
					<s:if test="statue==2">
					<td class="white_bg">&nbsp;发送中</td>
					</s:if>
					
					<td class="white_bg">
					<a class="btn btn-primary btn-sm" type="button" href="mspush!mslist.action?id=${id}" target="_blank">详情</a>
				    <a class="btn btn-primary btn-sm" type="button" href="mspush!tosendhome.action?id=${id}">发送</a>
<%-- 				    <s:if test="serviceType!=3">
				   <a class="btn btn-primary btn-sm" type="button" href="mspush!input.action?id=${id}">编辑</a>
					</s:if> --%>
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