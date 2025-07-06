package visualizer.graph;

import java.util.*;

public class TopoSort {

    public static void sort(Map<Integer, List<Integer>> graph, int nodes) {
        int[] inDegree = new int[nodes];

        for (List<Integer> neighbors : graph.values()) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() != nodes) {
            System.out.println("❌ Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("✅ Topological Order: " + result);
        }
    }
}
