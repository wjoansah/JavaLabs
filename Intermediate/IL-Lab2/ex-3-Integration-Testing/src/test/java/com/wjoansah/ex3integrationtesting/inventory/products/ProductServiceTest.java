package com.wjoansah.ex3integrationtesting.inventory.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testAddProduct() {
        Product product = new Product();
        product.setName("Laptop");
        product.setQuantity(10);
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.addProduct(product);
        assertEquals("Laptop", savedProduct.getName());
        assertEquals(10, savedProduct.getQuantity());
    }

    @Test
    void testReduceProductQuantity() {
        Product product = new Product();
        product.setName("Laptop");
        product.setQuantity(10);
        Mockito.when(productRepository.findByName("Laptop")).thenReturn(Optional.of(product));

        boolean result = productService.reduceProductQuantity("Laptop", 5);
        assertTrue(result);
        assertEquals(5, product.getQuantity());
    }
}
