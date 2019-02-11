package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 客户
 *
 * @author zhangpz
 */
public class CustInfoVo extends BaseVo {

    /**
    * 用户id
    */
    private String custId;

    /**
     * 姓名
     */
    private String custName;
    /**
     * 用户昵称
     */
    private String shortName;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 人员类型 1员工、2用户、3系统人员
     */
    private String custType;
    /**
     * N: 正常 D: 普通冻结 C: 注销 E:人工冻结
     */
    private String userStatus;
    /**
     * 冻结时间
     */
    private Date freezeDate;
    /**
     * 性别
     */
    private String sex;
    /**
     * 用户生日
     */
    private Date birthday;
    /**
     * 头像
     */
    private String photo;
    /**
     * 个性签名
     */
    private String sign;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * qq
     */
    private String qq;
    /**
     * 微信
     */
    private String weixin;
    /**
     * 所属单位
     */
    private String office;
    /**
     * 身份证号码
     */
    private String idcarNo;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * OPEN_ID
     */
    private String openId;
    /**
     * UNIONID
     */
    private String unionid;
    /**
     * 员工类型由各方案定义
     */
    private String staffType;
    /**
     * 员工用户时，管理员标识：0否、1是
     */
    private String custIsAdmin;
    /**
     * 商户方案id
     */
    private String mchtSchmId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 站点id
     */
    private String siteId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    public Date getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    public String getIdcarNo() {
        return idcarNo;
    }

    public void setIdcarNo(String idcarNo) {
        this.idcarNo = idcarNo;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }
    public String getCustIsAdmin() {
        return custIsAdmin;
    }

    public void setCustIsAdmin(String custIsAdmin) {
        this.custIsAdmin = custIsAdmin;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public static class CF {
        public static String custId = "custId";  // 用户id
        public static String custName = "custName";  // 姓名
        public static String shortName = "shortName";  // 用户昵称
        public static String loginName = "loginName";  // 登录名
        public static String password = "password";  // 密码
        public static String custType = "custType";  // 人员类型 1员工、2用户、3系统人员
        public static String userStatus = "userStatus";  // N: 正常 D: 普通冻结 C: 注销 E:人工冻结
        public static String freezeDate = "freezeDate";  // 冻结时间
        public static String sex = "sex";  // 性别
        public static String birthday = "birthday";  // 用户生日
        public static String photo = "photo";  // 头像
        public static String sign = "sign";  // 个性签名
        public static String phone = "phone";  // 手机号
        public static String email = "email";  // 邮箱
        public static String qq = "qq";  // qq
        public static String weixin = "weixin";  // 微信
        public static String office = "office";  // 所属单位
        public static String idcarNo = "idcarNo";  // 身份证号码
        public static String createDate = "createDate";  // 创建时间
        public static String openId = "openId";  // OPEN_ID
        public static String unionid = "unionid";  // UNIONID
        public static String staffType = "staffType";  // 员工类型由各方案定义
        public static String custIsAdmin = "custIsAdmin";  // 员工用户时，管理员标识：0否、1是
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String mchtId = "mchtId";  // 商户id
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点id

    }

}
