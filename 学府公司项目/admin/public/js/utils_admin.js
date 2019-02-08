(function (window, $) {
    //侧边栏配置
    var jsonpage = {
        "img": '../public/img/32-32.png',
        "text": '后台管理',
        "navarr": [
            {
                "id": "0",
                "type": "0",
                "text": "用户管理",
                "icon": "nc-icon nc-circle-09",
                "chaildarr": [
                    {
                        "url": "#/usernumber",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "管理员账号管理",
                    },
                    {
                        "url": "#/userlogin",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "注册用户账号管理",
                    },
                    {
                        "url": "#/userrole",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "角色管理",
                    }
                ]
            },
            {
                "id": "1",
                "url": "#/muchgerent",
                "icon": "nc-icon nc-vector",
                "text": "站群管理",
                "type": "1",
            },
            {
                "id": "2",
                "type": "0",
                "text": "信息发布管理",
                "icon": "nc-icon nc-bullet-list-67",
                "chaildarr": [
                    {
                        "url": "#/messagegerent",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资讯管理",
                    },
                    {
                        "url": "#/messagecolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资讯栏目管理",
                    },
                    {
                        "url": "#/messageinform",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "通知管理",
                    }, {
                        "url": "#/messagenoticecolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "通知栏目管理",
                    },
                    {
                        "url": "#/messagehelp",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "帮助管理",
                    }, {
                        "url": "#/messagehelpcolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "帮助栏目管理",
                    }
                ]
            },
            {
                "id": "3",
                "type": "0",
                "text": "首页管理",
                "icon": "nc-icon nc-paper-2",
                "chaildarr": [
                    {
                        "url": "#/indexlink",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "友情链接管理",
                    },
                    {
                        "url": "#/indexbanner",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "banner图管理",
                    },
                    {
                        "url": "#/indeximages",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "广告位图片管理",
                    }
                ]
            },
            {
                "id": "4",
                "icon": "nc-icon nc-single-copy-04",
                "text": "资源管理",
                "type": "0",
                "chaildarr": [
                    {
                        "url": "#/resource",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资源管理",
                    },
                    {
                        "url": "#/classifyresource",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资源分类管理",
                    }
                ]
            },
            {
                "id": "5",
                "icon": "nc-icon nc-backpack",
                "text": "课程管理",
                "type": "0",
                "chaildarr": [
                    {
                        "url": "#/course",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "课程管理",
                    },
                    {
                        "url": "#/classifycourse",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "课程分类管理",
                    }
                ]
            },
            {
                "type": "0",
                "text": "证书管理",
                "icon": "nc-icon nc-credit-card",
                "id": "6",
                "chaildarr": [
                    {
                        "url": "#/certificategecolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "证书管理",
                    },
                    {
                        "url": "#/classifycertify",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "证书分类管理",
                    }
                ]
            },
            {
                "type": "0",
                "text": "活动管理",
                "icon": "nc-icon nc-air-baloon",
                "id": "7",
                "chaildarr": [
                    {
                        "url": "#/activitygecolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动管理",
                    },
                    {
                        "url": "#/classifyactivity",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动分类管理",
                    },
                ]
            },
            {
                "type": "0",
                "text": "网上报名管理",
                "icon": "nc-icon nc-tv-2",
                "id": "8",
                "chaildarr": [
                    {
                        "url": "#/applygrade",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "班级管理",
                    },
                    {
                        "url": "#/classifygrade",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "班级分类管理",
                    }
                ]
            },
            {
                "id": "9",
                "icon": "nc-icon nc-ruler-pencil",
                "text": "学习小组管理",
                "type": "0",
                "chaildarr": [
                    {
                        "url": "#/studygroup",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "学习小组管理",
                    },
                    {
                        "url": "#/classifygroup",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "学习小组分类管理",
                    }
                ]
            },
            {
                "id": "10",
                "type": "0",
                "text": "才艺&经验管理",
                "icon": "nc-icon nc-palette",
                "chaildarr": [
                    {
                        "url": "#/acquirement",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "才艺管理",
                    },
                    {
                        "url": "#/classifyacquirement",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "才艺分类管理",
                    },
                    {
                        "url": "#/undergo",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "经验管理",
                    },
                    {
                        "url": "#/classifyundergo",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "经验分类管理",
                    }
                ]
            },
            {
                "id": "11",
                "type": "0",
                "text": "订单管理",
                "icon": "nc-icon nc-align-center",
                "chaildarr": [
                    {
                        "url": "#/indentlist",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "订单列表",
                    },
                    {
                        "url": "#/indentinfo",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "订单统计",
                    }
                ]
            },
            {
                "id": "12",
                "type": "0",
                "text": "题库管理",
                "icon": "nc-icon nc-caps-small",
                "chaildarr": [
                    {
                        "url": "#/questiongerent",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "题库管理",
                    },
                    {
                        "url": "#/knowledgegerent",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "知识点管理",
                    }
                ]
            },
            {
                "id": "13",
                "type": "0",
                "text": "考核管理",
                "icon": "nc-icon nc-button-play",
                "chaildarr": [
                    {
                        "url": "#/assesswork",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "作业管理",
                    },
                    {
                        "url": "#/assessissue",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "测验管理",
                    }
                ]
            },
            {
                "id": "14",
                "type": "0",
                "text": "学员互动管理",
                "icon": "nc-icon nc-chat-round",
                "chaildarr": [
                    {
                        "url": "#/interactwork",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "作业反馈管理",
                    },
                    {
                        "url": "#/interactproduct",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动作品管理",
                    },

                    {
                        "url": "#/interactcomment",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "评论管理",
                    },
                    {
                        "url": "#/interactstop",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "禁言管理",
                    }
                ]
            },
            {
                "id": "15",
                "type": "0",
                "text": "积分管理",
                "icon": "nc-icon nc-money-coins",
                "chaildarr": [
                    {
                        "url": "#/integralstudent",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "学员积分",
                    },
                    {
                        "url": "#/integralrule",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "积分规则",
                    }
                ]
            },
            {
                "id": "16",
                "url": "#/datastatistics",
                "icon": "nc-icon nc-chart-pie-35",
                "text": "统计数据",
                "type": "1",
            }
        ]
    };
    var restspage = [
        {
            "parent": "muchgerent",
            "url": "muchadd",
            "text": "创建站点",
        },
        {
            "parent": "certificate",
            "url": "certificate",
            "text": "证书添加",
        },
        {
            "parent": "apply",
            "url": "applyadd",
            "text": "班级添加",
        },
        {
            "parent": "activity",
            "url": "activityadd",
            "text": "活动添加",
        },
        {
            "parent": "/",
            "url": "/",
            "text": "总揽"
        },
        {
            "parent": "usernumber",
            "url": "addusernumber",
            "text": "管理员账号管理",
        },
        {
            "parent": "userrole",
            "url": "adduserrole",
            "text": "角色管理"
        },
        {
            "parent": "userrole",
            "url": "adduserlogin",
            "text": "用户管理"
        },
        {
            "parent": "messagegerent",
            "url": "addmessagegerent",
            "text": "资讯管理"
        },
        {
            "parent": "messageinform",
            "url": "addmessageinform",
            "text": "通知管理"
        },
        {
            "parent": "indexlink",
            "url": "addindexlink",
            "text": "友情链接新增"
        },
        {
            "parent": "indexbanner",
            "url": "addindexbanner",
            "text": "banner图管理"
        },
        {
            "parent": "indeximages",
            "url": "addindeximages",
            "text": "广告位图片管理"
        },
        {
            "parent": "resource",
            "url": "addresource",
            "text": "资源管理"
        },
        {
            "parent": "resource",
            "url": "addbatchresource",
            "text": "资源管理"
        },
        {
            "parent": "course",
            "url": "addcourse",
            "text": "课程管理"
        },
        {
            "parent": "course",
            "url": "uploadactivitygecolumn",
            "text": "成果上传"
        },
        {
            "parent": "course",
            "url": "courseapplygrade",
            "text": "课程管理"
        },
        {
            "parent": "course",
            "url": "editsections",
            "text": "编辑课程章节"
        },
        {
            "parent": "course",
            "url": "addcourseapplygrade",
            "text": "添加课程"
        },
        {
            "parent": "questiongerent",
            "url": "addlibrary",
            "text": "新增题库"
        },
        {
            "parent": "questiongerent",
            "url": "addquestiongerent",
            "text": "新增题目"
        },
        {
            "parent": "assesswork",
            "url": "addassesswork",
            "text": "发布作业"
        },
        {
            "parent": "assessissue",
            "url": "addassessissue",
            "text": "新增测验"
        },
        {
            "parent": "assessissue",
            "url": "installassessissue",
            "text": "考核设置"
        },
        {
            "parent": "indentlist",
            "url": "lookindentlist",
            "text": "查看订单"
        },
        {
            "parent": "indentlist",
            "url": "checkindentlist",
            "text": "线下支付审核"
        },
        {
            "parent": "undergo",
            "url": "checkundergo",
            "text": "经验审核"
        },
        {
            "parent": "acquirement",
            "url": "checkacquirement",
            "text": "才艺审核"
        },
        {
            "parent": "studygroup",
            "url": "checkstudygroup",
            "text": "学习小组审核"
        },
        {
            "parent": "studygroup",
            "url": "checkstudygroup",
            "text": "学习小组审核"
        },
        {
            "parent": "interactwork",
            "url": "comment",
            "text": "作业批阅",
        },
        {
            "parent": "assessissue",
            "url": "grouplist",
            "text": "组卷规则列表",
        },
        {
            "parent": "assessissue",
            "url": "addgrouplist",
            "text": "新增组卷",
        },
        {
            "parent": "questiongerent",
            "url": "topic",
            "text": "题目列表",
        },
        {
            "parent": "knowledgegerent",
            "url": "addknowledgegerent",
            "text": "新增知识点",
        },
        {
            "parent": "messagehelp",
            "url": "addmessagehelp",
            "text": "新增通知",
        }, {
            "parent": "messagehelpcolumn",
            "url": "messagehelpcolumnadd",
            "text": "帮助分类",
        }, {
            "parent": "messagenoticecolumn",
            "url": "messagenoticecolumnadd",
            "text": "通知分类",
        }, {
            "parent": "activitygecolumn",
            "url": "activityaudit",
            "text": "活动审核",
        }, {
            "parent": "gecolumn",
            "url": "activityRstaudit",
            "text": "活动成果审核",
        }, {
            "parent": "gecolumn",
            "url": "activityRstAdd",
            "text": "活动成果新增",
        }, {
            "parent": "studygroup",
            "url": "studygroupaudit",
            "text": "学习小组审核",
        }, {
            "parent": "studygroup",
            "url": "studygroupadd",
            "text": "学习小组新增",
        }, {
            "parent": "classifygroup",
            "url": "studygroupcateAdd",
            "text": "学习小组分类新增",
        }, {
            "parent": "knowledgegerent",
            "url": "knowledgegerentadd",
            "text": "知识点新增",
        },
        {
            "parent": "all",
            "url": "addclass",
            "text": "编辑",
        },
        {
            "parent": "gecolumn",
            "ur;": "gecolumn",
            "text": "成果上传"
        }
    ];
    var routuhtml = './template';
    var pagehtml = './page/';


    //引入侧边栏
    function Router() {
        this.routes = {};
        this.currentUrl = '';
    }

    Router.prototype.route = function (path, callback) {
        this.routes[path] = callback || function () {
        };//给不同的hash设置不同的回调函数
    };
    Router.prototype.refresh = function () {
        this.currentUrl = location.hash.slice(1) || '/';//如果存在hash值则获取到，否则设置hash值为/
        if (this.currentUrl) {
            this.routes[this.currentUrl]();//根据当前的hash值来调用相对应的回调函数
        }
    };
    Router.prototype.init = function () {
        window.addEventListener('load', this.refresh.bind(this), false);
        window.addEventListener('hashchange', this.refresh.bind(this), false);
    };
    //给window对象挂载属性
    window.Router = new Router();
    window.Router.init();


    class utils_admin {
        constructor() {
            this.name = 'utils_admin'
        };


        //ajax请求 setajax('POST','data','url')
        setajax(...a) {
            var dataz, timestamp = +new Date();
            if (a[1].header) {
                a[1].header.REQ_TIME = "" + timestamp + "";
                a[1] = JSON.stringify(a[1]);
            }
            $.ajax({
                url: a[2],
                type: a[0],
                async: false,
                contentType: "application/json",
                data: a[1],
                success(res) {
                    console.log(res)
                    dataz = res
                },
                error(res) {
                    console.log(res);
                    dataz = res
                }
            });
            return dataz;
        };

        //load引入 loadhtml($('#xx'),'url','data')
        loadhtml(...a) {
            if (a[1].slice(a[1].index, 1) == '/') {
                temp_page(routuhtml);
            } else {
                temp_page(pagehtml);
            }

            function temp_page(page) {
                $.ajaxSetup({
                    cache: false
                });
                a[0].children().remove();
                a[0].load(page + a[1], function (e) {
                    if (a[2]) {
                        a[0].html(window.template.render(e, a[2]))
                    } else {
                        return 0
                    }
                });
            }
        };

        //表格渲染 queryPage(挂载的节点,摸板名,数据)
        queryPage(phtml, htmlt, data) {
            $("#" + phtml + "").html(template(htmlt, data))
        }

        //上传图片
        setimg(input, canvas, imgdata, postdata) {
            input.addEventListener('change', function (e) {
                readFile(this, imgdata)
            }, false);

            function readFile(that, setdata) {
                var file = that.files[0];//获取上传文件列表中第一个文件
                var formData = new FormData();
                var type = (file.name.substr(file.name.lastIndexOf("."))).toLowerCase();
                if (type != ".png" && type != ".gif" && type != ".jpg") {
                    alert("文件必须为图片！");
                    return false;
                }
                formData.append("file", file);
                postdata ? postdata.payload.photo = 0 : apidata.postdata.payload.photo = 0;
                $.ajax({
                    url: window.apidata.file.pic,
                    type: 'POST',
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: setdata,
                    error: function (e) {
                        alert("上传失败");
                        return false;
                    }
                });
            }
        }

        //图片回填 returnimg(node,url)
        returnimg(canvas, url) {
            var img = new Image();
            img.src = url;
            $(canvas).html(img);
            $(canvas).children().css({width: "150px", height: "150px"})
        }

        //传入图片路径getBase64("http://xxxx","cvstwo")
        getBase64(img, cvs) {
            function getBase64Image(img) {
                var canvas = document.getElementById(cvs);
                var ctx = canvas.getContext("2d");
                ctx.drawImage(img, 0, 0, 150, 150);
            }

            var image = new Image();
            image.crossOrigin = '';
            image.src = img;
            var deferred = $.Deferred();
            if (img) {
                image.onload = function () {
                    deferred.resolve(getBase64Image(image));//将base64传给done上传处理
                };
                return deferred.promise();//问题要让onload完成后再return sessionStorage['imgTest']
            }
        }

        //日历  window.utils_admin.calendar($('.datepicker'));
        calendar(datepicker) {
            datepicker.datetimepicker({
                format: 'YYYY/MM/DD',
                icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa fa-chevron-up",
                    down: "fa fa-chevron-down",
                    previous: 'fa fa-chevron-left',
                    next: 'fa fa-chevron-right',
                    today: 'fa fa-screenshot',
                    clear: 'fa fa-trash',
                    close: 'fa fa-remove'
                }
            });
        };


        //请求多接口,返回josn     window.utils_admin.eventproxy([{"url":"","param":{},"name":}]);
        eventproxy(apisetdata) {
            let strdata = '', data = {};
            apisetdata.forEach((a) => {
                strdata = this.setajax('POST', a.param, a.url);
                data[a.name] = strdata
            });
            return data
        };

        lohspage(...a) {
            return a[1][a[0].slice(2, a[0].length)]
        };

        logout() {
            this.delCookie('ahll_m_user');
            this.delCookie('ahll_m_user_name');
        }

        cookieLogin() {
            let postadata = null;
            if (this.getCookie('ahll_m_user')) {
                postadata = JSON.parse(localStorage.getItem("ahll_m_user_postdata"));
                let initpostdata = JSON.parse(localStorage.getItem("ahll_m_user_postdata"));
                apidata.postdata = postadata;
                apidata.initpostdata = initpostdata;
            }
            return postadata;
        };

        getLoginName() {
            let cname = this.getCookie('ahll_m_user_name');
            if (cname) {
                return cname;
            } else
                return "匿名";
        }

        //克隆对象
        clone(myObj) {
            if (typeof(myObj) != 'object') return myObj;
            if (myObj == null) return myObj;

            var myNewObj = new Object();

            for (var i in myObj)
                myNewObj[i] = this.clone(myObj[i]);

            return myNewObj;
        }

        //设置cookie
        setCookie(name, value, day) {
            var date = new Date();
            date.setDate(date.getDate() + day);
            if (day == 0)
                document.cookie = name + '=' + value;
            else
                document.cookie = name + '=' + value + ';expires=' + date;
        };

        //获取cookie
        getCookie(name) {
            var reg = RegExp(name + '=([^;]+)');
            var arr = document.cookie.match(reg);
            if (arr) {
                return arr[1];
            } else {
                return '';
            }
        };

        //删除cookie
        delCookie(name) {
            this.setCookie(name, null, -1);
        }

        //列表中编辑  redact(跳转后缀,参数,this)
        redact(url, name, data) {
            data = data.dataset.id;
            window.apidata.postdata.payload[name] = data;
            localStorage.setItem("ahll_m_user_postdata", JSON.stringify(window.apidata.postdata));
            window.location.href = "/admin/views/index.html#/" + url + "";
        }

        //删除参数
        delpostdata(...a) {
            a.forEach((code) => {
                window.apidata.postdata.payload[code] = "";
            });
            localStorage.setItem("ahll_m_user_postdata", JSON.stringify(window.apidata.postdata));
        }

        //批量操作返回选中的id
        choosevalue(a) {
            let choosevalue = "";
            let inputdata = $("#" + a + " input[name='choose']:checked");
            if (inputdata.length <= 0) {
                return false;
            }
            let i = 0;
            $(inputdata).each(function () {
                choosevalue += this.value + ",";
                i++;
            });
            return choosevalue
        }

        //下拉框返回选中id
        downid(that, node) {
            let id = '';
            if (that.target.nodeName.toLowerCase() == "li") {
                id = that.target.getAttribute("id")
            } else {
                id = $("." + node + " input")[0].id
            }
            return id
        }

        //下拉框配置数据loop(data,"id","text")
        loop(...a) {
            let dataarr = [];
            a[0].forEach((e, index) => {
                dataarr.push(e);
                dataarr[index].id = e[a[1]];
                dataarr[index].text = e[a[2]];
            });
            return dataarr;
        }

        //新增栏目
        addclass(a) {
            localStorage.setItem("ahll_class", JSON.stringify(a));
            window.location.href = "/admin/views/index.html#/addclass";
        }
    }

    $.ajaxSetup({
        cache: false
    });

    window.jsonpage = jsonpage;
    window.restspage = restspage;
    window.utils_admin = new utils_admin();


})(window, window.$);

(function ($, window, document, undefined) {
    var $html = $('html');
    $html.off('click.ui.dropdown').on('click.ui.dropdown', '.js-dropdown', function (e) {
        e.preventDefault();
        $(this).toggleClass('is-open');
    });

    $html.on('click.ui.dropdown', '.js-dropdown [data-dropdown-value]', function (e) {
        e.preventDefault();
        var $item = $(this);
        var $dropdown = $item.parents('.js-dropdown');
        $dropdown.find('.js-dropdown__input').val($item.data('dropdown-value'));
        $dropdown.find('.js-dropdown__current').text($item.text());
    });

    $html.on('click.ui.dropdown', function (e) {
        var $target = $(e.target);
        if (!$target.parents().hasClass('js-dropdown')) {
            $('.js-dropdown').removeClass('is-open');
        }
    });
})(jQuery, window, document);