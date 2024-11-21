package com.wjoansah.design_patterns.strategy.sorting;

public interface SortStrategy<T extends Comparable<T>> {
    void sort(T[] array);
}
