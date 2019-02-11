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
<style type="text/css">
.highchart-btn{
	background-color:#6BB72E !important;
	color: white !important;
}
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学情统计<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
 	<link href="${ctx}/css/pageGroup.css" type="text/css" rel="stylesheet"/>
    <script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/pageGroup.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script> 
	<script src="${staticurl}/js/HighChart/highcharts.js"></script>
	<script src="${staticurl}/js/HighChart/highcharts-3d.js"></script>
	<script src="${staticurl}/js/HighChart/themes/sand-signika.js"></script> 
	<script src="${staticurl}/js/HighChart/modules/exporting.js"></script>   
	<script src="${staticurl}/js/HighChart/modules/export-excel.js"></script>  
	<script type="text/javascript">
		function changeTenant(){				
			var tenantId = $("#tenantId").val();
				$.post("${ctx}/count/manage/learningsituation!getPrograms.excsec",{"tenantId":tenantId},function(data) {
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
       <li><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituationclazz.action">班级学情统计</a></li>
       <li class="active"><a style="cursor: pointer;" href="${ctx }/count/manage/learningsituationclazz!highchart.action">班级图表统计</a></li>
   </ul>                
</div> 
	<!--页面标题-->
<div>
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="${ctx}/count/manage/learningsituationclazz.action" method="post">
<div class="dr-searchbar" style="margin-bottom:0px;">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<div class="form-group" style="float: left"> 
	<s:if test="currentTenant == null ">
	<label>租户</label>
	<s:select list="tenantLists" listKey="id"  onchange="changeTenant()"
		id="tenantId"   value="tenantId" listValue="name" theme="simple" headerValue="--选择租户--"
		headerKey="" cssClass="form-control input-sm" name="tenantId"></s:select>
</s:if>
	  	<label>所属项目: </label> 
	  	<s:select list="programesLists" listKey="id" value="programesId" listValue="name" theme="simple" 
		headerValue="--所属项目--"	headerKey="" cssClass="form-control" name="programesId" onChange="loadHighchart(4,1);"></s:select>
	    &nbsp; 单日时间设置：    
		<input id="startTime" style="width: 100px" value="${startTime }" class="form-control input-sm"/>
		-     
		<input id="endTime"   style="width: 100px" value="${endTime }" class="form-control input-sm"/>
</div>   
<div class="form-group" id="highchart_type" style="float: left">  
 		<label>图表信息: </label>   
 		<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
 			<button class="btn btn-sm highchart-btn" type="button"   onclick="loadHighchart(4,1)" id="highchart_4">通过率</button>
		</s:if>
		<s:else>
			<button class="btn btn-sm highchart-btn" type="button"   onclick="loadHighchart(4,1)" id="highchart_4">及格率</button>
		</s:else> 
	  	<button class="btn btn-sm " type="button"   onclick="loadHighchart(2,1)" id="highchart_2">作业完成率</button>
	  	<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
			
		</s:if>
		<s:else>
	  	<button class="btn btn-sm " type="button"   onclick="loadHighchart(3,1)" id="highchart_3">研修成果完成率</button>
	  	</s:else>
	  	<button class="btn btn-sm " type="button"   onclick="loadHighchart(1,1)" id="highchart_1">学习率</button>
	    <button class="btn btn-sm " type="button"   onclick="loadHighchart(5,2)" id="highchart_5">学习人数</button>
	    <button class="btn btn-sm " type="button"   onclick="loadHighchart(6,3,'总班级')" id="highchart_6">24小时人数</button>
		<button class="btn btn-sm " type="button"   onclick="loadHighchart(7,4,'总班级')" id="highchart_7">单日学习时长</button>
</div>         
<div style="clear: both;"></div>
</div> 
</form>
<div class="panel panel-default  mt10 mb10">
<div id="container" style="width:100%;height: 500px;margin-bottom: 10px;"></div>
<div style="width:100%;height: 550px;"> 
<table  class="table table-bordered dr-table-bordered" id="highchart-table" style="font-size: 12px !important;">    
</table>
<div id="pageGro" style="margin-bottom: 30px;">
	<div class="pageUp">上一页</div>
    <div class="pageList">  
        <ul style="list-style:none;padding-left: 0px;">
            <li>1</li>
        </ul>
    </div>
    <div class="pageDown">下一页</div>
</div>
</div>
</div>
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
<script type="text/javascript">
$("#startTime").datetimepicker({
	 customFormat: "yyyy-mm-dd",
	 format: "yyyy-mm-dd",
	 language:'zh-CN',
	 weekStart: 1,
	 autoclose: 1,
	 todayHighlight: 1,
	 startView: 2,
	 minView: 2,
	 forceParse: 0,
}); 
$("#endTime").datetimepicker({
	 customFormat: "yyyy-mm-dd",
	 format: "yyyy-mm-dd",
	 language:'zh-CN',
	 weekStart: 1,
	 autoclose: 1,
	 todayHighlight: 1,
	 startView: 2,
	 minView: 2,
	 forceParse: 0,
}); 
//关闭ajax异步请求 为了取值可以正常
$.ajaxSetup({
	  async: false
});
var arrayValue = {
	 		banji:[],
	 		canyu:[],
	 		zuoye:[], 
	 		yanxiu:[], 
	 		jige:[],
	 		xuexi:[],
	 		baoming:[],
	 		weicanjia:[]
	};    
var pageCount = 0;
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
    loadHighchart(4,1);
});  
function loadHighchart(type,htype,typename){
		$('#highchart_type').find("button").removeClass("highchart-btn");
		$('#highchart_'+type).addClass("highchart-btn");
		if(htype ==1){
			arrayValue = initData(); 
			createHtml(1);   
		    initPage();
			var series = [];
			if(type==1){
				series.push({ 
		            name: '学习率',
		            data: arrayValue.canyu
		        });
			}else if(type==2){
				series.push({
		            name: '作业完成率',
		            data: arrayValue.zuoye
		        });
			}else if(type==3){
				series.push({
		            name: '研修成果完成率',
		            data: arrayValue.yanxiu
		        });
			}else if(type==4){
				series.push({
		            name: '及格率',
		            data: arrayValue.jige
		        });
			}
		    chart = new Highcharts.Chart({
	            chart: {
		    		renderTo: 'container',
	                type: 'column',
                	margin: 75,
                	options3d: {
                        enabled: true,
                        alpha: 0,
                        beta: 0, 
                        depth: 40, 
                        viewDistance: 25
                    }	
	            },
	            title: {
	                text: $("#programesId").find("option:selected").text()+'学情统计图'
	            },
	            xAxis: {
	            	categories:arrayValue.banji
	            },
	            yAxis: {
	                min:0, 
	 	            max:100, 
	 	            tickInterval:1,    
	                title: {
	                    text: '百分比(%)',
	                    align: 'high'
	                }
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
	                layout: 'vertical',
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
	            series: series
	        });
		}else if(htype ==2){  
		    chart = new Highcharts.Chart({
	            chart: {
		    		renderTo: 'container',
		            type: 'column',
		            options3d: {
		                enabled: true,
		                alpha: 0,
		                beta: 0,
		                viewDistance: 25,
		                depth: 40
		            }
		        },
		        title: {
		            text: '班级学情统计图'
		        },
		        xAxis: {
		        	categories:arrayValue.banji
		        },
		        yAxis: {
		            allowDecimals: true,
		            min: 0,
		            title: {
	                    text: '人数(个)',
	                    align: 'high'
	                }
		        },
	            legend: {
	                layout: 'vertical',
	                align: 'right', 
	                verticalAlign: 'top',
	                x:-30,
	                floating: true, 
	                borderWidth: 1,
	                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
	                shadow: true
	            },
		        tooltip: {
		            headerFormat: '<b>{point.key}</b><br>',
		            pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y} / {point.stackTotal}'
		        },
		        plotOptions: {
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
		        series: [{
		            name: '未学习人数',
		            data: arrayValue.weicanjia,
		            stack: 'male'
		        }, {
		            name: '学习人数',
		            data: arrayValue.xuexi,
		            stack: 'male'
		        }]
		    });
		}else if(htype ==3){  
			document.documentElement.scrollTop = document.body.scrollTop =50;  
		    chart = new Highcharts.Chart({    
	            chart: {    
		    		   renderTo: 'container',
		    		   type: 'spline'
			        },  
			        title: {
			            text: '24小时学习人数统计'
			        },
			        xAxis: { 
			        	  categories: ['00:00','01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00'
			        	               , '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00'
			        	               , '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
			        },  
			        yAxis: {
			            title: {
			                text: '学习人数'
			            },
			            min:0, 
			            tickInterval:1 
			        },
			        legend: {
		                layout: 'vertical',
		                align: 'right',   
		                verticalAlign: 'top',
		                x:-30,
		                floating: true, 
		                borderWidth: 1,
		                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
		                shadow: true
		            },
			        plotOptions: {
			        	spline: {
			                dataLabels: {
			                    enabled: true
			                },
			                enableMouseTracking: true
			            }
			        },  
			        series: loadDiquClazz24HourData(typename)
			    }); 
		}else if(htype ==4){  
			if(Date.parse($("#startTime").val())>Date.parse($("#endTime").val())){
				alert("开始时间不能大于结束时间");
				return;
			}
			document.documentElement.scrollTop = document.body.scrollTop =50;  
		    chart = new Highcharts.Chart({
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
	                text:'单日学习时长统计图'
	            },
	            xAxis: {
	            	categories:computeTime()
	            },
	            yAxis: {
	                min:0, 
	 	            tickInterval:1,   
	                title: {  
	                    text: '分钟(min)',
	                    align: 'high'    
	                }
	            },
	            tooltip: {
	                valueSuffix: '分钟'
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
	                floating: true, 
	                borderWidth: 1,
	                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
	                shadow: true
	            },
	            credits: {
	                enabled: false
	            },
	            series: loadDiquClazzDateHourData(typename)
	        }); 
		}
	}
	function computeTime(){    
		var dates = new Array();
		var startDate = Date.parse($("#startTime").val());  
		var endDate = Date.parse($("#endTime").val());
		var length = (endDate-startDate)/(1000*60*60*24);
		for(var i =0;i<=length;i++){
			dates.push(formartDate(new Date(startDate+i*1*24*60*60*1000)));
		}  
		return dates;
	}
	
	function formartDate(date){
		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	}

  function loadDiquClazzDateHourData(typename){
    	var sdata = new Array(); 
		$.post("${ctx }/count/manage/learningsituation!loadDiquClazzDateHourData.excsec?typeName="+typename+"&startTime="+Date.parse($("#startTime").val())+"&endTime="+Date.parse($("#endTime").val())+"&programesId="+$("#programesId").val(),function(data) {
			var arrayObj = data.toString().split(",");　
			$(arrayObj).each(function(index){   
				sdata.push(parseInt(arrayObj[index]));  
			});
	 	});  
		return [{
            name: typename, 
            data: sdata
        }];
    }
	function loadDiquClazz24HourData(typename){
		var sdata = new Array(); 
		$.post("${ctx }/count/manage/learningsituation!loadDiquClazz24HourData.excsec?typeName="+typename+"&programesId="+$("#programesId").val(),function(data) {
			var arrayObj = data.toString().split(",");　
			$(arrayObj).each(function(index){   
				sdata.push(parseInt(arrayObj[index]));  
			});
	 	});  
		return [{
	        name: typename, 
	        data: sdata
	    }];
	}
	function initData(){ 
	 	$.post("${ctx }/count/manage/learningsituationclazz!getHighchartData.excsec?programesId="+$("#programesId").val(),{tenantId:$("#tenantId").val()},function(data) {
	 		    arrayValue.banji =  data.banji;
		 		arrayValue.canyu =  parseIntArray(data.canyu);
		 		arrayValue.zuoye =  parseIntArray(data.zuoye);
				arrayValue.yanxiu = parseIntArray(data.yanxiu);
				arrayValue.jige =   parseIntArray(data.jige);
				arrayValue.xuexi = parseIntArray(data.xuexi);
				arrayValue.baoming =   parseIntArray(data.baoming);
				arrayValue.weicanjia =   parseIntArray(data.weicanjia);
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
	function createHtml(currrentPage){
		var zjOpen = false;
		var isahstudyopen = '<%=request.getAttribute("isahstudyopen")%>';
		if(isahstudyopen) zjOpen = true;
		var isHbddOpen = '<%=request.getAttribute("isHbddOpen")%>';
		if(isHbddOpen) zjOpen = true;
		var html =  '<tr>'+	
					'<th width="40px;">地区</th>';
		if(zjOpen){
			html+='<th width="40px;">通过率</th>';
		}else{
			html+='<th width="40px;">及格率</th>';
		}
		html+='<th width="50px;">作业完成率</th>';
					
		if(zjOpen){
			
		}else{
			html+='<th width="60px;">研修成果完成率</th>';
			}		
		html+='<th width="60px;">学习率</th>'+
					'<th width="60px;">学习人数</th>'+
					'<th width="60px;">报名人数</th>'+
					'<th width="60px;">操作</th>'+
					'</tr>'; 
		var length = arrayValue.banji.length; 
		//每页显示10条  
		var pageTotal = 9; //每页显示10条      
		pageCount = length%(pageTotal+1)==0? parseInt(length/(pageTotal+1)):parseInt(length/(pageTotal+1))+1;//页数
		var currrentPage = currrentPage;//当前页数
		var startCount = (currrentPage-1)*pageTotal;
		var endCount = startCount+pageTotal;
		for(var i=0;i<length;i++){ 
			if(i>=startCount&&i<=endCount){
				html+='<tr>';
						html+='<td>'+arrayValue.banji[i]+'</td>';
						for(var j=0 ;j<7;j++){  
							if(j==0){
								html+='<td>'+arrayValue.jige[i]+'%</td>';
							}else if(j==1){
								html+='<td>'+arrayValue.zuoye[i]+'%</td>';
							}else if(j==2){
								if(zjOpen){
								
								}else{
									html+='<td>'+arrayValue.yanxiu[i]+'%</td>';
									}
							}else if(j==3){
								html+='<td>'+arrayValue.canyu[i]+'%</td>';
							}else if(j==4){
								html+='<td>'+arrayValue.xuexi[i]+'</td>';
							}else if(j==5){
								html+='<td>'+arrayValue.baoming[i]+'</td>';
							}else if(j==6){
								html+='<td><button class="btn btn-sm highchart-btn " type="button"   onclick="loadHighchart(6,3,\''+arrayValue.banji[i]+'\');">24小时人数</button>&nbsp;'+
							   	  '<button class="btn btn-sm highchart-btn" type="button"   onclick="loadHighchart(7,4,\''+arrayValue.banji[i]+'\')" >单日学习时长</button></td>';
							}
						}
				html+='</tr>';   
			}  
		}
        $('#highchart-table').html(html);
	}
	$("#download").click(function(){ 
	      Highcharts.post('http://export.hcharts.cn/cvs.php', {
	        csv: chart.getCSV()
	      });
	 })
</script> 
</body>
</html>