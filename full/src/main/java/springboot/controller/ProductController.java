package springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.base.ApiController;
import springboot.exception.ProductNotFoundException;
import springboot.model.Product;
import springboot.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController extends ApiController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "")
	ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<?> getProductById(@PathVariable Integer id) {
		Product p = productService.getProduct(id);

		if (p == null)
			throw new ProductNotFoundException(id);

		return ResponseEntity.ok(p);
	}

	// @Valid tanımı ile model üzerindeki validasyon tanımları kontrol edilir ve
	// valid olmaması durumunda kontrol
	// CustomExceptionHandler::handleMethodArgumentNotValid'e geçer.
	@RequestMapping(method = RequestMethod.POST, value = "")
	ResponseEntity<?> createProduct(@Valid @RequestBody Product product) throws Exception {
		productService.createProduct(product);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getnext")
	ResponseEntity<?> getNextProduct(@RequestParam Integer id) {
		Product p = productService.getNextProduct(id);

		if (p == null)
			throw new ProductNotFoundException(id);

		return ResponseEntity.ok(p);
	}
}
