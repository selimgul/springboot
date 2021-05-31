package springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import springboot.interceptor.RequestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Value("${pattern.interceptor}")
	private String interceptorPattern;

	@Autowired
	private RequestInterceptor logInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor).addPathPatterns(interceptorPattern);
	}

}
