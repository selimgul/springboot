package springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springboot.filter.LogFilter;

@Configuration
public class FilterConfig {
	
	@Value("${pattern.filter}")
	private String filterPattern;
	
	@Bean
	public FilterRegistrationBean<LogFilter> loggingFilter(){
	    			
		FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
	    		
	    registrationBean.setFilter(new LogFilter());
	    registrationBean.addUrlPatterns(filterPattern);
	         	   	    	    
	    return registrationBean;
	}
	
}
