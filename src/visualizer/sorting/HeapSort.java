package visualizer.sorting;

public class HeapSort {

    public static void sort(int[] arr) {
        System.out.println("\n🔸 Heap Sort Visualization:");

        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.print("After building heap: ");
        printArray(arr);

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max) with end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);

            System.out.print("Heap after removing max: ");
            printArray(arr);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare left
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Compare right
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Swap if needed
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Heapify subtree
            heapify(arr, n, largest);
        }
    }

    private static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
}
