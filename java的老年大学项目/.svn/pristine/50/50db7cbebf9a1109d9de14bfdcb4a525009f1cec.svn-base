<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>项目学员查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script type="text/javascript">
    $(document).ready(function(){
    	changePrograms();
    	changePlan();
       if(${export}){
    	   $('#exportbut').hide();
    	   checkover();
       }
	   $("#checkboxall").click(function(){
		     $("input[name='ids']").attr("checked",$(this).attr("checked"));
	   });
		
       //验证批量删除文章的列表非空与否
	   $(".batchDelDown").click(
		   function(){
			   var oaction = document.getElementById("deleteForm").action;
			   document.getElementById("deleteForm").action="${ctx }/user/manage/student!batchDelete.action";
		       if(!checkSelect()) {
		            alert("没有可操作记录,请勾选");
		            return false;
		       } 
		       if(!confirm('您确定要进行此操作吗?')) return  false;

			   $("#deleteForm").submit();
			   document.getElementById("deleteForm").action = oaction;
	   }); 	
		 
     });
		 
	 function checkSelect() {
		var flag = false;
		$("input[name='ids']:checked").each(function(){
			flag = true;
		}); 
		return flag;
	}

	 function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
	function checkover(){
		$.ajax({
	        type: "POST",
	        url: "programs!isFinishExport.action",
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

	function changePrograms(){
		var programsid = $('#programsid').val();
		if(programsid) {
			$.getJSON("${ctx}/related/teachplan!plans.action",{"programsid":programsid},function(data) {
				$("#planid option[value!='']").remove();
				var teachplan = eval(data.teachplan);
				if(teachplan.length == 0) return;
				for(var i = 0 ;i < teachplan.length ; i++) {
					if('${planid}'==teachplan[i].value)
						$("#planid").append("<option selected='selected' value='"+teachplan[i].value+"'>"+teachplan[i].label+"</option>");
					else
						$("#planid").append("<option value='"+teachplan[i].value+"'>"+teachplan[i].label+"</option>");
				}
			});
		}else {
			$("#planid option[value!='']").remove();
		}
	}
	function changePlan(){
		var planid =  $('#planid').val();
		if(planid == '')
			planid = '${planid}'
		if(planid) {
			$.getJSON("programs!clazzs.action",{"planid":planid},function(data) {
				$("#clazzid option[value!='']").remove();
				if(data.length == 0) return;
				for(var i = 0 ;i < data.length ; i++) {
					if('${clazzid}'==data[i].value)
						$("#clazzid").append("<option selected='selected' value='"+data[i].value+"'>"+data[i].label+"</option>");
					else
						$("#clazzid").append("<option value='"+data[i].value+"'>"+data[i].label+"</option>");
				}
			});
		}else {
			$("#clazzid option[value!='']").remove();
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
	<jsp:param value="studentsExport" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
      <li> <span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
      <li><a href="#" >
                  <s:if test="#request.isqlxx=='true'">
                			课程学习管理
                		</s:if>
                		<s:else>
                			   培训项目管理
                		</s:else>
      </a></li>
      <li class="active">
       <s:if test="#request.isqlxx=='true'">
                			课程学员查询
                		</s:if>
                		<s:else>
                			   项目学员查询
                		</s:else>
      </li>
    </ol>
   <div class="dr-page-header">
     <h3>
            <s:if test="#request.isqlxx=='true'">
                			课程学员查询
                		</s:if>
                		<s:else>
                			   项目学员查询
                		</s:else>
     </h3>
   </div>
   <hr/>
<form id="mainForm" name="mainForm" action="programs!students.action" method="post" class="form-inline dr-form-inline">
<div class="dr-searchbar">
	<input type="hidden" name="page2.pageNo"	id="pageNo" value="1" />
	<input type="hidden" name="page2.orderBy" id="orderBy" value="${page2.orderBy}"/>
	<input type="hidden" name="page2.order" id="order" value="${page2.order}"/>
	<input type="hidden" name="export" value="false" id="export"/>
<div class="form-group">
	<label class="">培训项目</label>
	<s:select list="allPrograms" listKey="id" listValue="name" cssClass="form-control input-sm" value="programId" name="programId" theme="simple" headerValue="--选择培训项目--" headerKey=""></s:select>
</div>
<div class="form-group">
	<label class="">单位</label>
	<input name="unit" class="form-control input-sm" value="${unit}" />
</div>
<div class="form-group">
	<label class="">姓名</label>
	<input name="name" class="form-control input-sm" value="${name}" />
</div>
<div class="form-group">
	<label class="">身份证</label>
	<input name="idcard" class="form-control input-sm" value="${idcard}" />
</div>
<div class="form-group">
	<label class="">是否完成</label>
	<s:select list="#{'true':'完成','false':'未完成'}" listKey="key" listValue="value" cssClass="form-control input-sm"
		name="finished" theme="simple" headerValue="--全部--" headerKey="" 
		value="finished"></s:select>
</div>
    
<div class="form-group">
	<button name="Submit5" class="btn btn-default btn-sm" onclick="$('#export').val('false');$('#pageNo').val('1');document.mainForm.submit();">
		<span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
</div>   
</div>
</form>

<form name="deleteForm" id="deleteForm" action="programs!delete.action" method="post">
<div class="panel panel-default">
   <div class="btn-toolbar dr-btn-toolbar">
       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
      onclick="exportexcel()"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
    <label class="ml10" id="downLoad" style="display: none">
		<a href="" target="_blank">项目学员导出excel文件下载</a>
	</label>
    </span>
   </div>
   <s:set  name="page" value="page2" scope="request"/>   
  <table class="table table-bordered dr-table-bordered" style="font-size:14px">
  	<thead>
    <tr>
      <th width="10%">用户名</th>
      <th width="9%">姓名</th>
      <th width="12%">身份证号</th>
      <th width="13%">项目名称</th>
      <th width="7%">是否完成</th>
	  <th width="14%">单位</th>
	  <th width="8%">在学课程数</th>
	  <th width="8%">完成课程数</th>    
	  <th width="8%">操作</th>   
    </tr></thead>
    <s:iterator value="page2.result" status="stat">
    <tr>    
      <td >&nbsp;${username}</td>
      <td >&nbsp;${name}</td>
      <td >&nbsp;${idcard}</td>
      <td >&nbsp;${programDTO.name}</td>
      <td >&nbsp;<s:if test='finished'>完成</s:if><s:else>未完成</s:else></td>
      <td >&nbsp;${unit}</td>
      <td >&nbsp;${learningCourseCount}</td>
      <td >&nbsp;${finishedCourseCount}</td>
      <td><a target="_blank" href="${ctx}/user/manage/student!info.action?id=${userId}" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;详细</a></td>
    </tr>
    </s:iterator>
  </table>
   <%@ include file="/common/turnpage.jsp"%>
   </div>
</form>

</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
</body>
</html>