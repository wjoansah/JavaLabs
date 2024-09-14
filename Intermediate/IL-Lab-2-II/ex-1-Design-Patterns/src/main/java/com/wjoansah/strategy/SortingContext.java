package com.wjoansah.strategy;

public class SortingContext<T extends Comparable<T>> {
    private SortStrategy<T> sortStrategy;

    public void setSortStrategy(SortStrategy<T> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sortArray(T[] array) {
        if (sortStrategy != null) {
            sortStrategy.sort(array);
        } else {
            throw new IllegalStateException("SortStrategy is null");
        }
    }
}
