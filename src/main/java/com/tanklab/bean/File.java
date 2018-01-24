package com.tanklab.bean;

import java.util.Date;

public class File {
    public File() {
    }

    public File(String fileName, String path, Date uploadTime) {
        this.fileName = fileName;
        this.path = path;
        this.uploadTime = uploadTime;
    }
    public File(int id, String fileName, String path, Date uploadTime) {
        this.id = id;
        this.fileName = fileName;
        this.path = path;
        this.uploadTime = uploadTime;
    }






    private int id;
    private String fileName;
    private String path;
    private Date uploadTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
