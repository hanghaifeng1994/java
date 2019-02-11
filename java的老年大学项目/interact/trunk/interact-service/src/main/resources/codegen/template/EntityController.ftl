<#assign serviceName = table.className?uncap_first + "WyService" />
package ${basePackageName}.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import ${basePackageName}.model.${table.className};
import ${basePackageName}.service.${table.className}WyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ${author}
 */
@Component
public class ${table.className}Controller extends BaseController<${table.className}> {

    @Autowired
    private ${table.className}WyService ${serviceName};

    @Override
    protected WeyeBaseService<${table.className}> getService() {
        return ${serviceName};
    }
}
