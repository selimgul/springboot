package com.gul.selim.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class BeanDefinitions {

	@Bean
	@Primary
	@Qualifier("h2")
	@ConfigurationProperties(prefix = "spring.datasource.h2")
	public DataSource getDataSourceH2() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier("postgresql")
	@ConfigurationProperties(prefix = "spring.datasource.postgresql")
	public DataSource getDataSourcePostgreSQL() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier("h2")
	public JdbcTemplate getJDBCTemplateforH2(@Qualifier("h2") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Qualifier("postgresql")
	public NamedParameterJdbcTemplate getJDBCTemplateforPostgreSQL(@Qualifier("postgresql") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
