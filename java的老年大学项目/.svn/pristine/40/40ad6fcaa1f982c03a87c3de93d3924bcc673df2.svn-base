<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息栏目分类管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">   
$(document).ready(function() {
    if($("#success").text()!="")$("#div-success").show();
    if($("#error").text()!="")$("#div-error").show();
})
function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
}
</script>
</head>

<body>
<!-- navbar start -->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper">
	<!-- sidebar start -->
	<jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="category" name="menu" />
	<jsp:param value="message" name="bigmenu" />
    </jsp:include>
	<!-- sidebar end -->
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
	<!--breadcrumb-->
		<ol class="dr-breadcrumb" style="">
		<li>
		<span class="glyphicon glyphicon-home"></span>
		<a href="#">平台首页</a>
		</li>
		<li>
		<a href="#">信息发布管理</a>
		</li>
		<li class="active"><span>信息栏目分类管理</span></li>
		</ol>
	<!--/breadcrumb-->
	
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>信息栏目分类管理<small>&nbsp;</small></h3>
        </div>
        <hr></hr>
    <!--页面标题end-->
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
    <s:if test="nowUser.tenantId==null">
     <ul class="nav nav-tabs nav-justified">
	     <li class="<s:if test='isMy'>active</s:if><s:else></s:else>" ><a href="category.action?isMy=true">大平台信息栏目分类</a></li>
         <li class="<s:if test='!isMy'>active</s:if><s:else></s:else>"><a href="category.action?isMy=false">租户信息栏目分类</a></li>
    </ul>
    </s:if>
    <div class="tab-content dr-tabs-panel">
    
 
<form class="form-inline dr-form-inline" id="mainForm" name="mainForm" action="category.action" method="post">
 <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
     <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
     <input type="hidden" name="page.order" id="order" value="${page.order}" /> 
     <input type="hidden" name="parentId" id="parentId" value="${parentId}" />
      
<input type="hidden" name="isMy" id="isMy" value="${isMy}" />
<s:if test="nowUser.tenantId==null">
<s:if test="!isMy">
  <div class="dr-searchbar">
	<div class="form-group">
  	<label>租户</label>
  	<s:select list="tenantLists" listKey="id" headerValue="--选择租户--" headerKey="" value="tenantId" listValue="name" theme="simple" 
	cssClass="form-control" name="tenantId"></s:select>
	</div>
	<div class="form-group">
		<button class="btn btn-default btn-sm" type="submit">
			<span class="glyphicon glyphicon-search"></span>
 			搜索
		</button>
	</div>
  </div>
  </s:if>
</s:if>

</form>
    
    <!--订单列表-->
	
	<form name="deleteForm" id="deleteForm" action="category.action" method="post">
	
	    <div class="panel panel-default">
    	<s:if test="parentId != null">
    		<div class="btn-toolbar dr-btn-toolbar">
    		<s:if test="isMy">
	    		<div class="btn-group">
				<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="window.location='category!input.action?parentId=${parentId}&isMy=${isMy}'">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
                </button>
				</div>
			</s:if>
				<div class="btn-group">
				<button  name="Submit3"  class="btn btn-primary btn-sm" type="button"   onclick="window.location='category!reback.action?parentId=${parentId}&isMy=${isMy}'">
				<span class="glyphicon glyphicon-backward"></span>&nbsp;返回上级栏目
				</button>
				</div>
				<div class="btn-group">
				<span style="line-height:28px">(${advanceName})</span>
				</div>
	    	</div>
    	</s:if>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
					<s:if test="parentId != '' && parentId != null && canAddFlag!=null">
						<td width="4%" class="tt_noline">
						<input type="checkbox" id="checkboxall" /></td>
					</s:if>
					<s:if test="parentId != '' && parentId != null">
						<th width="10%">栏目名称</th>
						<th width="15%">上级栏目名称</th>
					</s:if>
					<s:else>
						<th width="10%">栏目名称</th>
					</s:else>
					<th width="5%">分类ID</th>
					<th width="6%">栏目等级</th>
					<s:if test="nowUser.tenantId==null"><th width="15%">来自</th></s:if>
				
					<th width="30%">操作</th>
					
				</tr>
				</thead>
				<tbody>
				<s:iterator value="page.result" status="stat">
				<tr>
					<s:if test="parentId != '' && parentId != null && canAddFlag!=null">
					<td>
						<input type="checkbox" name="ids" value="${id}" />
					</td>
					</s:if>
					<s:if test="parentId != '' && parentId != null">
						<td title="${name}">
						<common:cut len="20" string="${name}" />&nbsp;
						</td>
						<td title="${parentName}" >
						<common:cut len="20" string="${parentName}" />&nbsp;
						</td>
					</s:if>
					<s:else>
						<td title="${name}">
						<common:cut len="20" string="${name}" />&nbsp;
						</td>
					</s:else>
					<td title="${id}">
					<common:cut len="20" string="${id}" />&nbsp;
					</td>
		            <td title="${level}">
		            <common:cut len="20" string="${level}" />&nbsp;
		            </td>
		            <s:if test="nowUser.tenantId==null"><td>${tenantName}</td></s:if>
		           
		            
					<td class="white_bg">
					 <s:if test="isMy">
					 <s:if test="level>1">
						<a class="btn btn-primary btn-sm" href="${ctx }/news/manage/category!moveUp.action?parentId=${parentId}&id=${id }&sortnum=${orderNum}&isMy=${isMy}">
		           			<span class="glyphicon glyphicon-arrow-up"></span>&nbsp;上移
		           		</a>	
						<a class="btn btn-default btn-sm"  href="${ctx }/news/manage/category!moveDown.action?parentId=${parentId}&id=${id }&sortnum=${orderNum}&isMy=${isMy}">
			                 <span class="glyphicon glyphicon-arrow-down"></span>&nbsp;下移
			            </a>	
						<a class="btn btn-primary btn-sm" href="${ctx }/news/manage/category!input.action?id=${id}&parentId=${parentId}&isMy=${isMy}"  type="button">
		                    <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑
		                </a>	
					  </s:if> 
					  <s:if test="parentId != '' && parentId != null">
						<a class="btn btn-default btn-sm"  type="button" href="#"
							onclick="delRecord('${ctx }/news/manage/category!delete.action?id=${id}&parentId=${parentId}&isMy=${isMy}');">
		                 <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
		               </a>
						
                       </s:if>
					</s:if>
					<s:if test="level<3">
					<%-- <a href="${ctx }/news/manage/category.action?parentId=${id}">进入下级栏目</a> --%>
						<a class="btn btn-primary btn-sm" href="${ctx }/news/manage/category.action?parentId=${id}&isMy=${isMy}" type="button" >
							<span class="glyphicon glyphicon-forward"></span>&nbsp;进入下级栏目
						</a>
					</s:if>
					</td>
					
				</tr>
			</s:iterator>
				</tbody>
			</table>
			<%@ include file="/common/turnpage.jsp"%>
			</div>
			</form>
		</div>
    <!--订单列表end-->
	</div>
	<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
   <!--footer over-->
	
	</section>
</div>
<!-- container end -->
<!--右侧弹出div 开始-->
<div class="expand">
			<a class="btn"><i class="fa fa-list-ul" style="margin-top: 14px;"></i>
			</a>
			<div class="popup-list">
				<div id="FlatTree" class="tree tree-plus-minus">
				</div>
			</div>
</div>
<!--右侧弹出div 结束-->



<script>
		jQuery(document).ready(function () {
			//TreeView.init();
			<s:iterator value="categories" status="stat">
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
		         url: "${ctx}/news/manage/category!folderOpen.action",
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
			window.location.href = "category!selectTree.action?id="+id;
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