package com.learnyeai.file.web;

import com.learnyeai.file.fastdfs.FastDfsProperties;
import com.learnyeai.file.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 获取服务器配置
 * Created by zpz on 2018/9/3.
 */
@RestController
public class GainServerSettingController {
    @Autowired
    private FastDfsProperties fastDfsProperties;

    @RequestMapping("/getSetting.do")
    public Map getSetting(){
        Map rst = BaseResponse.ok("获取配置成功");
        rst.put("data", fastDfsProperties);
        return rst;
    }
}
