/** ***********************首页********************************** */

$(document).ready(function() {

	// 窗体加载时显示第一个,即"实践示范"的图片
		$("#sjsf").YlMarquee( {
			visible : 0,
			width : 669,
			step : 2
		});

	});

// 点击展播栏目图片右下角数字时,显示DIV显示,切换图片滚动,切换文字显示
function show(val, none1, none2, none3, none4, num, value) {
	document.getElementById(val).style.display = "";
	document.getElementById(none1).style.display = "none";
	document.getElementById(none2).style.display = "none";
	document.getElementById(none3).style.display = "none";
	document.getElementById(none4).style.display = "none";
	if (val == "sqxy") {
		$("#sqxy").YlMarquee( {
			visible : 0,
			width : 669,
			step : 2
		});
	}
	if (val == "sjzx") {
		$("#sjzx").YlMarquee( {
			visible : 0,
			width : 669,
			step : 2
		});
	}

	if (val == "sfjz") {
		$("#sfjz").YlMarquee( {
			visible : 0,
			width : 669,
			step : 2
		});
	}

	if (val == "nkjjd") {
		$("#nkjjd").YlMarquee( {
			visible : 0,
			width : 669,
			step : 2
		});
	}
	for ( var i = 1; i <= 5; i++) {
		var val = document.getElementById('scorll_' + i);

		if (i == num) {
			val.className = "picture_bottom_img2 ll mr4";
		} else {
			val.className = "picture_bottom_img1 ll mr4";
		}
		document.getElementById("ta_c_id").innerHTML = value;
	}

}

// 点击展播栏目中"more++"时,设置跳转路径
function onColums() {
	var val = $('#ta_c_id').html();
	if (val == "实践示范") {
		location.href = "./cityarea.action?type=实践示范";
	} else if (val == "社区学院") {
		location.href = "./cityarea.action?type=社区学院";
	} else if (val == "社教中心") {
		location.href = "./cityarea.action?type=社教中心";
	} else if (val == "示范街镇") {
		location.href = "./cityarea.action?type=示范街镇";
	} else if (val == "农科教基地") {
		location.href = "./cityarea.action?type=农科教基地";
	}
}
