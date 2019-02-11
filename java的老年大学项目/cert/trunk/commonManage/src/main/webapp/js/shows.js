/**
 * 上传图片ajax效果
 * @author qingang
 * @since 2011-03-07
 * @return
 */
function ajaxPicUpload(){
			
			$("#loading")
			.ajaxStart(function(){
				$(this).show();
			})//开始上传文件时显示一个图片
			.ajaxComplete(function(){
				$(this).hide();
			});//文件上传完成将图片隐藏起来
			
			$.ajaxFileUpload
			(
				{
					url:'showsupload.action',//用于文件上传的服务器端请求地址
					secureuri:false,//一般设置为false
					fileElementId:'picfile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
					dataType: 'json',//返回值类型 一般设置为json
					success: function (data, status)  //服务器成功响应处理函数
					{
						alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量
						if(data.message=='上传成功'){
							$("#picview").attr("src",$('#picurl').val()+"/"+data.picname);
							$("#pic").attr("value",data.picname);
							document.getElementById('picview').style.display="";
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
						alert(e);
					}
				}
			)
			
			return false;

}
/**
 * 上传附件
 * @param fileName		上传之后赋值的隐藏域
 * @param fileElement	文件元素 <input type="file" id="file" name="file" />
 * @param displayArea	上传成功后文件在页面显示的区域
 * @param loading		上传过程显示的图片
 * @param dellink		删除文件超链接
 * @param fileurl		文件存储全路径
 * @return
 */
function ajaxAttachUpload(fileName,fileElement,displayArea,loading,dellink,fileurl,attacharea){
	
	$("#"+loading)
	.ajaxStart(function(){
		$(this).show();
	})//开始上传文件时显示一个图片
	.ajaxComplete(function(){
		$(this).hide();
	});//文件上传完成将图片隐藏起来
	
	$.ajaxFileUpload
	(
		{
			url:'showsupload!attach.action',//用于文件上传的服务器端请求地址
			secureuri:false,//一般设置为false
			fileElementId:fileElement,//文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType: 'json',//返回值类型 一般设置为json
			success: function (data, status)  //服务器成功响应处理函数
			{
				alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量
				if(data.message=='上传成功'){
					$("#"+fileName).attr("value",data.attachname);
					document.getElementById(dellink).style.display="";
					fileurl = document.getElementById(fileurl).value;
					displaya = "<a id='"+attacharea+"' target='blank' href='"+fileurl+data.attachname+"'>"+data.attachname.substr(8)+"</a>";
					document.getElementById(displayArea).innerHTML = displaya;
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
				alert(e);
			}
		}
	)
	
	return false;

}
/**
 * 删除文件
 * @return
 */
function delFile(attachment,displayarea,dellink){

	$.post("showsupload!deleteFile.action",{"attachment":$("#"+attachment).val()
		 },function(data) {
				alert(data.message);
				if(data.message=="删除成功"){
					document.getElementById(attachment).value="";
					document.getElementById(displayarea).innerHTML="";
					document.getElementById(dellink).style.display="none";
				}
	});
}