<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page session="false"%>
<%@page import="cn.common.lib.util.web.PropertyUtils"%>
<script type="text/javascript">
<!--
$(document).ready(function(){
	//if ($("#city_id").val()=="江苏省外") {
	//	$("#areaselect").hide();
	//	$("#areadiv").show();
	//} else {
	//	$("#areaselect").show();
	//	$("#areadiv").hide();
	//}
   	//根据地级市获得区县
	$("#city_id").bind("change",function() {
		var city = $("#city_id").val();
		//if (city=="江苏省外") {
		//	$("#areaselect").hide();
		//	$("#areadiv").show();
		//} else {
		//	$("#areaselect").show();
		//	$("#areadiv").hide();
		//}
		//$("#area_id").val("");
		//$("#street_id").val("");
		//$("#areainput").val("");
		$("#area_id option[value!='']").remove();
		$("#street_id option[value!='']").remove();
		if(city) {
			$.post("${ctx}/data/cantonrelated.excsec",{"parentName":city},function(data) {
				$("#area_id option[value!='']").remove();
				var practiceUnit = eval(data.cantons);
				if(practiceUnit.length == 0) $("#area_id option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					$("#area_id").append("<option value='"+practiceUnit[i].label+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}
	});
	
	//根据区县获得街道
	$("#area_id").bind("change",function() {
		$("#street_id option[value!='']").remove();
		var area = "";//$("#area_id").val();  
		if(area) {
			$.post("${ctx}/data/cantonrelated.excsec",{"parentName":area},function(data) {
				$("#street_id option[value!='']").remove();
				var practiceUnit = eval(data.cantons);
				if(practiceUnit.length == 0) $("#street_id option[value!='']").remove();
				for(var i = 0 ;i < practiceUnit.length ; i++) {
					$("#street_id").append("<option value='"+practiceUnit[i].label+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}
	});
});
-->
</script>
<s:select cssClass="cxse0" list="citysVLists" listKey="name"  listValue="name" name="updateUser.unitcity" value="nowUser.unitcity" id="city_id" theme="simple" headerKey="" headerValue="-所在市-"/>
<s:select cssClass="cxse0" list="areasVLists" listKey="name"  listValue="name" name="updateUser.unitarea" value="nowUser.unitarea" id="area_id" theme="simple" headerKey="" headerValue="-所在区县-"/>