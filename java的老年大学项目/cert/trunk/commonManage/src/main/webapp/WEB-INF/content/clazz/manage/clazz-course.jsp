<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<%
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
%> 
<!--<link href="${staticurl}/js/colorbox/colorbox.css" type="text/css" rel="stylesheet" />
<script src="${staticurl}/js/colorbox/jquery.colorbox.js" type="text/javascript"></script>

-->
<title>选择课程-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script type="text/javascript">
	function removeoutplancourse() {
		 b_confirm('确定要删除教学内容外课程吗?', function() {
			window.location.href='clazz!removeoutplancourse.action?id=${id}&teachContentId=${teachContentId}&flag=${flag}';
		   });
	}

	function removecourse() {
		 b_confirm('确定要删除课程吗?', function() {
			window.location.href='clazz!removecourse.action?id=${id}&planid=${planid}';
		   });
	}
  
	function tst(){location.reload();}
	
	function addoutteachcontentcourse(){
		b_IframeLevel("${ctx}/clazz/manage/clazz!addOutTeachContentcourse.action?teachContentId=${teachContentId}&id=${id}",850,800,tst);
	}

	function addcourse(){
		b_IframeLevel("${ctx}/clazz/manage/clazz!addcourse.action?teachContentId=${teachContentId}&id=${id}",850,800,tst);
	}

		   
    $(document).ready(function(){
        
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
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
	
				  // $("#deleteForm").submit();
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
		function createClazz(falg){
			if(falg){
				alert("完成建班后请及时修改班级测验日程");
			}
			$("#saveForm").submit();
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
<s:if test="flag2=='wxold'">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="input-group" name="menu" />
	<jsp:param value="clazz" name="bigmenu" />
    </jsp:include>
</s:if>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">班级管理</a>
</li>
<li class="active">选择课程</li>
</ol>

<div class="dr-page-header">
<h3>
选择课程
</h3>
</div>
<hr/>
<div class="panel panel-default">
<s:if test="flag=='group'||flag3=='noprograms'">
<div class="dr-steps clearfix">
   <ul role="tablist">
      <li class="first done" role="tab"><a href="#"><span class="current-info">current step: </span><span class="number">1.</span><span class="title">填写班级信息</span></a></li>
      <li class="current" role="tab"><a href="#"><span class="number">2.</span><span class="title">课程选择</span></a></li>
	  <s:if test="flag=='group'">
      <li class="last" role="tab"><a href="#"><span class="number">3.</span><span class="title">导入学员</span></a></li>
      <li class="last" role="tab"><a href="#"><span class="number">4.</span><span class="title">费用结算和管理设置</span></a></li>
	  </s:if>
      </ul>
</div>
</s:if>
<s:else>
<div class="dr-steps clearfix">
   <ul role="tablist">
      <li class="first done" role="tab"><a href="#"><span class="current-info">current step: </span><span class="number">1.</span><span class="title">填写班级信息</span></a></li>
      <li class="current" role="tab"><a href="#"><span class="number">2.</span><span class="title">课程选择</span></a></li>
   </ul>
</div>   
</s:else>


<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<form id="mainForm" name="mainForm" action="item.action" method="post">
<input type="hidden" name="page.pageNo" id="pageNo"
	value="${page.pageNo}" /> <input type="hidden" name="page.orderBy"
	id="orderBy" value="${page.orderBy}" /> <input type="hidden"
	name="page.order" id="order" value="${page.order}" />
</form>

<form name="saveForm" id="saveForm" action="clazz!savecourse.action"
	method="post">
	<input type="hidden" name="randomtemp" value="${clazzDTO.randomNo}" id="randomNo"/>
	<input type="hidden" name="flag" value="${flag}"/>
	<input type="hidden" name="flag2" value="${flag2}"/>
	<input type="hidden" name="flag3" value="${flag3}"/>
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="programId" value="${programId}" />
	<input type="hidden" name="teachContentId" value="${teachContentId}" />
	<input type="hidden" name="clazzid" value="${clazzid}" />
	<input type="hidden" name="isdown" value="${isdown}" />
	
    <div class="btn-toolbar dr-btn-toolbar" style="width: 98%;margin-left: 1%">
	    <div class="btn-group">
	    <s:if test="flag3!='noprograms'&&teachContentId!=null">
		    <button class="btn btn-primary btn-sm"  name="Submit3" type="button"  onclick="addoutteachcontentcourse()">
		    <span class="glyphicon glyphicon-plus"></span>	
		          添加计划外课程
		    </button>
	    </s:if>
	    <s:else>
		    <button class="btn btn-primary btn-sm"  name="Submit3" type="button"  onclick="addcourse()">
		    <span class="glyphicon glyphicon-plus"></span>	
		          添加课程
		    </button>
	    </s:else>
	    </div>
	    
	    <div class="btn-group">
	    <s:if test="flag3!='noprograms'&&teachContentId!=null">
	    	<button class="btn btn-default  btn-sm" onclick="removeoutplancourse();" name="Submit3" type="button">
		    <span class="glyphicon glyphicon-trash"></span>
		           删除所有计划外课程
		    </button>
	    </s:if>
	    <s:else>
	    	<button class="btn btn-default  btn-sm" onclick="removecourse();" name="Submit3" type="button">
		    <span class="glyphicon glyphicon-trash"></span>
		           删除所有课程
		    </button>
	    </s:else>
	    </div>
	</div>
<div class="panel panel-default">
<table class="table table-bordered dr-table-bordered" style="width: 98%;margin-left: 1%">
	<tr>
		<td width="30%" class="tt_line">课程名称</td>
		<td width="15%" class="tt_line">课程属性</td>
		<td width="15%" class="tt_line">教学方式</td>
		<td width="15%" class="tt_line">学分</td>
		<td width="20%" class="tt_line">选课情况</td>
	</tr>
	<s:if test="teachContentId!=null">
		<s:iterator value="teachContentCourseList" status="stat">
			<tr>
				<td class="white_bg">${courseName}</td>
				<td class="white_bg">${coursePropString}</td>
				<td class="white_bg">${offlineType}</td>
				<td class="white_bg">${studylength}</td>
	
				<td class="white_bg">
				<input type="hidden" name="propids" value="${courseProp}" /> 
				<input type="hidden" name="modelids" value="${courseModel}" /> 
				<s:if test="courseProp==2">
				<input type="checkbox" name="ids" class="cxcheckbox0" value="${courseId}" checked="checked" onclick="alert('必修课不能取消!');return false;" style="display: none;"/>已选
				</s:if><s:else>
				<input checked="checked" type="checkbox" name="ids" value="${courseId}" />选课
				</s:else>
				</td>
			</tr>
		</s:iterator>
	</s:if>	
		<s:iterator value="outTeachContentCourses" status="stat">
			<tr>
				<td >${course.name}</td>
				<td >${coursePropString}</td>
				<td class="white_bg">${course.offlineType}</td>
				<td >${course.studylength}</td>
				<td >
				<input type="hidden" name="propids" value="${courseProp}" />
				<input type="hidden" name="modelids" value="${course.courseModel}" /> 
				
				<input checked="checked" type="checkbox" name="ids" value="${course.id}" />选课</td>
			</tr>
		</s:iterator>
</table>
</div>
<div class="panel-footer">
<div class="row">
<div class="col-md-12">
<button class="btn btn-default pull-left" type="button" onclick="window.location='clazz!input.action?id=${id}&programId=${programId}&teachContentId=${teachContentId}&flag2=${flag2}&flag=${flag}&randomtemp=${clazzDTO.randomNo}&isdown=${isdown}'">
<span class="glyphicon glyphicon-step-backward"></span>
 上一步
</button>

<s:if test="flag=='group'">
<button class="btn btn-primary pull-right" type="submit">
下一步
<span class="glyphicon glyphicon-step-forward"></span>
</button>
</s:if><s:else>
<button class="btn btn-primary pull-right" type="button" onclick="createClazz(${iffocus})">
<span class="glyphicon glyphicon-ok"></span>
完成
</button>
</s:else>

</div>
</div>
</div>
</form>
</div>
</div>

<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->

</body>
</html>