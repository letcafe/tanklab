package com.tanklab.bean;

public enum JDBC_STATUS {
    SUCCESS("success", "jdbc success"),
    FAIL("fail", "jdbc fail"),
    ERROR("error", "jdbc error"),
    ROWHAS("exception", "jdbc hasNoRowsException");


    private String status;
    private String content;

    JDBC_STATUS(String status, String content) {
        this.status = status;
        this.content = content;
    }

    @Override
    public String toString() {
        return status + ":" + content;
    }
}
