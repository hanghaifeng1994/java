/**
 * @description 公共交易请求 TransAjax
 * @return
 */
var TransAjax = function(headers) {
	this.headers = headers;
	return this;
};
TransAjax.prototype = {
	timeout : 120000,// 超时时长
	timeoutflg : false,// 是否超时信息的标记
	_args : null, // 自定义参数
	_rpdata : null,
	_showError : false,
	_resetSessTimer : true,// 是否更新会话定时器
	getRpdata : function() {
		return this._rpdata;
	},
	setArgs : function(obj) {
		this._args = obj;
	},
	resetSessTimer : function(flag) {
		this._resetSessTimer = flag;
	},
	getArgs : function() {
		return this._args;
	},
	setShowError : function(s) {
		// 设置是否显示错误信息
		this._showError = s;
	},
	start : function() {
		// 开启超时提醒
		this.timeoutflg = true;
	},
	clear : function() {
		// 取消超时提醒时，需调用此方法。
		this.timeoutflg = false;
		if (this._timeoutHandle) {
			clearTimeout(this._timeoutHandle);
		}
	},
	getXmlHttpObj : function() {
		var xmlHttpObj;
		try {
			xmlHttpObj = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttpObj;
	},
	sendPostData : function(url, param, callback) {
		param = JSON.parse(param);
		
		var date = new Date().format("yyyy-MM-dd HH:mm:ss");
		date = date.replace(/-/g,"").replace(/:/g,"").replace(" ","");
		if(!param.header)
			param.header = {};
		param.header["_REPEAT"] = {};
		param.header._REPEAT['REQ_TIME'] = date;
		param = JSON.stringify(param);
		var _ajax = this;
		_ajax.start();
		var xhr = this.getXmlHttpObj();
		xhr.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					if (_ajax.abort) {
						alert("timeout is abort!");
						return;
					}
					var rpdata = eval("(" + this.responseText + ")");
					_ajax._rpdata = rpdata;
					var run = true;
					try {
						if (rpdata && rpdata.success) {
							if (rpdata.success == "005") {
								alert("session超时");// session超时;
								run = false;
							} else if (rpdata.success == "006") {
								alert("" + rpdata.message);
								run = false;
							} else if (rpdata.success == "security.req_replay") {
								alert("" + rpdata.message);
								run = false;
							} else if (rpdata.success != "1") {
								if (_ajax._showError) {
									alert("" + rpdata.message);
								}
							}
						}
						if (run)
							callback(rpdata, _ajax._args);
					} catch (e) {
						alert("TransAjax", e);
					}
					_ajax.clear();
				}
			}
		};
		xhr.open("POST", url, true);
		xhr.setRequestHeader('Content-Type', 'application/json');
		var heads = this.headers;
		if(heads && typeof heads == 'object'){
			for(var p in heads){
				xhr.setRequestHeader(p, heads[p]);
			}
		}

		xhr.send(param);
		// Timeout checker
		if (_ajax.timeout > 0) {
			_ajax._timeoutHandle = setTimeout(function() {
				// Check to see if the request is still happening
				if (xhr && _ajax.timeoutflg) {
					_ajax.abort = true;
					xhr.abort();
					// alert("交易超时！");
				}
			}, _ajax.timeout);
		}
	}
};

/**
 * JSON对象转String
 * 
 * @param o
 * @returns {String}
 */
function JsonToStr(obj, prev, lvl) {
	if (obj == null) {
		return '""';
	}
	lvl = lvl || 0;
	var lvl2 = lvl + 1;
	var prev2 = prev ? (prev + " ") : null;
	prev = prev || "";
	switch (typeof (obj)) {
	default:
	case 'number':
	case 'string':
		return '"' + obj + '"';
	case 'object': {
		if (obj instanceof Array) {
			var strArr = [];
			var len = obj.length;
			for (var i = 0; i < len; i++) {
				strArr.push(JsonToStr(obj[i], prev2, lvl2));
			}
			return '[' + strArr.join(',') + ']';
		} else {
			var arr = [];
			for ( var i in obj) {
				var s = JsonToStr(obj[i], prev2, lvl2);
				arr.push(prev + '"' + i + '":' + s);
			}
			return (lvl > 0 ? prev : "") + "{" + arr.join(',') + "}";
		}
	}
	}
	return '""';
};

function getFormJson(panel, sendObj) {
	sendObj = sendObj ? sendObj : {};
	// 表单异步提交
	panel.find("[data-type]").each(function() {
		var jqObj = $(this);
		var name = '', value = '';
		name = jqObj.attr("name");
		value = jqObj.val();
		if (name && value) {
			/*if ($.browser.msie) {
				var placeholder = jqObj.attr("placeholder");
				if (placeholder == value) {
					value = "";
				}
			}
			// 去掉破坏JSON格式的内容；
			var jsonType = jqObj.attr("data-json");
			if (jsonType == "db") {
				value = value.replace(/\'|\"/ig, "");
				value = value.replace(/</ig, "&lt;");
				value = value.replace(/>/ig, "&gt;");
			} else {
				if(value.indexOf('[') == 0 || value.indexOf('{') == 0 ){
					try{
						value = eval(value);
					}catch(e){
					}
				}
				else{
					value = value.replace(/\'|\"|,|=|:|\\{|\\}|\\[|\\]/ig, "");
					value = value.replace(/</ig, "&lt;");
					value = value.replace(/>/ig, "&gt;");
				}

			}*/
			// alert("formJson: \n "+value);
			sendObj[name] = value;
		}
	});
	return sendObj;
}

// 处理url参数a=1&b=3，返回参数对象
function getUrlParams(url){
	var items = url.split('&');
	if(items.length === 0){
		return null;
	}
	//
	var key, value, index, item;
	var values = {};
	for (index = 0; index < items.length; index++) {
		item = items[index].split('=');
		key = item[0];
		value = item[item.length - 1];
		if (key) {
			values[key] = value;
		}
	}
	return values;
}