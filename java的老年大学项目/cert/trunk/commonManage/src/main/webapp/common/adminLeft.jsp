<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="cn.common.lib.util.web.PropertyUtils"%>
<%
	request.setAttribute("menu", request.getParameter("menu"));
	request.setAttribute("bigmenu", request.getParameter("bigmenu"));
	request.setAttribute("dyrUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","dyr.manage.url"));
%>

<link href="${staticurl}/wx_js/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="${staticurl}/wx_js/drfont/icomoon/icomoon.css" rel="stylesheet" type="text/css" />
<s:set name="curUser" value="@com.drcl.traincore.util.UserUtils@getCurUser()"></s:set>
<style>
<!--
滚动条样式 老钱让加个滚动条，简单加个滚动条样式和定位bylen
-->#divContent {
	overflow: auto;
}

#divContent::-webkit-scrollbar {
	width: 10px;
	height: 10px;
}

#divContent::-webkit-scrollbar-button {
	background-color: #51A12A;
}

#divContent::-webkit-scrollbar-track {
	background: #51A12A;
}

#divContent::-webkit-scrollbar-track-piece {
	background: #51A12A;
}

#divContent::-webkit-scrollbar-thumb {
	background: #A0D05D;
	border-radius: 4px;
}

#divContent::-webkit-scrollbar-corner {
	background: #A0D05D;
}

#divContent::-webkit-scrollbar-resizer {
	background: #51A12A;
}
</style>
<script type="text/javascript">
	function selectmenu(curaObj, url) {
		$(curaObj).parent().parent().children().attr("class", "")
		$(curaObj).attr("class", "active");
		if (url.indexOf("?") > -1) {
			url = url + "&rnd=" + Math.random();
		} else
			url = url + "?rnd=" + Math.random();
		$(curaObj).attr("href", url);
	}

	function changecss(id, id2) {
		//显示选中菜单
		var e = $("#" + id)
		var f = $("#" + id2)
		console.log(e);
		console.log(f);
		var flag = f.css("display");
		if (flag == 'none') {
			//  遍历所有菜单，初始化为不可见
			$("ul[class='submenu in']").each(function() {
				$(this).css("height", "0");
				$(this).attr("class", "submenu collapse");
			});
			$("li[class='active open']").each(function() {
				$(this).attr("class", "");
			});
			e.addClass("active");
		} else {
			e.removeClass("active");
		}
	}

	function KeepScrollBar() {
		var scrollPos;
		scrollPos = document.getElementById('divContent').scrollTop;
		document.cookie = "scrollTop=" + scrollPos;
	}
	window.onload = function() {
		$(".topmenu a").click(function() {
			KeepScrollBar()
		})
		if (document.cookie.match(/scrollTop=([^;]+)(;|$)/) != null) {
			var arr = document.cookie.match(/scrollTop=([^;]+)(;|$)/);
			document.getElementById('divContent').scrollTop = parseInt(arr[1]);
		}
	}
</script>
<style>
</style>
<aside class="sidebar sidebar-left sidebar-menu" id="divContent"
	style="overflow-y:scroll;overflow-x:hidden;">
	<div class="dr-user-menu">
		<img class="avatar" src="${ctx}/wx_css/images/user.png" alt="">
		<div class="user-info">
			<div class="welcome">欢迎您！</div>
			<div class="username">${curUser.name}</div>   
		</div>
	</div>
	<section class="content slimscroll">

		<ul class="topmenu" data-toggle="menu">

			<li id="menuHead10" class="<s:if test="#request.bigmenu=='programs'">active open</s:if>" onclick="changecss('menuHead10','components10')"><a class="menu2" id="menuHead" data-parent=".topmenu" data-toggle="submenu" data-target="#components10" href="javascript:void(0);">
	                            <span class="figure glyphicon glyphicon-leaf"></span>
	                            <span class="text">用户证书管理</span>
	                            <span class="arrow"></span>
	            </a>
			<!-- START 2nd Level Menu -->
		       <ul id="components10" class="submenu <s:if test="#request.bigmenu=='programs'">in</s:if><s:else>collapse</s:else>">
					<li class="<s:if test="#request.menu=='certtemplatelist'">active</s:if>"><a href="javascript:void(0)"  
					onclick="selectmenu(this,'${ctx}/cert/manage/certtemplate.action')"><span class="text">证书模板列表</span></a></li>		
					<li class="<s:if test="#request.menu=='certofflinelist'">active</s:if>"><a href="javascript:void(0)" 
						onclick="selectmenu(this,'${ctx}/cert/manage/certoffline.action')"><span class="text">证书列表</span></a></li>
					<li class="<s:if test="#request.menu=='usercertoffline'">active</s:if>"><a href="javascript:void(0)" 
						onclick="selectmenu(this,'${ctx}/cert/manage/usercertoffline.action')"><span class="text">用户证书查询</span></a></li>
				</ul>
			</li>
		</ul>

	</section>
</aside>