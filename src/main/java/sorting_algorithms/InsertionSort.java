package sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArr = {12, 11, 13, 5, 6};
        System.out.println(Arrays.toString(insertionSort(unsortedArr)));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int prevIndex = i - 1;

            while (prevIndex >= 0 && arr[prevIndex] > key) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex = prevIndex - 1;
            }
            arr[prevIndex + 1] = key;
        }
        return arr;
    }

}
