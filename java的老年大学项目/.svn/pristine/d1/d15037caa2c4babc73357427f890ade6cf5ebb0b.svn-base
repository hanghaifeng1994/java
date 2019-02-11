<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
<head>
<title>新增课程<%@ include file="/common/title.jsp" %></title>
    <%@ include file="/common/admin_meta.jsp"%>
    <script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
	<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
	<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>

 	<link href="${ctx}/js/datetime/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.js"type="text/javascript"></script>
	<script src="${ctx}/js/datetime/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	<link rel="stylesheet" href="${ctx}/jcrop_zh/css/jquery.Jcrop.css" type="text/css" />
    <script src="${ctx}/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/jcrop_zh/js/jquery.Jcrop.js"></script>
	<link href="${staticurl}/css/layer.css" type="text/css" rel="stylesheet"/>  
	<script src="${staticurl}/js/layer.js" type="text/javascript"></script>
    <script src="${ctx}/js/cutpic.js" type="text/javascript"></script>        
    
<script>
		$(document).ready(function() {
			 // tree初始化
            var o = {
                    showcheck: true,          
                    //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                    theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
    				isfolder:false,
    				iscascade: false, //是否选中节点后向下遍历
                    isbubble: false //是否选中节点后向上上溯
                    //onnodeclick:function(item){alert(item.text);}
            };
            o.data = ${catTreeData};
            $("#navigation").treeview(o);
		
		});
		function iFrameHeight() {
			var ifm= document.getElementById("main");
			
			var subWeb = document.frames ? document.frames["main"].document : ifm.contentDocument;  
			if(ifm != null && subWeb != null) {
			   ifm.height = subWeb.body.scrollHeight;
			}   
		}

		function saveCat(){
			var s=$("#navigation").getTSVs();
            if(s !=null){
				$("#checkCats").val(s.join(","));
            }
            window.parent.saveCat($("#checkCats").val()); 
            
			//$('#inputForm').submit();
		}
       
</script>
</head>
<body>

<!--正文开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<div class="dr-page-header">
     <h3>课程分类 </h3>
   </div>
<hr/>	
<div class="panel panel-default">
<form style="margin: 0px" class="form-horizontal dr-form-bordered" id="inputForm" name="inputForm" action="${ctx}/course/manage/course.action" method="post" enctype="multipart/form-data">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>
<input id="id" name="finishedneed" type="hidden" value="" size="30"/>

<div class="form-group" id="validate_checkCats">
    <div class="col-md-3">
		<div id="tree" style="width:250px;height:250px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
			<ul id="navigation">
			</ul>
			<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
		</div>
		<span class="help-block" id="error_checkCats"></span>
    </div>
  </div>  
</form>
</div>
</div>
</section>
</body>
</html>
