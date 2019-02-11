package cn.com.weyeyun.commoncert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.common.lib.springside.entity.AutoIdEntity;

/**
 * 
 * 证书模板实体类
 * 
 * @author fangyong
 * @version 1.0
 * @since 2012-9-3
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name = "certtemplate")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CertTemplate extends AutoIdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = -3100366768440953058L;

    private String            name;                                    // 模板名称

    private String            imageName;                               // 模板图片名称

    private String            fixedImage;                              // 固定图片

    private String            subject;                                 // 模板内容

    private boolean           status;                                  // 是否启用的状态，true表示启用

    private String            textOne;                                 // 打印文本1

    private String            textTwo;                                 // 打印文本2

    private String            textThree;                               // 打印文本3

    private String            textFour;                                // 打印文本4

    private String            textFive;                                // 打印文本5

    private String            textSix;                                 // 打印文本6

    private String            textSeven;                               // 打印文本7

    private String            textEight;                               // 打印文本8

    private String            textNine;                                // 打印文本9

    private String            textTen;                                 // 打印文本10

    private String            textEleven;                              // 打印文本11

    private String            textTwelve;                              // 打印文本12

    private String            textThirteen;                            // 打印文本13

    private String            textFourteen;                            // 打印文本14

    private String            textFifteen;                             // 打印文本15

    private String            imageUrlOne;                             // 打印图片1

    private String            imageUrlTwo;                             // 打印图片1

    private String            imageUrlThree;                           // 打印图片3

    private String            imageUrlFour;                            // 打印图片4

    private String            imageUrlFive;                            // 打印图片5

    private String            staticOne;                                // 静态文本1

    private String            staticTwo;                                // 静态文本2

    private String            staticThree;                              // 静态文本3
    
    private Long			  createTenantId;							//创建者租户id

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    @Column(name = "text_one")
    public String getTextOne()
    {
        return textOne;
    }

    public void setTextOne(String textOne)
    {
        this.textOne = textOne;
    }

    @Column(name = "text_two")
    public String getTextTwo()
    {
        return textTwo;
    }

    public void setTextTwo(String textTwo)
    {
        this.textTwo = textTwo;
    }

    @Column(name = "text_three")
    public String getTextThree()
    {
        return textThree;
    }

    public void setTextThree(String textThree)
    {
        this.textThree = textThree;
    }

    @Column(name = "text_four")
    public String getTextFour()
    {
        return textFour;
    }

    public void setTextFour(String textFour)
    {
        this.textFour = textFour;
    }

    @Column(name = "text_five")
    public String getTextFive()
    {
        return textFive;
    }

    public void setTextFive(String textFive)
    {
        this.textFive = textFive;
    }

    @Column(name = "text_six")
    public String getTextSix()
    {
        return textSix;
    }

    public void setTextSix(String textSix)
    {
        this.textSix = textSix;
    }

    @Column(name = "text_seven")
    public String getTextSeven()
    {
        return textSeven;
    }

    public void setTextSeven(String textSeven)
    {
        this.textSeven = textSeven;
    }

    @Column(name = "text_eight")
    public String getTextEight()
    {
        return textEight;
    }

    public void setTextEight(String textEight)
    {
        this.textEight = textEight;
    }

    @Column(name = "text_nine")
    public String getTextNine()
    {
        return textNine;
    }

    public void setTextNine(String textNine)
    {
        this.textNine = textNine;
    }

    @Column(name = "text_ten")
    public String getTextTen()
    {
        return textTen;
    }

    public void setTextTen(String textTen)
    {
        this.textTen = textTen;
    }

    public String getTextEleven()
    {
        return textEleven;
    }

    public void setTextEleven(String textEleven)
    {
        this.textEleven = textEleven;
    }

    public String getTextTwelve()
    {
        return textTwelve;
    }

    public void setTextTwelve(String textTwelve)
    {
        this.textTwelve = textTwelve;
    }

    public String getTextThirteen()
    {
        return textThirteen;
    }

    public void setTextThirteen(String textThirteen)
    {
        this.textThirteen = textThirteen;
    }

    public String getTextFourteen()
    {
        return textFourteen;
    }

    public void setTextFourteen(String textFourteen)
    {
        this.textFourteen = textFourteen;
    }

    public String getTextFifteen()
    {
        return textFifteen;
    }

    public void setTextFifteen(String textFifteen)
    {
        this.textFifteen = textFifteen;
    }

    @Column(name = "imageurlone")
    public String getImageUrlOne()
    {
        return imageUrlOne;
    }

    public void setImageUrlOne(String imageUrlOne)
    {
        this.imageUrlOne = imageUrlOne;
    }

    @Column(name = "imageurltwo")
    public String getImageUrlTwo()
    {
        return imageUrlTwo;
    }

    public void setImageUrlTwo(String imageUrlTwo)
    {
        this.imageUrlTwo = imageUrlTwo;
    }

    @Column(name = "imageurlthree")
    public String getImageUrlThree()
    {
        return imageUrlThree;
    }

    public void setImageUrlThree(String imageUrlThree)
    {
        this.imageUrlThree = imageUrlThree;
    }

    @Column(name = "imageurlfour")
    public String getImageUrlFour()
    {
        return imageUrlFour;
    }

    public void setImageUrlFour(String imageUrlFour)
    {
        this.imageUrlFour = imageUrlFour;
    }

    @Column(name = "imageurlfive")
    public String getImageUrlFive()
    {
        return imageUrlFive;
    }

    public void setImageUrlFive(String imageUrlFive)
    {
        this.imageUrlFive = imageUrlFive;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "image_name")
    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }

    @Column(name = "subject")
	@Lob
    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    @Column(name = "fixed_image")
    public String getFixedImage()
    {
        return fixedImage;
    }

    public void setFixedImage(String fixedImage)
    {
        this.fixedImage = fixedImage;
    }

    @Column(name = "static_one")
    public String getStaticOne()
    {
        return staticOne;
    }

    public void setStaticOne(String staticOne)
    {
        this.staticOne = staticOne;
    }

    @Column(name = "static_two")
    public String getStaticTwo()
    {
        return staticTwo;
    }

    public void setStaticTwo(String staticTwo)
    {
        this.staticTwo = staticTwo;
    }

    @Column(name = "static_three")
    public String getStaticThree()
    {
        return staticThree;
    }

    public void setStaticThree(String staticThree)
    {
        this.staticThree = staticThree;
    }

	public void setCreateTenantId(Long createTenantId) {
		this.createTenantId = createTenantId;
	}

	public Long getCreateTenantId() {
		return createTenantId;
	}

}
