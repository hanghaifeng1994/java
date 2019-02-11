package com.learnyeai.base.vo;

import com.learnyeai.base.model.CustInfo;
import com.learnyeai.tools.excel.annotation.ExcelField;

import java.util.Date;

/**
 * Created by zpz on 2018/9/28.
 */
public class CustInfoXlsCommon extends CustInfo {

    @ExcelField( title = "用户名",sort = 1, groups = 1)
    @Override
    public String getCustName() {
        return super.getCustName();
    }
    @ExcelField(title = "身份证号", sort = 10, groups = 1)
    @Override
    public String getIdcarNo() {
        return super.getIdcarNo();
    }
    @ExcelField(title = "生日", sort = 20, groups = 1)
    @Override
    public String getPhone() {
        return super.getPhone();
    }
    @ExcelField(title = "email", sort = 30, groups = 1)
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @ExcelField(title = "性别", sort = 40, groups = 1)
    @Override
    public String getSex() {
        return super.getSex();
    }

    @ExcelField(title = "生日", sort = 50, groups = 1)
    @Override
    public Date getBirthday() {
        return super.getBirthday();
    }

    @ExcelField(title = "组织机构", sort = 60, groups = 1)
    @Override
    public String getOffice() {
        return super.getOffice();
    }


}
