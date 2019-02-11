package com.learnyeai.tools.http;

import java.io.InputStream;

/**
 * 流文件的数据bean
 * Created by zpz on 2017/9/20.
 */
public class StreamFileBean extends FileBean{
    private InputStream inputStream; // 输入流

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
