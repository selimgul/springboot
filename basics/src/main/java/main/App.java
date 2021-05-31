package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gul.selim.beans.CustomerService;
import com.gul.selim.beans.HelloWorld;
import com.gul.selim.config.AppConfig;

public class App 
{
	/*
	 	@Bean             - Indicates that a method produces a bean to be managed by the Spring container.	 	
		@Repository       - Used to mark a bean as DAO Component on persistence layer
		@Service 	      - Used to mark a bean as Service Component on business layer
		@Controller       - Used to mark a bean as Controller Component on Presentation layer
		@Configuration    - Used to mark a bean as Configuration Component.		
		@Component        - General purpose annotation, can be used as a replacement for above annotations.		
		@ComponentScan    - Configures component scanning directives for use with @Configuration classes.
		@Autowired        - Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
		@Required         - Marks a method (typically a JavaBean setter method) as being 'required': that is, the setter method must be configured to be dependency-injected with a value.
		@Scope		      - Indicates the name of a scope to use for instances of the annotated type or returned from the method.	
		@PostConstruct    - The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done to perform any initialization.
		@PreDestroy       - The PreDestroy annotation is used on methods as a callback notification to signal that the instance is in the process of being removed by the container.
		@Resource         -
		@Qualifier        -
		@ModelAttribute   -
		@ExceptionHandler -	
		@SessionAttibutes - 
		@ResponseBody     -	
		
		Scope
		-----

		Valid in any configuration:
		  - Singleton
		  - Prototype

		Valid in Web-Aware configuration:
		  - Request
		  - Session
		  - Global


		 Stereotypes
		 -----------
		 (@Bean, @ComponentScan, @Autowired, @PostConstruct, @Value, @Profile)
		 @Component
		 @Repository
		 @Service

		 Notlar:
		 @Bean metot seviyesinde tanımlanabilir.
		 @Autowired field, constructor ya da setter üzerine tanımlanabilir.
		 @Value içinde SpEL kullanılabilir.
		 @Profile, -Dspring.profiles.active=dev şeklinde VM options olarak belirtilmelidir.
	*/
	
	
    @SuppressWarnings("resource")    
	public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);        
    	
    	HelloWorld obj = (HelloWorld) context.getBean(HelloWorld.class);
    	obj.setMessage("Hello World!");
	    obj.getMessage();
	    
	    CustomerService customerService = (CustomerService)context.getBean("CustomerService");
	    System.out.println(customerService.toString());
	    
    }
}
