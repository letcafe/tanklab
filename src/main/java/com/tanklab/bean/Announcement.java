package com.tanklab.bean;

import java.util.Date;

/**
 * @Author yanan
 * @Desc 长期公告实体类
 * @Date 2018/1/20 21:43
 */
public class Announcement {
    private int id;  //自增id
    private String title; //公告标题
    private String content; //公告内容
    private Date date; //变更日期

    public Announcement(int id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }
    public Announcement(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
    public Announcement() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return this.id+" "+this.title+" "+this.content+" "+this.date;
    }
}
