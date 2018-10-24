package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLog(LoginLogDao loginLogDao){
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String username , String password){
        return userDao.getMatchCount(username,password) > 0;
    }

    public User findUserByUser(String username){
        return userDao.findUserByUserName(username);
    }

    public void updateLoginInfo(User user){
        userDao.updateLoginInfo(user);
    }

    public void insertLoginLog(LoginLogDao loginLogDao){
//        loginLogDao.insertLoginLog();
    }

}
