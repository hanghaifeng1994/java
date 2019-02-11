<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>


<script src="${staticurl}/js/related.js" type="text/javascript"></script>

<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
</head>
<body>
<form id="inputform" action="clazz!saveimport.action" method="post"
	enctype="multipart/form-data"><input type="hidden"
	name="clazzid" value="${clazzid}" />
<div class="tcbox">
<div class="toptt"><strong class="fl ml10">导入学员名单</strong><!-- <a	href="#" class="fr"></a>--></div>
<div class="downmore"><span class="ttname">数据文件样本下载</span> <span>下载数据文件包样本：<a
	href="${ctx}/template/calzzstudent.xlsx" class="bule" target="_blank">导入样本.rar </a></span>
<h4>XLS文件编辑规则：</h4>
<p>1.使用MicroSoft Office Excel编辑数据并生成XSL后缀的文件。<br />
2. xsl文件的表格中每一行单元格只能填写一个用户的数据，单元格字段顺序为：<font class="colorred">身份证*、姓名*、单位*、性别*</font><br />
3. 带星号标记 * 并且标为红色的字段为必填字段，请务必填写。 <br />
4.导入用户的初始密码则系统默认为与身份证号码最后6位</p>
<h4>个人照片文件编辑规则：</h4>

<p>1.个人照片需符合2寸报名照要求，即3.5*5.3cm （以3000dpi计算，则对应像素尺寸为413px*626px） <br />
2.个人照片的文件命名必须是身份证号，并且格式为jpg。</p>
<h4>文件包规则：</h4>
<p>1.将xls文件直接上传 <br />
2.将所有照片打包生成ZIP压缩格式并上传<br />
3.照片压缩包内不能有目录</p>
	
	<span class="ttname">上传数据Excel文件和照片zip包</span>
	<span>数据Excel文件*：
	<input type="file" id="upload" name="upload" class="wjy" />
	</span>
	<span>照片zip包*：
	<input type="file" id="upload" name="uploadPicZip" class="wjy" />
	<input name="Submit32" type="submit" class="operation_btu2" value="上传" />
	</span>
	<div style="height:55px">
	 <span
	id="error_upload" class="admin_woring_x"></span> <span
	id="error_uploadPic" class="admin_woring_x"></span>
</div>
</div>
<input type="hidden" name="from" value="colorbox"/>
</form>

<p>&nbsp;</p>
</body>
</html>
