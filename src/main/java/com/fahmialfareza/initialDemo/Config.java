package com.fahmialfareza.initialDemo;

import com.fahmialfareza.initialDemo.Entity.Address;
import com.fahmialfareza.initialDemo.Entity.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean
    public Address getAddress() {
        return new Address("Jalan Maju Mundur", 15);
    }
}

