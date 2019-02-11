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

<div id="wrapper">


<div id="head">安徽专技 - 移动版</div>




<div id="content">
	<div class="btn_back">
	<s:if test="categoryId!=null">
	<a href="${ctx }/wap/news!list.action?categoryId=${categoryId}"  class="button_back"> </a>
	</s:if>
	<s:else>
	<s:if test="keyword!=null&&keyword!=''">
	<a href="${ctx }/wap/news!search.action?keyword=${keyword}"  class="button_back"> </a>
	</s:if>
	<s:else>
	<a href="${ctx }/wap/index.action"  class="button_back"> </a>
	</s:else>
	
	</s:else>
	新闻中心 > ${article.firstCatname }</div>
    
    
	<div class="content_block">
    
    <p class="news_title">${article.title }</p>
    <p class="data_number ta_c"><s:date name="article.lastUpdateDate" format="yyyy.MM.dd"/> | 来源：${article.fromSource }</p>
    <p class="grey_line"></p>
    <p>
${article.content }
</p>
    
    </div>




	<ul class="news_list">
    <li>
    <s:if test="preArticle!=null">
    	<p >上一篇</p>
    	<p><a href="${ctx }/wap/news!detail.action?id=${preArticle.id}">${preArticle.title }</a></p>
    	</s:if>
    	<s:if test="nextArticle!=null">
		<p >下一篇</p>
    	<p><a href="${ctx }/wap/news!detail.action?id=${nextArticle.id}">${nextArticle.title }</a></p>
    	</s:if>
    </li>
    </ul>

	<p class="btn_top"> &nbsp;<a href="#" class="rr">返回顶部</a></p>


</div>


<div id="footer">


</div>



</div>

</body>
</html>