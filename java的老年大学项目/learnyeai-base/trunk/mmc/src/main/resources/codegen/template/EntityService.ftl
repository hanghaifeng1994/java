<#assign daoName = table.className?uncap_first + "Dao" />
package ${basePackageName}.service;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import ${basePackageName}.dao.${table.className}Dao;
import ${basePackageName}.entity.${table.className};
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author ${author}
 */
@Service
public class ${table.className}Service extends MybatisBaseService<${table.className}> {

    @Resource
    private ${table.className}Dao ${daoName};

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("${table.schemaPropName}") + ".${table.name}";
    }

    @Override
    public String getIdKey() {
        return "${table.primaryField.name}";
    }

    @Override
    public MybatisBaseDao<${table.className}> getDao() {
        return ${daoName};
    }
    
    @Override
    protected boolean isLogicDelete(){
<#assign del = 0/>
<#list table.fieldList as field>
    <#if field.collumnName = "DEL_FLAG"><#assign del = 1/></#if>
</#list>
<#if del = 1>
        return true;
<#else>
        return false;
</#if>
    }
}
