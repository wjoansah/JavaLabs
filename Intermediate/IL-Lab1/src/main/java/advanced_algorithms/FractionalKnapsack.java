package advanced_algorithms;

import java.util.Arrays;

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(int capacity, Item[] items) {
        Arrays.sort(items, (o1, o2) -> {
            double r1 = (double) o1.value / o1.weight;
            double r2 = (double) o2.value / o2.weight;
            // Sort in decreasing order of ratio
            return Double.compare(r2, r1);
        });

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity == 0) break;

            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                double fraction = ((double) remainingCapacity / item.weight);
                totalValue += item.value * fraction;
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
