package com.wjoansah.strategy;

public interface SortStrategy<T extends Comparable<T>> {
    void sort(T[] array);
}
