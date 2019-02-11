package cn.com.weye.core.persistence;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import com.thinkgem.jeesite.common.persistence.CrudDao;

import java.util.List;

/**
 * Created by zpz on 2016/9/19.
 */
public interface CrudExtDao<T> extends CrudDao<T> {
    /**
     * 查询数量
     * @param query
     * @return
     */
    int countByCriteria(DBQuery query);

    /**
     * 查询删除
     * @param query
     * @return
     */
    Integer deleteByCriteria(DBQuery query);

    /**
     * 条件查询，支持分页
     * @param query
     * @return
     */
    List<T> queryByCriteria(DBQuery query);
}
