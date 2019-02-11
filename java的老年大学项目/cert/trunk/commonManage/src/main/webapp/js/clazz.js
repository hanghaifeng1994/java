//用于栏目管理 的级联查询取数据
$(document).ready(function() {

	
	
	//chenbo 2012/7/22
	
	$("#itemid").bind("change",function() {
		
		var itemid = $(this).val();
		
		if(itemid) {
			$.getJSON("../../related/itemprogram!programs.action",{"itemid":itemid},function(data) {
				$("#programsid option[value!='']").remove();
				var programs = eval(data.programs);
				if(programs.length == 0) return;
				for(var i = 0 ;i < programs.length ; i++) {
					$("#programsid").append("<option value='"+programs[i].value+"'>"+programs[i].label+"</option>");
				}
			});
		}else {
			$("#programsid option[value!='']").remove();
		}
	});
	
	//chenbo 2012/7/22
	$("#programsid").bind("change",function() {
		var programsid = $(this).val();
		$("#hiddenprogramsid").val(programsid);
		if(programsid) {
			$.getJSON("../../related/teachplan!plans.action",{"programsid":programsid},function(data) {
				$("#planid option[value!='']").remove();
				var teachplan = eval(data.teachplan);
				if(teachplan.length == 0) return;
				for(var i = 0 ;i < teachplan.length ; i++) {
					$("#planid").append("<option value='"+teachplan[i].value+"'>"+teachplan[i].label+"</option>");
				}
			});
		}else {
			$("#planid option[value!='']").remove();
		}
	});
	
	
	//chenbo 2012/7/22
	$("#planid").bind("change",function() {
		var planid = $(this).val();
		$("#hiddenplanid").val(planid);
	});
	
	
	
	//chenbo 2012/7/22
	$("#onecategory").bind("change",function() {
		var categoryid = $(this).val();
		if(categoryid) {
			$.getJSON("../../related/coursecategory!categories.action",{"categoryid":categoryid},function(data) {
				$("#twocategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#twocategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#twocategory option[value!='']").remove();
		}
	});
	
	//chenbo 2012/7/22
	$("#twocategory").bind("change",function() {
		var categoryid = $(this).val();
		if(categoryid) {
			$.getJSON("../../related/coursecategory!categories.action",{"categoryid":categoryid},function(data) {
				$("#threeCategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#threeCategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#threeCategory option[value!='']").remove();
		}
	});
	
	
	
	
})