package com.lqh;

import com.lqh.mapper.UserDao;
import com.lqh.mapper.UserDaoImpl;
import com.lqh.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);

    }

    @Test
    public void test2(){
        UserDao userDao=new UserDaoImpl();
        Users one=userDao.getOne(1);
        System.out.println(one);
        }

    @Test
    public void test3(){
        UserDao userDao=new UserDaoImpl();
        Users u=new Users();
        u.setUname("小黑");
        u.setPsd("123");
        u.setAge(18);
        u.setMoney(100);
        int i = userDao.addOne(u);
        System.out.println(i);
    }

    @Test
    public void test4(){
        UserDao userDao=new UserDaoImpl();
        List<Users> users=userDao.getList();
        for (Users u:users) {
            System.out.println(u);
        }
    }


    }

