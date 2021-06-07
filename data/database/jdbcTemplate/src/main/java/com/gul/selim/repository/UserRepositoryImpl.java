package com.gul.selim.repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.gul.selim.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends JdbcDaoSupport implements UserRepository {

    @Autowired
    @Qualifier("h2")
	DataSource dataSource;
    
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO Users " + "(id, name) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] { user.getId(), user.getName() });
    }    
}
