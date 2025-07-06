package visualizer.sorting;

public class SelectionSort {
    public static void sort(int[] arr) {
        System.out.println("\n🔸 Selection Sort Visualization:");

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            System.out.print("After selecting index " + i + ": ");
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
}
