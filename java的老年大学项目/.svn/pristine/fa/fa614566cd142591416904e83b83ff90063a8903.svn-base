package cn.com.weyeyun.commoncert.dto;

/**
 * 
 * 用户证书类 当每次有用户学时得以认定后，触发生成证书业务方法 有三种情况触发： 1.信息系统有认证动作 2.信息导入学员学时 3.专技系统同步数据过来
 * 生成证书业务方法判断触发的年度是否有累计认定学时达到72小时，达到就生成，已经生成则不在生成
 * 
 * @author zhaowei
 * @version 1.0
 * @since 2012-12-15
 */
public class CertDTO{
	
	public Long id;

	private int serialNum; // 证书流水编号

	private String code; // 证书编号

	private String name; // 证书名称

	private String unit;// 单位

	private Long certtemplateId;     // 证书对应的模板Id
	
	private String certTemplateName; // 证书对应的模板名称

    private String            templateText;          // 证书对应模板的文本对应的值

    private String            templateImage;         // 证书对应模板的图片对应的值
    
    private Long tenantId;           //证书创建者所在区id
    
    private String tenantName;       //证书创建者所在区id
    private int numCode;       //证书位数
    
    private int certType;//证书类型
    
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
    
	public Long getCerttemplateId() {
		return certtemplateId;
	}

	public void setCerttemplateId(Long certtemplateId) {
		this.certtemplateId = certtemplateId;
	}

    public String getTemplateText()
    {
        return templateText;
    }

    public void setTemplateText(String templateText)
    {
        this.templateText = templateText;
    }

    public String getTemplateImage()
    {
        return templateImage;
    }

    public void setTemplateImage(String templateImage)
    {
        this.templateImage = templateImage;
    }
    
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCertTemplateName(String certTemplateName) {
		this.certTemplateName = certTemplateName;
	}

	public String getCertTemplateName() {
		return certTemplateName;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
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
