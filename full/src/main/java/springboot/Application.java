package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableEurekaClient
@SpringBootApplication // (scanBasePackages = { Constants.APPLICATION_BASE_PACKAGE })
@EnableSwagger2
public class Application extends SpringBootServletInitializer implements ApplicationRunner {

	@Autowired
	@Qualifier("dataSource1")
	private JdbcTemplate jdbcTemplate;

	private RedisTemplate<String, Object> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
		return builder.sources(Application.class);
	}

	@Override
	public void run(ApplicationArguments appArgs) throws Exception {
		System.out.println("Spring Boot app is started.");

		try {
			int count = jdbcTemplate.queryForObject("select count(*) from accounts", Integer.class);
			System.out.println("Count => " + count);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
