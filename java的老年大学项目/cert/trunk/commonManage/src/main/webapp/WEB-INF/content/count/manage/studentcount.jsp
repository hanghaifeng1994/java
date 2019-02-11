<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<script type="text/javascript">
    $(document).ready(function(){
    	 
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
   		if(${export}){
		   $('#exportbut').hide();
		   checkover();
	    }
    }); 
    
    function exportexcel(){
		 $('#export').val('true');
		 document.mainForm.submit();
	}
	
	function changecity(){				
		var cityId = $("#cityId").val();
		if(cityId) {
			$.post("${ctx}/count/manage/studentcount!getAreaJson.excsec",{"cityId":cityId},function(data) {
				$("#cantonId option[value!='']").remove();
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#cantonId option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if("${cantonId}"==practiceUnit[i].value){
						    $("#cantonId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else{
						    $("#cantonId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					}
				}
			});
		}
	}

	function changeTenant(){				
		var tenantId = $("#tenantId").val();
			$.post("${ctx}/count/manage/studentcount!getPrograms.excsec",{"tenantId":tenantId},function(data) {
				$("#programesId option[value!='']").remove();
				var practiceUnit = eval(data);
				if(practiceUnit.length == 0) $("#programesId option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					 if(i==0){
						    $("#programesId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					 }else{
						    $("#programesId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
					}
				}
			});
	}
	
	function checkover(){
		$.ajax({
	        type: "POST",
	        url: "${ctx}/count/manage/studentcount!isFinishExportNew.action",
	        data: {
	        	"threadName": '${threadName}',"fileName":'${fileName}'
			},
			dataType:"json" ,
	        success: function(data) {
				 if(data.value=="false"){
					 $('#downLoad').show();
					 $('#downLoad a').attr("href","<common:prop name="traincore.uploadpath.url" propfilename=""/>/"+data.label);
					 $('#font').hide();
					 $('#exportbut').show();
				 }else{
					 setTimeout('checkover()',3000);
			     } 
	        }
		});
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
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="studentcount" name="menu" />
	<jsp:param value="xueqing" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">学情统计</a>
</li>
<li class="active">项目个人学情</li>
</ol>

<div class="dr-page-header">
<h3>
项目个人学情统计
</h3>
</div>
<hr/>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/studentcount.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>
<s:if test="currentTenant == null ">
	<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id" onchange="changeTenant()"
					id="tenantId"   value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
					headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
</s:if>
<div class="form-group">
	  	<label>所属项目</label>
	  	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" headerValue="--所属项目--"
			headerKey="" cssClass="form-control" name="programesId"></s:select>
</div>

<div class="form-group">
	  	<label>所属城市</label>
	  	<s:select list="citysVLists" onchange="changecity()" listKey="id" listValue="name" id="cityId" name="cityId" value="cityId" theme="simple" headerValue="--所属城市--" headerKey="" cssClass="form-control" ></s:select>
</div>

<div class="form-group">
	  	<label>所属地区</label>
	  	<s:select cssClass="form-control" list="areaVLists" listKey="id" listValue="name" id="cantonId" name="cantonId" theme="simple" value="cantonId" headerKey="" headerValue="--所在地区--" />
</div>

<s:if test="type==0">
<div class="form-group">
     <label>是否合格</label>
     <s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="qualified" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.qualified)" cssClass="form-control input-sm" ></s:select>
   </div>
</s:if>
<s:elseif test="type==1">
<div class="form-group">
     <label>是否完成</label>
     <s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="qualified" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.qualified)" cssClass="form-control input-sm" ></s:select>
   </div>
</s:elseif>
   
   
<div class="form-group">
     <label>作业是否提交</label>
     <s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="homesignuped" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.homesignuped)" cssClass="form-control input-sm" ></s:select>
   </div>
   
   <!--<div class="form-group">
     <label>研修成果是否提交</label>
     <s:select list="#{'1':'是','0':'否'}" listKey="key" listValue="value" name="trainresultsigned" theme="simple" headerValue="--全部--" headerKey="" value="@java.lang.Integer@parseInt(#parameters.trainresultsigned)" cssClass="form-control input-sm" ></s:select>
   </div>-->
<div class="form-group">
			
<label>学员账号：</label>
<input id="catname" name="username" class="form-control input-sm" value="${username}"/>
</div>

<div class="form-group">
<label>姓名</label>
<input name="name" type="text" class="form-control input-sm"
				value="${name}"/>
</div>
<div class="form-group">
<label>单位</label>
<input name="unit" class="form-control input-sm" value="${unit}"/>
</div>
<!--<div class="form-group">
<label>班级</label>
<input name="clazzname" class="form-control input-sm" value="${clazzname}"/>
</div>

--><div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#pageNo').val('1');$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
		<!-- 	<div class="form-group">
			<button class="btn btn-default btn-sm" type="button" style="height:30px" name="Submit2" onclick="$('#export').val('true');document.mainForm.submit();$('#export').val('false');">
			<span class="glyphicon glyphicon-export"></span>
			 导出
			</button>
			</div> -->

</div>
</form>
<form name="deleteForm" id="deleteForm" action="course.action" method="post">
 <div class="panel panel-default  mt10 mb10" >
 	<div class="btn-toolbar dr-btn-toolbar">
		       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
		         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
			    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
			    <label class="ml10" id="downLoad" style="display: none">
					<a href="" target="_blank">项目个人学情导出文件下载</a>
				</label>
			    </span>
     </div>
<table  class="table table-bordered dr-table-bordered"  > 
	<tr>
	
	<th width="5%">序号</th>
		<th width="10%">学员账号</br>
		单位</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="5%">地区</th>
		<!--<th width="13%">所属班级名称</th>-->
		
		<s:if test="programsCheckDTO.hasKcxx">		 
			<th width="8%">课程学时（分钟）</th>	
		</s:if>
			 
		 <s:if test="programsCheckDTO.hasscore">		 		 
			<th width="7%">学习成绩</th>	 
		</s:if>
		
		<s:if test="programsCheckDTO.hasKhzy">
			<th width="7%">作业提交待批阅</th>
			<th width="7%">作业已评</th>
			<th width="7%">作业未提交</th>					 	 
			<th width="7%">作业总成绩</th>		 	
		</s:if>
		
		<s:if test="programsCheckDTO.hasXxglgjjh">	
			<th width="8%">研修成果已提交</th>
			<th width="8%">研修成果成绩</th>
		</s:if>
			
		<s:if test="programsCheckDTO.hasLtyt">
			<th width="8%">研修讨论发帖数</th>
			<th width="8%">研修讨论考核成绩</th>
		</s:if>
			
		<s:if test="programsCheckDTO.hasYxrz">
			<th width="8%">研修日志发布数</th>
			<th width="8%">研修日志成绩</th>
		</s:if>
			
		<s:if test="programsCheckDTO.hasYdjb">
			<th width="8%">阅读简报个数</th>
			<th width="8%">简报阅读成绩</th>
		 </s:if>
		 	
		 <s:if test="programsCheckDTO.hasKccy">
			<th width="8%">测验成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasscore">			 
			<th width="8%">最终成绩</th>			 
		</s:if>		
		<s:elseif test="programsCheckDTO.hashour">		 		 
			<th width="8%">所得学时</th>
			<th width="8%">考核要求学时</th>		 
		</s:elseif>		
		<s:if test="programsCheckDTO.hasscore">	
			<th width="8%">是否合格</th>
		</s:if>
		<s:else>	
			<th width="8%">是否完成</th>
		</s:else>	
		<%-- <th width="5%">序号</th>
		<th width="10%">学员账号</br>
		单位</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		<th width="5%">地区</th>
		<!--<th width="13%">所属班级名称</th>
		--><th width="8%">课程学时（分钟）</th>
		<s:if test="type==0">
			<th width="7%">学习成绩</th>
		</s:if>
		<th width="7%">作业提交待批阅</th>
		<th width="7%">作业已评</th>
		<th width="7%">作业未提交</th>
		<s:if test="type==0">
			<th width="7%">作业总成绩</th>
		</s:if>
		<s:if test="#request.isahstudyopen=='true'">
		
		</s:if>
		<s:else>
			<th width="8%">研修成果已提交</th>
			<th width="8%">研修成果成绩</th>
			<th width="8%">研修讨论发帖数</th>
			<th width="8%">研修讨论考核成绩</th>
			<th width="8%">研修日志发布数</th>
			<th width="8%">研修日志成绩</th>
			<th width="8%">阅读简报个数</th>
			<th width="8%">简报阅读成绩</th>
		</s:else>
		<th width="8%">测验成绩</th>
		<s:if test="type==0">
			<th width="8%">最终成绩</th>
		</s:if>
		
		<s:if test="type==0"></s:if>
		<s:else>
			<th width="8%">所得学时</th>
			<th width="8%">考核要求学时</th>
		</s:else>
		
		<s:if test="type==0">
			<th width="8%">是否合格</th>
		</s:if>
		<s:elseif test="type==1">
			<th width="8%">是否完成</th>
		</s:elseif> --%>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
		<td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}<br/>${unit}</td>
			<td>${name}</td>
			<td>
			<s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			
			</td>
			<td>${canton}</td>
			<!--<td>${clazzname}</td>
			-->
			<s:if test="programsCheckDTO.hasKcxx">
			<td>${studytime}</td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasscore">			 
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>			 
			</s:if>
			
			<s:if test="programsCheckDTO.hasKhzy">			 
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>						 
			<td><fmt:formatNumber type="number" value="${homescoresum}"  maxFractionDigits="1"/></td>			 
			</s:if>
			
			 <s:if test="programsCheckDTO.hasXxglgjjh">	
				<td>${trainresultsigned}</td>
				<td><fmt:formatNumber type="number" value="${trainresultscore}"  maxFractionDigits="1"/></td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasLtyt">
				<td>${traindiscussposts}</td>				
				<td><fmt:formatNumber type="number" value="${traindiscussscore}"  maxFractionDigits="1"/></td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasYxrz">
				<td>${trainjournalsignsum}</td>
				<td><fmt:formatNumber type="number" value="${trainjournalscore}"  maxFractionDigits="1"/></td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasYdjb">
				<td>${readnewslettersum}</td>
				<td><fmt:formatNumber type="number" value="${readnewsletterscore}"  maxFractionDigits="1"/></td>
			 </s:if>
			 
			<s:if test="programsCheckDTO.hasKccy">
				<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>	
			</s:if>
			<s:if test="programsCheckDTO.hasscore">		 
				<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			 </s:if>
			<!--<td>
			<s:if test='qualified=="1"'>合格</s:if>
			  <s:elseif test='qualified=="0"'>不合格</s:elseif>
			  <s:else>优秀</s:else>
			</td>
		-->
			<s:elseif test="programsCheckDTO.hashour">			 
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>		 
			</s:elseif>
				
			<td>
			<s:if test="programsCheckDTO.hasscore">	
				<s:if test='qualified=="1"'>合格</s:if>
			  	<s:elseif test='qualified=="0"'>不合格</s:elseif>
			  	<s:else>未知</s:else>
			 </s:if>
			 <s:else>				 
			 	<s:if test='qualified=="1"'>完成</s:if>
			  	<s:elseif test='qualified=="0"'>未完成</s:elseif>
			  	<s:else>未知</s:else>			  	
			 </s:else>
			</td> 
			<%-- <td><s:property value="#stat.index+1"></s:property></td>
			<td>${username}<br/>${unit}</td>
			<td>${name}</td>
			<td>
			<s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			
			</td>
			<td>${canton}</td>
			<!--<td>${clazzname}</td>
			--><td>${studytime}</td>
			<s:if test="type==0">
			<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>
			<s:if test="type==0">
				<td>${homescoresum}</td>
			</s:if>
			<s:if test="#request.isahstudyopen=='true'">
				
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
			<td><fmt:formatNumber type="number" value="${examscore}"  maxFractionDigits="1"/></td>
			<s:if test="type==0">
			<td><fmt:formatNumber type="number" value="${score}"  maxFractionDigits="1"/></td>
			</s:if>
			<!--<td>
			<s:if test='qualified=="1"'>合格</s:if>
			  <s:elseif test='qualified=="0"'>不合格</s:elseif>
			  <s:else>优秀</s:else>
			</td>
		-->
			
			<s:if test="type==0"></s:if>
			<s:else>
				<td>${learnhour}</td>
				<td>${qualifiedlearnhour}</td>
			</s:else>
			
				
			<td>
			<s:if test="type==0">
				<s:if test='qualified=="1"'>合格</s:if>
			  	<s:elseif test='qualified=="0"'>不合格</s:elseif>
			  	<s:else>未知</s:else>
			 </s:if>
			 <s:elseif test="type==1">
				 
			 	<s:if test='qualified=="1"'>完成</s:if>
			  	<s:elseif test='qualified=="0"'>未完成</s:elseif>
			  	<s:else>未知</s:else>
			  	
			 </s:elseif>
			</td> --%>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>


<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>
</body>
</html>