<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>课程列表<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
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
        if(${export}){
 		   $('#exportbut').hide();
 		   checkover();
 	    }
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
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!delete.action";
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
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!publish.action";
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
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!unpublish.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			 });
	   $("#batchhide").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!dohide.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
	   }); 	

	   $("#batchunhide").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!dounhide.action";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       
			       b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
			 });
	   $("#courseissued").click(
			   function(){
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       
			       b_confirm('您确定要进行此操作吗?', function() {
				       var courseIds=null;
			    	   $("input[name='ids']:checked").each(function(){
							if(courseIds==null)
								courseIds = $(this).val();
							else courseIds += "," + $(this).val();
						})
						b_IframeLevel("${ctx}/course/manage/course!issued.action?isIssue=true&tabFlag=isMy&courseIds="+courseIds,550,400,tst);
		    	   })
		}); 

	   $("#cancelissued").click(
			   function(){
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?', function() {
				       var courseIds=null;
			    	   $("input[name='ids']:checked").each(function(){
							if(courseIds==null)
								courseIds = $(this).val();
							else courseIds += "," + $(this).val();
							b_IframeLevel("${ctx}/course/manage/course!issued.action?isIssue=false&tabFlag=isMy&courseIds="+courseIds,550,400,tst);
						})
		    	   })
		}); 

	    $("#courseReceive").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/course!courseReceive.action";
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
    function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
    function checkover(){
		$.ajax({
	        type: "POST",
	        url: "${ctx}/course/manage/course!isFinishExportNew.action",
	        data: {
	        	"threadName": '${threadName}',"fileName":'${fileName}'
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.value=="false"){
					 $('#downLoad').show();
					 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
					 $('#font').hide();
					 $('#exportbut').show();
				 }else{
					 setTimeout('checkover()',3000);
			     } 
	        }
		});
	}
	
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
   		if(hrefvalue=='course!input.action')
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
   		if(hrefvalue=='course!input.action')
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
		 b_IframeLevel("${currentTenant.doname}/course/manage/course!addCourseCatP.action?checkCats="+checkCats+"&tenantId="+tenantId,400,500,tst);
	}
	 function tst(){
		 //var c = window.frames['mainiframe'].document.getElementById('checkCats').value; 
		 window.frames['mainiframe'].saveCat();
		 //alert(c)
	};
	 function saveCat(checkCats){
		 $.ajax({
		        type: "POST",
		        url: "${ctx}/course/manage/course!catName.excsec",
		        data: {
		        	"checkCats": checkCats,
				},
		        success: function(data) {
					$("#catname").val(data.value);
					$("#checkCats").val(checkCats);
		        }
			});
	}

	 function tst(){location.reload();}
	 function issued(id){
		 b_IframeLevel("${ctx}/course/manage/course!issued.action?tabFlag=isMy&id="+id,550,400,tst);
	}
	 function changeOneCat(obj){
			var tenantid = $(obj).val();
			//根据一级栏目获得二级栏目
				if(tenantid) {
					$.post("${ctx }/course/manage/course!getOneCat.action",{"tenantId":tenantid,"tabFlag":"other"},function(data) {
						$("#courseonecategory option[value!='']").remove();
						var category = eval(data);
						$("#courseonecategory option[value!='']").remove(); 
						if(category.length == 0) return;
						for(var i = 0 ;i < category.length ; i++) {
							$("#courseonecategory").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
						} 
						$("#coursetwocategory option[value!='']").remove();
						$("#coursethreecategory option[value!='']").remove();
					});
				}else {
					$("#courseonecategory option[value!='']").remove(); 
					$("#coursetwocategory option[value!='']").remove();
					$("#coursethreecategory option[value!='']").remove();
				}
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
	<jsp:param value="courselist" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
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
<a href="#">课程资源库管理</a>
</li>
<li class="active">课程列表</li>
</ol>

<div class="dr-page-header">
<h3>
课程列表
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
 	<li class="<s:if test="tabFlag=='isMy'">active</s:if>" ><a href="course.action?tabFlag=isMy">我的课程 </a></li>
 	<li class="<s:if test="tabFlag=='canUseing'">active</s:if>"><a href="course!courseTenant.action?tabFlag=canUseing">可使用课程</a></li>
 	<li class="<s:if test="tabFlag=='noValidate'">active</s:if>"><a href="course.action?tabFlag=noValidate">待接收课程</a></li>
    <li class="<s:if test="tabFlag=='other'">active</s:if>"><a href="course.action?tabFlag=other">租户课程</a></li>
</ul>
<div class="tab-content dr-tabs-panel">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/course/manage/course.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" id="onecat" name="onecat" value="${onecat}" />
<input type="hidden" id="twocat" name="twocat" value="${twocat}" />
<input type="hidden" id="threecat" name="threecat" value="${threecat}" />
<input type="hidden" name="tabFlag" value="${tabFlag}" />
<input type="hidden" name="export" value="false" id="export"/>
<input type="hidden" name="hideCourse" value="true" id="hideCourse"/>
<s:if test="tabFlag!='isMy'">
<div class="form-group">
  <label>租户</label>
  <s:select list="tenantLists" listKey="id" onchange="changeOneCat(this)"
	value="tenantId" listValue="name" theme="simple"
	cssClass="form-control" name="tenantId" headerValue="--选择租户--"
	headerKey=""></s:select>
</div> 
</s:if>
<!--<div class="form-group">
<label>课程分类：</label>
<input id="catname" name="checkCatName" class="form-control input-sm" onfocus="selectCat()"
				value="${checkCatName}"/>
<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
</div>
-->
<div class="form-group">
<label>一级分类</label>
<s:select theme="simple" list="oneCategories" cssClass="form-control"
				listKey="id" listValue="name" id="courseonecategory" value="onecat"
				headerKey="" headerValue="选择一级分类"/>
</div>
<div class="form-group">
<label>二级分类</label>
<s:select list="twoCategories" listKey="id" cssClass="form-control"
				listValue="name" theme="simple" id="coursetwocategory" headerKey=""
				headerValue="选择二级分类" value="twocat"></s:select>
</div>
<div class="form-group">
<label>三级分类</label>
<s:select list="threeCategories" listKey="id" cssClass="form-control"
				listValue="name" theme="simple" id="coursethreecategory"
				headerKey="" headerValue="选择三级分类" value="threecat"></s:select>
</div>

<div class="form-group">
<label>课程名称</label>
<input name="coursename" type="text" class="form-control input-sm"
				value="${param['coursename']}"/>
</div>
<div class="form-group">
<label>课程代码</label>
<input name="filter_LIKES_serialNo" class="form-control input-sm"
				value="${param['filter_LIKES_serialNo']}"/>
</div>
<div class="form-group">
<label>教学方式</label>
<s:select name="filter_EQB_offline" cssClass="form-control input-sm" list="#{'--全部--':'','线下':'true','线上':'false'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_offline">
		        </s:select>
</div>
<div class="form-group">
<label>学分</label>
<input class="form-control input-sm" type="text" name="filter_GEN_studylength" id="scoreStart" style="width: 50px;"
				value="${param['filter_GEN_studylength']}" maxlength="6"/>
-
<input class="form-control input-sm" type="text" name="filter_LEN_studylength" id="scoreEnd" style="width: 50px;"
				value="${param['filter_LEN_studylength']}" maxlength="6"/>
</div>
<div class="form-group">
<label>课程状态</label>
<s:select name="filter_EQB_hideCourese" cssClass="form-control input-sm" list="#{'显示':'false','隐藏':'true'}" 
                theme="simple" listKey="value" listValue="key" value="#parameters.filter_EQB_hideCourese">
		        </s:select>
</div>

<div class="form-group">
<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
<div class="form-group">
<button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut"  onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
<span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
<label class="ml10" id="downLoad" style="display: none"><a href="" target="_blank">课程列表导出excel文件下载</a></label></span>
</div>
     
</div>
</form>
<form name="deleteForm" id="deleteForm" action="course.action" method="post">
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
<s:if test="curTenantID==null">
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location='course!input.action?tabFlag=isMy'">
<span class="glyphicon glyphicon-plus"></span>
新增课程
</button>
</div>
</s:if>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="courseissued">
<span class="glyphicon glyphicon-share mr5"></span>
课程批量下发
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit3" id="cancelissued">
<span class="glyphicon glyphicon-share mr5"></span>
取消课程下发
</button>
</div>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="batchpublicDown">
<span class="glyphicon glyphicon-bullhorn"></span>
发布课程
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit3" id="batchUnpublicDown">
<span class="glyphicon glyphicon-ban-circle"></span>
取消发布
</button>
</div>

<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="batchhide">
<span class="glyphicon glyphicon-hand-up"></span>
显示课程
</button>
</div>
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit3" id="batchunhide">
<span class="glyphicon glyphicon-hand-down"></span>
隐藏课程
</button>
</div>
<s:if test="#request.iswxeduopen=='true'">
	<div class="btn-group" >
		<a href="<common:prop name="lp3.url" propfilename=""></common:prop>/course/rescourse/list" class="btn btn-primary btn-sm" type="button" target="blank" >
			<span class="glyphicon glyphicon-bullhorn"></span>
				课程资源梳理
		</a>
	</div>
</s:if>

</div>

</s:if>
<s:if test="tabFlag=='noValidate'">
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" id="courseReceive">
<span class="glyphicon  glyphicon-edit"></span>
接收课程
</button>
</div>
</s:if>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
	    <s:if test="tabFlag!='other'">
		<th width="4%"><input type="checkbox" id="checkboxall"/></th>
		</s:if>
		<th width="23%">课程名称<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="10%">课程编码<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="5%">学分<!--<i class="dr-sorting-desc"></i>--></th>
		<th width="8%">辅导教师数<!--<i class="dr-sorting-desc"></i>--></th>
		<s:if test="#request.iswxeduopen=='true'"><th width="8%">学习时长</th></s:if>
		<!--<th width="10%">有效期<i class="dr-sorting-desc"></i></th>
		--><th width="8%">发布状态<!--<i class="dr-sorting-desc"></i>--></th>
		<s:if test="isCommon!=null"><th width="11%">来自</th></s:if>
		<th width="8%">教学方式</th>
		<th width="8%">下发</th>
		<s:if test="tabFlag=='isMy'"><th width="13%">操作</th></s:if>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
		    <s:if test="tabFlag!='other'">
			<td><input type="checkbox" name="ids" id="ids"	value="${id}" /></td>
			</s:if>
			<td title="${name}"><common:cut len="30" string="${name}"/></td>
			<td>&nbsp;${serialNo}</td>
			<td>${studylength}</td>
			<td>${tutorCount}</td>
			<s:if test="#request.iswxeduopen=='true'"><td>${studyTimeStr }</td></s:if>
			
			<!--<td>${formatValidDate}</td>
			--><td><s:if test="published">是</s:if> <s:else>否</s:else></td>
			<s:if test="isCommon!=null"><td>${tenant.name}</td></s:if>
			<td>${offlineType}</td>
			<td><s:if test="isIssue">已下发</s:if><s:else>未下发</s:else></td>
			<s:if test="tabFlag=='isMy'">
			<td>
			<div class="btn-group">
               <button class="btn btn-default btn-sm" type="button" id="oper_${id}" style="padding: 5px 8px;">
                <s:if test="newlp">课程管理</s:if>
                <s:else>旧平台课程管理</s:else>
              </button>
              <button data-toggle="dropdown" class="btn btn-default btn-sm dropdown-toggle" type="button" style="height: 30px;padding: 5px">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
              </button>
                     <ul role="menu" class="dropdown-menu">
                     <s:if test="newlp">
                     <li><a href="#" onclick="newoperaction('course!input.action',${id},'课程属性')">课程属性</a></li>
                     <s:if test="!offline">
                     <li><a href="#" onclick="newoperaction('course!tryreadInput.action',${id},'试读管理')">试读管理</a></li>
                     <li><a href="#" onclick="newoperaction('1',${id},'课程建设')">课程建设</a></li>
                     </s:if>
                    <!--<li><a href="#" onclick="newoperaction('2',${id},'课程辅导')">课程辅导</a></li>
                     <li><a href="#" onclick="newoperaction('3',${id},'课程实施')">课程实施</a></li>
                     --><!--
                     <li class="divider"></li>
                     -->
                     </s:if>
                     <s:else>
                     <li><a href="#" onclick="newoperaction('course!input.action',${id},'课程属性')">课程属性</a></li>
                     <li><a href="#" onclick="newoperaction('course!tryreadInput.action',${id},'试读管理')">试读管理</a></li>
                     <li><a href="#" onclick="newoperaction('course!manageCourse.action',${id},'课程内容管理')">课程内容管理</a></li>
                     <li><a href="#" onclick="newoperaction('course!examSubjectBase.action?id=${id}',${id},'课程题库管理')">课程题库管理</a></li>
                     <li><a href="#" onclick="newoperaction('course!examPaperRule.action?id=${id}',${id},'课程测验管理')">课程测验管理</a></li>
                     <li><a href="#" onclick="newoperaction('course!examination.action?id=${id}',${id},'测验阅卷')">测验阅卷</a></li>
                     <li><a href="#" onclick="newoperaction('course!addHomeWorks.action?id=${id}',${id},'作业布置')">作业布置</a></li>
                     <li><a href="#" onclick="newoperaction('course!readHomeWorks.action?id=${id}',${id},'作业批阅')">作业批阅</a></li>
                     </s:else>                           
                     </ul>
            </div>
			</td>
			</s:if>
		</tr>
	</s:iterator>
</table>
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
<input name="tenantsCode" id="tenantsCode" type="hidden" value="${tenantsCode}"/>
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