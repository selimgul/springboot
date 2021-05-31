package com.gul.selim.runner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gul.selim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CodeRunnerH2 implements CommandLineRunner {

	@Autowired
	@Qualifier("h2")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		getSingleUser();
		getAllUsers();
	}

	private void getSingleUser() {

		String sql = "select * from Users where id=?";

		Integer id = 1;

		User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {

				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));

				return user;
			}

		});

		System.out.println(user.toString());
	}

	private void getAllUsers() {

		String sql = "select * from Users";

		List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {

				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));

				return user;
			}

		});

		users.forEach(user -> System.out.println(user.toString()));
	}
}
