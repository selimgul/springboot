
https://www.tutorialspoint.com/spring_boot/index.htm
https://www.mkyong.com/spring-boot/spring-boot-deploy-war-file-to-tomcat/
https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas (Spring Boot Microservices Level 1)

SpringApplicationBuilder ile web server üzerindeki çalışmalarda configurasyon override edilebilir.

@ComponentScan => SpringBootApplication annotation'ını ComponentScan'i içerdiği için ekstra kullanmaya gerek yok.
Code Structure olarak SpringBootApplication annotation'ı olan class root'da yer alırsa (diğerlerine göre 1 package level üstte)
@SpringBootApplication (scanBasePackages = { Constants.APPLICATION_BASE_PACKAGE }) yerine yalnızca @SpringBootApplication
kullanılabilir.

actuator  => spring-boot-starter-actuator
thymeleaf => spring-boot-starter-thymeleaf
eureka    => spring-cloud-starter-netflix-eureka-client
		     - Eureka client olmak için:
			 	- @EnableEurekaClient => ekle
				- RestTemplate => @LoadBalanced ekle
				- pom.xml => spring-cloud-starter-netflix-eureka-client ekle
				- application.properties => spring.application.name, eureka.client.serviceUrl.defaultZone, eureka.client.preferIpAddress ekle  			
			
swagger   => springfox-swagger2 (http://localhost:8081/swagger-ui.html)

@ControllerAdvice (ResponseEntityExceptionHandler)
@ExceptionHandler

CORS 
	- WebMvcConfigurer'i implemente eden @Configuration ile decorate edilen bir class ile
	- WebMvcConfigurer instance'ı dönen @Bean le decorate edilen bir class
	- @CrossOrigin ile decorate edilen controller metodu ile 
	
Environment (config)
Internationalization (LocaleChangeInterceptor, http://localhost:8080/full/?lang=tr)
  
RestTemplate (@LoadBalanced (for eureka client))
WebClient

Parameters:
	Command Line: 
		--server.port=12345
		--spring.profiles.active=prod > application-prod.properties
 Environment Variables:
 	server.port=${ENV_PORT} > application.properties
 External Config File:
 	-Dspring.config.location = C:\application.properties

Interceptor kontrol controller'a bırakılmadan önce ve controller'dan client'a dönerken devreye girer.
Spring context'i içinde çalışır.
Filter ile benzer bir kullanımı vardır. Önce Filter çalışır, controller'a geçmeden önce de Interceptor çalışır.


Annotations
-----------
[@Scope("prototype")]

[@Bean]
[@Component]
@Controller
@RestController
@Repository
@Service
@Configuration

@Autowired
@Primary / @Qualifier
@Value ($ ya da # ile başlayabilir. # bean'e eriş, metodunu kullan demektir. SPEL)
@ConfigurationProperties
@Profile (kod tarafında kullanılacak class'ları belirleyebilir.)
@Import (component-scan ile tüm bean'leri alacağımıza sadece istedğimiz bean'i import edebiliriz)
@PropertySource (istenilen bir config dosyasını bağlamak için kullanılır)

@RequestMapping
@{Verb}Mapping
@ResponseEntity

- Configuration
  * Config Client
- Logging
  * Elasticsearch
- Exception Handling
- Security
  * Filter
  * Interceptor
- Data
  * RDBMS
  * NoSQL
- Cache
  * Redis
- Messaging
  * Kafka
  * RabbitMQ
- Documentation
  * Swagger
- Monitoring
  * Actuator


