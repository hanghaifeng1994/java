package com.learnyeai.core.message.impl.socket.listener;

import com.learnyeai.core.message.impl.socket.SocketSetting;
import com.learnyeai.core.message.monitor.MessageMonitorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * @author zhanglong
 * @date 15/7/13
 */
public class SocketQueueListener {

    private static final Logger logger = LoggerFactory.getLogger(SocketQueueListener.class);

    static DatagramPacket dp = null;

    static MulticastSocket ms = null;

    private String multiHost = SocketSetting.getMultiHost();//Properties.getValue("queue.multi.host");

    private int multiPort = SocketSetting.getMultiPort();// Integer.valueOf(Properties.getValue("queue.multi.port"));

    // socket实现 初始化 监听端口
    public void init() {
        if(logger.isInfoEnabled()) {
            logger.info("SocketQueueListener ======= start");
        }
        //初始化监听使用多播机制 在处理时限制自由一个监听处理，采用轮询方式
        createMultiCast();

        if(logger.isInfoEnabled()) {
            logger.info("SocketQueueListener ======= end");
        }
    }

    /**
     * 监听 多播
     */
    private void createMultiCast() {
        try {
            if(null == ms) {
                //绑定端口的
                ms = new MulticastSocket(multiPort);
                //加入多播地址
                InetAddress group = InetAddress.getByName(multiHost);
                ms.joinGroup(group);
            }
            Thread t = new Thread(){
                public void run(){
                    StringBuffer sbuf = null;
                    byte[] buf = null;
                    while (true) {
                        try{
                            sbuf  = new StringBuffer();
                            buf = new byte[1024];
                            dp = new DatagramPacket(buf, buf.length);
                            ms.receive(dp);
                            for(int i = 0; i < 1024; i++){
                                if(buf[i] == 0){
                                    break;
                                }
                                sbuf.append((char) buf[i]);
                            }
                            MessageMonitorManager.doMessage(sbuf.toString(), 0);
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            ms.close();
        }
    }
}
