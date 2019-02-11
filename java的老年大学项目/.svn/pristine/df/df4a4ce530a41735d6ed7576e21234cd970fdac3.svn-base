/**
 * 
 */
package com.learnyeai.learnai.sso.impl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Map;

import com.learnyeai.learnai.sso.ISendService;
import com.learnyeai.core.config.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SendService
 * @Description: 广播服务
 * @author: mingyi.li（mylee0523@gmail.com）
 * @date: 2015年3月10日 下午1:24:51
 */
@Service
public class SendService implements ISendService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String udpIp = ConfigUtils.getValue("UDP_IP");

    private int port = ConfigUtils.getValue("UDP_PORT", 80);

    // 用于接收广播信息
    private MulticastSocket multicastSocket;

    // 广播地址
    private InetAddress inetAddress;

    @Override
    public void notice(Map<String, Object> map) {

        if (null == map || map.isEmpty()) {
            logger.error("Upd param ansy command is empty !");
            return;
        }

        //请求参数初始化
        String msg = null;

        //初始化，加入广播
        try {
            multicastSocket = new MulticastSocket(port);
            inetAddress = InetAddress.getByName(udpIp);
            multicastSocket.joinGroup(inetAddress);
            //插入主机IP
            map.put("HOST", InetAddress.getLocalHost().getHostAddress());
        } catch (IOException ex) {
            logger.error("AppOnLineEventNotice init error!\n", ex);
            return;
        }
        logger.info("AppOnLineEventNotice startup...");
        msg = JSONObject.toJSONString(map);
        byte[] b = msg.getBytes();
        logger.info(">>>>msg:" + msg);
        //需要加密 操作 TODO
        // 数据流套接字 相当于码头，用于发送信息
        DatagramPacket dp = new DatagramPacket(b, 0, b.length, inetAddress, port);
        try {
            multicastSocket.send(dp);
            logger.info("-single user session control----");
        } catch (IOException ex) {
            logger.error("notice the other server error!\n" + ex);
        } finally {
            multicastSocket.close();
        }
    }
}
