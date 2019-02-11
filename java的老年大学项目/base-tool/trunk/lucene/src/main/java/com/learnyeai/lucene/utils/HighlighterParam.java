package com.learnyeai.lucene.utils;

/**
 * Created by zpz on 2018/9/9.
 */
public class HighlighterParam {
    /**是否需要设置高亮*/
    private boolean highlight;
    /**需要设置高亮的属性名*/
    private String fieldName;
    /**高亮前缀*/
    private String prefix;
    /**高亮后缀*/
    private String suffix;
    /**显示摘要最大长度*/
    private int fragmenterLength;
    public boolean isHighlight() {
        return highlight;
    }
    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public int getFragmenterLength() {
        return fragmenterLength;
    }
    public void setFragmenterLength(int fragmenterLength) {
        this.fragmenterLength = fragmenterLength;
    }
    public HighlighterParam(boolean highlight, String fieldName, String prefix, String suffix, int fragmenterLength) {
        this.highlight = highlight;
        this.fieldName = fieldName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.fragmenterLength = fragmenterLength;
    }

    public HighlighterParam(boolean highlight, String fieldName, int fragmenterLength) {
        this.highlight = highlight;
        this.fieldName = fieldName;
        this.fragmenterLength = fragmenterLength;
    }

    public HighlighterParam(boolean highlight, String fieldName, String prefix, String suffix) {
        this.highlight = highlight;
        this.fieldName = fieldName;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public HighlighterParam() {
    }
}
