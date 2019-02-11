package cn.com.weye.modules.sh.web;

import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.sh.entity.ShActivity;
import cn.com.weye.modules.sh.service.ShActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yl
 */
@Controller
@RequestMapping("${adminPath}" + ShActivityController.BASE_URL)
public class ShActivityController extends MybatisBaseController<ShActivity>{

    public static final String BASE_URL = "/sh/ShActivity/";
    private static final String BASE_PATH = "modules/sh/ShActivity";

    @Resource
    private ShActivityService shActivityService;

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
        return "sh:ShActivity";
    }

    @Override
    protected MybatisBaseService<ShActivity> getService() {
        return shActivityService;
    }


    @RequestMapping("publish")
    public String publish(ShActivity entity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        super.save(entity,request,redirectAttributes);
        return  repageListPath;
    }
}
