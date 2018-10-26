package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Service 作用于业务逻辑层，主要是让smart-context.xml中的component-scan找到
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

    @Transactional
    public void insertsuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
