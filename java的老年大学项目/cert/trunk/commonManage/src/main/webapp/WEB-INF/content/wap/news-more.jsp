<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
	<s:iterator value="page.result" status="stat">
  <li>
    	<p class="news_list_title"><a href="/ahstudy-webapp/wap/news!detail.action?id=${id }&categoryId=${categoryId}&keyword=${keyword}">${title }</a></p>
		<p class="data_number"><s:date name="lastUpdateDate" format="yyyy.MM.dd"></s:date></p>
    </li>
</s:iterator>
  <s:if test="!page.hasNext">
  <script>
  $(".btn_more").hide();
  </script>
  </s:if>
  