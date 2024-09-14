package com.wjoansah.strategy;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        SortingContext<Integer> context = new SortingContext<>();

        Integer[] array1 = {5, 3, 8, 4, 2};
        Integer[] array2 = {9, 7, 6, 3, 1};

        // Use Bubble Sort
        context.setSortStrategy(new BubbleSort<>());
        context.sortArray(array1);
        System.out.println("Sorted Array: " + Arrays.toString(array1));

        // Use Quick Sort
        context.setSortStrategy(new QuickSort<>());
        context.sortArray(array2);
        System.out.println("Sorted Array: " + Arrays.toString(array2));
    }
}
