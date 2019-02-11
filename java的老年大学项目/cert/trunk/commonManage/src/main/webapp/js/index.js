/** ***********************首页********************************** */

// 新闻焦点,理论研究,政策导航,期刊简报 的相互切换
function onShowNews(one, two, three, four,count, one_li, two_id, three_id, four_id) {
	document.getElementById(one).style.display = 'block';
	document.getElementById(two).style.display = 'none';
	document.getElementById(three).style.display = 'none';
	document.getElementById(four).style.display = 'none';
	document.getElementById(one_li).className = "news_mouse";
	document.getElementById(two_id).className = "";
	document.getElementById(three_id).className = "";
	document.getElementById(four_id).className = "";
	
	var top =  jQuery("#"+one_li).css("top");
	   
	if(count==1)  
		jQuery("#"+one_li).css("top","0px");
	else if(count==2)
		 
		jQuery("#"+one_li).css("top","41px");
	else if(count==3)
		jQuery("#"+one_li).css("top","82px");
	else if(count==4)
		jQuery("#"+one_li).css("top","123px");
}

// 点击展播栏目图片右下角数字时,显示DIV显示,切换图片滚动,切换文字显示
function show(num, objVal) {
	if (objVal == "实验示范") {
		document.getElementById("sjsf").style.display = "";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="./news/cityarea.action?intType=1";
		$("#sjsf").YlMarquee( {
			visible : 0,
			width : 473,
			step : 2
		}); 
	}
	if (objVal == "社区学院") {
		document.getElementById("sqxy").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="./news/cityarea.action?intType=2";
		$("#sqxy").YlMarquee( {
			visible : 0,
			width : 473,
			step : 2
		});
	}
	if (objVal == "社教中心") {
		document.getElementById("sjzx").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="./news/cityarea.action?intType=3";
		$("#sjzx").YlMarquee( {
			visible : 0,
			width : 473,
			step : 2
		});
	}
	if (objVal == "示范街镇") {
		document.getElementById("sfjz").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="./news/cityarea.action?intType=4";
		$("#sfjz").YlMarquee( {
			visible : 0,
			width : 473,
			step : 2
		});
	}

	if (objVal == "农科教基地") {
		document.getElementById("nkjjd").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="./news/cityarea.action?intType=5";
		$("#nkjjd").YlMarquee( {
			visible : 0,
			width : 473,
			step : 2
		});
	}
	if(num==5){
		document.getElementById('scorll_5').className = "picture_bottom_img2 ll";
		document.getElementById('scorll_1').className = "picture_bottom_img1 ll mr5";
		document.getElementById('scorll_2').className = "picture_bottom_img1 ll mr5";
		document.getElementById('scorll_3').className = "picture_bottom_img1 ll mr5";
		document.getElementById('scorll_4').className = "picture_bottom_img1 ll mr5";
	}else{
		for ( var i = 1; i <= 5; i++) {
			var val = document.getElementById('scorll_' + i);
			if (i == num) {
				val.className = "picture_bottom_img2 ll mr5";
			} else {
				val.className = "picture_bottom_img1 ll mr5";
			} 
		}  
	}
 
	for ( var i = 1; i <= 5; i++) {
		if (i == num) {
			document.getElementById('ta_c_' + i).className = "ta_c ll mr5 db";
			$("#ta_span_"+num).html(objVal)
		} else {
			document.getElementById('ta_c_' + i).className = "ta_c ll mr5 dn";
		} 
	}   
}

// 点击展播栏目中"more++"时,设置跳转路径
function onColums() {
	var valUrl = $('#colmnsShowUrlId').val();
	window.open(valUrl,"newwindow");
}

/**
 * 文字向上向下滚动
 */
(function($){
$.fn.extend({
	Scroll:function(opt,callback){
	//参数初始化
	if(!opt) var opt={};
	var _this=this.eq(0).find("ul:first");
	var        lineH=_this.find("li:first").height(), //获取行高
	line=opt.line?parseInt(opt.line,11):parseInt(this.height()/lineH,11), //每次滚动的行数，默认为一屏，即父容器高度
	speed=opt.speed?parseInt(opt.speed,11):500, //卷动速度，数值越大，速度越慢（毫秒）
	timer=opt.timer?parseInt(opt.timer,11):3000; //滚动的时间间隔（毫秒）
	if(line==0) line=1;
	var upHeight=0-line*lineH;
	//滚动函数
	scrollUp=function(){
	_this.animate({
	marginTop:upHeight
	},speed,function(){
	for(i=1;i<=line;i++){
	_this.find("li:first").appendTo(_this);
	}
	_this.css({marginTop:0});
	});
	}
	//鼠标事件绑定
	_this.hover(function(){
	clearInterval(timerID);
	},function(){
		timerID=setInterval("scrollUp()",timer);
	}).mouseout();
	}      
	})
})(jQuery);

function closeAdv1(){
	$("#left_ad").hide();
}
function closeAdv2(){
	$("#right_ad").hide();
}