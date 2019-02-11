package cn.com.weyeyun.rabbitmq.web;

import cn.com.weyeyun.servicebase.support.ApiBaseController;
import cn.com.weyeyun.servicebase.support.BaseService;

import cn.com.weyeyun.rabbitmq.model.RabMsgTempTable;
import cn.com.weyeyun.rabbitmq.service.RabMsgTempTableWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("${adminPath}" + RabMsgTempTableController.BASE_URL)
public class RabMsgTempTableController extends ApiBaseController<RabMsgTempTable> {
    public static final String BASE_URL = "/RabMsgTempTable/";

    @Autowired
    private RabMsgTempTableWyService rabMsgTempTableWyService;

    @Override
    protected BaseService<RabMsgTempTable> getBaseService() {
        return rabMsgTempTableWyService;
    }
    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
