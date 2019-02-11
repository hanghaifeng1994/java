<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
request.setAttribute("ahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url"));
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));

%>
<!DOCTYPE html>
<html lang="de">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
	<script type="text/javascript">
		function jumpToPersonClazzCount(clazzId){
			$("#clazzId").val(clazzId);
			$("#mainForm3").submit();
		}

		function changeTenant(){				
			var tenantId = $("#tenantId").val();
				$.post("${ctx}/count/manage/learningsituationclazz!getPrograms.excsec",{"tenantId":tenantId},function(data) {
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
	</script>
</head>
<body>

<!-- navbar start -->	
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="cantonCountClazz" name="menu" />
	<jsp:param value="xueqing" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
          <li>
             <span class="glyphicon glyphicon-home"></span>
              <a href="#">平台首页</a>
         </li>
         <li>
             <a href="#">学情统计</a>
         </li>
       <li class="active"><span>地区班级学情</span></li>
      </ol>
	<!--/breadcrumb-->
<div class="bs-example" > 
	<ul class="nav nav-tabs nav-justified" id="tab" style="padding: 0px;">
       <li class="active"><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituationclazz.action">班级学情统计</a></li>
       <li><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituationclazz!highchart.action">班级图表统计</a></li>
   </ul>                
</div> 
	<!--页面标题-->
<div>
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/learningsituationclazz.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />

<!--<div class="form-group">
	  	<label>所属班级</label>
	  	<s:select list="clazzLists" listKey="id" value="clazzId" listValue="name" theme="simple" headerValue="--所属班级--"
			headerKey="" cssClass="form-control" name="clazzId"></s:select>
</div>
-->
 <s:if test="currentTenant == null ">
	<div class="form-group">
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"  onchange="changeTenant()"
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
<button class="btn btn-default btn-sm" type="button" onclick="document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>

</div>
</form>
	<form class="form-inline dr-form-inline"  id="mainForm2" name="mainForm2" action="${ctx}/count/manage/learningsituationclazz!list.action"
	 method="post" enctype="multipart/form-data">
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
      <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
      <input type="hidden" name="page.order" id="order" value="${page.order}" />
<table class="table table-bordered dr-table-default">
	<tbody  >
		<tr>
		 	
			<th width="80px;">地区</th>
			<th width="40px;">报名人数</th>
			<th width="40px;">学习人数</th>			
			<s:if test="programsCheckDTO.hasKcxx">
			<th width="60px;">总学习时间（分钟）</th>
			<th width="60px;">平均学习时间（分钟）</th>
			</s:if>
			<s:if test="programsCheckDTO.hasKhzy">
			<th width="60px;">作业提交待批阅数</th>
			<th width="60px;">作业评阅数</th>
			<th width="60px;">作业全部完成人数</th>
			<th width="60px;">作业未完成人数</th>
			<th width="50px;">作业完成率</th>
			</s:if>			
			<s:if test="programsCheckDTO.hasXxglgjjh">			 
			<th width="60px;">提交研修成果人数</th>
			<th width="60px;">研修成果已评数</th>
			<th width="50px;">研修成果完成率</th>
			</s:if>	
			<s:if test="programsCheckDTO.hasLtyt">
			<th width="60px;">研修讨论发帖数</th>
			<th width="60px;">平均研修讨论发帖数</th>
			</s:if>				
			<s:if test="programsCheckDTO.hasYxrz">
			<th width="60px;">研修日志发布数</th>
			<th width="60px;">平均研修日志发布数</th>
			</s:if>													
			<s:if test="programsCheckDTO.hasKccy">
			<th width="40px;">平均测验成绩</th>
			</s:if>
			<s:if test="programsCheckDTO.hasscore">
			<th width="40px;">平均成绩</th>
			<th width="40px;">总合格率</th>
			</s:if>			
			<s:elseif test="programsCheckDTO.hashour">
			<th width="40px;">平均学时</th>
			<th width="40px;">总通过率</th>			
			</s:elseif>	
			<%-- <s:if test="#request.isahstudyopen=='true'"> --%>	
			 
			<%-- <th width="80px;">班级</th>
			<th width="40px;">报名人数</th>
			<th width="40px;">学习人数</th>
			<th width="60px;">总学习时间（分钟）</th>
			<th width="60px;">平均学习时间（分钟）</th>
			<th width="60px;">作业提交待批阅数</th>
			<th width="60px;">作业评阅数</th>
			<th width="60px;">作业全部完成人数</th>
			<th width="60px;">作业未完成人数</th>
			<th width="50px;">作业完成率</th>
			
			<s:if test="#request.isahstudyopen=='true'">
			
			</s:if>
			<s:else>
			<th width="60px;">提交研修成果人数</th>
			<th width="60px;">研修成果已评数</th>
			<th width="50px;">研修成果完成率</th>
			<!--<th width="50px;">研修讨论主题数</th>
			-->
			<th width="60px;">研修讨论发帖数</th>
			<th width="60px;">平均研修讨论发帖数</th>
			<th width="60px;">研修日志发布数</th>
			<th width="60px;">平均研修日志发布数</th>
			</s:else>
			<th width="40px;">平均测验成绩</th>
			<th width="40px;">平均成绩</th>
			<s:if test="#request.isahstudyopen=='true'">
			<th width="40px;">平均学时</th>
			<th width="40px;">总通过率</th>
			</s:if>
			<s:else>
			<th width="40px;">总合格率</th>
			</s:else> --%>
			</tr>

 <s:iterator value="learninglist" status="stat">
		<tr>
		<td width="80px;"><a href="#" onclick="jumpToPersonClazzCount('${clazzId}');">${clazzName}</a></td>
			<td width="40px;">${signupnum}</td>
			<td width="40px;">${studynum}</td>	
			<s:if test="programsCheckDTO.hasKcxx">	
			<td width="60px;">${allhour}</td>
			<td width="50px;"><fmt:formatNumber type="number" value="${averagehour}" maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasKhzy">
			<td width="60px;">${hwnum}</td>
			<td width="60px;">${hwrearmknum}</td>
			<td width="60px;">${hwcompletnum}</td>
			<td width="60px;">${unhwcompletnum}</td>
			<!--<td width="50px;">${hwcompleted}</td>-->
			<td width="50px;"><fmt:formatNumber value="${hwcompleted}" type="percent"/></td>
			 </s:if>
			 <s:if test="programsCheckDTO.hasXxglgjjh">				 		 
			<td width="60px;">${resnum}</td>
			<td width="60px;">${resremarknum}</td>
			<!--<td width="50px;">${rescompleted}</td>-->
			<td width="50px;"><fmt:formatNumber value="${rescompleted}" type="percent"/></td>
			<!--<td width="50px;">${dbnum}</td>
			-->
			</s:if>
			<s:if test="programsCheckDTO.hasLtyt">
			<td width="60px;">${dbcommentnum}</td>			
			<td width="60px;"><fmt:formatNumber type="number" value="${averdbcommentnum}" maxFractionDigits="1"/></td>			
			</s:if>
			<s:if test="programsCheckDTO.hasYxrz">
			<td width="60px;">${blognum}</td>			
			<td width="60px;"><fmt:formatNumber type="number" value="${averblognum}" maxFractionDigits="1"/></td>				 
			</s:if>
			<s:if test="programsCheckDTO.hasKccy">
			<td width="40px;"><fmt:formatNumber type="number" value="${averageexamscore}" maxFractionDigits="1"/></td>
			</s:if>
			<s:if test="programsCheckDTO.hasscore">
				<td width="40px;"><fmt:formatNumber type="number" value="${grate}" maxFractionDigits="1"/></td>		 
		    	
		     </s:if>
		     <s:elseif test="programsCheckDTO.hashour">
			<td width="40px;"><fmt:formatNumber type="number" value="${averagelearnhour}" maxFractionDigits="1"/></td>			 
			</s:elseif> 
			<td width="60px;"><fmt:formatNumber value="${qualifiedRate}" type="percent"/></td>
			<%-- <td width="80px;"><a href="#" onclick="jumpToPersonClazzCount('${clazzId}');">${clazzName}</a></td>
			<td width="40px;">${signupnum}</td>
			<td width="40px;">${registernum}</td>		
			<td width="60px;">${allhour}</td>
			<td width="50px;"><fmt:formatNumber type="number" value="${averagehour}" maxFractionDigits="1"/></td>
			<td width="60px;">${hwnum}</td>
			<td width="60px;">${hwrearmknum}</td>
			<td width="60px;">${hwcompletnum}</td>
			<td width="60px;">${unhwcompletnum}</td>
			<!--<td width="50px;">${hwcompleted}</td>-->
			<td width="50px;"><fmt:formatNumber value="${hwcompleted}" type="percent"/></td>
			
			<s:if test="#request.isahstudyopen=='true'">
				
			</s:if>
			<s:else>
			<td width="60px;">${resnum}</td>
			<td width="60px;">${resremarknum}</td>
			<!--<td width="50px;">${rescompleted}</td>-->
			<td width="50px;"><fmt:formatNumber value="${rescompleted}" type="percent"/></td>
			<!--<td width="50px;">${dbnum}</td>
			-->
				<td width="60px;">${dbcommentnum}</td>
			
			<td width="60px;"><fmt:formatNumber type="number" value="${averdbcommentnum}" maxFractionDigits="1"/></td>
			
			<td width="60px;">${blognum}</td>
			
			<td width="60px;"><fmt:formatNumber type="number" value="${averblognum}" maxFractionDigits="1"/></td>
			</s:else>
			<td width="40px;"><fmt:formatNumber type="number" value="${averageexamscore}" maxFractionDigits="1"/></td>
			<td width="40px;"><fmt:formatNumber type="number" value="${grate}" maxFractionDigits="1"/></td>
			<s:if test="#request.isahstudyopen=='true'">
			<td width="40px;"><fmt:formatNumber type="number" value="${averagelearnhour}" maxFractionDigits="1"/></td>
			</s:if>
			<td width="60px;"><fmt:formatNumber value="${qualifiedRate}" type="percent"/></td> --%>
            </tr>
</s:iterator>
	</tbody>
</table>
<%@ include file="/common/turnpage.jsp"%>

</form>
<form id="mainForm3" name="mainForm3" action="${ctx}/count/manage/studentcountclazz.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="clazzId" id ="clazzId" />
</form>
</div>
</div>

	

<!-- container end -->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
</section>

</body>
</html>