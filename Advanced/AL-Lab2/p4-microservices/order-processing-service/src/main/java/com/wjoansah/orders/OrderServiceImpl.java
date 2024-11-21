package com.wjoansah.orders;

import com.wjoansah.clients.ProductCatalogClient;
import com.wjoansah.clients.UserServiceClient;
import com.wjoansah.orders.dtos.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final UserServiceClient userServiceClient;
    private final ProductCatalogClient productCatalogClient;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderServiceImpl(UserServiceClient userServiceClient, ProductCatalogClient productCatalogClient, OrderRepository orderRepository) {
        this.userServiceClient = userServiceClient;
        this.productCatalogClient = productCatalogClient;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse placeOrder(Order order) {
        var userExists = userServiceClient.userExists(order.getUserId());

        if (!userExists) {
            throw new IllegalArgumentException("Cannot place order because user does not exist");
        }

        var orderedItemsInStock = order.getOrderItems().parallelStream().allMatch(orderItem -> {
            orderItem.setOrder(order);
            var product = productCatalogClient.getProductById(orderItem.getProductId());
            return product.quantity() >= orderItem.getQuantity();
        });

        if (!orderedItemsInStock) {
            throw new IllegalArgumentException("One or more items are not enough to meet order requirements");
        }

        var newOrder = orderRepository.save(order);

        return modelMapper.map(newOrder, OrderResponse.class);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
