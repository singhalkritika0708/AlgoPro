package visualizer.sorting;

public class InsertionSort {
    public static void sort(int[] arr) {
        System.out.println("\n🔸 Insertion Sort Visualization:");

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            System.out.print("After inserting element " + key + ": ");
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
}
