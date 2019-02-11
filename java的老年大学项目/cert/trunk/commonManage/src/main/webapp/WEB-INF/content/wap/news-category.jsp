<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${ctx }/wapcss/mobile.css" rel="stylesheet" type="text/css">
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0;">
<title>安徽专技-移动版</title>
<script type="text/javascript">
$().ready(function(){
	$(".slide_list li").click(function (){
		$(".slide_list li").removeClass("current");
		$("p").hide();
		$(this).addClass("current");
		$('.css'+$(this).attr("rel")).show();
	});
});
</script>
</head>
<body>


<div class="slide_layer">

<ul class="slide_nav"><li class="current">分类</li><li><a href="${ctx }/wap/news!search.action">搜索</a></li></ul>

<ul class="slide_list">
<s:iterator value="categories" status="stat">
<li rel="${stat.index }" <s:if test='#stat.index==0'>class="current"</s:if>>${name }</li>
<s:iterator value="childs" status="stat1">
    <p class="css${stat.index }" <s:if test='#stat.index!=0'>style="display:none"</s:if>><a href="${ctx }/wap/news!list.action?categoryId=${id}"> ${name } </a></p>
    <s:iterator value="childs" status="stat2">
     <p class="css${stat.index }" <s:if test='#stat.index!=0'>style="display:none"</s:if>><a href="${ctx }/wap/news!list.action?categoryId=${id}"> &nbsp;&nbsp;&nbsp;&nbsp;${name }</a></p>
    </s:iterator>
</s:iterator>
</s:iterator>
</ul>







</div>
</body>
</html>