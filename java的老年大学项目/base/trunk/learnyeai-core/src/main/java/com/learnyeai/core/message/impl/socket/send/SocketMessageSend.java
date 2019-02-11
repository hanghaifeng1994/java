package com.learnyeai.core.message.impl.socket.send;

import com.learnyeai.core.message.send.MessageSendService;
import com.learnyeai.core.message.impl.socket.SocketSetting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by winkie on 15/6/29.
 */
public class SocketMessageSend implements MessageSendService {

    private String multiHost = SocketSetting.getMultiHost();// Properties.getValue("topic.multi.host");

    private int multiPort = SocketSetting.getMultiPort();// Integer.valueOf(Properties.getValue("topic.multi.port"));

    private String multiQHost = SocketSetting.getMultiQHost();// Properties.getValue("queue.multi.host");

    private int multiQPort = SocketSetting.getMultiQPort();// Integer.valueOf(Properties.getValue("queue.multi.port"));

    /**
     * 发送多播消息 多处接收
     * @param pipeName 通道名
     * @param message 消息体（业务名 + “：” + 消息内容）
     * @param <T>
     */
    @Override
    public <T> void sendTopic(String pipeName, T message) {
        MulticastSocket s = null;
        try {
            s = new MulticastSocket();
            String send = (String)message;

            //加入多播组
            InetAddress group = InetAddress.getByName(multiHost);
            s.joinGroup(group);
            DatagramPacket dp = new DatagramPacket(send.getBytes(), send.length(), group, multiPort);
            s.send(dp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != s) {
                s.close();
            }
        }
    }

    /**
     * 发送多播消息 一处接收（这里单播发送的方式使用多播方式发送，在消息派发时限制一处接收）
     * @param pipeName 通道名
     * @param message 消息体（业务名 + “：” + 消息内容）
     * @param <T>
     */
    @Override
    public <T> void sendQueue(String pipeName, T message) {
        MulticastSocket s = null;
        try {
            s = new MulticastSocket();
            String send = (String)message;

            //加入多播组
            InetAddress group = InetAddress.getByName(multiQHost);
            s.joinGroup(group);
            DatagramPacket dp = new DatagramPacket(send.getBytes(), send.length(), group, multiQPort);
            s.send(dp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != s) {
                s.close();
            }
        }
    }
}
