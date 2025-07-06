package visualizer.recursion;

public class TowerOfHanoi {
    public static void solve(int n, char from, char to, char aux) {
        if (n == 0) return;
        solve(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        if (n == 1) {
            System.out.println("🧠 Time Complexity: O(2^n)");
            System.out.println("🧠 Space Complexity: O(n)");
        }
        solve(n - 1, aux, to, from);
    }
}
