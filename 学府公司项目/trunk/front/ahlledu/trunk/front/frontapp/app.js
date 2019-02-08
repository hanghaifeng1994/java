// app.js
let express = require('express');   //引入express框架
let path = require('path');
let app = express();
let FileStreamRotator = require('file-stream-rotator');//日志分割
let fs = require('fs');//文件操作的模块
let morgan = require('morgan');
let routes = require('./routes/routes');
let logDirectory = path.join(__dirname, 'log');

app.set('views', path.join(__dirname, 'views'));

app.engine('html', require('./server/art_template'));    //使用art-template渲染
app.use(express.static('public'));      //设置静态文件地址


// 检查日志文件是否存在
fs.existsSync(logDirectory) || fs.mkdirSync(logDirectory);

// 创建日志
let accessLogStream = FileStreamRotator.getStream({
    date_format: 'YYYYMMDD',
    filename: path.join(logDirectory, 'access-%DATE%.log'),
    frequency: 'daily',
    verbose: false
});
// 设置日志
app.use(morgan('combined', {stream: accessLogStream}));

//查找日志文件
function getyyyyMMdd() {
    let d = new Date();
    let curr_date = d.getDate();
    let curr_month = d.getMonth();
    let curr_year = d.getFullYear();
    if (curr_month < 0) {
        curr_date = curr_date - 1;
        curr_month = 12;
    }
    String(curr_month).length < 2 ? (curr_month = "0" + curr_month) : curr_month;
    String(curr_date).length < 2 ? (curr_date = "0" + curr_date) : curr_date;
    let yyyyMMdd = curr_year + "" + curr_month + "" + curr_date;
    return yyyyMMdd;
}
let getdata = getyyyyMMdd();
let fileNames = fs.readdirSync('./log');
//删除日志
setInterval(function () {
    if (fileNames.length)
        fileNames.forEach((a) => {
            if (a.slice(0, 7) == "access-")
                if (parseInt(a.slice(7, 15)) <= parseInt(getdata)) {
                    fs.unlink(__dirname + '/log/' + a, function (err) {
                        console.log(err)
                    });
                }
        })
}, 24 * 60 * 60 * 1000);


//路由设置
routes.routes(app);


//设置端口服务
// 1.linux环境下：
// $ PORT=1234 node app.js
// 使用上面命令每次都需要重新设置，如果想设置一次永久生效，使用下面的命令。
// $ export PORT=1234
// $ npm start
// 2.windows下面按照顺序这样进行：
// set PORT=1234
//npm start
app.set('port', process.env.PORT || 3000);
let server = app.listen(app.get('port'), function () {
    let host = server.address().address;
    let port = server.address().port;
    console.log('应用启动成功！端口为:', port);
});
//socket服务启动
require('./server/socket').listen(server);