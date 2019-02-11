package com.learnyeai.testing.api.client;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.testing.api.vo.ClzClazzTestVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 答卷的题目答题情况和判分情况
 *
 * @author twang
 */
@FeignClient(name = "SCHOOLECLASS-SERVICE", path="/schoolclass-service/schoolclass/ClzClazzTest")
public interface ClzClazzTestClient extends BaseFeignClient<ClzClazzTestVo> {
    @RequestMapping(
            value = {"/addTsNum"},
            method = {RequestMethod.POST},
            consumes = {"application/x-www-form-urlencoded"}
    )
    int addTsNum(@RequestBody Map<String, Object> params);
}
