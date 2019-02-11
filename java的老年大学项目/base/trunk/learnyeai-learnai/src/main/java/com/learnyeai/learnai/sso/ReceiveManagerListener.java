package com.learnyeai.learnai.sso;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.learnyeai.core.config.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

import com.learnyeai.tools.common.StringUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: ReceiveManagerListener
 * @Description: 订阅服务监听
 * @author: mingyi.li（mylee0523@gmail.com）
 * @date: 2015年3月12日 上午10:02:56
 */
@Component
public class ReceiveManagerListener extends Thread {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String udpIp = ConfigUtils.getValue("UDP_IP");

    private int port = ConfigUtils.getValue("UDP_PORT", 80);

    // 用于接收广播信息
    private MulticastSocket multicastSocket;

    //线程是否停止
    private boolean stop = false;

    //注册订阅服务
    private static Map<String, IReceiveService> serviceMap = new HashMap<String, IReceiveService>();;

    /**
     * @Title: resigerListener
     * @Description: 注册订阅的服务
     * @param topicName
     */
    public static void registerListener(String topicName, IReceiveService receiveService) {
        serviceMap.put(topicName, receiveService);
    }

    @PostConstruct
    public void init() {
        /*try {
            logger.info("upd ip:port is " + udpIp + ":" + port);
            multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(InetAddress.getByName(udpIp));
            // 启动线程 开始监听
            this.start();
            logger.info("ReceiveListener listener Thread start...");
        } catch (IOException ex) {
            logger.error("ReceiveListener init error,\n" + ex);
        }*/
    }

    @PreDestroy
    public void destory() {
        this.stop = true;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        //订阅message初始化
        String revStr = "";
        while (true) {
            if (stop) {
                logger.info("ReceiveListener stop ....");
                multicastSocket.close();
                return;
            }
            try {
                packet.setLength(buffer.length);
                logger.info("ReceiveListener waitting.. ");
                multicastSocket.receive(packet);
                int msgLength = packet.getLength();
                revStr = new String(buffer, 0, msgLength, "UTF-8");
                // 判空处理
                if (StringUtils.isEmpty(revStr)) {
                    logger.info("ReceiveListener recvdata is Invalid!");
                    continue;
                }
                try {

                    //解密 TODO

                    logger.info("ReceiveListener recvdata:" + revStr);
                    //解析接收订阅
                    Map map = (Map) JSONObject.parseObject(revStr);
                    if (null != map && !map.isEmpty()) {
                        IReceiveService recService = serviceMap.get(String.valueOf(map.get("SUBS_TYPE")));
                        if (null != recService) {
                            recService.receive(map);
                        }
                    }
                } catch (JSONException je) {
                    logger.error("ReceiveListener parse msg error!\n" + je);
                } catch (NoSuchBeanDefinitionException e) {
                    logger.error("No Such Bean Definition Exception!\n" + e);
                } catch (Exception e) {
                    logger.error("Exception!\n" + e);
                }
            } catch (IOException ex) {
                logger.error("ReceiveListener rev msg error!\n" + ex);
            }
        }
    }
}