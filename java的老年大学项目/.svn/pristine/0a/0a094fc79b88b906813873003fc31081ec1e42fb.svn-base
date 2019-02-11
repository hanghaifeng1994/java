package com.learnyeai.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.pattern.PatternTokenizer;

import java.util.regex.Pattern;

/**
 * Created by zpz on 2018/9/13.
 */
public class PatternAnalyzer  extends Analyzer {



    String regex;//使用的正则拆分式

    public PatternAnalyzer(String regex) {

        this.regex=regex;

    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return new TokenStreamComponents(new PatternTokenizer(Pattern.compile(regex),-1));

    }

}