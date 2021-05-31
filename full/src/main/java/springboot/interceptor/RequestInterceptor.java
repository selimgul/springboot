package springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import springboot.base.Loggable;
import springboot.exception.AuthorizationException;

@Component
public class RequestInterceptor extends Loggable implements HandlerInterceptor {

	@Autowired
	private Environment config;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestURI = request.getRequestURI();
		String name = ServletRequestUtils.getStringParameter(request, "name", "");
		
		logger.info("[preHandle][" + requestURI + "][name:" + name + "]");

		if (request.getMethod().equals("GET") || (request.getHeader(config.getProperty("custom.header.name")) != null
				&& request.getHeader(config.getProperty("custom.header.name")).equals("selim")))
			logger.info("Access granted.");
		else
			throw new AuthorizationException();

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[postHandle][" + request + "]" + "[postHandle][" + response + "]");
	}

}
