package com.example.wangtianyi.androidtimetable3;

/**
 * Created by Administrator on 2019/5/27.
 */

public class NoteMode {
    private int id;
    private int num;
    private int tag;
    private String text;
    private String textDay;
    private String textTime;
    private String alarm;

    public NoteMode(String text, String textTime, String alarm) {
        this.text = text;
        this.textTime = textTime;
        this.alarm = alarm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextTime() {
        return textTime;
    }

    public void setTextTime(String textTime) {
        this.textTime = textTime;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
}
