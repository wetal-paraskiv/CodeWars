package sorting_algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {5, 9, 2, 11, 14, 6, 3, 8};
//        int[] arr = {2, 1, 3};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        System.out.println("  Sorted array: " + Arrays.toString(quicksort(arr, 0, arr.length - 1)));
    }

    public static int[] quicksort(int[] arr, int start, int end) {
        if (arr != null) {
            if(arr.length <= 1) {
                return arr;
            }
            if (start < end) {
                int pivotIndex = partition(arr, start, end);
                quicksort(arr, start, pivotIndex - 1);
                quicksort(arr, pivotIndex + 1, end);
            }
        }
        return arr;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start]; // choosing first element as pivot
        int i = start;
        for (int j = start + 1; j <= end; j++) { // iterate starting pivot's next element
            if (arr[j] < pivot) { // if next element is smaller than pivot...
                i++; // increase index of last swapped 'smaller than pivot' element
                swap(arr, i, j); // swap founded 'smaller than pivot' element with first bigger than pivot element
            }
        }
        // after iteration through all elements and moving all 'smaller than pivot' elements =>
        // swap pivot from start to correct index
        swap(arr, start, i);
        return i; // return pivot's index
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
