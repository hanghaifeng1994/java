package cn.com.weye.modules.sh.web;

import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.sh.entity.ShOrderAddserviceRel;
import cn.com.weye.modules.sh.service.ShOrderAddserviceRelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Controller
@RequestMapping("${adminPath}" + ShOrderAddserviceRelController.BASE_URL)
public class ShOrderAddserviceRelController extends MybatisBaseController<ShOrderAddserviceRel>{

    public static final String BASE_URL = "/sh/ShOrderAddserviceRel/";
    private static final String BASE_PATH = "modules/sh/ShOrderAddserviceRel";

    @Resource
    private ShOrderAddserviceRelService shOrderAddserviceRelService;

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
        return "sh:ShOrderAddserviceRel";
    }

    @Override
    protected MybatisBaseService<ShOrderAddserviceRel> getService() {
        return shOrderAddserviceRelService;
    }
}
