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
function getTeachContent(obj){			 
  	var teachcontentId = obj.value;	 
  	 b_IframeLevel("${ctx}/train/manage/programs!requireclazzs.action?teachcontentId="+teachcontentId+"&getclazz=1",850,800,tst);			 
  /* 	window.location.href="${ctx}/train/manage/programs!requireTeachContent.action?teachcontentId="+teachcontentId+"&getclazz=1"
	if(teachcontentId) {
		$.post("${ctx}/train/manage/programs!requireTeachContent.action?teachcontentId="+teachcontentId+"&getclazz=1",function(){
			//window.location.href="${ctx}/train/manage/programs!requireTeachContent.action?teachcontentId="+teachcontentId+"&getclazz=1";		
			alert(22)
		});
	} 
  */
  	function tst(){location.reload();}
} 
</script>
</head>
<body>   
    <form class="form-horizontal" id="inputForm" name="inputForm" action="programsdetail!saveClazz.action?clazzId=${clazzId}&id=${id}" method="post"">               	 				  				 								  		 		 
	 
		  <%-- <div style="display:inline;width:150px;float:left" class="form-group" id="validate_area" >			  
			<s:select cssClass="form-control" cssStyle="width:120px;display:inline;height:35px;line-height:25px;" onchange="getTeachContent(this)" list="teachcontentlist" theme="simple" 
					listKey="id" listValue="name" name="name" value="id" headerKey="" headerValue="--选择教学内容--"   id="tc" />	   													    		 
		</div>  
		  <div style="display:inline;width:120px;float:left;margin-left:50px" class="form-group">																 				 								 
            <s:select  cssClass="form-control" cssStyle="width:120px;display:inline;height:35px;line-height:25px;" list="{}" 
                   listKey="id" listValue="name"  name="name" value="clazz"   id="clazzId" theme="simple" headerKey=""  headerValue="-选择班级-" />	                        
		</div>	 --%>
		<div style="display:inline;width:120px;float:left;margin-left:300px"  ><button class="btn_primary" onclick="$('#inputForm').submit();">确认审核</button>
		</div>
		<div id="show">			 												
			<table class="table table-bordered dr-table-bordered">
			<thead>
				<tr>				     					 
					<th width="10%" >学员姓名</th>					 
					<th width="14%">所在班级</th>
					<th width="10%">课程</th>
					<th width="5%" align="center">审核状态</th>					 
				</tr>
			</thead>
				<tbody>
				 <s:iterator value="ucclist" status="stat"  > 
			    <tr>			       					 
					<td class="white_bg"><s:property value="programs" /></td>					 
					<td class="white_bg">&nbsp;<s:property value="clazz.name" /></td>
					<td class="white_bg">&nbsp;<s:property value="course.name" /></td>
					<s:if test="normal==false">
					<td class="white_bg">&nbsp;未审核</td>	
					</s:if><s:else>
					<td class="white_bg">&nbsp;已审核</td>
					</s:else>  	  						 		 			 		       						    
				</tr>
				   </s:iterator>  
				  <tr>			       					 
					<td class="white_bg">aaaa</td>					 
					<td class="white_bg">&nbsp;bbbbb</td>
					<td class="white_bg">&nbsp;cccccc</td>
					<td class="white_bg">&nbsp;未审核</td>					 		       						    
				</tr>
				<tr>			       					 
					<td class="white_bg">aaaa</td>					 
					<td class="white_bg">&nbsp;bbbbb</td>
					<td class="white_bg">&nbsp;cccccc</td>
					<td class="white_bg">&nbsp;未审核</td>					 		       						    
				</tr>
				<tr>			       					 
					<td class="white_bg">aaaa</td>					 
					<td class="white_bg">&nbsp;bbbbb</td>
					<td class="white_bg">&nbsp;cccccc</td>
					<td class="white_bg">&nbsp;未审核</td>					 		       						    
				</tr>  --> 
			  
				</tbody>			 
			</table>
		</div>	 	 	 
</form> 
</body>
</html>

 