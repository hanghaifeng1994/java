<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.Constants"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta content="certtemplate" name="activemenu" />
	<title>创建证书项目</title>
	<%@ include file="/common/admin_meta.jsp"%>
	<script  type="text/javascript"  src="${ctx}/js/LodopFuncs.js">${ctx}</script>
	<link href="${ctx}/css/front/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${ctx}/js/layer.js" type="text/javascript"></script>
	<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="../js/install_lodop32.exe"></embed>
	</object>
	<script type="text/javascript">
	var oldObj = {};
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		if('${id}'!=''){
			init();
		}
		
	});
	
	function init(){
		$.ajax({
			type:"post",    //请求方式
			url:"${certapiurl}/cert/certtemplate/manage/info",
			dataType:"jsonp",    //跨域json请求一定是jsonp
			jsonp: "callback",    //跨域请求的参数名，默认是callback
			jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			data:{
				"id":$("#id").val()
			},    //请求参数
			success: function(data) {
			    //请求成功处理，和本地回调完全一样
			    oldObj = data;
			    $("#name").val(data.name);
			    $("#imageName").val(data.imageName);
			    if(data.imageName!=''){
			     	$("#delImageName").show();
			    	$("#showImageName").html(data.imageName);
			    }
			    $("#fixedImage").val(data.fixedImage);
			    $("#subject").val(data.subject);
			    $("#strSubject").val(data.subject);
			    $("#status").val(data.status);
			    if(data.status){
				    $("#status1").attr("checked",'checked');
				    $("#status2").removeAttr("checked");
			    }else{
			    	$("#status2").attr("checked",'checked');
				    $("#status1").removeAttr("checked");
			    }
			    $("#textOne").val(data.textOne);
			    $("#textTwo").val(data.textTwo);
			    $("#textThree").val(data.textThree);
			    $("#textFour").val(data.textFour);
			    $("#textFive").val(data.textFive);
			    $("#textSix").val(data.textSix);
			    $("#textSeven").val(data.textSeven);
			    $("#textEight").val(data.textEight);
			    $("#textNine").val(data.textNine);
			    $("#textTen").val(data.textTen);
			    $("#textEleven").val(data.textEleven);
			    $("#textTwelve").val(data.textTwelve);
			    $("#textThirteen").val(data.textThirteen);
			    $("#textFourteen").val(data.textFourteen);
			    $("#textFifteen").val(data.textFifteen);
			    $("#imageUrlOne").val(data.imageUrlOne);
			    $("#old_imageUrlOne").val(data.imageUrlOne);
			    if(data.imageUrlOne!=''){
			     	$("#delImageName1").show();
			    	$("#showImageName1").html(data.imageUrlOne);
			    }
			    $("#imageUrlTwo").val(data.imageUrlTwo);
			     $("#old_imageUrlTwo").val(data.imageUrlTwo);
			    if(data.imageUrlTwo!=''){
			     	$("#delImageName2").show();
			    	$("#showImageName2").html(data.imageUrlTwo);
			    }
			    $("#imageUrlThree").val(data.imageUrlThree);
			     $("#old_imageUrlThree").val(data.imageUrlThree);
			    if(data.imageUrlThree!=''){
			     	$("#delImageName3").show();
			    	$("#showImageName3").html(data.imageUrlThree);
			    }
			    $("#imageUrlFour").val(data.imageUrlFour);
			     $("#old_imageUrlFour").val(data.imageUrlFour);
			    if(data.imageUrlFour!=''){
			     	$("#delImageName4").show();
			    	$("#showImageName4").html(data.imageUrlFour);
			    }
			    $("#imageUrlFive").val(data.imageUrlFive);
			     $("#old_imageUrlFive").val(data.imageUrlFive);
			    if(data.imageUrlFive!=''){
			     	$("#delImageName5").show();
			    	$("#showImageName5").html(data.imageUrlFive);
			    }
			    $("#staticOne").val(data.staticOne);
			    $("#staticTwo").val(data.staticTwo);
			    $("#staticThree").val(data.staticThree);
			},
			error: function() {
			    //请求出错处理
			}
		});
	}
	/*
	* 保存证书模板
	*/
	function onSave(){
		//验证模板名称是否为空
		var name=$.trim($("#name").val());
		if(isNull(name)){
			b_alert("请输入证书模板名称");
			$('#name').focus();
			return; 
		}
		//验证15个文本及5个图片输入是否合法,如果合法才继续下面的操作
		if(onValidTemplate())
		{
	 		//var id=$("#id").val();
			var subject = $.trim($("#subject").val());
			if(isNull(subject))
	 	    {   
	 			b_alert("请进行模板设计");
				$('#templateDegin').focus();
	 	    	return;
	 		}
	 		$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certtemplate/manage/save",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"id":$("#id").val(),
			    	"name":$("#name").val(),
			    	"imageName":$("#imageName").val(),
			    	"fixedImage":$("#fixedImage").val(),
			    	"subject":$("#subject").val(),
			    	"status":$("input[name='status']:checked").val(),
			    	"textOne":$("#textOne").val(),
			    	"textTwo":$("#textTwo").val(),
			    	"textThree":$("#textThree").val(),
			    	"textFour":$("#textFour").val(),
			    	"textFive":$("#textFive").val(),
			    	"textSix":$("#textSix").val(),
			    	"textSeven":$("#textSeven").val(),
			    	"textEight":$("#textEight").val(),
			    	"textNine":$("#textNine").val(),
			    	"textTen":$("#textTen").val(),
			    	"textEleven":$("#textEleven").val(),
			    	"textTwelve":$("#textTwelve").val(),
			    	"textThirteen":$("#textThirteen").val(),
			    	"textFourteen":$("#textFourteen").val(),
			    	"textFifteen":$("#textFifteen").val(),
			    	"imageUrlOne":$("#imageUrlOne").val(),
			    	"imageUrlTwo":$("#imageUrlTwo").val(),
			    	"imageUrlThree":$("#imageUrlThree").val(),
			    	"imageUrlFour":$("#imageUrlFour").val(),
			    	"imageUrlFive":$("#imageUrlFive").val(),
			    	"staticOne":$("#staticOne").val(),
			    	"staticTwo":$("#staticTwo").val(),
			    	"staticThree":$("#staticThree").val()
			    },    //请求参数
			    success: function(data) {
			        //请求成功处理，和本地回调完全一样
			        location.href="${ctx}/cert/manage/certtemplate.action";
			    },
			    error: function() {
			        //请求出错处理
			    }
			});
	 		//$("#form1").submit();
		}
	}

	//验证15个文本及5个图片输入是否合法,规则是15个文本必须至少输入1个,多个之间必须连续;5个上传图片多个之间必须连续
	function onValidTemplate(){
		//验证静态文本
 		var staticOne=$("#staticOne").val();
 		var staticTwo=$("#staticTwo").val();
 		var staticThree=$("#staticThree").val();

 		if(isNull(staticOne) && (!isNull(staticTwo) || !isNull(staticThree))){
 			b_alert("请输入静态文本内容");
 			$('#staticOne').focus();
			return false;
 		}

 		if(isNull(staticTwo) && !isNull(staticThree)){
 			b_alert("请输入静态文本内容");
 			$('#staticTwo').focus();
			return false;
 		}
		
		var emptyValue = true;
 		$("#a_1_box .certText").each(function(index, domEle)
 		{
	 		if(!isNull($(domEle).val()))
	 		{
	 			emptyValue = false;
	 		}
	 	});
	 	if(emptyValue)
	 	{
	 		b_alert("请至少输入一个证书模板文本");
			$('#textOne').focus();
			return false;
	 	} 

 		var textOne=$.trim($("#textOne").val());
 		var textTwo=$.trim($("#textTwo").val());
 		var textThree=$.trim($("#textThree").val());
 		var textFour=$.trim($("#textFour").val());
 		var textFive=$.trim($("#textFive").val());
 		var textSix=$.trim($("#textSix").val());
 		var textSeven=$.trim($("#textSeven").val());
 		var textEight=$.trim($("#textEight").val());
 		var textNine=$.trim($("#textNine").val());
 		var textTen=$.trim($("#textTen").val());
 		var textEleven=$.trim($("#textEleven").val());
 		var textTwelve=$.trim($("#textTwelve").val());
 		var textThirteen=$.trim($("#textThirteen").val());
 		var textFourteen=$.trim($("#textFourteen").val());
 		var textFifteen=$.trim($("#textFifteen").val());

 		if(isNull(textOne) && (!isNull(textTwo) || !isNull(textThree) || !isNull(textFour) || !isNull(textFive)
 				 || !isNull(textSix) || !isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
 				 || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
 			b_alert("请输入模板文本");
 			$('#textOne').focus();
			return false;
 		}

 		if(isNull(textTwo) && (!isNull(textThree) || !isNull(textFour) || !isNull(textFive)
				 || !isNull(textSix) || !isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
				 || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textTwo').focus();
			return false;
		}

 		if(isNull(textThree) && (!isNull(textFour) || !isNull(textFive)
				 || !isNull(textSix) || !isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
				 || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textThree').focus();
			return false;
		}

 		if(isNull(textFour) && (!isNull(textFive) || !isNull(textSix) || !isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
				 || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textFour').focus();
			return false;
		}

 		if(isNull(textFive) && (!isNull(textSix) || !isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
 				|| !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textFive').focus();
			return;
		}

 		if(isNull(textSix) && (!isNull(textSeven) || !isNull(textEight) || !isNull(textNine) || !isNull(textTen)
 				|| !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textSix').focus();
			return false;
		}

 		if(isNull(textSeven) && (!isNull(textEight) || !isNull(textNine) || !isNull(textTen)
 				|| !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textSeven').focus();
			return false;
		}

 		if(isNull(textEight) && (!isNull(textNine) || !isNull(textTen) || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textEight').focus();
			return false;
		}

 		if(isNull(textNine) && (!isNull(textTen) || !isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textNine').focus();
			return;
		}

 		if(isNull(textTen) && (!isNull(textEleven) || !isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textTen').focus();
			return false;
		}

 		if(isNull(textEleven) && (!isNull(textTwelve) || !isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textEleven').focus();
			return false;
		}

 		if(isNull(textTwelve) && (!isNull(textThirteen) || !isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textTwelve').focus();
			return false;
		}

 		if(isNull(textThirteen) && (!isNull(textFourteen) || !isNull(textFifteen))){
			b_alert("请输入模板文本");
			$('#textThirteen').focus();
			return false;
		}

 		if(isNull(textFourteen) && !isNull(textFifteen)){
			b_alert("请输入模板文本");
			$('#textFourteen').focus();
			return false;
		}

		//验证上传的图片
 		var imageUrlOne=$("#imageUrlOne").val();
 		var imageUrlTwo=$("#imageUrlTwo").val();
 		var imageUrlThree=$("#imageUrlThree").val();
 		var imageUrlFour=$("#imageUrlFour").val();
 		var imageUrlFive=$("#imageUrlFive").val();
 		 

 		if(isNull(imageUrlOne) && (!isNull(imageUrlTwo) || !isNull(imageUrlThree) || !isNull(imageUrlFour) || !isNull(imageUrlFive))){
 			b_alert("请上传图片");
 			$('#picfile1').focus();
			return false;
 		}

 		if(isNull(imageUrlTwo) && (!isNull(imageUrlThree) || !isNull(imageUrlFour) || !isNull(imageUrlFive))){
 			b_alert("请上传图片");
 			$('#picfile2').focus();
			return false;
 		}

 		if(isNull(imageUrlThree) && (!isNull(imageUrlFour) || !isNull(imageUrlFive))){
 			b_alert("请上传图片");
 			$('#picfile3').focus();
			return false;
 		}

 		if(isNull(imageUrlFour) && !isNull(imageUrlFive)){
 			b_alert("请上传图片");
 			$('#picfile4').focus();
			return false;
 		}

 		return true;
	}
	
	//判断上传照片格式
	//picfile:file文本框的ID, imageName:隐藏域的ID, fileSpan:file文本框的外围span
	//delImage:删除图片的 a 链接,showImage:显示上传后名称的span
	function onValidate(picfile,imageName,filespan,delImage,showImage)
	{  
		var picFile = $("#"+picfile).val();
		var picfileObj = picFile.substr(picFile.lastIndexOf(".")).toLowerCase();

		if(picfileObj!=".jpg" && picfileObj!=".gif" && picfileObj!=".png"){
			b_alert("上传图片格式不正确，请重新上传.");
			$("#"+filespan).html('&nbsp;<input type="file" name="picfile" id="'+picfile+'" size="30" onchange="onValidate(\''+picfile+'\',\''+imageName+'\',\''+filespan+'\',\''+delImage+'\',\''+showImage+'\');"/>');
			return;
		}else
			ajaxFileUpload(picfile,imageName,filespan,delImage,showImage);
	}
	
	//自定义照片上传
	function ajaxFileUpload(picfile,imageName,filespan,delImage,showImage){
		showLayer('dialog','dialog_content',"<span style='text-align:center'><img align='top' alt='正在上传...' src='${ctx}/css/back/image/loading.gif'/></span>");
				$.ajaxFileUpload
				(
					{
						url:'${ctx}/related/upload!uploadCertTemImage.excsec',//用于文件上传的服务器端请求地址
						secureuri:false,//一般设置为false
						fileElementId:picfile,//文件上传空间的id属性  <input type="file" id="file" name="file" />
						dataType: 'json',//返回值类型 一般设置为json
						success: function (data, status)  //服务器成功响应处理函数
						{ 
							closeLayer();//关闭提示层
							if(data!=null){
								if(data.message!=null){
									b_b_alert(data.message);//错误提示信息，如附件太大，上传失败
									//上传失败后，清空上传文件框
									$("#"+filespan).html('&nbsp;<input type="file" name="picfile" id="'+picfile+'" size="30" onchange="onValidate(\''+picfile+'\',\''+imageName+'\',\''+filespan+'\',\''+delImage+'\',\''+showImage+'\');"/>');
									return;
								}else{
									var fileName = data.avatarname; 
									$("#"+imageName).val(fileName);//给隐藏域赋值
									$("#"+delImage).show();//显示删除图片的 a 链接
									$("#"+showImage).html(fileName);//给上传后的图片名称显示
									$("#"+showImage).show();//显示上传后的图片名称
								}
							}	
							if(typeof(data.error) != 'undefined')
							{
								if(data.error != '')
									b_alert(data.error);
								else
									b_alert(data.message);
							}
						},
						error: function (data, status, e)//服务器响应失败处理函数
						{
							//b_alert(e);
						}
					}
				)
				return false;
	}

	//删除证书模板图片	
	//picfile:file文本框的ID, imageName:隐藏域的ID, fileSpan:file文本框的外围span
	//delImage:删除图片的 a 链接,showImage:显示上传后名称的span
	function onDelImage(picfile,imageName,filespan,delImage,showImage){
		//取得附件名称
		var imageNameVal = $('#'+imageName).val();
		//后台删除附件
		$.getJSON("${ctx}/related/upload!deleteCertTemImage.excsec",{"imageName":imageNameVal},function(data) {
			 if(data!=null)//删除失败，打印提示信息
			 	b_alert(data.value);
			 else{ //删除成功 
				//清空附件文本框
				$("#"+filespan).html('&nbsp;<input type="file" name="picfile" id="'+picfile+'" size="30" onchange="onValidate(\''+picfile+'\',\''+imageName+'\',\''+filespan+'\',\''+delImage+'\',\''+showImage+'\');"/>');
				$("#"+imageName).val('');//清空隐藏域
				$("#"+delImage).hide();//隐藏删除图片的 a 链接
				$("#"+showImage).hide();//隐藏显示上传后名称的span
			 }	
		});
	} 
	var LODOP;
	var strSubject="";
	//模板设计
	function designTemplate(){
		//验证15个文本及5个图片输入是否合法,如果不合法则不继续下面的操作
		if(!onValidTemplate())
			return;
		LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));

		//初始化并自定义纸张大小
		LODOP.PRINT_INITA(0,100,888,1000,"模板设计中.");
	
		//取得图片路径
		var avUrl=	$("#ava_url").val();
		var id=$("#id").val();

		if(isNull(id)){
			//生成打印背景图片
			var imageName=$("#imageName").val();
			if(!isNull(imageName)){
				LODOP.ADD_PRINT_SETUP_BKIMG('<img border="0" src="'+avUrl+imageName+'"></img>');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}

			//设计模板固定图片
			var fixedImage=$.trim($("#fixedImage").val());
			if(!isNull(fixedImage)){
				LODOP.ADD_PRINT_IMAGE(330,200,200,200,'<img border="0" transcolor="#FFFFFF" src="'+avUrl+fixedImage+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}

			//设计静态文本
			var staticOne=$.trim($("#staticOne").val());
			if(!isNull(staticOne))
				LODOP.ADD_PRINT_TEXT(125,183,135,30,staticOne);

			var staticTwo=$.trim($("#staticTwo").val());
			if(!isNull(staticTwo))
				LODOP.ADD_PRINT_TEXT(175,183,135,30,staticTwo);

			var staticThree=$.trim($("#staticThree").val());
			if(!isNull(staticThree))
				LODOP.ADD_PRINT_TEXT(225,183,135,30,staticThree);

			//设计打印文本
			var textOne=$.trim($("#textOne").val());
			if(!isNull(textOne))
				LODOP.ADD_PRINT_TEXT(65,43,135,30,textOne);
				
			var textTwo=$.trim($("#textTwo").val());
			if(!isNull(textTwo))
				LODOP.ADD_PRINT_TEXT(105,43,135,30,textTwo);
	
			var textThree=$.trim($("#textThree").val());
			if(!isNull(textThree))
				LODOP.ADD_PRINT_TEXT(145,43,135,30,textThree);
	
			var textFour=$.trim($("#textFour").val());
			if(!isNull(textFour))
				LODOP.ADD_PRINT_TEXT(185,43,135,30,textFour);
	
			var textFive=$.trim($("#textFive").val());
			if(!isNull(textFive))
				LODOP.ADD_PRINT_TEXT(225,43,135,30,textFive);
	
			var textSix=$.trim($("#textSix").val());
			if(!isNull(textSix))
				LODOP.ADD_PRINT_TEXT(265,43,135,30,textSix);
	
			var textSeven=$.trim($("#textSeven").val());
			if(!isNull(textSeven))
				LODOP.ADD_PRINT_TEXT(305,43,135,30,textSeven);
	
			var textEight=$.trim($("#textEight").val());
			if(!isNull(textEight))
				LODOP.ADD_PRINT_TEXT(345,43,135,30,textEight);
	
			var textNine=$.trim($("#textNine").val());
			if(!isNull(textNine))
				LODOP.ADD_PRINT_TEXT(385,43,135,30,textNine);
	
			var textTen=$.trim($("#textTen").val());
			if(!isNull(textTen))
				LODOP.ADD_PRINT_TEXT(425,43,135,30,textTen);
			
			var textEleven=$.trim($("#textEleven").val());
			if(!isNull(textEleven))
				LODOP.ADD_PRINT_TEXT(465,43,135,30,textEleven);
			 
			var textTwelve=$.trim($("#textTwelve").val());
			if(!isNull(textTwelve))
				LODOP.ADD_PRINT_TEXT(505,43,135,30,textTwelve);
			
			var textThirteen=$.trim($("#textThirteen").val());
			if(!isNull(textThirteen))
				LODOP.ADD_PRINT_TEXT(545,43,135,30,textThirteen);
			
			var textFourteen=$.trim($("#textFourteen").val());
			if(!isNull(textFourteen))
				LODOP.ADD_PRINT_TEXT(585,43,135,30,textFourteen);
			
			var textFifteen=$.trim($("#textFifteen").val());
			if(!isNull(textFifteen))
				LODOP.ADD_PRINT_TEXT(625,43,135,30,textFifteen);

			//设计打印图片
			var imageUrlOne=$("#imageUrlOne").val();
			if(!isNull(imageUrlOne)){
				LODOP.ADD_PRINT_IMAGE(30,350,100,100,'<img transcolor="#FFFFFF" border="0" src="'+avUrl+imageUrlOne+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}
	
			var imageUrlTwo=$("#imageUrlTwo").val();
			if(!isNull(imageUrlTwo)){
				LODOP.ADD_PRINT_IMAGE(130,350,100,100,'<img transcolor="#FFFFFF" border="0" src="'+avUrl+imageUrlTwo+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}
	
			var imageUrlThree=$("#imageUrlThree").val();
			if(!isNull(imageUrlThree)){
				LODOP.ADD_PRINT_IMAGE(230,350,100,100,'<img transcolor="#FFFFFF" border="0" src="'+avUrl+imageUrlThree+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}
			
			var imageUrlFour=$("#imageUrlFour").val();
			if(!isNull(imageUrlFour)){
				LODOP.ADD_PRINT_IMAGE(330,350,100,100,'<img transcolor="#FFFFFF" border="0" src="'+avUrl+imageUrlFour+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}
			var imageUrlFive=$("#imageUrlFive").val();
			if(!isNull(imageUrlFive)){
				LODOP.ADD_PRINT_IMAGE(430,350,100,100,'<img transcolor="#FFFFFF" border="0" src="'+avUrl+imageUrlFive+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}
		}else{
			var newsLodText="";//定义全局LODOP字符串
			strSubject=$("#strSubject").val();//获得模板修改前的内容
			//设置打印背景图片
			var imageName=$("#imageName").val();
			if(!isNull(imageName)){
				newsLodText+='LODOP.ADD_PRINT_SETUP_BKIMG(\'<img transcolor="#FFFFFF" border=\"0\" src=\"'+avUrl+imageName+'\" ></img>\');';
				//newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
			}

			//设置背景图片的属性
			var index = strSubject.indexOf("LODOP.ADD_PRINT_TEXT");
			var imgIndex = strSubject.indexOf("LODOP.ADD_PRINT_IMAGE");
			//先取固定图片之前的一段代码为背景图片的属性,如果不行说明没有固定图片则再取第一个文本之前的一段代码为背景图片的属性
			if(imgIndex!=-1 && imgIndex <index){
				var backImgPro =strSubject.substr(0,imgIndex);//获得背景图片的属性
				newsLodText+=backImgPro;
			}else{
				var backImgPro =strSubject.substr(0,index);//获得背景图片的属性
				newsLodText+=backImgPro;
			}

			//设计模板固定图片
			var oldFixedImage=oldObj.fixedImage;//取得旧文本
			var newFixedImage=$.trim($("#fixedImage").val());//取得新文本
			if(isNull(oldFixedImage) && !isNull(newFixedImage)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				LODOP.ADD_PRINT_IMAGE(330,200,200,200,'<img border="0" transcolor="#FFFFFF" src="'+avUrl+newFixedImage+'" />');
				//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//按原图比例(可变形)缩放模式
			}else if(!isNull(oldFixedImage) && !isNull(newFixedImage)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldFixedImage);
				newsLodText+=textVal.replace(oldFixedImage,newFixedImage);
			}
 
			//设置静态文本一
			var bIndex=0;
			var eIndex=0;
			var oldStaticOne=oldObj.staticOne;//取得旧文本
			var newStaticOne=$.trim($("#staticOne").val());//取得新文本
			if(isNull(oldStaticOne) && !isNull(newStaticOne)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(125,183,135,30,"'+newStaticOne+'");';
			}else if(!isNull(oldStaticOne) && !isNull(newStaticOne)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				bIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT");
				eIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT",bIndex+1);
				var textVal = strSubject.substring(bIndex,eIndex)
				newsLodText+=textVal;
			}
	
			//设置静态文本二
			var tbIndex=0;
			var teIndex=0;
			var oldStaticTwo=oldObj.staticTwo;//取得旧文本
			var newStaticTwo=$.trim($("#staticTwo").val());//取得新文本
			if(isNull(oldStaticTwo) && !isNull(newStaticTwo)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(175,183,135,30,"'+newStaticTwo+'");';
			}else if(!isNull(oldStaticTwo) && !isNull(newStaticTwo)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				tbIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT",eIndex);
				teIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT",eIndex+1);
				var textVal = strSubject.substring(tbIndex,teIndex)
				newsLodText+=textVal;
			}
 
			//设置静态文本三
			var thbIndex=0;
			var theIndex=0;
			var oldStaticThree=oldObj.staticThree;//取得旧文本
			var newStaticThree=$.trim($("#staticThree").val());//取得新文本
			if(isNull(oldStaticThree) && !isNull(newStaticThree)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(225,183,135,30,"'+newStaticThree+'");';
			}else if(!isNull(oldStaticThree) && !isNull(newStaticThree)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				thbIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT",teIndex);
				theIndex= strSubject.indexOf("LODOP.ADD_PRINT_TEXT",teIndex+1);
				var textVal = strSubject.substring(thbIndex,theIndex)
				newsLodText+=textVal;
			}
			
			//设置模板文本一
			var oldTextOne=oldObj.textOne;//取得旧文本
			var newTextOne=$.trim($("#textOne").val());//取得新文本
			if(isNull(oldTextOne) && !isNull(newTextOne)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(65,43,135,30,"'+newTextOne+'");';
			}else if(!isNull(oldTextOne) && !isNull(newTextOne)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextOne+"\"");
				newsLodText+=textVal.replace(oldTextOne,newTextOne);
			}
 
			//设置模板文本二
			var oldTextTwo=oldObj.textTwo;//取得旧文本
			var newTextTwo=$.trim($("#textTwo").val());//取得新文本
			if(isNull(oldTextTwo) && !isNull(newTextTwo)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(105,43,135,30,"'+newTextTwo+'");';
			}else if(!isNull(oldTextTwo) && !isNull(newTextTwo)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextTwo+"\"");
				newsLodText+=textVal.replace(oldTextTwo,newTextTwo);
			}
			
			//设置模板文本三
			var oldTextThree=oldObj.textThree;//取得旧文本
			var newTextThree=$.trim($("#textThree").val());//取得新文本
			if(isNull(oldTextThree) && !isNull(newTextThree)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(145,43,135,30,"'+newTextThree+'");';
			}else if(!isNull(oldTextThree) && !isNull(newTextThree)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextThree+"\"");
				newsLodText+=textVal.replace(oldTextThree,newTextThree);
			}
			
			//设置模板文本四
			var oldTextFour=oldObj.textFour;//取得旧文本
			var newTextFour=$.trim($("#textFour").val());//取得新文本
			if(isNull(oldTextFour) && !isNull(newTextFour)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(185,43,135,30,"'+newTextFour+'");';
			}else if(!isNull(oldTextFour) && !isNull(newTextFour)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextFour+"\"");
				newsLodText+=textVal.replace(oldTextFour,newTextFour);
			}
	 
			//设置模板文本五
			var oldTextFive=oldObj.textFive;//取得旧文本
			var newTextFive=$.trim($("#textFive").val());//取得新文本
			if(isNull(oldTextFive) && !isNull(newTextFive)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(225,43,135,30,"'+newTextFive+'");';
			}else if(!isNull(oldTextFive) && !isNull(newTextFive)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextFive+"\"");
				newsLodText+=textVal.replace(oldTextFive,newTextFive);
			}
 
			//设置模板文本六
			var oldTextSix=oldObj.textSix;//取得旧文本
			var newTextSix=$.trim($("#textSix").val());//取得新文本
			if(isNull(oldTextSix) && !isNull(newTextSix)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(265,43,135,30,"'+newTextSix+'");';
			}else if(!isNull(oldTextSix) && !isNull(newTextSix)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextSix+"\"");
				newsLodText+=textVal.replace(oldTextSix,newTextSix);
			}

			//设置模板文本七
			var oldTextSeven=oldObj.textSeven;//取得旧文本
			var newTextSeven=$.trim($("#textSeven").val());//取得新文本
			if(isNull(oldTextSeven) && !isNull(newTextSeven)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(305,43,135,30,"'+newTextSeven+'");';
			}else if(!isNull(oldTextSeven) && !isNull(newTextSeven)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextSeven+"\"");
				newsLodText+=textVal.replace(oldTextSeven,newTextSeven);
			}

			//设置模板文本八
			var oldTextEight=oldObj.textEight;//取得旧文本
			var newTextEight=$.trim($("#textEight").val());//取得新文本
			if(isNull(oldTextEight) && !isNull(newTextEight)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(345,43,135,30,"'+newTextEight+'");';
			}else if(!isNull(oldTextEight) && !isNull(newTextEight)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextEight+"\"");
				newsLodText+=textVal.replace(oldTextEight,newTextEight);
			}

			//设置模板文本九
			var oldTextNine=oldObj.textNine;//取得旧文本
			var newTextNine=$.trim($("#textNine").val());//取得新文本
			if(isNull(oldTextNine) && !isNull(newTextNine)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(385,43,135,30,"'+newTextNine+'");';
			}else if(!isNull(oldTextNine) && !isNull(newTextNine)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextNine+"\"");
				newsLodText+=textVal.replace(oldTextNine,newTextNine);
			}

			//设置模板文本十
			var oldTextTen=oldObj.textTen;//取得旧文本
			var newTextTen=$.trim($("#textTen").val());//取得新文本
			if(isNull(oldTextTen) && !isNull(newTextTen)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(425,43,135,30,"'+newTextTen+'");';
			}else if(!isNull(oldTextTen) && !isNull(newTextTen)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextTen+"\"");
				newsLodText+=textVal.replace(oldTextTen,newTextTen);
			}

			//设置模板文本十一
			var oldTextEleven=oldObj.textEleven;//取得旧文本
			var newTextEleven=$.trim($("#textEleven").val());//取得新文本
			if(isNull(oldTextEleven) && !isNull(newTextEleven)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(465,43,135,30,"'+newTextEleven+'");';
			}else if(!isNull(oldTextEleven) && !isNull(newTextEleven)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextEleven+"\"");
				newsLodText+=textVal.replace(oldTextOne,newTextEleven);
			}

			//设置模板文本十二
			var oldTextTwelve=oldObj.textTwelve;//取得旧文本
			var newTextTwelve=$.trim($("#textTwelve").val());//取得新文本
			if(isNull(oldTextTwelve) && !isNull(newTextTwelve)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(505,43,135,30,"'+newTextTwelve+'");';
			}else if(!isNull(oldTextTwelve) && !isNull(newTextTwelve)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextTwelve+"\"");
				newsLodText+=textVal.replace(oldTextTwelve,newTextTwelve);
			}

			//设置模板文本十三
			var oldTextThirteen=oldObj.textThirteen;//取得旧文本
			var newTextThirteen=$.trim($("#textThirteen").val());//取得新文本
			if(isNull(oldTextThirteen) && !isNull(newTextThirteen)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(545,43,135,30,"'+newTextThirteen+'");';
			}else if(!isNull(oldTextThirteen) && !isNull(newTextThirteen)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextThirteen+"\"");
				newsLodText+=textVal.replace(oldTextThirteen,newTextThirteen);
			}

			//设置模板文本十四
			var oldTextFourteen=oldObj.textFourteen;//取得旧文本
			var newTextFourteen=$.trim($("#textFourteen").val());//取得新文本
			if(isNull(oldTextFourteen) && !isNull(newTextFourteen)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(585,43,135,30,"'+newTextFourteen+'");';
			}else if(!isNull(oldTextFourteen) && !isNull(newTextFourteen)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextFourteen+"\"");
				newsLodText+=textVal.replace(oldTextFourteen,newTextFourteen);
			}
			
			//设置模板文本十五
			var oldTextFifteen=oldObj.textFifteen;//取得旧文本
			var newTextFifteen=$.trim($("#textFifteen").val());//取得新文本
			if(isNull(oldTextFifteen) && !isNull(newTextFifteen)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_TEXT(625,43,135,30,"'+newTextFifteen+'");';
			}else if(!isNull(oldTextFifteen) && !isNull(newTextFifteen)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr("\""+oldTextFifteen+"\"");
				newsLodText+=textVal.replace(oldTextFifteen,newTextFifteen);
			}

			//设置模板图片一
			var oldImageUrlOne=oldObj.imageUrlOne;//取得旧文本
			var newImageUrlOne=$.trim($("#imageUrlOne").val());//取得新文本
			if(isNull(oldImageUrlOne) && !isNull(newImageUrlOne)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_IMAGE(30,350,100,100,\'<img transcolor="#FFFFFF" border="0" src="'+avUrl+newImageUrlOne+'" />\');';
				newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
				
			}else if(!isNull(oldImageUrlOne) && !isNull(newImageUrlOne)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldImageUrlOne);
				newsLodText+=textVal.replace(oldImageUrlOne,newImageUrlOne);
			}

			//设置模板图片二
			var oldImageUrlTwo=oldObj.imageUrlTwo;//取得旧文本
			var newImageUrlTwo=$.trim($("#imageUrlTwo").val());//取得新文本
			if(isNull(oldImageUrlTwo) && !isNull(newImageUrlTwo)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_IMAGE(130,350,100,100,\'<img transcolor="#FFFFFF" border="0" src="'+avUrl+newImageUrlTwo+'" />\');';
				//newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
			}else if(!isNull(oldImageUrlTwo) && !isNull(newImageUrlTwo)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldImageUrlTwo);
				newsLodText+=textVal.replace(oldImageUrlTwo,newImageUrlTwo);
			}

			//设置模板图片三
			var oldImageUrlThree=oldObj.imageUrlThree;//取得旧文本
			var newImageUrlThree=$.trim($("#imageUrlThree").val());//取得新文本
			if(isNull(oldImageUrlThree) && !isNull(newImageUrlThree)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_IMAGE(330,350,100,100,\'<img transcolor="#FFFFFF" border="0" src="'+avUrl+newImageUrlThree+'" />\');';
				//newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
				
			}else if(!isNull(oldImageUrlThree) && !isNull(newImageUrlThree)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldImageUrlThree);
				newsLodText+=textVal.replace(oldImageUrlThree,newImageUrlThree);
			}
			
			//设置模板图片四
			var oldImageUrlFour=oldObj.imageUrlFour;//取得旧文本
			var newImageUrlFour=$.trim($("#imageUrlFour").val());//取得新文本
			if(isNull(oldImageUrlFour) && !isNull(newImageUrlFour)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_IMAGE(430,350,100,100,\'<img transcolor="#FFFFFF" border="0" src="'+avUrl+newImageUrlFour+'" />\');';
				//newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
				
			}else if(!isNull(oldImageUrlFour) && !isNull(newImageUrlFour)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldImageUrlFour);
				newsLodText+=textVal.replace(oldImageUrlFour,newImageUrlFour);
			}
			
			//设置模板图片五
			var oldImageUrlFive=oldObj.imageUrlFive;//取得旧文本
			var newImageUrlFive=$.trim($("#imageUrlFive").val());//取得新文本
			if(isNull(oldImageUrlFive) && !isNull(newImageUrlFive)){//如果旧文本为空,新文本不为空,则新增一个标准lodop字符串
				newsLodText+='LODOP.ADD_PRINT_IMAGE(530,350,100,100,\'<img transcolor="#FFFFFF" border="0" src="'+avUrl+newImageUrlFive+'" />\');';
				//newsLodText+='LODOP.SET_PRINT_STYLEA(0,"Stretch",1);';//按原图比例(可变形)缩放模式
				
			}else if(!isNull(oldImageUrlFive) && !isNull(newImageUrlFive)){ //如果新文本和旧文本都不为空,则从大字符串中取出属性,并将新文本替换旧文本
				var textVal=getTextStr(oldImageUrlFive);
				newsLodText+=textVal.replace(oldImageUrlFive,newImageUrlFive);
			}
			eval(newsLodText);
		}
		
		LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);//打印预览时是否包含背景图
		LODOP.SET_SHOW_MODE("HIDE_ABUTTIN_SETUP",1);//隐藏应用按钮
		LODOP.SET_SHOW_MODE("HIDE_RBUTTIN_SETUP",1);//隐藏复原按钮
		//LODOP.SET_SHOW_MODE("HIDE_DISBUTTIN_SETUP",1);//隐藏那些无效按钮
		//LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_SETUP",1);//隐藏打印按钮
		//LODOP.SET_SHOW_MODE("HIDE_VBUTTIN_SETUP",1);//隐藏预览按钮 
		
		LODOP.SET_PRINT_MODE("PRINT_SETUP_PROGRAM",true);//设置打印维护窗口关闭后是否返回程序代码
		var subject = LODOP.PRINT_DESIGN();
		//截取并去掉背景图片代码
		var index= subject.indexOf("</img>\");");
		if(index!=-1)
			subject= subject.substr(index+9,subject.length);
		//将打印内容保存到对象属性中
		$("#subject").val(subject);
		onSave();
	} 

	//修改时获得某个文本或图片的全设计代码
	function getTextStr(textVal){
		var flagLodText="ADD_PRINT_TEXT";//获得文本的标识字符串;
		var flagLodImg="ADD_PRINT_IMAGE";//获得图片的标识字符串
		var textValue="";
		var strArray= strSubject.split(";");
		var len=strArray.length;
		var flag=false;
		for(var i=0;i<len-1;i++){
			if(!isNull(strArray[i]) && (strArray[i].indexOf(textVal)!=-1)){
				textValue+=strArray[i]+";";//获得当前文本或图片
				flag=true;
				continue;
			}
			
			if(flag){//如果下一句代码包含下一个文本或图片,则直接返回当前文本或图片
				if(!isNull(strArray[i]) && (strArray[i].indexOf(flagLodText)!=-1)){
					return textValue;
				}else if(!isNull(strArray[i]) && (strArray[i].indexOf(flagLodImg)!=-1))
					return textValue;
				else //获得当前文本或图片的属性代码
					textValue+=strArray[i]+";";
			}
		}
		return textValue;
	}

	//判断非空
	function isNull(value){
		return (value==null || ""==value)?true:false;
	}
	</script>
</head>
<body>
<!--浮动层-->	
	<!-- JS遮罩层 --> 
	<div id="fullbg"></div> 
	<!-- end JS遮罩层 --> 
	<!-- 对话框 --> 
	<div id="dialog"> 
		<div id="dialog_content"></div> 
	</div>
 
    <!--浮动层 end --> 
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->

<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="certtemplatelist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">培训项目管理</a>
</li>
<li class="active">证书模板列表</li>
</ol>
<div class="dr-page-header">
<h3>
创建证书模板
</h3>
</div>
<hr/>
<div id="a_1_box" class="panel panel-default">
   <form class="form-horizontal dr-form-bordered" action="certtemplate!save.action" method="post" id="form1" name="form1" enctype="multipart/form-data"> 
	<input type="hidden" name="id" id="id" value="${id}" /> 
    <input type="hidden" name="subject" id="subject" value='${subject}'/>
    <input type="hidden" name="strSubject" id="strSubject" value='${requestScope.strSubject}'/>
 	<input id="ava_url" name="ava_url" type="hidden" value="<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}"/><%=Constants.CETTEMPLATE_PATH%>"/>
	<div class="dr-form-title clearfix">
    <div class="col-md-12">
    <h4 class="text-primary">证书模板基本信息</h4>
    </div>
	</div>
			<div class="form-group"> 
				<label class="col-md-5 text-danger">以下有*的内容为必填项：</label>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板名称<span class="text-danger">*</span></label> 
				<div class="col-md-3">
				<input type="text" name="name" id="name" value="${name}" maxlength="50" class="form-control" />
				</div>
			</div>
            <div class="form-group">
            <label class="col-md-2 control-label">是否启用模板</label>
	            <div class="col-md-3">
	            <div class="radio" style="float: left;margin-right: 25px;">
	            <input type="radio" name="status" id="status1" value="true" <s:if test="id==null || status">checked="checked"</s:if>/>是
	             </div>
	             <div class="radio">
	             <input type="radio" name="status" id="status2" value="false" <s:if test="id!=null && !status">checked="checked"</s:if>/>否
	            </div>
	            </div>
          	</div>
			<div class="form-group">

				<label class="col-md-2 control-label">模板背景图片</br>(990x700px) </label>
				<div class="col-md-3" id="filespan">
                 <input type="file" name="picfile" id="picfile" size="30" style="margin-top: 5px;" onchange="onValidate('picfile','imageName','filespan','delImageName','showImageName');"/>
				</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" class="btn btn-default btn-sm" id="delImageName" style="margin-left:20px;display: <s:if test="id==null || imageName==null || ''==imageName">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile','imageName','filespan','delImageName','showImageName');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;
                </div>
				<div class="col-md-4 help-block" style="margin-left:20px;" id="showImageName">&nbsp;${imageName}</div>  
				<input type="hidden" name="imageName" id="imageName" value="${imageName}"/>  
			</div> 	
			<div class="form-group"> 

				<label class="col-md-2 control-label" >模板固定图片</label>
				<div class="col-md-3" id="fixfilespan" style="margin-top: -15px;">&nbsp;<input type="file" name="picfile" id="fixpicfile" size="30" onchange="onValidate('fixpicfile','fixedImage','fixfilespan','delFixedImage','showFixedImage');"/>
				</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" id="delFixedImage" style="margin-left:20px;display: <s:if test="id==null || fixedImage==null || ''==fixedImage">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('fixpicfile','fixedImage','fixfilespan','delFixedImage','showFixedImage');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showFixedImage">&nbsp;${fixedImage}</div>  
				<input type="hidden" name="old_fixedImage" id="old_fixedImage" value="${fixedImage}"/> 
				<input type="hidden" name="fixedImage" id="fixedImage" value="${fixedImage}"/> 
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">模板静态文本1</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_staticOne" name="old_staticOne" value="${staticOne}"/>
				<input type="text" name="staticOne" id="staticOne" value="${staticOne}" maxlength="50"  class="form-control " />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">模板静态文本2</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_staticTwo" name="old_staticTwo" value="${staticTwo}"/>
				<input type="text" name="staticTwo" id="staticTwo" value="${staticTwo}" maxlength="50" class="form-control " />
				</div>
			</div>
			<div class="form-group"> 
				<label class="col-md-2 control-label">模板静态文本3</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_staticThree" name="old_staticThree" value="${staticThree}"/>
				<input type="text" name="staticThree" id="staticThree" value="${staticThree}" maxlength="50" class="form-control"  />
				</div>
			</div>		
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本1</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textOne" name="old_textOne" value="${textOne}"/>
				<input  type="text" name="textOne" id="textOne" value="${textOne}" maxlength="50" class="form-control certText"   />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本2</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textTwo" name="old_textTwo" value="${textTwo}"/>
				<input  type="text" name="textTwo" id="textTwo" value="${textTwo}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本3</label>
				<div class="col-md-3">
				<input type="hidden" id="old_textThree" name="old_textThree" value="${textThree}"/>
				<input  type="text" name="textThree" id="textThree" value="${textThree}" maxlength="50" class="form-control  certText"  />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本4</label>
				<div class="col-md-3">
				<input type="hidden" id="old_textFour" name="old_textFour" value="${textFour}"/>
				<input  type="text" name="textFour" id="textFour" value="${textFour}" maxlength="50" class="form-control certText"  />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本5</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textFive" name="old_textFive" value="${textFive}"/>
				<input  type="text" name="textFive" id="textFive" value="${textFive}" maxlength="50" class="form-control certText"   />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本6</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textSix" name="old_textSix" value="${textSix}"/>
				<input type="text" name="textSix" id="textSix" value="${textSix}" maxlength="50"  class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本7</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textSeven" name="old_textSeven" value="${textSeven}"/>
				<input  type="text" name="textSeven" id="textSeven" value="${textSeven}" maxlength="50"  class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本8</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textEight" name="old_textEight" value="${textEight}"/>
				<input  type="text" name="textEight" id="textEight" value="${textEight}" maxlength="50"  class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本9</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textNine" name="old_textNine" value="${textNine}"/>
				<input  type="text" name="textNine" id="textNine" value="${textNine}" maxlength="50"  class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本10</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textTen" name="old_textTen" value="${textTen}"/>
				<input type="text" name="textTen" id="textTen" value="${textTen}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本11</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textEleven" name="old_textEleven" value="${textEleven}"/>
				<input type="text" name="textEleven" id="textEleven" value="${textEleven}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本12</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textTwelve" name="old_textTwelve" value="${textTwelve}"/>
				<input  type="text" name="textTwelve" id="textTwelve" value="${textTwelve}" maxlength="50"  class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本13</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textThirteen" name="old_textThirteen" value="${textThirteen}"/>
				<input  type="text" name="textThirteen" id="textThirteen" value="${textThirteen}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本14</label> 
				<div class="col-md-3">
				<input type="hidden" id="old_textFourteen" name="old_textFourteen" value="${textFourteen}"/>
				<input  type="text" name="textFourteen" id="textFourteen" value="${textFourteen}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板文本15</label> 
				 <div class="col-md-3">
				 <input type="hidden" id="old_textFifteen" name="old_textFifteen" value="${textFifteen}"/>
				 <input  type="text" name="textFifteen" id="textFifteen" value="${textFifteen}" maxlength="50" class="form-control certText" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" >证书模板图片1</label>
				<div class="col-md-3" id="filespan1" style="margin-top: 3px;">
				<input type="file" name="picfile" id="picfile1" size="30" onchange="onValidate('picfile1','imageUrlOne','filespan1','delImageName1','showImageName1');" />&nbsp;
				</div>
				<p class="help-block">tips：默认印章浮于文字之上,印章图片应为透明印章图片</br> 照片:105x145px; 二维码：85x85px; 电子条码:250x50px</p>
				<div class="col-md-1" style="display: inline;"><a class="btn btn-default btn-sm" id="delImageName1" style="margin-left:20px;display: <s:if test="id==null || imageUrlOne==null || ''==imageUrlOne">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile1','imageUrlOne','filespan1','delImageName1','showImageName1');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showImageName1">&nbsp;${imageUrlOne}</div>  
				<input type="hidden" name="imageUrlOne" id="imageUrlOne" value="${imageUrlOne}"/>
				<input type="hidden" name="old_imageUrlOne" id="old_imageUrlOne" value="${imageUrlOne}"/> 
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板图片2</label>
				<div class="col-md-3" id="filespan2" style="margin-top: -15px;">&nbsp;<input type="file" name="picfile" id="picfile2" size="30" onchange="onValidate('picfile2','imageUrlTwo','filespan2','delImageName2','showImageName2');"/>&nbsp;</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" id="delImageName2" style="margin-left:20px;display: <s:if test="id==null || imageUrlTwo==null || ''==imageUrlTwo">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile2','imageUrlTwo','filespan2','delImageName2','showImageName2');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showImageName2">&nbsp;${imageUrlTwo}</div>  
				<input type="hidden" name="imageUrlTwo" id="imageUrlTwo" value="${imageUrlTwo}"/>
				<input type="hidden" name="old_imageUrlTwo" id="old_imageUrlTwo" value="${imageUrlTwo}"/>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" >证书模板图片3</label>
				<div class="col-md-3" id="filespan3"  style="margin-top: -15px;">&nbsp;<input type="file" name="picfile" id="picfile3" size="30" onchange="onValidate('picfile3','imageUrlThree','filespan3','delImageName3','showImageName3');"/>&nbsp;</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" id="delImageName3" style="margin-left:20px; display: <s:if test="id==null || imageUrlThree==null || ''==imageUrlThree">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile3','imageUrlThree','filespan3','delImageName3','showImageName3');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showImageName3">&nbsp;${imageUrlThree}</div>  
				<input type="hidden" name="imageUrlThree" id="imageUrlThree" value="${imageUrlThree}"/>
 				<input type="hidden" name="old_imageUrlThree" id="old_imageUrlThree" value="${imageUrlThree}"/>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">证书模板图片4</label>
				<div class="col-md-3" id="filespan4"  style="margin-top: -15px;">&nbsp;<input type="file" name="picfile" id="picfile4" size="30" onchange="onValidate('picfile4','imageUrlFour','filespan4','delImageName4','showImageName4');"/>&nbsp;</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" id="delImageName4" style="margin-left:20px;display:<s:if test="id==null || imageUrlFour==null || ''==imageUrlFour">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile4','imageUrlFour','filespan4','delImageName4','showImageName4');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showImageName4">&nbsp;${imageUrlFour}</div>  
				<input type="hidden" name="imageUrlFour" id="imageUrlFour" value="${imageUrlFour}"/>
				<input type="hidden" name="old_imageUrlFour" id="old_imageUrlFour" value="${imageUrlFour}"/>								 			
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" >证书模板图片5</label>
				<div class="col-md-3" id="filespan5"  style="margin-top: -15px;">&nbsp;<input type="file" name="picfile" id="picfile5" size="30" onchange="onValidate('picfile5','imageUrlFive','filespan5','delImageName5','showImageName5');"/>&nbsp;</div>
				<div class="col-md-1"><a class="btn btn-default btn-sm" id="delImageName5" style="margin-left:20px;display: <s:if test="id==null || imageUrlFive==null || ''==imageUrlFive">none</s:if><s:else>inline-block</s:else>;" href="javascript:void(0);" onclick="onDelImage('picfile5','imageUrlFive','filespan5','delImageName5','showImageName5');">
				<span class="glyphicon glyphicon-trash"></span>&nbsp;删除文件</a>&nbsp;</div>
				<div class="col-md-4" style="margin-left:20px;" id="showImageName5">&nbsp;${imageUrlFive}</div>  
				<input type="hidden" name="imageUrlFive" id="imageUrlFive" value="${imageUrlFive}"/>
				<input type="hidden" name="old_imageUrlFive" id="old_imageUrlFive" value="${imageUrlFive}"/>				
			</div>			
			<div class="form-group">

				<label class="col-md-2 control-label">请进行模板设计<span class="text-danger">*</span></label>
				<div class="col-md-2">
				<button class="btn btn-primary btn-sm" id="templateDegin" onclick="designTemplate();return false;">
				<span class="glyphicon glyphicon-cog"></span>&nbsp;模板设计</button>
				</div>
				<p class="help-block">(请注意:如果内容有改动,请点击模板设计)</p> <strong id="error_subject"></strong>           
			</div>

		<div class="panel-footer">
			<div class="row">
				<div class="col-md-offset-2 col-md-10">	
						<button type="button" onclick="onSave();" class="btn btn-primary btn-sm" ><span class="glyphicon glyphicon-save"></span>&nbsp;保存</button>&nbsp;&nbsp;
						<button type="button" class="btn btn-default btn-sm"   onclick="location.href='certtemplate.action';"><span class="glyphicon glyphicon-remove-circle"></span>&nbsp;取消</button>
				</div>
			</div>
		</div>
      </form>
	  </div>
      </div>
      </div>
       <!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
      </section>
      	   
</body>
</html>
