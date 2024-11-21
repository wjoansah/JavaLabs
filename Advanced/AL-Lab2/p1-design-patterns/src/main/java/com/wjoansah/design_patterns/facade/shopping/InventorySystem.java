package com.wjoansah.design_patterns.facade.shopping;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventorySystem() {
        stock.put("ItemA", 10);
        stock.put("ItemB", 5);
    }

    public boolean isInStock(String itemId) {
        return stock.getOrDefault(itemId, 0) > 0;
    }

    public void reduceStock(String itemId) {
        stock.put(itemId, stock.get(itemId) - 1);
    }
}
