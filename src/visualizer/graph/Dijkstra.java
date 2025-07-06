package visualizer.graph;

import java.util.*;

public class Dijkstra {

    public static void shortestPath(Map<Integer, List<int[]>> graph, int src, int nodes) {
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (dist[next] > cost + weight) {
                    dist[next] = cost + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        System.out.println("✅ Shortest distances from source node " + src + ":");
        for (int i = 0; i < nodes; i++) {
            System.out.println("Node " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }
}
