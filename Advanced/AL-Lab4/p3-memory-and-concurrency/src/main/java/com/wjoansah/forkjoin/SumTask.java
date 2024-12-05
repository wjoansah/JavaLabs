package com.wjoansah.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1_000;
    private final int[] array;
    private final int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }

        int middle = (start + end) / 2;
        SumTask left = new SumTask(array, start, middle);
        SumTask right = new SumTask(array, middle, end);

        left.fork();
        long rightResult = right.compute();
        long leftResult = left.join();

        return leftResult + rightResult;
    }
}
