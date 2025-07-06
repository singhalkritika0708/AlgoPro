package visualizer.graph;

import java.util.*;

public class Kruskal {
    public static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.weight = w;
        }
    }

    static int[] parent;

    public static void mst(int nodes, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) parent[i] = i;

        int cost = 0;
        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges) {
            int uSet = find(edge.u);
            int vSet = find(edge.v);
            if (uSet != vSet) {
                cost += edge.weight;
                result.add(edge);
                parent[uSet] = vSet;
            }
        }

        System.out.println("✅ MST Edges (Kruskal):");
        for (Edge e : result) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
        }
        System.out.println("🌐 Total MST Cost: " + cost);
    }

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}