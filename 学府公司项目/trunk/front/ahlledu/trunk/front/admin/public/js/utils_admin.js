(function (window, $) {
    //侧边栏配置
    var jsonpage = {
        "img": '',
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
                "type": "0",
                "text": "站群管理",
                "icon": "nc-icon nc-vector",
                "chaildarr": [
                    {
                        "url": "#/muchgerent",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "站群管理",
                    },
                    {
                        "url": "#/muchadd",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "创建站点",
                    }
                ]
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
                        "api": [{
                            "url": window.apidata.news.queryPage,
                            "param": window.apidata.postdata,
                            "name": "queryPage"
                        }, {
                            "url": window.apidata.news.newsCategoryqueryShowPage,
                            "param": window.apidata.postdata,
                            "name": "newsCategoryqueryShowPage"
                        }, {
                                "url": window.apidata.news.lowerSendPage,
                                "param": window.apidata.postdata,
                                "name": "lowerSendPage"
                            },
                        ]
                    },
                    {
                        "url": "#/messagecolumn",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资讯栏目管理",
                        "api": [{
                            "url": window.apidata.news.newsCategoryqueryPage,
                            "param": window.apidata.postdata,
                            "name": "queryPage"
                        }]
                    },
                    {
                        "url": "#/messageinform",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "通知管理",
                    },
                    {
                        "url": "#/messagehelp",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "帮助管理",
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
                "url": "#/resource",
                "icon": "nc-icon nc-single-copy-04",
                "text": "资源管理",
                "type": "1",
            },
            {
                "id": "5",
                "url": "#/course",
                "icon": "nc-icon nc-backpack",
                "text": "课程管理",
                "type": "1",
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
                        "url": "#/certificateadd",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "证书添加",
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
                        "url": "#/activityadd",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动添加",
                    }
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
                        "url": "#/applyadd",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "班级添加",
                    }
                ]
            },
            {
                "id": "9",
                "url": "#/studygroup",
                "icon": "nc-icon nc-ruler-pencil",
                "text": "学习小组管理",
                "type": "1",
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
                        "url": "#/undergo",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "经验管理",
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
                        "text": "组卷管理",
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
                        "url": "#/interactachievement",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动成果管理",
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
                "type": "0",
                "text": "分类管理",
                "icon": "nc-icon nc-notes",
                "chaildarr": [
                    {
                        "url": "#/classifyresource",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "资源分类管理",
                    },
                    {
                        "url": "#/classifycourse",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "课程分类管理",
                    },
                    {
                        "url": "#/classifycertify",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "证书分类管理",
                    },
                    {
                        "url": "#/classifyactivity",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "活动分类管理",
                    },
                    {
                        "url": "#/classifygroup",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "学习小组分类管理",
                    },
                    {
                        "url": "#/classifygrade",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "班级分类管理",
                    },
                    {
                        "url": "#/classifyacquirement",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "才艺分类管理",
                    },
                    {
                        "url": "#/classifyundergo",
                        "icon": "nc-icon nc-preferences-circle-rotate w-25",
                        "text": "经验分类管理",
                    }
                ]
            },
            {
                "id": "17",
                "url": "#/datastatistics",
                "icon": "nc-icon nc-chart-pie-35",
                "text": "统计数据",
                "type": "1",
            },
            {
                "id": "18",
                "url": "#/databasics",
                "icon": "nc-icon nc-chart-bar-32",
                "text": "基础数据管理",
                "type": "1",
            },
            {
                "id": "19",
                "url": "#/install",
                "icon": "nc-icon nc-settings-90",
                "text": "平台配置",
                "type": "1",
            }
        ]
    };
    var restspage = [
        {
            "parent": "/",
            "url": "/",
            "text": "总揽"
        },
        {
            "parent": "usernumber",
            "url": "addusernumber",
            "text": "管理员账号管理",
            "apiurl": window.apidata
        },
        {
            "parent": "userrole",
            "url": "adduserrole",
            "text": "角色管理"
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
            "text": "友情链接管理"
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
            "url": "addcourseapplygrade",
            "text": "添加课程"
        },
        {
            "parent": "questiongerent",
            "url": "addquestiongerent",
            "text": "添加试题"
        },
        {
            "parent": "assesswork",
            "url": "addassesswork",
            "text": "发布作业"
        },
        {
            "parent": "assessissue",
            "url": "addassessissue",
            "text": "自动组卷"
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

    //

    class utils_admin {
        constructor() {
            this.name = 'utils_admin'
        };

        //ajax请求 setajax('POST','data','url')
        setajax(...a) {
            var dataz, timestamp = Date.parse(new Date());
            a[1].header.REQ_TIME = "" + timestamp + "";
            console.log(a[0], a[1], a[2]);
            a[1] = JSON.stringify(a[1]);
            $.ajax({
                url: a[2],
                type: a[0],
                async: false,
                contentType: "application/json",
                data: a[1],
                success(res) {
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
                // console.log(page + a[1]);
                $.ajaxSetup({
                    cache: false
                });
                $(a[0]).children().detach();
                a[0].load(page + a[1], function (e) {
                    if (a[2]) {
                        //console.log(window.template.render(e, a[2]))
                        a[0].html(window.template.render(e, a[2]))
                        //console.log(window.template.render(e, a[2]))
                    } else {
                        return 0
                    }
                });
            }
        };

        //表格渲染 queryPage(挂载的节点,摸板名,数据)
        queryPage(phtml,htmlt,data) {
            $("#"+phtml+"").html(template(htmlt,data))
        }
        //上传图片
        setimg(input, canvas) {
            if (typeof FileReader === 'undefined') {
                //result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
                input.setAttribute('disabled', 'disabled');
            } else {
                input.addEventListener('change', readFile, false);
                /*input.addEventListener('change',function (e){
                    console.log(this.files);//上传的文件列表
                },false); */
            }

            function readFile() {
                var file = this.files[0];//获取上传文件列表中第一个文件
                if (!/image\/\w+/.test(file.type)) {
                    //图片文件的type值为image/png或image/jpg
                    alert("文件必须为图片！");
                    return false;
                }
                // console.log(file);
                var reader = new FileReader();//实例一个文件对象
                reader.readAsDataURL(file);//把上传的文件转换成url
                //当文件读取成功便可以调取上传的接口
                reader.onload = function (e) {
                    console.log(e)
                    // console.log(this.result);//文件路径
                    // console.log(e.target.result);//文件路径
                    /*var data = e.target.result.split(',');
                    var tp = (file.type == 'image/png')? 'png': 'jpg';
                    var imgUrl = data[1];//图片的url，去掉(data:image/png;base64,)
                    //需要上传到服务器的在这里可以进行ajax请求
                    // console.log(imgUrl);
                    // 创建一个 Image 对象
                    var image = new Image();
                    // 创建一个 Image 对象
                    // image.src = imgUrl;
                    image.src = e.target.result;
                    image.onload = function(){
                        document.body.appendChild(image);
                    }*/

                    var image = new Image();
                    // 设置src属性
                    image.src = e.target.result;
                    var max = 150;
                    // 绑定load事件处理器，加载完成后执行，避免同步问题
                    image.onload = function () {
                        // 获取 canvas DOM 对象
                        // 如果高度超标 宽度等比例缩放 *=
                        /*if(image.height > max) {
                            image.width *= max / image.height;
                            image.height = max;
                        } */
                        // 获取 canvas的 2d 环境对象,
                        var ctx = canvas.getContext("2d");
                        // canvas清屏
                        ctx.clearRect(0, 0, canvas.width, canvas.height);
                        // 重置canvas宽高
                        /*canvas.width = image.width;
                        canvas.height = image.height;
                        if (canvas.width>max) {canvas.width = max;}*/
                        // 将图像绘制到canvas上
                        // ctx.drawImage(image, 0, 0, image.width, image.height);
                        ctx.drawImage(image, 0, 0, 150, 150);
                        // 注意，此时image没有加入到dom之中
                    };
                }
            };
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

        //ztree树     window.utils_admin.Ztreedata($("#treeDemo"),setting,zNodes);
        Ztreedata(ztree, setting, zNodes) {
            $.fn.zTree.init(ztree, setting, zNodes);
        };

        //请求多接口,返回josn     window.utils_admin.eventproxy([{"url":"","param":{},"name":}]);
        eventproxy(apisetdata) {
            let strdata = '', data = {};
            apisetdata.forEach((a) => {
                strdata = this.setajax('POST', a.param, a.url)
                data[a.name] = strdata
            });
            return data
        }

        lohspage(...a){
            return a[1][a[0].slice(2,a[0].length)]
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