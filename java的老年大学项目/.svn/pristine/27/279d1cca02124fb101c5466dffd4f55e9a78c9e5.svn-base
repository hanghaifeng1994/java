package cn.com.weyeyun.rabbitmq.consumer.demo.web;

import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTempTable;
import cn.com.weyeyun.servicebase.support.ApiBaseController;
import cn.com.weyeyun.servicebase.support.BaseService;

import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTable;
import cn.com.weyeyun.rabbitmq.consumer.demo.service.RabMsgTableWyService;
import cn.com.weyeyun.servicebase.support.MyPage;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@RestController
@RequestMapping("/Rabbit")
public class RabMsgTableController extends ApiBaseController<RabMsgTable> {
    public static final String BASE_URL = "/RabMsgTable/";

    @Autowired
    private RabMsgTableWyService rabMsgTableWyService;
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    protected BaseService<RabMsgTable> getBaseService() {
        return rabMsgTableWyService;
    }
    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @RequestMapping("/reSend")
    public String reSend(RabMsgTable rabMsgTable){
            rabMsgTableWyService.reSend(rabMsgTable);
            return  "1";
    }

    @Override
    public int delete(@PathVariable Object id){

        return  rabMsgTableWyService.deleteData(String.valueOf(id));
    }

    @RequestMapping("list")
    public List<RabMsgTable> list(RabMsgTable rabMsgTable){
        MyPage<RabMsgTable> page=super.listPage(rabMsgTable);
        List<RabMsgTable> list=page.getList();
        return list;
    }
}
