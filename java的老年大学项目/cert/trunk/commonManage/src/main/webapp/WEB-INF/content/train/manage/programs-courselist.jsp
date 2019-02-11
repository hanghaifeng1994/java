<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>	
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else>江苏省无锡教育公共服务平台</s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/table.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){ 		
});
function changeCourse(obj){			 
  	var coursecode = obj.value;	 	 
  	//alert(coursecode+"--"+${shzxuserid}+"--"+${shzxcourseid}+"---"+${shzxclazzid})
  	// b_IframeLevel("${ctx}/train/manage/programs!changeCourse.action?coursecode="+coursecode+"&shzxuserid="+${shzxuserid}+"&oldcourseid="+${shzxcourseid}+"&shzxclazzid="+${shzxclazzid},300,800,tst);			    
  	//function tst(){location.reload();}
} 
</script>
</head>
<body>   
    <form class="form-horizontal" id="inputForm" name="inputForm" action="${ctx}/train/manage/programs!changeCourse.action?shzxuserid=${shzxuserid}&oldcourseid=${shzxcourseid}&shzxclazzid=${shzxclazzid}&uccid=${uccid}&programId=${programId}" method="post">               	 				  				 								  		 		 	 
		 <div style="display:inline;width:250px;float:left" class="form-group" id="validate_area" >			  
			<s:select cssClass="form-control" cssStyle="width:150px;display:inline;height:35px;line-height:25px;" onchange="changeCourse(this)" list="coursevolist" theme="simple" 
					listKey="code" listValue="name" name="coursecode" value="code" headerKey="" headerValue="--请选择课程--"   id="tc" />	   													    		 
			<button style="margin-left:20px" class="btn btn-primary btn-sm" type="submit" name="Submit32">
     			<span class="glyphicon glyphicon-ok"></span>
     					 &nbsp;确定
   			</button> 
		</div> 			     		 		 	 	  
</form> 
</body>
</html>

