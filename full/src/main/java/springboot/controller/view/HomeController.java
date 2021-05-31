package springboot.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.base.ViewController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController extends ViewController {
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private Environment config;
	
	@RequestMapping("/")
	String index(Model model) {

		return "index";
	}
		
	@RequestMapping("/hello")
	String home(Model model) {

		String msg = "Hello World!";
		logger.info(msg);

		model.asMap().put("msg", msg);
		return "index";
	}

	@RequestMapping("/productList")
	String productList() {
		return "productList";
	}

	@RequestMapping("/services")
	String getServiceInstances() {
		
		String html = "";
		
//		List<ServiceInstance> instances =  discoveryClient.getInstances(config.getProperty("spring.application.name"));
//		
//		if (instances == null || instances.isEmpty())
//			return "No instance found.";
//						
//		for (ServiceInstance serviceInstance : instances) {
//			html+="<h3>Instance: " + serviceInstance.getUri() + "</h3>";
//			html+="Host: " + serviceInstance.getHost() + "<br>";
//			html+="Port: " + serviceInstance.getPort() + "<br>";
//		}
		
		return html;
	}	
}
