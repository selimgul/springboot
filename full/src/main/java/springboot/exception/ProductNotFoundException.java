package springboot.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Integer id) {
		super("Product not found. " + id);
	}
}
