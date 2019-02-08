var io = require('socket.io')();            //socket模块
var amqp = require('amqplib/callback_api');//rabbitMQ模块
const NodeCache = require('node-cache') ;   //cache模块
const myCache = new NodeCache();
var datauser=[],socketid='',datacookuser=[],dataz='';

//客户端连接
io.on('connection', function (socket) {
    console.log("客户端连接成功~~");
    //接受客户端发来的数据
    socket.on('send', function (data) {
        console.log("接受客户端发来的数据");
        socketid=socket.id;
        data.socketid=socketid;

        //在存储socketid时候通过用户发来的id检查有没有存储过
        if(datauser.length){
            datauser.forEach((a)=>{
                if(a.uuid==data.uuid){
                    a.socketid=socketid
                }else {
                    datauser.push(data);
                }
            })
        }else {
            datauser.push(data);
        }

        //用户连接到客户端用登录传过来的id查找缓存中是否有消息,并推送到客户端，剔除已推送的数据
        console.log('检查缓存');
        console.log(datacookuser);
        myCache.get("datacookuser", function( err, value ){
            if(!err){
                if(value!=undefined){
                    value.forEach((a)=>{
                        if(a==data.uuid){
                            //检查是否连接正常
                            if(io.sockets.connected[socketid]){
                                io.sockets.connected[socketid].emit('receive',a);
                                //从缓存中删除已推送的消息
                                myCache.del( "datacookuser", function( err, count ){
                                    if(!err ){
                                        console.log('成功删除');
                                        datacookuser.splice(datacookuser.indexOf(a), 1);
                                        myCache.set("datacookuser", datacookuser, function( err, success ){
                                            if(!err && success ){
                                                console.log('保存到缓存');
                                                console.log(datacookuser)
                                            }
                                        });
                                    }
                                });
                            }
                        }else {
                            datacookuser.push(a)
                        }
                    })
                }
            }
        });
    });

    //连接rabbitmq服务器
    amqp.connect('amqp://localhost', function (err, conn) {
        conn.createChannel(function (err, ch) {
            var q = 'task_queue';
            ch.assertQueue(q,{durable: true});
            ch.prefetch(1);
            console.log("[*] 等待消息 %s.退出 CTRL+C", q);
            ch.consume(q, function (msg) {
                console.log("[x] 接收到 %s", msg.content.toString());
                var content= msg.content.toString();
                //判断用户有没有连接,有登录推送给用户,没有登录把消息放到缓存中
                console.log(datauser);

                //在发通知之前，去除重复的用户
                var hash = {};
                datauser = datauser.reduce(function(item, next) {
                    hash[next.uuid] ? '' : hash[next.uuid] = true && item.push(next);
                    return item
                }, []);
                console.log('去重',datauser);

                if(datauser.length){
                    datauser.forEach((a)=>{
                        if(a.uuid==content){
                            console.log(a.uuid)
                            console.log(content)
                            console.log(a.socketid);

                            io.sockets.connected[a.socketid].emit('receive',a);
                            //去除已经发送的数据，剩下是未通知的用户
                            // content.splice(content.findIndex(item => item.id === a.uuid), 1)
                        }else {
                            console.log('else',a.uuid)
                            console.log(content);
                            datacookuser.push(content);
                        }
                    });
                }else {
                    datacookuser.push(content);
                }

                //把未通知的消息放进缓存中
                myCache.set("datacookuser", datacookuser, function( err, success ){
                    if(!err && success ){
                        console.log('保存到缓存');
                    }
                });
                //通知mq完成发送
                ch.ack(msg);
                console.log("[x] 完成");
                //io.sockets.connected[socket.id].emit('receive',content);
                //io.emit('receive', content);
            }, {noAck: false}); // 开启消息确认标识
        });
    });



    // socket.on('send', function (data) {
    // 	console.log("接受客户端发来的数据");
    // 	console.log(data);
    //    console.log(socket.id);
    //    if (io.sockets.connected[socket.id]) {
    //        io.sockets.connected[socket.id].emit('receive',data);
    //    }
    // 	//io.emit('receive', data);
    // });


    //断开
    // socket.on('disconnect', function(){
    //    //移除
    //    if(socket.username in usocket){
    //        delete(usocket[socket.username]);
    //        user.splice(user.indexOf(socket.username), 1);
    //    }
    //    console.log(user);
    //    socket.broadcast.emit('user left',socket.username)
    // })
});

exports.listen = function (server) {
    return io.listen(server);
};