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
	<jsp:param value="clazzsignup" name="menu" />
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
<li class="active">项目班级统计</li>
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
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzsignup.action">班级报名统计</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzstudycomplete.action">班级学习率情况</a></li>
        <li  class="active"><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzhegecomplete.action">班级合格情况</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzscore.action">班级各项成绩</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzscorecomplete.action">班级得分率情况</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/graphics/studycountgraphics!clazzavgsocore.action">班级平均成绩</a></li>
    </ul>                
</div> 
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
	  	<label>数据说明：合格率=班级学员合格人数/班级学员总人数	</label>
	</div>
</div>       
<div style="clear: both;"></div> 
</div>  
</form> 
<div id="container" style="min-width: 310px; margin: 0 auto"></div>
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
$(function() {
	loadHighchart();
});
function loadHighchart(){
	    $('#container').highcharts({
	        chart: {
				zoomType: 'xy',
				type: 'bar'	
	        },
	        title: {
	            text: '项目班级合格情况柱状图',
				style: {
					color: '#4572A7'
				}
	        },
	        xAxis: {
	            categories: loadxAxis()
	        },
	        yAxis: [{
				min:0, 
				tickInterval:1,   
	            title: {
	                text: '人数(个)'
	            },
	        	labels: {
	                format: '{value} ',
	                style: {
	                    color: '#89A54E' 
	                }
            	}
	        },{ 
				min:0, 
				tickInterval:1,   
	            title: {
	                text: '合格率',
	                style: {
	                    color: '#4572A7'
	                }
	            },
	            labels: {
	                format: '{value} %',
	                style: {
	                    color: '#4572A7' 
	                }
	            },
				opposite: true
				}],
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
	            series: {
	                stacking: 'normal'
	            },
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
	                    }
	                }  
	        },				
	        series: [{
	            name: '合格人数',
	            color: '#89A54E',
				yAxis: 0,
				type: 'column',
	            data: inithegeData(),
	            zIndex:1000
	           }, 
	           {name: '不合格人数',
	            color:"#f45b5b", 
				type: 'column',
				yAxis: 0, 
	            data: initbuhegeData(),
	            zIndex:1000
	           }, 
	           {name: '合格率',
				type: 'spline',
			    color: '#89A54E',
				yAxis: 1,
				data:inithegelvData(),
				tooltip: {
					valueSuffix: '%'
				},
				zIndex:50
				}]
	    });
}
function loadxAxis(){	
	var res = new Array(); 
	var programesId = $("#programesId").val(); 
		if(programesId) {
			$.post("${ctx}/count/graphics/studycountgraphics!getProgramJson.excsec",{"programesId":programesId},function(data) {
				var practiceUnit = eval(data);
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					res.push(practiceUnit[i].label);
				}
			});
	}
	if(res.length<5){
		$("#container").css("height","400px");    
	}else{ 
		$("#container").css("height",(40*res.length)+"px");
	}
	return res; 
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
			loadHighchart();
		});
}
function inithegeData(){  
	var arrayValue = new Array(); 
	$.post("${ctx }/count/graphics/studycountgraphics!gethegecountdata.excsec?parameter=0&programesId="+$("#programesId").val(),function(data) {
		var arrayObj = data.toString().split(",");　
		$(arrayObj).each(function(index){ 
			arrayValue.push(parseInt(arrayObj[index]));
		});
	});
	return arrayValue; 
}	
function initbuhegeData(){  
	var arrayValue = new Array(); 
	$.post("${ctx }/count/graphics/studycountgraphics!gethegecountdata.excsec?parameter=1&programesId="+$("#programesId").val(),function(data) {
		var arrayObj = data.toString().split(",");　
		$(arrayObj).each(function(index){ 
			arrayValue.push(parseInt(arrayObj[index]));
		});
	});
	return arrayValue; 
}
function inithegelvData(){  
	var arrayValue = new Array(); 
	$.post("${ctx }/count/graphics/studycountgraphics!gethegecountdata.excsec?parameter=2&programesId="+$("#programesId").val(),function(data) {
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