package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author twang
 */
public class ClzClazzScheduleExt {
    private String date;

    private List<ScheduleInfo> info;

    public List<ScheduleInfo> getInfo() {
        return info;
    }

    public void setInfo(List<ScheduleInfo> info) {
        this.info = info;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
