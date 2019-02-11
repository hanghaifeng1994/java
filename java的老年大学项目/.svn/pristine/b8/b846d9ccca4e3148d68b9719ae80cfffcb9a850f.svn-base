package io.ymq.lucene;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import com.learnyeai.lucene.analyzer.SplitAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * Created by zpz on 2018/9/13.
 */
public class AnalyzerTest {

    @Test
    public void aa(){
//        Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer(true);//中文分词
//        Analyzer analyzer = new ComplexAnalyzer();//中文分词
//        Analyzer analyzer = new IKAnalyzer();//中文分词

        String words = "主站下发,课程";
//        String words = "4f1674eb26434a9a9831f9fbef063e30";
        TokenStream stream = null;

        try {
            stream = analyzer.tokenStream("myfield", words);
            stream.reset();
            CharTermAttribute offsetAtt = stream.addAttribute(CharTermAttribute.class);
            while (stream.incrementToken()) {
                System.out.println(offsetAtt.toString());
            }
            stream.end();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Test
    public void split(){
        Analyzer analyzer = new SplitAnalyzer(',');

        String words = "主站下发,,,课程";
//        String words = "4f1674eb26434a9a9831f9fbef063e30";
        TokenStream stream = null;

        try {
            stream = analyzer.tokenStream("myfield", words);
            stream.reset();
            CharTermAttribute offsetAtt = stream.addAttribute(CharTermAttribute.class);
            while (stream.incrementToken()) {
                System.out.println(offsetAtt.toString());
            }
            stream.end();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
