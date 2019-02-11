package com.learnyeai.file.fastdfs;

import feign.RequestLine;

/**
 * Created by zpz on 2018/9/3.
 */
public interface FileServerClient {
    @RequestLine( value = "GET /file-service/getSetting.do")
    String getSetting();
}
