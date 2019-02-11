//用于栏目管理 的级联查询取数据
$(document).ready(function() {
 
	//根据一级栏目获得二级栏目
	$("#oneCat").bind("change",function() {
		 
		var oneCatId = $("#oneCat").val();
		if(oneCatId) {
			$.post("../manage/related!getCategorys.excsec",{"catId":oneCatId},function(data) {
				$("#twoCat option[value!='']").remove();
				var category = eval(data.cats);
				if(category.length == 0) return;
				for(var i = 0 ;i < category.length ; i++) {
					$("#twoCat").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
				} 
				$("#threeCat option[value!='']").remove();
			});
		}else {
			$("#twoCat option[value!='']").remove(); 
			$("#threeCat option[value!='']").remove();
		}
	});
	
	//根据二级栏目获得三级栏目　
	$("#twoCat").bind("change",function() {
		var twoCatId = $("#twoCat").val();
	 
		if(twoCatId) {
			$.post("../manage/related!getCategorys.excsec",{"catId":twoCatId},function(data) {
				$("#threeCat option[value!='']").remove();
				var category = eval(data.cats);
				if(category.length == 0) return;
				for(var i = 0 ;i < category.length ; i++) {
					$("#threeCat").append("<option value='"+category[i].value+"'>"+category[i].label+"</option>");
				}
			});
		}else {
			$("#threeCat option[value!='']").remove();
		}
	});
	
	
	$("#adduser").bind("click",function() {
		var idcard = $("#idcard").val();
	 
		if(idcard) {
			$.post("../../related/user!useridcard.action",{"idCard":idcard},function(data) {

				var user = eval(data.user);
				if(user==null||user=="")
				{
					alert('没找到此用户或者此用户没有班主任权限');
					return false;
				}
				if(user.length == 0) return;
				var exists=false;
				$("#clazzmanager option").each(function ()
				{
					if($(this).val()==user[0].username)
					{
						alert('不能分配相同的用户');
						exists=true;
						return false;
					}
				})
				if(exists) return false;
				for(var i = 0 ;i < user.length ; i++) {
					$("#clazzmanager").append("<option value='"+user[i].username+"'>"+user[i].name+"("+$("#idcard").val()+")</option>");
				}
			});
		}else {
			alert("请输入身份证号码");
		}
	});
	
	$("#removemanager").bind("click",function() {
		$("#clazzmanager option:selected").remove();
	});
	
	//根据类型获得年份
	$("#type").bind("change",function() {
		
		var type = $("#type").val();
 
		if(type) {
			$.post("../manage/relateperiod!getYearsByType.excsec",{"type":type},function(data) {
				$("#year option[value!='']").remove();
				var year = eval(data.years);
				if(year.length == 0) return;
				for(var i = 0 ;i < year.length ; i++) {
				 
					$("#year").append("<option value='"+year[i].value+"'>"+year[i].label+"</option>");
				}
			});
		}else {
			$("#year option[value!='']").remove();
			$("#nonumId option[value!='']").remove();
		}
	});
	
	//根据年份获得期次
	$("#year").bind("change",function() {
		var year = $("#year").val(); 
		var type = $("#type").val();
	 
		if(year) {
			$.post("../manage/relateperiod!getPeriodsByYear.excsec",{"year":year,"type":type},function(data) {
				$("#nonumId option[value!='']").remove();
				var period = eval(data.periods);
				if(period.length == 0) return;
				for(var i = 0 ;i < period.length ; i++) {
				 
					$("#nonumId").append("<option value='"+period[i].value+"'>"+period[i].label+"</option>");
				}
			});
		}else {
			$("#nonumId option[value!='']").remove();
		}
	});
	
	//根据实践点获得其子类型
	$("#type_id").bind("change",function() {
		var type = $("#type_id").val();  
		if(type!="实验示范" && type!="")
		{ 
			document.getElementById('childType_id').options[0].selected="selected";
			document.getElementById('childType_id').disabled="disabled";
			return;
		}else
		{
			document.getElementById('childType_id').removeAttribute('disabled');
		}
		if(type) {
			$.post("../manage/relatepractice!getPractices.excsec",{"type":type},function(data) {
				$("#childType_id option[value!='']").remove();
				var practiceUnit = eval(data.practs);
				if(practiceUnit.length == 0) return;
				for(var i = 0 ;i < practiceUnit.length ; i++) {
 
					$("#childType_id").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}else {
			$("#childType_id option[value!='']").remove();
		}
	});
	
	//根据地级市 获得区县
	$("#city_id").bind("change",function() {
		var city = $("#city_id").val();  
		if(city) {
			$.post("../manage/relatepractice!getAreasByCity.excsec",{"city":city},function(data) {
				$("#area_id option[value!='']").remove();
				var practiceUnit = eval(data.areas);
				if(practiceUnit.length == 0) return;
				for(var i = 0 ;i < practiceUnit.length ; i++) {
 
					$("#area_id").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}else {
			$("#area_id option[value!='']").remove();
		}
	});
	
	
	
	$("#level").bind("change",function() {
		
		var levelid = $(this).val();
		if(levelid) {
			$.getJSON("../../related/related!levelcategories.action",{"levelid":levelid},function(data) {
				$("#parentcategory option[value!='']").remove();
				var categories = eval(data.courseCategories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#parentcategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#parentcategory option[value!='']").remove();
		}
	});	
	
	//根据地级市 获得区县
	$("#area_id").bind("change",function() {
		var area = $("#area_id").val();
	 
		if(area) {
			$.post("../manage/relatepractice!getStreetsByArea.excsec",{"area":area},function(data) {
				$("#street_id option[value!='']").remove();
				var practiceUnit = eval(data.streets);
				if(practiceUnit.length == 0) return;
				for(var i = 0 ;i < practiceUnit.length ; i++) {
 
					$("#street_id").append("<option value='"+practiceUnit[i].value+"'>"+practiceUnit[i].label+"</option>");
				}
			});
		}else {
			$("#street_id option[value!='']").remove();
		}
	});
	
	
	
	//chenbo 2012/7/22
	
	$("#itemid").bind("change",function() {
		$("#programsid option[value!='']").remove();
		$("#planid option[value!='']").remove();
		var itemid = $(this).val();
		if(itemid) {
			$.getJSON("../../related/itemprogram!programs.action",{"itemid":itemid},function(data) {
				$("#programsid option[value!='']").remove();
				var programs = eval(data.programs);
				if(programs.length == 0) return;
				for(var i = 0 ;i < programs.length ; i++) {
					$("#programsid").append("<option value='"+programs[i].value+"'>"+programs[i].label+"</option>");
				}
				if(pageprogramsid!=undefined&&pageprogramsid!=null&&pageprogramsid!="")
				{
					$("#programsid").val(pageprogramsid);
					$("#programsid").change();
				}
				
			});
		}else {
			$("#programsid option[value!='']").remove();
			$("#planid option[value!='']").remove();
		}
	});
	
	//chenbo 2012/7/22
	$("#programId").bind("change",function() {
		var programsid = $(this).val();
		if(programsid) {
			$.getJSON("../../related/teachplan!plans.action",{"programsid":programsid},function(data) {
				$("#planid option[value!='']").remove();
				var teachplan = eval(data.teachplan);
				if(teachplan.length == 0) return;
				for(var i = 0 ;i < teachplan.length ; i++) {
					$("#planid").append("<option value='"+teachplan[i].value+"'>"+teachplan[i].label+"</option>");
				}
				
				if(pageplanid!=undefined&&pageplanid!=null&&pageplanid!="")
				{
					$("#planid").val(pageplanid);
				
				}
			
			});
		}else {
			$("#planid option[value!='']").remove();
		}
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
				$("#threecategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0)
					return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#threecategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#threecategory option[value!='']").remove();
		}
	});
	
	
	//chenbo 2012/8/18
	$("#articleonecategory").bind("change",function() {
		var catid = $(this).val();
		if(catid) {
			$.getJSON("../../related/articlecategory!categories.action",{"catid":catid},function(data) {
				$("#articletwocategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#articletwocategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#articletwocategory option[value!='']").remove();
		}
		$("#onecat").val(catid);
	});
	
	
	//chenbo 2012/8/18
	$("#articletwocategory").bind("change",function() {
		var catid = $(this).val();
		if(catid) {
			$.getJSON("../../related/articlecategory!categories.action",{"catid":catid},function(data) {
				$("#articlethreecategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#articlethreecategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#articlethreecategory option[value!='']").remove();
		}
		$("#twocat").val(catid);
	});
	
	//chenbo 2012/8/18
	$("#articlethreecategory").bind("change",function() {
		var catid = $(this).val();
		
		$("#threecat").val(catid);
	});
	
	//chenbo 2012/8/18
	$("#courseonecategory").bind("change",function() {
		var catid = $(this).val();
		if(catid) {
			$.getJSON("../../related/coursecategory!categories.action",{"categoryid":catid},function(data) {
				$("#coursetwocategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#coursetwocategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#coursetwocategory option[value!='']").remove();
		}
		$("#onecat").val(catid);
	});
	
	
	//chenbo 2012/8/18
	$("#coursetwocategory").bind("change",function() {
		var catid = $(this).val();
		if(catid) {
			$.getJSON("../../related/coursecategory!categories.action",{"categoryid":catid},function(data) {
				$("#coursethreecategory option[value!='']").remove();
				var categories = eval(data.categories);
				if(categories.length == 0) return;
				for(var i = 0 ;i < categories.length ; i++) {
					$("#coursethreecategory").append("<option value='"+categories[i].value+"'>"+categories[i].label+"</option>");
				}
			});
		}else {
			$("#coursethreecategory option[value!='']").remove();
		}
		$("#twocat").val(catid);
	});
	
	//chenbo 2012/8/18
	$("#coursethreecategory").bind("change",function() {
		var catid = $(this).val();
		
		$("#threecat").val(catid);
	});
	
})