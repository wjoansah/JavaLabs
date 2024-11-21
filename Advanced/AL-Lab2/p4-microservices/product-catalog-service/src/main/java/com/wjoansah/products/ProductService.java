package com.wjoansah.products;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    Product addProduct(Product product);
}
