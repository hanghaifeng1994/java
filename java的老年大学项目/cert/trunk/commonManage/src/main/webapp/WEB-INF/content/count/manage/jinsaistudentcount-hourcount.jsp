<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.user.dto.UserDTO"%>
<%@page import="com.drcl.traincore.user.util.UserUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>竞赛统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<s:set name="user" value="@com.drcl.traincore.user.util.UserUtils@getCurUser()"></s:set>
<script src="${staticurl}/js/HighChart/highcharts.js"></script>
<script src="${staticurl}/js/HighChart/modules/exporting.js"></script>
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
	<jsp:param value="cityCount" name="menu" />
	<jsp:param value="jinsai" name="bigmenu" />
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
<a href="#">竞赛统计</a>
</li>
<li class="active">市级竞赛统计</li>
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
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/jinsaistudentcount!hourcount.action" method="post">
<div class="dr-searchbar">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="export" value="false" id="export"/>
<div class="form-group">
	<label>所属项目</label>
	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" 
			headerKey="" cssClass="form-control" name="programesId"></s:select>
</div>
<div class="form-group">
<button class="btn btn-default btn-sm" type="button" onclick="$('#export').val('false');document.mainForm.submit();">
<span class="glyphicon glyphicon-search"></span>
  搜索
</button>
</div>
</div>
</form>
<div class="bs-example" > 
	<ul class="nav nav-tabs nav-justified" id="tab">
        <li><a style="cursor: pointer;" href="${ctx }/count/manage/jinsaistudentcount!groupcount.action">参赛人数统计</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/manage/jinsaistudentcount!schoolcount.action">参数学校统计</a></li>
        <li><a style="cursor: pointer;" href="${ctx }/count/manage/jinsaistudentcount!areacount.action">参赛区域统计</a></li>
        <li class="active"><a style="cursor: pointer;" href="${ctx }/count/manage/jinsaistudentcount!hourcount.action">24小时人数统计</a></li>
    </ul>                
</div>
 <div class="panel panel-default  mt10 mb10" >
 	<div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>
</div>
</div>  
</section> 
<!--正文结束-->  
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</div>
	<script type="text/javascript">
$(function () {
	 Highcharts.setOptions({
         lang: {
                                 　  printChart:"打印图表",
               downloadJPEG: "下载JPEG 图片" , 
               downloadPDF: "下载PDF文档"  ,
               downloadPNG: "下载PNG 图片"  ,
               downloadSVG: "下载SVG 矢量图" , 
               exportButtonTitle: "导出图片" 
         },
         credits: {
      	   enabled:false
		 }
     });
    $('#container').highcharts({
        chart: {
            zoomType: 'x'
        },
        title: {
            text: '24小时参赛人数统计'
        },
        subtitle: {
            text: ''
        },
        xAxis: { 
        	  categories: ['00:00','01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00'
        	               , '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00'
        	               , '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
        },  
        yAxis: {
            title: {
                text: '参赛人数'
            },
            min:0, // 定义最小值  
            tickInterval:1 // 刻度值  
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            area: {
                fillColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                },
                marker: {
                    radius: 2
                },
                lineWidth: 1,
                states: {
                    hover: {
                        lineWidth: 1
                    }
                },
                threshold: null
            }  
        },

        series: [{
            type: 'area',
            name: '参赛人数', 
            data: initData()
        }]
    });
});
//关闭ajax异步请求 为了取值可以正常
$.ajaxSetup({
	  async: false
});
function initData(){ 
	var arrayValue = new Array(); 
	$.post("${ctx }/count/manage/jinsaistudentcount!gethourcountdata.excsec?programesId="+$("#programesId").val(),function(data) {
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