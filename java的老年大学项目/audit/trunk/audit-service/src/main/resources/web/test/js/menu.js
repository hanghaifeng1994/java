var menus = [
	// 00审核服务
    {
        name : "审核-列表",
        url : "api/adtAuditLog/queryPage.do",
        path : "api/adtAuditLog/queryPage",
        clazz : "PP00"
    }
	/*{
		name : "我的审核-新增",
		url : "api/adtAuditLog/insert.do",
		path : "api/adtAuditLog/insert",
		clazz : "PP00"
	},{
		name : "我的审核-列表",
		url : "api/adtAuditLog/queryPageByIds.do",
		path : "api/adtAuditLog/queryPageByIds",
		clazz : "PP00"
	},{
        name : "上报审核-列表",
        url : "api/adtReportUp/queryPage.do",
        path : "api/adtReportUp/queryPage",
        clazz : "PP00"
    },{
        name : "上报审核-新增",
        url : "api/adtReportUp/insert.do",
        path : "api/adtReportUp/insert",
        clazz : "PP00"
    },{
        name : "上报审核-删除",
        url : "api/adtReportUp/deleteById.do",
        path : "api/adtReportUp/deleteById",
        clazz : "PP00"
    },{
        name : "上报审核-审核",
        url : "api/adtReportUp/audit.do",
        path : "api/adtReportUp/audit",
        clazz : "PP00"
    }*/
];


var tplMenus = [ '{@each menus as item}',
	'<button class="PP ${item.clazz}" data-url="${item.url}" ',
	' data-path="${item.path}" data-opType=${item.opType} ',
	' onclick="loadForm(this)">${item.name}</button>', '{@/each}' ]
		.join("");

function loadMenus(ftClass,ftCode,ftName) {
	try {
		var datas = [];
		if (ftClass || ftCode || ftName) {
			for (var i = 0, j = menus.length; i < j; i++) {
				var menu = menus[i];
				if(!menu.opType)
					menu.opType = 0;
				if (ftName && ftName.length > 0
						&& menu.name.indexOf(ftName) >= 0) {
					datas.push(menu);
				} else if (ftCode && ftCode.length > 0
						&& menu.url.indexOf(ftCode) >= 0) {
					datas.push(menu);
				} else if (ftClass && ftClass.length > 0
						&& menu.clazz.indexOf(ftClass) >= 0) {
					datas.push(menu);
				}
			}
		} else {
			datas = menus;
		}
		var html = juicer(tplMenus, {
			menus : datas
		});
		$("#TRAN_AREA").html(html);
	} catch (e) {
		alert(e);
	}
}
