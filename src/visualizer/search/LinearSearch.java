package visualizer.search;

public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("🔍 Target found at index: " + i);
                System.out.println("🧠 Time Complexity: O(n)");
                System.out.println("🧠 Space Complexity: O(1)");
                return i;
            }
        }
        System.out.println("❌ Target not found.");
        return -1;
    }
}
