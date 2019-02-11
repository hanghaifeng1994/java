package cn.com.weye.core.persistence;

import cn.com.weye.utils.key.KeyFactory;
import com.thinkgem.jeesite.common.persistence.TreeEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

import java.util.Date;

/**
 * Created by zpz on 2016/9/14.
 */
public abstract class TreeExtEntity<T> extends TreeEntity<T> {

    public TreeExtEntity() {
        super();
        this.sort = 30;
    }

    public TreeExtEntity(String id) {
        super(id);
    }

    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord){
            setId(genId());
        }
        User user = UserUtils.getUser();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(user.getId())){
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
