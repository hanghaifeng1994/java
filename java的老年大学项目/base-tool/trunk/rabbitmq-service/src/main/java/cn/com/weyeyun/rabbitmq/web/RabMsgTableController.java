package cn.com.weyeyun.rabbitmq.web;

import cn.com.weyeyun.core.IBaseBusinessContext;
import cn.com.weyeyun.rabbitmq.model.RabMsgTempTable;
import cn.com.weyeyun.servicebase.support.*;

import cn.com.weyeyun.rabbitmq.model.RabMsgTable;
import cn.com.weyeyun.rabbitmq.service.RabMsgTableWyService;
import cn.com.weyeyun.tools.common.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    @Value("${MAX_OVERRUN_HOUR}")
    private int maxOverRunHour;

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

    @RequestMapping("/del")
    public int delete(RabMsgTable rabMsgTable){
        String id=rabMsgTable.getMsgId();
        return  rabMsgTableWyService.deleteData(id);
    }

    @RequestMapping("list")
    public MyPage<RabMsgTable> list(RabMsgTable rabMsgTable){
        if(null == rabMsgTable) {
            try {
                rabMsgTable = (RabMsgTable)((RabMsgTable)this.getBaseService().getEntityClass().newInstance());
            } catch (Exception var5) {
                ;
            }
        }

        rabMsgTable.initPage();
        IBaseBusinessContext ctx = ThreadContextUtil.getCtx();
        List<RabMsgTable> rmList = this.getBaseService().queryList(rabMsgTable, ctx.getParamMap());
        Date curDate = Calendar.getInstance().getTime();
        for (RabMsgTable rm:rmList){
            int hMargin = DateHelper.getDateMargin(rm.getCreateDate(), curDate, Calendar.HOUR);
           //消息未确认并且消息未确认的时间大约24小小时
            if(rm.getMsgStatus()==0&&hMargin>maxOverRunHour){
                rm.setCsStatus(1);
            }
        }
        MyPage<RabMsgTable> page=new MyPage<>(rmList);
        return page;
    }
}
