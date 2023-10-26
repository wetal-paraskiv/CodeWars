package sorting_algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArr = {12, 11, 13, 5, 6};
        System.out.println(Arrays.toString(selectionSort(unsortedArr)));
    }

    public static int[] selectionSort(int[] arr) {
        int pos;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                //find the index of the minimum element
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            //swap the current element with the minimum element
            temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
