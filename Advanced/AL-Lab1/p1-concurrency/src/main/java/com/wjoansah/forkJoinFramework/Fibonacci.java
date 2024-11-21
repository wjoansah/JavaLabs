package com.wjoansah.forkJoinFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {
    private final int n;
    private static final ConcurrentHashMap<Integer, Long> memo = new ConcurrentHashMap<>();

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (memo.containsKey(n)) return memo.get(n);

        if (n <= 1) return Integer.toUnsignedLong(n);

        Fibonacci task1 = new Fibonacci(n - 1);
        task1.fork();

        Fibonacci task2 = new Fibonacci(n - 2);
        Long fib2result = task2.compute();

        Long fib1result = task1.join();

        Long result = fib1result + fib2result;
        memo.put(n, result);

        return memo.get(n);
    }

    public static Long withMemo(Integer n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return Integer.toUnsignedLong(n);

        memo.put(n, withMemo(n - 1, memo) + withMemo(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        int number = 50;

        Long result = pool.invoke(new Fibonacci(number));
        System.out.println("Fibonacci of " + number + " is " + result);

        Map<Integer, Long> memo = new HashMap<>();

        System.out.println("Fibonacci with memoization of  " + number + " is " + withMemo(number, memo));

        memo.clear();
    }
}
//12,586,269,025
//12,586,269,025