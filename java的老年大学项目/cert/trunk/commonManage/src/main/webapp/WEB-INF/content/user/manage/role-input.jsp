<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<html>
  <head>
    <%@ include file="/common/admin_meta.jsp" %>
    <link href="${staticurl}/js/omytreeview/jquery.tree.css" rel="stylesheet" type="text/css" />
	<script src="${staticurl}/js/omytreeview/js/common.js" type="text/javascript" ></script>
	<script src="${staticurl}/js/omytreeview/js/jquery.tree.js" type="text/javascript" ></script>
	<script>
		$(document).ready(function() { 
			 var o = {
                showcheck: true,          
                //url: "http://jscs.cloudapp.net/ControlsSample/GetChildData" 
                theme: "bbit-tree-lines", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
				isfolder:false,
				iscascade: true, //是否选中节点后向下遍历
                isbubble: false //是否选中节点后向上上溯
                //onnodeclick:function(item){alert(item.text);}
        	};
        	o.data = ${catTreeData};
        	$("#navigation").treeview(o);
        
			//聚焦第一个输入框
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name: {
						required: true,
						maxlength:10
					},
					aids:{
						required: true  
						}	
				},
				messages: {
					name:{
						required:"请输入名称",
						maxlength:"字数小于10位"
					},
					aids:{
						required:"请选择角色"
						}
			
				},
				errorPlacement: function(error, element) {   
			        if (document.getElementById("error_"+element.attr("name")))  {
			            error.appendTo("#error_"+element.attr("name"));  
			        }
			        else       
			            error.insertAfter(element);   
			    }				
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

<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
   <!--adminLeft结束-->
    <jsp:include page="/common/adminLeft.jsp">
	<jsp:param value="rolelist" name="menu" />
	<jsp:param value="manager" name="bigmenu" />
    </jsp:include>
   <!--adminLeft结束-->  
 
  <section id="main" role="main">
  <div class="dr-container-fluid">
    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">角色管理</a></li>
     <li class="active">
       <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>角色
     </li>
    </ol>
    
   <div class="dr-page-header">
     <h3> 
      <s:if test="id == null">新增</s:if>
       <s:else>编辑</s:else>角色
     </h3>
   </div>
   <hr/>

<div class="panel panel-default">
<form id="inputForm" name="inputForm" action="role!save.action" method="post" class="form-horizontal dr-form-bordered" onsubmit="submitHandler();">
<input id="id" name="id" type="hidden" value="${id}" size="30"/>

    <div class="dr-form-title clearfix">
	  <div class="col-md-12">
	    <h4 class="text-primary">      
	       <s:if test="id == null">新增</s:if>
           <s:else>编辑</s:else>角色</h4>
	  </div>
	</div>
   <div class="form-group" id="validate_name">
    <label class="col-md-3 control-label">名称<span class="admin_red">*</span></label>
    <div class="col-md-3">
       <input id="name" name="name" value="${name}" type="text" class="form-control" />
    </div>
    <span id="error_name" class="help-block"></span>
  </div>

   <div class="form-group" id="validate_aids">
    <label class="col-md-3 control-label">管理员权限<span class="admin_red">*</span></label>
    <div class="col-md-3">
    	<div id="tree" style="width:440px;height:500px;overflow:auto;border-style:solid;border-width:1px; border-color:#CCC">
			<ul id="navigation">
			</ul>
			<input type="hidden" id="checkCats" name="checkCats" value="${checkCats}"/>
		</div>
      <%-- <s:iterator value="checkedVOList">

		<s:if test="isChecked">
		  <input type="checkbox" name="aids" value="${id}" checked="checked"/>${name}
		</s:if>
		<s:else>
		  <input type="checkbox" name="aids" value="${id}"/>${name}
		</s:else>
		</s:iterator> --%>
    </div>
    <span id="error_aids" class="help-block"></span>
  </div>
  
     <div class="panel-footer">
   <div class="row">
    <div class="col-md-offset-3 col-md-10">
	 <button class="btn btn-primary"  name="Submit32" type="submit">
       <span class="glyphicon glyphicon-ok"></span>&nbsp;保存
     </button>
     <button class="btn btn-default" onclick="window.location.href='role.action'" type="button">
       <span class="glyphicon glyphicon-remove"></span>&nbsp;取消
     </button>
     </div>
      </div>
     </div>
</form>
</div>
</div>
    <jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	</jsp:include>
</section>
</div>
</body>
</html>