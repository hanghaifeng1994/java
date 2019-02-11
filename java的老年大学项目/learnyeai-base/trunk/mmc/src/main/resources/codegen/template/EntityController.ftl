<#assign serviceName = table.className?uncap_first + "Service" />
package ${basePackageName}.web;

import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import ${basePackageName}.entity.${table.className};
import ${basePackageName}.service.${table.className}Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 *
 * @author ${author}
 */
@Controller
@RequestMapping("${r'${adminPath}'}" + ${table.className}Controller.BASE_URL)
public class ${table.className}Controller extends MybatisBaseController<${table.className}>{

    public static final String BASE_URL = "/${moduleName}/${table.className}/";
    private static final String BASE_PATH = "modules/${moduleName}/${table.className}";

    @Resource
    private ${table.className}Service ${serviceName};

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected String getBasePath() {
        return BASE_PATH;
    }

    @Override
    protected String getBasePermission() {
        return "${moduleName}:${table.className}";
    }

    @Override
    protected MybatisBaseService<${table.className}> getService() {
        return ${serviceName};
    }
}
