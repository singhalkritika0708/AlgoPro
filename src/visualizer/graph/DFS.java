package visualizer.graph;

import java.util.*;

public class DFS {

    public static void traverse(Map<Integer, List<Integer>> graph, int start) {
        System.out.println("\n🔸 Depth-First Search (DFS) Traversal:");
        Set<Integer> visited = new HashSet<>();
        System.out.print("Visited: ");
        dfsHelper(graph, start, visited);
        System.out.println();
    }

    private static void dfsHelper(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(graph, neighbor, visited);
            }
        }
    }
}
