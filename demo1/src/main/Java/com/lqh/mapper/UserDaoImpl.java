package com.lqh.mapper;

import com.lqh.pojo.Users;
import com.lqh.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Users getOne(Integer uid) {
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Users u=sqlSession.selectOne("getOne",uid);
        return u;
    }

    @Override
    public int addOne(Users u) {
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i=sqlSession.insert("addOne",u);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateOne(Users u) {
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i=sqlSession.update("updateOne",u);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteOne(Users u) {
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i=sqlSession.delete("deleteOne",u);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public <Users> List<Users> getList() {
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
         List<Users> u=sqlSession.selectList("getList");
        return u;
    }
}
