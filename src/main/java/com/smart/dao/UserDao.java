package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //数据库查找密码账号同时匹配的用户数量
    public int getMatchCount(String username,String password){
        String sqlstr = "select count(*) from user where username = ? and password = ?";
        return jdbcTemplate.queryForObject(sqlstr,new Object[]{username,password},Integer.class);
        //关于queryForObject(sql语句，占位符？处的值，返回的值类型)
    }

    //数据库从用户名找用户
    public User findUserByUserName(final String username){
        String sqlstr = "select * from user where username = ?";
        final User user = new User();
        jdbcTemplate.query(sqlstr,new Object[] {username},
                new RowCallbackHandler(){
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("userId"));
                        user.setUserName(username);
                        user.setCredits(rs.getInt("credits"));
                    }
                });
        //使用RowCallbackHandler回调接口处理查询结果
        //再利用processRow将查询结果从ResultSet中装载到类似于对象领域的实列中
        //注意：jdbcTemplate后面使用的是query
        return user;
    }

    //数据库更新操作
    public void updateLoginInfo(User user){
        String sqlstr = "update user set lastVisit = ?,lastIp = ?,credits = ? where userId = ?";
        jdbcTemplate.update(sqlstr,new Object[] {user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
        //update用update
    }

}
