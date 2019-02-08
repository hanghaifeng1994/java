(function (window, $) {
    var aggregateUrl = "http://127.168.0:3000/componentlistdata",
        compomenturl = "/js/compoment_front.json",
        pageurl = "/js/page_front.json",
        pagelist = '',
        componentlist = '',
        htmldata = [];

    //请求多接口,返回josn  eventproxy([{"url":"","param":{},"name":}]);
    function eventproxy(apisetdata) {
        var data = {};
        for (var i = 0; i < apisetdata.length; i++) {
            data[apisetdata[i].name] = getdata(true, 'POST', apisetdata[i].param, apisetdata[i].url, apisetdata[i].data)
        }
        return data
    }


    //请求接口 getdata(async,type, datatype, url, data, setdata)
    function getdata(async, type, datatype, url, data, setdata) {
        if (data) {
            if (data.header) {
                var timestamp = Date.parse(new Date());
                data.header.REQ_TIME = "" + timestamp + "";
                data = JSON.stringify(data);
            }

        }
        $.ajax({
            type: type,
            dataType: datatype,
            url: url,
            data: data,
            async: async,
            success: function (a) {
                setdata = a
            }
        });
        return setdata
    }

    //返回当前页面的组件list
    function getComponentofPage(pageCode) {
        pagelist = getdata(false, "GET", "json", pageurl);
        var pageObj = null;
        for (var i = 0; i < pagelist.length; i++) {
            pageObj = pagelist[i];
            if (pageObj.pcode == pageCode) {
                return pageObj.clist;
            }
        }
    }

    //返回组件属性
    function getComponentObj(ccode, componentlist) {
        var cObj = null;
        for (var i = 0; i < componentlist.length; i++) {
            cObj = componentlist[i];
            if (cObj.ccode == ccode) {
                return cObj;
            }
        }
    }

    //返回当前页面组件
    function loadPage(pageCode) {
        var pageClist = getComponentofPage(pageCode);
        var componentlist = getdata(false, "GET", "json", compomenturl);
        console.log('当前页的组件list', pageClist);
        var paramArr = [];
        var comParamJson = {}; //当前页的组件对象
        for (var i = 0; i < pageClist.length; i++) {
            var cobj = getComponentObj(pageClist[i], componentlist);
            console.log('组件属性', cobj);
            var tempParam = {
                "ccode": cobj.ccode,
                "curl": cobj.curl,
                "param": cobj.param
            };
            paramArr.push(tempParam);
            console.log('获取挂载的node', "#" + cobj.ccode + "_phtml");
            console.log('引入的组件', cobj.chtml);
            //引入组件摸板
            $("#" + cobj.ccode + "_phtml").load(cobj.chtml, function (a) {
                htmldata.push(a)
            });
        }
        comParamJson["comParam"] = paramArr;
        return comParamJson;
    }

    //发送聚合接口数据到node端
    function sendRequest(comParamJson) {
        var paramStr = JSON.stringify(comParamJson);
        var header = JSON.stringify({
            "header":
                {
                    "SESSION_TOKEN": "4692931360",
                    "UUID": "4692931360",
                    "CLIENT_OS": "O",
                    "REQ_TIME": "1535082585083"
                }
        });
        handleResData(getdata(false, "POST", "application/json", aggregateUrl, {
            "heard":header,
            "data": paramStr
        }))
    }

    //取出node端返回的组件id和组件data
    function handleResData(resDataList) {
        var resDataListObj = resDataList; //JSON.parse(resDataList);
        var cdataObj = null;
        for (var i = 0; i < resDataListObj.length; i++) {
            cdataObj = resDataListObj[i];
            setData(cdataObj.ccode, cdataObj.cdata, htmldata[i]);
        }
    }

    //用数据渲染页面
    function setData(ccode, jsonCData, htmldata) {
        console.log(ccode, jsonCData);
        console.log($("#" + ccode + "_chtml"));
        $("#" + ccode + "_chtml").html(htmldata || window.template.render($("#" + ccode + "_t").html(), jsonCData))
    }

    function Utils() {
    }

    Utils.prototype = {
        loadPage: loadPage,
        sendRequest: sendRequest,
        getdata: getdata,
        eventproxy: eventproxy
    };
    window.utils = new Utils();
})(window, window.$);