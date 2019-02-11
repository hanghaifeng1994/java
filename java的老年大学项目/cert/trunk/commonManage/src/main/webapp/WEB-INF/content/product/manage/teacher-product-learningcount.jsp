<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 辅导老师辅导的书籍 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<s:set name="user" value="@com.drcl.zhisou.ahstudy.util.UserUtils@getCurUser()"></s:set>
<title>班级学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>

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
学情统计(${clazz.name})
</h3>
</div>
<hr/>
 
<form id="mainForm" name="mainForm" action="${ctx}/product/manage/teacher-product!learningcount.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page3.pageNo" id="pageNo"	value="${page3.pageNo}" />
	<input type="hidden" name="page3.orderBy" id="orderBy" value="${page3.orderBy}" />
	<input type="hidden" name="page3.order" id="order" value="${page3.order}" />
	<input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="clazzid" id="clazzid" value="${clazz.id}" />
</form>  
 
<form name="deleteForm" id="deleteForm" action="${ctx}/product/manage/teacher-product!learningcount.action" method="GET">
<div class="panel panel-default " >
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="5%">序号</th>
		<th width="15%">学员账号</th>
		<th width="8%">姓名</th>
		<th width="8%">性别</th>
		<th width="10%">单位</th>
		<th width="10%">地区</th>
		<th width="10%">书籍学时（分钟）</th>
		<s:if test="type==0">
			<th width="8%">学习成绩</th>
		</s:if>
		<th width="10%">作业已提交</th>
		<th width="10%">作业已评</th>
		<th width="10%">作业未提交</th>
		<s:if test="type==0">
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
		
		<s:if test="type==0">
			<th width="10%">测验成绩</th>
			<th width="10%">最终成绩</th>
		</s:if>
		
		<s:if test="type==0"></s:if>
		<s:else>
			<th width="8%">所得学时</th>
			<th width="8%">考核要求学时</th>
		</s:else>
	</tr>
	<s:iterator value="page3.result" status="stat">
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			<td>${unit}</td>
			<td>${canton}</td>
			<td>${studytime}</td>	
			<s:if test="type==0">		
				<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>
			<s:if test="type==0">
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
			
			<s:if test="type==0">
				<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
				<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="type==0"></s:if>
			<s:else>
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
			</s:else>
			
		</tr>
	</s:iterator>
</table>
 <s:set name="page" value="page3" scope="request"/>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</section>
</div>
<!--正文结束-->
<!--模拟打开新窗口 -->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</center>
</body>
</html>
