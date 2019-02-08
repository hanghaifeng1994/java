(function (window, $) {
    var aggregateUrl = "http://127.168.0.1:3000/componentlistdata",
        compomenturl = "/js/compoment_front.json",
        pageurl = "/js/page_front.json",
        pagelist = '',
        componentlist = '',
        htmldata = [];

    //删除指定数组值
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        while(index>-1){
            this.splice(index, 1);
            index = this.indexOf(val);
        }
    };

    //请求接口 getdata(type, datatype, url, data, setdata)
    function getdata(type, datatype, url, data, setdata) {
        if (data) {
            if (data.header) {
                var timestamp = Date.parse(new Date());
                data.header.REQ_TIME = "" + timestamp + "";
                data = JSON.stringify(data)
            }
        }
        //alert(url)
        //alert(data)
        $.ajax({
            type: type,
            dataType: datatype,
            url: url,
            data: data,
            async: false,
            contentType: "application/json",
            success: function (res) {
                console.log(res,"----success")
                setdata = res
            },
            error: function (res) {
                console.log(res,"----error")
                setdata = res
            }
        });
        return setdata
    }

    //返回当前页面的组件list
    function getComponentofPage(pageCode) {
        pagelist = getdata("GET", "json", pageurl);
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
        console.log(ccode)
        if (componentlist[ccode].ccode == ccode) {
            return componentlist[ccode]
        }
    }

    //返回当前页面组件
    function loadPage(pageCode) {
        var pageClist = getComponentofPage(pageCode);
        var componentlist = getdata("GET", "json", compomenturl);
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
        var paramStr = comParamJson;
        let curtime = Date.parse(new Date())+"";
        var header = {
            "header":
                {
                    "SESSION_TOKEN": "4811261689",
                    "UUID": "4811261689",
                    "CLIENT_OS": "O",
                    "REQ_TIME": curtime,
                    "__account_id":"222"
                }
        };
        handleResData(getdata("POST", "json", aggregateUrl, JSON.stringify({
            "header": header,
            "data": paramStr
        })))
    }

    function getHeader(isLogin){
        var header = {
            "SESSION_TOKEN": "6348187417",
            "UUID": "6348187417",
            "CLIENT_OS": "O",
            "__account_id":"222",
            "REQ_TIME": "234234234"
        }
        return header;
    }

    function getCurrentUser(){
        return "2";
    }
    //取出node端返回的组件id和组件data
    function handleResData(resDataList) {
        var resDataListObj = resDataList.totalData.data; //JSON.parse(resDataList);
        console.log("1111-",resDataListObj)

        var cdataObj = null;
        var i = 0;
        for ( i in resDataListObj) {
            cdataObj = resDataListObj[i];
            console.log("templdatedata--",cdataObj)
            setData(i, cdataObj, htmldata[i]);
        }
    }

    //用数据渲染页面
    function setData(ccode, jsonCData, htmldata) {
        var htmls = htmldata || $("#"+ccode+"_t").html();
        console.log(htmls)
        console.log("dsfd---",jsonCData)
        $("#" + ccode + "_phtml").html(window.template.render($("#" + ccode + "_t").html(), jsonCData))
    }

    //取出地址栏参
    function setloacn(style) {

        var url =window.location.pathname+window.location.search;
        url=url.toLowerCase();
        var aherf= $("a");
       for(var i=0;i<aherf.length;i++){
           var documta=$(aherf[i]);
           if(documta.attr("href").toLowerCase()==url){
               documta.parent().siblings().removeClass(style)
               documta.parent().addClass(style)
           }
       }
    }

    function Utils() {
    }

    Utils.prototype = {
        loadPage: loadPage,
        sendRequest: sendRequest,
        getdata: getdata,
        setloacn:setloacn,
        getHeader:getHeader,
        getCurrentUser:getCurrentUser
    };
    window.utils = new Utils();
})(window, window.$);