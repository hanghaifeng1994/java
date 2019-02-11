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
function checkover(){
	$.ajax({
        type: "POST",
        url: "${ctx}/clazz/manage/headerclazz!isFinishExportClazzAllAcount.action",
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
<section id="main" role="main">
<div class="dr-container-fluid">
<%@ include file="/common/clazzHeader.jsp"%>
			<div class="bs-example">
				<ul class="nav nav-tabs" id="tab">
					<li class="active"><a href="#">课程实施管理</a>
					</li>
				</ul>
			</div>

			<div class="tab-content dr-tabs-panel">
				<div class="panel-body row">
					<div class="col-md-12">
						<table class="table table-bordered dr-table-default">
							<tr>
								<td class="buleleft" width="50%">课程名称</td>
								<td class="buleleft">操作</td>
							</tr>
							<s:iterator value="classCourseDTOs" status="stat">
								<tr>
									<td>&nbsp;${course.name}</td>
									<td>&nbsp; <s:if test="course.newlp">
											<a href="#" onclick="lpoperaction(${course.id})"
												class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;课程实施</a>
										</s:if> <s:else>
											<a
												href="${ctx }/course/manage/course!schedule.action?id=${course.id}&headerClazzId=${headerClazzId}"
												target="_blank" class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;作业日程管理</a>
											<a
												href="${ctx}/course/manage/course!examSchedule.action?id=${course.id}&headerClazzId=${headerClazzId}"
												target="_blank" class="btn btn-primary btn-sm"><span
												class="glyphicon glyphicon-cog"></span>&nbsp;测验日程管理</a>
										</s:else></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			
<%@ include	file="/common/tagtitle.jsp"%>
<div class="tab-content dr-tabs-panel">
<div class="dr-searchbar">
<form id="mainForm" name="mainForm" action="headerclazz!learningcount.action" method="post" class="form-inline dr-form-inline">
   	<input type="hidden" name="page3.pageNo" id="pageNo"	value="${page3.pageNo}" />
	<input type="hidden" name="page3.orderBy" id="orderBy" value="${page3.orderBy}" />
	<input type="hidden" name="page3.order" id="order" value="${page3.order}" />
    <input type="hidden" name="headerClazzId" id="headerClazzId" value="${headerClazzId}" />
    <input type="hidden" name="curRoleId" id="curRoleId" value="${curRoleId}" />
	<input type="hidden" name="tabnum" id="tabnum" value="1" />
    <input type="hidden" name="export" value="false" id="export"/>
  <div class="form-group">
<label>用户名</label>
 <input name="username" type="text" class="form-control input-sm" value="${username}" />
</div>
 <div class="form-group">
<label>姓名</label>
 <input name="name" type="text" class="form-control input-sm" value="${name}" />
</div>
 <div class="form-group">
<label>单位</label>
 <input name="unit" type="text" class="form-control input-sm" value="${unit}" />
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
<button name="Submit" class="btn btn-default btn-sm" type="submit">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
<div class="form-group">
<s:if test="type==0">
       <span style="margin-left:30px;">合格人数：<font style="color: #11B1CD;">${qualifiedCount}</font>&nbsp;&nbsp;|&nbsp;&nbsp;不合格人数：<font style="color: #11B1CD;">${unqualifiedCount}</font></span>
	   </s:if>
	   <s:else>
	   <span style="margin-left:30px;">完成人数：<font style="color: #11B1CD;">${qualifiedCount}</font>&nbsp;&nbsp;|&nbsp;&nbsp;未完成人数：<font style="color: #11B1CD;">${unqualifiedCount}</font></span>
	   </s:else>
	</div>
</div>
 </form>  
 </div>  
  <form name="deleteForm" id="deleteForm" action="headerclazz!learningcount.action" method="post">
<div class="panel panel-default  mt10 mb10" >
<div class="btn-toolbar dr-btn-toolbar">
				       <button name="Submit2" type="button" class="btn btn-default btn-sm" id="exportbut" 
				         onclick="exportexcel();"><span class="glyphicon glyphicon-export"></span>&nbsp;导出表格</button>
					    <span style="font-size: 12px;"><span id="font" style="<s:if test="export"></s:if><s:else>display:none;</s:else>">文件正在生成中，请稍候再点击下载按钮下载您所需要的导出文件！</span>
					    <label class="ml10" id="downLoad" style="display: none">
							<a href="" target="_blank">班主任学情导出文件下载</a>
						</label>
					    </span>  
</div>
<table   class="table table-bordered dr-table-bordered"  > 
	<tr>
	<th width="5%">序号</th>
		<th width="10%">学员账号</br>
		单位</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>		
		<th width="5%">地区</th>
		<s:if test="programsCheckDTO.hasKcxx">	
		<th width="10%">课程学时（分钟）</th>
		</s:if>
		<s:if test="programsCheckDTO.hasscore">		 
			<th width="8%">学习成绩</th>
		</s:if>
		
		<s:if test="programsCheckDTO.hasKhzy">
		<th width="8%">作业提交待批阅</th>
		<th width="8%">作业已评</th>
		<!-- <th width="8%">作业未提交</th>	 -->	 
		<th width="10%">作业总成绩</th>
		</s:if>	
		<s:if test="programsCheckDTO.hasXxglgjjh">						 
			<th width="10%">研修成果已提交</th>
			<th width="10%">研修成果成绩</th>
		</s:if>		
		<s:if test="programsCheckDTO.hasLtyt">		
			<th width="10%">研修讨论发帖数</th>
			<th width="10%">研修讨论考核成绩</th>
		</s:if>	
		<s:if test="programsCheckDTO.hasYxrz">	
				<th width="10%">研修日志发布数</th>
				<th width="10%">研修日志成绩</th>
		</s:if>		
		<s:if test="programsCheckDTO.hasYdjb">		
				<th width="10%">阅读简报个数</th>
				<th width="10%">简报阅读成绩</th>
		</s:if>		
		<s:if test="programsCheckDTO.hasKccy">
		<th width="10%">测验成绩</th>
		</s:if>
		<s:if test="programsCheckDTO.hasscore">	
			
			<th width="10%">最终成绩</th>
		</s:if>
		<s:elseif test="programsCheckDTO.hashour">	
			<th width="8%">所得学时</th>
			<th width="8%">考核要求学时</th>
		</s:elseif>
		<s:if test="programsCheckDTO.hasscore">	
			<th width="8%">是否合格</th>
		</s:if>
		<s:elseif test="programsCheckDTO.hashour">	
			<th width="8%">是否完成</th>
		</s:elseif>
		<%-- <th width="5%">序号</th>
		<th width="10%">学员账号</br>
		单位</th>
		<th width="8%">姓名</th>
		<th width="5%">性别</th>
		
		<th width="5%">地区</th>
		<th width="10%">课程学时（分钟）</th>
		<s:if test="type==0">
			<th width="8%">学习成绩</th>
		</s:if>
		<th width="8%">作业提交待批阅</th>
		<th width="8%">作业已评</th>
		<th width="8%">作业未提交</th>
		<s:if test="type==0">
			<th width="10%">作业总成绩</th>
		</s:if>
		
		
		<s:if test="#request.isahstudyopen=='true'">
				
		</s:if>
		<s:else>
				<th width="10%">研修成果已提交</th>
				<th width="10%">研修成果成绩</th>
				<th width="10%">研修讨论发帖数</th>
				<th width="10%">研修讨论考核成绩</th>
				<th width="10%">研修日志发布数</th>
				<th width="10%">研修日志成绩</th>
				<th width="10%">阅读简报个数</th>
				<th width="10%">简报阅读成绩</th>
		</s:else>
		<th width="10%">测验成绩</th>
		<s:if test="type==0">
			
			<th width="10%">最终成绩</th>
		</s:if>
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
	<s:iterator value="page3.result" status="stat">		 
		<tr>
		<td><s:property value="#stat.index+1"></s:property></td>
			<td><s:if test="#request.iswxeduopen=='false'">${username}</s:if><s:else>${hideusername}</s:else>
			<br/>${unit}</td>
			<td>${name}</td>
			<td>
			  <s:if test='sexstr=="m"'>男</s:if>
			  <s:elseif test='sexstr=="f"'>女</s:elseif>
			  <s:else>未知</s:else>
			</td>
			
			<td>${canton}</td>
			<s:if test="programsCheckDTO.hasKcxx">
			<td>${studytime}</td>
			</s:if>
			<s:if test="programsCheckDTO.hasscore">	
				<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>			
			<s:if test="programsCheckDTO.hasKhzy">
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<%-- <td>${homenosignup}</td> --%>			 
			<td>${homescoresum}</td>			 
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
			 
			<s:elseif test="programsCheckDTO.hashour">
				 
			 	<s:if test='qualified=="1"'>完成</s:if>
			  	<s:elseif test='qualified=="0"'>未完成</s:elseif>
			  	<s:else>未知</s:else>
			  	
			 </s:elseif>
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
			<td>${studytime}</td>
			<s:if test="programsCheckDTO.hasscore">	
				<td><fmt:formatNumber type="number" value="${studyscore}"  maxFractionDigits="1"/></td>
			</s:if>
			
			<s:if test="programsCheckDTO.hasKhzy">
			<td>${homesignuped}</td>
			<td>${homemarked}</td>
			<td>${homenosignup}</td>
			<s:if test="type==0">
				<td>${homescoresum}</td>
			</s:if>
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
 <s:set name="page" value="page3" scope="request"/>
<%@ include file="/common/turnpage.jsp"%>
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
