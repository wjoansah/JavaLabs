package com.wjoansah.forkJoinFramework;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    public static int THRESHOLD = 1000;

    private final int[] array;

    public SumTask(int[] array) {
        this.array = array;
    }

    @Override
    protected Long compute() {
        if (array.length < THRESHOLD) {
            // perform sum sequentially
            return performSum(array);
        } else {
            int middle = array.length / 2;
            SumTask left = new SumTask(Arrays.copyOfRange(array, 0, middle));
            SumTask right = new SumTask(Arrays.copyOfRange(array, middle, array.length));
            left.fork();
            right.fork();

            return left.join() + right.join();
        }
    }

    private Long performSum(int[] array) {
        return Arrays.stream(array)
                .asLongStream()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        int[] arrayBelowThreshold = new int[] {
            868, 782, 493, 408, 204, 599, 791, 232, 72, 203
        } ;
        SumTask sumTask = new SumTask(arrayBelowThreshold);

        ForkJoinPool pool = new ForkJoinPool(4);
        Long result = pool.invoke(sumTask);

        System.out.println("the result of the sum is: " + result);
    }
}
