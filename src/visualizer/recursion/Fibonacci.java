package visualizer.recursion;

public class Fibonacci {
    public static int calculate(int n) {
        int result = (n <= 1) ? n : calculate(n - 1) + calculate(n - 2);
        if (n == 1) {
            System.out.println("🧠 Time Complexity: O(2^n)");
            System.out.println("🧠 Space Complexity: O(n)");
        }
        return result;
    }
}
