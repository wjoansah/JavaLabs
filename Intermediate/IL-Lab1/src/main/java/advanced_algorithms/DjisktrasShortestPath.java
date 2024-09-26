package advanced_algorithms;

import java.util.*;

public class DjisktrasShortestPath {
    static class Graph {
        private final Map<Integer, List<Edge>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        static class Edge {
            int destination;
            int weight;

            public Edge(int destination, int weight) {
                this.destination = destination;
                this.weight = weight;
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, weight));
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, weight));
        }

        // Dijkstra's algorithm to find the shortest path from a source node to a target node
        public int dijkstra(int source, int target) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
            pq.add(new int[]{source, 0});

            Map<Integer, Integer> distances = new HashMap<>();
            distances.put(source, 0);

            Set<Integer> visited = new HashSet<>();

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0];
                int currentDist = current[1];

                if (node == target) {
                    return currentDist;
                }

                if (visited.contains(node)) {
                    continue;
                }

                visited.add(node);

                for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(edge.destination)) {
                        int newDist = currentDist + edge.weight;
                        // If the new distance is shorter, update it and add to the priority queue
                        if (newDist < distances.getOrDefault(edge.destination, Integer.MAX_VALUE)) {
                            distances.put(edge.destination, newDist);
                            pq.add(new int[]{edge.destination, newDist});
                        }
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            Graph graph = new Graph();

            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 1);
            graph.addEdge(2, 1, 2);
            graph.addEdge(1, 3, 1);
            graph.addEdge(2, 3, 5);
            graph.addEdge(3, 4, 3);

            int shortestPath = graph.dijkstra(0, 4);
            System.out.println("Shortest path from node 0 to node 4: " + shortestPath);
        }
    }
}


