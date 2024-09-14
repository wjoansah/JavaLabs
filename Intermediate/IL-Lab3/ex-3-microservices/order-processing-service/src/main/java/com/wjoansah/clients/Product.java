package com.wjoansah.clients;

public record Product(
        Integer id,
        String name,
        Double price,
        String description,
        Integer quantity
) {
}
