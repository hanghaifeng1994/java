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
	<jsp:param value="areasignup" name="menu" />
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
<li class="active">地区报名情况</li>
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
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areasignup.action">报名学习情况</a></li>
        <li class="active"><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areaagesex.action">年龄性别比例</a></li>
    </ul>                
</div> 
 <div class="panel panel-default  mt10 mb10" >  
 
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" >
<div class="form-group" style="float: left"> 
<div class="form-group" <s:if test="cityId!=null">style="display: none;"</s:if> >
	  	<label>所属城市</label>
	  	<s:select list="citysVLists" onchange="changecity();loadHighchart()" listKey="id" listValue="name" id="cityId" name="cityId" value="cityId" theme="simple" headerValue="--所属城市--" headerKey="" cssClass="form-control" ></s:select>
</div>

<div class="form-group" <s:if test="areaId!=null">style="display: none;"</s:if> >
	  	<label>所属地区</label>
	  	<s:select cssClass="form-control" onchange="loadHighchart()" list="areaVLists" listKey="id" listValue="name" id="areaId" name="areaId" theme="simple" value="cantonId" headerKey="" headerValue="--所在地区--" />
</div>
    <div class="form-group">
	  	<label>数据说明：不同年龄段的性别构成	</label>
	</div>
</div>       
<div style="clear: both;"></div> 
  
</form>
 </div>
<div id="container" style="width:33%;height: 550px;margin-bottom: 10px;float:left;"></div>  
<div id="container2" style="width:33%;height: 550px;margin-bottom: 10px;float:left;"></div>
<div id="container3" style="width:34%;height: 550px;margin-bottom: 10px;float:left;"></div>

</div>
<!--正文结束-->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->  	
</section>
</div>
<script type="text/javascript">
$.ajaxSetup({
	  async: false
});
var arrayValue = {
		ageMale:[],
		ageFemale:[],
		ageUnknow:[]
};
var totalAgeMale = 0;
var totalAgeFeMale = 0;
var totalAgeUnknow = 0;
var ageSex1 = 0;
var ageSex2 = 0;
var ageSex3 = 0;
var ageSex4 = 0;
var ageSex5 = 0;
$(function () {
	changecity();
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
    loadHighchart();
});

 function loadHighchart(){
	 arrayValue = initData();
	 var chart = new Highcharts.Chart({
	            chart: {
		    		renderTo: 'container',
	                type: 'column',
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
	                text:'年龄段人数柱状图',
					style: {
	                    color: '#4572A7'
	                }
	            },
	            xAxis: {
	            	categories:["0-20岁","20-30岁","30-40岁","40-50岁","50岁以上"]
	            },
	            yAxis: {
	                min:0, 
	 	            tickInterval:100,   
	                title: {
						text: '人数',
						style: {
							color: '#89A54E'
						}
					},
					labels: {
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
	                column: {
					    stacking: 'normal',
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
	                y:30,
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
							    color: '#4572A7',
								name:"男",
								//data:[20,120,3400,100,650]
								data:arrayValue.ageMale
							},
							{
								name:"女",
								//data:[30,1200,300,1200,650]
								data:arrayValue.ageFemale
							},
							{
								color: '#FFD700',
								name:"未知",
								//data:[30,1200,300,1200,650]
								data:arrayValue.ageUnknow
							}
							
						]
	        });

		$('#container2').highcharts({ 
				chart: { type: 'pie', options3d: { enabled: true, alpha: 45, beta: 0 } }, 
				title: { text: '年龄段占比饼图',style: { color: '#4572A7'} }, 
				tooltip: { pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>' }, 
				plotOptions: { 
								pie: {
										allowPointSelect: true, 
										cursor: 'pointer', 
										depth: 35, 
										dataLabels: { enabled: true, format: '{point.name}' },
										showInLegend: true
									 } 
							},
				series: [
					{ type: 'pie',
					  name: '年龄段所占', 
					  data: [
								['0-20岁', ageSex1],//25
								['20-30岁', ageSex2], //37
								{ name: '30-40岁', y: ageSex3, sliced: true, selected: true },//23
								//['30-40岁', 23], 
								['40-50岁', ageSex4], //10
								['50岁以上', ageSex5]//5
							] 
					}] 
		}); 		

	$('#container3').highcharts({ 
			chart: { type: 'pie', options3d: { enabled: true, alpha: 45, beta: 0 } }, 
			title: { text: '性别占比饼图',	style: { color: '#4572A7' } }, 
			tooltip: { pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>' }, 
			plotOptions: { 
							pie: {
									allowPointSelect: true, 
									cursor: 'pointer', 
									depth: 35, 
									dataLabels: { enabled: true, format: '{point.name}' },
									showInLegend: true
								 } 
						},
			series: [
				{ type: 'pie',
				  name: '性别所占', 
				  data: [
							{name:'男', y: totalAgeMale, sliced: true, selected: true },
							['女', totalAgeFeMale],
							['未知', totalAgeUnknow]
						] 
				}] 
	});

 }
function changecity(){				
	var cityId = $("#cityId").val();
	if(cityId) {
				$.post("${ctx}/count/manage/studentcount!getAreaJson.excsec",{"cityId":cityId},function(data) {
					$("#areaId option[value!='']").remove();
					var practiceUnit = eval(data);
					if(practiceUnit.length == 0) $("#areaId option[value!='']").remove();
					for(var i = 0 ;i < practiceUnit.length ; i++) {
						if("${areaId}"==practiceUnit[i].value){
							$("#areaId").append("<option selected='selected' value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
						}else{
							$("#areaId").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
						}
					}
				});
	}else {
		//$("#areaId").html("headerValue","--所在地区--");
	}
	//loadHighchart();
}

 function initData(){ 
	 	$.post("${ctx }/count/graphics/studycountgraphics!getdiquAgeHighchartData.excsec",{cityId:$("#cityId").val(),areaId:$("#areaId").val(),tenantId:'${currentTenant.id}'},function(data) {
	 		arrayValue.ageMale =  parseIntArray(data.ageMale);
	 		arrayValue.ageFemale =  parseIntArray(data.ageFeMale);
	 		arrayValue.ageUnknow = parseIntArray(data.ageUnknow);
	 		var temp = extend(extend(arrayValue.ageMale,arrayValue.ageFemale),arrayValue.ageUnknow);
	 		ageSex1 = temp[0];
	 		ageSex2 = temp[1];
	 		ageSex3 = temp[2];
	 		ageSex4 = temp[3];
	 		ageSex5 = temp[4];
	 		totalAgeMale = getTotal(arrayValue.ageMale);
	 		totalAgeFeMale = getTotal(arrayValue.ageFemale);
	 		totalAgeUnknow = getTotal(arrayValue.ageUnknow);
	 	});
	 	return arrayValue; 
}
 
function parseIntArray(array){
		var returnArray = new Array();
		$(array).each(function(index){ 
			returnArray.push(parseInt(array[index]));
		});
		return returnArray;
}	

function extend(jsonData1,jsonData2){
	var temp =[];
	for(var item in jsonData2){
		temp[item] = jsonData1[item]+jsonData2[item];
	}
	return temp;
}

function getTotal(jsonData1){
	var total = 0;
	for(var item in jsonData1){
		total += jsonData1[item];
	}
	return total;
}
</script>
</body>
</html>