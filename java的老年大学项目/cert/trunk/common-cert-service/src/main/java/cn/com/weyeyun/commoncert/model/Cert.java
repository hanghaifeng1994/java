package cn.com.weyeyun.commoncert.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.common.lib.springside.entity.AutoIdEntity;

/**
 * 
 * 用户证书类 当每次有用户学时得以认定后，触发生成证书业务方法 有三种情况触发： 1.信息系统有认证动作 2.信息导入学员学时 3.专技系统同步数据过来
 * 生成证书业务方法判断触发的年度是否有累计认定学时达到72小时，达到就生成，已经生成则不在生成
 * 
 * @author zhaowei
 * @version 1.0
 * @since 2012-12-15
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name = "cert")
// 默认的缓存策略
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cert extends AutoIdEntity {
	private static final long serialVersionUID = 448764257799847483L;
	public static int CERT_OFFLINE=1;//线下证书
	public static int CERT_PROGRAME=0;//项目证书

	private int serialNum; // 证书流水编号

	@Column(nullable = false)
	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String code; // 证书编号

	private String name; // 证书名称

	private String unit;// 单位

	private CertTemplate certTemplate; // 证书对应的模板
	
    private String            templateText;          // 证书对应模板的文本对应的值

    private String            templateImage;         // 证书对应模板的图片对应的值
    
    private Long tenantId;         //课程创建者所在区id
    
    private int numCode;       //证书位数
    
    private int certType;//证书类型
    
       
    @Column(name = "template_text")
    public String getTemplateText()
    {
        return templateText;
    }

    public void setTemplateText(String templateText)
    {
        this.templateText = templateText;
    }

    @Column(name = "template_image")
    public String getTemplateImage()
    {
        return templateImage;
    }

    public void setTemplateImage(String templateImage)
    {
        this.templateImage = templateImage;
    }
    
	@Column(nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setCertTemplate(CertTemplate certTemplate) {
		this.certTemplate = certTemplate;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "certtemplate_id")
	public CertTemplate getCertTemplate() {
		return certTemplate;
	}

	public int getNumCode() {
		return numCode;
	}

	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}

	public int getCertType() {
		return certType;
	}

	public void setCertType(int certType) {
		this.certType = certType;
	}
	
}
