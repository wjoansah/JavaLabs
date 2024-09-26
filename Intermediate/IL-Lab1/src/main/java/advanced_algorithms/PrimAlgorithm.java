package advanced_algorithms;

import java.util.*;

public class PrimAlgorithm {
    private static final int NUM_CITIES = 5;

    private static int findMinKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < NUM_CITIES; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < NUM_CITIES; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    private static void primMST(int[][] graph) {
        int[] key = new int[NUM_CITIES];

        int[] parent = new int[NUM_CITIES];

        boolean[] mstSet = new boolean[NUM_CITIES];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < NUM_CITIES - 1; count++) {
            int u = findMinKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < NUM_CITIES; v++) {
                // Update only if graph[u][v] is smaller and v is not in mstSet
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
