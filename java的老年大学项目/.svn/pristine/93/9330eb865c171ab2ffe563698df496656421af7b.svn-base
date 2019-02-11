<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
 <head>
 <title>意见反馈管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
 <%@ include file="/common/admin_meta.jsp" %>
 <script src="${ctx}/layer/layer.js"></script>
<script type="text/javascript">	
$(document).ready(function(){    
      	 
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();   
		 
   $("#checkboxall").click(function(){
	     
        if($("#checkboxall").attr("checked")=="checked"){
        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
        }else {
          $("input[name='ids']").removeAttr("checked");
         }
   });
	
       //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/user/manage/tenant!batchDelete.action";
			       if(!checkSelect()) {
			    	   b_alertx("没有可操作记录,请勾选");
			            return false;
			       } 
		    	   b_confirmx('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
		    	   });
		   }); 	
		 
     });

	 function checkSelect() {
		var flag1 = false;
		$("input[name='ids']:checked").each(function(){
			flag1 = true;
		}); 
		return flag1;
	}
		
     function  checkupload(){
          var upload = $("#upload").val();
          if(upload == "" || upload == null){
           b_alertx("上传文件不能为空！");
           }else {
        	   $("#mainForm").submit();   
           }
     } 
     
     function detial(id){
  		$.ajax({    
  		    url:'${ctx}/feedback/manage/feedback!detial.action?id='+id,  
  		    type:'post',    
  		    dataType:'json',    
  		    success:function(data) {
  		    	layer.open({
  		    	  type: 1 //Page层类型
  		    	  ,area: ['500px', '300px']
  		    	  ,title: '意见反馈详细'
  		    	  ,shade: 0.6 //遮罩透明度 
  		    	  ,maxmin: true //允许全屏最小化
  		    	  ,anim: 2 //0-6的动画形式，-1不开启 
  		    	  ,content: '<div style="padding-left:30px;padding-top:13px;height:50px; line-height: 22px; background-color: #FDFDFD;  font-weight: 400;">反馈人:  '+data.userName+'</div><div style="padding-left:30px;padding-top:13px;line-height: 22px; background-color: #F6F6F6;  font-weight: 300;word-wrap: break-word; word-break: normal;height:80%; padding-right:30px;">反馈内容:  '+data.content+'</div>'
  		    	    
  		    	});     
  		     }     
  		});
    } 
</script>
  </head>
  <body>
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<div class="dr-wrapper">
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="feedbacktlist"  name="menu" />
	<jsp:param value="feedback" name="bigmenu" />
    </jsp:include>
  <section id="main" role="main"> 
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">意见反馈管理</a></li>
     <li class="active">意见反馈列表</li>
    </ol>
   <div class="dr-page-header">
     <h3>反馈内容列表</h3>
   </div>
   <hr>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<form id="mainForm" name="mainForm" action="feedback.action" class="form-inline dr-form-inline" method="post" enctype="multipart/form-data">
   <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
   <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
   <input type="hidden" name="page.order" id="order" value="${page.order}" />

   <div class="dr-searchbar">
   <!--
   <div class="form-group">
     <label>代码</label>
     <input class="form-control input-sm" type="text"  name="filter_LIKES_code" id="code" value="${param['filter_LIKES_code']}">
   </div>
   -->
   <div class="form-group">
      <label>反馈内容</label>
      <input class="form-control input-sm" type="text" name=filter_LIKES_content value="${param['filter_LIKES_content']}">
   </div>  
   
   
   
   <div class="form-group">
   <button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
	<span class="glyphicon glyphicon-search"></span>
	搜索
	</button>
	</div>
   </div>
</form>


<form name="deleteForm" id="deleteForm" action="feedback.action" method="post">
  <div class="panel panel-default">
<!--       <div class="btn-toolbar dr-btn-toolbar">
    <span class="fl">
	    <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
        </button>
        <button class="btn btn-primary btn-sm" type="button"  name="Submit3" onclick="window.location='tenant!input.action'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增租户
        </button>
        </span>
  </div> 
 -->


  <table class="table table-bordered dr-table-bordered" style="font-size: 14px;">
   <thead>
    <tr>
      <td width="5%" class="tt_noline"><input type="checkbox" id="checkboxall"/></td>
      <th width="40%">反馈内容</th>
      <th width="20%" >时间</th>
      <th width="15%" >反馈人</th>    
      <th width="20%">操作</th>
    </tr>
    </thead>
   <tbody>
    <s:iterator value="page.result" status="stat">
    <tr>
      <td><input type="checkbox" name="ids" value="${feedbackId}" /></td>
      <td><common:cut len="30" string="${content}"></common:cut></td>
      <td><s:date name="pubDate" format="yyyy-MM-dd"></s:date></td>
      <td>${userName}</td>
      <td>
      <a onclick="detial(${feedbackId});"  class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-edit"></span>&nbsp;查看详情</a>
      </td>
    </tr>
    </s:iterator> 
    </tbody>
  </table>
  <%@ include file="/common/turnpage.jsp"%> 
</div>
</form>
</div>
<!--dr-container-fluid结束-->
<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
</section>
</div><!--dr-wrapper结束-->
	    	
</body>
</html>