package sorting_algorithms;

import java.util.Arrays;

public class BubbleSort {
    /*
    * Bubble Sort is the simplest sorting algorithm
    * that works by repeatedly swapping the adjacent elements if they are in the wrong order.
    * This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.
    */
    public static void main(String[] args) {
//        int[] unsorted = {6, 4, 5, 3, 2, 1};
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(Arrays.toString(bubbleSort(unsorted)));
    }

    public static int[] bubbleSort(int[] arr) {
        int temp;
        int start = 0;
        int end = arr.length - 1;
        while (start != end) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            -- end;
        }
        return arr;
    }
}
