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
function idcardcheck(){
    var idcard = $.trim($("#idcard").val());
    var checkidcard=idCardNoUtil.checkIdCardNo(idcard);
    if(idcard!=""){
    if(!checkidcard)  
      {  
          alert("身份证输入不合法");  
          return  false;  
       } 
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
<section id="main" role="main">
<div class="dr-container-fluid">
<%@ include file="/common/clazzHeader.jsp"%>
<%@ include	file="/common/tagtitle.jsp"%>
<div class="tab-content dr-tabs-panel">
<div class="dr-searchbar">
<form id="mainForm" name="mainForm" action="headerclazz!countAll.action" method="post" class="form-inline dr-form-inline">
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="tabnum" id="tabnum" value="2" />
    <div class="form-group">
    <s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
	<span style="margin-left: 30px;">完成人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=1"><font
		style="color: #11B1CD;">${qualifiedCount}</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;未完成人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=0"><font
		style="color: #11B1CD;">${unqualifiedCount}</font></a></span>
    </s:if>
    <s:else>
	<span style="margin-left: 30px;">合格人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=1"><font
		style="color: #11B1CD;">${qualifiedCount}</font></a>&nbsp;&nbsp;|&nbsp;&nbsp;不合格人数：<a href="headerclazz!learningcountAll.action?headerClazzId=${headerClazzId }&tabnum=1&curRoleId=${curRoleId}&qualified=0"><font
		style="color: #11B1CD;">${unqualifiedCount}</font></a></span>
    </s:else>
	</div>
 </form>  
 </div>  
  <form name="deleteForm" id="deleteForm" action="headerclazz!countAll.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="5%">序号</th>
		<th width="12%">班级</th>
		<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
		<th width="8%">完成人数</th>
		<th width="8%">未完成人数</th>
		</s:if>
        <s:else>
        <th width="8%">合格人数</th>
		<th width="8%">不合格人数</th>
        </s:else>
	</tr>
	<s:iterator value="qualifiedVOs" status="stat">		 
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<td>${name}</td>
			<td>${qualified}</td>
			<td>${unqualified}</td>
		</tr>
	</s:iterator>
</table>
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
