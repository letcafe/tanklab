package com.tanklab.dao;

import com.tanklab.bean.User;

public interface UserDao {
    public User loginRight(String loginName, String passwoed);
}
