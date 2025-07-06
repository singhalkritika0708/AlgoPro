package visualizer.graph;

import java.util.*;

public class BFS {

    public static void traverse(Map<Integer, List<Integer>> graph, int start) {
        System.out.println("\n🔸 Breadth-First Search (BFS) Traversal:");
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("Visited: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}
