var domain='http://localhost:8081/';
var params={};
var api={};
api.p=function (name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;

}

api.loadpage=function (url,tpl,ctl,callback){
	$.ajax({
	    type:"get",    //请求方式
	    url:url,
	    dataType:"jsonp",    //跨域json请求一定是jsonp
	    jsonp: "callback",    //跨域请求的参数名，默认是callback
	    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
	    data:params,    //请求参数
	    beforeSend: function() {
	        //请求前的处理
	    },
	    success: function(data) {
	    	console.log(data);
	    	var myTemplate = Handlebars.compile($("#"+tpl).html());
	        $('#'+ctl).html(myTemplate(data));
	      	$('.M-box').pagination({
                totalData:data.totalCount,
                showData:data.pageSize,
                coping:true,
                current:data.pageNo,
                callback:function(api){
                	params.pageNo= api.getCurrent();
                	callback();
                }
            });
	    },
	    complete: function() {
	        //请求完成的处理
	    },
	    error: function() {
	    }
	});
}
	
api.load=function (ctx,url,tpl,ctl,callback){
	jQuery.ajax({
		url:ctx+'/user/manage/manager!dohttp.action',
	    dataType:'json', 
	    type:'post', 
	    data:{url:domain+url,param:JSON.stringify(params)},
	    success:function(data){  
	         var myTemplate = Handlebars.compile($("#"+tpl).html());
	         $('#'+ctl).html(myTemplate(data));
	         if(typeof(callback)==='function')
	        	 callback(data);
	    }
	},"json");	
	}

api.exec=function (ctx,url,callback){
	jQuery.ajax({
		url:ctx+'/user/manage/manager!dohttp.action',
	    dataType:'json', 
	    type:'post', 
	    data:{url:domain+url,param:JSON.stringify(params)},
	    success:function(data){  
	         if(data.success==1)
	        	 callback(data);
	         else{
	        	 b_alert(data.message);
	         }
	    }
	},"json");	
	}