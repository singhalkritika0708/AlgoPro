package visualizer.recursion;

public class GCD {
    public static int find(int a, int b) {
        int result = (b == 0) ? a : find(b, a % b);
        if (b == 0) {
            System.out.println("🧠 Time Complexity: O(log(min(a, b)))");
            System.out.println("🧠 Space Complexity: O(log(min(a, b)))");
        }
        return result;
    }
}
