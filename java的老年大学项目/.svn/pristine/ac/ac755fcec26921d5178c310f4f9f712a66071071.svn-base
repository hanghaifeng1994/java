// 点击展播栏目图片右下角数字时,显示DIV显示,切换图片滚动,切换文字显示
function show(num, objVal) {
	if (objVal == "实验示范") {
		document.getElementById("sjsf").style.display = "";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="../news/cityarea.action?intType=1";
		$("#sjsf").YlMarquee( {
			visible : 0,
			width : 666,
			step : 2
		}); 
	}
	if (objVal == "社区学院") {
		document.getElementById("sqxy").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="../news/cityarea.action?intType=2";
		$("#sqxy").YlMarquee( {
			visible : 0,
			width : 666,
			step : 2
		});
	}
	if (objVal == "社教中心") {
		document.getElementById("sjzx").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="../news/cityarea.action?intType=3";
		$("#sjzx").YlMarquee( {
			visible : 0,
			width : 666,
			step : 2
		});
	}
	if (objVal == "示范街镇") {
		document.getElementById("sfjz").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("nkjjd").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="../news/cityarea.action?intType=4";
		$("#sfjz").YlMarquee( {
			visible : 0,
			width : 666,
			step : 2
		});
	}

	if (objVal == "农科教基地") {
		document.getElementById("nkjjd").style.display = "";
		document.getElementById("sjsf").style.display = "none";
		document.getElementById("sqxy").style.display = "none";
		document.getElementById("sjzx").style.display = "none";
		document.getElementById("sfjz").style.display = "none";
		document.getElementById('colmnsShowUrlId').value="../news/cityarea.action?intType=5";
		$("#nkjjd").YlMarquee( {
			visible : 0,
			width : 666,
			step : 2
		});
	}
	if(num==5){
		document.getElementById('scorll_5').className = "picture_bottom_img2 ll";
		document.getElementById('scorll_1').className = "picture_bottom_img1 ll mr4";
		document.getElementById('scorll_2').className = "picture_bottom_img1 ll mr4";
		document.getElementById('scorll_3').className = "picture_bottom_img1 ll mr4";
		document.getElementById('scorll_4').className = "picture_bottom_img1 ll mr4";
	}else{
		for ( var i = 1; i <= 5; i++) {
			var val = document.getElementById('scorll_' + i);
			if (i == num) {
				val.className = "picture_bottom_img2 ll mr4";
			} else {
				val.className = "picture_bottom_img1 ll mr4";
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
	window.open(valUrl, "newwindow");
}
