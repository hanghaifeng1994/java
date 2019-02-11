	var selectX;
	var selectY;
	var selectW;
	var selectH;
	var cutX;
	var cutY;
	var cutW;
	var cutH;
	var picfile_path;//文件保存路径
	var opicfileName;//原文件名称
	var tmpfileName;//处理中的临时文件名称，最终保存一次为准，每次要显示的图片名称，如果裁剪框能拖动，那么就可能会变化 ，如果裁剪狂固定大小就不会变化，图片缩放依次为基础
	//设置原始图片的高和宽
	var oht;
	var owt;
	var isInit;//是否初始化状态，用于判断操作前是否要进行
	var isCut;//是否进行过裁剪
	var postCutUrl="";
	var postUploadUrl="";
	//设置裁剪参数
	function setJcrop(left,top,width,height,pic_path,init_filename,cutUrl,uploadUrl){
		selectX = left;
		selectY = top;
		selectW = width;
		selectH = height;
		picfile_path = pic_path;
		opicfileName = init_filename;
		tmpfileName = init_filename;
		initJcrop(selectX,selectY,selectW,selectH);
		//付给操作区图片文件
		//alert(pic_path+o_filename)
		$("#xuwanting").attr("src",pic_path+init_filename);
		isInit = true;
		postCutUrl= cutUrl;
		postUploadUrl = uploadUrl;
	};
	
	//Jcrop调用	
	function initJcrop(left,top,width,height){
		$("#xuwanting").Jcrop({ 
			bgColor:"#EEEEEE", //裁剪时背景颜色设为灰色 
			allowSelect:false,//不允许选择区域
			allowResize:false, //不允许改变选中区域的大小 
			setSelect:[left,top,width,height], //初始化选中区域 
			onChange:setCoords, //当选择区域变化的时候，执行对应的回调函数 
			onSelect:setCoords //当选中区域的时候，执行对应的回调函数
		});	
	};
	
	//简单的事件处理程序，响应自onChange,onSelect事件，按照上面的Jcrop调用	 
	//设置剪裁目标，要裁剪的位置信息
	function setCoords(obj){
		cutX = obj.x;
		cutY = obj.y; 
		cutW = obj.w;
		cutH = obj.h;
	}
	
	//判断上传照片格式
	function onValidate()
	{   
		var picFile = document.getElementById('picfile').value;
		var picfileObj = picFile.substr(picFile.lastIndexOf(".")).toLowerCase(); 
			if(picfileObj!=".jpg" && picfileObj!=".JPG"){
				alert("上传图片格式不正确，请重新上传.");
				//document.getElementById('error_picurl').style.display="block";
				tmpfileName = "";
				document.getElementById('filespan').innerHTML='<center><input type="file" name="picfile" id="picfile" size="30" onchange="onValidate();"/></center>';
				return;
			}else
				ajaxFileUpload();
	}
	
	//自定义照片上传
	function ajaxFileUpload(){
		showLayer('dialog','dialog_content',"<span style='text-align:center'><img align='top' alt='正在上传...' src='../images/loading.gif'/></span>");
		$.ajaxFileUpload
		(
			{
				url:postUploadUrl+'?rnd='+Math.random(),//用于文件上传的服务器端请求地址
				secureuri:false,//一般设置为false
				fileElementId:'picfile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
				dataType: 'json',//返回值类型 一般设置为json
				success: function (data, status)  //服务器成功响应处理函数
				{ 
					closeLayer();//关闭提示层
					if(data!=null){
						if(data.message!=null){
							alert(data.message);//错误提示信息，如附件太大，上传失败
							//上传失败后，清空上传文件框
							document.getElementById('filespan').innerHTML='<center><input type="file" name="picfile" id="picfile" size="30" onchange="onValidate();"/><center>';
							return;
						}else{
							var fileName = data.avatarname; 
							var fullImgPath = picfile_path +fileName;
							//保存图片名称用于裁剪图片 
							tmpfileName = fileName;
							//保存原始图片，用于还原
							opicfileName = fileName;
							//设置高和宽
							oht = data.height;
							owt = data.width;
							//给操作区赋新图片
							document.getElementById('define_ava_div').innerHTML='<center style="margin-top: 10px;"><img style="" id="xuwanting" src="'+fullImgPath+'" /></center>';
							document.getElementById('define_ava_div').style.height="600px";
							//重新初始化剪裁 
							initJcrop(selectX,selectY,selectW,selectH);
							$("#filespan").hide();
							isInit=false;//上传后就不是初始化状态了，可以进行操作了
						}
					}	
					if(typeof(data.error) != 'undefined')
					{
						if(data.error != '')
						{
							alert(data.error);
						}else
						{
							
							alert(data.message);
						}
					}
				},
				error: function (data, status, e)//服务器响应失败处理函数
				{
					closeLayer();//关闭提示层
					alert("上传失败");
				}
			}
		)
		return false;
	}
	
	//重置为初始图片
	function reset(){
		if(isInit){
			alert("请先上传照片！");
			return;
		}
		if(tmpfileName=="" || tmpfileName==null)return;
		tmpfileName = opicfileName;
		var fullImgPath = picfile_path + tmpfileName;
		document.getElementById('define_ava_div').innerHTML='<center style="margin-top: 10px;"><img style="" id="xuwanting" src="'+fullImgPath+'" /></center>';
		//用原始图片重新设置原始高和宽
		oht=$("#xuwanting").attr("width");
		owt=$("#xuwanting").attr("height");	
		initJcrop(selectX,selectY,selectW,selectH);
		document.getElementById('define_ava_div').style.height="600px";
	}
	
	//裁剪照片，多次裁剪动作只要未保存，都不会改变用户最终图片
	function onCut(){	
		if(isInit){
			alert("请先上传照片！");
			return;
		}
		if(!document.getElementById("xuwanting") || cutW==null || ""==cutW){
			return;
		}else{  
			
			var picName= tmpfileName;  
			//原始的宽和高			
			//现在的宽和高
			var nowWidth=$("#xuwanting").attr("width");
			var nowHeight=$("#xuwanting").attr("height");
			//算出等比例的宽和高
			var newW=Math.round((owt*cutW)/nowWidth);
			var newH=Math.round((oht*cutH)/nowHeight);	
			var newX=Math.round((owt*cutX)/nowWidth);
			var newY=Math.round((oht*cutY)/nowHeight);	
			
			showLayer('dialog','dialog_content',"<span style='text-align:center'><img align='top' style='z-index:10000;' alt='正在上传...' src='../images/loading.gif'/></span>");
			$.post(postCutUrl,{"X":newX,"Y":newY,"cutWidth":newW,"cutHeight":newH,"destWidth":selectW,"destHeight":selectH,"picName":picName},function(data) {
				var newPicName = data.value;
				if(newPicName=="error"){
			 		alert("系统异常,裁剪失败"); 
				}else{
 					var url=picfile_path + newPicName;
 					//给操作区赋新的图片
			 		document.getElementById('define_ava_div').innerHTML='<center><img style="" width="'+cutW+'" height="'+cutH+'" id="xuwanting" src="'+url+'"  /></center>';
			 		//重新赋临时图片新名称
			 		tmpfileName = newPicName; 
					//用切后的图片重新设置原始高和宽
					oht=$("#xuwanting").attr("width");
					owt=$("#xuwanting").attr("height");	
					
					//剪裁完了,则初始化值
					setCoords("","","","");
					$("#avatarname").val(newPicName);
					isCut = true;
			 	} 
				document.getElementById('define_ava_div').style.height="340px";
				closeLayer();//关闭提示层
			});	
		}
	}
	
	//放大照片
	function onLagr(rate){  
		if(!document.getElementById("xuwanting"))
			return ;
		if(isInit){
			alert("请先上传照片！");
			return;
		}
		//放大照片前先销毁旧的照片,否则无法去除旧照片
		$.Jcrop("#xuwanting").destroy();
		//完整照片文件
		var fullImgPath = picfile_path+tmpfileName;
		//图片当前高度，缩放0.9得到新高度
		var ht=Math.round(parseInt($("#xuwanting").attr("height"))*rate);
		//图片当前宽度，缩放0.9，得到新宽度
		var wt=Math.round(parseInt($("#xuwanting").attr("width"))*rate);
		document.getElementById('define_ava_div').innerHTML='<center><img style="" width="'+wt+'" height="'+ht+'" id="xuwanting"  src="'+fullImgPath+'" /></center>';

		//新图片加载后要重新初始化裁剪框
		initJcrop(selectX,selectY,selectW,selectH);
	}
	
	//缩小照片，每次缩放临时图片的0.9，参数为每次缩放比率
	function onSmall(rate){
		if(!document.getElementById("xuwanting"))
			return ;
		if(isInit){
			alert("请先上传照片！");
			return;
		}
		//缩小照片前先销毁旧的照片,否则无法去除旧照片
		$.Jcrop("#xuwanting").destroy();
		var fullImgPath = picfile_path + tmpfileName;
		//图片当前高度，缩放0.9得到新高度
		var ht=Math.round(parseInt($("#xuwanting").attr("height"))*rate);
		//图片当前宽度，缩放0.9，得到新宽度
		var wt=Math.round(parseInt($("#xuwanting").attr("width"))*rate);
		//重新设置新尺寸的图片
		document.getElementById('define_ava_div').innerHTML='<center><img style="" width="'+wt+'" height="'+ht+'" id="xuwanting"  src="'+fullImgPath+'" /></center>';
		//新图片加载后要重新初始化裁剪框
		initJcrop(selectX,selectY,selectW,selectH);
	} 

	//显示上传文件input
	function uploadfile(){
		$("#filespan").show();
	}
