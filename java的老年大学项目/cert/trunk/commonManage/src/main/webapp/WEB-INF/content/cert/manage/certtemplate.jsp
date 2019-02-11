<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.drcl.traincore.contants.Constants"%><html xmlns="http://www.w3.org/1999/xhtml">
<head >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="certtemplate" name="activemenu" />
	<title >证书模板管理</title>
	<%@ include file="/common/admin_meta.jsp"%>
	
    <script  type="text/javascript"  src="${ctx}/js/LodopFuncs.js">${ctx}</script>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="${ctx}/js/install_lodop32.exe"></embed>
	</object>
	
    <script type="text/javascript">
	$(document).ready(function(){  
		$("#checkboxall").click(function(){
			  if($("#checkboxall").attr("checked")=="checked"){
				     $("input[name='idList']").attr("checked",$(this).attr("checked"));
					   }
				   else{
				   $("input[name='idList']").removeAttr("checked");
					   } 
		}); 
		init();
	}); 
	function init(){
		params.name=$("#name").val();
		params.status=$("#status").val();
		api.loadpage('${certapiurl}/cert/certtemplate/manage/list','listTemplate','list', init);
	} 
	
	var LODOP; //声明为全局变量 
	
	//批量启用
	function onUse(){
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return ;
	       }
	       b_confirm('您确定要进行此操作吗?', function() {
	       $("#deleteForm").attr("action","certtemplate!batchUse.action");
		   $("#deleteForm").submit();
   	   }); 
	       //if(!confirm('您确定要进行此操作吗?')) return ;
	}

	//批量取消启用
	function cancleUse(){
	       if(!checkSelect()) {
	            b_alert("没有可操作记录,请勾选");
	            return ;
	       } 
	       b_confirm('您确定要进行此操作吗?', function() {
	       $("#deleteForm").attr("action","certtemplate!cancleUse.action");
		   $("#deleteForm").submit();
	   	   }); 
	}
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		}

	function batchUse(id){
		$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certtemplate/manage/batchUse",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"ids":id
			    },    //请求参数
			    success: function(data) {
			    	location.href="${ctx}/cert/manage/certtemplate.action";
			    },
			    error: function() {
			        //请求出错处理
			    }
			});
	}
	
	function cancleUse(id){
		$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certtemplate/manage/cancleUse",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"ids":id
			    },    //请求参数
			    success: function(data) {
			    	location.href="${ctx}/cert/manage/certtemplate.action";
			    },
			    error: function() {
			        //请求出错处理
			    }
			});
	}
	// 单个预览
	function singleViewPrint(id){
		$.ajax({
			    type:"post",    //请求方式
			    url:"${certapiurl}/cert/certtemplate/manage/singleViewPrint",
			    dataType:"jsonp",    //跨域json请求一定是jsonp
			    jsonp: "callback",    //跨域请求的参数名，默认是callback
			    jsonpCallback:"successCallback",    //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
			    data:{
			    	"id":id
			    },    //请求参数
			    success: function(data) {
			    	var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));//声明为全局变量 
					LODOP.NewPage();
					LODOP.PRINT_INITA(0,120,800,1000,"模板查看");
					var uploadUrl='<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}" /><%=Constants.CETTEMPLATE_PATH%>';
	   				LODOP.ADD_PRINT_IMAGE("0%","0%","100%","100%","<img border='0' src='"+uploadUrl+data.imageUrl+"' />");
	   				eval(data.subject);  
	   				LODOP.SET_PRINT_PAGESIZE(2,0,0,"");
	   				LODOP.SET_PREVIEW_WINDOW(1,3,0,0,0,"模板查看.开始打印");	
	   				LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);//横向时的正向显示
	
	   				//LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);//打印预览时是否包含背景图
	   				//LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW",1);//隐藏打印按钮
	   				//LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW",1);//隐藏设置按钮
	   				//LODOP.SET_PREVIEW_WINDOW(3,3,0,"100%","100%","模板查看.开始打印");	
	   				LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD",1);
	   				LODOP.PREVIEW();
			    },
			    error: function() {
			        //请求出错处理
			    }
			});
	} 
</script>		
</head>
<body > 
<!--header start-->
    <jsp:include page="/common${currentTenant.contents}/adminHeader.jsp">
	<jsp:param value="" name="menu" />
    </jsp:include>
<!--header over-->

<!--正文开始-->

<div class="dr-wrapper">
<!--正文左边开始-->
    <jsp:include page="/common${currentTenant.contents}/adminLeft.jsp">
	<jsp:param value="certtemplatelist" name="menu" />
	<jsp:param value="programs" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<section id="main" role="main">
<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li>
<a href="#">培训项目管理</a>
</li>
<li class="active">证书模板列表</li>
</ol>

<div class="dr-page-header">
<h3>证书模板管理</h3>
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
<div class="tab-content dr-tabs-panel">
	    <form role="form" class="form-inline dr-form-inline" id="mainForm" action="certtemplate.action" method="post">
		<div class="dr-searchbar" >
        <div class="form-group">
            <label>证书模板名称 </label>
             <input type="text" size="20" name="name" id="name" value="" class="form-control input-sm"/>
        </div>
        
        <div class="form-group">
            <label>是否启用</label>
            <s:select list="#{'true':'已启用','false':'未启用'}" listKey="key"  cssClass="form-control input-sm"
            listValue="value" name="status" id="status" cssStyle="width:150px;"  
              headerKey="" headerValue="--全部--"/>  
        </div>
        <div class="form-group">
        <button type="button" onclick="init();" class="btn btn-default btn-sm">           
                <span class="glyphicon glyphicon-search"></span>&nbsp;搜索
          </button>
         </div>
		</div>
		 </form>
    <!--sou end-->
	    <form name="deleteForm" id="deleteForm" action="certtemplate!delete.action" method="post">
	    <div class="panel panel-default">
	    <div class="btn-toolbar dr-btn-toolbar">
				<div class="btn-group">
				<button name="Submit3" class="btn btn-primary btn-sm" type="button" onclick="editRecord('certtemplate!input.action')">
                                        <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
                                    </button>
				</div>
			</div>
			<table class="table table-bordered dr-table-bordered">
				<thead>
				<tr>
				    <th style="width:150px;">证书模板名称</th>
				    <th style="width:100px;">是否启用</th>
				    <th width="160" style="padding-left:120px;">操作</th>
				</tr>
				</thead>
				<tbody id="list">
				</tbody>
			</table>
			<div class="M-box dr-panel-footer"></div>
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
	    
	    <script type="text/x-handlebars-template" id="listTemplate">
			{{#if result}}	
			{{#each result}}
			<tr>
		    <td>&nbsp;{{name}}</td>
		    <td>&nbsp;{{statusStr}}</td>
			<td class="white_bg">
				<a class="btn btn-default btn-sm" type="button" href="certtemplate!input.action?id={{id}}">
                   <span class="glyphicon glyphicon-pencil"></span> 重新设计
                </a>
		        <a class="btn btn-primary btn-sm" type="button"  href="#" onclick="singleViewPrint('{{id}}');">
                   <span class="glyphicon glyphicon-eye-open"></span> 模板查看
                </a>
                 {{#if status}}
					<a class="btn btn-default btn-sm" type="button"  onclick="cancleUse({{id}})">
                    <span class="glyphicon glyphicon-remove-circle"></span> 取消启用
                   </a>
                 {{else}}
					<a class="btn btn-primary btn-sm" type="button"  onclick="batchUse({{id}})">
                    <span class="glyphicon glyphicon-check"></span> 启用
                   </a>
				 {{/if}}
		       	</td>
		       	</tr>
			{{/each}}
			{{/if}}
			</script>
</body>
</html>
