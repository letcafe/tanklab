package com.tanklab.bean;

import java.util.Date;

public class News {
    int id;
    String title;
    String content;
    Date date;
    String imgUrl;

    public News() {
    }

    public News(String title, String content, Date date, String imgUrl) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.imgUrl = imgUrl;
    }

    public News(int id, String title, String content, Date date, String imgUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.imgUrl = imgUrl;
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
