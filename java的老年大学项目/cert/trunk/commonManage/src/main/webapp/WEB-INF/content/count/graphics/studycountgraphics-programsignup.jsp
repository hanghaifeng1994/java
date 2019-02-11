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
	<jsp:param value="programSignup" name="menu" />
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
<li class="active">项目报名情况</li>
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
        <li class="active"><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programSignup.action">项目报名学习情况</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!programAgeSex.action">项目年龄性别比例</a></li>
    </ul>                
</div> 
 <div class="panel panel-default  mt10 mb10" >  
 <form class="form-inline dr-form-inline" id="mainForm" name="mainForm" >
<div class="form-group" style="float: left"> 
	<div class="form-group" <s:if test="filter==1">style="display: none;"</s:if> > 
					  	<label>租户</label>
					  	<s:select list="tenantLists" listKey="id" onchange="loadHighchart()" id="tenantId"   value="tenantId" listValue="name" theme="simple" 
						 cssClass="form-control input-sm" name="tenantId"></s:select>
	</div>

    <div class="form-group">
	  	<label>数据说明：项目学习率=项目学习人数/项目报名人数	</label>
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
<script><!--
//关闭ajax异步请求 为了取值可以正常
$.ajaxSetup({
	  async: false
});
var arrayValue = {
 		program:[],
 		baomingNum:[],
 		studyNum:[], 
 		studyRate:[]
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
	$('#container').highcharts({
        chart: {
            zoomType: 'xy',
			options3d: {
			   enabled: true,    
			   alpha: 0,      
			   beta: 0,  
			   viewDistance: 25,  
			   depth: 40  	
		   }	
        },
        title: {
            text: '注册情况-总表',
			style: {
                    color: '#4572A7'
            }
        },
        xAxis: [{
            //categories:["南长","江阴","北塘","崇安","滨湖","惠山","崇安","锡山","新区","宜兴"]
        	categories:arrayValue.program
        }],
        yAxis: [{ 
            labels: {
			    min:0, 
 	            tickInterval:1,   
                format: '{value}个',
                style: {
                    color: '#89A54E'
                }
            },
            title: {
                text: '注册人数',
                style: {
                    color: '#89A54E'
                }
            }
        }, { 
            title: {
                text: '学习率',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
				min:0, 
                format: '{value} %',
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
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
                column: {
                    dataLabels: {
                        enabled: true,
                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                        style: {
                            textShadow: '0 0 3px black'
                        }
                    },
                    pointPadding: 0.2,
                    borderWidth: 0,
                    pointWidth: 40
                   
                }  
            },
        series: [{
            name: '学习率',
            color: '#89A54E',
            type: 'spline',
			yAxis: 1,
            //data:[20,12,34,12,65,31,25,67,43,23],
            data : arrayValue.studyRate,
            tooltip: {
                valueSuffix: '%'
            },
            zIndex:999
        },{
            name: '注册人数',
            color: '#4572A7',
            type: 'column',
            yAxis: 0,
            //data:[202,132,234,312,465,531,225,617,443,523],
            data:arrayValue.baomingNum,
            tooltip: {
                valueSuffix: ' 个'
            },
        	zIndex:1000
        }]
    });
}

function initData(){ 
 	$.post("${ctx }/count/graphics/studycountgraphics!getProgramSignupdata.excsec",{tenantId:$("#tenantId").val()},function(data) {
 		arrayValue.program =  data.program;
 		arrayValue.baomingNum =  parseIntArray(data.baomingNum);
 		arrayValue.studyNum = parseIntArray(data.studyNum);
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

--></script>
</body>
</html>