package Service;

import Model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private Map<Long, Product> productDB = new HashMap<>();
    private Long nextId = 4L;

    public ProductService() {
        // Initial mock data
        productDB.put(1L, new Product(1L, "Laptop Pro", 49999.0));
        productDB.put(2L, new Product(2L, "Gaming Mouse", 1999.0));
        productDB.put(3L, new Product(3L, "Mechanical Keyboard", 3999.0));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productDB.values());
    }

    public Product getProductById(Long id) {
        return productDB.get(id);
    }

    public Product createProduct(Product product) {
        product.setId(nextId++);
        productDB.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(Long id, Product newProductData) {
        if (!productDB.containsKey(id)) return null;

        Product existing = productDB.get(id);
        existing.setName(newProductData.getName());
        existing.setPrice(newProductData.getPrice());
        return existing;
    }

    public boolean deleteProduct(Long id) {
        return productDB.remove(id) != null;
    }
}
