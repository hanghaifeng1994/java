package com.learnyeai.learnai.session.vo;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Iterator转Enumeration的包装类
 * @author lc3@yitong.com.cn
 */
public class EnumerationWrapper<E> implements Enumeration<E> {

    private Iterator<E> iterator;

    public EnumerationWrapper(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
