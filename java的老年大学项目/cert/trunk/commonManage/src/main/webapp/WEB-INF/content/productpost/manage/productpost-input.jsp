<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程评论详细<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
 <%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>

<script>  

	$(document).ready(function() {
 		//聚焦第一个输入框
 		$("#name").focus();
 		//为registerForm注册validate函数
 		$("#form1").validate({
 			rules: {
 			name: {
				required: true,
				maxlength: 20
			}  
			,code:
			{
				required: true
			}
 			},
 			messages: {
 				name: {
 					required: "请输入班级名称",
 					maxlength: "班级名称最多为20个字符,请重新输入"
 				}
				,code:
				{
					required: "请输入班级代码"
				} 
			
 			},
	        errorPlacement: function(error, element) {   
	        if (document.getElementById("error_"+element.attr("name")))  {
	            error.appendTo("#error_"+element.attr("name"));  
	        }
	        else       
	            error.insertAfter(element);   
	        },
	        errorElement: "strong" 
 		});
 	});
</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>

<body>
      <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
  
 <div class="dr-wrapper">
   <section id="main" role="main"> 
     <div class="dr-container-fluid">
    <div class="dr-page-header">
     <h3>课程评论详细</h3>
   </div>
   <hr/>
     
     
 <div class="panel panel-default">
<form id="form1" action="coursePost!save.action" class="form-horizontal">
   <input type="hidden" name="id" value="${id}" />
   <div class="panel-body row">
     <div class="col-md-12">
       <table class="table table-bordered dr-table-default">
          <tbody>
             <tr>
               <th>课程名称</th>
                <td>${courseName}</td>
             </tr>
             <tr>
               <th>评论日期</th>
                <td><s:date name="postdate" format="yyyy.MM.dd" /></td>
             </tr>
             <tr>
               <th>评论人姓名</th>
                <td>${commentUser.name}</td>
             </tr>
             
             <tr>
               <th>内容</th>
                <td>${content}</td>
             </tr>             
          </tbody>
       
       </table>
     </div>
   </div>

  <div class="dr-panel-footer">
  <div class="row">
  <div class="text-center">
    <button class="btn btn-default" type="button" onclick="window.opener=null;window.open('','_self');window.close();">
     <span class="glyphicon glyphicon-remove-circle"></span>
                关闭
   </button>  
   </div>
   </div>
   </div>

</form>
</div>
</div>
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</section>
</div>

</body>
</html>
