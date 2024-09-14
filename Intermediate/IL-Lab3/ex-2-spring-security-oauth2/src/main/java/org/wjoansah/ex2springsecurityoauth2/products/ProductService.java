package org.wjoansah.ex2springsecurityoauth2.products;

import org.wjoansah.ex2springsecurityoauth2.products.dtos.ProductResponse;
import org.wjoansah.ex2springsecurityoauth2.products.dtos.UpsertProductRequest;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(UpsertProductRequest request);

    ProductResponse getProduct(Integer id);

    List<ProductResponse> getProducts();

    ProductResponse updateProduct(Integer productId, UpsertProductRequest request);

    void deleteProduct(Integer id);
}
