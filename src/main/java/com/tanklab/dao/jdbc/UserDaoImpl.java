package com.tanklab.dao.jdbc;

import com.tanklab.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public boolean loginRight(String loginName, String passwoed) {
        //实现
        return false;
    }
}
