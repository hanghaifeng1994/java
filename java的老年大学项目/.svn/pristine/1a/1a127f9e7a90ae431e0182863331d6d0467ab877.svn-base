<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("ahstudyUrl", PropertyUtils
			.getPropertyWithConfigName("sysconfig.properties",
					"ahstudy.webapp.url"));
request.setAttribute("innerahstudyUrl",PropertyUtils.getPropertyWithConfigName("sysconfig.properties","ahstudy.webapp.url.inner"));
%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>auto</title>
<link href="${ctx}/style.css" rel="stylesheet" type="text/css" />
<!--
  jQuery library
-->
<%@ include file="/common/meta.jsp"%>
<link href="${staticurl}/css/master.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/ad.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.cycle.js"></script>
<script type="text/javascript" src="${ctx}/js/floatingAd.js"></script>
<script type="text/javascript" src="${ctx}/jcarousel_zh/lib/jquery.jcarousel.pack.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/jcarousel_zh/lib/jquery.jcarousel.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/jcarousel_zh/skins/tango/skin.css"/>
<style type="text/css">

/**
 * Overwrite for having a carousel with dynamic width.
 */
.jcarousel-skin-tango .jcarousel-container-horizontal {
    width:657px;
    padding: 0px 40px;
    height: 108px;
}

.jcarousel-skin-tango .jcarousel-clip-horizontal {
    width:655px;
    height: 107px;
   
}

.leftm{ float:left; width:75px; margin-left:5px;height: 98px}
.leftm span{ text-align:center; margin-top:2px; display:block;}
.leftm img{ border:1px solid #88DFFC; padding:1px; width:68px; height:70px   }
.rightm{ float:right; width:120px; padding-left:8px;height: 65px;line-height:15px}
.rightm .up{font-size:14px; padding-bottom:11px; clear:both;display:block;height: 22px}
.rightm .down{ color:#333; display:block;height: 50px}

.teacher{width:215px; padding-left:3px; height:95px; margin-top:5px; float:left;display:inline-block}
</style>
<script type="text/javascript">
var mycarousel_itemList = [
                           <s:iterator value="teacherRecommendList" status="status">
                           <s:if test="#status.last">
                           {
                               mtId:'${mainTeacher.id}', mpic:'${mainTeacher.pic}',mname:'${mainTeacher.name}',mscs:'<common:cut len="26"	string="${mainTeacher.simpleCourseStr}"></common:cut>',md:'<common:cut len="55"	string="${mainTeacher.description}"></common:cut>'
                           }
                           </s:if><s:else>
                           {
                               mtId:'${mainTeacher.id}', mpic:'${mainTeacher.pic}',mname:'${mainTeacher.name}',mscs:'<common:cut len="26"	string="${mainTeacher.simpleCourseStr}"></common:cut>',md:'<common:cut len="55"	string="${mainTeacher.description}"></common:cut>'
                           },
                           </s:else>
                           
                           </s:iterator> 
                           ];

function mycarousel_itemVisibleInCallback(carousel, item, i, state, evt)
{
   // The index() method calculates the index from a
   // given index who is out of the actual item range.
   var idx = carousel.index(i, mycarousel_itemList.length);
   carousel.add(i, mycarousel_getItemHTML(mycarousel_itemList[idx - 1]));
};

function mycarousel_itemVisibleOutCallback(carousel, item, i, state, evt)
{
   carousel.remove(i);
};

/**
* Item html creation helper.
*/
function mycarousel_getItemHTML(item)
{		
   var html = '<div class="teacher">';
   html = html+'<div class="leftm">';
   html = html+'<a href="${ctx}/repos/course.action?mtId='+item.mtId+'"><img  src="<common:prop name="traincore.uploadpath.url" propfilename=""/>/'+item.mpic+'"/></a><br/>';
   html = html+'<span><a href="${ctx}/repos/course.action?mtId='+item.mtId+'">'+item.mname+'</a></span>';
   html = html+'</div>';
   html = html+'<div class="rightm">';
   html = html+'<span class="up">主讲 <a	href="${ctx}/repos/course.action?mtId='+item.mtId+'" class="bule">'+item.mscs+'</a></span>';
   html = html+'<span class="down">';
   html = html+''+item.md+'</span>';
   html = html+'</div>';
   html = html+'</div>';
   return html
};
function mycarousel_initCallback(carousel)
{
    // Disable autoscrolling if the user clicks the prev or next button.
    carousel.buttonNext.bind('click', function() {
        carousel.startAuto(0);
    });

    carousel.buttonPrev.bind('click', function() {
        carousel.startAuto(0);
    });
    carousel.buttonNext.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
    carousel.buttonPrev.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
    // Pause autoscrolling if the user moves with the cursor over the clip.
    carousel.clip.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
};
</script>
</head>
<body>

<div class="teachabout" >	
		<ul id="recommend" class="jcarousel-skin-tango" style="margin-top: 1px">
		</ul>
</div>

<script>
 function recommend(){
	 $('#recommend').jcarousel({
		        auto: 3,
		        visible	: 3,
		        wrap: 'circular',
		        itemVisibleInCallback: {onBeforeAnimation: mycarousel_itemVisibleInCallback},
		        itemVisibleOutCallback: {onAfterAnimation: mycarousel_itemVisibleOutCallback},
		        initCallback: mycarousel_initCallback
	 });
 }

 $(document).ready(function() {
	 setTimeout(recommend,1000);  
 })
//$(document).ready(function() {
   // $('#recommend').jcarousel({
   //     auto: 3,
   //     visible	: 3,
   //     wrap: 'circular',
   //     itemVisibleInCallback: {onBeforeAnimation: mycarousel_itemVisibleInCallback},
   //     itemVisibleOutCallback: {onAfterAnimation: mycarousel_itemVisibleOutCallback},
   //     initCallback: mycarousel_initCallback
   // });
//});
</script>
</body>
</html>

