package cn.com.weye.modules.sh.vo;


import cn.com.weye.modules.sh.entity.ShAppletSetting;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.modules.sh.entity.ShOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2017/12/7.
 */
public class ShMerchantSchemeVo {
    private ShMerchantScheme merchantScheme;
    private List<ShAppletSetting> appletSettings = new ArrayList<ShAppletSetting>();
    private ShOrder order;

    public ShMerchantScheme getMerchantScheme() {
        return merchantScheme;
    }

    public void setMerchantScheme(ShMerchantScheme merchantScheme) {
        this.merchantScheme = merchantScheme;
    }

    public List<ShAppletSetting> getAppletSettings() {
        return appletSettings;
    }

    public void setAppletSettings(List<ShAppletSetting> appletSettings) {
        this.appletSettings = appletSettings;
    }

    public ShOrder getOrder() {
        return order;
    }

    public void setOrder(ShOrder order) {
        this.order = order;
    }
}
