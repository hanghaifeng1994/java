var amqp = require('amqplib/callback_api');

function setamqp() {
    amqp.connect('amqp://localhost', function (err, conn) {
        conn.createChannel(function (err, ch) {
            var q = 'task_queue';
            var msg = process.argv.slice(2).join(' ') || "Hello World!";
            ch.assertQueue(q, {
                durable: true
            });
            ch.sendToQueue(q, new Buffer(msg), {persistent: true});
            console.log(" [x] 发出 '%s'", msg);
        });
        setTimeout(function () {
            conn.close();
            process.exit(0)
        }, 500);
    });
}

module.exports = {
    amqp: setamqp
}
