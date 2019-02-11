<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书籍列表<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
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
		
	   $("#batchDelDown").click(
			function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!productTenantDelete.action";
			       if(!checkSelect()) {
				   		b_alert('没有可操作记录,请勾选');
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
	   
	   $("#batchpublicDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!publishProductTenant.action";
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

	   $("#batchUnpublicDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!unpublishProductTenant.action";
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

	   $("#productshare").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!productShare.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			 });
	   $("#cancelshare").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!cancelShare.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			 });
	   $("#productreport").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/product/manage/product!productReport.action";
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

	 //选择一项操作动作
     function operaction(obj,id){
        
   		var hrefvalue = obj.value;
   		if(hrefvalue=="")return;
   		var target = "_blank";
   		if(hrefvalue=='product!input.action')
   			target = "_self";
   		openUrl(hrefvalue,target,id);
     }   
     
	 //选择一项操作动作
     function newoperaction(obj,id,name){
    	 $("#oper_"+id).text(name);
        var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
   		var hrefvalue = obj;
   		if(hrefvalue=="")return;
   		var target = "_blank";
   		if(hrefvalue=='product!input.action')
   			target = "_self";
		if(hrefvalue=="1" || hrefvalue=="2" || hrefvalue=="3"){
			$("#outItemId").val(id);
			$("#roleType").val(hrefvalue);			
			hrefvalue = hreflp;
		}
   		openUrl(hrefvalue,target,id);
     }     

	 function selectCat(){
		 var checkCats = $('#checkCats').val();
		 var tenantId = $('#tenantId').val();
		 b_IframeLevel("${currentTenant.doname}/product/manage/product!addProductCatP.action?checkCats="+checkCats+"&tenantId="+tenantId,400,500,tst);
	}
	 function tst(){
		 //var c = window.frames['mainiframe'].document.getElementById('checkCats').value; 
		 window.frames['mainiframe'].saveCat();
		 //alert(c)
	};
	 function saveCat(checkCats){
		 $.ajax({
		        type: "POST",
		        url: "${ctx}/product/manage/product!catName.excsec",
		        data: {
		        	"checkCats": checkCats,
				},
		        success: function(data) {
					$("#catname").val(data.value);
					$("#checkCats").val(checkCats);
		        }
			});
	}
</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="productlist" name="menu" />
	<jsp:param value="product" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">书籍资源库管理</a>
</li>
<li class="active">书籍列表</li>
</ol>

<div class="dr-page-header">
<h3>
书籍列表
</h3>
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

<ul class="nav nav-tabs nav-justified">
	<s:if test="nowUser.tenantId==null">
	<li class="<s:if test="tabFlag=='isMy'">active</s:if>" ><a href="product.action?tabFlag=isMy">我的书籍 </a></li>
	</s:if><s:else>
 	<li class="<s:if test="tabFlag=='isMy'">active</s:if>" ><a href="product!productTenant.action?tabFlag=isMy">我的书籍</a></li>
	</s:else>
    <li class="<s:if test="tabFlag=='canUseing'">active</s:if>"><a href="product!productTenant.action?tabFlag=canUseing">可使用书籍</a></li>
    <s:if test="nowUser.tenantId==null">
    <li class="<s:if test="tabFlag=='noValidate'">active</s:if>"><a href="product.action?tabFlag=noValidate">待接收书籍</a></li>
    <li class="<s:if test="tabFlag=='other'">active</s:if>"><a href="product.action?tabFlag=other">租户书籍</a></li>
    </s:if>
</ul>
<div class="tab-content dr-tabs-panel">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/product/manage/product!productTenant.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" id="onecat" name="onecat" value="${onecat}" />
<input type="hidden" id="twocat" name="twocat" value="${twocat}" />
<input type="hidden" id="threecat" name="threecat" value="${threecat}" />
<input type="hidden" name="tabFlag" value="${tabFlag}" />
<s:if test="isCommon!=null">
<div class="form-group">
  <label>租户</label>
  <s:select list="tenantLists" listKey="id"
	value="tenantId" listValue="name" theme="simple"
	cssClass="form-control" name="tenantId" headerValue="--选择租户--"
	headerKey=""></s:select>
</div> 
</s:if>
<!--<div class="form-group">
<label>书籍分类：</label>
<input id="catname" name="checkCatName" class="form-control input-sm" onfocus="selectCat()"
				value="${checkCatName}"/>
<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
</div>
-->
<div class="form-group">
<label>一级分类</label>
<s:select theme="simple" list="oneCategories" cssClass="form-control"
				listKey="id" listValue="name" id="productonecategory" value="onecat"
				headerKey="" headerValue="选择一级分类"/>
</div>
<div class="form-group">
<label>二级分类</label>
<s:select list="twoCategories" listKey="id" cssClass="form-control"
				listValue="name" theme="simple" id="producttwocategory" headerKey=""
				headerValue="选择二级分类" value="twocat"></s:select>
</div>
<div class="form-group">
<label>三级分类</label>
<s:select list="threeCategories" listKey="id" cssClass="form-control"
				listValue="name" theme="simple" id="productthreecategory"
				headerKey="" headerValue="选择三级分类" value="threecat"></s:select>
</div>

<div class="form-group">
<label>书籍名称</label>
<input name="filter_LIKES_product$name" type="text" class="form-control input-sm"
				value="${param['filter_LIKES_product$name']}"/>
</div>
<div class="form-group">
<label>书籍代码</label>
<input name="filter_LIKES_product$serialNo" class="form-control input-sm"
				value="${param['filter_LIKES_product$serialNo']}"/>
</div>
<div class="form-group">
<label>教学方式</label>
<s:select name="filter_EQB_product$offline" cssClass="form-control input-sm" list="#{'--全部--':'','线下':'true','线上':'false'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_product$offline">
		        </s:select>
</div>
<div class="form-group">
<label>学分</label>
<input class="form-control input-sm" type="text" name="filter_GEN_product$studylength" id="scoreStart" style="width: 50px;"
				value="${param['filter_GEN_product$studylength']}" maxlength="6"/>
-
<input class="form-control input-sm" type="text" name="filter_LEN_product$studylength" id="scoreEnd" style="width: 50px;"
				value="${param['filter_LEN_product$studylength']}" maxlength="6"/>
</div>
<div class="form-group">
<button class="btn btn-default btn-sm" type="submit">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
</div>
</form>
<form name="deleteForm" id="deleteForm" action="${ctx}/product/manage/product!productTenant.action" method="post">
<input type="hidden" name="tabFlag" value="${tabFlag}" />
<div class="panel panel-default">
<div class="btn-toolbar dr-btn-toolbar">
<s:if test="tabFlag=='isMy'">
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit2" id="batchDelDown">
<span class="glyphicon glyphicon-trash"></span>
 批量删除
</button>
</div>

<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
	<%-- <s:if test="curTenantID==null"> --%>
		<div class="btn-group">
			<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location='product!input.action?tabFlag=isMy'">
				<span class="glyphicon glyphicon-plus"></span>
			新增书籍
			</button> 
		</div>
	<%-- </s:if> --%>
</s:if>

<s:if test="#request.iswxeduopen=='true'">	 
		<div class="btn-group">
			<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location='product!input.action?tabFlag=isMy'">
				<span class="glyphicon glyphicon-plus"></span>
				新增书籍												
			</button> 
		</div>	 
</s:if>

 
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="productshare">
<span class="glyphicon glyphicon-share mr5"></span>
书籍分享
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit3" id="cancelshare">
<span class="glyphicon glyphicon-share mr5"></span>
取消书籍分享
</button>
</div>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="productreport">
<span class="glyphicon glyphicon-send mr5"></span>
书籍上报
</button>
</div>
</s:if>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="batchpublicDown">
<span class="glyphicon glyphicon-ban-circle"></span>
发布书籍
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit3" id="batchUnpublicDown">
<span class="glyphicon glyphicon-ban-circle"></span>
取消发布
</button>
</div>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
		<th width="4%"><input type="checkbox" id="checkboxall"/></th>
		<th width="23%">书籍名称<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">书籍编码<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="5%">学分<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="9%">辅导教师数<!--<i class="dr-sorting-desc"></i>--></th>
		<s:if test="#request.iswxeduopen=='true'"><th width="8%">学习时长</th></s:if>
		<!--<th width="10%">有效期<i class="dr-sorting-desc"></i></th>
		--><th width="8%">发布状态<!--<i class="dr-sorting-desc"></i>--></th>
		<s:if test="tabFlag=='isMy'"><th width="8%">分享状态</th></s:if><s:else>
		<th width="11%">来自</th></s:else>
		<th width="8%">教学方式</th>
		<s:if test="tabFlag=='isMy'"><th width="13%">操作</th></s:if>
	</tr>
	<s:iterator value="page2.result" status="stat">
		<tr>
			<td><input type="checkbox" name="ids" id="ids"	value="${id}" /></td>
			<td title="${productDTO.name}"><common:cut len="30" string="${productDTO.name}"/></td>
			<td>&nbsp;${productDTO.serialNo}</td>
			<td>${productDTO.studylength}</td>
			<td>${productDTO.tutorCount}</td>
			<s:if test="#request.iswxeduopen=='true'"><td>${productDTO.studyTimeStr }</td></s:if>
			<!--<td>${productDTO.formatValidDate}</td>
			--><td><s:if test="tabFlag=='isMy'"><s:if test="productDTO.published">是</s:if> <s:else>否</s:else></s:if><s:else><s:if test="display">是</s:if> <s:else>否</s:else></s:else> </td>
			<s:if test="tabFlag=='isMy'"><td><s:if test="productDTO.hasShare">已分享</s:if><s:else>未分享</s:else> </td></s:if><s:else>
			<td><s:if test="productDTO.tenant!=null">${productDTO.tenant.name}</s:if><s:else>大平台</s:else> </td></s:else>
			<td>${productDTO.offlineType}</td>
			<s:if test="tabFlag=='isMy'">
			<td>
			<div class="btn-group">
               <button class="btn btn-default btn-sm" type="button" id="oper_${productDTO.id}" style="padding: 5px 8px;">
                <s:if test="productDTO.newlp">书籍管理</s:if>
                <s:else>旧平台书籍管理</s:else>
              </button>
              <button data-toggle="dropdown" class="btn btn-default btn-sm dropdown-toggle" type="button" style="height: 30px;padding: 5px">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
              </button>
                     <ul role="menu" class="dropdown-menu">
                     <s:if test="productDTO.newlp">
                     <li><a href="#" onclick="newoperaction('product!input.action',${productDTO.id},'书籍属性')">书籍属性</a></li>
                     <s:if test="!offline">
                     <li><a href="#" onclick="newoperaction('product!tryreadInput.action',${productDTO.id},'试读管理')">试读管理</a></li>
                     <li><a href="#" onclick="newoperaction('1',${productDTO.id},'书籍建设')">书籍建设</a></li>
                     </s:if>
                    <!--<li><a href="#" onclick="newoperaction('2',${id},'书籍辅导')">书籍辅导</a></li>
                     <li><a href="#" onclick="newoperaction('3',${id},'书籍实施')">书籍实施</a></li>
                     --><!--
                     <li class="divider"></li>
                     -->
                     </s:if>
                     <s:else>
                     <li><a href="#" onclick="newoperaction('product!input.action',${productDTO.id},'书籍属性')">书籍属性</a></li>
                     <li><a href="#" onclick="newoperaction('product!tryreadInput.action',${productDTO.id},'试读管理')">试读管理</a></li>
                     <li><a href="#" onclick="newoperaction('product!manageProduct.action',${productDTO.id},'书籍内容管理')">书籍内容管理</a></li>
                     <li><a href="#" onclick="newoperaction('product!examSubjectBase.action?id=${productDTO.id}',${productDTO.id},'书籍题库管理')">书籍题库管理</a></li>
                     <li><a href="#" onclick="newoperaction('product!examPaperRule.action?id=${productDTO.id}',${productDTO.id},'书籍测验管理')">书籍测验管理</a></li>
                     <li><a href="#" onclick="newoperaction('product!examination.action?id=${productDTO.id}',${productDTO.id},'测验阅卷')">测验阅卷</a></li>
                     <li><a href="#" onclick="newoperaction('product!addHomeWorks.action?id=${productDTO.id}',${productDTO.id},'作业布置')">作业布置</a></li>
                     <li><a href="#" onclick="newoperaction('product!readHomeWorks.action?id=${productDTO.id}',${productDTO.id},'作业批阅')">作业批阅</a></li>
                     </s:else>                           
                     </ul>
            </div>
			</td></s:if>
		</tr>
	</s:iterator>
</table>
<s:set name="page" value="page2" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
<!--模拟打开新窗口 -->
<script type="text/javascript">
function openUrl(url,target,id){
	$("#newwindowFrom").attr("action",url);
	$("#newwindowFrom").attr("target",target);
	$("#newwindowId").val(id);
	$("#newwindowFrom").submit();
}
</script>
<form id="newwindowFrom" action="" method="get" target="_blank">
<input name="id" id="newwindowId" type="hidden"/>
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="<common:prop name="lp3.tenantsCode" propfilename=""></common:prop>"/>
<input name="teacherName" id="teacherName" type="hidden" value="${user.name}"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="${user.username}"/> 
<input name="tabFlag" id="tabFlag" value="${tabFlag}" type="hidden"/>            
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
<!--正文结束-->
</div>
<script>
		jQuery(document).ready(function () {
			TreeView.init();
		});

		$(".expand").mouseover(function () {
			$(this).stop();
			$(this).animate({
				right: 0
			}, 400);
		})
		 $(".expand").mouseout(function () {
			$(this).stop();
			$(this).animate({
				right: -400
			}, 400);
		})
	</script>
</body>
</html>