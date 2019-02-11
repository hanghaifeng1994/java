<#assign serviceName = table.className?uncap_first + "WyService" />
package ${basePackageName}.web.api;

import ${basePackageName}.model.${table.className};
import ${basePackageName}.service.${table.className}WyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ${author}
 */
@RestController
@RequestMapping("${r'${adminPath}'}" + ${table.className}Action.BASE_URL)
public class ${table.className}Action extends ApiBaseController<${table.className}> {
    public static final String BASE_URL = "/${table.className}/";

    @Autowired
    private ${table.className}WyService ${serviceName};

    @Override
    protected BaseService<${table.className}> getBaseService() {
        return ${serviceName};
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
