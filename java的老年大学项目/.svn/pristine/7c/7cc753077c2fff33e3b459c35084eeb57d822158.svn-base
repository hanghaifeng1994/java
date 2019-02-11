<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
	request.setAttribute("certapiurl", PropertyUtils.getPropertyWithConfigName("sysconfig.properties", "cert.api.url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>   
	<%@ include file="/common/meta.jsp" %> 
	<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Access-Control-Allow-Origin" content="*" />
    <meta name="keywords" content="keywords">
    <meta name="description" content="description">
    <title>证书验证-中小学教师教育网</title>
    <script src="${ctx }/cert/js/jquery.min.js"></script>
    <script src="${ctx }/cert/js/jquery.combo.select.min.js"></script>
    <script type="text/javascript">
       $(function(){
       		loadCert();
       });
        function loadCert(){
        	
        	$.ajax({
				type : "post", //请求方式
				url : "${certapiurl}/cert/usercertoffline/info",
				dataType : "jsonp", //跨域json请求一定是jsonp
				data:{id:'${id}'},
				jsonp : "callback", //跨域请求的参数名，默认是callback
				jsonpCallback : "successCallback", //自定义跨域参数值，回调函数名也是一样，默认为jQuery自动生成的字符串
				success : function(data) {
					console.log(data);
					//$("#certImage").attr("src",data.imgUrl);
					$("#name").html(data.name);
					$("#unit").html(data.unit);
					$("#certno").html(data.certno);
					$("#downloadCert").html("<button type=\"button\" style=\"background-color: #5cb85c;cursor: pointer;color: #fff;border: 1px solid transparent;border-radius: 4px;width:80px;\" href=\"#\" onclick=\"downLoadPicture("+data.id+")\">下载</button>");
				},
				error : function() {
					//请求出错处理
				}
			});
        }
        
        function downLoadPicture(id) {
			//文件导出中不在响应
			var form = $("<form id=\"downLoadPicture\" target=\"_blank\">");
			form.attr("style", "display:none");
			form.attr("target", "");
			form.attr("method", "post");
			form.attr("action", "${certapiurl}/cert/usercertoffline/downloadUserCertOffline");
			var usercertId = $("<input />");
			usercertId.attr("type", "hidden");
			usercertId.attr("name", "id");
			usercertId.attr("value", id);
			form.append(usercertId);
			$("body").append(form);
			form.submit();
			$("#downLoadPicture").remove();
			//timer =  window.setInterval("isFinsh()",1000);
		}
       
    </script>
    <style>
    	table tr{
    		height:30px;
    	}
    </style>
</head>
<body>   
<div style="margin:50px 20px;text-align:center;">
           	 <table style="width:100%;max-width: 500px;border: 2px solid #d6e9c6; border-radius: 4px;" align="center" cellspacing="5" bgcolor="#fff"
				class="admin_tab10">
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">培训专题：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;">2018年合肥市高中教师新课程改革专题培训</td>
				</tr>
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">培训单位：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;">安徽广播电视大学</td>
				</tr>	
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">年度：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;">2018年度</td>
				</tr>	
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">学员：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;" id="name">--</td>
				</tr>	
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">学员单位：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;" id="unit">--</td>
				</tr>	
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">证书编号：</td>
					<td width="60%" class="buleleft" style="text-align:left;color:blue;" id="certno">--</td>
				</tr>	
				<tr>
					<td width="40%" class="buleleft" style="text-align:right;">下载地址：</td>
					<td width="60%" class="buleleft" style="text-align:left;" id="downloadCert">--</td>
				</tr>
				
			</table>
</div>

</body>
</html>
