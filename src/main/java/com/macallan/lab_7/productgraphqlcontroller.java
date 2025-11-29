
package com.macallan.lab_7;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductGraphQLController {

    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }

    // QUERIES
    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProductById(@Argument Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.orElse(null);
    }

    // MUTATIONS
    @MutationMapping
    public Product createProduct(@Argument String name, @Argument Double price) {
        return productService.createProduct(new Product(null, name, price));
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String name, @Argument Double price) {
        return productService.updateProduct(id, new Product(id, name, price)).orElse(null);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}

