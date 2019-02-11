package ${basePackageName}.dao;

import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import ${basePackageName}.entity.${table.className};

import cn.com.weye.core.persistence.annotation.MyBatisDao;

/**
 * @Description: ${table.remarks}
 * @author ${author}
 */
@MyBatisDao
public interface ${table.className}Dao extends MybatisBaseDao<${table.className}> {
}
