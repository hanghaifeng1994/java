package com.learnyeai.core.support;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 小程序
 *
 * @author zhangpz
 */
public interface BaseFeignClient<T> {
    @RequestMapping(value = {"/listPage"}
    ,method = RequestMethod.POST
    , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    MyPage<T> listPage(Map<String, Object> params);

    @RequestMapping(value = {"/getList"}
            ,method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    List<T> getList(Map<String, Object> params);

    @RequestMapping(value = "/view/{id}")
    T view(@PathVariable(value = "id") Object id);

    @RequestMapping(value = "/delete/{id}")
    int delete(@PathVariable(value = "id") Object id);


    @RequestMapping(value = {"/save"}
            ,method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    String save(T param);

    @RequestMapping(value = {"/save"}
            ,method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    String save(Map<String, Object> params);
}
