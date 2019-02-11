var menus = [
    // 00基础服务
    {
        name : "订单列表",
        url : "api/ordOrderform/queryManagePage.do",
        path : "api/ordOrderform/queryManagePage",
        clazz : "PP00"
    },{
        name : "订单详情",
        url : "api/ordOrderform/queryById.do",
        path : "api/ordOrderform/queryById",
        clazz : "PP00"
    },{
        name : "微信二维码支付入口",
        url : "api/ordOrderform/queryWxpayqrcode.do",
        path : "api/ordOrderform/queryWxpayqrcode",
        clazz : "PP00"
    },{
        name : "支付宝支付入口",
        url : "api/ordOrderform/queryAipayCode.do",
        path : "api/ordOrderform/queryAipayCode",
        clazz : "PP00"
    },{
        name : "查询微信订单是否已支付",
        url : "api/ordOrderform/queryWxOrder.do",
        path : "api/ordOrderform/queryWxOrder",
        clazz : "PP00"
    },{
        name : "查询支付宝订单是否已支付",
        url : "api/ordOrderform/queryAliOrder.do",
        path : "api/ordOrderform/queryAliOrder",
        clazz : "PP00"
    },{
        name : "查询订单是否已支付",
        url : "api/ordOrderform/queryOrderStatus.do",
        path : "api/ordOrderform/queryOrderStatus",
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
