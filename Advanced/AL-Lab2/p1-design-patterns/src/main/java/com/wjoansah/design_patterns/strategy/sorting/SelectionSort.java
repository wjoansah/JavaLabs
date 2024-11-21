package com.wjoansah.design_patterns.strategy.sorting;

public class SelectionSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(T[] array) {
        int n = array.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Assume the first element is the minimum
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
