package com.learnyeai.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;

/**
 * Created by zpz on 2018/9/13.
 */
public class LengFilterAnalyzer extends Analyzer {
    private int len;

    public int getLen() {
        return len;
    }


    public void setLen(int len) {
        this.len = len;
    }


    public LengFilterAnalyzer() {
        super();
    }


    public LengFilterAnalyzer(int len) {
        super();
        this.len = len;
    }


    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        final Tokenizer source = new WhitespaceTokenizer();
        TokenStream result = new LengthFilter(source, len, Integer.MAX_VALUE);
        return new TokenStreamComponents(source,result);

    }

}
