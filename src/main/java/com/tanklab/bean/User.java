package com.tanklab.bean;

public class User {
    int id;
    String loginName;
    String password;
    int powerLevel;

    public User() {
    }

    public User(String loginName, String password, int powerlevel) {
        this.loginName = loginName;
        this.password = password;
        this.powerLevel = powerlevel;
    }

    public User(int id, String loginName, String password, int powerlevel) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.powerLevel = powerlevel;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
