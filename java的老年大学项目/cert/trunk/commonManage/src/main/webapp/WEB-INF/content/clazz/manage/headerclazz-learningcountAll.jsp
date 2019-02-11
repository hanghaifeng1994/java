<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 班主任管理的班级主页面 -->
<s:set name="user" value="@com.drcl.zhisou.ahstudy.util.UserUtils@getCurUser()"></s:set>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>班级学员查询-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script src="${staticurl}/js/idcard.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
		if(${export}){
	   $('#exportbut').hide();
	   checkover();
    }
}); 

function exportexcel(){
	 $('#export').val('true');
	 document.mainForm.submit();
}
function checkover(){
	$.ajax({
        type: "POST",
        url: "${ctx}/clazz/manage/headerclazz!isFinishExportClazzAllAcount.action",
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
<section id="main" role="main">
<div class="dr-container-fluid">
<%@ include file="/common/clazzHeader.jsp"%>
<%@ include	file="/common/tagtitle.jsp"%>
<div class="tab-content dr-tabs-panel">
<div class="dr-searchbar">
<form id="mainForm" name="mainForm" action="headerclazz!learningcountAll.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page3.pageNo" id="pageNo"	value="${page3.pageNo}" />
	<input type="hidden" name="page3.orderBy" id="orderBy" value="${page3.orderBy}" />
	<input type="hidden" name="page3.order" id="order" value="${page3.order}" />
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="export" value="false" id="export"/>
	<input type="hidden" name="tabnum" id="tabnum" value="1" />
	<input type="hidden" name="ordervalue" id="ordervalue" value="${ordervalue}" />
    <input type="hidden" name="ordercolumn" id="ordercolumn" value="${ordercolumn}" />
    <input type="hidden" name="phaseId" id="phaseId" value="${phaseId}" />
     <div class="form-group">
<label>用户名</label>
 <input name="username" type="text" class="form-control input-sm" value="${username}" />
</div>
 <div class="form-group">
<label>姓名</label>
 <input name="name" type="text" class="form-control input-sm" value="${name}" />
</div>
 <div class="form-group">
<label>单位</label>
 <input name="unit" type="text" class="form-control input-sm" value="${unit}" />
</div>
<div class="form-group">
	  	<label>所属班级</label>
	  	<s:select list="clazzs" listKey="id" value="clazzId" listValue="name" theme="simple"  headerValue="--全部--"
			headerKey=""  cssClass="form-control" name="clazzId"></s:select>
</div>
<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
<div class="form-group"><label>是否完成</label> <s:select
	list="#{'0':'未完成','1':'完成'}" listKey="key" listValue="value"
	name="qualified" theme="simple" headerValue="--全部--" headerKey=""
	value="qualified" cssClass="form-control input-sm"></s:select></div>
	<div class="form-group"><label>待考状态</label> <s:select
	list="#{'0':'未待考','1':'已待考'}" listKey="key" listValue="value"
	name="daikao" theme="simple" headerValue="--全部--" headerKey=""
	value="daikao" cssClass="form-control input-sm"></s:select></div>
</s:if>
<s:else>
<div class="form-group"><label>是否合格</label> <s:select
	list="#{'0':'不合格','1':'合格'}" listKey="key" listValue="value"
	name="qualified" theme="simple" headerValue="--全部--" headerKey=""
	value="qualified" cssClass="form-control input-sm"></s:select></div>
</s:else>
<div class="form-group">
<button name="Submit" class="btn btn-default btn-sm" type="submit" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
 </form>  
 </div>  
  <form name="deleteForm" id="deleteForm" action="headerclazz!learningcountAll.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<div class="btn-toolbar dr-btn-toolbar">
				 <s:if test="#request.iswxeduopen=='false'">
				       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
				         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
					    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
					    <label class="ml10" id="downLoad" style="display: none">
							<a href="" target="_blank">班主任总学情导出文件下载</a>
						</label>
					    </span>  
				 </s:if>  
	<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
	<span style="margin-left: 30px;"><a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=1">完成人数：<font
		style="color: #11B1CD;">${qualifiedCount}</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;未完成人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=0"><font
		style="color: #11B1CD;">${unqualifiedCount}</font></a></span>
    </s:if>
    <s:else>  
	<span <s:if test="#request.iswxeduopen=='false'">style="margin-left: 30px;"</s:if>>合格人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=1"><font
		style="color: #11B1CD;">${qualifiedCount}</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;不合格人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=0"><font
		style="color: #11B1CD;">${unqualifiedCount}</font></a></span>
    </s:else>
</div>
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
	<th width="5%">序号</th>
		<th width="12%">学员账号</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="10%">单位</th>
		<s:if test="#request.iswxeduopen=='false'">
			<th width="10%">地区</th>
		</s:if>
		<th width="10%">所属班级</th>
		<s:if test="programsCheckDTO.hasKcxx">	
		<th width="10%">课程学时（分钟） <a href="#" id="order-studytime" onclick="countAllOrder('studytime')">
				<c:if test="${ordercolumn eq 'studytime'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'studytime'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:else>
				<th width="10%">课程学时（分钟） <a href="#" id="order-studytime" onclick="countAllOrder('studytime')">
				<c:if test="${ordercolumn eq 'studytime'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'studytime'}">
				  		--
				</c:if>
			</a></th>
		</s:else>
		
		
		<s:if test="programsCheckDTO.hasscore">	
		<th width="8%">学习成绩 <a href="#" id="order-studyscore" onclick="countAllOrder('studyscore')">
				<c:if test="${ordercolumn eq 'studyscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'studyscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:else>
				<th width="8%">学习成绩 <a href="#" id="order-studyscore" onclick="countAllOrder('studyscore')">
				<c:if test="${ordercolumn eq 'studyscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'studyscore'}">
				  		--
				</c:if>
			</a></th>
		</s:else>
		<s:if test="programsCheckDTO.hasKhzy">
			<th width="10%">作业提交待批阅 <a href="#" id="order-homesignuped" onclick="countAllOrder('homesignuped')">
				<c:if test="${ordercolumn eq 'homesignuped'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'homesignuped'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">作业已评 <a href="#" id="order-homemarked" onclick="countAllOrder('homemarked')">
				<c:if test="${ordercolumn eq 'homemarked'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'homemarked'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">作业未提交 <a href="#" id="order-homenosignup" onclick="countAllOrder('homenosignup')">
				<c:if test="${ordercolumn eq 'homenosignup'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'homenosignup'}">
				  		--
				</c:if>
			</a></th>		 
			<th width="10%">作业总成绩 <a href="#" id="order-homescoresum" onclick="countAllOrder('homescoresum')">
				<c:if test="${ordercolumn eq 'homescoresum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'homescoresum'}">
				  		--
				</c:if>
			</a></th>
		 </s:if>
		 <s:else>
		 	<th width="10%">作业总成绩 <a href="#" id="order-homescoresum" onclick="countAllOrder('homescoresum')">
				<c:if test="${ordercolumn eq 'homescoresum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'homescoresum'}">
				  		--
				</c:if>
			</a></th>
		 </s:else>
		<s:if test="clazzDTO.beforeTestClazz">
			<th width="10%">是否完成后测 <a href="#" id="order-afterstudentTest" onclick="countAllOrder('afterstudentTest')">
				<c:if test="${ordercolumn eq 'afterstudentTest'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'afterstudentTest'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
	 	<s:if test="programsCheckDTO.hasXxglgjjh">	
			<th width="10%">研修成果已提交 <a href="#" id="order-trainresultsigned" onclick="countAllOrder('trainresultsigned')">
				<c:if test="${ordercolumn eq 'trainresultsigned'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'trainresultsigned'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">研修成果成绩 <a href="#" id="order-trainresultscore" onclick="countAllOrder('trainresultscore')">
				<c:if test="${ordercolumn eq 'trainresultscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'trainresultscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:if test="programsCheckDTO.hasLtyt">
			<th width="10%">研修讨论发帖数 <a href="#" id="order-traindiscussposts" onclick="countAllOrder('traindiscussposts')">
				<c:if test="${ordercolumn eq 'traindiscussposts'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'traindiscussposts'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">研修讨论考核成绩 <a href="#" id="order-traindiscussscore" onclick="countAllOrder('traindiscussscore')">
				<c:if test="${ordercolumn eq 'traindiscussscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'traindiscussscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:if test="programsCheckDTO.hasYxrz">
			<th width="10%">研修日志发布数 <a href="#" id="order-trainjournalsignsum" onclick="countAllOrder('trainjournalsignsum')">
				<c:if test="${ordercolumn eq 'trainjournalsignsum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'trainjournalsignsum'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">研修日志成绩 <a href="#" id="order-trainjournalscore" onclick="countAllOrder('trainjournalscore')">
				<c:if test="${ordercolumn eq 'trainjournalscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'trainjournalscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:if test="programsCheckDTO.hasYdjb">		
			<th width="10%">阅读简报个数 <a href="#" id="order-readnewslettersum" onclick="countAllOrder('readnewslettersum')">
				<c:if test="${ordercolumn eq 'readnewslettersum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'readnewslettersum'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">简报阅读成绩 <a href="#" id="order-readnewsletterscore" onclick="countAllOrder('readnewsletterscore')">
				<c:if test="${ordercolumn eq 'readnewsletterscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'readnewsletterscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:if test="programsCheckDTO.hasKccy">					 
			<th width="10%">测验成绩 <a href="#" id="order-examscore" onclick="countAllOrder('examscore')">
				<c:if test="${ordercolumn eq 'examscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'examscore'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:else>
			<th width="10%">测验成绩 <a href="#" id="order-examscore" onclick="countAllOrder('examscore')">
				<c:if test="${ordercolumn eq 'examscore'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'examscore'}">
				  		--
				</c:if>
			</a></th>
		</s:else>
		 <s:if test="programsCheckDTO.hasscore">	
			<th width="10%">最终成绩 <a href="#" id="order-score" onclick="countAllOrder('score')">
				<c:if test="${ordercolumn eq 'score'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'score'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">是否合格 <a href="#" id="order-qualified" onclick="countAllOrder('qualified')">
				<c:if test="${ordercolumn eq 'qualified'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'qualified'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:elseif test="programsCheckDTO.hashour">	
			<th width="8%">所得学时 <a href="#" id="order-learnhour" onclick="countAllOrder('learnhour')">
				<c:if test="${ordercolumn eq 'learnhour'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'learnhour'}">
				  		--
				</c:if>
			</a></th>
			<th width="8%">考核要求学时 <a href="#" id="order-qualifiedlearnhour" onclick="countAllOrder('qualifiedlearnhour')">
				<c:if test="${ordercolumn eq 'qualifiedlearnhour'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'qualifiedlearnhour'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">是否完成 <a href="#" id="order-qualified" onclick="countAllOrder('qualified')">
				<c:if test="${ordercolumn eq 'qualified'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'qualified'}">
				  		--
				</c:if>
			</a></th>
		</s:elseif>
		<s:else>
		<th width="8%">所得学时 <a href="#" id="order-learnhour" onclick="countAllOrder('learnhour')">
				<c:if test="${ordercolumn eq 'learnhour'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'learnhour'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">是否完成 <a href="#" id="order-qualified" onclick="countAllOrder('qualified')">
				<c:if test="${ordercolumn eq 'qualified'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'qualified'}">
				  		--
				</c:if>
			</a></th>
			<th width="10%">是否待考 <a href="#" id="order-daikao" onclick="countAllOrder('daikao')">
				<c:if test="${ordercolumn eq 'daikao'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'daikao'}">
				  		--
				</c:if>
			</a></th>
		
		</s:else>
		<%-- <th width="5%">序号</th>
		<th width="12%">学员账号</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="10%">单位</th>
		<th width="10%">地区</th>
		<th width="10%">所属班级</th>
		<th width="10%">课程学时（分钟）</th>
		<s:if test="#request.iswxeduopen=='true'">
		<th width="8%">学习成绩</th>
		</s:if>
		<th width="10%">作业提交待批阅</th>
		<th width="10%">作业已评</th>
		<th width="10%">作业未提交</th>
		<s:if test="#request.iswxeduopen=='true'">
		<th width="10%">作业总成绩</th>
		</s:if>
		<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
				
			</s:if>
			<s:else>
				<th width="10%">研修成果已提交</th>
				<th width="10%">研修成果成绩</th>
				<th width="10%">研修讨论发帖数</th>
				<th width="10%">研修讨论考核成绩</th>
				<th width="10%">研修日志发布数</th>
				<th width="10%">研修日志成绩</th>
				<th width="10%">阅读简报个数</th>
				<th width="10%">简报阅读成绩</th>
			</s:else>
			<th width="10%">测验成绩</th>
		<s:if test="#request.iswxeduopen=='true'">
			<th width="10%">最终成绩</th>
			<th width="10%">是否合格</th>
		</s:if>
		<s:else>
			<th width="8%">所得学时</th>
			<th width="8%">考核要求学时</th>
			<th width="10%">是否完成</th>
		</s:else> --%>
	</tr>
	<s:iterator value="page3.result" status="stat">		 
		<tr>
		<td><s:property value="#stat.index+1"></s:property></td>
			<td>
			<s:if test="#request.iswxeduopen=='false'">
				${username}
			</s:if>
			<s:else>  
				${hideusername}
			</s:else>
			</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${unit}</td>
			<s:if test="#request.iswxeduopen=='false'">
				<td>${canton}</td>
			</s:if>
			<td>${clazzname}</td>
			
			<s:if test="programsCheckDTO.hasKcxx">
			<td>${studytime}</td>
			</s:if>
			<s:else>
			<td>${studytime}</td>
			</s:else>
			
			<s:if test="programsCheckDTO.hasscore">	
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if><s:else>
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:else>
			<s:if test="programsCheckDTO.hasKhzy">
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>			 
			<td>${homescoresum}</td>
			</s:if>
			<s:else>
			<td>${homescoresum}</td>
			</s:else>
			<s:if test="clazzDTO.beforeTestClazz">
				<td><s:if test="afterstudentTest">完成</s:if><s:else>未完成</s:else></td>
			</s:if>
			<s:if test="programsCheckDTO.hasXxglgjjh"> 
			<td>${trainresultsigned}</td>
			<td><fmt:formatNumber type="number" value="${trainresultscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasLtyt">
			<td>${traindiscussposts}</td>
			<td><fmt:formatNumber type="number" value="${traindiscussscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasYxrz">
			<td>${trainjournalsignsum}</td>
			<td><fmt:formatNumber type="number" value="${trainjournalscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasYdjb">	
			<td>${readnewslettersum}</td>
			<td><fmt:formatNumber type="number" value="${readnewsletterscore}"  maxFractionDigits="1"/></td>	
			</s:if> 
			<s:if test="programsCheckDTO.hasKccy">
			<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:else>
			<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			</s:else>
			<s:if test="programsCheckDTO.hasscore">	
				<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			    <td><s:if test="qualified">合格</s:if><s:else>不合格</s:else></td>
			</s:if>
			<s:elseif test="programsCheckDTO.hashour">	
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
				<td><s:if test="qualified">完成</s:if><s:else>未完成</s:else></td>
			</s:elseif><s:else>
				<td>${learnhour}</td>
				<td><s:if test="qualified">完成</s:if><s:else>未完成</s:else></td>
				<td><s:if test="daikao">已待考</s:if><s:else>未待考</s:else></td>
			   
			</s:else>
			<%-- <td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${unit}</td>
			<td>${canton}</td>
			<td>${clazzname}</td>
			<td>${studytime}</td>
			<s:if test="#request.iswxeduopen=='true'">
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>
			<s:if test="#request.iswxeduopen=='true'">
			<td>${homescoresum}</td>
			</s:if>
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
				
			</s:if>
			<s:else>
				<td>${trainresultsigned}</td>
			<td><fmt:formatNumber type="number" value="${trainresultscore}"  maxFractionDigits="1"/></td>
			<td>${traindiscussposts}</td>
			<td><fmt:formatNumber type="number" value="${traindiscussscore}"  maxFractionDigits="1"/></td>
			<td>${trainjournalsignsum}</td>
			<td><fmt:formatNumber type="number" value="${trainjournalscore}"  maxFractionDigits="1"/></td>
			<td>${readnewslettersum}</td>
			<td><fmt:formatNumber type="number" value="${readnewsletterscore}"  maxFractionDigits="1"/></td>	
			</s:else>
				<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			<s:if test="#request.iswxeduopen=='true'">
				<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			    <td><s:if test="qualified">合格</s:if><s:else>不合格</s:else></td>
			</s:if>
			<s:else>
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
				<td><s:if test="qualified">完成</s:if><s:else>未完成</s:else></td>
			</s:else> --%>
		</tr>
	</s:iterator>
</table>
 <s:set name="page" value="page3" scope="request"/>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</div>
</section>
</div>
<!--正文结束-->

<script type="text/javascript">
<!--
//选择一项操作动作
function lpoperaction(id){
   var hreflp = '<common:prop name="lp3.url" propfilename=""></common:prop>/backend';
		var hrefvalue = "3";
		if(hrefvalue=="")return;
		var target = "_blank";

		if(hrefvalue=="1" || hrefvalue=="2" || hrefvalue=="3"){
			$("#outItemId").val(id);
			$("#roleType").val(hrefvalue);			
			hrefvalue = hreflp;
		}
		openlpUrl(hrefvalue,target,id);
}

function openlpUrl(url,target,id){
	$("#lpwindowFrom").attr("action",url);
	$("#lpwindowFrom").attr("target",target);
	$("#lpwindowFrom").submit();
}
function countAllOrder(column){
	$("#ordercolumn").val(column);
	<c:if test="${ordervalue eq 'desc'}">
		$("#ordervalue").val("asc");
	</c:if>
	<c:if test="${ordervalue ne 'desc'}">
		$("#ordervalue").val("desc");
	</c:if>
	$("#mainForm").submit();
}
//-->
</script>

<form id="lpwindowFrom" action="" method="get" target="_blank">
<input name="outItemId" id="outItemId" type="hidden"/>
<input name="roleType" id="roleType" type="hidden"/>
<input name="tenantsCode" id="tenantsCode" type="hidden" value="wxedu"/>
<input name="teacherName" id="teacherName" type="hidden" value="${user.name}"/>
<input name="teacherUsername" id="teacherUsername" type="hidden" value="${user.username}"/>           
</form>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
