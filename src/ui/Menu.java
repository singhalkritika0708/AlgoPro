package ui;

import visualizer.graph.*;
import visualizer.recursion.*;
import visualizer.search.*;
import visualizer.sorting.*;
import visualizer.tree.*;

import java.util.*;

public class Menu {
    public static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printLine();
            System.out.println("🔷 WELCOME TO ALGOPRO 🔷");
            printLine();
            System.out.println("1️⃣  Sorting Algorithms");
            System.out.println("2️⃣  Graph Algorithms");
            System.out.println("3️⃣  Recursion Algorithms");
            System.out.println("4️⃣  Searching Algorithms");
            System.out.println("5️⃣  Tree Traversals");
            System.out.println("0️⃣  Exit");
            printLine();
            System.out.print("📥 Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> showSortingMenu();
                case 2 -> showGraphMenu();
                case 3 -> showRecursionMenu();
                case 4 -> showSearchMenu();
                case 5 -> showTreeMenu();
                case 0 -> {
                    System.out.println("👋 Exiting AlgoPro. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // -----------------------------------------
    private static void showSortingMenu() {
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("📊 Sorting Algorithms");
        printLine();
        System.out.println("1️⃣  Bubble Sort");
        System.out.println("2️⃣  Merge Sort");
        System.out.println("3️⃣  Quick Sort");
        System.out.println("4️⃣  Insertion Sort");
        System.out.println("5️⃣  Selection Sort");
        System.out.println("6️⃣  Heap Sort");
        printLine();
        System.out.print("📥 Select an algorithm (1–6): ");
        int choice = sc.nextInt();

        System.out.print("🔢 Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("🧮 Enter " + n + " integers separated by space: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("\n🎬 Sorting Process Begins...\n");
        switch (choice) {
            case 1 -> BubbleSort.sort(arr);
            case 2 -> MergeSort.sort(arr, 0, n - 1);
            case 3 -> QuickSort.sort(arr, 0, n - 1);
            case 4 -> InsertionSort.sort(arr);
            case 5 -> SelectionSort.sort(arr);
            case 6 -> HeapSort.sort(arr);
            default -> System.out.println("❌ Invalid choice.");
        }

        printLine();
        System.out.print("✅ Sorted Output: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println("\n🧠 Time Complexity: " + getComplexity(choice));
        printLine();
    }

    // -----------------------------------------
    private static void showGraphMenu() {
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("🌐 Graph Algorithms");
        printLine();
        System.out.println("1️⃣  BFS");
        System.out.println("2️⃣  DFS");
        System.out.println("3️⃣  Topological Sort");
        System.out.println("4️⃣  Dijkstra's Algorithm");
        System.out.println("5️⃣  Cycle Detection");
        System.out.println("6️⃣  Kruskal's MST");
        System.out.println("7️⃣  Prim's MST");
        printLine();
        System.out.print("📥 Choose an algorithm: ");
        int choice = sc.nextInt();

        System.out.print("🔢 Enter number of nodes: ");
        int nodes = sc.nextInt();

        switch (choice) {
            case 1, 2, 3, 5 -> {
                System.out.print("🔗 Enter number of edges: ");
                int e = sc.nextInt();
                Map<Integer, List<Integer>> graph = new HashMap<>();
                System.out.println("📝 Enter each edge (u v):");
                for (int i = 0; i < e; i++) {
                    int u = sc.nextInt(), v = sc.nextInt();
                    graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                    graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
                }
                if (choice == 1) {
                    System.out.print("🚩 Enter starting node: ");
                    BFS.traverse(graph, sc.nextInt());
                } else if (choice == 2) {
                    System.out.print("🚩 Enter starting node: ");
                    DFS.traverse(graph, sc.nextInt());
                } else if (choice == 3) TopoSort.sort(graph, nodes);
                else System.out.println("🔍 Cycle Present: " + CycleDetector.hasCycle(graph, nodes));
            }
            case 4, 7 -> {
                System.out.print("🔗 Enter number of edges: ");
                int e = sc.nextInt();
                Map<Integer, List<int[]>> graph = new HashMap<>();
                System.out.println("📝 Enter each edge (u v weight):");
                for (int i = 0; i < e; i++) {
                    int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
                    graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
                    graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
                }
                System.out.print("🚩 Enter starting node: ");
                int start = sc.nextInt();
                if (choice == 4) Dijkstra.shortestPath(graph, start, nodes);
                else Prim.mst(nodes, graph);
            }
            case 6 -> {
                System.out.print("🔗 Enter number of edges: ");
                int e = sc.nextInt();
                List<Kruskal.Edge> edges = new ArrayList<>();
                System.out.println("📝 Enter each edge (u v weight):");
                for (int i = 0; i < e; i++) {
                    int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
                    edges.add(new Kruskal.Edge(u, v, w));
                }
                Kruskal.mst(nodes, edges);
            }
            default -> System.out.println("❌ Invalid choice.");
        }
        printLine();
    }

    // -----------------------------------------
    private static void showRecursionMenu() {
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("🔁 Recursion Algorithms");
        printLine();
        System.out.println("1️⃣  Factorial");
        System.out.println("2️⃣  Fibonacci");
        System.out.println("3️⃣  Tower of Hanoi");
        System.out.println("4️⃣  GCD");
        printLine();
        System.out.print("📥 Choose an algorithm: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter n: ");
                System.out.println("Result: " + Factorial.calculate(sc.nextInt()));
            }
            case 2 -> {
                System.out.print("Enter n: ");
                System.out.println("Result: " + Fibonacci.calculate(sc.nextInt()));
            }
            case 3 -> {
                System.out.print("Enter number of disks: ");
                int n = sc.nextInt();
                TowerOfHanoi.solve(n, 'A', 'C', 'B');
            }
            case 4 -> {
                System.out.print("Enter a and b: ");
                int a = sc.nextInt(), b = sc.nextInt();
                System.out.println("GCD: " + GCD.find(a, b));
            }
            default -> System.out.println("❌ Invalid choice.");
        }
        printLine();
    }

    // -----------------------------------------
    private static void showSearchMenu() {
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("🔍 Searching Algorithms");
        printLine();
        System.out.println("1️⃣  Linear Search");
        System.out.println("2️⃣  Binary Search");
        printLine();
        System.out.print("Choose an algorithm: ");
        int choice = sc.nextInt();

        System.out.print("🔢 Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("🧮 Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("🎯 Enter target element: ");
        int target = sc.nextInt();

        if (choice == 1) LinearSearch.search(arr, target);
        else if (choice == 2) BinarySearch.search(arr, target);
        else System.out.println("❌ Invalid choice.");
        printLine();
    }

    // -----------------------------------------
    private static void showTreeMenu() {
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("🌳 Binary Tree Traversals");
        printLine();
        System.out.println("1️⃣  InOrder");
        System.out.println("2️⃣  PreOrder");
        System.out.println("3️⃣  PostOrder");
        printLine();
        System.out.print("Choose traversal: ");
        int choice = sc.nextInt();

        System.out.print("🔢 Enter number of nodes: ");
        int n = sc.nextInt();
        int[] nodes = new int[n];
        System.out.println("🧮 Enter " + n + " integers (-1 for nulls): ");
        for (int i = 0; i < n; i++) nodes[i] = sc.nextInt();

        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println("🎬 Traversal: ");
        switch (choice) {
            case 1 -> BinaryTree.inOrder(root);
            case 2 -> BinaryTree.preOrder(root);
            case 3 -> BinaryTree.postOrder(root);
            default -> System.out.println("❌ Invalid choice.");
        }
        System.out.println();
        BinaryTree.printComplexity();
        printLine();
    }

    private static String getComplexity(int algo) {
        return switch (algo) {
            case 1, 4, 5 -> "O(n²)";
            case 2, 3, 6 -> "O(n log n)";
            default -> "Unknown";
        };
    }

    private static void printLine() {
        System.out.println("────────────────────────────────────────────");
    }
}
