package advanced_algorithms;

import java.util.*;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjacencyList.putIfAbsent(u, new ArrayList<>());
        adjacencyList.putIfAbsent(v, new ArrayList<>());
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal Starting from Node " + startNode + ":");
        dfs(startNode, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);

        graph.dfs(0);
    }
}
