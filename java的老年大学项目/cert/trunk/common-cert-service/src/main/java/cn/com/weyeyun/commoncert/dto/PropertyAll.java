package cn.com.weyeyun.commoncert.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyAll {
	@Value("${traincore.uploadpath}")
	public String uploadPath;

	@Value("${traincore.uploadpath.url}")
	public String uploadUrl;

	@Value("${offlinecert.url}")
	public String offlinecertUrl;

	@Value("${cert.font.default.path}")
	public String certFontDefaultPath;
	@Value("${cert.font.kaiti.path}")
	public String certFontKaitiPath;
	@Value("${cert.font.heiti.path}")
	public String certFontHeitiPath;
	@Value("${cert.font.songti.path}")
	public String certFontSongtiPath;
	@Value("${cert.font.xinsongti.path}")
	public String certFontXinsongtiPath;
	@Value("${cert.font.weiruanyahei.path}")
	public String certFontWeiruanyaheiPath;
	@Value("${cert.font.fangsong.path}")
	public String certFontFangsongPath;
	@Value("${IMagickPath}")
	public String imagickPath;
	

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getOfflinecertUrl() {
		return offlinecertUrl;
	}

	public void setOfflinecertUrl(String offlinecertUrl) {
		this.offlinecertUrl = offlinecertUrl;
	}

	public String getCertFontDefaultPath() {
		return certFontDefaultPath;
	}

	public void setCertFontDefaultPath(String certFontDefaultPath) {
		this.certFontDefaultPath = certFontDefaultPath;
	}

	public String getCertFontKaitiPath() {
		return certFontKaitiPath;
	}

	public void setCertFontKaitiPath(String certFontKaitiPath) {
		this.certFontKaitiPath = certFontKaitiPath;
	}

	public String getCertFontHeitiPath() {
		return certFontHeitiPath;
	}

	public void setCertFontHeitiPath(String certFontHeitiPath) {
		this.certFontHeitiPath = certFontHeitiPath;
	}

	public String getCertFontSongtiPath() {
		return certFontSongtiPath;
	}

	public void setCertFontSongtiPath(String certFontSongtiPath) {
		this.certFontSongtiPath = certFontSongtiPath;
	}

	public String getCertFontXinsongtiPath() {
		return certFontXinsongtiPath;
	}

	public void setCertFontXinsongtiPath(String certFontXinsongtiPath) {
		this.certFontXinsongtiPath = certFontXinsongtiPath;
	}

	public String getCertFontWeiruanyaheiPath() {
		return certFontWeiruanyaheiPath;
	}

	public void setCertFontWeiruanyaheiPath(String certFontWeiruanyaheiPath) {
		this.certFontWeiruanyaheiPath = certFontWeiruanyaheiPath;
	}

	public String getCertFontFangsongPath() {
		return certFontFangsongPath;
	}

	public void setCertFontFangsongPath(String certFontFangsongPath) {
		this.certFontFangsongPath = certFontFangsongPath;
	}

	public String getImagickPath() {
		return imagickPath;
	}

	public void setImagickPath(String imagickPath) {
		this.imagickPath = imagickPath;
	}

}
