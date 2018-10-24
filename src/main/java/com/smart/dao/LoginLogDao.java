package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog){
        String sqlstr = "insert into user(userId,ip,loginDate) value (?,?,?)";
        jdbcTemplate.update(sqlstr,new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()});
    }

}
