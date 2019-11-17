package com.lqh.pojo.bo;


import com.lqh.pojo.Users;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<Users>{

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users u = new Users();
        u.setId(resultSet.getInt("id"));
        u.setAge(resultSet.getInt("ages"));
        u.setUname(resultSet.getString("uname"));
        u.setPsd(resultSet.getString("psd"));
        u.setCdate(resultSet.getDate("cdate"));
        u.setMoney(resultSet.getInt("money"));
        return u;
    }
}
