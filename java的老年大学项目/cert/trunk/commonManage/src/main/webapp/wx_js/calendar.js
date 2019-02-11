var lastDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);  
//判断是否为闰年     
function isBissextile(year){     
 var isBis = false;     
 if (0==year%4&&((year%100!=0)||(year%400==0))) {     
  isBis = true;     
 }     
 return isBis;     
} 
//计算某月的总天数，闰年二月为29天     
function getMonthCount(year,month){     
 var Mcount = lastDay[month-1];     
 if((month==2)&&isBissextile(year)){  
  Mcount++;  
 }   
 return Mcount;     
}     
//计算某天是星期几  
function thisWeekDay(year,month,date){  
var d = new Date(year,month-1,date);  
return d.getDay();  
} 

function initCal(year,month,completeDays){
	var curDay = new Date().getDate()
	//先判断1号是星期几
	var weekday = thisWeekDay(year,month,1);
	//completeDays=","+completeDays;
	//总天数
	var totalDays = getMonthCount(year,month);
	for(var i =0;i<totalDays;i++){
		var xuhao = i+weekday;
		var innerhtml=i+1;
		if(curDay==innerhtml){
			document.getElementById("c_"+xuhao).className = "today";
		} 
			$("#c_"+xuhao).html(innerhtml);
		
		//if(completeDays.indexOf(","+innerhtml)>-1){
			//innerhtml=innerhtml+"<i></i>";
			//document.getElementById("c_"+xuhao).className = "complete";
		//}
	}
	var completeDaysArry=new Array(); 
	var completeDays = completeDays+""; 
	if(completeDays!="")
	completeDaysArry = completeDays.split(",");
	for(var j = 0;j<completeDaysArry.length;j++){
		var com = parseInt(completeDaysArry[j]-1)+parseInt(weekday); 
		//var com = completeDaysArry[j]-1;
		document.getElementById("c_"+com).className = "complete";
		document.getElementById("c_"+com).innerHTML = completeDaysArry[j]+"<i></i>";
	}
	
}
