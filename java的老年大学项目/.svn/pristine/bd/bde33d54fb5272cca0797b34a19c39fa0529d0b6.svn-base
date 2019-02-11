var menus = [
	// 00审核服务
	{
		name : " 积分-积分列表",
		url : "api/bilPoints/queryPage.do",
		path : "api/bilPoints/queryPage",
		clazz : "PP00"
	},{
        name : "学分-学分列表查询",
        url : "api/bilCredit/queryPage.do",
        path : "api/bilCredit/queryPage",
        clazz : "PP00"
    },{
        name : "账单用户-几个用户参数的账单列表查询",
        url : "api/bilCustExt/queryPageByUser.do",
        path : "api/bilCustExt/queryPageByUser",
        clazz : "PP00"
    }
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
