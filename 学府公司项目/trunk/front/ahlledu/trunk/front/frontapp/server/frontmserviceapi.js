let superagent = require('superagent');
let EventProxy = require('eventproxy');
let apinodes = require('../public/js/api_node');

//获取多个微服务的数据
function frontmserviceapi(req, res, data_callback) {
    let requestParamData = req.body.data;
    let requestParamDataheader = req.body.header;
    console.log('请求的参数数据:', requestParamDataheader);

    if (requestParamData.comParam.length) {
        let returndatalists = returndatalist(requestParamData);
        console.log('被重构的参数数据', returndatalists);
        //获取EventProxy实例
        let ep = new EventProxy();
        let requestParamDataObjList = returndatalists.stepushdata;
        ep.after("reqgroup", requestParamDataObjList.length, function (jsonstrdata) {
            let strdata ='';
            //返回请求所有的data，取出数组中value拼成一个字符串
            jsonstrdata.forEach((a) => {
                strdata+=a;
            });
            //数据回调到路由模块
            strdata = JSON.parse(strdata.replace(/}{/g, ','));
            console.log("strdata-",strdata)
            data_callback(strdata)
        });
        //异步请求微服务数据
        requestParamDataObjList.forEach((a) => {
            let param = {
                "header":requestParamDataheader.header,
                "payload":a.param
            };
            superagent
                .post(a.curl)
                .set('Content-Type', 'application/json')
                .send(param)
                .end(function (err, res) {
                    let jsonstrdata = {};
                    jsonstrdata[a.ccode]=null;
                    if (err) {
                        jsonstrdata[a.ccode] = 'err';
                    } else {
                        jsonstrdata[a.ccode] = JSON.parse(res.text);
                    }
                    jsonstrdata = JSON.stringify(jsonstrdata);
                    ep.emit("reqgroup", jsonstrdata);
                })
        })
    }
}

//匹配请求接口
function returndatalist(requestParamData) {
    let stepushdata = [], nosetapidata = [];
    requestParamData.comParam.forEach((data) => {
        if (data.curl) {
            let curl = data.curl.split(".");
            if (curl.length == 2&&curl.slice(0,4)!='http') {
                data.curl = apinodes[curl[0]][curl[1]];
            }
            stepushdata.push(data)
        } else {
            nosetapidata.push(data)
        }
    });
    return {
        "stepushdata": stepushdata,
        "nosetapidata": nosetapidata
    };
}

module.exports = {
    frontmserviceapi: frontmserviceapi,
};