let superagent = require('superagent');
let EventProxy = require('eventproxy');
let apinodes = require('../public/js/api_node');

//获取多个微服务的数据
function frontmserviceapi(req, res, data_callback) {
    let requestParamData = JSON.parse(req.body.data);
    let requestParamDataheard = JSON.parse(req.body.heard);
    console.log('请求的参数数据:', requestParamDataheard);

    if (requestParamData.comParam.length) {
        let rutendatalists = rutendatalist(requestParamData);
        console.log('被重构的参数数据', rutendatalists);
        //获取EventProxy实例
        let ep = new EventProxy();
        let requestParamDataObjList = rutendatalists.stepushdata;
        ep.after("reqgroup", requestParamDataObjList.length, function (jsonstrdata) {
            let strdata = '[';
            //返回请求所有的data，取出数组中value拼成一个字符串
            let i = 0;
            jsonstrdata.forEach((a) => {
                i++;
                if (i == 1)
                    strdata += a;
                else
                    strdata += "," + a
            });
            //数据回调到路由模块
            data_callback(strdata + "]")
        });
        //异步请求微服务数据
        requestParamDataObjList.forEach((a) => {
            let param = {
                "header":requestParamDataheard.header,
                "payload":a.param
            };
            superagent
                .post(a.curl)
                .set('Content-Type', 'application/json')
                .send(param)
                .end(function (err, res) {
                    let jsonstrdata = {"ccode": a.ccode, "cdata": null};
                    if (err) {
                        jsonstrdata["cdata"] = 'err';
                    } else {
                        jsonstrdata["cdata"] = JSON.parse(res.text);
                    }
                    jsonstrdata = JSON.stringify(jsonstrdata);
                    ep.emit("reqgroup", jsonstrdata);
                })
        })
    }
}

//匹配请求接口
function rutendatalist(requestParamData) {
    let stepushdata = [], nosetapidata = [];
    requestParamData.comParam.forEach((data) => {
        if (data.curl) {
            let curl = data.curl.split(",");
            if (curl.length == 2) {
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