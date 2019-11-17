package com.lqh.mapper;


import com.lqh.pojo.Users;
import com.lqh.pojo.bo.UserRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;
    // 用户注册
    public int insertOnne(String uname, String psd) {
        String sql = "INSERT INTO users VALUES (null,18,?,?,now(),100)";
        int i = jdbcTemplate.update(sql, uname, psd);
        return i;
    }

    // 用户登录
    public Users selectByUnameAndPsd(String uname, String psd) {
        String sql = "select * from users where uname=? and psd=?";
        Users u = null;
        try {
            u = jdbcTemplate.queryForObject(sql, new UserRowMapper(), uname, psd);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return u;
    }

    //更新用户金额
    public int updateByUname(String uname, int money, int type) {
        String sql = null;
        if (type == 1) {
            sql = "UPDATE users SET cdate=now(), money=money-? WHERE uname=? ";
        }
        if(type==0) {
            sql = "UPDATE users SET cdate=now(), money=money+? WHERE uname=?";
        }
        int i = jdbcTemplate.update(sql, money, uname);
        return i;
    }

    // 用户修改信息
    public int updateInfomationByUname(String uname, String psd,int age) {
        String sql = "UPDATE users SET ages=?,psd=?,cdate=now() WHERE uname=?";
        int i = jdbcTemplate.update(sql,age ,psd,uname);
        return i;
    }
}
