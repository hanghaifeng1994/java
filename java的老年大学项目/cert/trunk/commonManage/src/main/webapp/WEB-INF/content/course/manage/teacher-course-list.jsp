<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 辅导老师辅导的课程 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<title>辅导老师辅导的课程<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script type="text/javascript">
	 //选择一项操作动作
     function operaction(obj,id){
   		var hrefvalue = obj.value;
   		var target = "_blank";
   		if(hrefvalue=='')
   			return;
   		openUrl(hrefvalue,target,id);
     }
	function up(obj){
		$(obj).hide();
		var down= $(obj).next();
		down.show();
		var first=$(obj).next().next();
		first.hide();
		var last = first.next();	
		last.show();	
	}

	function down(obj){
		var first=$(obj).next();
		var last= first.next();
		first.show();
		last.hide();
		var prev=$(obj).prev();
		prev.show();
		$(obj).hide()
		
	}
 
	//function show(obj){
	//		$(obj).hide();
	//		var s= $(obj).next()
	//		s.show();
	//}

	//function hidediv(obj){
	//	$(obj).hide();
	//	var f= $(obj).prev()
	//	f.show();
	//}

   // window.onload = function showdiv(){
    //	$("strHref").onclick = function(){
	//		//document.getElementById("hpn").style.display = "block";
	//		if( $(obj).style.display == "none"){
	//			document.getElementById("hpn").style.display = "block";	
	//			document.getElementById("strHref").innerHTML = "收起";	
	//		}else{
	//		document.getElementById("hpn").style.display = "none";
	//		document.getElementById("strHref").innerHTML = "更多选项";
	//		}
	//	}
	//}
  

</script>
</head>
<body>
<center>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<div class="dr-wrapper">
<section id="main" role="main">
<div class="dr-container-fluid">

<!--正文开始-->
<div class="dr-page-header" style="text-align: left;">
<h3>
我管理的课程
</h3>
</div>
<hr/>
<s:if test="page.totalCount!=0">
<div class="dr-searchbar" style="text-align: left;">
  <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/course/manage/teacher-course.action" method="post">
	<input type="hidden" name="page.pageNo" id="pageNo" value="1" />
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	<input type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />	
	 <div class="form-group">
	    <label>课程名称</label>
	      <input name="course.name" type="text" class="form-control input-sm" value="${course.name}" />
	    </div>
	    <div class="form-group">
	    <label>课程代码</label>
	      <input name="course.serialNo" type="text" class="form-control input-sm" value="${course.serialNo}"/>
	      </div>
	    <div class="form-group">
	    <button name="Submit" class="btn btn-default btn-sm" type="submit">
        <span class="glyphicon glyphicon-search"></span>
                        搜索
        </button>
	  </div>
  </form>
</div>

<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12">
<table class="table table-bordered dr-table-default">
    <tr>
      <th width="2%">课程名称</th>
      <th width="2%">课程代码</th>
      <th width="2%">学分</th>
      <th width="3%">辅导的在学学员数</th>
      <th width="4%">辅导的班级</th>
      <th width="2%">操作</th>
    </tr>
    <s:iterator value="page.result">
    <tr>
      <td>${name}</td>
      <td>${serialNo}</td>
      <td>${studylength}</td>
      <td>${studyNum}</td>
      
      
  
       <td>
        <!--<p class="slide">
            <a href="javascript:showdiv();"  id="strHref" class="btn-slide" onclick="showdiv()">全部班级+</a></p>
       -->
       <div  align="right" onclick="up(this);" style="width: 20%;float: right"><p><a href="javascript:showdiv();">展开</a></p></div>
       <div align="right" style="display: none;width: 20%;float: right" onclick="down(this);"><p><a href="javascript:showdiv();">收起</a></p></div>
       <div id="pn" align="left" style="width: 80%;float: left"  onclick="show(this);"> 
        <s:iterator value="clazzs" status="stat">
        		<!--<s:if test="#stat.index<1">
        			<p><a href="javascript:showdiv();"> ${name}</a></p>
        		</s:if>
        		--><s:if test="#stat.index==0">
        			<p> ${name}<a href="javascript:showdiv();"></a></p>
        		</s:if>
        </s:iterator> 
        
       </div>
       <div id="hpn" align="left" style="display: none;width: 80%;float: left" onclick="hidediv(this);">
       		<s:iterator value="clazzs" status="stat">
        			<p>${name}<a href="javascript:showdiv();"></a></p>
        		</s:iterator>
       </div> 
          	<!--<a target="_blank" href="${ctx }/course/manage/teacher-course!learningcount.action?clazzid=${id}&curRoleId=${curRoleId}">查看${name}的学情统计</a>&nbsp;&nbsp;&nbsp;(<a target="_blank" href="<common:prop name="fang.main.url" propfilename="sysconfig.properties"/>/fang/fang!index.action?fangId=${fangId}">进入研修坊</a>)<br></br>
       ${name}
        -->
 </td>
      
      <td>
        <s:if test="newlp">
		<a href="#" onclick="lpoperaction(${id})">课程辅导</a>
		</s:if>
		<s:else>
		<select name="oper" onchange="operaction(this,${id})">
			<option value="">选择操作</option>		
			<option value="course!examPaperRule.action?id=${id}">课程测验管理</option>
			<option value="course!examination.action?id=${id}">测验阅卷</option>
			<option value="course!addHomeWorks.action?id=${id}">作业布置</option>
			<option value="course!readHomeWorks.action?id=${id}">作业批阅</option>				
		</select>
		</s:else>
		<s:if test="#request.iswxeduopen=='true'">
			<%-- <a href="${ctx }/clazzcourse/manage/clazzcourse!teacherQuestion.action?courseId=${id}">在线提问</a> --%>
			<a href="${ctx }/teacherquestion/manage/onlineteacherquestion.action?objectId=${id}&type=2">在线提问</a>
		</s:if>
	</td>
    </tr>
    </s:iterator>
  </table>
<div class="dr-panel-footer">
<%@ include file="/common/turnpage.jsp"%>
</div>
</div>
</div>
</div>
</s:if>
<s:else>
<div class="panel panel-default">
<div class="panel-body row">
<div class="col-md-12" style="align:center;">
<h1 align="center"><font color="#333333">您暂无管理的课程</font></h1>
</div>
</div>
</div>
</s:else>
</div>
</section>
</div>
<!--正文结束-->
<!--模拟打开新窗口 -->
<script type="text/javascript">
//选择一项操作动作
function lpoperaction(id){
   var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
		var hrefvalue = "2";
		if(hrefvalue=="")return;
		var target = "_blank";

		if(hrefvalue=="1" || hrefvalue=="2" || hrefvalue=="3"){
			$("#outItemId").val(id);
			$("#roleType").val(hrefvalue);			
			hrefvalue = hreflp;
		}
		openlpUrl(hrefvalue,target,id);
}

function openUrl(url,target,id){
	$("#newwindowFrom").attr("action",url);
	$("#newwindowFrom").attr("target",target);
	$("#newwindowId").val(id);
	$("#newwindowFrom").submit();
}
function openlpUrl(url,target,id){
	$("#lpwindowFrom").attr("action",url);
	$("#lpwindowFrom").attr("target",target);
	$("#lpwindowFrom").submit();
}

</script>

<form id="newwindowFrom" action="" method="get" target="_blank">
<input name="id" id="newwindowId" type="hidden"/> 
</form>

<form id="lpwindowFrom" action="" method="get" target="_blank">
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="${tenantsCode}"/>
<input name="teacherName" id="teacherName" type="hidden" value="${user.name}"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="${user.username}"/>           
</form>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</center>
</body>
</html>
