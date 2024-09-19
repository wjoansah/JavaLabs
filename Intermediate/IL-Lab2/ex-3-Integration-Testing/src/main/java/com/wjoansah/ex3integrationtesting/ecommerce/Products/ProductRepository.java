package com.wjoansah.ex3integrationtesting.ecommerce.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
