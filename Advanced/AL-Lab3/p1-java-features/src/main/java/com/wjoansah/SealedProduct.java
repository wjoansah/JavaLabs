package com.wjoansah;

public abstract sealed class SealedProduct permits ElectronicsProduct, ClothingProduct {
    private final String name;
    private final double price;

    public SealedProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String description();
}
