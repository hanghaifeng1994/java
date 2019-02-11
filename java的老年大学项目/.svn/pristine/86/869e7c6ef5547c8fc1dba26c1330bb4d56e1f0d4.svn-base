var menus = [
	// 00友情链接
	{
		name : "友情链接-管理列表",
		url : "api/setLinks/queryPage.do",
		path : "api/setLinks/queryPage",
		clazz : "PP00"
	},{
        name : "友情链接-添加",
        url : "api/setLinks/save.do",
        path : "api/setLinks/save",
        clazz : "PP00"
    },{
        name : "友情链接-修改",
        url : "api/setLinks/update.do",
        path : "api/setLinks/update",
        clazz : "PP00"
    },{
        name : "友情链接-删除",
        url : "api/setLinks/deleteById.do",
        path : "api/setLinks/deleteById",
        clazz : "PP00"
    },{
        name : "友情链接-详情",
        url : "api/setLinks/queryById.do",
        path : "api/setLinks/queryById",
        clazz : "PP00"
    },{
        name : "友情链接-启用",
        url : "api/setLinks/enable.do",
        path : "api/setLinks/enable",
        clazz : "PP00"
    },{
        name : "友情链接-禁用",
        url : "api/setLinks/disable.do",
        path : "api/setLinks/disable",
        clazz : "PP00"
    },{
        name : "友情链接-保存排序",
        url : "api/setLinks/saveSorts.do",
        path : "api/setLinks/saveSorts",
        clazz : "PP00"
    },{
        name : "友情链接-列表(前台)",
        url : "common/setLinks/querySiteLinks.do",
        path : "common/setLinks/querySiteLinks",
        clazz : "PP00"
    }
    // 推广PP01-------------------

    ,{
        name : "推广-管理列表",
        url : "api/setPromotion/queryPage.do",
        path : "api/setPromotion/queryPage",
        clazz : "PP01"
    },{
        name : "推广-添加",
        url : "api/setPromotion/save.do",
        path : "api/setPromotion/save",
        clazz : "PP01"
    },{
        name : "推广-修改",
        url : "api/setPromotion/update.do",
        path : "api/setPromotion/update",
        clazz : "PP01"
    },{
        name : "推广-删除",
        url : "api/setPromotion/deleteById.do",
        path : "api/setPromotion/deleteById",
        clazz : "PP01"
    },{
        name : "推广-详情",
        url : "api/setPromotion/queryById.do",
        path : "api/setPromotion/queryById",
        clazz : "PP01"
    },{
        name : "推广-启用",
        url : "api/setPromotion/enable.do",
        path : "api/setPromotion/enable",
        clazz : "PP01"
    },{
        name : "推广-禁用",
        url : "api/setPromotion/disable.do",
        path : "api/setPromotion/disable",
        clazz : "PP01"
    },{
        name : "推广-保存排序",
        url : "api/setPromotion/saveSorts.do",
        path : "api/setPromotion/saveSorts",
        clazz : "PP01"
    },{
        name : "推广-列表(前台)",
        url : "common/setPromotion/querySitePromotions.do",
        path : "common/setPromotion/querySitePromotions",
        clazz : "PP01"
    }
	// 通用PP02-------------------
    ,{
        name : "关于-保存",
        url : "api/setAbout/save.do",
        path : "api/setAbout/save",
        clazz : "PP02"
    },{
        name : "关于-根据站点获取",
        url : "api/setAbout/getSiteAbout.do",
        path : "api/setAbout/getSiteAbout",
        clazz : "PP02"
    },{
        name : "关于-获取关于(前台)",
        url : "common/getAbout.do",
        path : "common/getAbout",
        clazz : "PP02"
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
