package com.learnyeai.tools.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 服务器相关的工具方法
 * @author lc3@yitong.com.cn
 */
public class ServerUtils {

    private static String SERVER_IP;
    private static Logger logger = LoggerFactory.getLogger(ServerUtils.class);

    public static String getServerIp() {
        if(null != SERVER_IP) {
            return SERVER_IP;
        }
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces
                        .nextElement();
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                ip = null;
                while(inetAddresses.hasMoreElements()) {
                    ip = inetAddresses.nextElement();
                    if(ip instanceof Inet4Address) {
                        break;
                    } else {
                        ip = null;
                    }
                }
                if(null == ip) {
                    continue;
                }
                SERVER_IP = ip.getHostAddress();
                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && !ip.getHostAddress().contains(":")) {
                    SERVER_IP = ip.getHostAddress();
                    if(!SERVER_IP.startsWith("127")) {
                        break;
                    }
                } else {
                    ip = null;
                }
            }
        } catch (SocketException e) {
            if(logger.isErrorEnabled()) {
                logger.error("获取本地的IP地址失败，失败原因为：" + e.getMessage(), e);
            }
        }
        return SERVER_IP;
    }
}
