package com.learnyeai.schoolclass.web.api;

import com.learnyeai.schoolclass.api.vo.ClzClazzTestVo;
import com.learnyeai.schoolclass.model.ClzClazzTest;
import com.learnyeai.schoolclass.service.ClzClazzTestWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzClazzTestAction.BASE_URL)
public class ClzClazzTestAction extends ApiBaseController<ClzClazzTest> {
    public static final String BASE_URL = "/ClzClazzTest/";

    @Autowired
    private ClzClazzTestWyService clzClazzTestWyService;

    @Override
    protected BaseService<ClzClazzTest> getBaseService() {
        return clzClazzTestWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @RequestMapping("addTsNum")
    public int addTsNum(@RequestBody  Map<String,Object> test){
        ClzClazzTest ct=new ClzClazzTest();
        String tsId= MapUtil.singleNodeText(test,"tsId");
        String czId= MapUtil.singleNodeText(test,"czId");
        ct.setTsId(tsId);
        ct.setCzId(czId);
        List<ClzClazzTest> t=clzClazzTestWyService.queryList(ct,test);
        ClzClazzTest clazzTest=new ClzClazzTest();
       int i=0;
        if(t !=null && t.size()>0){
            clazzTest=t.get(0);
            Integer num =clazzTest.getTsNum();
            if(num ==null){
               num=0;
            }
            num++;
            clazzTest.setTsNum(num);
            i=   clzClazzTestWyService.save(clazzTest);
        }
        return i;
    }

}
