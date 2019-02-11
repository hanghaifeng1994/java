<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
 
<head>
<title>英语竞赛学校区划管理<s:if test="currentTenant!=null">-${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp" %>
<link href="${staticurl}/wx_js/drfont/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<script type="text/javascript">
    $(document).ready(function(){
        if($("#success").text()!="")$("#div-success").show();
        if($("#error").text()!="")$("#div-error").show();   
		 
	   $("#checkboxall").click(function(){
	        if($("#checkboxall").attr("checked")=="checked"){
	        	$("input[name='ids']").attr("checked",$(this).attr("checked"));
            }else {
              $("input[name='ids']").removeAttr("checked");
             }
		});

		
	 //验证批量删除文章的列表非空与否
	   $("#batchDelDown").click(
			   function(){
				   var oaction = document.getElementById("deleteForm").action;
				   document.getElementById("deleteForm").action="${ctx }/areaschool/manage/areaschool!batchDeleteed.action?parentId=${parentId}";
				       if(!checkSelect()) {
			            b_alert("没有可操作记录,请勾选");
			            return false;
			       } 
			    	b_confirm('您确定要进行此操作吗?', function() {
							$("#deleteForm").submit();
							document.getElementById("deleteForm").action = oaction;
			    	});

				       
			       //if(!confirm('您确定要进行此操作吗?')) return  false;
	
				  // $("#deleteForm").submit();
				  // document.getElementById("deleteForm").action = oaction;
			 }); 		
    });  
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
<!--adminHeader开始-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--adminHeader结束-->
<div class="dr-wrapper">
  <!--adminLeft结束-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="cantonlist" name="menu" />
	<jsp:param value="basedata" name="bigmenu" />
    </jsp:include>
<!--adminLeft结束-->  
  <section id="main" role="main"> 
  <div class="dr-container-fluid">

    <ol class="dr-breadcrumb">
     <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="#">平台首页</a></li>
     <li><a href="#">基础数据管理</a></li>
     <li class="active">英语竞赛学校区划管理</li>
    </ol>
   <div class="dr-page-header">
     <h3>英语竞赛学校区划管理</h3>
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
<!-- 查询及分页条件，没有查询条件就只要带page隐藏域的mainForm -->
<%-- <form id="mainForm" name="mainForm" action="areaschool.action"
	method="post"><input type="hidden" name="page.pageNo"
	id="pageNo" value="${page.pageNo}" /> <input type="hidden"
	name="page.orderBy" id="orderBy" value="${page.orderBy}" /> <input
	type="hidden" name="page.order" id="order" value="${page.order}" />
	<input type="hidden" name="parentId" id="parentId" value="${parentId}" />
</form> --%>

<div class="dr-searchbar">
	   <form class="form-inline dr-form-inline"  id="mainForm" name="mainForm" action="areaschool.action" method="post">
	        <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" />
	        <input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" />
	        <input type="hidden" name="page.order"	id="order" value="${page.order}" />
	        <input type="hidden" name="parentId" id="parentId" value="${parentId}" />
            <div class="form-group">
                <label>行政区名称:&nbsp;&nbsp;</label>
                <input style="width: 158px" name="name" type="text" placeholder="" class="form-control input-sm" value="${param['name']}"/>
           </div>
            <div class="form-group">
               	<button class="btn btn-default btn-sm" onclick="$('#pageNo').val('1');document.mainForm.submit();">
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
                </button>
           </div>
        </form>
</div>


<form name="deleteForm" id="deleteForm" action="areaschool.action" method="post">
<div class="panel panel-default">
    <!--搜索模块end-->
    <div class="btn-toolbar dr-btn-toolbar">
      <button class="btn btn-default btn-sm" type="button" id="batchDelDown" name="Submit2">
        <span class="glyphicon glyphicon-trash"></span>
                    批量删除
      </button>
     
        <button class="btn btn-primary btn-sm" type="button" id="batchDelDown" name="Submit3" onclick="window.location='areaschool!input.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-plus"></span>
                    新增
        </button>
	    
	<s:if test="parentId != null">
	   <button class="btn btn-primary btn-sm" type="button" id="batchDelDown" name="Submit3" onclick="window.location.href='areaschool!reback.action?parentId=${parentId}'">
        <span class="glyphicon glyphicon-backward"></span>
                    返回上级区划
        </button>
	    (${advanceName})
	</s:if>
    </div>
<table  class="table table-bordered dr-table-bordered">
  <thead>
	<tr>
		<td width="3%" class="tt_noline"><input type="checkbox"
			id="checkboxall" /></td>
		<s:if test="parentId != '' && parentId != null">
			<th width="10%" >行政区名称</th>
			<th width="10%" >上级行政区名称</th>
		</s:if>
		<s:else>
			<th width="10%" >行政区名称</th>
		</s:else>
		<th width="10%" >行政区代码</th>
		<th width="20%" >操作</th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="page.result" status="stat">
		<tr>

			<td><input type="checkbox" name="ids"
				value="${id}" /></td>
			<s:if test="parentId != '' && parentId != null">
				<td title="${name}" ><common:cut len="20"
					string="${name}" />&nbsp;</td>
				<td title="${parentName}" ><common:cut
					len="20" string="${parentName}" />&nbsp;</td>
			</s:if>
			<s:else>
				<td title="${name}"><common:cut len="20"
					string="${name}" />&nbsp;</td>
			</s:else>
				<td title="${code}" ><common:cut len="20"
					string="${code}" />&nbsp;</td>
			<td>
			<a href="${ctx }/areaschool/manage/areaschool!input.action?id=${id}&parentId=${parentId}" class="btn btn-primary btn-sm" type="button">
			<span class="glyphicon glyphicon-edit"></span>
			编辑</a>
			
			<s:if test="parentId != '' && parentId != null">
				<button class="btn btn-default btn-sm" type="button" onclick="delRecord('${ctx }/areaschool/manage/areaschool!delete.action?id=${id}&parentId=${parentId}');">
               <span class="glyphicon glyphicon-trash"></span>
                                  删除
               </button>	
			</s:if> 
			<a href="${ctx }/areaschool/manage/areaschool.action?parentId=${id}" class="btn btn-primary btn-sm" type="button">
			<span class="glyphicon glyphicon-forward"></span>
			管理下级区划</a>			
			
			</td>
		</tr>
	</s:iterator>
	</tbody>
</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>

</div>  
<!--footer start-->
	    	<jsp:include page="/common/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
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
			<s:iterator value="cantonDTOs" status="stat">
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
		         url: "${ctx}/areaschool/manage/areaschool!folderOpen.action",
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
			window.location.href = "canton!selectTree.action?id="+id;
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