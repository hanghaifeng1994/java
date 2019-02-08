let mservice_aggerateapi_forserver = require('../server/mserviceapi').mservice_aggerateapi_forserver;

function page_data(req, res, router) {
    mservice_aggerateapi_forserver(req,res,router, function (totalData, rutendatalists) {
        //返回的页面数据回调到路由
        return res_callback(req, res, totalData, router, rutendatalists)
    });
    return mservice_aggerateapi_forserver;
}

function res_callback(req, res, totalDataStr, router, rutendatalists) {
    let totalDataObj='';
    //多个字符串对象拼接成一个josn对象
    totalDataObj = JSON.parse(totalDataStr.replace(/}{/g, ','));
    //console.log('返回页面数据', totalDataObj);
    //console.log('返回页面', req.originalUrl);
    //console.log('返回组件', rutendatalists);
    //返回页面和数据
    //console.log(req.originalUrl.split("?")[0])
    let originurl=req.originalUrl.split("?")[0];
    res.render('.' +originurl, {
        pagedata: {
            "rutendatalists": rutendatalists,
            "totalData": totalDataObj
        }
    });
    return true;
}

module.exports = {
    page_data: page_data
};