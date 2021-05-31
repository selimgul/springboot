package springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import springboot.base.Loggable;

@Component
public class LogFilter extends Loggable implements Filter {
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
		ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
	   	
		logger.info("REMOTE HOST    => " + request.getRemoteHost());
	    logger.info("REMOTE ADDRESS => " + request.getRemoteAddr());
	    
		chain.doFilter(wrappedRequest, wrappedResponse);
				
		logger.info("REQUEST        => " + new String(wrappedRequest.getContentAsByteArray()));
		logger.info("RESPONSE       => " + new String(wrappedResponse.getContentAsByteArray()));

		wrappedResponse.copyBodyToResponse();

	}

}
