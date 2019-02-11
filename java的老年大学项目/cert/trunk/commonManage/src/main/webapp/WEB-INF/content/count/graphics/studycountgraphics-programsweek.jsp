<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学情统计图形<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.user.util.UserUtils@getCurUser()"></s:set>
<script src="${staticurl}/js/HighChart/highcharts.js"></script>
<script src="${staticurl}/js/HighChart/highcharts-3d.js"></script>
<script src="${staticurl}/js/HighChart/modules/exporting.js"></script>
<script src="${staticurl}/js/HighChart/modules/export-excel.js"></script> 
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
	<jsp:param value="programshour" name="menu" />
	<jsp:param value="xueqinggraphics" name="bigmenu" />
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
<a href="#">学情图形统计</a> 
</li>
<li class="active">项目过程统计</li>
</ol>
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
<div class="bs-example" > 
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programshour.action">项目0-24学习人数</a></li>
        <li  class="active"><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programsweek.action">项目一周学习人数</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programsavgstudytime.action">项目平均学习时间</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programsagestudytime.action">年龄段电脑和app学习时间</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programssexstudytime.action">性别电脑和app学习时间</a></li>
    </ul>                
</div> 
<div class="panel panel-default  mt10 mb10" >  
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" >
<div class="dr-searchbar" style="margin-bottom:0px;">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<div class="form-group" style="float: left"> 
	<div class="form-group" <s:if test="filter==1">style="display: none;"</s:if> >
				  	<label>租户</label>
				  	<s:select list="tenantLists" listKey="id"  onchange="changeTenant()" 
					id="tenantId"   value="tenantId" listValue="name" theme="simple"  cssClass="form-control input-sm" name="tenantId"></s:select>
					</div>
<div class="form-group"> 
	  	<label>所属项目</label>
	  	<s:select list="programesLists" onchange="loadHighchart();" listKey="id" value="programesId" listValue="name" theme="simple" cssClass="form-control" id="programesId" name="programesId"></s:select>
</div>
<div class="form-group">
	  	<label>数据说明：不同项目某周的总学习人数</label>
</div>
</div>       
<div style="clear: both;"></div> 
</div>  
</form>
<div id="container" style="min-width: 310px; height: 550px; margin: 0 auto"></div>
</div>
<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>  	
</section>
</div>
<script type="text/javascript">
$.ajaxSetup({
	  async: false
});
Highcharts.setOptions({
	 lang: {
		printChart:"打印图表",
		downloadJPEG: "下载JPEG 图片" , 
		downloadPDF: "下载PDF文档"  ,
		downloadPNG: "下载PNG 图片"  ,
		downloadSVG: "下载SVG 矢量图" , 
		exportButtonTitle: "导出图片" ,
		downloadCSV: "下载 CSV" , 
		downloadXLS: "下载 XLS" 
	 },
	 credits: {
	   enabled:false
	 }
});
Highcharts.setOptions(Highcharts.theme);
$(function () {
	loadHighchart();
});
function loadHighchart(){
	var city = $("#cityId :selected").text();
	var area = $("#areaId :selected").text();
	if(city=='--所属城市--'){
		city="";
	}   
	if(area=='--所属地区--'){
		area="";  
	}
	var chart = new Highcharts.Chart({
        chart: {
	    		renderTo: 'container',
            type: 'spline',
           	margin: 75,  
           	options3d: {
                   enabled: true,    
                   alpha: 0,      
                   beta: 0,  
                   viewDistance: 25,  
	               	   depth: 40  	
               }	  
        },  
        title: {
            text:city+area+'一周学习人数',
				style: {
                color: '#4572A7'
				}
        },
        xAxis: {
        	categories:["周一","周二","周三","周四","周五","周六","周日"]
        },
        yAxis: {
            min:0, 
	            tickInterval:1000,   
            title: {  
                text: '学习人数(个)',
					style: {
						color: '#89A54E' 
					}   
            },
				labels: {
					format: '{value}',
					style: {
						color: '#89A54E' 
					}
				}
        },
        tooltip: {
            valueSuffix: '个'
        },
        plotOptions: {
            bar: {  
                dataLabels: {
                    enabled: true  
                }
            },
            spline: {
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }  
        },
        legend: {
            layout: 'horizontal',  
            align: 'right',    
            verticalAlign: 'top',
            x:-30,
            floating: true, 
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [
						{
							name:"人数:",
							color: '#4572A7',
							data:initData()
						}
					]
    }); 
}
function changeTenant(){				
	var tenantId = $("#tenantId").val();
		$.post("${ctx}/count/graphics/studycountgraphics!getPrograms.excsec",{"tenantId":tenantId},function(data) {
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
		loadHighchart();
}
function initData(){  
	var arrayValue = new Array(); 
	$.post("${ctx }/count/graphics/studycountgraphics!getprogramsweekcountdata.excsec?programesId="+$("#programesId").val(),function(data) {
		var arrayObj = data.toString().split(",");　
		$(arrayObj).each(function(index){ 
			arrayValue.push(parseInt(arrayObj[index]));
		});
	});
	return arrayValue; 
}
</script>
</body>
</html>