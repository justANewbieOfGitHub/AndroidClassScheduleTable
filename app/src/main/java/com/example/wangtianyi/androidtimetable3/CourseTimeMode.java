package com.example.wangtianyi.androidtimetable3;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/30.
 */

public class CourseTimeMode implements Serializable {

    private int index;
    private String startTime;
    private String endTime;

    public CourseTimeMode(int index, String startTime, String endTime) {
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
