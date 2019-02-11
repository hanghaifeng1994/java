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
	<jsp:param value="areahege" name="menu" />
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
<li class="active">地区学习情况</li>
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
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areahege.action">地区合格情况</a></li>
        <li class="active"><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areastudycomplete.action">地区学习率情况</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areawell.action">地区优秀情况</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!areaclazzcomplete.action">地区班级合格率</a></li>
    </ul>                
</div> 
 <div class="panel panel-default  mt10 mb10" >  
  <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" >
   <input type="hidden" name="filter" id="filter" value="${filter}" />
<div class="form-group" style="float: left"> 
<div class="form-group" <s:if test="cityId!=null">style="display: none;"</s:if> >
	  	<label>所属城市</label>
	  	<s:select list="citysVLists" onchange="loadHighchart();" listKey="id" listValue="name" id="cityId" name="cityId" value="cityId" theme="simple" headerValue="--所属城市--" headerKey="" cssClass="form-control" ></s:select>
</div>

    <div class="form-group">
	  	<label>数据说明：地区合格率=地区合格人数/地区报名人数	</label>
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
var arrayValue = {
		diqu:[],
		hegeNum:[],
		isNotHegeNum:[], 
		hegeRate:[]
};
$(function () {
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
            text:'地区学习率柱状图',
				style: {
                color: '#4572A7'
            }
        },
        xAxis: {
        	//categories:["南长","江阴","北塘","崇安","滨湖","惠山","崇安","锡山","新区","宜兴"]
        	categories : arrayValue.diqu
        },
        yAxis: {
            min:0, 
	            tickInterval:1,   
            title: {  
                text: '学习率',
					style: {
						color: '#89A54E'
					}
            },
				labels: {
					style: {
						color: '#89A54E'
					}
				},
        },
        tooltip: {
            valueSuffix: '%'
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
        credits: {
            enabled: false
        },
        series: [
                 	{
						color: '#4572A7',
						name:"地区",
						//data:[20,12,34,12,65,31,25,67,43,23]
						data : arrayValue.studyRate
					}
				]
    }); 
} 
function initData(){ 
 	$.post("${ctx }/count/graphics/studycountgraphics!getdiquHighchartData.excsec",{cityId:$("#cityId").val(),areaId:'${areaId}',filter:'${filter}',tenantId:'${currentTenant.id}'},function(data) {
 		arrayValue.diqu =  data.diqu;
 		//alert(arrayValue.diqu);
 		//arrayValue.baomingNum =  parseIntArray(data.baomingNum);
 		//arrayValue.studyNum = parseIntArray(data.studyNum);
		arrayValue.studyRate = parseIntArray(data.studyRate);	
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

</script>
</body>
</html>