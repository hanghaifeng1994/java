package cn.com.weye.core.persistence;

import cn.com.weye.utils.key.KeyFactory;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by zpz on 2016/9/13.
 */
public abstract class DataExtEntity<T> extends DataEntity<T> {

    public DataExtEntity() {
    }

    public DataExtEntity(String id) {
        super(id);
    }

    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord){
            setId(genId());
        }
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user;
            this.createBy = user;
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    public String genId(){
        return KeyFactory.getKeyGenerator(getTableName()).genNextKey();
    }

    public abstract String getTableName();
}
