package visualizer.sorting;

public class BubbleSort {
    public static void sort(int[] arr) {
        System.out.println("\n🔸 Bubble Sort Visualization:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print("Pass " + (i + 1) + ": ");
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
