package com.learnyeai.lucene.analyzer;

import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.AttributeFactory;

/**
 * Created by zpz on 2018/9/13.
 */
public class SpiltTokenizer  extends CharTokenizer {
    private char c = ',';
    public SpiltTokenizer(char arg) {
        c = arg;
    }
    public SpiltTokenizer(AttributeFactory factory, char c) {
        super(factory);
        this.c = c;
    }
    protected boolean isTokenChar(int arg) {
        return !(c == arg);
    }
}