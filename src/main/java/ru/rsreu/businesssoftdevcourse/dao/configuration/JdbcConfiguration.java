package ru.rsreu.businesssoftdevcourse.dao.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {
    @Bean
    public SimpleJdbcInsert workOrdersSimpleJdbcInsert(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource).withTableName("work_orders")
                .usingGeneratedKeyColumns("id");
    }

    @Bean
    public SimpleJdbcInsert orderBreakDownsSimpleJdbcInsert(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource).withTableName("order_breakdowns")
                .usingGeneratedKeyColumns("id");
    }
}
