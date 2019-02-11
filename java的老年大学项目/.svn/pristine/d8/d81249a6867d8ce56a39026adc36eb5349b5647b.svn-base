<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>班级列表-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/clazz.js" type="text/javascript"></script>
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
	   $("#itemdel").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!delete.action?ID=${id}";
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

	   //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/clazz/manage/clazz!delete.action?flag=${flag}";
			       if(!checkSelect()) {
			    	   b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			     //  if(!confirm('您确定要进行此操作吗?')) return  false;
	
				 //  $("#deleteForm").submit();
				 //  document.getElementById("deleteForm").action = oaction;
	   }); 	
				 
	   $("#batchEnableDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!enable.action";
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
				   document.getElementById("deleteForm").action="${ctx }/programs/manage/programs!disable.action";
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

	 function changeItem(obj){
		var tenantid = $(obj).val();
		//根据一级栏目获得二级栏目
		if(tenantid) {
			$.post("${ctx}/clazz/manage/clazz!getItem.excsec",{"tenantId":tenantid},function(data) {
				$("#articleonecategory option[value!='']").remove();
				var category = eval(data);
				$("#itemid option[value!='']").remove(); 
				if(category.length == 0) return;
				for(var i = 0 ;i < category.length ; i++) {
					$("#itemid").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
				} 
				$("#programsid option[value!='']").remove();
				$("#planid option[value!='']").remove();
			});
		}else {
			$("#itemid option[value!='']").remove(); 
			$("#programsid option[value!='']").remove();
			$("#planid option[value!='']").remove();
		}
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
	<jsp:param value="clazzlist" name="menu" />
	<jsp:param value="clazz" name="bigmenu" />
    </jsp:include>
  <!--adminLeft结束-->
   
    <section id="main" role="main"> 
      <div class="dr-container-fluid">
      <ol class="dr-breadcrumb">
        <li><span class="glyphicon glyphicoden-home"></span>&nbsp;<a href="#">平台首页</a></li>
        <li><a href="#">班级管理</a></li>
        <li class="active">班级列表</li>
       </ol>
   <div class="dr-page-header">
     <h3>班级列表 </h3>
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
	     <li class="<s:if test='flag!="group"&&isOther!="other"'>active</s:if><s:else></s:else>" ><a href="clazz!oldlist.action">自主班级</a></li>
         <li class="<s:if test='flag=="group"&&isOther!="other"'>active</s:if><s:else></s:else>"><a href="clazz!oldlist.action?flag=group">集体班级</a></li>
         <s:if test="CurTenantID==null">
         <li class="<s:if test='flag!="group"&&isOther=="other"'>active</s:if><s:else></s:else>" ><a href="clazz!oldlist.action?isOther=other">租户自主班级</a></li>
         <li class="<s:if test='flag=="group"&&isOther=="other"'>active</s:if><s:else></s:else>"><a href="clazz!oldlist.action?flag=group&isOther=other">租户集体班级</a></li>
         </s:if>
    </ul>
    
<div class="tab-content dr-tabs-panel">
<form id="mainForm" name="mainForm" action="clazz!oldlist.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page.pageNo" id="pageNo"	value="${page.pageNo}" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input	type="hidden" name="flag" id="flag" value="${flag}" />
	<input	type="hidden" name="isOther" id="isOther" value="${isOther}" />

<div class="dr-searchbar">
	<div class="form-group">
        <label>班级名称</label>
        <input class="form-control input-sm" type="text"  name="filter_LIKES_name" value="${param['filter_LIKES_name']}"/>
	</div>
	<div class="form-group">
        <label>班级代码</label>
        <input class="form-control input-sm" type="text" name="filter_LIKES_code" value="${param['filter_LIKES_code']}"/>
	</div>
	<div class="form-group">
            <label>状态</label>
            <s:checkboxlist name="state" list="#{'开 放':1,'未开始':0,'结 束':2}"
            	theme="simple" listKey="value" listValue="key" value="state">
            </s:checkboxlist>
	   			<input type="hidden" name="programsid" value="${programsid }" id="hiddenprogramsid" />
	   			<input type="hidden" name="planid" value="${planid }" id="hiddenplanid" />
	   
	</div>
	<s:if test="CurTenantID==null&&isOther=='other'">
    <div class="form-group">
	<label>租户</label>
	<s:select list="tenantLists" listKey="id" onchange="changeItem(this)"
	value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
	headerKey="" cssClass="form-control" name="tenantId"></s:select>
	</div>
    </s:if>
	<div class="form-group">		
		<label>培训项目</label>
				<s:select list="programList" listKey="id" cssClass="form-control input-sm"
				listValue="name"
				value="@java.lang.Integer@parseInt(#parameters.filter_EQL_program$id)"
				name="filter_EQL_program$id" theme="simple"
				headerValue="请选择培训项目" headerKey="" id="programsid"></s:select>
		<label>项目阶段</label>
			<s:select list="phaseList" listKey="id" cssClass="form-control input-sm"
				listValue="name"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_phase$id)"
				name="filter_EQL_phase$id" theme="simple"
				headerValue="--请选择项目阶段--" headerKey="" id="phaseId"></s:select>
		<label>教学内容</label>
			<s:select list="teachContentList" listKey="id" cssClass="form-control input-sm"
				listValue="name+'(第'+version+'版)'"
				value="@java.lang.Long@parseLong(#parameters.filter_EQL_teachContent$id)"
				name="filter_EQL_teachContent$id" theme="simple"
				headerValue="--请选择教学内容--" headerKey="" id="teachContentId"></s:select>	
	</div>
	<div class="form-group">
		<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
			<span class="glyphicon glyphicon-search"></span>
 			搜索
		</button>
	</div>
</div>
</form>

<form name="deleteForm" id="deleteForm" action="clazz!delete.action"method="post">
<input	type="hidden" name="flag2" id="flag2" value="wxold" />
  <div class="panel panel-default">
  	<s:if test="isOther!='other'">
    <div class="btn-toolbar dr-btn-toolbar">
      	 <button name="Submit2" type="button" class="btn btn-default btn-sm" id="batchDelDown" >
		<span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除</button>
    <!--<button class="btn btn-primary btn-sm" type="button"
	onclick="window.location='clazz!input.action?flag2=wxold<s:if test='flag=="group"'>&flag=group</s:if>'">
	<span class="glyphicon glyphicon-plus"></span>
	<s:if test='flag=="group"'>新增集体班级</s:if><s:else>新增自主班级</s:else>
	</button>
	<button class="btn btn-primary btn-sm" type="button"
	onclick="window.location='clazz!input.action?flag2=wxold&flag3=noprograms<s:if test='flag=="group"'>&flag=group</s:if>'">
	<span class="glyphicon glyphicon-plus"></span>
	<s:if test='flag=="group"'>新增非项目集体班级</s:if><s:else>新增非项目自主班级</s:else>
	</button>
    -->
    </div>
    </s:if>

<table class="table table-bordered dr-table-default">
<thead>
	<tr>
	    <s:if test="isOther!='other'">
		<th width="3%"><input type="checkbox" id="checkboxall" /></th>
		</s:if>
		<th width="10%">班级名称<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="6%">班级代码<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="12%">培训项目<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="13%">项目阶段<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">班主任<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="8%">学员数<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="7%">班级状态<!--<i class="dr-sorting-desc"></i>--></th>
		<s:if test="CurTenantID!=null"><th width="15%">来自</th></s:if>
		<s:if test="isOther!='other'">
		<th width="15%">操作</th>
		</s:if>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="page.result" status="stat">
		<tr>
		    <s:if test="isOther!='other'">
			<td><input type="checkbox" name="ids" value="${id}" /></td>
			</s:if>
			<td>${name}</td>
			<td>${code}</td>
			<td>${programName}</td>
			<td>${phaseName}</td>
			<td><s:if test="header==null">&nbsp;</s:if><s:property value="header.name"/></td>
			<td>${studentCount}</td>
			<td>${StateStr}</td>
			<s:if test="CurTenantID!=null"><td>${currentTenant.name}</td></s:if>
			<s:if test="isOther!='other'">
			<td >  
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('clazz!minfo.action?id=${Id}&flag2=wxold<s:if test="selfClass=='false'">&flag=group</s:if>')">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;管理
				</button>
			  <s:if test="model==1">
				<s:if test="mspushId!=null&&mspushId!=''">
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('${ctx}/mspush/manage/mspush!tosendhome.action?id=${mspushId}')">
				<span class="glyphicon glyphicon-send"></span>&nbsp;发送短信
				</button> 
				</s:if><s:else>
				<button class="btn btn-primary btn-sm" type="button" onclick="window.open('${ctx}/mspush/manage/mspush!sendClassStudent.action?clazzId=${Id}')">
				<span class="glyphicon glyphicon-envelope"></span>&nbsp;发送短信
				</button> 
				</s:else>
				
			</s:if>
			<a href="#"
				onclick="delRecord('${ctx }/clazz/manage/clazz!delete.action?ids=${id}&flag2=wxold<s:if test='flag=="group"'>&flag=group</s:if>');">
				<button class="btn btn-default btn-sm" type="button">
					<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
				</button></a>
			</td>
			</s:if>
		</tr>
	</s:iterator>
  </tbody>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>
</body>
</html>