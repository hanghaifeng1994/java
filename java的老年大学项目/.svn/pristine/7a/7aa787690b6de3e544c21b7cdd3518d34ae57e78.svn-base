<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
request.setAttribute("usermenu",request.getParameter("usermenu"));
request.setAttribute("bigmenu",request.getParameter("bigmenu"));
%> 
<div class="left_menu">
<p class="tit">我的学习空间</p>
<ul class="list">
<li><a href="#" class="menu1 <s:if test="#request.bigmenu=='item'">cur</s:if>">我的课表</a>
<ul>
<li><a href="portal!programscourse.action" <s:if test="#request.usermenu=='learningx'">class="selected"</s:if>>项目课程</a></li>
<li><a href="portal!learning.action" <s:if test="#request.usermenu=='learning'">class="selected"</s:if>>超市课程</a></li>
<li><a href="portal!report.action" <s:if test="#request.usermenu=='pxxstj'">class="selected"</s:if>>培训学时统计</a></li>
</ul>
</li>

<!--<li><a href="portal!homework.action" class="menu1 <s:if test="#request.bigmenu=='homework'">cur</s:if>">我的作业</a></li>
<li><a href="portal!exam.action" class="menu1  <s:if test="#request.bigmenu=='exam'">cur</s:if>">我的测试</a></li>-->
<li><a href="portal!clazz.action" class="menu1 <s:if test="#request.bigmenu=='clazz'">cur</s:if>">我的培训班级</a></li>
<li><a href="portal!cert.action" class="menu1 <s:if test="#request.bigmenu=='cert'">cur</s:if>">我的培训证书</a></li>

<li><a href="#" class="menu1 <s:if test="#request.bigmenu=='order'">cur</s:if>">我的订单</a>
<ul>
<li><a href="portal!waitorder.action" <s:if test="#request.usermenu=='waitorder'">class="selected"</s:if>>待付款订单</a></li>
<li><a href="portal!finishedorder.action" <s:if test="#request.usermenu=='finishedorder'">class="selected"</s:if>>已付款订单</a></li>
<li><a href="portal!failedorder.action" <s:if test="#request.usermenu=='failedorder'">class="selected"</s:if>>失效订单</a></li>
<li><a href="portal!rollbackorder.action" <s:if test="#request.usermenu=='rollbackorder'">class="selected"</s:if>>已退订单</a></li>
</ul>
</li>

<li><a href="#" class="menu1 <s:if test="#request.bigmenu=='grxx'">cur</s:if>">个人信息</a>
<ul>
<li><a href="portal!changeinfo.action" <s:if test="#request.usermenu=='changeinfo'">class="selected"</s:if>>修改个人信息</a></li>
<li><a href="portal!changephoto.action" <s:if test="#request.usermenu=='changephoto'">class="selected"</s:if>>更改报名照</a></li>
<li><a href="portal!changepwd.action" <s:if test="#request.usermenu=='changepwd'">class="selected"</s:if>>修改密码</a></li>
</ul>
</li>
<li><a href="#" class="menu1 <s:if test="#request.bigmenu=='message'">cur</s:if>">消息与好友 </a>
<ul>
<li><a href="portal!friend.action" <s:if test="#request.usermenu=='friend'">class="selected"</s:if>>好友</a></li>
<li><a href="portal!contact.action" <s:if test="#request.usermenu=='contact'">class="selected"</s:if>>最近联系人</a></li>
<li><a href="portal!message.action" <s:if test="#request.usermenu=='message'">class="selected"</s:if>>系统消息</a></li>
</ul>
</li>

</ul>
</div>