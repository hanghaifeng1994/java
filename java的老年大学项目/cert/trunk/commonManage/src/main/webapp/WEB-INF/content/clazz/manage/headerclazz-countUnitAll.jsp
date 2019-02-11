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
<form id="mainForm" name="mainForm" action="headerclazz!countUnitAll.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page3.pageNo" id="pageNo"	value="${page3.pageNo}" />
	<input type="hidden" name="page3.orderBy" id="orderBy" value="${page3.orderBy}" />
	<input type="hidden" name="page3.order" id="order" value="${page3.order}" />
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="export" value="false" id="export"/>
	<input type="hidden" name="tabnum" id="tabnum" value="3" /> 
    <input type="hidden" name="ordervalue" id="ordervalue" value="${ordervalue}" />
    <input type="hidden" name="ordercolumn" id="ordercolumn" value="${ordercolumn}" />
<div class="form-group">
<label>单位</label>  
 <input name="unit" type="text" class="form-control input-sm" value="${unit}" />
</div>
<div class="form-group">
	  	<label>所属班级</label>
	  	<s:select list="clazzs" listKey="id" value="clazzId" listValue="name" theme="simple"  headerValue="--全部--"
			headerKey=""  cssClass="form-control" name="clazzId"></s:select>
</div>
<div class="form-group">
<button name="Submit" class="btn btn-default btn-sm" type="submit" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
 </form>  
 </div>  
<form id="mainForm" name="mainForm" action="headerclazz!countUnitAll.action" method="post" class="form-inline dr-form-inline">
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="tabnum" id="tabnum" value="3" />
 </form>  
 </div>  
 <form name="deleteForm" id="deleteForm" action="headerclazz!countUnitAll.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
		<th width="5%">序号</th>
		<th width="12%">单位</th>
		<th width="12%">总人数<a href="#" id="order-totalnum" onclick="countUnitAllOrder('totalnum')">
				<c:if test="${ordercolumn eq 'totalnum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'totalnum'}">
				  		--
				</c:if>
		</a></th>
		<th width="8%">开始学习人数  <a href="#" id="order-studynum" onclick="countUnitAllOrder('studynum')">
				<c:if test="${ordercolumn eq 'studynum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'studynum'}">
				  		--
				</c:if>
		</a></th>
		<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			<th width="8%">&#8595;完成人数     <a href="#" id="order-finshnum" onclick="countUnitAllOrder('finshnum')">
				<c:if test="${ordercolumn eq 'finshnum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'finshnum'}">
				  		--
				</c:if>
			</a></th>
		</s:if>
		<s:else>
	        <th width="8%">合格人数    <a href="#" id="order-finshnum" onclick="countUnitAllOrder('finshnum')">
	    		<c:if test="${ordercolumn eq 'finshnum'}">
				  	<c:if test="${ordervalue eq 'desc'}">
						&#8595;
					</c:if>
					<c:if test="${ordervalue eq 'asc'}">
						&#8593;
					</c:if>
				</c:if>
				<c:if test="${ordercolumn ne 'finshnum'}">
				  		--
				</c:if>
	        </a></th>
		</s:else>
	</tr>
	<s:iterator value="studentClazzUnitCountDTOs" status="stat">		 
		<tr>
			<td><s:property value="#stat.index+1"></s:property></td>
			<td><a href="#" onclick="openlpUrl('${unit}');">${unit}</a></td>
			<td>${totalnum}</td>
			<td>${studynum}</td>
			<td>${finshnum}</td>
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
function openlpUrl(unit){
	$("#lpwindowFrom-unit").val(unit);
	$("#lpwindowFrom-clazzId").val($("#clazzId").val());
	$("#lpwindowFrom").submit();
}  
function countUnitAllOrder(column){
	$("#ordercolumn").val(column);
	<c:if test="${ordervalue eq 'desc'}">
		$("#ordervalue").val("asc");
	</c:if>
	<c:if test="${ordervalue ne 'desc'}">
		$("#ordervalue").val("desc");
	</c:if>
	$("#mainForm").submit();
}
</script>
<form id="lpwindowFrom" action="headerclazz!learningcountAll.action" method="post" target="_blank">
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
    <input type="hidden" name="export" value="false" id="export"/>
	<input type="hidden" name="tabnum" id="tabnum" value="1" />
    <input type="hidden" name="unit" id="lpwindowFrom-unit"/>
    <input type="hidden" name="clazzId" id="lpwindowFrom-clazzId"/>     
    <input type="hidden" name="unitlike"  value="0"/>
</form>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>
