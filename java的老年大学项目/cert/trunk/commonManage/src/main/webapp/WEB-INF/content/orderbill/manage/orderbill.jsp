<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		if('${threadName}' != ''){
			checkover();
		}
		var uploadflag = $("#uploadflag").val();
        if(uploadflag == 'true'){
        	$("#div-success").show();
		  	$("#success").text("上传完成，请查看导入结果记录表。");
	    	$('#errorResult').show();
	    	$('#importnum').show();
	    	$("#uploadflag").val("false");
        }
        //信息提示  
		if($("#success").text()!="")$("#div-success").show();
		if($("#error").text()!="")$("#div-error").show();
		 $("#checkboxall").click(function(){
			   if($("#checkboxall").attr("checked")=="checked"){
			     	$("input[name='ids']").attr("checked",$(this).attr("checked"));
			   }else{
			   		$("input[name='ids']").removeAttr("checked");
			   } 
		   });
			//验证批量删除文章的列表非空与否
			   $("#batchDelDown").click(function(){
					   var oaction = document.getElementById("mainForm").action;
					  document.getElementById("mainForm").action="${ctx }/clazz/manage/clazz!batchDeletestudent.action";
				       if(!checkSelect()) {
				            b_alert("没有可操作记录,请勾选");
				            return false;
				       } 
				      b_confirm('您确定要进行此操作吗?', function() {
							$("#mainForm").submit();
							document.getElementById("mainForm").action = oaction;
			   	   		});
				 }); 
					    
		 });			     
					  
		//信息提示  end
		function deleteAll(){
			  var oaction = document.getElementById("mainForm").action;
			  document.getElementById("mainForm").action="${ctx }/clazz/manage/clazz!deleteAllstudent.action";
		      b_confirm('您确定要进行此操作吗?', function() {
					$("#mainForm").submit();
					document.getElementById("mainForm").action = oaction;
	   	   		});
		}
		 function checkSelect() {
				var flag = false;
				$("input[name='ids']:checked").each(function(){
					flag = true;
				}); 
				return flag;
			}
			 
	 function  checkupload(){
		 var upload = $("#upload").val();
         if(upload == "" || upload == null){
          b_alert("上传文件不能为空！");
          }else {
        	  $("#uploadForm").submit(); 
          }
    } 
	 function checkover(){
			$.ajax({
		        type: "POST",
		        url: "${ctx}/orderbill/manage/orderbill!isFinishSaveOrderBill.action",
		        data: {
		        	"threadName":'${threadName}',
				},
				dataType:"json",
		        success: function(data) {
					 if(data.value=="true"){
						 var num = data.label.split("_");
						 $("#uploadDiv").hide();
						 $("#uploadResult").show();
						 $('#importnum').show();
						 $('#sucessImport').text(num[0]);
						 $('#uSucessImport').text(num[1]);
						 setTimeout("checkover()",1000);
					 }else{
						 var num = data.label.split("_");
						 $("#uploadflag").val("true");
						 $("#sImportNum").val(num[0]);
						 $("#uImportNum").val(num[1]);
						 $("#mainForm").submit();   
				     } 
		        }
			});
		}
		
function cancel(){
	$("#confirm").css("display","none");
	$("#fade").css("display","none");
	
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
	<jsp:param value="orderbill" name="menu" />
	<jsp:param value="order" name="bigmenu" />
    </jsp:include>
<!--正文右边开始-->
<!--the end of left-->
<!--正文右边开始-->
<section id="main" role="main">

<div class="dr-container-fluid">
<ol class="dr-breadcrumb">
<li>
<span class="glyphicon glyphicon-home"></span>
<a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
</li>
<li class="active">
<a href="#">定单发票管理</a>
</li>
</ol>

<!--信息提示-->
<div class="alert alert-success alert-dismissable" id="div-success" style="display: none">
<button class="close" type="button" onclick="$('#div-success').hide()">×</button>
<span id="success"><s:actionmessage  theme="simple"/></span>
</div>
<div class="alert alert-danger alert-dismissable" id="div-error" style="display: none">
<button class="close" type="button" onclick="$('#div-error').hide()">×</button>
<span id="error"><s:actionerror theme="simple"/></span>
</div>
<!--信息提示 end-->
<form id="uploadForm" class="form-inline dr-form-inline mt10 ml5 mr5" action="orderbill!saveimport.action" method="post" enctype="multipart/form-data">
      <div class="dr-searchbar">
        <div class="form-group">
  		<label>下载数据文件包样本：
  		<a href="${ctx}/template/orderbill.xlsx"  target="_blank">导入样本.xls</a>
		</label>
		</div>
		<div class="form-group">
		<label >上传数据Excel文件</label>
		<input type="file" id="upload" name="upload" style="display: inline;" onclick="$('#errorResult').hide();$('#importnum').hide();$('#div-success').hide();"/>

		</div>
		<div class="form-group" id="uploadDiv">
		<button class="btn btn-primary btn-sm" type="button" id="Submit32" onclick="checkupload()">
		<span class="glyphicon glyphicon-open"></span>上传</button>
		</div>
		<div class="form-group ml30" id="uploadResult" style="display: none">
		<label>正在上传，请稍等、、、</label>
		</div>
		<div class="form-group ml30" id="errorResult" style="display: none">&nbsp;&nbsp;&nbsp;
		<label><a href="${fileName}" target="_blank">下载导入结果记录excel表格</a></label>
		</div>
		&nbsp;&nbsp;<span id="importnum" style="display: none"><span>成功导入数据：<label id="sucessImport">${sucessImportNum}</label></span>&nbsp;&nbsp;<span class="ml10">未成功导入数据：<label id="uSucessImport">${unSucessImportNum}</label></span></span>
	 </div>
</form>

<form id="mainForm" name="mainForm" action="orderbill.action" class="form-inline dr-form-inline" method="post">
<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}" /> 
<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}" /> 
<input type="hidden" name="page.order" id="order" value="${page.order}" />
<input type="hidden" id="fileName" name=fileName value="${fileName}"/>
<input type="hidden" id="uploadflag" name="uploadflag" value="${uploadflag}"/>
<input type="hidden" id="sImportNum" name="sucessImportNum" value="${sucessImportNum}"/>
<input type="hidden" id="uImportNum" name="unSucessImportNum" value="${unSucessImportNum}"/>
<div class="dr-searchbar mt10 mb10 ml5 mr5">
   <div class="form-group">
      <label>定单号</label>
      <input class="form-control input-sm" type="text" name="orderNo" id="orderNo" value="${orderNo}"  />
   </div>  
   <div class="form-group">
   <button class="btn btn-default btn-sm" type="submit" onclick="$('#pageNo').val(1);">
	<span class="glyphicon glyphicon-search"></span>
	搜索
	</button>
	</div>
</div>

<div class="panel panel-default">
<table class="table table-bordered dr-table-default">
	<tr>
	    <th>定单号</th>
		<th>发票代码</th>
		<th>发票号码</th>
		<!-- <th>开具日期</th>
		<th>发票类型</th>
		<th>购方名称</th>
		<th>合计金额(元)</th>		
		<th>合计税额(元)</th> -->
		<th>价税合计(元)</th>
		<!-- <th>开票人</th> -->
		<th>商品名称</th>
		<!-- <th>商品税率</th>
		<th>备注</th> -->
		<th>导入时间</th>
		<th>附件</th>
	</tr>
		<s:iterator value="page.result" status="stat">
		<tr>
			<td class="white_bg">${orderNo}</td>
			<td class="white_bg">${billCode}</td>
			<td class="white_bg">${billNo }</td>
			<%-- <td class="white_bg">${genTime }</td>
			<td class="white_bg">${billType }</td>			
			<td class="white_bg">${buyer }</td>	
			<td class="white_bg">${price }</td>	
			<td class="white_bg">${taxPrice }</td>	 --%>
			<td class="white_bg">${totalPrice }</td>	
			<%-- <td class="white_bg">${biller }</td>	 --%>
			<td class="white_bg">${productName }</td>	
			<%-- <td class="white_bg">${productTax }</td>
			<td class="white_bg">${demo }</td>	 --%>
			<td><s:date name="createTime" format="yyyy-MM-dd"/></td>
			<td>
				<s:if test="path!=''&&path!=null"><a href="${pathStr }" target="_blank">有</a></s:if>
				<s:else><font color="red">无<font/></s:else>
			</td>
		</tr>
		</s:iterator>

</table>
<%@ include file="/common/turnpage.jsp"%>
</div>
</form>
</div>
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</section>
</div>
</body>
</html>