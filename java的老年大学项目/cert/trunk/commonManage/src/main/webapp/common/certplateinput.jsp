<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<link href="${staticurl}/wx_js${currentTenant.contents}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${staticurl}/wx_js${currentTenant.contents}/bootstrap/drcl_css/drcl.css" rel="stylesheet" type="text/css" />	
<%@page import="com.drcl.traincore.contants.CerttemplateField"%>
<head>
	<script type="text/javascript">
	//证书关联的模板切换时的操作,certtemplateId:选择的模板ID,flag:是否默认选择第一个下拉列表的标识
	function onCertplateText(certtemplateId,flag){
		if(certtemplateId){
			$.post("cert!ajaxCertplateText.excsec",{"certtemplateId":certtemplateId},function(data) {
				//隐藏所有LI
				onHideLi();
				
				//如果下拉列表的标识为true,则默认选择第一个下拉列表项且表空左边的文本框和图片SRC
				if(flag){
					onSelect();
					onClear();
				}
				//调用显示文本的方法
				onShowText(data.textOne,"liOne","textOne","selTextOne"); 
				onShowText(data.textTwo,"liTwo","textTwo","selTextTwo"); 
				onShowText(data.textThree,"liThree","textThree","selTextThree"); 
				onShowText(data.textFour,"liFour","textFour","selTextFour");  
				onShowText(data.textFive,"liFive","textFive","selTextFive"); 
				onShowText(data.textSix,"liSix","textSix","selTextSix"); 
				onShowText(data.textSeven,"liSeven","textSeven","selTextSeven"); 
				onShowText(data.textEight,"liEight","textEight","selTextEight"); 
				onShowText(data.textNine,"liNine","textNine","selTextNine"); 
				onShowText(data.textTen,"liTen","textTen","selTexteTen"); 
				onShowText(data.textEleven,"liEleven","textEleven","selTextEleven"); 
				onShowText(data.textTwelve,"liTwelve","textTwelve","selTextTwelve"); 
				onShowText(data.textThirteen,"liThirteen","textThirteen","selTextThirteen"); 
				onShowText(data.textFourteen,"liFourteen","textFourteen","selTextFourteen"); 
				onShowText(data.textFifteen,"liFifteen","textFifteen","selTextFifteen"); 

				//调用显示图片的方法
				onShowImage(data.imageOne,"liImageOne","imageOneUrl","imageOne"); 
				onShowImage(data.imageTwo,"liImageTwo","imageTwoUrl","imageTwo"); 
				onShowImage(data.imageThree,"liImageThree","imageThreeUrl","imageThree"); 
				onShowImage(data.imageFour,"liImageFour","imageFourUrl","imageFour"); 
				onShowImage(data.imageFive,"liImageFive","imageFiveUrl","imageFive"); 

				//框架高度自适应
				//parent.iFrameHeight();
			});
		}else{
			//隐藏所有LI
			onHideLi();
		}
	}

	//调用显示文本的方法
	function onShowText(tempTextValue,liId,textId,selTextId){
		if(isNotNull(tempTextValue)){
			$("#"+liId).show();//显示LI
			$("#"+textId).show();//显示文本框
			$("#"+textId).val(tempTextValue);//给文本框赋值 
		}
	} 
	
	//调用显示图片的方法
	function onShowImage(tempImageValue,liImageId,ImageId,selImageId){
		if(isNotNull(tempImageValue)){
			var varUrl='<common:prop name="certtemplate.webapp.uploadUrl" propfilename="certtemplate.properties" defaultvalue="${pageContext.request.contextPath}"/><%=CerttemplateField.CETTEMPLATE_PATH%>';
			$("#"+liImageId).show();//显示LI
			$("#"+ImageId).attr("src",varUrl+tempImageValue);//给文本框赋值
			$("#"+selImageId).show();//显示图片对应关系的下拉框
		}
	} 
	

	//清空所有文本,图片,下拉框
	function onHideLi(){
		$("#liOne").hide();
		$("#liTwo").hide();
		$("#liThree").hide();
		$("#liFour").hide();
		$("#liFive").hide();
		$("#liSix").hide();
		$("#liSeven").hide();
		$("#liEight").hide();
		$("#liNine").hide();
		$("#liTen").hide();
		$("#liEleven").hide();
		$("#liTwelve").hide();
		$("#liThirteen").hide();
		$("#liFourteen").hide();
		$("#liFifteen").hide();
		$("#liImageOne").hide();
		$("#liImageTwo").hide();
		$("#liImageThree").hide();
		$("#liImageFour").hide();
		$("#liImageFive").hide();
	} 

	
	//表空左边的文本框和图片SRC
	function onClear(){
		$("#textOne").val("");
		$("#textTwo").val("");
		$("#textThree").val("");
		$("#textFour").val("");
		$("#textFive").val("");
		$("#textSix").val("");
		$("#textSeven").val("");
		$("#textEight").val("");
		$("#textNine").val("");
		$("#textTen").val("");
		$("#textEleven").val("");
		$("#textTwelve").val("");
		$("#textThirteen").val("");
		$("#textFourteen").val("");
		$("#textFifteen").val("");
		$("#imageOneUrl").attr("src","");
		$("#imageTwoUrl").attr("src","");
		$("#imageThreeUrl").attr("src","");
		$("#imageFourUrl").attr("src","");
		$("#imageFiveUrl").attr("src",""); 
	} 

	//让下拉列表第一项默认选中
	function onSelect(){
		$("#selTextOne").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextTwo").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextThree").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextFour").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextFive").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextSix").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextSeven").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextEight").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextNine").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextTen").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextEleven").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextTwelve").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextThirteen").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextFourteen").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#selTextFifteen").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#imageOne").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#imageTwo").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#imageThree").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#imageFour").get(0).options[0].selected = true; //让下拉列表第一项默认选中
		$("#imageFive").get(0).options[0].selected = true; //让下拉列表第一项默认选中 
	} 
	
	//判断非空
	function isNotNull(value){
		return (value!=null && ""!=value)?true:false;
	}
	</script>
</head>
<body>
<ul style="width: 250px;float: left;margin-right:1000px">
<li style="list-style-type:none;margin-left: 10px;">
 <s:select list="certtemplateVOs" listKey="certemplateId"  value="certtemplateId"
   	listValue="certtemplateName" name="certtemplateId" id="certtemplateId" label="证书模板"  
    headerKey="" headerValue="--所有证书模板--" theme="simple" cssStyle="width:220px;margin-left: -48px;" onchange="onCertplateText($(this).val(),true)" cssClass="form-control input-sm"/> 
</li>
</ul>
<ul id="liUl">
<s:set var="certTypeLists" value="@com.drcl.traincore.contants.CerttemplateField@enumTextList"></s:set>
<li id="liOne" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textOne" id="textOne" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textOne"
		listValue="label" name="selTextOne" id="selTextOne"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liTwo" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textTwo" id="textTwo" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span> 
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textTwo"
		listValue="label" name="selTextTwo" id="selTextTwo"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liThree" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textThree" id="textThree" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textThree"
		listValue="label" name="selTextThree" id="selTextThree"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liFour" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textFour" id="textFour" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textFour"
		listValue="label" name="selTextFour" id="selTextFour"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liFive" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textFive" id="textFive" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span> 
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textFive"
		listValue="label" name="selTextFive" id="selTextFive"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liSix" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textSix" id="textSix" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textSix"
		listValue="label" name="selTextSix" id="selTextSix"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liSeven" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textSeven" id="textSeven" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span> 
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textSeven"
		listValue="label" name="selTextSeven" id="selTextSeven"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liEight" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textEight" id="textEight" value="" readonly="readonly" style="width: 150px;display: none;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textEight"
		listValue="label" name="selTextEight" id="selTextEight"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liNine" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textNine" id="textNine" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textNine"
		listValue="label" name="selTextNine" id="selTextNine"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liTen" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textTen" id="textTen" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textTen"
		listValue="label" name="selTextTen" id="selTextTen"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liEleven" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textEleven" id="textEleven" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textEleven"
		listValue="label" name="selTextEleven" id="selTextEleven"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liTwelve" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textTwelve" id="textTwelve" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textTwelve"
		listValue="label" name="selTextTwelve" id="selTextTwelve"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liThirteen" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textThirteen" id="textThirteen" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textThirteen"
		listValue="label" name="selTextThirteen" id="selTextThirteen"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liFourteen" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textFourteen" id="textFourteen" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textFourteen"
		listValue="label" name="selTextFourteen" id="selTextFourteen"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liFifteen" style="display: none;">
	<label>&nbsp;</label>
	<input type="text" name="textFifteen" id="textFifteen" value="" readonly="readonly" style="width: 150px;"/>
	<span>&lt;==&gt; </span>  
	<s:select list="certTypeLists" listKey="value"  value="certplateVO.textFifteen"
		listValue="label" name="selTextFifteen" id="selTextFifteen"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>

<!-- 图片显示 -->
<s:set var="certImageLists" value="@com.drcl.traincore.contants.CerttemplateField@enumImageList"></s:set>
<li id="liImageOne" style="display: none;">
	<label>&nbsp;</label>
	<img alt="" id="imageOneUrl" src="" width="100" height="100">
	<span>&lt;==&gt; </span>  
	<s:select list="certImageLists" listKey="value"  value="certplateVO.imageOne"
		listValue="label" name="selImageOne" id="imageOne"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liImageTwo" style="display: none;">
	<label>&nbsp;</label>
	<img alt="" id="imageTwoUrl" src="" width="100" height="100">
	<span>&lt;==&gt; </span>  
	<s:select list="certImageLists" listKey="value"  value="certplateVO.imageTwo"
		listValue="label" name="selImageTwo" id="imageTwo"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liImageThree" style="display: none;">
	<label>&nbsp;</label>
	<img alt="" id="imageThreeUrl" src="" width="100" height="100">
	<span>&lt;==&gt; </span>  
	<s:select list="certImageLists" listKey="value"  value="certplateVO.imageThree"
		listValue="label" name="selImageThree" id="imageThree"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liImageFour" style="display: none;">
	<label>&nbsp;</label>
	<img alt="" id="imageFourUrl" src="" width="100" height="100">
	<span>&lt;==&gt; </span>
	<s:select list="certImageLists" listKey="value"  value="certplateVO.imageFour"
		listValue="label" name="selImageFour" id="imageFour"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
<li id="liImageFive" style="display: none;">
	<label>&nbsp;</label>
	<img alt="" id="imageFiveUrl" src="" width="100" height="100">
	<span>&lt;==&gt; </span>  
	<s:select list="certImageLists" listKey="value"  value="certplateVO.imageFive"
		listValue="label" name="selImageFive" id="imageFive"   
		headerKey="" headerValue="--选择模板关联数据项--" theme="simple" cssStyle="width:200px;"/>
</li>
</ul>
</body>
 