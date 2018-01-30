package com.tanklab.dao.jdbc;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.User;
import com.tanklab.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private final static String loginRight="SELECT id,loginName,password,powerLevel FROM user WHERE loginName=? and password=?";
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User loginRight(String loginName, String password) {
        try {
            return jdbcTemplate.queryForObject(loginRight,new UserRowMapper(),loginName,password);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String loginName = rs.getString("loginName");
            String password = rs.getString("password");
            int powerLevel = rs.getInt("powerLevel");
            User user = new User(id,loginName,password,powerLevel);
            return user;
        }
    }

}
