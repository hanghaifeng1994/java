package cn.com.weyeyun.commoncert.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import org.apache.commons.lang.StringUtils;
import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.GMOperation;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.MogrifyCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.weyeyun.commoncert.dto.PropertyAll;
import cn.com.weyeyun.commoncert.vo.PrintClazzVO;

@Component
public class GimageUtil {

	public static String TEXT = "text";

	public static String IMAGE = "image";

	public static int FONTSIZEPLUS = 5;
	public static int ALPHA = 100;

	private static PropertyAll property;

	@Autowired
	public GimageUtil(PropertyAll property) {
		GimageUtil.property = property;
	}

	public static void copyFile(String sourceFilePath, String descFilePath, String uploadPath) {
		File uploadFile = new File(uploadPath);

		if (!uploadFile.exists()) {
			uploadFile.mkdir();
		}

		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(sourceFilePath);
			fo = new FileOutputStream(descFilePath);
			in = fi.getChannel();// 得到f1 的文件通道
			out = fo.getChannel();// 得到f12的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * 取得两个参数之间的字符串
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String getBetweenStr(String str, String str1, String str2) {
		int i = str.indexOf(str1);
		int j = str.indexOf(str2);
		String strtemp = str.substring(i + 1, j);
		return strtemp;
	}

	/**
	 * 解析证书模板Subject中的文字、图片以及它们的属性 封装在PrintClazz类中
	 * 
	 */
	public static List<PrintClazzVO> convertToPrintClazz(String str) {
		List<PrintClazzVO> printClazzVOs = new ArrayList<PrintClazzVO>();
		PrintClazzVO printClazzVO = null;
		String imageUrlPath = "";
		String imageUrl = "";
		imageUrlPath = property.getUploadUrl();
		imageUrl = property.getUploadPath();

		// 先将字符串参数按照;分割成数组
		if (str == null) {
			return printClazzVOs;
		}
		String[] spltString = str.split(";");
		String attributeStrs = "";
		String[] attributeArray;
		String[] imageAttributeArray;
		for (int i = 0; i < spltString.length; i++) {
			//
			if (spltString[i].trim().startsWith("LODOP.ADD_PRINT_TEXT")) {
				// 打印的文字
				// 1、如果printClazz对象已经创建，则加入到List
				if (printClazzVO != null) {
					printClazzVOs.add(printClazzVO);
				}
				// 2、创建PrintClazz对象
				printClazzVO = new PrintClazzVO();

				// 3、将参数提取出来
				attributeStrs = getBetweenStr(spltString[i], "(", ")");
				// System.out.println(spltString[i] + " ------- " +
				// attributeStrs);

				attributeArray = attributeStrs.split(",");
				if (attributeArray.length == 5) {
					printClazzVO.setKey(GimageUtil.TEXT);
					printClazzVO.setY(Integer.valueOf(attributeArray[0].trim()));
					printClazzVO.setX(Integer.valueOf(attributeArray[1].trim()));
					printClazzVO.setWidth(Integer.valueOf(attributeArray[2].trim()));
					printClazzVO.setHeight(Integer.valueOf(attributeArray[3].trim()));
					printClazzVO.setValue(attributeArray[4].trim());
				}
			} else if (spltString[i].trim().startsWith("LODOP.ADD_PRINT_IMAGE")) {
				// 打印的图片
				// 1、如果printClazz对象已经创建，则加入到List
				if (printClazzVO != null) {
					printClazzVOs.add(printClazzVO);
				}
				// 2、创建PrintClazz对象
				printClazzVO = new PrintClazzVO();
				attributeStrs = getBetweenStr(spltString[i], "(", ")");
				// System.out.println(spltString[i] + " ------- " +
				// attributeStrs);

				attributeArray = attributeStrs.split(",");
				if (attributeArray.length == 5) {
					printClazzVO.setKey(GimageUtil.IMAGE);
					printClazzVO.setY(Integer.valueOf(attributeArray[0].trim()));
					printClazzVO.setX(Integer.valueOf(attributeArray[1].trim()));
					printClazzVO.setWidth(Integer.valueOf(attributeArray[2].trim()));
					printClazzVO.setHeight(Integer.valueOf(attributeArray[3].trim()));
					imageAttributeArray = attributeArray[4].split(" ");
					for (String imageAttribute : imageAttributeArray) {
						if (imageAttribute.startsWith("src=")) {
							printClazzVO.setValue(imageUrl + imageAttribute.trim().replaceFirst("src=" + imageUrlPath, "").trim());
						}
					}
				}

			} else if (spltString[i].trim().startsWith("LODOP.SET_PRINT_STYLEA")) {
				// 添加文字或者图片的属性
				attributeStrs = getBetweenStr(spltString[i], "(", ")");
				attributeArray = attributeStrs.split(",");
				if (attributeArray.length == 3 && printClazzVO != null) {

					if (attributeArray[1].trim().equals("FontName")) {
						if (attributeArray[2].equals("楷体")) {
							printClazzVO.setFontType(property.getCertFontKaitiPath());
						} else if (attributeArray[2].equals("黑体")) {
							printClazzVO.setFontType(property.getCertFontHeitiPath());
						} else if (attributeArray[2].equals("宋体")) {
							printClazzVO.setFontType(property.getCertFontSongtiPath());
						} else if (attributeArray[2].equals("新宋体")) {
							printClazzVO.setFontType(property.getCertFontXinsongtiPath());
						} else if (attributeArray[2].equals("微软雅黑")) {
							printClazzVO.setFontType(property.getCertFontWeiruanyaheiPath());
						} else if (attributeArray[2].equals("仿宋")) {
							printClazzVO.setFontType(property.getCertFontFangsongPath());
						} else {
							printClazzVO.setFontType(property.getCertFontDefaultPath());
						}

					} else if (attributeArray[1].trim().equals("FontSize")) {
						printClazzVO.setFontSize(Integer.valueOf(attributeArray[2].trim()));
					} else if (attributeArray[1].trim().equals("Bold")) {
						printClazzVO.setFontBold(Integer.valueOf(attributeArray[2].trim()));
					}
					if (StringUtils.isBlank(printClazzVO.getFontType())) {
						printClazzVO.setFontType(property.getCertFontDefaultPath());
					}

				}

			}
		}
		if (printClazzVO != null) {
			printClazzVOs.add(printClazzVO);
		}

		return printClazzVOs;
	}

	/**
	 * 添加图片水印
	 * 
	 * @param srcPath
	 *            原图片路径
	 * @param distPath
	 *            新图片路径
	 * @param watermarkImg
	 *            水印图片路径
	 * @param width
	 *            图片的宽度
	 * @param height
	 *            图片的高度
	 * @param x
	 *            横向边距
	 * @param y
	 *            纵向边距
	 * @param alpha
	 *            透明度
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws IM4JavaException
	 */

	public static void WatermarkImg(String srcPath, String distPath, String watermarkImg, int width, int height, int x, int y, int alpha) throws IOException, InterruptedException, IM4JavaException {
		watermarkImg(srcPath, distPath, watermarkImg, width, height, x, y, alpha);
	}

	/**
	 * 添加图片水印
	 * 
	 * @param srcPath
	 *            原图片路径
	 * @param distPath
	 *            新图片路径
	 * @param watermarkImg
	 *            水印图片路径
	 * @param width
	 *            水印宽度（可以于水印图片大小不同）
	 * @param height
	 *            水印高度（可以于水印图片大小不同）
	 * @param x
	 *            水印开始X坐标
	 * @param y
	 *            水印开始Y坐标
	 * @param alpha
	 *            透明度[0-100]
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws IM4JavaException
	 */
	private static synchronized void watermarkImg(String srcPath, String distPath, String watermarkImg, int width, int height, int x, int y, int alpha) throws IOException, InterruptedException,
			IM4JavaException {
		CompositeCmd cmd = new CompositeCmd();
		String path = property.getImagickPath();
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("win") != -1) {
			// linux下不要设置此值，不然会报错
			cmd.setSearchPath(path);
		}

		IMOperation op = new IMOperation();
		op.dissolve(alpha);

		op.addRawArgs("-quality", "100");
		op.geometry(width, height, x, y);
		op.addImage(watermarkImg);
		op.addImage(srcPath);
		op.addImage(distPath);
		System.out.println(op);
		cmd.run(op);
	}

	/**
	 * 把文字转化为一张背景透明的png图片
	 * 
	 * @param str
	 *            文字的内容
	 * @param fontType
	 *            字体，例如宋体
	 * @param fontSize
	 *            字体大小
	 * @param colorStr
	 *            字体颜色，不带#号，例如"990033"
	 * @param outfile
	 *            png图片的路径
	 * @throws Exception
	 */
	public void converFontToImage(String srcImagePath, String str, String fontType, int fontSize, int fontBold, String colorStr, int width, int height, int x, int y, String outfile) throws Exception {

		Font font = new Font(fontType, fontBold, fontSize + GimageUtil.FONTSIZEPLUS);

		File file = new File(srcImagePath);
		/*
		 * BufferedImage image = new BufferedImage(width, height * 2,
		 * BufferedImage.TYPE_INT_RGB);
		 */
		BufferedImage image = ImageIO.read(new File(srcImagePath));
		Graphics2D g2d = image.createGraphics();

		/*
		 * image = g2d.getDeviceConfiguration().createCompatibleImage(width,
		 * height * 2, Transparency.TRANSLUCENT);
		 */

		g2d = image.createGraphics();

		g2d.setColor(Color.WHITE);
		// g2d.setStroke(new BasicStroke(10));
		// g2d.setBackground(Color.BLACK);
		g2d.setColor(new Color(Integer.parseInt(colorStr, 16)));// 在换成所需要的字体颜色
		g2d.setFont(font);

		// g2d.setStroke(new BasicStroke(3.0f));

		// 图片除毛刺
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		List<String> strList = splitStringByPicWidth(str, g2d, width);
		for (int i = 0; i < strList.size(); i++) {
			g2d.drawString(strList.get(i), x, y + i * g2d.getFontMetrics().getHeight() + g2d.getFontMetrics().getHeight() - 3);
		}
		g2d.dispose();
		ImageIO.write(image, "jpg", file);// 输出png图片
	}

	/**
	 * function:当字符串的长度超过图片的长度时，将字符串分隔成几个字符串
	 * 
	 * @param str
	 *            文字的内容
	 * @param graphics2D
	 *            画笔
	 * @param picWidth
	 *            图片的长度
	 * @return 分割后的字符串集合
	 */

	public static List<String> splitStringByPicWidth(String str, Graphics2D graphics2D, int picWidth) {
		List<String> strList = new ArrayList<String>();
		int perStrWidth = 0;
		// int strWidth = 0;
		int columnNum = 0; // 图片每行的字符个数
		int listLength = 0;
		if (str != null && str.length() > 0) {
			// 获得单个字的长度
			perStrWidth = graphics2D.getFontMetrics().stringWidth(String.valueOf(str.charAt(0)));
			System.out.println(perStrWidth + "----" + graphics2D.getFontMetrics().getHeight());
			// 按照图片的长度计算一行有多少个字
			columnNum = (perStrWidth > 0 ? (picWidth / perStrWidth) : 0);
			listLength = (columnNum > 0 ? (str.length() / columnNum + 1) : 0);

			// 根据每一行的字数，将字符串分割
			for (int i = 0; i < listLength; i++) {
				strList.add(str.substring(i * columnNum, ((i + 1) * columnNum) >= str.length() ? str.length() : ((i + 1) * columnNum)));
			}
		} else {
			return strList;
		}
		return strList;
	}

	public static FontMetrics getfontMetrics(String str, String fontType, int fontSize, int fontBold) {
		Font font = new Font(fontType, fontBold, fontSize + GimageUtil.FONTSIZEPLUS);
		JLabel label = new JLabel();
		label.setFont(font);
		label.setText(str);
		FontMetrics metrics = label.getFontMetrics(label.getFont());
		return metrics;
	}

	public static List<String> splitStringByPicWidth(String str, int picWidth, String fontType, int fontSize, int fontBold) {

		FontMetrics metrics = getfontMetrics(str, fontType, fontSize, fontBold);

		List<String> strList = new ArrayList<String>();
		int perStrWidth = 0;
		// int strWidth = 0;
		int columnNum = 0; // 图片每行的字符个数
		int listLength = 0;
		if (str != null && str.length() > 0) {
			// 获得单个字的长度
			perStrWidth = metrics.stringWidth(String.valueOf(str.charAt(0)));
			/*
			 * System.out.println(perStrWidth + "----" + metrics.getHeight());
			 */
			// 按照图片的长度计算一行有多少个字
			columnNum = (perStrWidth > 0 ? (picWidth / perStrWidth) : 0);
			listLength = (columnNum > 0 ? (str.length() / columnNum + 1) : 0);
			// 根据每一行的字数，将字符串分割
			for (int i = 0; i < listLength; i++) {
				strList.add(str.substring(i * columnNum, ((i + 1) * columnNum) >= str.length() ? str.length() : ((i + 1) * columnNum)));
			}
		} else {
			return strList;
		}
		return strList;
	}

	public static synchronized void orgImage(String srcImage, List<PrintClazzVO> printClazzVOs) throws UnsupportedEncodingException {
		int height = 0;
		IMOperation op = null;
		FontMetrics metrics;
		for (PrintClazzVO printClazzVO : printClazzVOs) {
			if (printClazzVO.getKey().equals(GimageUtil.TEXT)) {
				if (op == null) {
					op = new IMOperation();
				}
				// 按照width计算每行显示的文字
				List<String> strs = splitStringByPicWidth(printClazzVO.getValue(), printClazzVO.getWidth(), printClazzVO.getFontType(), printClazzVO.getFontSize(), printClazzVO.getFontBold());
				metrics = getfontMetrics(printClazzVO.getValue(), printClazzVO.getFontType(), printClazzVO.getFontSize(), printClazzVO.getFontBold());
				height = metrics.getHeight();
				for (int i = 0; i < strs.size(); i++) {
					if (printClazzVO.getFontBold() == Font.BOLD) {
						op.weight(700);
					} else {
						op.weight(400);
					}
					op.font(printClazzVO.getFontType()).pointsize(printClazzVO.getFontSize() + GimageUtil.FONTSIZEPLUS).fill("#000000").gravity("NorthWest")
							.draw("text " + printClazzVO.getX() + "," + (printClazzVO.getY() + height * i) + " '" + strs.get(i) + "'");

				}

			}/*
			 * else if(printClazzVO.getKey().equals(GimageUtil.IMAGE)) { try {
			 * WatermarkImg(srcImage, srcImage, printClazzVO.getValue(),
			 * printClazzVO.getWidth(),
			 * printClazzVO.getHeight(),printClazzVO.getX
			 * (),printClazzVO.getX(),printClazzVO.getAlpha()); } catch
			 * (Exception e) { e.printStackTrace(); } }
			 */
		}
		if (op != null) {

			// weight("bolder")
			op.addRawArgs("-quality", "100");
			op.addImage(srcImage);
			op.addImage(srcImage);
			MogrifyCmd convert = new MogrifyCmd();
			System.out.println(op);
			String path = property.getImagickPath();
			String osName = System.getProperty("os.name").toLowerCase();
			if (osName.indexOf("win") != -1) {
				convert.setSearchPath(path);
			}

			try {
				convert.run(op);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (PrintClazzVO printClazzVO : printClazzVOs) {
			if (printClazzVO.getKey().equals(GimageUtil.IMAGE)) {
				try {
					// System.out.println(printClazzVO.getValue());
					if (!new File(printClazzVO.getValue()).exists()) {
						System.out.println("picture is not found ： " + printClazzVO.getValue());
					} else {
						WatermarkImg(srcImage, srcImage, printClazzVO.getValue(), printClazzVO.getWidth(), printClazzVO.getHeight(), printClazzVO.getX(), printClazzVO.getY(), printClazzVO.getAlpha());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * try { //WatermarkImg(srcImage, srcImage, "D://cert//photo111.jpg",
		 * 99, 199,200,185 , 100); //WatermarkImg(srcImage, srcImage,
		 * "D://cert//erweima.jpg", 91, 94,209,476 , 100);
		 * //WatermarkImg(srcImage, srcImage, "D://cert//zhang.gif", 206,
		 * 191,631,425 , 100); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

	}

	public void orgImage(String fontType, String srcImage, String str, int fontsize, int x, int y, int width) throws UnsupportedEncodingException {
		int height = 0;

		// 按照width计算每行显示的文字
		List<String> strs = splitStringByPicWidth(str, width, fontType, fontsize, Font.PLAIN);
		/*
		 * for (String str1 : strs) { System.out.println(str1); }
		 */

		FontMetrics metrics = getfontMetrics(str, fontType, fontsize, Font.PLAIN);
		height = metrics.getHeight();
		System.out.println("height = " + height);
		IMOperation op = new IMOperation();

		for (int i = 0; i < strs.size(); i++) {
			op.font(fontType).pointsize(fontsize + 5).fill("#000000").gravity("NorthWest").draw("text " + x + "," + (y + height * i) + " '" + strs.get(i) + "'");
		}
		op.weight(0);
		// weight("bolder")
		op.addRawArgs("-quality", "100");

		op.addImage(srcImage);
		op.addImage(srcImage);
		MogrifyCmd convert = new MogrifyCmd();
		System.out.println(op.getCmdArgs());
		// "C://im//ImageMagick";
		String path = property.getImagickPath();
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("win") != -1) {
			convert.setSearchPath(path);
		}

		try {
			convert.run(op);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void orgImage(String srcImage, String str, int fontsize, int x, int y, boolean watermark) throws UnsupportedEncodingException {
		GMOperation op = new GMOperation();
		// str = "加水印的源的";

		if (watermark) {
			op.font("Arial").pointsize(fontsize + 5).fill("#000000").draw("text " + x + "," + y + " '" + str + "'");
		}
		op.background("white");
		// op.addRawArgs("-thumbnail", "860x614");
		// op.addRawArgs("-gravity", "center");
		// op.addRawArgs("-extent", "860x614");
		op.addRawArgs("-quality", "100");

		// op.geometry(arg0, arg1)
		op.addImage(srcImage);
		op.addImage(srcImage);
		ConvertCmd convert = new ConvertCmd(true);
		String path = "C://Program Files//GraphicsMagick";
		convert.setSearchPath(path);
		try {
			convert.run(op);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cutImage(String srcImage, String targetImage, int width, int height) {
		IMOperation op = new IMOperation();
		op.addRawArgs("-quality", "100");
		op.addImage(srcImage);
		// 图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰
		op.quality(100d);
		op.addRawArgs("-resize", width + "x" + height);
		op.addRawArgs("-gravity", "center");
		op.addImage(targetImage);
		MogrifyCmd convert = new MogrifyCmd();
		System.out.println(op.getCmdArgs());
		/*
		 * String path =
		 * PropertyUtils.getPropertyWithConfigName("sysconfig.properties",
		 * "IMagickPath"); String osName =
		 * System.getProperty("os.name").toLowerCase(); if
		 * (osName.indexOf("win") != -1) { convert.setSearchPath(path); }
		 */
		try {
			convert.run(op);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createImage(String str, Font font, File outFile, Integer width, Integer height) throws Exception {
		// 创建图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		// Graphics g = image.getGraphics();
		g.setClip(0, 0, width, height);
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景
		g.setColor(Color.black);// 在换成黑色
		g.setFont(font);// 设置画笔字体
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		/** 用于获得垂直居中y */
		Rectangle clip = g.getClipBounds();
		FontMetrics fm = g.getFontMetrics(font);
		int ascent = fm.getAscent();
		int descent = fm.getDescent();
		int y = (clip.height - (ascent + descent)) / 2 + ascent;
		for (int i = 0; i < 6; i++) {// 256 340 0 680
			g.drawString(str, i * 680, y);// 画出字符串
		}
		g.dispose();
		ImageIO.write(image, "png", outFile);// 输出png图片
	}

	public static void createBlankImage(String srcImagePath, String outImagePath, String type) throws Exception {
		BufferedImage srcImg = ImageIO.read(new File(srcImagePath));
		File outFile = new File(outImagePath);
		// 创建图片
		BufferedImage image = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		// Graphics g = image.getGraphics();
		g.fillRect(0, 0, srcImg.getWidth(), srcImg.getHeight());// 先用黑色填充整张图片,也就是背景
		g.setColor(Color.white);
		g.dispose();
		ImageIO.write(image, type, outFile);// 输出png图片
	}

}