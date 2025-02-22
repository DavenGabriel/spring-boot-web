package com.example.finalproject6.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }
}