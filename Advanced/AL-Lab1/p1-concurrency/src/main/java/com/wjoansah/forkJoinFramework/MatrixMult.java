package com.wjoansah.forkJoinFramework;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MatrixMult extends RecursiveTask<Integer> {
    private final ArrayList<ArrayList<Integer>> m1;
    private final ArrayList<ArrayList<Integer>> m2;
    private final ArrayList<ArrayList<Integer>> result;

    public MatrixMult(ArrayList<ArrayList<Integer>> m1,
                      ArrayList<ArrayList<Integer>> m2,
                      ArrayList<ArrayList<Integer>> result) {
        this.m1 = m1;
        this.m2 = m2;
        this.result = result;
    }

    @Override
    protected Integer compute() {
        int m1Rows = m1.size();
        int m2Rows = m2.size();
        int m1Cols = m1.get(0).size();
        int m2Cols = m2.get(0).size();

        if (m1Cols != m2Rows) throw new IllegalArgumentException("matrices row and cols do not match");
        System.out.println("m1rows: " + m1Rows);
        System.out.println("m2cols: " + m2Cols);


        for (int i = 0; i < m1Rows; i++) {
            result.add(i, new ArrayList<>());

            ArrayList<ArrayList<Integer>> wrapper = new ArrayList<>();
            wrapper.add(m1.get(i));

            MatrixMult subMatrixMult = new MatrixMult(wrapper, m2, result);
            subMatrixMult.fork();
            subMatrixMult.performSubMatrixMult(wrapper.get(0), m2, i);

            result.get(i).set(i, subMatrixMult.join());
        }


//        for (int i = 0; i < m1Rows; i++) {
//            result.add(new ArrayList<>());
//            for (int j = 0; j < m2Cols; j++) {
//                result.get(i).add(j, 0);
//                for (int k = 0; k < m1Cols; k++) {
//                    System.out.println("[m1] " + m1.get(i).get(k));
//                    System.out.println("[m2] " + m2.get(k).get(j));
//                    System.out.println("i: " + i + ", j: " + j + ", k " + k);
//                    System.out.println("result: " + result);
//                    System.out.println("--------------------------");
//                    result.get(i).set(j, result.get(i).get(j) + m1.get(i).get(k) * m2.get(k).get(j));
//                }
//            }
//        }

        return 0;
    }

    private Integer performSubMatrixMult(ArrayList<Integer> matrixRow, ArrayList<ArrayList<Integer>> matrixCol, Integer rowIndex) {
        Integer result = 0;
        for (int i = 0; i < matrixCol.get(0).size(); i++) {
            for (int j = 0; j < matrixRow.size(); j++) {
                System.out.println("[m1] " + m1.get(rowIndex).get(j));
                System.out.println("[m2] " + m2.get(j).get(rowIndex));
                System.out.println("i: " + i + ", j: " + i + ", k " + j);
                System.out.println("--------------------------");
                result += m1.get(rowIndex).get(j) * m2.get(j).get(rowIndex);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] mult = new int[2][3];
        ArrayList<ArrayList<Integer>> matrix2x3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Initialize the 2x3 matrix
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);

        // Add rows to the matrix
        matrix2x3.add(row1);
        matrix2x3.add(row2);

        // 3x2 matrix using ArrayList
        ArrayList<ArrayList<Integer>> matrix3x2 = new ArrayList<>();

        // Initialize the 3x2 matrix
        ArrayList<Integer> rowA = new ArrayList<>();
        rowA.add(7);
        rowA.add(8);

        ArrayList<Integer> rowB = new ArrayList<>();
        rowB.add(9);
        rowB.add(10);

        ArrayList<Integer> rowC = new ArrayList<>();
        rowC.add(11);
        rowC.add(12);

        // Add rows to the matrix
        matrix3x2.add(rowA);
        matrix3x2.add(rowB);
        matrix3x2.add(rowC);

        MatrixMult matrixMult = new MatrixMult(matrix2x3, matrix3x2, result);

        ForkJoinPool pool = new ForkJoinPool(4);

        pool.invoke(matrixMult);

        System.out.println(result);

        System.out.println(mult.length);
        System.out.println(mult[0].length);
    }
}
