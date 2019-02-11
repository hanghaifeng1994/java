<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${ctx }/wapcss/mobile.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0;">
<title>安徽专技-移动版</title>
</head>
<body>


<div class="slide_layer">
<form action="${ctx }/wap/news!search.action" method="post" name="searchform">
<ul class="slide_nav"><li ><a href="${ctx }/wap/news!category.action">分类</a></li><li class="current">搜索</li></ul>

<p class="mb10 mt10">新闻搜索</p>
<p><input type="text"  style="width:99%" name="keyword"></p>
<p class="clearb mt20" ></p>
<p class="submit_block"><a class="submit_btn" onclick="searchform.submit()">搜索</a><a href="${ctx }/wap/news!category.action" class="cancel_btn">取消</a></p>
</ul>
</form>


</div>
</body>
</html>