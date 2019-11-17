package com.lqh.service;

import com.lqh.pojo.Users;

public interface UserService {
    // 用户注册
    int register(String uname, String psd);

    //用户登录
    Users login(String uname, String psd);

    //用户存钱
    int setMoney(String uname, int money);

    //用户取钱
    int getMoney(String uname, int money);

    //用户转账
    int aToB(String aname, String bname, int money);

    //用户信息修改
    int modify(String uname, String psd, int age);

}
