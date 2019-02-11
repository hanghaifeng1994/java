package com.learnyeai.learnai.net.netWay.socket;

import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketClient {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 超时时间 ：140000
	 */
	private static final int TRADE_TIMEOUT = 140000;

	private static final String CHARSET = "UTF-8";

	private String serverIP;
	private int serverPort;
	private boolean isConnected; // 是否建立连接

	private Socket socket;
	private PrintWriter out;
	private DataInputStream in;

	public SocketClient(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		init();
	}

	/**
	 * 初始化socket
	 * 
	 */
	private void init() {
		logger.debug("服务器地址:\t {} : {}", serverIP, serverPort);
		try {
			socket = new Socket(serverIP, serverPort);
			// 设置超时时间
			socket.setSoTimeout(TRADE_TIMEOUT);
			in = new DataInputStream(socket.getInputStream());
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream(), CHARSET));
			isConnected = true;
		} catch (Exception e) {
			isConnected = false;
			logger.error("connect error==> {} : {}", serverIP, serverPort, e);
			throw new AresRuntimeException("net.connect.fail");
		}
	}

	/**
	 * socket通信数据处理
	 * 
	 * 
	 * @param b
	 *            发送的数据
	 * 
	 * @return
	 */
	public byte[] sendData(String b) {
		int lengthStr = 0;
		String headNumSre = "";
		int oneReadMaxLength = 256;// 每次读取的最大长度
		int readLocation = 0;// 读取的位置
		int readLength = 0;// 读取的长度
		int remainLength = 0;// 剩余的长度
		byte[] recMsgLength = new byte[6];
		byte[] result = null;
		long startTime = System.currentTimeMillis();
		try {
			// TODO 前置编码 GBK
			//b = StringUtil.utf2gbk(b);// 转码
			lengthStr = b.getBytes(CHARSET).length;
			headNumSre = String.format("%06d", lengthStr);// 前面加6位长度
			b = headNumSre + b;
			if (isConnect()) {
				send(b);
				in.read(recMsgLength);//先读6个字节(表示后续的报文长度)
				int allLength = StringUtils.parseInt(new String(recMsgLength));

				logger.info("返回的报文长度 = {}", allLength);
				result = new byte[allLength];
				byte[] readByte = null;
				for (; readLocation < allLength; readLocation += readLength) {
					readLength = oneReadMaxLength;
					remainLength = allLength - readLocation;
					if (remainLength < oneReadMaxLength)
						readLength = remainLength;
					readByte = new byte[readLength];
					in.read(readByte);
					System.arraycopy(readByte, 0, result, readLocation,
							readLength);
				}
			}
			logger.debug("response:{}", StringUtils.gbk2utf(result));
			// TODO 前置编码 GBK
			long useTime = System.currentTimeMillis() - startTime;
			logger.debug("交易耗时：{} ms", useTime);
		} catch (SocketTimeoutException e) {
			long useTime = System.currentTimeMillis() - startTime;
			logger.error("交易超时!spend time:{}", useTime, e);
		} catch (Exception e) {
			logger.error("socket通信异常:", e);
		} finally {
			close();
		}
		return result;
	}



	/**
	 * socket通信数据处理
	 *
	 *
	 * @param b
	 *            发送的数据
	 *
	 * @return
	 */
	public byte[] sendBytesData(byte[] b) {
		int lengthStr = 0;
		String headNumSre = "";
		int oneReadMaxLength = 256;// 每次读取的最大长度
		int readLocation = 0;// 读取的位置
		int readLength = 0;// 读取的长度
		int remainLength = 0;// 剩余的长度
		byte[] recMsgLength = new byte[4];//报文长度值
		byte[] recHead = new byte[10];//报文头
		byte[] result = null;
		long startTime = System.currentTimeMillis();
		try {
			if (isConnect()) {
				send(b);
				in.read(recMsgLength);//先读4个字节(表示后续的报文长度)
				int allLength = StringUtils.parseInt(new String(recMsgLength));

				/*in.read(recHead);//先读10个字节(表示报文头)
				String head = new String(recMsgLength);*/

				logger.info("返回的报文长度 = {}", allLength);
				result = new byte[allLength];
				byte[] readByte = null;
				for (; readLocation < allLength; readLocation += readLength) {
					readLength = oneReadMaxLength;
					remainLength = allLength - readLocation;
					if (remainLength < oneReadMaxLength)
						readLength = remainLength;
					readByte = new byte[readLength];
					in.read(readByte);
					System.arraycopy(readByte, 0, result, readLocation,
							readLength);
				}
			}
			logger.debug("response:{}", StringUtils.gbk2utf(result));
			long useTime = System.currentTimeMillis() - startTime;
			logger.debug("交易耗时：{} ms", useTime);
		} catch (SocketTimeoutException e) {
			long useTime = System.currentTimeMillis() - startTime;
			logger.error("交易超时!spend time:{}", useTime, e);
		} catch (Exception e) {
			logger.error("socket通信异常:", e);
		} finally {
			close();
		}
		return result;
	}

	/**
	 * 判断socket是否连接
	 * 
	 * @return
	 * @throws IOException
	 */
	private boolean isConnect() throws IOException {
		return isConnected;
	}

	/**
	 * socket 发送数据
	 * 
	 * @param s
	 * @throws IOException
	 */
	private void send(String s) throws IOException {
		if (checkLink()) {
			init();
		}
		logger.debug("request:{}", s);
		out.print(s);
		out.flush();
		socket.shutdownOutput();
	}

	/**
	 * socket 发送数据
	 *
	 * @param s
	 * @throws IOException
	 */
	private void send(byte[] s) throws IOException {
		if (checkLink()) {
			init();
		}
		logger.debug("request:{}", s);
		out.print(s);
		out.flush();
		socket.shutdownOutput();
	}

	/**
	 * @return true 如果socket没有连接也没有关闭,else false
	 */
	private boolean checkLink() {
		return !socket.isConnected() && !socket.isClosed();
	}

	/**
	 * 关闭连接
	 */
	private void close() {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
			}
			in = null;
		}
		if (out != null) {
			out.close();
			out = null;
		}
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
			socket = null;
		}

	}
}