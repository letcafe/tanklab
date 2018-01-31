package com.tanklab.service.implService;

import com.tanklab.bean.User;
import com.tanklab.dao.UserDao;
import com.tanklab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginRight(String loginName, String passwoed) {
        return userDao.loginRight(loginName, passwoed);
    }
}
