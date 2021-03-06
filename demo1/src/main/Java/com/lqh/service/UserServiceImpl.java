package com.lqh.service;

import com.lqh.mapper.UserMapper;
import com.lqh.pojo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    /**
     *
     */
    @Autowired
    UserMapper userMapper;
    // 用户注册
    @Override
    public int register(String uname, String psd) {
        // 参数验证
        if (uname == null || "".equals(uname)) {
            return 0;
        }
        if (StringUtils.isEmpty(psd)) {
            return 0;
        }
        // 注册用户
        int i = userMapper.insertOnne(uname, psd);
        return i;
    }
        @Override
        public Users login(String uname,String psd) {
            Users u = null;
            //参数非空判断
            if (StringUtils.isEmpty(uname)) {
                return u;
            }
            if (StringUtils.isEmpty(psd)) {
                return u;
            }
            //成功返回数据
            u = userMapper.selectByUnameAndPsd(uname, psd);
            return u;
        }

    @Override
    public int setMoney(String uname, int money) {
        // 参数验证
        if (money <= 0) {
            return 0;
        }
        //存钱
        int i = userMapper.updateByUname(uname, money, 0);
        return i;
    }

    @Override
    public int getMoney(String uname, int money) {
        // 参数验证
        if (money <= 0) {
            return 0;
        }
        //取钱
        int i = userMapper.updateByUname(uname, money, 1);
        return i;
    }

    @Override
    public int aToB(String aname, String bname, int money) {
        //参数非空判断
        if (StringUtils.isEmpty(bname)) {
            return 0;
        }
        if (money <= 0) {
            return 0;
        }
        //a用户扣钱
        int i = userMapper.updateByUname(aname, money, 1);
        //b用户加钱
        int i2 = userMapper.updateByUname(bname, money, 0);
        return i+i2;
    }


    // 用户信息修改
    @Override
    public int modify(String uname, String psd, int age) {
        if (StringUtils.isEmpty(uname)) {
            return 0;
        }
        int i=userMapper.updateInfomationByUname( uname, psd, age);
        return i;
    }

}
