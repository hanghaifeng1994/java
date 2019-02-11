package com.learnyeai.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;

/**
 * Created by zpz on 2018/9/13.
 */
public class SplitAnalyzer extends Analyzer {

    char c;//按特定符号进行拆分



    public SplitAnalyzer(char c) {
        this.c=c;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return  new TokenStreamComponents(new SpiltTokenizer(c));
    }
}