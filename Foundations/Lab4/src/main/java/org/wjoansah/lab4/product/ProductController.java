package org.wjoansah.lab4.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProductByEmail(@PathVariable byte id) {
        return productService.getProductById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createProduct(@RequestBody Product product) {
         productService.addProduct(product);
    }

    @PutMapping("{id}")
    public void updateProduct(@PathVariable byte id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable byte id) {
        productService.removeProduct(id);
    }
}
