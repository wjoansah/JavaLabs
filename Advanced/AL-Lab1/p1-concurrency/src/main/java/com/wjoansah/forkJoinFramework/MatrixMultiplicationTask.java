package com.wjoansah.forkJoinFramework;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class MatrixMultiplicationTask extends RecursiveAction {
    private final ArrayList<ArrayList<Integer>> matrixA;
    private final ArrayList<ArrayList<Integer>> matrixB;
    private final ArrayList<ArrayList<Integer>> result;
    private final int startRow, endRow;

    private static final int THRESHOLD = 1; // Minimum granularity for parallelism

    public MatrixMultiplicationTask(ArrayList<ArrayList<Integer>> matrixA,
                                    ArrayList<ArrayList<Integer>> matrixB,
                                    ArrayList<ArrayList<Integer>> result,
                                    int startRow, int endRow) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    protected void compute() {
        if ((endRow - startRow) <= THRESHOLD) {
            // Perform matrix multiplication for the assigned row range
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrixB.get(0).size(); j++) {
                    int sum = 0;
                    for (int k = 0; k < matrixA.get(0).size(); k++) {
                        sum += matrixA.get(i).get(k) * matrixB.get(k).get(j);
                    }
                    result.get(i).set(j, sum); // Store the result in the result matrix
                }
            }
        } else {
            // Split the task into two subtasks
            int mid = (startRow + endRow) / 2;
            invokeAll(new MatrixMultiplicationTask(matrixA, matrixB, result, startRow, mid),
                    new MatrixMultiplicationTask(matrixA, matrixB, result, mid, endRow));
        }
    }

    public static void main(String[] args) {
        // Initialize matrix A (2x3)
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
        matrixA.add(new ArrayList<>());
        matrixA.get(0).add(1);
        matrixA.get(0).add(2);
        matrixA.get(0).add(3);
        matrixA.add(new ArrayList<>());
        matrixA.get(1).add(4);
        matrixA.get(1).add(5);
        matrixA.get(1).add(6);

        // Initialize matrix B (3x2)
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();
        matrixB.add(new ArrayList<>());
        matrixB.get(0).add(7);
        matrixB.get(0).add(8);
        matrixB.add(new ArrayList<>());
        matrixB.get(1).add(9);
        matrixB.get(1).add(10);
        matrixB.add(new ArrayList<>());
        matrixB.get(2).add(11);
        matrixB.get(2).add(12);

        // Resultant matrix (2x2) initialized with zeros
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(0);
        result.get(0).add(0);
        result.add(new ArrayList<>());
        result.get(1).add(0);
        result.get(1).add(0);

        // Perform parallel matrix multiplication
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.invoke(new MatrixMultiplicationTask(matrixA, matrixB, result, 0, matrixA.size()));

        System.out.println(result);

        // Display the result
        System.out.println("Resultant Matrix:");
        for (ArrayList<Integer> row : result) {
            for (Integer elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
