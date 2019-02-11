package cn.com.weyeyun.commoncert.vo;

import org.springframework.stereotype.Component;

import cn.com.weyeyun.commoncert.util.GimageUtil;

@Component
public class PrintClazzVO {

	private String key;   
	private String value;
	private int width;
	private int height;
	private int x;
	private int y;
	private String fontType;
	private int fontSize = 12;
	private int fontBold;
	private int alpha = GimageUtil.ALPHA;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getFontType() {
		return fontType;
	}

	public void setFontType(String fontType) {
		this.fontType = fontType;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setFontBold(int fontBold) {
		this.fontBold = fontBold;
	}

	public int getFontBold() {
		return fontBold;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

}
