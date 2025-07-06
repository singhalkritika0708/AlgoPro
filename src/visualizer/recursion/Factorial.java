package visualizer.recursion;

public class Factorial {
    public static int calculate(int n) {
        int result = (n <= 1) ? 1 : n * calculate(n - 1);
        if (n == 1) {
            System.out.println("🧠 Time Complexity: O(n)");
            System.out.println("🧠 Space Complexity: O(n) (due to recursion stack)");
        }
        return result;
    }
}
