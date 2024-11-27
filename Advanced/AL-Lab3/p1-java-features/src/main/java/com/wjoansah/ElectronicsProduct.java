package com.wjoansah;

public final class ElectronicsProduct extends SealedProduct {
    private final String brand;
    private final int warrantyInMonths;

    public ElectronicsProduct(String name, double price, String brand, int warrantyInMonths) {
        super(name, price);
        this.brand = brand;
        this.warrantyInMonths = warrantyInMonths;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyInMonths() {
        return warrantyInMonths;
    }

    @Override
    public String description() {
        return "Electronics: " + getName() + " by " + brand + ", $" + getPrice() + ", Warranty: " + warrantyInMonths + " months.";
    }
}
