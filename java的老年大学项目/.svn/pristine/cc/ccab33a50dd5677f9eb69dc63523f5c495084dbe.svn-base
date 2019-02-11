<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
request.setAttribute("isqlxx",PropertyUtils.getPropertyWithConfigName("systemSwitch.properties","qlxx.open"));
%> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务管理-<s:if test="currentTenant!=null">${currentTenant.logo}</s:if><s:else><%@ include file="/common/title.jsp" %></s:else></title>
<%@ include file="/common/admin_meta.jsp"%>
<script type="text/javascript" language="javascript">   
$(document).ready(function(){   

	 if($("#success").text()!="")$("#div-success").show();
     if($("#error").text()!="")$("#div-error").show();   
      
	 $("#checkboxall").click(function(){
		   if($("#checkboxall").attr("checked")=="checked"){
		     	$("input[name='ids']").attr("checked",$(this).attr("checked"));
		   }else{
		   		$("input[name='ids']").removeAttr("checked");
		   } 
	   });
	 function checkSelect() {
			var flag = false;
			$("input[name='ids']:checked").each(function(){
				flag = true;
			}); 
			return flag;
		}
	//验证批量删除文章的列表非空与否
	 $("#savebutton").click(function(){
		
					var mainqualifiedlearnhour = $("#mainqualifiedlearnhour").val();
		            var mainqualifiedscore = $("#mainqualifiedscore").val();
		            var mainischeck = $("#mainischeck").val();
		            var maingoodscore = $("#maingoodscore").val();
		            var banklearnhour = $("#banklearnhour").val();
		            var bankscore = $("#bankscore").val();
		            var programId = $("#programId").val();
	 			    var tabLen = document.getElementById("tab");
	 			    var  typeb1 = $('input[name="scoreRadio1"]:checked ').val();
	 			   	var  typeb2 = $('input[name="scoreRadio2"]:checked ').val();
	 			   	//alert(typeb1);
	 			    //alert(typeb2);
		 			if(typeb1==typeb2){
						//alert(typeb1)
						typeb = 0;
		 			}
		 			if(typeb1==undefined&&typeb2==1){
		 				typeb = 1;
			 		}
			 		if(typeb1==0&&typeb2==undefined){
			 			typeb = 0;
					 }
					if(typeb1==0&&typeb2==1){
						typeb = 2;
					}
	 			   //alert(typeb);
				 	
	                 //拼接表格数据
	 			    var jsonT = "";
	 			    for(var i = 1; i < tabLen.rows.length-3;i++){
	 			        if(tabLen.rows[i].cells[0].getElementsByTagName("INPUT")[0].checked == true){
		 			       	jsonT +=",{\"ischeck\":\""+tabLen.rows[i].cells[0].getElementsByTagName("INPUT")[0].value+"\",\"checkcode\":\""+tabLen.rows[i].cells[7].getElementsByTagName("INPUT")[0].value+"\",\"maxcalculate\":\""+tabLen.rows[i].cells[2].getElementsByTagName("INPUT")[0].value+"\",\"maxscore\":\""+tabLen.rows[i].cells[3].getElementsByTagName("INPUT")[0].value+"\",\"unitnum\":\""+tabLen.rows[i].cells[5].getElementsByTagName("INPUT")[0].value+"\",\"courses\":\""+tabLen.rows[i].cells[6].getElementsByTagName("INPUT")[0].value+"\"}"
			 			 }
	 			    }
	 			    if(jsonT!=""||jsonT!=null){
	 			    	jsonT = jsonT.substring(1);
	 			    	jsonT = "["+jsonT+"]";
	 			    }	 			   
	 			   $.ajax({
	 	                cache: false,
	 	                type: "POST",
	 	                url : "${ctx }/train/manage/programscheck!save.action",
	 	                 
	 	                data:{"typeb":typeb,"mainqualifiedlearnhour":mainqualifiedlearnhour,"jsonT":jsonT,"mainqualifiedscore":mainqualifiedscore,"mainischeck":"true","maingoodscore":maingoodscore,"programId":programId,"banklearnhour":banklearnhour,"bankscore":bankscore},// 你的formid
	 	                async: false,
	 	                error: function(request) {
	 	                    b_alert("保存失败");
	 	                },
	 	                success: function(data) {
	 	                	b_alert("保存成功");
	 	                }
	 	            });

	 		   }); 	
});  
		


</script>

</head>

<body>
<!-- navbar start -->

<!-- navbar end --> 

<!-- container start -->
<div class="dr-wrapper" style="margin-top: 0px;">
	
	<section id="main" role="main">
	<div class="dr-container-fluid"> 
		<ol class="dr-breadcrumb" style="">
	       <li>
	        <span class="glyphicon glyphicon-home"></span>
	        <a href="<common:prop name="ahstudy.webapp.url" propfilename=""/>">平台首页</a>
	       </li>
	       <li>
	        <a href="#">
	                    <s:if test="#request.isqlxx=='true'">
                			学习课程列表
                		</s:if>
                		<s:else>
                			         培训项目管理
                		</s:else>
	        </a>
	       </li>
	       <li class="active"><span>
	       <s:if test="#request.isqlxx=='true'">
                			课程学习评价
                		</s:if>
                		<s:else>
                			        培训项目考评标准
                		</s:else>
	       </span></li>
	    </ol>
	<!--/breadcrumb-->
	<!--页面标题-->
        <div class="dr-page-header">
            <h3>
              <s:if test="#request.isqlxx=='true'">
                			课程学习评价 
                		</s:if>
                		<s:else>
                			        培训项目考评标准
                		</s:else>
            <small>&nbsp;</small></h3>
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


    <!--订单列表-->
    	<form name="deleteForm" id="deleteForm" action="programs.action" method="post" class="form-inline dr-form-inline">
    	<input value="${programId}" id="programId" style="display: none;" name="programId" type="text"/>
    	  <div class="panel panel-default">
					<div class="panel-body row">
						<div class="col-md-10">
    	  
			<table class="table table-bordered dr-table-bordered" id="tab">
				<thead>
				<tr>
					<th width="5%" class="tt_noline">设置</th>
					<th width="10%">考评内容</th>
					<th width="18%">最大计算值</th>
					<th width="10%">封顶分值</th>
					<th width="10%">计算方式</th>
					<th width="20%">单次分值</th>
					<th width="50%">涉及课程代码串（多个之间用逗号分割）</th>
				</tr>
				</thead>
				<tbody>
					 <tr>
                       <td class="white_bg"><input type="checkbox" <s:if test="kcxxcheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck"  /></td>
					   <td >课程学习</td>
					   <td ><input class="form-control input-sm" value="${kcxxcheckDetailDTO.maxcalculate}" style="width: 60px;"/>分钟</td>
					   <td ><input class="form-control input-sm" value="${kcxxcheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					   <td >按学时百分比</td>
					   <td >每学习一分钟取得<input class="form-control input-sm" value="${kcxxcheckDetailDTO.unitnum}"  name="unitnum" style="width: 60px;"/>学分</td>
					   <td ><input class="form-control input-sm" value="${kcxxcheckDetailDTO.courses}"  name="courses" style="width: 200px;" />(设置则必填)</td>
					   <td style="display: none;"><input value="kcxx"  name="checkcode"/></td>
					</tr>
                       
			     	<tr>
                       <td class="white_bg"><input type="checkbox" <s:if test="khzycheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck"  /></td>
					   <td >课后作业</td>
					   <td ><input class="form-control input-sm" value="${khzycheckDetailDTO.maxcalculate}" style="width: 60px;"/>篇</td>
					   <td ><input class="form-control input-sm" value="${khzycheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					   <td >按成绩百分比</td>
					   <td >每篇记<input class="form-control input-sm" value="${khzycheckDetailDTO.unitnum}" name="unitnum" style="width: 60px;"/>分</td>
					   <td ><input class="form-control input-sm" value="${khzycheckDetailDTO.courses}"  name="courses" style="width: 200px;"/>(设置则必填)</td>					   
					   <td style="display: none;"><input value="khzy"  name="checkcode"/></td>
					</tr>
					<tr>
                       <td class="white_bg"><input type="checkbox" <s:if test="kccycheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck"  /></td>
					   <td >课程测验</td>
					   <td ><input class="form-control input-sm" value="${kccycheckDetailDTO.maxcalculate}" style="width: 60px;"/>次测验</td>
					   <td ><input class="form-control input-sm" value="${kccycheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					   <td >按成绩百分比</td>
					   <td >每测记<input class="form-control input-sm" value="${kccycheckDetailDTO.unitnum}" name="unitnum" style="width: 60px;"/>分</td>
					   <td ><input class="form-control input-sm" value="${kccycheckDetailDTO.courses}"  name="courses" style="width: 200px;"/>(设置则必填)</td>					   
					   <td style="display: none;"><input value="kccy"  name="checkcode"/></td>
					</tr>
					<s:if test="#request.isahstudyopen=='true'||#request.isHbddOpen=='true'">
		
					</s:if>
					<s:else>
						<tr>
			    	    <td class="white_bg"><input type="checkbox" <s:if test="glgjjhcheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck" value="${ischeck}" /></td>
					    <td>研修报告</td>
					    <td><input class="form-control input-sm" value="${glgjjhcheckDetailDTO.maxcalculate}" style="width: 60px;"/>篇研修报告</td>
					    <td><input class="form-control input-sm" value="${glgjjhcheckDetailDTO.maxscore}" name="maxscore" style="width: 60px;"/>分</td>
					
					    <td>按篇</td>
					    <td>每提交一篇记<input class="form-control input-sm" value="${glgjjhcheckDetailDTO.unitnum}" name="unitnum" style="width: 60px;"/>分</td>
					    <td ><input class="form-control input-sm" value="${glgjjhcheckDetailDTO.courses}"  name="courses" style="width: 200px;"/>(设置则必填)</td>
					    <td style="display: none;"><input value="xxglgjjh"  name="checkcode"/></td>
					</tr>
			     	 <tr>
                        <td class="white_bg"><input type="checkbox" <s:if test="ltytcheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck" value="${ischeck}" /></td>
					    <td >论坛研讨</td>
					    <td ><input class="form-control input-sm" value="${ltytcheckDetailDTO.maxcalculate}" style="width: 60px;"/>个研讨贴</td>
					    <td ><input class="form-control input-sm" value="${ltytcheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					    <td >按贴</td>
					    <td >每发一帖记<input class="form-control input-sm" value="${ltytcheckDetailDTO.unitnum}" name="unitnum" style="width: 60px;"/>分</td>
					    <td ><input class="form-control input-sm" value="${ltytcheckDetailDTO.courses}"   name="courses" style="display: none;"/></td>
					    <td style="display: none;"><input value="ltyt"  name="checkcode"/></td>
					</tr>

			     	 <tr>
			     	    <td class="white_bg"><input type="checkbox" <s:if test="ydjbcheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck" /></td>
					    <td >阅读简报</td>
					    <td ><input class="form-control input-sm" value="${ydjbcheckDetailDTO.maxcalculate}" style="width: 60px;"/>期简报</td>
					    <td ><input class="form-control input-sm" value="${ydjbcheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					    <td >按篇</td>
					    <td >每阅读一篇记<input class="form-control input-sm" value="${ydjbcheckDetailDTO.unitnum}"  name="unitnum" style="width: 60px;"/>分</td>
					    <td ><input class="form-control input-sm" value="${ydjbcheckDetailDTO.courses}"  name="courses" style="display: none;;"/></td>
					    <td style="display: none;"><input value="ydjb"  name="checkcode"/></td>
					</tr>

			     	 <tr>
			    	    <td class="white_bg"><input type="checkbox" <s:if test="yxrzcheckDetailDTO.ischeck==true">checked="checked"</s:if> name="ischeck" value="${ischeck}" /></td>

				    	<td >研修日志</td>
					    <td ><input class="form-control input-sm" value="${yxrzcheckDetailDTO.maxcalculate}" style="width: 60px;"/>篇研修日志</td>
					    <td ><input class="form-control input-sm" value="${yxrzcheckDetailDTO.maxscore}" name="maxscore"  style="width: 60px;"/>分</td>
					    <td>按篇</td>
					    <td >每发表一篇记<input class="form-control input-sm" value="${yxrzcheckDetailDTO.unitnum}" name="unitnum" style="width: 60px;"/>分</td>
					    <td ><input class="form-control input-sm" value="${yxrzcheckDetailDTO.courses}"  name="courses" style="display: none;;"/></td>
					    <td style="display: none;"><input value="yxrz"  name="checkcode"/></td>
					</tr>
					</s:else>



		<tr>
			<td class="white_bg"><input type="checkbox" name="scoreRadio1" id="scoreRadio1"
				<s:if test="programsCheckDTO.type==0">checked="checked"</s:if>value="0"
				<s:elseif test="programsCheckDTO.type==2">checked="checked"</s:elseif>value="2" />
				</td>

			<td>最终成绩</td>
			<td colspan="5">学员最终成绩为以上各项指标所得分数之和，得分达到或者超过<input
				class="form-control input-sm" type="text" id="mainqualifiedscore"
				name="qualifiedscore" value="${programsCheckDTO.qualifiedscore}"
				style="width: 60px;" />分，则培训合格。<input class="form-control input-sm"
				type="text" value="${programsCheckDTO.goodscore}" id="maingoodscore"
				name="goodscore" style="width: 60px;" />分以上为优秀</td>
		</tr>

		<tr>
			<td class="white_bg"><input type="checkbox" name="scoreRadio2" id="scoreRadio2"
				<s:if test="programsCheckDTO.type==1">checked="checked"</s:if>
				value="1" <s:elseif test="programsCheckDTO.type==2">checked="checked"</s:elseif>value="2" />
				</td>

			<td>所得学时</td>
			<td colspan="5">学员最终所得学时达到或者超过<input
				class="form-control input-sm" type="text"
				id="mainqualifiedlearnhour" name="qualifiedlearnhour"
				value="${programsCheckDTO.qualifiedlearnhour}" style="width: 60px;" />学时，则培训通过<!--<input class="form-control input-sm" type="text" value="${programsCheckDTO.qualifiedlearnhour}" id="maingoodscore" name="goodscore" style="width: 60px;"/>学时以上为优秀	--></td>
		</tr>
		
		<tr <s:if test="#request.isahstudyopen == 'true'||#request.isHbddOpen=='true'">style="display:none;"</s:if>>
			<td class="white_bg">&nbsp;</td>
			<td>学分银行</td>
			<td colspan="5">学员完成项目可获得<input class="form-control input-sm" type="text" id="banklearnhour" name="banklearnhour" value="${programsCheckDTO.banklearnhour}" style="width: 60px;" />学时，
				转换为<input class="form-control input-sm" type="text" id="bankscore" name="bankscore" value="${programsCheckDTO.bankscore}" style="width: 60px;" />学分。
			</td>
		</tr>
	</tbody>
			</table>
			</div>
			</div>
					<div class="dr-panel-footer">
						<div class="row">
							<div class="text-center">
					<button name="Submit3" class="btn btn-primary btn-sm" type="button" id="savebutton">
	                    <span class="glyphicon glyphicon-plus"></span>&nbsp;保存信息
	                </button>
								<button type="button" onclick="window.opener=null;window.open('','_self');window.close();" class="btn btn-default">关闭</button>
							</div>
						</div>
					</div>
     		</div>
		</form>
    <!--订单列表end-->
	</div>
	</section>
</div>

<!-- container end -->
<!--footer start-->
	    	<jsp:include page="/common${currentTenant.contents}/adminFooter.jsp">
	    	<jsp:param value="index" name="menu"/>
	    	</jsp:include>
<!--footer over-->
</body>
</html>