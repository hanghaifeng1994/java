package cn.com.weyeyun.commoncert.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.common.lib.springside.entity.AutoIdEntity;

/**
 * 
 * 用户线下证书类
 * 
 * @author twang
 * @version 1.0
 * @since 2017-08-20
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "usercert_offline", uniqueConstraints = { @UniqueConstraint(name = "userid_cert_uni", columnNames = { "userId", "cert_id" }) })
// 默认的缓存策略
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserCertOffline extends AutoIdEntity {
	private static final long serialVersionUID = -7517474682635853425L;
	private String userId; // 用户id
	private Cert cert; // 证书,打印是获取模板数据来源于生成
	private String username; // 用户名
	private String idcard;// 身份证号码
	private String unit;// 单位
	private String name;// 姓名
	private String program;
	private String phase;//培训年度
	private String mobilePhone;// 手机号
	private String certno; // 证书编号
	private String year;
	private String month;
	private String day;
	private String score;//学分
	private String tenantId;
	private Date genTime; // 发证时间
	private boolean published; // 是否发布
	private Date publishedTime; // 发布时间
	private boolean printed; // 是否打印
	private Date printedTime; // 打印时间
	private String col01;// 第一列
	private String col02;// 第二列
	private String col03;// 第三列
	private String col04;// 第四列
	private String col05;// 第五列
	private String col06;// 第六列
	private String col07;// 第七列
	private String col08;// 第八列
	private String col09;// 第九列
	private String col10;// 第十列

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "cert_id", nullable = false)
	public Cert getCert() {
		return cert;
	}

	public void setCert(Cert cert) {
		this.cert = cert;
	}

	public Date getGenTime() {
		return genTime;
	}

	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Date getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	public boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean printed) {
		this.printed = printed;
	}

	public Date getPrintedTime() {
		return printedTime;
	}

	public void setPrintedTime(Date printedTime) {
		this.printedTime = printedTime;
	}

	public String getCol01() {
		return col01;
	}

	public void setCol01(String col01) {
		this.col01 = col01;
	}

	public String getCol02() {
		return col02;
	}

	public void setCol02(String col02) {
		this.col02 = col02;
	}

	public String getCol03() {
		return col03;
	}

	public void setCol03(String col03) {
		this.col03 = col03;
	}

	public String getCol04() {
		return col04;
	}

	public void setCol04(String col04) {
		this.col04 = col04;
	}

	public String getCol05() {
		return col05;
	}

	public void setCol05(String col05) {
		this.col05 = col05;
	}

	public String getCol06() {
		return col06;
	}

	public void setCol06(String col06) {
		this.col06 = col06;
	}

	public String getCol07() {
		return col07;
	}

	public void setCol07(String col07) {
		this.col07 = col07;
	}

	public String getCol08() {
		return col08;
	}

	public void setCol08(String col08) {
		this.col08 = col08;
	}

	public String getCol09() {
		return col09;
	}

	public void setCol09(String col09) {
		this.col09 = col09;
	}

	public String getCol10() {
		return col10;
	}

	public void setCol10(String col10) {
		this.col10 = col10;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCertno() {
		return certno;
	}

	public void setCertno(String certno) {
		this.certno = certno;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
