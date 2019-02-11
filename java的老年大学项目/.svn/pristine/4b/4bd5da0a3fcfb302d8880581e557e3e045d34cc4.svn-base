<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript">
$(document).ready(function(){ 	
	 if($("#success").text()!="")$("#div-success").show();
     if($("#error").text()!="")$("#div-error").show();  
	//审核
	$("#batchShenhe12").click(function(){
	    var idls = "";
		$("input[name='uccid']:checked").each(function(){
			idls += $(this).val()+",";
		}); 
	   var oaction = document.getElementById("inputForm22").action;
	   document.getElementById("inputForm22").action="${ctx }/train/manage/programs!sureSingup.action";
       if(!checkSelect()) {
           // b_alert("没有可操作记录,请勾选");
           $("#shenheinfo").show();
            return false;
       } 
       $.ajax({
           type: "POST",
           dataType:"json",
           url: "${ctx }/train/manage/programs!sureSingup.action?idls="+idls,
           success:function(data){
        	   console.log(data);
        	   if(data.success=="true"){
        		   $("#mainForm").submit();
		       }else{
		    	   $("#shenhe").show();
		    	   $("#mainForm").submit();
			   }
        	   setTimeout(function () {
        		   $("#mainForm").submit();
               }, 3000);  
           }
   		});	
	});
	$("#checkboxall2").click(function(){
		   if($("#checkboxall2").attr("checked")=="checked"){
		     	$("input[name='uccid']").attr("checked",$(this).attr("checked"));
		   }else{
		   		$("input[name='uccid']").removeAttr("checked");
		   } 
		   $("#shenheinfo").hide();
	}); 
}); 

function hideshenheinfo(){
	$("#shenheinfo").hide();
}
function checkSelect() {
	var flag = false;
	//var ids = "";
	$("input[name='uccid']:checked").each(function(){
		flag = true;
		//ids += $(this).val()+",";
	}); 
	return flag;
}
 
/* function getTeachContent(obj){			 
  	var teachcontentId = obj.value;	
  	alert(teachcontentId) 	
} */
function tst(){location.reload();}
function listCourse(clazzid,userid,courseid,uccid,programid){	  
	 b_IframeLevel("${ctx}/train/manage/programs!requireTeachContentCourse.action?clazzid="+clazzid+"&userid="+userid+"&oldcourseid="+courseid+"&uccid="+uccid+"&programId="+programid,300,800,tst);			    
} 
function changeClazz(obj){
	var a=obj.value
	alert(a)
}
</script>
</head>
<body> 
<div class="dr-wrapper" style="margin-top: 0px;">
 <section id="main" role="main">
 
 <div class="dr-container-fluid"> 
		<ol class="dr-breadcrumb" style="">
	       <li>
	        <span class="glyphicon glyphicon-home"></span>
	        <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
	       </li>
	       <li>
	        <a href="#">培训项目管理</a>
	       </li>
	       <li class="active"><span>培训项目审核</span></li>
	    </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>培训项目审核<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->	
    <!--信息提示-->
  <div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>  
<!--信息提示 end-->     
 
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/train/manage/programs!requireUcc.action?programid=${programId}" method="post"">
<div class="dr-searchbar">
<input type="hidden" name="shenhepage.pageNo" id="pageNo" value="${shenhepage.pageNo}" />
<input type="hidden" name="shenhepage.orderBy" id="orderBy" value="${shenhepage.orderBy}" />
<input type="hidden" name="shenhepage.order" id="order" value="${shenhepage.order}" />
<input type="hidden" name="export" value="false" id="export"/>
 
<div class="form-group">
	  	<label>所属阶段</label>
	  	<s:select cssStyle="width:150px"  list="phaseLists" listKey="id" value="phaseId" listValue="name" id="phaseId" theme="simple" headerValue="--所属阶段--"
			headerKey="" cssClass="form-control" name="phaseId"></s:select>
</div>


 <%--  <div class="form-group">
				 <label>学员姓名</label>
                 <input name="studentname" class="form-control input-sm" value="${studentname}" />
</div>  --%>  
<div class="form-group">
				<label>班级</label>
				<s:select id="clazzitem" cssClass="form-control input-sm" list="clazzDTOlist" listKey="id" listValue="name"
			       value="@java.lang.Long@parseLong(#parameters.filter_EQL_clazz$id)" name="filter_EQL_clazz$id" 
			       theme="simple" headerValue="--全部--" headerKey="">
			    </s:select>

				<%-- <label>班级</label>
				<s:select  cssClass="form-control input-sm" onChange="changeClazz(this)" list="clazzDTOlist" listKey="id" listValue="name"
			       value="" name="clazzid" 
			       theme="simple" headerValue="--全部--" headerKey="">			       			        
			    </s:select> --%>
</div>
<%-- <div class="form-group">
				 <label>课程</label>
                 <input name="courseN" class="form-control input-sm" value="${courseN}" />
</div>  --%>  
 
<div class="form-group">
 	<label>审核状态</label> 
 	<s:select list="#{'0':'未审核','1':'已审核'}" value="shenhe" name="shenhe" headerValue="--全部--" headerKey="" cssClass="form-control input-sm"  theme="simple"  ></s:select>
</div>

<div class="form-group">
                <button class="btn btn-default btn-sm" onclick="document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
</div>
<div class="btn-group">
	<button  name="Submit2" class="btn btn-default btn-sm" type="button" id="batchShenhe12">
         <span class="glyphicon glyphicon-user"></span>&nbsp;确认审核
    </button>
</div>

<div id="shenheinfo" class="btn-group" style="display: none">
         <font color="red">没有可操作记录,请勾选</font>
</div>

<div id="shenhe" class="btn-group" style="display: none">
         <font color="red">审核未通过</font>
</div>

<div class="form-group">
			<label>导出</label> 
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.mainForm.submit();$('#export').val('false');">
			<span class="glyphicon glyphicon-export"></span>
		 
			</button>
		</div>
</div>
</form>
    <form class="form-horizontal" id="inputForm22" name="inputForm22" action="${ctx}/train/manage/programs!sureSingup.action" method="post"">
    	<div class="panel panel-default">
			<table class="table table-bordered dr-table-bordered">
			<thead>
				<tr>
					<th width="5%" class="tt_noline"><input type="checkbox" id="checkboxall2"/></th>				     					 
					<th width="10%" >学员姓名</th>					 
					<th width="14%">所在班级</th>
					<th width="15%">课程</th>
					<th width="5%" align="center">审核状态</th>					 
				</tr>
			</thead>
				<tbody>
				   <s:iterator value="page3.result" status="stat"  >  				  
			    <tr>	
			    	  <td class="white_bg">
					<input onclick="hideshenheinfo()" type="checkbox" name="uccid" value="${id}" />
					</td>		       					 
					<td class="white_bg"><s:property value="name" /></td>					 
					<td class="white_bg">&nbsp;<s:property value="clazzname" /></td>
					<td class="white_bg">
						<div class="btn-group">
							&nbsp;<s:property value="coursename" />
						</div>
						&nbsp;&nbsp;&nbsp;<div class="btn-group">
							<button  name="setCountButton" class="btn btn-default btn-sm" type="button" onclick="listCourse('${clazzid}','${userid}','${courseid}','${id}','${programId}')">
	               			 	<span class="glyphicon glyphicon-plus"></span>&nbsp;调课
	           				</button>
						</div>
						
						&nbsp;&nbsp;&nbsp;<div class="btn-group">
							<s:if test="tipinfo!=null">
							&nbsp;&nbsp;&nbsp;课程剩余人数:<s:property value="tipinfo" />
							</s:if><s:else>
							&nbsp;&nbsp;&nbsp;课程剩余人数:<s:property value="exitCourse" />
							</s:else>
						</div>
					</td>
					<s:if test="normal==false">
					<td class="white_bg">&nbsp;未审核</td>	
					</s:if><s:else>
					<td class="white_bg">&nbsp;已审核</td>
					</s:else>   				 
						  						 		 			 		       						    
				</tr>
				   </s:iterator>  				  			  
				</tbody>			 
			</table>
			<s:set name="page" value="shenhepage" scope="request"></s:set>			
			<%@ include file="/common/turnpage.jsp"%> 
		</div>	 
</form>
</div>
</section>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over--> 
 
</body>
</html>

