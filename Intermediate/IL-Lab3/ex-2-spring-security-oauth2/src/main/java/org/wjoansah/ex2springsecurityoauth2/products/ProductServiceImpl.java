package org.wjoansah.ex2springsecurityoauth2.products;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wjoansah.ex2springsecurityoauth2.products.dtos.ProductResponse;
import org.wjoansah.ex2springsecurityoauth2.products.dtos.UpsertProductRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(UpsertProductRequest request) {
        var product = modelMapper.map(request, Product.class);
        var result = productRepository.save(product);

        return modelMapper.map(result, ProductResponse.class);
    }

    @Override
    public ProductResponse getProduct(Integer id) {
        var user = productRepository.findById(id).orElse(null);
        return modelMapper.map(user, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getProducts() {
        var products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse updateProduct(Integer productId, UpsertProductRequest request) {
        var product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        modelMapper.map(request, product);
        var result = productRepository.save(product);

        return modelMapper.map(result, ProductResponse.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
