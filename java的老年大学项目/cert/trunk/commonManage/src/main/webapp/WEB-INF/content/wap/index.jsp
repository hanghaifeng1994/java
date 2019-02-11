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
var page=2;
$().ready(function(){
	$(".btn_more").click(function (){
		$.post("${ctx}/wap/news!more.action", { pageNo:page,keyword:'${keyword}'},
				function (data){
					$(".news_list").append(data);
					page++;
				});
	})
})
</script>
</head>
<body>
<div id="wrapper">


<div id="head">安徽专技 - 移动版</div>




<div id="content">


	<p class="news_top_block"><a  href="${ctx }/wap/news!category.action" class="btn_category">分类</a> 新闻中心</p>

	<ul class="news_list">
	<s:iterator value="page.result" status="stat">
    <li>
    	<p class="news_list_title"><a href="${ctx}/wap/news!detail.action?id=${id }">${title }</a></p>
		<p class="data_number"><s:date name="lastUpdateDate" format="yyyy.MM.dd"></s:date></p>
    </li>
    </s:iterator>
    
    </ul>
 <s:if test="page.hasNext">
	<div class="btn_more">点击显示更多</div>
</s:if>
</div>
<div id="footer">

</div>
</div>
</body>
</html>