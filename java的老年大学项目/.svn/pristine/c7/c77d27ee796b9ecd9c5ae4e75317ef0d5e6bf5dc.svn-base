/**
 * 
 * 单个预览和打印
 * 参数说明如下:
 * @param actionUrl 请求打印或预览的Action路径
 * @param uploadUrl 模板图片保存的文件路径(不包括数据库保存的图片路径),如:http://192.168.0.122:8088/picserver/uplaod/certtemplate
 * @param isBackImage 打印时是否打印背景图 true表示是,否则表示否 
 * @param isPreview 是作预览操作还是作打印操作,true表示预览（不带工具栏等）,否则表示打印
 * @param isLayer 是否显示正在加载的图片 true表示显示,否则表示不显示 
 * @return
 */
 function singleViewPrint(id,actionUrl,uploadUrl,isPreview,isBackImage,isLayer){
	 //显示加载的图片
	 if(isLayer)
		 showLayer('dialog','dialog_content',"<span style='text-align:center'><img align='top' alt='正在上传...' src='../../image/loading.gif'/></span>");
	 
	 $.post(actionUrl,{"id":id},function(data) {
			var tempData = eval(data);//data.value;
  			if(tempData=="error"){
				if(isLayer) //关闭加载的图片
					closeLayer();
				
  		 		alert("系统异常,操作失败"); 
  			}else if(tempData=="null"){
				if(isLayer) //关闭加载的图片
					closeLayer();
				
  		 		alert("证书没有关联的模板,打印失败"); 
  			}else{
				var vo= eval(data.vo);
				if(vo==null || ""==vo){
					//if(isLayer) //关闭加载的图片
					//	closeLayer();
					
  					alert("没有符合查询条件的打印记录");
  					return;
   				}
				var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));//声明为全局变量 
	 
				LODOP.NewPage();
				var imageName=vo.imageUrl;
				
				//打印时是否打印背景图,如果为true,则打印时会打印背景图,如果为false,则则打印时不会打印背景图
				if(isBackImage){
   					LODOP.ADD_PRINT_IMAGE(vo.top,vo.left,vo.width,vo.height,"<img border='0' src='"+uploadUrl+imageName+"' />");
				}else{
					LODOP.ADD_PRINT_SETUP_BKIMG("<img border=\"0\" src=\""+uploadUrl+imageName+"\"></img>");	
				}
			
  				eval(vo.subject);  
				
				 //关闭加载的图片
				if(isLayer)
					closeLayer();
				
   				if(isPreview){
	   				LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);//打印预览时是否包含背景图
	   				//LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW",0);//隐藏打印按钮
	   				//LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW",1);//隐藏设置按钮
	   				//第一个参数:0--适高1--正常大小2--适宽。第二个参数:工具条和按钮，数字型 0--显示工具条1--显示按钮 2--两个都显示 3--两个都不显示
	   				//第三个参数:打印按钮是否“直接打印” 1-是 0-否（弹出界面“选机打印”）
	   				//第四个参数:窗口宽，整数型，单位是px。第五个参数:窗口高，整数型，单位是px
	   				//第六个参数:预览窗口和打印按钮的名称组合，字符型，用“点”分隔，譬如“预览查看.开始打印”，表示预览窗口的标题是“预览查看”，按钮名是“开始打印”
	   				LODOP.SET_PREVIEW_WINDOW(1,0,0,1000,720,"证书查看.开始打印");	
	   				LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD",1);
	   				LODOP.PREVIEW();
   				}else{
   					LODOP.PRINTA();
   				}
  			}
		});
} 
 
 /**
  * 
  * 批量打印或预览
  * @param actionUrl 请求打印或预览的Action路径
  * @param uploadUrl 模板图片保存的文件路径(不包括数据库保存的图片路径),如:http://192.168.0.122:8088/picserver/uplaod/certtemplate
  * @param isBackImage 打印时是否打印背景图 true表示是,否则表示否 
  * @param isPreview 是作预览操作还是作打印操作,true表示预览（不带工具栏等）,否则表示打印
  * @param isLayer 是否显示正在加载的图片 true表示显示,否则表示不显示 
  * @return
  */
 function batchViewPrint(idList,actionUrl,uploadUrl,isPreview,isBackImage,isLayer){
	 //显示加载的图片
	 if(isLayer)
		 showLayer('dialog','dialog_content',"<span style='text-align:center'><img align='top' alt='正在上传...' src='../../image/loading.gif'/></span>");
	 
	//模板相关
	var operateIds="";
 	$("input[name='"+idList+"']:checked").each(function(){
	 operateIds+=","+$(this).val();
	});
 	if(operateIds==null || ""==operateIds){
		if(isLayer) //关闭加载的图片
			closeLayer();
		alert("至少要选择一个证书信息");
		return;
	}
 	
 	//参数说明: flag: 是否保存打印记录,如果是打印时则保存
 	$.post(actionUrl,{"operateIds":operateIds,"flag":isPreview?false:true},function(data) {
 		var tempData = data.value;
		if(tempData=="error"){
			if(isLayer) //关闭加载的图片
				closeLayer();
	 		alert("系统异常,操作失败"); 
	 		return;
		}else{
			var vo= eval(data.vo);
			if(vo==null || ""==vo){
				if(isLayer) //关闭加载的图片
					closeLayer();
				alert("没有符合查询条件的打印记录");
				return;
			}
		} 
		
		var LODOP = getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
		LODOP.PRINT_INIT(isPreview?"证书批量预览":"证书批量打印");
				
		var length=vo.length; 
 
		for(var i = 0 ;i < length ; i++) {
			LODOP.NewPage();
   				
			var imageName=vo[i].imageUrl;
			
			//打印时是否打印背景图,如果为true,则打印时会打印背景图,如果为false,则则打印时不会打印背景图
			if(isBackImage){ 
				LODOP.ADD_PRINT_IMAGE(vo[i].top,vo[i].left,vo[i].width,vo[i].height,"<img border='0' src='"+uploadUrl+imageName+"' />");
			}else{
				LODOP.ADD_PRINT_SETUP_BKIMG("<img border=\"0\" src=\""+uploadUrl+imageName+"\"></img>");	
			}
			
   			eval(vo[i].subject); 
		}
		
		 //关闭加载的图片
		if(isLayer)
			closeLayer();
		
		if(isPreview){//预览
			LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);//打印预览时是否包含背景图
			//LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW",0);//隐藏打印按钮
			//LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW",1);//隐藏设置按钮
			//第一个参数:0--适高1--正常大小2--适宽。第二个参数:工具条和按钮，数字型 0--显示工具条1--显示按钮 2--两个都显示 3--两个都不显示
			//第三个参数:打印按钮是否“直接打印” 1-是 0-否（弹出界面“选机打印”）
			//第四个参数:窗口宽，整数型，单位是px。第五个参数:窗口高，整数型，单位是px
			//第六个参数:预览窗口和打印按钮的名称组合，字符型，用“点”分隔，譬如“预览查看.开始打印”，表示预览窗口的标题是“预览查看”，按钮名是“开始打印”
			LODOP.SET_PREVIEW_WINDOW(1,0,0,1000,720,"证书查看.开始打印");	
			LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD",1);
			LODOP.PREVIEW();
		}
		else//打印
			LODOP.PRINTA();
	});
}  