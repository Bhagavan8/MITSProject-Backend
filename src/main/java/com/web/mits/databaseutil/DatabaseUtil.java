package com.web.mits.databaseutil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public boolean validateMobile(String mobileNumber) {
        String sql = "SELECT COUNT(*) FROM user_information WHERE mobile_Number = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, mobileNumber);
        return count > 0;
    }
    
    public boolean validateEmail(String email) {
        String sql = "SELECT COUNT(*) FROM user_information WHERE email = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }
    
    public boolean validatePassword(String password) {
        String sql = "SELECT COUNT(*) FROM user_information WHERE password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, password);
        return count > 0;
    }
    
   
    
}

