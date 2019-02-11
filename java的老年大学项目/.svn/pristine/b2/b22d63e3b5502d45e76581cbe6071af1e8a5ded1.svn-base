<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<script>  
	function removeoutplancourse() {
		 b_confirm('确定要删除添加的课程吗?', function() 
		{
			window.location.href='${ctx }/clazz/manage/clazz!removeoutplancourse.action?id=${id}&planid=${clazz.teachPlan.id}&validate=true';
		});
	}
	function tst(){location.reload();}
    function clid(){
        b_IframeLevel("${ctx}/clazz/manage/clazz!addOutTeachContentcourse.action?teachContentId=${clazzDTO.teachContentId}&id=${id}",850,800,tst);
		//$('#trigger').scojs_modal();
	}
 	function addTeachContentCourse(){
        b_IframeLevel("${ctx}/clazz/manage/clazz!addTeachContentcourse.action?teachContentId=${clazzDTO.teachContentId}&id=${id}",850,800,tst);
 	}
	
	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
		//$("#colorbox1").colorbox({ 
		//	onClosed:function(){window.location.reload(); }, 
		//	width: "860px",
		//	height:"100%", 
		 //   close: "关闭", 
		 //   overlayClose: false,
		 //   href:'${ctx}/clazz/manage/clazz!addoutplancourse.action?planid=${clazz.teachPlan.id}&clazzid=${id}'
           

		//	    });
	})

	function selectAll(checked)
	{
		$(".course_sel").attr("checked",checked.checked);
		barinfo();
	}

	function barinfo()
	{
		$("#selectall").attr("checked",$(".course_sel:checked").length==$(".course_sel").length);
		$("#totalNum_html").html($(".course_sel:checked").length);
		var totalStudyLength=0;
		$(".course_sel:checked").each(function (){
			totalStudyLength+= parseFloat ($(this).attr("rel"));
		})
		$("#totalLen_html").html(totalStudyLength);
	}
	
	$(document).ready(function() {
		barinfo();
		$(".course_sel").click(function(){barinfo();})
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入班级代码"
				} 
			
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});

	function assignTutor(clazzCourseId){
		b_IframeLevel("${ctx}/clazz/manage/clazz!assignTutor.action?clazzCourseId="+clazzCourseId,850,800,tst);
	}
	
	function del(id){
 		var oaction = document.getElementById("mainForm").action;
 		document.getElementById("mainForm").action="${ctx}/clazz/manage/clazz!softDelete.action?clazzCourseId="+id;
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#mainForm").submit();
				document.getElementById("mainForm").action = oaction;
	   	});
 	}
 	
	function iFrameHeight() {
		var ifm= document.getElementById("mainFrame");   
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;  
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight+10;
		}   
	}
	
	function setStudyLength(clazzCourseId){
 		b_IframeLevel("${ctx}/clazz/manage/clazz!setStudyLength.action?clazzCourseId="+clazzCourseId,500,100,tst);
 	}
	
	function setCategory(clazzCourseId){
		b_IframeLevel("${ctx}/clazz/manage/clazz!setCategory.action?clazzCourseId="+clazzCourseId,500,100,tst);
	}
</script>
</head>

<body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">
      <div class="dr-page-header">
     <h3>批量选课</h3>
   </div>
   <hr/>



   <input type="hidden" name="id" value="${id}" />
  <div class="panel panel-default">
   <div class="panel-heading">
    <h3 class="panel-title">
       <s:if test='!clazzDTO.selfClass'>集体</s:if><s:else>自主</s:else>报名班级"${clazzDTO.name}"管理
    </h3>
    <div class="panel-toolbar">
       <ul class="nav nav-tabs pull-right">
	     <li><a href="clazz!minfo.action?id=${id }<s:if test='!clazzDTO.selfClass'>&flag=group</s:if>" >班级信息</a></li>
         <li><a href="clazz!learningcount.action?id=${id }" >班级学情统计</a></li>
	     <!--<s:if test='!clazz.selfClass'>-->
	     
	     <!--</s:if>-->
	     <li class="active"><a href="clazz!mcourse.action?id=${id}">班级课程</a></li>
	     <li><a href="clazz!mstudents.action?id=${id }">班级学员</a></li>
	     <li><a href="clazz!mmanager.action?id=${id }">班主任任命</a></li>
	     <s:if test='!clazzDTO.selfClass'>
		 <li><a href="clazz!mcost.action?id=${id }">费用结算</a></li>
	    </s:if>
       </ul>
    </div>

  </div>
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
<s:if test="clazzDTO.phaseId!=null">
<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
<table  class="table table-bordered dr-table-bordered" style="width="98%"">
  <tbody>
	<tr>
		<th>项目</th>
		<td>${clazzDTO.programName }</td>
	</tr>
	<tr>
		<th>项目阶段</th>
		<td>${clazzDTO.phaseName }</td>
	</tr>
	<s:if test="clazzDTO.teachContentId!=null">
	<tr>
		<th >教学内容</th>
		<td>${clazzDTO.teachContentName} 第${clazzDTO.teachContentVersion}版 </td>
	</tr>
	</s:if>
	</tbody>
</table>
</div>
</s:if>
<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
    <div class="btn-toolbar dr-btn-toolbar">
      <div>
        <span class="fr">
         <button class="btn btn-primary btn-sm" name="Submit3"  onclick="addTeachContentCourse()">
              <span class="glyphicon glyphicon-save"></span>
                                  添加教学内容课程
         </button>
         <button class="btn btn-primary btn-sm" name="Submit3"  onclick="clid()">
              <span class="glyphicon glyphicon-save"></span>
                                  添加教学内容外课程
         </button>
         <button class="btn btn-default btn-sm" onclick="removeoutplancourse();" style="margin-left: 10px;" name="Submit3">
              <span class="glyphicon glyphicon-trash"></span>
                                   删除所有教学内容外课程
         </button>
        </span>
      </div>
 	</div>
 	
<form class="form-inline dr-form-inline" id="mainForm" role="form" name="mainForm" action="clazz!mcourse.action" method="post" >
<input type="hidden" name="classCoursePage.pageNo" id="pageNo" value="${classCoursePage.pageNo}" />
<input type="hidden" name="classCoursePage.orderBy" id="orderBy" value="${classCoursePage.orderBy}" /> 
<input type="hidden" name="classCoursePage.order" id="order" value="${classCoursePage.order}" />
<input type="hidden" name="id" value="${id}" />
<input type="hidden" name="programId" value="${clazzDTO.programId}" />
<table  class="table table-bordered dr-table-bordered" style="width:98%;">
  <thead>
	<tr>
		<th >课程名称</th>
		<th >模块属性</th>
		<th >课程属性</th>
		<th >课程学时</th>
		<th >课程类型</th>
		<s:if test="clazzDTO.clazzUseingType!=0">
		<th >课表设置</th>
		<th >签到情况</th>
		</s:if>
		<th>操作</th>
	</tr>
  </thead>
  <tbody>
  	<s:iterator value="classCoursePage.result" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;${course.courseModelString}</td>
			<td>&nbsp;${coursePropString}</td>
			<td>&nbsp;${studylength }</td>
			<td>&nbsp;${category }</td>
            <s:if test="lazzDTO.clazzUseingType!=0||clazzDTO.offlined">
            <td><a class="btn btn-primary" target="_blank" href="${ctx}/clazz/manage/mcoursearrange.action?clazzid=${clazzDTO.id}&&courseid=${course.id}"><span class="glyphicon glyphicon-edit"></span>&nbsp;开始排课</a></td>
            <td><a class="btn btn-primary" target="_blank" href="${ctx}/clazz/manage/mcoursearrange!showSignin.action?clazzid=${clazzDTO.id}&&courseid=${course.id}"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;查看签到情况</a></td>
			</s:if>
			<td>
				<s:if test="source==0">
				<div class="btn-group">
					<button  name="setButton" class="btn btn-default btn-sm" type="button" onclick="setStudyLength('${id}')">
	                	<span class="glyphicon glyphicon-plus"></span>&nbsp;设置学时
	           		</button>
	           	</div>
	           	<div class="btn-group">
					 <button  name="setButton" class="btn btn-default btn-sm" type="button" onclick="setCategory(${id})">
	                <span class="glyphicon glyphicon-plus"></span>&nbsp;设置课程类型
	           		</button>  
				</div>
	           	</s:if>
				<s:if test="!(source==1&&courseProp==2)">
					<div class="btn-group">
						<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="del('${id}')">
		                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
		           		</button>
					</div>
				</s:if>
								<div class="btn-group">
						<button  name="Submit2" class="btn btn-primary btn-sm" type="button" onclick="assignTutor('${id}')">
		                <span class="glyphicon glyphicon-plus"></span>&nbsp;分配辅导老师
		           		</button>
				</div>
			</td>
		</tr>
	</s:iterator>
    <!--<s:if test="clazzDTO.teachContentId!=null">
	<s:iterator value="mcourses" status="stat">
		<tr>
			<td>&nbsp;${classCourse.course.name}</td>
			<td>&nbsp;${classCourse.course.courseModelString}</td>
			<td>&nbsp;${classCourse.coursePropString}</td>
			<td>&nbsp;${classCourse.course.studylength }</td>
            <s:if test="clazzDTO.clazzUseingType!=0">
            <td><button   onclick="window.open('${ctx}/clazz/manage/mcoursearrange.action?clazzid=${id}&&courseid=${classCourse.course.id}')" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;开始排课</button></td>
			<td><button  onclick="window.open('${ctx}/clazz/manage/mcoursearrange!showSignin.action?clazzid=${id}&&courseid=${classCourse.course.id}')" class="btn btn-primary"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;查看签到情况</button></td>
			</s:if>
			<td>
				<div class="btn-group">
					<button  name="Submit2" class="btn btn-default btn-sm" type="button" onclick="del(${id})">
	                <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
	           		</button>
				</div>
			</td>
		</tr>
	</s:iterator>
	</s:if>
	<s:else>
	  	<s:iterator value="mclasscourses" status="stat">
		<tr>
			<td>&nbsp;${course.name}</td>
			<td>&nbsp;${course.courseModelString}</td>
			<td>&nbsp;${coursePropString}</td>
			<td>&nbsp;${course.studylength }</td>
			<td><input disabled="disabled"  checked="checked" type="checkbox"  rel="${course.studylength }"  name="ids" value="${course.id}" class="course_sel"/>选课</td>
            <td><button  onclick="window.open('${ctx}/clazz/manage/mcoursearrange.action?clazzid=${clazz.id}&&courseid=${course.id}')" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;开始排课</button></td>
			<td><button  onclick="window.open('${ctx}/clazz/manage/mcoursearrange!showSignin.action?clazzid=${clazz.id}&&courseid=${course.id}')" class="btn btn-primary"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;查看签到情况</button></td>
		</tr>
	</s:iterator>
	</s:else>
	-->
	</tbody>
</table>
<s:set name="page" value="classCoursePage" scope="request"></s:set>
<%@ include file="/common/turnpage.jsp"%>
</form>
</div>
<div class="panel panel-default" style="margin: 10px 5px 10px 5px;">
 	<s:if test="!clazz.passed"> 
	   <label style="margin-left: 120px;">
	      <input type="checkbox" id="selectall" name="selectall" class="cxcheckbox0"
	      onclick="selectAll(this);" /><span style="vertical-align: middle">选修课全选</span>
	   </label>
	</s:if>
	<span style="margin-left: 120px;">已选课程
       <span id="totalNum_html"></span> 门，共计 <span id="totalLen_html"></span>学时</span>
 </div>
 <iframe src="" frameborder="0" id="mainFrame" name="mainFrame" onLoad="iFrameHeight()" width="100%" style="overflow-x:none" scrolling="no"></iframe>
</div>
<!--<table width="90%">
	<tr align="center">
		<td></td>
		<td>
		<s:if test="!clazzDTO.passed">
		  <button class="btn btn-primary" type="submit" onclick="return checklimit()" style="margin-right: 10px;">
            <span class="glyphicon glyphicon-ok"></span>
                       保存选课情况
           </button>	
		</s:if>
		<s:if test="clazzDTO.programId==null">
		  <button class="btn btn-primary btn-sm" type="button" name="Submit3"  onclick="clid()">
         <span class="glyphicon glyphicon-save"></span>
                     添加课程
       </button>
          <button class="btn btn-default btn-sm" onclick="removeoutplancourse();" style="margin-left: 10px;" name="Submit3">
              <span class="glyphicon glyphicon-trash"></span>
                                   删除添加的课程
          </button>	
		</s:if>
	   <button class="btn btn-default" type="button" onclick="window.opener=null;window.open('','_self');window.close();">
         <span class="glyphicon glyphicon-remove-circle"></span>
                   关闭
       </button>	
			
			
			
		</td>
	</tr>
</table>
--></div>
</section>
</div>
	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	<jsp:param value="index" name="menu"/>
	</jsp:include>
</body>
</html>
