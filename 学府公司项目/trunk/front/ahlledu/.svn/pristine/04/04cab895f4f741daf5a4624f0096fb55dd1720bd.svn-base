let page_data = require('./page_data').page_data;
let bodyParser = require("body-parser");
let path = require('path');
let sitedata = require('./sitedata').sitedata;
let frontmserviceapi = require("../server/frontmserviceapi").frontmserviceapi;
let superagent = require('superagent');

//  /old/user/index.html
//
function routes(app) {
    app.use(bodyParser.urlencoded({extended: false}));
    app.use(bodyParser.json());

    sitedata.forEach((a) => {
        app.get('/' + a.sitedata + '/html/*?*', function (req, res) {
            if (!page_data(req, res, req.params[0])) {
                res.render('404.html', {
                    title: 'No Found'
                })
            }
        });
        app.get('/' + a.sitedata + '/user/*', function (req, res) {
            res.sendFile(path.resolve('./views' + req.originalUrl), function (err) {
                if (err)
                    res.render('404.html', {
                        title: 'No Found'
                    })
            })
        });
    });
    app.get("/template/*", function (req, res) {
        let originalUrl = req.originalUrl;
        console.log(__dirname + '/../public' + req.originalUrl);
        res.sendFile(path.resolve(__dirname + '/../public' + req.originalUrl))
    });
    app.get('*', function (req, res) {
        res.render('404.html', {
            title: 'No Found'
        })
    });

    app.get('/socket', function (req, res) {
        console.log(req, res);
        res.render('socket/index.html');
    });

    //前端统一聚合接口
    app.post('/componentlistdata', function (req, res) {
        frontmserviceapi(req, res, function (data) {
            console.log("resdata--",data)
            let pagedata = {
                "totalData": {
                    "data": data
                }
            };
            console.log("pagedata--",pagedata)
            res.send(pagedata);
        })
    });
}

module.exports = {
    routes: routes
};