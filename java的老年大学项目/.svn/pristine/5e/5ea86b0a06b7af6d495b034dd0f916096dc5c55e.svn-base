/**
 * 生成分页页码选择器
 * @param curPageNo
 * @param maxPageNo
 * @param minIndex
 * @param maxIndex
 * @param count
 * @returns
 */
function generyPageNumberHtml(curPageNo, maxPageNo, minIndex, maxIndex, count) {
	var sb = [];
	sb[sb.length] = "<li ";
	if (minIndex > 1) {
		sb[sb.length] = " onclick='showMorePrev(this)'";
	}else{
		sb[sb.length] = " class='disabled'";
	}
	sb[sb.length] = " ><a onclick='return false;'>&lt;&lt;</a></li>";
	for ( var i = minIndex; i <= maxIndex; i++) {
		var clazz = "";
		if (i == curPageNo) {
			clazz = "active";
		}
		sb[sb.length] = "<li ";
		if (clazz != "") {
			sb[sb.length] = " class='" + clazz + "'";
		}
		sb[sb.length] = "><a onclick='gotoPageList(listForm," + i + ");return false;'>" + i + "</a></li>";
	}
	sb[sb.length] = "<li ";
	if (maxIndex < maxPageNo) {
		sb[sb.length] = " onclick='showMoreNext(this)'";
	}else{
		sb[sb.length] = " class='disabled'";
		
	} 
	sb[sb.length] = " ><a onclick='return false;'>&gt;&gt;</a></li>";
	if(count && false){
		sb[sb.length] = "<li><a data-pageAct='print'>打印</li>";
		sb[sb.length] = "<li><a data-pageAct='down_text'>下载</a></li>";		
		//sb[sb.length] = "<li><a data-pageAct='down_csv'>下载CSV</a></li>";		
	}
	return sb.join("");
}

/**
 * 列表页面-向前遍历页码
 * @param obj
 */
function showMorePrev(obj){
	var ulObj=$(obj).parent();
	var totalPage=ulObj.attr("data-totalPageNo")*1;
	var totalCount=ulObj.attr("data-totalCount")*1;
	var curMin=ulObj.attr("data-minPageNo")*1;
	var curMax=ulObj.attr("data-maxPageNo")*1;
	var curNo=ulObj.attr("data-curPageNo")*1;
	var min = Math.max(curMin - 5, 1);
	var max = Math.min(min + 4,totalPage);
	ulObj.attr("data-minPageNo",min);
	ulObj.attr("data-maxPageNo",max);
	var html=generyPageNumberHtml(curNo,totalPage,min,max,totalCount);
	$(ulObj).html(html);
}

/**
 * 列表页面-向后遍历页码
 * @param obj
 */
function showMoreNext(obj){
	var ulObj=$(obj).parent();
	var totalPage=ulObj.attr("data-totalPageNo")*1;
	var totalCount=ulObj.attr("data-totalCount")*1;
	var curMin=ulObj.attr("data-minPageNo")*1;
	var curMax=ulObj.attr("data-maxPageNo")*1;
	var curNo=ulObj.attr("data-curPageNo")*1;
	var max = Math.min(curMax+5, totalPage);
	var min = Math.max(max-4,1);
	ulObj.attr("data-minPageNo",min);
	ulObj.attr("data-maxPageNo",max);
	var html=generyPageNumberHtml(curNo,totalPage,min,max,totalCount);
	$(ulObj).html(html);
}

/**
 * 列表页面-显示第N页
 * @param obj
 */
function gotoPageList(form, pageNo) {
	form.pageNo.value = pageNo;
	form.submit();
}

/**
 * 延时提交
 * @param form
 * @param url
 * @returns {Boolean}
 */
function lasySubmit(form,url){
	//loading('正在处理，请稍等...');
	setTimeout(function(){
		if(url){
			/*var time = new Date().getTime();
			if (url.indexOf("?") > 0) {
				url += "&v=" + time;
			} else {
				url += "?v=" + time;
			}*/
			form.action=url;
		}
		form.submit();
	},10);
	return false;
}

/**
 * 确认再提交
 * @param mess
 * @param form
 * @param url
 * @returns {Boolean}
 */
function lasyConfirm(mess,form,url){
	top.$.jBox.confirm(mess,'系统提示',function(v,h,f){
		if(v=='ok'){
			loading('正在提交，请稍等...');
			lasySubmit(form,url);
		}
	},{buttonsFocus:1});
	top.$('.jbox-body .jbox-icon').css('top','55px');
	return false;
}

/**
 * lc3: 确认是否有关联数据，再确认提交
 * @param form 提交Form表单
 * @param thiz 当前链接按钮
 * @param mess 删除确认消息，可为空
 * @returns {boolean}
 */
var deleteActionRegExp = new RegExp('(/?)delete(\\W?)');
function deleteConfirm(form, thiz, mess){
    var formUrl = $(thiz).attr('href');
    var checkUrl = $(thiz).attr('checkUrl');
    if(!checkUrl && -1 != deleteActionRegExp.test(formUrl)) {
        checkUrl = formUrl.replace(deleteActionRegExp, '$1checkRelation$2');
    }
    if(!mess) {
        mess = "要删除该信息吗？";
    }
    top.$.jBox.confirm(mess,'系统提示',function(v,h,f){
        if(v=='ok'){
            var done = function(data) {
                if(!data.canDelete) {
                    top.$.jBox.info('原因为：' + data.cannotDelMsgList.join('<br/>&nbsp;&nbsp;&nbsp;&nbsp;'), '不能直接删除');
                } else if(data.hasRelation) {
                    lasyConfirm("存在关联信息，是否一并删除？<br/>关联信息:" + data.canDelMsgList.join('<br/>&nbsp;&nbsp;&nbsp;&nbsp;'), form, formUrl);
                } else {
                    lasySubmit(form, formUrl);
                }
            }
            if(checkUrl) {
                $.post(checkUrl, done);
            } else {
                done();
            }
        }
    },{buttonsFocus:1});
    return false;
}

/**
 * 先执行JQuery.Validator验证,然后再提交表单
 * @param jqForm
 */
function initJQueryFormValidator(jqForm, option) {
    option = $.extend({}, {
        submitHandler: function(form){
            loading('正在提交，请稍等...');
            form.submit();
        },
        errorContainer: "#messageBox",
        errorPlacement: function(error, element) {
            $("#messageBox").text("输入有误，请先更正。");
            if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        }
    }, option);
    jqForm.validate(option);
}
//设置validate的默认值
$.validator.setDefaults({
    submitHandler: function(form) {
        loading('正在提交，请稍等...');
        form.submit();
    },
    errorPlacement: function(error, element) {
        $("#messageBox").text("输入有误，请先更正！").removeClass("alert-success").addClass("alert-error");
        if ( element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append") ){
            error.appendTo(element.parent().parent());
        } else {
            error.insertAfter(element);
        }
    }
});

/**
 * JSON对象转String
 * 
 * @param o
 * @returns {String}
 */
function JsonToStr(obj) {
	if (obj == null) {
		return '""';
	}
	switch (typeof (obj)) {
		default: 
		case 'number':
		case 'string':
			return '"' + obj + '"';
		case 'object': {
			if (obj instanceof Array) {
				var strArr = [];
				var len = obj.length;
				for ( var i = 0; i < len; i++) {
					strArr.push(JsonToStr(obj[i]));
				}
				return '[' + strArr.join(',') + ']';
			} else {
				var arr = [];
				for ( var i in obj) {
					arr.push('"' + i + '":' + JsonToStr(obj[i]));
				}
				return "{" + arr.join(',') + "}";
			}
		}
	}
	return '""';
}
/**
 * 唯一性 检查
 */

jQuery.validator.addMethod("singleCheck",function(value, element){  
	 var returnVal = true;  
	$.ajax({  
        type:"POST",  
        url:ctx + 'system/user.shtml?action=toSingleCheckId',  
        async:false,                                          
        data:'TABLE_ID='+$(element).attr("table-id")+'&ID_NAME='+$(element).attr("name")+'&ID_VALUE='+value,  
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        success: function(data){  
				returnVal= data;
        }  
    });  
    return returnVal;  
    
},"存在相同的数据，请重新输入");  


jQuery.validator.addMethod("singleName",function(value, element){  
	
	 var returnVal = true;  
	 var collId=$(element).attr("coll-id");
	 var collIdValue=$("#"+collId).val();

	$.ajax({  
       type:"POST",  
       url:ctx + 'system/user.shtml?action=toSingleCheckName',  
       async:false,                                          
       data:'TABLE_ID='+$(element).attr("table-id")+'&ID_NAME='+$(element).attr("name")+'&ID_VALUE='+value+'&COLL_ID_VALUE='+collIdValue+'&COLL_ID='+collId,  
       contentType:"application/x-www-form-urlencoded; charset=UTF-8",
       success: function(data){  
				returnVal= data;
       }  
   });  
   return returnVal;  
   
},"存在相同的数据，请重新输入");

// 检查时间是否大于当前日期
jQuery.validator.addMethod("geNowDate",function(value, element){
	var selectDate=0;
	var newDate =0;
    if(value) {
        selectDate = Date.parse(value.replace('-', '/').replace('-', '/'));
        var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var vDay = d.getDate();
		var sysDate=vYear+"/"+(vMon<10 ? "0" + vMon : vMon)+"/"+(vDay<10 ? "0"+ vDay : vDay);
		newDate =Date.parse(sysDate);
    }
    if(selectDate >= newDate) {
        return true;
    } else {
        return false;
    }
},"不能小于当前日期");


// 只能输入字母和数字
jQuery.validator.addMethod("cantChinese",function(value, element){
	var ter = /^[a-zA-Z0-9]+$/;
	if (!ter.test(value)) {
		return false;
	} else {
		return true;
	}
},"只能包括英文字母和数字和下划线和中划线");
// 只能输入字母和数字
jQuery.validator.addMethod("zmszhx",function(value, element){
	var ter = /^[\w-]+$/;
	if (!ter.test(value)) {
		return false;
	} else {
		return true;
	}
},"只能包括英文字母,数字,中划线和下划线");

// 校验邮箱
jQuery.validator.addMethod("isEmail",function(value, element){
	var ter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!ter.test(value)) {
		return false;
	} else {
		return true;
	}
},"邮箱格式不正常");

//检查时间是否大于当前日期
jQuery.validator.addMethod("geNowTime",function(value, element){
	var selectDate=0;
	var newDate =0;
    if(value) {
        selectDate = Date.parse(value.replace('-', '/').replace('-', '/'));
        var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var vDay = d.getDate();
		var vHours=d.getHours();
		var vTime =d.getMinutes();
		var vSeconds=d.getSeconds();
		var sysDate=vYear+"/"+(vMon<10 ? "0" + vMon : vMon)+"/"+(vDay<10 ? "0"+ vDay : vDay)+" "+vHours+":"+vTime+":"+vSeconds;
		newDate =Date.parse(sysDate);
    }
    if(selectDate >= newDate) {
        return true;
    } else {
        return false;
    }
},"不能小于当前时间");

//复选框事件   
//全选、取消全选的事件   
	function selectCheckBoxAll2(){  
	    if ($("#selectAll").attr("checked")) {  
	        $(":checkbox").attr("checked", true);  
	    } else {  
	        $(":checkbox").attr("checked", false);  
	    }  
	}  
	//子复选框的事件   
	function setSelectAll2(){  
	    if (!$("#ID_ARR").checked) {  
	        $("#selectAll").attr("checked", false);  
	    }  
	    var chsub = $("input[type='checkbox'][name='ID_ARR']").length; //获取subcheck的个数   
	    var checkedsub = $("input[type='checkbox'][name='ID_ARR']:checked").length; //获取选中的subcheck的个数   
	    if (checkedsub == chsub) {  
	      $("#selectAll").attr("checked", true);  
	   } }  

/**
 * 批量删除确认提示
 * @param form
 * @param message
 */
function batchDeleteConfirm(form,message)
{
	var checkedNum = $("input[type='checkbox'][name='ID_ARR']:checked").length; //获取选中的subcheck的个数  
	
	if(checkedNum>0)
	{
		  top.$.jBox.confirm(message,'系统提示',function(v,h,f){
		        if(v=='ok'){
		        	form.submit();
		        }
		    },{buttonsFocus:1});
	}
	else
	{
		top.$.jBox.info("请选择要删除的内容！","系统提示");
	}
}

//字母和数字的验证  
jQuery.validator.addMethod("checkChrNum", function(value, element) {  
    var chrnum = /^([a-zA-Z0-9]+)$/;  
    return this.optional(element) || (chrnum.test(value));  
}, "只能输入数字和字母");  

//只允许汉字、英文字母、数字及下划线
jQuery.validator.addMethod("checkTextChar", function(value, element) {  
    var chrnum = /^[\u0391-\uFFE5\w]+$/;  
    return this.optional(element) || (chrnum.test(value));  
}, "只允许汉字、英文字母、数字及下划线");  

/**
 * 批量删除确认提示
 * @param form
 * @param message
 */
function batchDeleteConfirm(form,message)
{
	var checkedNum = $("input[type='checkbox'][name='chkId']:checked").length; //获取选中的subcheck的个数  
	
	if(checkedNum>0)
	{
		  top.$.jBox.confirm(message,'系统提示',function(v,h,f){
		        if(v=='ok'){
		        	form.submit();
		        }
		    },{buttonsFocus:1});
	}
	else
	{
		top.$.jBox.info("请选择要删除的内容！","系统提示");
	}
}


String.prototype.format = function(){
	var result = this;
	if (arguments.length < 1) {
		return result;
	}

	// 如果只有一个参数，并且是对象
	var obj = arguments[0];
	if(arguments.length == 1 && typeof(obj) == "object")
	{
		for ( var key in obj) {
			var value = obj[key];
			if (undefined != value) {
				result = result.replaceAll("\\{" + key + "\\}", value);
			}
		}
	}else{
		var reg = /{(\d+)}/gm;
		var args = arguments;
		return this.replace(/\{(\d+)\}/g,function(s,i){
			return args[i];
		});
		/*result =  result.replace(reg,function(match,i){
			return arguments[i];
		});*/
	}
	return result;
}