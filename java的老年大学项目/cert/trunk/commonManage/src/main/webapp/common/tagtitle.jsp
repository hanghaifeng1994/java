<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<% 
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
String tabnums = request.getParameter("tabnum");
if(tabnums==null || "".equals(tabnums)){
	tabnums = "0";
}
request.setAttribute("tabnums",tabnums);
%> 
<div class="bs-example">
		
<ul class="nav nav-tabs" id="tab">
	<s:if test="headerClazzId!=null">
	<li class="<c:if test="${tabnums==0 }">active</c:if>"><a
		href="headerclazz!bulletin.action?headerClazzId=${headerClazzId}&tabnum=0&curRoleId=${curRoleId}&phaseId=${phaseId}">班级公告管理</a></li>
		<li class="<c:if test="${tabnums==1 }">active</c:if>"><a
			href="headerclazz!learningcount.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&phaseId=${phaseId}">班级学员学情统计</a></li>
		<li class="<c:if test="${tabnums==2 }">active</c:if>"><a
			href="headerclazz!students.action?headerClazzId=${headerClazzId}&tabnum=2&curRoleId=${curRoleId}&phaseId=${phaseId}">班级学员查询</a></li>
		<s:if test="#request.isahstudyopen=='true'">
			<li class="<c:if test="${tabnums==3 }">active</c:if>"><a
				href="headerclazz!examStudents.action?headerClazzId=${headerClazzId}&tabnum=3&curRoleId=${curRoleId}&phaseId=${phaseId}">待考学员查询</a></li>
		</s:if>
		<li class="<c:if test="${tabnums==4 }">active</c:if>"><a
			href="headerclazz!bgimage.action?headerClazzId=${headerClazzId}&tabnum=4&curRoleId=${curRoleId}&phaseId=${phaseId}">班级背景图管理</a></li>
		<c:if
			test="${curHeaderClazz.clazz.fangId!=null&&curHeaderClazz.clazz.fangId!=0}">
			<li><a target="_blank"
				href="<common:prop name="fang.main.url" propfilename="sysconfig.properties"/>/fang/fang!index.action?fangId=${curHeaderClazz.clazz.fangId}">研修坊</a></li>
		</c:if>
	</s:if>
	<s:else>
	<li class="<c:if test="${tabnums==0 }">active</c:if>"><a
		href="headerclazz!bulletinAll.action?headerClazzId=${headerClazzId}&tabnum=0&curRoleId=${curRoleId}&phaseId=${phaseId}"><s:if test="#request.iswxeduopen=='true'">班级公告</s:if><s:else>所有班级公告管理</s:else></a></li>
		<li class="<c:if test="${tabnums==1 }">active</c:if>"><a
			href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&phaseId=${phaseId}"><s:if test="#request.iswxeduopen=='true'">学员学情</s:if><s:else>所有班级学员学情统计</s:else></a></li>
			<li class="<c:if test="${tabnums==3 }">active</c:if>"><a
			href="headerclazz!countUnitAll.action?headerClazzId=${headerClazzId }&tabnum=3&curRoleId=${curRoleId}&phaseId=${phaseId}"><s:if test="#request.iswxeduopen=='true'">单位学情</s:if><s:else>所有单位学员学情统计</s:else></a></li>
			<s:if test="#request.isahstudyopen=='true'">
			<li class="<c:if test="${tabnums==2 }">active</c:if>"><a
			href="headerclazz!countAll.action?headerClazzId=${headerClazzId }&tabnum=2&curRoleId=${curRoleId}&phaseId=${phaseId}"><s:if test="#request.iswxeduopen=='true'">班级学情</s:if><s:else>所有班级完成人数统计</s:else></a></li>
			</s:if>
			<s:else>
			<li class="<c:if test="${tabnums==2 }">active</c:if>"><a
			href="headerclazz!countAll.action?headerClazzId=${headerClazzId }&tabnum=2&curRoleId=${curRoleId}&phaseId=${phaseId}"><s:if test="#request.iswxeduopen=='true'">班级学情</s:if><s:else>所有班级合格人数统计</s:else></a></li>
			</s:else>
	</s:else>
</ul>
</div>