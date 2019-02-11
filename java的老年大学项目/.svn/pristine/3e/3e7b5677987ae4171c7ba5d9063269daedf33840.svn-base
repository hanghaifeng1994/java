function checkIE(){
	var agent = navigator.userAgent.toLowerCase();
	var isNeedUpgrade=false;
	var browserVersion="非IE系列";
	if(agent.indexOf("msie 6.0")!=-1){
		browserVersion="IE6.0";
		isNeedUpgrade=true;
	}else if(agent.indexOf("msie 7.0")!=-1){
		browserVersion="IE7.0";
		//isNeedUpgrade=true;
	}else if(agent.indexOf("msie 8.0")!=-1){
		browserVersion="IE8.0";
	}else if(agent.indexOf("msie 9.0")!=-1){
		browserVersion="IE9.0";
	}else if(agent.indexOf("msie 10.0")!=-1){
		browserVersion="IE10.0";
	}else{
		isNeedUpgrade=true;
	}
	if(isNeedUpgrade){
		var content="<div align=\"center\" style=\"width:390px;height:170px;overflow: hidden;\"><br />"
			+"您当前的浏览器版本是：<font color=\"red\">"+browserVersion+"</font><br /><br />"
			+"为便于您的正常访问学习，请升级或更换您的浏览器版本到不低于IE8 的版本后，再进行页面访问，谢谢！<br /><br />"
			+"<a style=\"color: #666666;text-decoration: none;\" href=\"http://www.zjzx.ah.cn/epcourse/direct!demo.action\">进入测试页</a><br /><br />"
			+"官方下载：<a style=\"color: red;text-decoration: none;\" href=\"http://download.microsoft.com/download/1/6/1/16174D37-73C1-4F76-A305-902E9D32BAC9/IE8-WindowsXP-x86-CHS.exe\">IE8</a>"
			+"&nbsp;&nbsp;&nbsp;&nbsp;<a style=\"color: #999999;text-decoration: none;\" href=\"http://www.microsoft.com/zh-cn/download/default.aspx\">更多</a>"
			+"</div>";
		$.fn.colorbox({html:content});
	}
	
}
setTimeout("checkIE()",5000);