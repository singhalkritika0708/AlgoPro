package visualizer.search;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        Arrays.sort(arr);  // Binary Search requires sorted array
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println("🔍 Target found at index (after sorting): " + mid);
                System.out.println("🧠 Time Complexity: O(log n)");
                System.out.println("🧠 Space Complexity: O(1)");
                return mid;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("❌ Target not found.");
        return -1;
    }
}
