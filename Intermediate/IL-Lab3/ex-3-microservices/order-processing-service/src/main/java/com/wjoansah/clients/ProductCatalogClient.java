package com.wjoansah.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-catalog-service", url = "http://localhost:8082")
public interface ProductCatalogClient {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Integer id);
}
