package springboot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import springboot.model.Product;
import springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${productservice.url}")
	private String productServiceUrl;

	@Autowired
	private Environment config;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	private List<Product> productList = new ArrayList<Product>();

	@PostConstruct
	public void init() throws Exception {
		productList.add(new Product(1, "pencil"));
		productList.add(new Product(2, "book"));
	}

	public List<Product> getAllProducts() {
		return productList;
	}

	public Product getProduct(Integer id) {

		return productList.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
	}

	public void createProduct(Product p) throws Exception {

		if (p.getID() < 0)
			throw new Exception("ID must be positive");

		productList.add(p);
	}

	public void updateProduct(Integer id, Product p) {

		for (int i = 0; i < productList.size(); i++) {
			Product pr = productList.get(i);
			if (pr.getID().equals(id)) {
				productList.set(i, p);
				return;
			}
		}
	}

	public void deleteProduct(Integer id) {

		productList.removeIf(p -> p.getID().equals(id));
	}

	public Product getNextProduct(Integer id) {

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set(config.getProperty("custom.header.name"), config.getProperty("custom.header.value"));

			HttpEntity<Product> entity = new HttpEntity<>(headers);

			return restTemplate.exchange(productServiceUrl + (id + 1), HttpMethod.GET, entity, Product.class).getBody();

			//return restTemplate.getForObject(productServiceUrl + (id + 1), Product.class);
			//return webClientBuilder.build().get().uri(productServiceUrl + (id +// 1)).retrieve().bodyToMono(Product.class).block();
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			return null;
		}
	}
}
