package gul.selim.webbundle.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gul.selim.webbundle.service.GreetingService;
import gul.selim.webbundle.service.MathService;

@Configuration
public class WebServicesConfig {

  @Bean
  public ServletRegistrationBean wsDispatcherServlet() {
    return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
  }

  @Bean(name = "cxf")
  public SpringBus springBus() {
    return new SpringBus();
  }

  @Bean
  public Endpoint helloWorldEndpoint() {
    EndpointImpl endpoint = new EndpointImpl(springBus(), new GreetingService());
    endpoint.publish("/hi");    
    return endpoint;
  }
  
  @Bean
  public Endpoint mathEndpoint() {
    EndpointImpl endpoint = new EndpointImpl(springBus(), new MathService());    
    endpoint.publish("/math");    
    return endpoint;
  }
}