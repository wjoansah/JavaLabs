package com.wjoansah;

public final class ClothingProduct extends SealedProduct {
    private final String size;
    private final String material;

    public ClothingProduct(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String description() {
        return "Clothing: " + getName() + ", $" + getPrice() + ", Size: " + size + ", Material: " + material + ".";
    }
}
