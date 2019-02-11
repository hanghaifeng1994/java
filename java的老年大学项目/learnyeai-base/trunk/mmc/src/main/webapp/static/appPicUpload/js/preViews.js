var imageArray = ["jpg", "png", "jpeg", "bmp"];
var documentArray = ["pdf"];
var zipArray = ["zip"];//chj 增加zip包资源 上传
var videoArray = ["mp4", "flv", "rmvb", "avi", "mkv"];
//input验证
$.validator.addMethod("checkFile", function (value, element) {
    var postfix = value.substring(value.lastIndexOf(".")+1).toLowerCase();
    if(imageArray.indexOf(postfix)!=-1){
        return true;
    }else if(documentArray.indexOf(postfix)!=-1){
        return true;
    }else if(videoArray.indexOf(postfix)!=-1){
        return true;
    }else if(zipArray.indexOf(postfix)!=-1){
        return true;
    }else{
        return false;
    }
}, "选择文件格式错误");
//验证 文件大小  
$.validator.addMethod("checkSize", function (file, element) {
    var returnVal = true;
    var size = 0;
    var file = document.getElementById("up");
    try {
        //IE浏览器
        if ($.browser.msie) {
            try {
                var obj_img = new Image();
                obj_img.src = file.value;
                size = obj_img.fileSize;
            } catch (e) {
                return true;
            }
        } else {  //其它浏览器
            size = file.files[0].size;
        }
        size = size / 1024 / 1024;
        //大于50M验证不通过
        if (size > 50) {
            return false;
        }
    } catch (e) {
        return true;
    }
    return returnVal;
}, "上传文件不能大于50M");

/**
 * 下载文件到IE本地缓存目录下
 * 
 */
function httpDownFileLocal(filepathAndName){
	var filepath = filepathAndName;
	var WshShell = new ActiveXObject("WScript.Shell"); 
	//缓存目录
	var keyValue = WshShell.RegRead('HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Cache\\Paths\\Directory');
	var PostRecvImpl = new ActiveXObject("ASPCom.PostRecv");
	var extName = filepath.substring(filepath.lastIndexOf('.'));
	var fileName = new Date().getTime() + extName;
	fileName = keyValue+"\\"+fileName;
	fileName = fileName.replace(/\\/gm,'\\\\');
	PostRecvImpl.HTTPDownloadFile(fileName,filepath);
	return fileName;
}
/** 
* 从 file 域获取 本地图片 url 
*/ 
function getFileUrl(sourceId,type) { 
	var url="";
	if(type=="img")
	{
		if(tmpData) {
		    return tmpData[sourceId+"FileSrc"];
		}
	}
	else
	{
		if (navigator.userAgent.indexOf("MSIE")>0) { // IE 
			url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
		} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox 
			url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
		} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
			url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
		} 
	}
	return url; 
} 

function change( id){
	var val = $("#"+id).val();
	if(val == ''){
		val = $("#"+id+"_Face").val();
		var preViewButton = '<a id="'+id+'fancyPreView" rel="example_group" href="' + resourcePath + val +
				'"><input id="'+id+'buttonClick" type="button" class="btn" value="预览文件" /></a>';
		$("#"+id).parents('.input-append').append(preViewButton);
		return true;
	}
    var postfix = val.substring(val.lastIndexOf(".")+1).toLowerCase();

     //清除添加的标签
    $("#"+id+"fancyPreView").remove();
    $("#"+id+"buttonClick").remove();
    if(imageArray.indexOf(postfix)!=-1){
    	var src= getFileUrl(id,"img");
    	if(typeof src == "object") {//IE10 support
        	var preViewButton = '<a id="'+id+'fancyPreView" rel="example_group" href=""><input id="'+id+'buttonClick" type="button" class="btn" value="预览文件" /></a>';
        	$("#"+id).parents('.input-append').append(preViewButton);
            var reader = new FileReader();
            reader.onload = function(evt){$("#"+id+"fancyPreView").attr("href", evt.target.result);};
            reader.readAsDataURL(src);
        } else {//IE7/8/9 support
        	var preViewButton = '<a id="'+id+'fancyPreView" rel="example_group" href="#data"  kesrc="#data"><input id="'+id+'buttonClick" type="button" class="btn" value="预览文件" /></a>'
        		+'<div style="display: none;"><div id="data"><img id="ImgPr"></div></div>';
        	$("#"+id).parents('.input-append').append(preViewButton);
        	$("#ImgPr").css({filter: 'progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=bEnabled,sizingMethod=scale)',
            	width: '100%',  height: '300px' });
            document.getElementById('ImgPr').filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
        }
    	
    	$("#fileType").find("option[value='']").attr("selected","true");
        $("#s2id_fileType span").text("图片");
        $("#fileType").attr("value","0");
         return true;
    }else if(documentArray.indexOf(postfix)!=-1){
        $("#fileType").find("option[value='']").attr("selected","true");
        $("#s2id_fileType span").text("PDF");
        $("#fileType").attr("value","1");
         return true;
    }else if(videoArray.indexOf(postfix)!=-1){
        $("#fileType").find("option[value='']").attr("selected","true");
        $("#s2id_fileType span").text("视频");
        $("#fileType").attr("value","2");
         return true;
    }else{
        return false;
    }
}

function preView() {
    var postfix = $("#up").val().substring($("#up").val().lastIndexOf(".") + 1).toLowerCase();
    if (imageArray.indexOf(postfix)!=-1) {
    	var src= getFileUrl("up","img");
        if(typeof src == "object") {
            var reader = new FileReader();
            reader.onload = function(evt){$("#fancyPreView").attr("href", evt.target.result);};
            reader.readAsDataURL(src);
        } 
//            else {
//                var image = '<img id="ImgPr">';
//                $("#ups").parent().css({position: 'relative',
//                            width: '100%', height: '100%'}); 
//                $("#ups").after(image);
//                $("#ImgPr").css({filter: 'progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=bEnabled,sizingMethod=scale)',
//                	width: '90%',  height: '400px' });
//                document.getElementById('ImgPr').filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
//            }
    }
}

//批量删除确认提示
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
		top.$.jBox.tip("请选择要删除的内容！", "warn");
//		top.$.jBox.info("请选择要删除的内容！","系统提示");
	}
}
//资源全选
var selectNode=function(id){
	//判断是否全选框，若是，再判断点击前的选中状态，若选中状态下置为未选中，未选中状态下置为选中
	if(id=="selectAll"){
		if($("#"+id).is(':checked')){
			$("input[type='checkbox']").attr('checked',true);
		}else{
			$("input[type='checkbox']").attr('checked',false);
		}
	}else{
		//判断该节点点击前的选中状态，选中状态下置为未选中，未选中状态下置为选中
		if($("#"+id).is(':checked')){
			$("#"+id).attr("checked",false);
		}else{
			$("#"+id).attr("checked",true);
		}
		//判断列表里的多选框是否全部选中，若全部选中，全选框跟随选中，否，则不选中
		var chkedNum = $("input[type='checkbox'][name='chkId']:checked").length;
		var totalNum = $("input[type='checkbox'][name='chkId']").length;
		if(chkedNum==totalNum){
			$("#selectAll").attr("checked",true);
		}else{
			$("#selectAll").attr("checked",false);
		}
	}
}