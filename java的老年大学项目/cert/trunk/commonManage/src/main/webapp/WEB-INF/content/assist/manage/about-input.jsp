<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<link href="${staticurl}/css/admin.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/js/validate/jquery.validate.css" type="text/css"
	rel="stylesheet" />
<script src="${staticurl}/js/jquery.js" type="text/javascript"></script>
<script src="${staticurl}/js/validate/jquery.validate.js"
	type="text/javascript"></script>
<script src="${staticurl}/js/validate/messages_cn.js" type="text/javascript"></script>
<link href="${staticurl}/js/treeview/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<script src="${staticurl}/js/treeview/jquery.cookie.js" type="text/javascript"></script>
<script src="${staticurl}/js/treeview/jquery.treeview.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>
<script type="text/javascript" src="${ctx}/fckeditor/lsfckeditor.js"></script>
<script type="text/javascript">
	function review()
	{
		var action=$("#inputForm").attr("action");
		var target=$("#inputForm").attr("target");
		$("#inputForm").attr("action","article!review.action");
		$("#inputForm").attr("target","_blank");
		$("#inputForm").get(0).submit();
		$("#inputForm").attr("action",action);
		$("#inputForm").attr("target",target);
		}
		$(document).ready(function() { 
			$("#oneCats").change(function(){
				$("#twoCats option[value!='']").remove();
				 $.get("${ctx}/related/articlecategory!categories.action", {catid:$(this).val()}, function (data){
					 var categories = eval(data.categories);
						if(categories.length == 0) return;
						for(var i = 0 ;i < categories.length ; i++) {
							$("#twoCats").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
						}
				});
			});
			//聚焦第一个输入框
			$("#username").focus();
	 		//选择2级分类时将其1级分类勾选上
	 		$('input[name="checkCats"]').bind("click", function(){
				if ($(this).parent().attr("id") == "treeLI2" && $(this).attr("checked")){
					$(this).parent().parent().parent().find('input[name="checkCats"]').first().attr("checked",true);
				}
				if ($(this).parent().attr("id") == "treeLI1" && !$(this).attr("checked")){
					$(this).parent().find('ul[id="treeUL2"]').find('input[name="checkCats"]').each(function(){
						$(this).attr("checked",false);
					})
				}
	 		})
	 	    // tree初始化
			$("#navigation").treeview({
	    		persist: "location",
	    		collapsed: false,
	    		unique: true
	    	});
			//为inputForm注册validate函数
			jQuery.validator.addMethod("isUsername", function(value, element) {    
		  		var name =/^[a-zA-Z]{1}[a-zA-Z0-9]{2,}$/;     
		  		return this.optional(element) || (name.test(value));    
			}, "用户名由数字字母组成,首位必须为字母");

	    	// 提交表单时check
			$("form[name='inputform']").submit(function(){
				var serialNo = /^[a-zA-Z0-9]{1,}$/;
				if ($("#serialNo").val().length >0 && !$("#serialNo").val().match(serialNo)) {
					alert("课程编号只能由数字字母组成！");
					return false;
				}
				var flag = false;
				$("#tree").find("input[name='checkCats']").each(function(){
					if ($(this).attr("checked")) {
						flag = true;
					}
				})
				if (!flag){
					alert("请选择信息分类！");
					return false;
				}
				var twoFlag = true;
				var name;
				$("#tree").find('li[id="treeLI1"]').each(function(){
					if ($(this).find('ul[id="treeUL2"]').find('input[name="checkCats"]').size() < 1) {
						twoFlag = true;
						return true;
					}
					if ($(this).find('input[name="checkCats"]').first().attr("checked")){
						twoFlag = false;
						$(this).find('ul[id="treeUL2"]').find('input[name="checkCats"]').each(function(){
							if ($(this).attr("checked")) {
								twoFlag = true;
								return false;
							}
						})
						name = $(this).find('input[name="checkCats"]').first().parent().find("label").html();
						if (!twoFlag){
							twoFlag = false;
							alert("请选择"+name+"分类下的二级分类！");
							return false;
						}
					}
				})
				if (!twoFlag){
					return false;
				}
				return true;
			})
			
			$("#inputForm").validate({
				rules: {
					title: {
						required: true
					},
					content: {
						required: true
					}
				},
				messages: {
					title:{
						required:"请输入标题",
						maxlength:"字数小于10位"
					},
					content:{
						required:"请输入内容"
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
	</script>

<div class="right_position"><a href="#" class="grey">平台首页</a> &gt;<a
	href="#" class="grey">信息发布管理</a> &gt; <span class="deep_bule"><s:if
	test="id==null">发布</s:if><s:else>编辑</s:else>信息</span></div>
<s:actionmessage theme="custom" cssClass="tipbox" />
<form id="inputForm" name="inputForm" action="article!save.action" method="post" enctype="multipart/form-data">
    <input id="id" name="id" type="hidden" value="${id}" size="30" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="adminedit">
	<tr>
		<td class="tdll">信息标题<span class="admin_red">*</span></td>
		<td><input name="title" value="${title}" type="text"
			class="txtinput01 fl" /><span class="admin_woring_x"
			id="error_title"></span></td>
	</tr>
	<tr>
		<td class="tdll">单位</td>
		<td><input name="unit" value="${unit}" type="text"
			class="txtinput01 fl" /></td>
	</tr>
	<tr>
		<td class="tdll">新闻来源</td>
		<td><input name="fromSource" value="${fromSource}" type="text"
			class="txtinput01 fl" /></td>
	</tr>
	<tr>
		<td class="tdll">作者</td>
		<td><input name="author" value="${author}" type="text"
			class="txtinput02 fl" /></td>
	</tr>
	<tr>
		<td valign="top" class="tdll">所属分类<span class="admin_red">*</span></td>
		<td><!-- 
		<div id="tree"
			style="width: 280px; height: 250px; overflow: auto; border-style: solid; border-width: 1px; border-color: #CCC">
		<ul id="navigation">
			<s:iterator value="oneCats">
				<li id="treeLI1" class="treeview">&nbsp; <s:if
					test="false==check">
					<input name="checkCats" type="checkbox" value="${id}" />
					<label>${name}</label>
				</s:if> <s:else>
					<input name="checkCats" type="checkbox" value="${id}"
						checked="checked" />
					<label>${name}</label>
				</s:else>
				<ul id="treeUL2" class="treeview">
					<s:iterator value="childs">
						<li id="treeLI2" class="treeview">&nbsp; <s:if
							test="false==check">
							<input name="checkCats" type="checkbox" value="${id}" />${name}
						</s:if> <s:else>
							&nbsp;<input name="checkCats" type="checkbox" value="${id}"
								checked="checked" />${name}
						</s:else>
						<ul id="treeUL3" class="treeview">
							<s:iterator value="childs">
								<li id="treeLI3" class="treeview">&nbsp; <s:if
									test="false==check">
									<input name="checkCats" type="checkbox" value="${id}" />${name}
							</s:if> <s:else>
								&nbsp;<input name="checkCats" type="checkbox" value="${id}"
										checked="checked" />${name}
							</s:else></li>
							</s:iterator>
						</ul>
						</li>
					</s:iterator>
				</ul>
				</li>
			</s:iterator>
		</ul>
		<s:iterator value="checkCats" var="checkCat">
			<input type="hidden" id="checkCat" value="${checkCat}" />
		</s:iterator></div>
		 --> <s:select list="oneCats" listKey="id" listValue="name"
			headerKey="" headerValue="选择一级分类" theme="simple" id="oneCats"></s:select> <select
			id="twoCats" name="checkCats">
			<option value="">选择二级分类</option>
		</select> <span class="woring_x" id="checkCats"></span></td>
	</tr>
	<tr>
		<td class="tdll">信息内容<span class="admin_red">*</span></td>
		<td><textarea rows="15" cols="116" name="content">${content}</textarea>
		<script type="text/javascript">
		createCkEditor("${ctx}/fckeditor/","content",600,380,"MyToolbar",'${fckUploadFileId}','${fckUploadFileYM}',true,80,'replace');
		function FCKeditor_OnComplete(editorInstance) { 
			//IE,搜狗浏览器的
			if(document.all){
				editorInstance.EditorDocument.attachEvent("onkeyup", editor_keyup); 
			}else{//火狐浏览器
				editorInstance.EditorDocument.addEventListener('keyup', editor_keyup,false) ;
			}
		}
		function editor_keyup(e) 
		   { 
		    if(getLength()>0)
				$('#error_content').hide();
		    else
		    	$('#error_content').show();
		   }
		</script><br />
		<span class="woring_x" id="error_content"></span></td>
	</tr>
	<tr>
		<td class="tdll">配图</td>
		<td><input id="uploadPic" name="uploadPic" value="" type="file"
			class="txtinput02 fl" /></td>
	</tr>
	<tr>
		<td class="tdll">&nbsp;</td>
		<td>
		<center><img
			src="<common:prop name="ahstudy.uploadpath.url" propfilename=""></common:prop>/${imgname}"
			title="${name}" alt="${name}" /></center>
		</td>
	</tr>
	<tr>
		<td class="tdll">&nbsp;</td>
		<td><span class="fl"> <input name="Submit32" type="submit"
			class="operation_btu1" value="保存" /> <input name="Submit32"
			type="button" onclick="review()" class="operation_btu1" value="预 览" />
		<input onclick="window.location.href='article.action'" type="button"
			class="operation_btu2" value="取消" /> </span></td>
	</tr>
</table>
</form>