package springboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    @Qualifier("dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource getDataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource getDataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("dataSource1")
    public JdbcTemplate getJDBCTemplate1(@Qualifier("dataSource1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Qualifier("dataSource2")
    public JdbcTemplate getJDBCTemplate2(@Qualifier("dataSource2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
