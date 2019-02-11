<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<script type='text/javascript'>
$(document).ready(function() {	
	
	});
	var startYear=2010;
	var endYear=2030;
	var YearObj=$("#selectYear");//$("#selectYear")document.getElementById
	onload=function(){
		for(i=startYear;i<=endYear;i++){
			YearObj.options.add(new Option(i,i));
			YearObj.options[YearObj.options.length-1].selected=1;
		}
	}
</script>
</head>
<body>
<form id="dataForm" action="${ctx}/train/manage/teachcontent!saveyear.action" method="post" class="form-inline dr-form-inline">
	<input type="hidden" name="id" value="${id}"></input>
  	<input type="hidden" name="programId" value="${programId}"></input>
  	<input type="hidden" name="teachContentCourseId" value="${teachContentCourseId}"></input> 	
  	<div class="dr-searchbar"> 
  	<div class="form-group">
     <label>课程年度:</label>
       <%-- <input  name="year" value="${year}" class="form-control input-sm" /> --%>
        <s:select style="width:80px" list="{'2010','2011','2012','2013','2014','2015','2016','2017','2018','2019','2020','2021','2022','2023','2024','2025' }" 
        name="year" id="selectYear" value="year" theme="simple" ></s:select>           
     </div>
  	<button class="btn btn-primary btn-sm" type="submit" name="Submit32">
     <span class="glyphicon glyphicon-ok"></span>
      &nbsp;保存
   </button> 
   </div>
</form>
</body>
</html>