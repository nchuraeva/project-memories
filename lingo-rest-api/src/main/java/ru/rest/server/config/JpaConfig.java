package ru.rest.server.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class JpaConfig extends HikariConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }
}
