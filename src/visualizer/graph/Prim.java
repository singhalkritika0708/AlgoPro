package visualizer.graph;

import java.util.*;

public class Prim {
    public static void mst(int nodes, Map<Integer, List<int[]>> graph) {
        boolean[] visited = new boolean[nodes];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0, 0}); // node, weight
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], weight = curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            totalCost += weight;
            System.out.println("Edge Included → Node: " + node + ", Weight: " + weight);

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited[neighbor[0]]) {
                    pq.offer(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }

        System.out.println("🌐 Total MST Cost (Prim): " + totalCost);
    }
}