package springboot.service;

import java.util.List;

import springboot.model.Product;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProduct(Integer id);
    void createProduct(Product p) throws Exception ;
    void updateProduct(Integer id, Product p);
    void deleteProduct(Integer id);
    Product getNextProduct(Integer id);
}
