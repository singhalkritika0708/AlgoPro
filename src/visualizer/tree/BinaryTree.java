package visualizer.tree;

import java.util.*;

public class BinaryTree {
    public static class Node {
        int data;
        Node left, right;
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static Node buildTree(int[] nodes) {
        if (nodes.length == 0) return null;
        Node root = new Node(nodes[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            Node curr = queue.poll();
            if (nodes[i] != -1) {
                curr.left = new Node(nodes[i]);
                queue.add(curr.left);
            }
            i++;
            if (i < nodes.length && nodes[i] != -1) {
                curr.right = new Node(nodes[i]);
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void printComplexity() {
        System.out.println("\n🧠 Time Complexity: O(n)");
        System.out.println("🧠 Space Complexity: O(h), where h is height of tree");
    }
}
