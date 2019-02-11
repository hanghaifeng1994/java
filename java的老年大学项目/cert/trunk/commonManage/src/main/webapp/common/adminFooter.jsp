<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<%@ include file="/common/taglibs.jsp"%>
<!--footer start-->
<div class="dr-footer">
<!--   	无锡教育电视台版权所有© 2017-2018<br/>
  	苏ICP备09024546号 |联系邮箱：<a href="mailto:wxedu@126.com">wxedu@126.com</a><br/> -->
           本系统支持火狐、谷歌、IE内核10或以上浏览器以及360浏览器极速模式
</div>
<a data-offset="-50%" data-hideanim="bounceOut" data-showanim="bounceIn" data-marker="#main" data-toggle="waypoints totop" class="totop animation" href="#">
<span class="glyphicon glyphicon-chevron-up" style="margin-top:13px;"></span>
</a>
<script>
function addToFavorite(){  
switch(getOs()){  
   case 1:  
    window.external.addFavorite(location.href,document.title);  
   break;  
   case 2:  
    window.sidebar.addPanel(document.title, location.href, "");  
   break;  
   case 0:  
    b_alert("加入收藏失败，您使用的浏览器不支持这个功能");  
   break;  
}  
}  
  
function getOs() {   
   if(navigator.userAgent.indexOf("MSIE")>0)return 1;   
   if(navigator.userAgent.indexOf("Firefox")>0)return 2;   
   return 0;   
}   

function setHomepage(){// 设为首页
	if(getOs()==0){
		b_alert("设为首页失败，您使用的浏览器不支持这个功能"); return;
		}
	 if (document.all){
	  document.body.style.behavior = 'url(#default#homepage)';
	  document.body.setHomePage('<common:prop name="ahstudy.webapp.url" propfilename=""/>');
	 }else if (window.sidebar){
	  if (window.netscape){
	   try {
	    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
	   }catch (e) {
		   b_alert("该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");
	   }
	  }
	  var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
	  prefs.setCharPref('browser.startup.homepage', '<common:prop name="ahstudy.webapp.url" propfilename=""/>');
	 }
} 
</script>
<!-- Placed at the end of the document so the pages load faster -->
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/js/table.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/js/related.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/wx_js/js/core.min.js"></script>  
<script type='text/javascript' src="${staticurl}/wx_js/js/app.min.js"></script>
<script type='text/javascript' src="${staticurl}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-modalmanager.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-modal.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/bootstrap/js/bootstrap-mymodal.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/js/tree.min.js"></script>
<script type='text/javascript' src="${staticurl}/wx_js/js/tree-init.js"></script>