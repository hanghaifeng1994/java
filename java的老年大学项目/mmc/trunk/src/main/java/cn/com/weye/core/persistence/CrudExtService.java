package cn.com.weye.core.persistence;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.service.CrudService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zpz on 2016/9/19.
 */
public abstract class CrudExtService<D extends CrudExtDao<T>, T extends DataEntity<T>> extends CrudService<D,T>{
    @Override
    @Transactional(readOnly = false)
    public void save(T entity) {
        if (entity.getIsNewRecord()){
            entity.preInsert();
            dao.insert(entity);
        }else{
            entity.preUpdate();
            dao.updateByIdSelective(entity);
        }
    }

    public List<T> queryByCriteria(DBQuery query) {
        return dao.queryByCriteria(query);
    }

    public Integer deleteByCriteria(DBQuery query){
        return dao.deleteByCriteria(query);
    }

    public Page<T> queryPage(DBQuery query, Page<T> page) {
        query.setPage(page);
        return page;
    }
}
