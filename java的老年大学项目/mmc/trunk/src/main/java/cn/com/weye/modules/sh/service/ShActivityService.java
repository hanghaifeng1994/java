package cn.com.weye.modules.sh.service;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.sh.dao.ShActivityDao;
import cn.com.weye.modules.sh.entity.ShActivity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class ShActivityService extends MybatisBaseService<ShActivity> {

    @Resource
    private ShActivityDao shActivityDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_ACTIVITY";
    }

    @Override
    public String getIdKey() {
        return "actId";
    }

    @Override
    public MybatisBaseDao<ShActivity> getDao() {
        return shActivityDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
