package visualizer.graph;

import java.util.*;

public class CycleDetector {
    public static boolean hasCycle(Map<Integer, List<Integer>> graph, int nodes) {
        boolean[] visited = new boolean[nodes];
        boolean[] recStack = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor] && dfs(neighbor, graph, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}
