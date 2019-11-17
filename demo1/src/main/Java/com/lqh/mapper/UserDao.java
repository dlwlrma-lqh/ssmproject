package com.lqh.mapper;

import com.lqh.pojo.Users;

import java.util.List;

public interface UserDao {
     Users getOne(Integer uid);
    int addOne(Users u);
    int updateOne(Users u);
    int deleteOne(Users u);

    <Users> List<Users> getList();

}
