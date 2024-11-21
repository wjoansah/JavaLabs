package com.wjoansah.design_patterns.facade.shopping;

import java.util.HashMap;
import java.util.Map;

public class DiscountSystem {
    private final Map<String, Double> discountRates = new HashMap<>();

    public DiscountSystem() {
        discountRates.put("ItemA", 0.10); // 10% discount on ItemA
        discountRates.put("PROMO10", 0.10); // 10% promo code discount
    }

    public double calculateDiscount(String itemId) {
        return discountRates.getOrDefault(itemId, 0.0);
    }

    public double applyPromoCode(String promoCode) {
        return discountRates.getOrDefault(promoCode, 0.0);
    }
}
