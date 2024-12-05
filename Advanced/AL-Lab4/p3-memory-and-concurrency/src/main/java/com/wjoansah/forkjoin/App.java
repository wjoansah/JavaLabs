package com.wjoansah.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        int[] array = new int[10_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(array, 0, array.length);

        long start = System.currentTimeMillis();
        long result = pool.invoke(task);
        long end = System.currentTimeMillis();

        System.out.println("Sum: " + result);
        System.out.println("Time: " + (end - start) + " ms");
    }
}
