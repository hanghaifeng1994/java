let superagent = require('superagent');
let EventProxy = require('eventproxy');
let pageList = require('../public/js/page_front.json');
let componentlist = require('../public/js/compoment_front.json');
let apinodes = require('../public/js/api_node');
const NodeCache = require('node-cache') ;   //cache模块
const myCache = new NodeCache();
global.siteMap = new Map();
//获取多个微服务的数据
//?pcode=sglistpage&papi=news.queryPageByCatIds&page=2&rows=4
function mservice_aggerateapi_forserver(req, res, route, data_callback) {
    let rutendatalists = rutendatalist(route, req);
    console.log(rutendatalists);
    let parameterHead = getparameterHead(req);
    //console.log('getparameterlsit',getparameterlsit);
    let strdata = '';
    //console.log('页面需要组件list:', rutendatalists);
    if (rutendatalists.stepushdata || rutendatalists.nosetapidata) {
        //获取EventProxy实例
        let ep = new EventProxy();
        //异步请求微服务数据
        let reqnums = 0;
        rutendatalists.stepushdata.forEach((a) => {
            if(a.curl!="")
            {
                reqnums++;
                let jsonstrdata = {}, key = a.ccode;
                let param = {
                    "header": parameterHead,
                    "payload": a.param
                };
                console.log(a.curl);
                console.log( JSON.stringify(param))
                //param=JSON.stringify(param);
                superagent
                    .post(a.curl)
                    .set('Content-Type', 'application/json')
                    .send(param)
                    .end(function (err, res) {
                        if (err) {
                            jsonstrdata[key] = 'err';
                        } else {
                            let jsonresdata = JSON.parse(res.text);
                            if (jsonresdata.success) {
                                jsonstrdata[key] = jsonresdata;
                            } else {
                                jsonstrdata[key] = 'err'
                            }
                            //console.log('jsonstrdata1', jsonstrdata)
                        }
                        jsonstrdata = JSON.stringify(jsonstrdata);
                        ep.emit(route, jsonstrdata);
                    })
            }
        });
        ep.after(route, reqnums, function (jsonstrdata) {
            //返回请求所有的data，取出数组中value拼成一个字符串
            jsonstrdata.forEach((a) => {
                strdata += a
            });
            let setapush = [];
            rutendatalists.stepushdata.forEach((a) => {
                if (!(a.chtml.slice(0, 15) == '../../../public')) {
                    a.chtml = '../../../public' + a.chtml;
                }
                setapush.push({
                    "chtml": a.chtml,
                    "ccode": a.ccode
                })
            });
            data_callback(strdata, setapush)
        });
    }
    else {
        res.render('404.html', {
            title: 'No Found'
        })
    }
}

function clone(a) {
    return JSON.parse(JSON.stringify(a));
}

function merge(o,newo) {
    let totalDataObj='';
    //多个字符串对象拼接成一个josn对象
    let totalDataStr = JSON.stringify(o)+JSON.stringify(newo);
    console.log(totalDataStr);
    totalDataObj = JSON.parse(totalDataStr.replace(/}{/g, ','));
    console.log(totalDataObj);
    return totalDataObj;
}

//通过路由匹配到返回那个页面数据
function rutendatalist(route, req) {
    let pcode = req.query.pcode;//页面指定组件码
    let papi = req.query.papi;//页面指定接口名
    route = route.substring(0, route.length - 5);
    let pagecomponentcodelist, stepushdata = [], nosetapidata = [];
    if (route == '/') route = 'index';
    pageList.forEach((a) => {
        if (route == a.pcode) pagecomponentcodelist = a.clist;
    });
    if (pagecomponentcodelist && pagecomponentcodelist.length)
        pagecomponentcodelist.forEach((ccode) => {
        let component=componentlist[ccode];
            if (ccode == component.ccode) {
                if (pcode == component.ccode) {
                    let papiArr;
                    if (papi)
                        papiArr = papi.split('.');
                    let newclone = clone(component);
                    if (papiArr.length == 2) {
                        newclone.curl = apinodes[papiArr[0]][papiArr[1]];//接口名称转接口地址
                    }
                    newclone.param = getparameterPayLoad(req);
                    stepushdata.push(newclone);
                } else if (ccode == component.ccode) {
                    if (component.curl) {
                        let curl = component.curl.split(".");
                        if (curl.length == 2) {
                            console.log(curl[0])
                            component.curl = apinodes[curl[0]][curl[1]];//接口名称转接口地址
                        }
                    }
                    //合并参数站点id参数
                    if(!component.param.siteId){
                        component.param = getparameterPayLoad(component.param,req)
                    }
                    stepushdata.push(component)
                }
            }
        });
    else
        stepushdata = null;
    return {
        "stepushdata": stepushdata,
    };
}
//保存数据到缓存
function setCache(cacheKey, cacheData){
    myCache.set(cacheKey, cacheData, function( err, success ){
        if(!err && success ){
            console.log('保存到缓存');
            console.log(cacheData)
        }
    });
}

function getCache(cacheKey,callback){
    myCache.get(cacheKey,function( err, value ){
        callback(value);
    });
}

//根据域名取得站点id
function getSiteIdbyDomain(req) {
    let domain = "localhost";//req.hostname ;
    //console.log(domain)
    if (domain == "") {
        domain = "";
    }
    let siteId = global.siteMap.get(domain);

    if (siteId!=undefined && siteId!="undefined") {
    } else {
        let pparam = {
            "header":
                {
                    "SESSION_TOKEN": "9625950758",
                    "UUID": "9625950758",
                    "CLIENT_OS": "O",
                    "REQ_TIME": "1535108439092",
                    "__account_id":"222"
                },
            "payload":
                {"siteDomain": domain}
        }

        //获取EventProxy实例
        let ep = new EventProxy();
        superagent
            .post("http://115.159.99.212:8861/base-service/login/anonLogin.do")
            .set('Content-Type', 'application/json')
            .send(pparam)
            .end(function (err, res) {
                let jsonstrdata="";
                if (err) {
                    jsonstrdata ="1";
                } else {
                    jsonstrdata = res.text;
                }
                ep.emit("getsite", jsonstrdata);
            });
        ep.after("getsite", 1, function (jsonstrdata) {
            //返回请求所有的data，取出数组中value拼成一个字符串
           // console.log(jsonstrdata+"jsonstrdata")
            siteId = "1";
            console.log("11-",siteId)
        });
        siteId = "1";
        console.log("22",siteId)
    }
    console.log("33",siteId)
    return siteId;
}

function getparameterHead(req) {
    let siteId = getSiteIdbyDomain(req);
    let curtime = Date.parse(new Date())+"";
    let getparameterdata = {
        "SESSION_TOKEN": "9625950758",
        "UUID": "9625950758",
        "CLIENT_OS": "O",
        "REQ_TIME": curtime,
        "SITE_ID":siteId
    };
    return getparameterdata
}

//站点换取token
function getparameterPayLoad(req) {
    let siteId = getSiteIdbyDomain(req);
    //将所有参数封装成json
    let newq = merge(req.query,{"siteId":siteId,"sites":siteId,"siteIds":siteId});
    return newq;
}

function getparameterPayLoad(oldparam,req) {
    let siteId = getSiteIdbyDomain(req);
    //将所有参数封装成json
    let newq = merge(oldparam,{"siteId":siteId,"sites":siteId});
    return newq;
}
module.exports = {
    mservice_aggerateapi_forserver: mservice_aggerateapi_forserver,
};