<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<!--<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
-->
<%@ include file="/common/admin_meta.jsp"%>
<!-- mytreeview js-->
	<link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
    <script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>

<script>  
	$(document).ready(function() {
		// tree初始化
        var o = {
                showcheck: true,          
                //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
				isfolder:false,
				iscascade: false, //是否选中节点后向下遍历
                isbubble: true //是否选中节点后向上上溯
                //onnodeclick:function(item){alert(item.text);}
        };
        o.data = ${catTreeData};
        $("#navigation").treeview(o);
		$("#allDown").click(
			function(){
				   var oaction = document.getElementById("form1").action;
				   document.getElementById("form1").action="${ctx }/train/manage/programs!programDown.action?isAll=all";
				   $("#form1").submit();
				   document.getElementById("form1").action = oaction; 
			}); 
			
 	});
    function submitHandler() {
   
        var s=$("#navigation").getTSVs();
        if(s !=null){
			$("#checkCats").val(s.join(","));
        }
	}
</script>

</head>

<body>
<!--正文开始-->
<div class="dr-wrapper">
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">

<div class="panel panel-default">
<form class="form-horizontal dr-form-bordered" id="inputForm" action="clazz!savesign.action" method="post" name="inputForm" onsubmit="submitHandler();">
<input type="hidden" name="id" value="${id}" id="id"  />
<input type="hidden" name="programId" value="${programId }" id="hiddenprogramsid" />
		<div id="tree" style="width:440px;height:500px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
			<ul id="navigation">
			</ul>
			<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
		</div>
		<span class="help-block" id="error_checkCats"></span>
  
<div class="panel-footer">
<div class="row">
<div class="col-md-offset-2 col-md-10">
    <div class="btn-group">
		<button name="Submit32" class="btn btn-primary btn-sm" type="submit">
        <span class="glyphicon glyphicon-ok"></span>
        	确定
        </button>
    </div>
    <div class="btn-group">
		<button name="Submit32" class="btn btn-default btn-sm" type="button" onclick="window.location.href='clazz.action?programId=${programId}'">
        <span class="glyphicon glyphicon-remove"></span>
                                取消
        </button>
    </div>
</div>
</div>
</div>
</form>
</div>
</div>
</section>
</div>
<!--正文结束-->
</body>
</html>
