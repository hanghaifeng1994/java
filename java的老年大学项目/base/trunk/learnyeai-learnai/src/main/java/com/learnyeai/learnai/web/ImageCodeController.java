package com.learnyeai.learnai.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.consts.SessR;

/**
 * 
 * @ClassName: ImageCodeController
 * @Description: 图形验证码生成，防暴力破解
 * @author: LQ
 * @date: 2015年7月20日
 * 
 */
@Controller
public class ImageCodeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private final int width = 60;
	private final int height = 20;
	private final int codeCount = 4;

	private final int x = width / (codeCount + 1);
	private final int fontHeight = height - 2;
	private final int codeY = height - 4;

	final char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	@RequestMapping("/common/ImageCode.do")
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String transCode = "/common/ImageCode";
	        MDC.put(AppR.MDC_TRANS_CODE, transCode);
	        
			HttpSession session = request.getSession();

			// 创建具有可访问图像数据缓冲区的Image
			BufferedImage buffImg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = buffImg.createGraphics();

			// 创建一个随机数生成器
			Random random = new Random();

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);

			// 创建字体，字体的大小应该根据图片的高度来定
			// Font font = new Font("Fixedsys", Font.ITALIC, 18);
			Font font = null;
			// 设置字体

			// 画边框
			g.setColor(Color.BLUE);
			g.drawRect(0, 0, width - 1, height - 1);
			int red = 0, green = 0, blue = 0;
			red = random.nextInt(110);
			green = random.nextInt(80);
			blue = random.nextInt(180);
			// 随机产生10条干扰线
			g.setColor(new Color(red, green, blue));
			for (int i = 0; i < 10; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int x1 = random.nextInt(22);
				int y1 = random.nextInt(22);
				g.drawLine(x, y, x + x1, y + y1);
			}

			// randomCode 用于保存随机产生的验证码
			StringBuffer randomCode = new StringBuffer();

			// 随机产生4位数字的验证码
			for (int i = 0; i < 4; i++) {
				// 得到随机产生的验证码数字
				String strRand = String.valueOf(random.nextInt(10));
				font = getFont();
				// 产生随机的颜色分量来构造颜色值
				red = random.nextInt(110);
				green = random.nextInt(80);
				blue = random.nextInt(180);
				// 用随机产生的颜色将验证码绘制到图像中
				g.setFont(font);
				g.setColor(new Color(red, green, blue));
				g.drawString(strRand, 13 * i + 6, 16);

				// g.RotateTransform(12);

				randomCode.append(strRand);
			}

			session.removeAttribute(SessR.IMAGE_CODE);
			session.setAttribute(SessR.IMAGE_CODE, randomCode.toString());
			logger.info("IMG_CODE:{}", session.getAttribute(SessR.IMAGE_CODE));
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			response.setContentType("image/png");
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(buffImg, "png", sos);
			sos.flush();
			sos.close();
		} catch (Exception e) {
			logger.error("client stream close error");
		}
	}

	private Font getFont() {
		// 获得随机字体;
		// 设置font :字体名称:Monotype Corsiva 华文彩云 方正舒体 华文行楷,隶书
		Random s = new Random();
		int i = s.nextInt(10);
		if (i % 2 == 0 && i < 6) {
			return new Font("Times New Roman", Font.PLAIN, 19);
		} else if (i % 3 == 0) {
			return new Font("Fixedsys", Font.PLAIN, 18);
		} else if (i % 7 == 0) {
			return new Font("Times New Roman", Font.ITALIC, 17);
		} else {
			return new Font("Fixedsys", Font.ITALIC, 19);
		}
	}
}
