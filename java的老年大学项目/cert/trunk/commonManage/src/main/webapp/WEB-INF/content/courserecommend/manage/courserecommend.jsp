<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ page import="cn.common.lib.util.web.PropertyUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("iswxeduopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","wxedu.open"));
request.setAttribute("isahstudyopen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.open"));
request.setAttribute("isHbddOpen",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","hbdd.open"));
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
<title><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>程推荐<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else>-安徽省专业技术人员培训平台</s:else></title>  
</s:if>
<s:else>
<title><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><s:if test="#request.isqlxx=='true'">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>程推荐<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
</s:else>

<%@ include file="/common/admin_meta.jsp" %>
<script src="${staticurl}/js/list2list.js" type="text/javascript"></script>
<script>
	//用于栏目管理 的级联查询取数据
	var isahstudyopen = '<%=request.getAttribute("isahstudyopen")%>';
	var isHbddOpen = '<%=request.getAttribute("isHbddOpen")%>';
	if(isHbddOpen) isahstudyopen = isHbddOpen;
	
	$(document).ready(function() {
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();
	  	//-------------------------------移动(move)测试:------------------------------
	    //右移
		jQuery("#moveright").click(function(){
			var num = 8;
			if (($("#page option").length + $("#coursePage option:selected").length) <= num){
				jQuery(this).listTolist("coursePage","page","append",false);
			} else {
				b_alert("推荐列表最多"+num+"条数据！");
			}
			$("#coursePage option:selected").each(function(){
				$(this).attr("selected","");
			});
		});

		jQuery("#moveup").click(function(){
			if ($("#page option:selected").prev("option").val() != "undefined") {
				$("#page option:selected").prev("option").before($("#page option:selected"));
			}
			//$("#page option:selected").each(function(){
			//	$(this).attr("selected","");
			//});
		});
		
		jQuery("#movedown").click(function(){
			if ($("#page option:selected").next("option").val() != "undefined") {
				$("#page option:selected").next("option").after($("#page option:selected"));
			}
			//$("#page option:selected").each(function(){
			//	$(this).attr("selected","");
			//});
		});

		jQuery("#delete").click(function(){
			$("#page option:selected").remove();
		});
		
		$("#inputForm").submit(function(){
			$("#page").find("option").each(function(){				
				$("#inputForm").append("<input type='checkbox' name='selectCourseIds' checked='checked'  style='display:none' value='"+$(this).val()+"'/>");
			})
		})
		
		jQuery("#add").click(function(){
			var group=$('input:radio:checked').val();
			var key;
			if(group==1)
			{
			if ($("#name").val() == ""){
				b_alert("请填写课程名称");
				$("#name").get(0).focus();
				return false;
			}
			key=$("#name").val();
			}else
			{
				if ($("#cid").val() == ""){
					b_alert("请填写课程编码");
					$("#cid").get(0).focus();
					return false;
				}
				key=$("#cid").val();
			}
			$.ajax({
				type:"POST",
				dataType: "json",
				url: "${ctx}/related/course!exists.action",
				data: {key:key,t:group},
				success: function(data){
					if(data.course==""||data.course==null)
					{
						b_alert('没有查到相关课程');
						return false;
						}
					var course = eval('('+data.course+')');
					if(course==undefined){b_alert('没有查到相关课程');return false;}
					if(Number(3)==(Number(1)+Number($("#type").val()))){
						if(course.courseModel!=(Number(1)+Number($("#type").val()))&&$("#type").val()!=4)
						{

						if(isahstudyopen=='true'){
							 b_alert('添加的课程不是<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if>');
						}else{
							b_alert('添加的课程不是<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><s:if test="#request.isqlxx==true">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if>');
							}
							
					
					 	return false;}
					}else{
						if(course.courseModel!=$("#type").val()&&$("#type").val()!=4)
						{
							if(isahstudyopen=='true'){
								b_alert('添加的课程不是<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if>');
							}else{
								b_alert('添加的课程不是<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><s:if test="#request.isqlxx==true">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if>');
								}
						return false;}
					}
						var flag = true;
						if(group==1)
						{
						$("#page option").each(function(){
							if ($(this).html() == $("#name").val()) {
								flag = false;
								return false; 
							}
						})
						}else
						{
							$("#page option").each(function(){
								if ($(this).val() == $("#cid").val()) {
									flag = false;
									return false; 
								}
							})
							}
						if (flag) {
							$("#page").append("<option value='"+course.id+"'>"+course.name+"</option>");
						} else {
							b_alert("此课程已经在推荐列表中，无需重复添加！");
						}
				}
			});
		});
		
		//$('#name').autocomplete("${ctx}/course/manage/courseajax.excsec", {
		//	minChars: 2,
		//	autoFill: false,
		//	scrollHeight: 220,
		//	ajaxParam: getSelectParam,
		//	parse:formateData
		//});
		//$('#name').result(resultSelect);
	})
	//获取参数
	function getSelectParam(){
		var type = "name";
		var value = $('#name').val();
		var p = { 
				fieldName:type,
				fieldValue:value
			};
		return p;
	}
	//形成下拉div
	function formateData(json){
		var parsed = [];
		var data = json.courseJson;
		data = eval('('+data + ')');
		for(var item in data){	
			var line = data[item];	
			var p = {data: line.name,
					value: line.id,
					result: ""}
			parsed[parsed.length] = p;		
		}		
		return parsed;
	}
	//返回值处理
	function resultSelect(event,name,id){
		$('#name').val(name);	
	}
	</script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<style type="text/css">

.txtwb0 {
    border: 1px solid #CCCCCC;
    height: 220px;
    margin: 10px auto;
    width: 96%;
}

</style>
</head>

<body>
  <!--adminHeader开始-->
     <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
  <!--adminHeader结束-->
  <div class="dr-wrapper">
     <!--adminLeft结束-->
     
     <s:if test="type==2">
       <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	   <jsp:param value="courserecommend2" name="menu" />
	   <jsp:param value="courserecommend" name="bigmenu" />
       </jsp:include>
    </s:if>
    <s:if test="type==1">
       <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	   <jsp:param value="courserecommend1" name="menu" />
	   <jsp:param value="courserecommend" name="bigmenu" />
       </jsp:include>
    </s:if>
        <s:if test="type==3">
       <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	   <jsp:param value="courserecommend3" name="menu" />
	   <jsp:param value="courserecommend" name="bigmenu" />
       </jsp:include>
    </s:if>
        <s:if test="type==4">
       <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	   <jsp:param value="courserecommend4" name="menu" />
	   <jsp:param value="courserecommend" name="bigmenu" />
       </jsp:include>
    </s:if>
  <!--adminLeft结束-->
      <section id="main" role="main"> 
      <div class="dr-container-fluid">
      <ol class="dr-breadcrumb">
        <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
        <li><a href="#">课程推荐管理</a></li>
        <s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
        <li class="active"><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>推荐管理</li> 
        </s:if>
        <s:else>
        <li class="active"><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"> <s:if test="#request.isqlxx=='true'">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>推荐管理</li>
        </s:else>
       </ol>
   <div class="dr-page-header">
     <s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
      <h3><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>推荐管理 </h3> 
     </s:if>
     <s:else>
       <h3><s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><s:if test="#request.isqlxx=='true'">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>推荐管理 </h3>
     </s:else>
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

<form id="inputForm" action="courserecommend!save.action" method="post">
<input type="hidden" value="${type}" name="type" id="type"/>

<div class="panel panel-default">
<table width="98%" border="0" align="center" cellspacing="0"  class="table table-bordered dr-table-bordered">
	<tr>
		<td width="54%" valign="top">
		<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
		  <strong>已推荐的<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>程</strong>
		</s:if>
		 <s:else>
		<strong>已推荐的<s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:if test="type==1"><s:if test="#request.isqlxx=='true'">校本特色课</s:if><s:else>精品课</s:else></s:if><s:if test="type==3">免费课</s:if><s:if test="type==4">试用课</s:if>程</strong>
		</s:else>
			<s:select list="page.result" listKey="courseId" listValue="courseName"
			name="page1" id="page" cssClass="txtwb0" theme="simple"
			multiple="true" size="10"/>
	
			<button class="btn btn-default" type="button" id="delete" name="Submit32222">
               <span class="glyphicon glyphicon-trash"></span>
                                      从推荐列表中删除
           </button>
			
			<button class="btn btn-primary" type="button" id="moveup" name="Submit322222">
               <span class="glyphicon glyphicon-arrow-up"></span>
                                      上 移
           </button>
			<button class="btn btn-default" type="button" id="movedown" name="Submit322223">
               <span class="glyphicon glyphicon-arrow-down"></span>
                                      下 移
           </button>
			
			<div>
			   <p class="help-block col-md-offset-0"><s:if test="type==2">添加新课程（课程属性必须是<common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop>）</s:if><s:if test="type==1">添加新课程（课程属性必须是<common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop>）</s:if>
			   </p>
			</div>
			
			<table border="0" width="100%" style="border:none" cellspacing="0" cellpadding="0">
			<tr >
			<td width="80" height="40px;" style="border:none">
			  <input type="radio" name="coursegroup"  checked="checked" value="1" />课程名称
			</td>
				<td style="border:none">
				<input name="textfield42" type="text" class="form-control" id="name" style="width: 200px;" />
				</td>
			</tr>
			<tr>
			<td width="80" height="40px;" style="border:none"><input type="radio" name="coursegroup"
				value="2" / ></input>课程编码
			</td>
			<td style="border:none">
			 <input name="textfield42" type="text" id="cid" class="form-control" style="width: 200px;" />
			</td>
			</tr>
			</table>
			
			
			<div class="mt10">
			<button class="btn btn-primary" type="button" id="add" name="Submit2">
					<span class="glyphicon glyphicon-plus"></span>&nbsp;添加至推荐列表
		    </button>
		    <button class="btn btn-primary" type="submit"  name="Submit4">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;保存所有列表
		    </button>

			</div>

		</td>
		
		<td width="2%" valign="top">
             
             <div class="col-md-4 posr">
						<div class="dr-switch-arrow" style="left: -6px;">
							<p>
								<button type="button" class="btn btn-primary" id="moveright" title="左移"><i class="icon-double-angle-left"></i>
								</button>
							</p>
						</div>
				</div>		
	
         </td>
		
		<td width="54%" valign="top">
			<strong>创建时间最新的前20门
			<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			  <s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:elseif test="type==1"><common:prop name="MODEL_PUBMUST" propfilename="sysconfig.properties"></common:prop></s:elseif><s:if test="type==3">免费课</s:if><s:else></s:else>程  
			</s:if>
			<s:else>
			 <s:if test="type==2"><common:prop name="MODEL_MAJOR" propfilename="sysconfig.properties"></common:prop></s:if><s:elseif test="type==1"><s:if test="#request.isqlxx=='true'">校本特色课</s:if><s:else>精品课</s:else></s:elseif><s:if test="type==3">免费课</s:if><s:else></s:else>程
			</s:else>
			 <s:select list="coursePage.result" listKey="courseDTO.id" listValue="courseDTO.name" name="coursePage1" id="coursePage" cssClass="txtwb0" theme="simple" cssStyle="height:425px"
			multiple="true"/>
			</strong>
		</td>
	</tr>
</table>
</div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>

</body>
</html>