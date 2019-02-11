package com.learnyeai.lucene.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zpz on 2018/9/9.
 */
public class LuceneManager {

    private String indexDir;
    private IndexReader reader;

    private IndexSearcher searcher;
    private Directory directory;
    private Analyzer analyzer = new SmartChineseAnalyzer();

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final Lock writerLock = new ReentrantLock();

    //private final Lock readerLock = new ReentrantLock();

    //private final Lock searcherLock = new ReentrantLock();

    private LuceneManager(String indexDir) {
        this.indexDir = indexDir;
    }
    public LuceneManager(String indexDir,Analyzer analyzer){
        this.analyzer = analyzer;
        this.indexDir = indexDir;
    }

    /**
     * 获取IndexWriter单例对象
     * 修改索引后，记得关闭closeWriter
     * @return
     */
    public IndexWriter getIndexWriter() throws IOException {
        return getIndexWriter(null);
    }
    public IndexWriter getIndexWriter(IndexWriterConfig.OpenMode openMode) throws IOException {

        FSDirectory dir = FSDirectory.open(Paths.get(indexDir));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        if(null != openMode) {
            indexWriterConfig.setOpenMode(openMode);
        }
        return new IndexWriter(dir, indexWriterConfig);
        /*try {
            writerLock.lock();
            if(null == writer){
                //如果索引目录被锁，则直接抛异常
                *//*if(IndexWriter.isLocked(dir)) {
                    throw new LockObtainFailedException("Directory of index had been locked.");
                }*//*
                writer = new IndexWriter(directory, indexWriterConfig);
            }
        } catch (LockObtainFailedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writerLock.unlock();
        }
        return writer;*/
    }
    public static void closeWriter(IndexWriter indexWriter){
        Directory dir = null;
        if(null != indexWriter){
            dir = indexWriter.getDirectory();
            try {
                indexWriter.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                indexWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(null != dir){
            try {
                dir.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取IndexReader对象
     * @return
     */
    protected IndexReader getIndexReader() {
        try {
            if(null == reader){
                directory= FSDirectory.open(Paths.get(indexDir));
                reader = DirectoryReader.open(directory);
            } else {
                if(reader instanceof DirectoryReader) {
                    //开启近实时Reader,能立即看到动态添加/删除的索引变化
                    // DirectoryReader提供了一个openIfChanged方法，这样的话我们可以判断索引是否被修改，如果被修改了，那么先把原来的indexReader关闭，重新打开新的IndexReader
                    DirectoryReader changeReader = DirectoryReader.openIfChanged((DirectoryReader) reader);
                    if(null != changeReader){
                        reader.close();
                        reader = changeReader;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }
    public IndexSearcher getIndexSearcher(){
        searcher = new IndexSearcher(getIndexReader());
        return searcher;
    }
    public void close(){
        if(null != reader){
            try {
                reader.close();
                reader = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(null != directory) {
            try {
                directory.close();
                directory = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }
}
