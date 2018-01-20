package com.tanklab.dao.jdbc;

import com.tanklab.bean.APIKey;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ApiKeyDao implements ApiKeyRepository {

    public static final String SELECT_APIKEY_IN_DB = "SELECT id, api_key, permission_level from api where api_key = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    ApiKeyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean apiInDBOrNot(String api_key) {
        try {
            APIKey apiKey = jdbcTemplate.queryForObject(SELECT_APIKEY_IN_DB, new APIiKeyRowMapper(), api_key);
            if(apiKey != null) {
                return true;
            }else {
                return false;
            }
        } catch( EmptyResultDataAccessException ex) {
            return false;
        }

    }

    @Override
    public JDBC_STATUS addOneApiKey() {
        return null;
    }

    private static final class APIiKeyRowMapper implements RowMapper<APIKey> {

        @Override
        public APIKey mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String api_key = rs.getString("api_key");
            int permission_level = rs.getInt("permission_level");
            APIKey apiKey = new APIKey(id, api_key, permission_level);
            return apiKey;
        }
    }
}
