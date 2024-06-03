package org.wjoansah.lab4.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Product newProduct) {
        var product = productRepository.getProductById(newProduct.getId());
        if (product != null) {
            throw new IllegalStateException("Product already exists");
        }
        productRepository.addProduct(newProduct);
    }

    public void updateProduct(int id, Product productUpdate) {
        var product = productRepository.getProductById(id);
        if (product == null) {
            throw new IllegalStateException("Product does not exist");
        }

        if(productUpdate.getName() != null) {
            product.setName(productUpdate.getName());
        }
        if(productUpdate.getDescription() != null) {
            product.setDescription(productUpdate.getDescription());
        }
        if(productUpdate.getPrice() != 0.0d){
            product.setPrice(productUpdate.getPrice());
        }

    }

    public void removeProduct(int id) {
        var product = productRepository.getProductById(id);
        if (product == null) {
            return;
        }
        productRepository.removeProduct(product);
    }
}
