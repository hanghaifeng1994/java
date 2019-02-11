function crertdiv(_parent, _element, _id, _css) {// 创建层
	var newObj = document.createElement(_element);
	if (_id && _id != "")
		newObj.id = _id;
	if (_css && _css != "") {
		newObj.setAttribute("style", _css);
		newObj.style.cssText = _css;
	}
	if (_parent && _parent != "") {
		var theObj = getobj(_parent);
		var parent = theObj.parentNode;
		if (parent.lastChild == theObj) {
			theObj.appendChild(newObj);
		} else {
			theObj.insertBefore(newObj, theObj.nextSibling);
		}
	} else
		document.body.appendChild(newObj);
}

function getobj(o) {// 获取对象
	return document.getElementById(o)
}

var swtemp = 0, objtemp;

function showdiv(inputid, inputlist) {// 显示层
	if (swtemp == 1) {
		getobj(objtemp + "mydiv").style.display = "none";
	}
	var text_list = inputlist.split(",")
	if (!getobj(inputid + "mydiv")) {// 若尚未创建就建之
		var divcss = "font-size:12px;color:#00f;position:absolute;left:"
				+ (getobj(inputid).offsetLeft + 0) + "px;top:"
				+ (getobj(inputid).offsetTop + 25) + "px;border:1px solid red"
		crertdiv("", "div", inputid + "mydiv", divcss);// 创建层"mydiv"
		// alert(document.getElementById("mydiv").outerHTML)
		crertdiv(inputid + "mydiv", "ul", inputid + "myul");// 创建ul
		for ( var i = 0, j = text_list.length; i < j; i++) {// 创建"text_list"li
			crertdiv(inputid + "myul", "li", inputid + "li" + i,
					"background:#fff");
			getobj(inputid + "li" + i).innerHTML = text_list;
		}
		crertdiv(inputid + "myul", "li", inputid + "li" + j,
				"color:#f00;background:#fff");// 创建"clear"li
		getobj(inputid + "li" + j).innerHTML = "clear";
		getobj(inputid + "mydiv").innerHTML += "<style type='text/css'>#"
				+ inputid
				+ "mydiv ul {padding:0px;margin:0;}#"
				+ inputid
				+ "mydiv ul li{list-style-type:none;padding:5px;margin:0;float:left;CURSOR: pointer;}</style>"
		for ( var i = 0; i <= j; i++) {
			getobj(inputid + "li" + i).onmouseover = function() {
				this.style.background = "#eee";
				clearTimeout(timer)
			}
			getobj(inputid + "li" + i).onmouseout = function() {
				this.style.background = "#fff"
			}
		}
	}
	
	var newdiv = getobj(inputid + "mydiv")
	newdiv.onclick = function() {
		hiddiv(event, inputid);
	}
	newdiv.onmouseout = function() {
		Mout(this)
	}
	newdiv.onmouseover = function() {
		clearTimeout(timer)
	}
	getobj(inputid).onmouseout = function() {
		Mout(newdiv)
	}
	newdiv.style.display = "block";
	swtemp = 1;
	objtemp = inputid;
}

var timer

function Mout(o) {
	timer = setTimeout(function() {
		o.style.display = "none";
	}, 300)
	swtemp = 0;
}

function hiddiv(e, inputid) {
	e = e || window.event;
	ev = e.target || e.srcElement;
	v = ev.innerText || ev.textContent;
	if (v != "clear")
		getobj(inputid).value = v;
	else
		getobj(inputid).value = ""
	getobj(inputid + "mydiv").style.display = "none";
}