<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>课程分类管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();   
		 
	   $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
			     $("input[name='ids']").attr("checked",$(this).attr("checked"));
				   }
			   else{
			   $("input[name='ids']").removeAttr("checked");
				   } 
		});
	
	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/coursecategory!delete.action?parentId=${parentId}";
				       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
				   b_confirm('您确定要进行此操作吗?', function() {
						$("#deleteForm").submit();
						document.getElementById("deleteForm").action = oaction;
			       });

			 }); 
	 
	   $("#hide").click(
			   
			   function(){
				   
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/course/manage/coursecategory!hide.action?parentId=${parentId}";
			       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			       b_confirm('您确定要进行此操作吗?',function(){
			    	   $("#deleteForm").submit();
					   document.getElementById("deleteForm").action = oaction;
			       });
		}); 
	
		$("#show").click(
				   function(){
					   var oaction = document.getElementById("deleteForm").action;					   
					   document.getElementById("deleteForm").action="${ctx }/course/manage/coursecategory!show.action?parentId=${parentId}";
					   if(!checkSelect()) {
				            b_alert("没有可操作记录,请勾选");
				            return false;
				       } 
				       b_confirm('您确定要进行此操作吗?',function(){
				    	   $("#deleteForm").submit();
						   document.getElementById("deleteForm").action = oaction;
				       });
					    
		});
		 
    });
    function deleted(id){
 		var oaction = document.getElementById("deleteForm").action;
 		document.getElementById("deleteForm").action="${ctx }/course/manage/coursecategory!delete.action?ids="+id;
	       b_confirm('您确定要进行此操作吗?', function() {
				$("#deleteForm").submit();
				document.getElementById("deleteForm").action = oaction;
	   	});
 	}  
	 function checkSelect() {
			var isMy = false;
			$("input[name='ids']:checked").each(function(){
				isMy = true;
			}); 
			return isMy;
	}	 
	</script>
</head>
<body>
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->
<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="coursecategory" name="menu" />
	<jsp:param value="course" name="bigmenu" />
    </jsp:include>
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="traincore.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">课程资源库管理</a>
</li>
<li class="active">课程分类列表</li>
</ol>

<div class="dr-page-header">
<h3>
课程分类列表
</h3>
</div>
<hr/>
<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" data-dismiss="alert" aria-hidden="true">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<s:if test="nowUser.tenantId!=null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="coursecategory.action?isMy=true">我的课程分类</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="coursecategory.action?isMy=false">公共课程分类</a></li>
    </ul>
</s:if>
<s:elseif test="nowUser.tenantId==null">
<ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="coursecategory.action?isMy=true">我的课程分类</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="coursecategory.action?isMy=false">其他租户课程分类</a></li>
    </ul>
</s:elseif>
<div class="tab-content dr-tabs-panel">
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="coursecategory.action" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
</form>
<form name="deleteForm" id="deleteForm" action="coursecategory.action" method="post">
<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
<div class="panel panel-default">

<div class="btn-toolbar dr-btn-toolbar">
<s:if test="isMy && (parentId != '' && parentId != null || nowUser.tenantId==null|| nowUser.tenantId!=null)">
<div class="btn-group">
<button class="btn btn-default btn-sm" type="button" name="Submit2" id="batchDelDown">
<span class="glyphicon glyphicon-trash"></span>
 批量删除
</button>
</div>
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location='coursecategory!input.action?parentId=${parentId}&isMy=${isMy}'">
<span class="glyphicon glyphicon-plus"></span>
新增
</button>
</div>
<div class="btn-group">
	<button name="Submit2" class="btn btn-primary btn-sm"
				type="button" id="hide">
	<span class="glyphicon glyphicon-eye-open"></span>&nbsp;隐藏
	</button>
</div>
<div class="btn-group">
	<button name="Submit2" type="button"
			class="btn btn-default btn-sm" id="show">
		<span class="glyphicon glyphicon-eye-close"></span>&nbsp;显示
	</button>
</div>
</s:if>
<s:if test="parentId != '' && parentId != null">
<div class="btn-group">
<button class="btn btn-primary btn-sm" type="button" name="Submit3" onclick="window.location='coursecategory!reback.action?parentId=${parentId}&isMy=${isMy}'">
<span class="glyphicon glyphicon-backward"></span>
返回上级分类
</button>
</div>
<div class="btn-group mt4">
(${advanceName})
</div>
</s:if>
</div>
<table class="table table-bordered dr-table-default">
	<tr>
	<s:if test="isMy && nowUser.tenantId==null || nowUser.tenantId!=null">
		<th width="3%"><input type="checkbox"
			id="checkboxall" /></th>
	</s:if><s:elseif test="isMy && parentId != '' && parentId != null">
		<th width="3%"><input type="checkbox"
			id="checkboxall" /></th>
	</s:elseif>
		<s:if test="parentId != '' && parentId != null">
			<th width="10%">分类名称</th>
			<th width="10%">上级分类名称</th>
		</s:if>
		<s:else>
			<th width="12%">分类名称</th>
		</s:else>

		<th width="9%">分类编号</th>
		<th width="9%">显示状态</th>		 
		<th width="8%">分类等级</th>
		<s:if test="!isMy&&nowUser.tenantId==null"><th width="20%">来自</th></s:if>
		<s:if test="parentId != '' && parentId != null">
		<th width="35%">操作</th>
		</s:if>
		<s:else>
		<th width="38%">操作</th>
		</s:else>
	</tr>
	<s:iterator value="page.result" status="stat">
		<tr>
		<s:if test="isMy && nowUser.tenantId==null || nowUser.tenantId!=null">
			<td class="white_bg">
			<input type="checkbox" name="ids" value="${id}" /></td>
		</s:if><s:elseif test="isMy && parentId != '' && parentId != null">
			<td class="white_bg">
			<input type="checkbox" name="ids" value="${id}" /></td>
		</s:elseif>
			<s:if test="advanceName != '' && advanceName != null">
				<td title="${name}" class="white_bg"><common:cut len="30"
					string="${name}" />&nbsp;</td>
				<td title="${parentName}" class="white_bg"><common:cut
					len="20" string="${parentName}" />&nbsp;</td>
			</s:if>
			<s:else>
				<td title="${name}" class="white_bg"><common:cut len="20"
					string="${name}" />&nbsp;</td>
			</s:else>
			<td title="${code}" class="white_bg"><common:cut len="20"
				string="${code}" />&nbsp;</td>
			<s:if test="hide">
			<td title="${hide}" class="white_bg"><font color="red"><common:cut len="20"
				string="隐藏 " /></font>&nbsp;</td>
			</s:if><s:else>
			<td title="${hide}" class="white_bg"><common:cut len="20"
				string="显示" />&nbsp;</td>
			</s:else>						
			<td title="${level}" class="white_bg"><common:cut len="20"
				string="${level}" />&nbsp;</td>
			<s:if test="!isMy&&nowUser.tenantId==null"><td title="${tenant.name}"><common:cut len="20"
				string="${tenant.name}" /></td></s:if>
			<td class="white_bg">
			<s:if test="isMy && (parentId != '' && parentId != null || nowUser.tenantId==null|| nowUser.tenantId!=null)">			 			 		 
			<a class="btn btn-primary btn-sm" href="${ctx }/course/manage/coursecategory!moveUp.action?parentId=${parentId}&id=${id }&sortnum=${orderNum}&tenantId=${tenantId}&isMy=${isMy}">
		       <span class="glyphicon glyphicon-arrow-up"></span>&nbsp;上移
		    </a>	
			<a class="btn btn-default btn-sm"  href="${ctx }/course/manage/coursecategory!moveDown.action?parentId=${parentId}&id=${id }&sortnum=${orderNum}&tenantId=${tenantId}&isMy=${isMy}">
			   <span class="glyphicon glyphicon-arrow-down"></span>&nbsp;下移
		    </a>
			<button class="btn btn-primary btn-sm" type="button" onclick="window.location='${ctx }/course/manage/coursecategory!input.action?id=${id}&parentId=${parentId}&isMy=${isMy}'">
             <span class="glyphicon glyphicon-edit"></span>
                                    编辑
            </button>
			 <button class="btn btn-default btn-sm" type="button"  onclick="deleted('${id}')">
                  <span class="glyphicon glyphicon-trash"></span>
                                                删除
                </button>
			</s:if> 
			<button class="btn btn-primary btn-sm" type="button" onclick="window.location='${ctx }/course/manage/coursecategory.action?parentId=${id}&isMy=${isMy}'">
			<span class="glyphicon glyphicon-forward"></span>&nbsp;进入下级分类</button>
			</td>
		</tr>
	</s:iterator>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
<!--正文结束-->
<!--右侧弹出div-->
<div class="expand">
			<a class="btn"><i class="fa fa-list-ul" style="margin-top: 14px;"></i>
			</a>
			<div class="popup-list">
				<div id="FlatTree" class="tree tree-plus-minus">
				</div>
			</div>
</div>

<script>
		jQuery(document).ready(function () {
			//TreeView.init();
			<s:iterator value="courseCategories" status="stat">
			var htm = "";
			htm = htm +'<div class="tree-folder"><div class="tree-folder-header">';
			 if(${childsCount}>0)
			 htm = htm +'<i class="fa fa-folder" id="folder_${id}" onclick="folderOpen(${id})"></i>';
			 htm = htm +'<div class="tree-folder-name" onclick="selectTree(${id})">${name}</div>';
			 htm = htm +'</div><div class="tree-folder-content" id="childs_${id}"></div>';
			 htm = htm +'</div>';
			$("#FlatTree").append(htm);
			folderOpen(${id})
			</s:iterator>
		});

		function folderOpen(parentId){
			//alert($("#childs_"+parentId).html()==null)
			var folderClass = $('#folder_'+parentId).attr("class");
			if(folderClass=='fa fa-folder' && $("#childs_"+parentId).html()==''){
			$('#folder_'+parentId).attr("class","fa fa-folder-open");
			$.ajax({
		         type: "POST",
		         url: "${ctx}/course/manage/coursecategory!folderOpen.action",
		         data: {
		       	 	"parentId":parentId
				 },
		         success: function(data) {
			         for(var i=0;i<data.length;i++){
					 var html = "";
					 html = html +'<div class="tree-folder"><div class="tree-folder-header">';
					 if(data[i].childsCount>0)
					 html = html +'<i class="fa fa-folder" id="folder_'+data[i].id+'" onclick="folderOpen('+data[i].id+')"></i>';
					 html = html +'<div class="tree-folder-name" onclick="selectTree('+data[i].id+')">'+data[i].name+'</div>';
					 html = html +'</div><div class="tree-folder-content" id="childs_'+data[i].id+'"></div>';
					 html = html +'</div>';
					 $("#childs_"+parentId).append(html);
					 if(data[i].childsCount>0)folderOpen(data[i].id);
				     }
		         },
		         beforeSend: function() {
		         }
		    });
			}else if(folderClass=='fa fa-folder'){
				 $('#folder_'+parentId).attr("class","fa fa-folder-open");
				 $("#childs_"+parentId).show();
				 }else{
					 $('#folder_'+parentId).attr("class","fa fa-folder");
					 $("#childs_"+parentId).hide();
					 }
		}

		function selectTree(id){
			window.location.href = "coursecategory!selectTree.action?id="+id;
		}
		$(".expand").mouseover(function () {
			$(this).stop();
			$(this).animate({
				right: 0
			}, 400);
		})
		 $(".expand").mouseout(function () {
			$(this).stop();
			$(this).animate({
				right: -400
			}, 400);
		})
</script>
</body>
</html>