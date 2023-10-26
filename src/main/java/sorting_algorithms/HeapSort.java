package sorting_algorithms;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] unsortedArr = {12, 11, 13, 5, 6};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(unsortedArr);
        System.out.println(Arrays.toString(unsortedArr));
    }

    void heapSort(int[] arr) {
        int temp;

        //build the heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        //extract elements from the heap
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];                        //move current root to end (since it is the largest)
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);                //recall heapify to rebuild heap for the remaining elements
        }
    }

    void heapify(int[] arr, int n, int i) {
        int MAX = i; // Initialize largest as root
        int left = 2 * i + 1; //index of the left child of ith node = 2*i + 1
        int right = 2 * i + 2; //index of the right child of ith node  = 2*i + 2
        int temp;

        //check if the left child of the root is larger than the root
        if (left < n && arr[left] > arr[MAX]) {
            MAX = left;
        }

        //check if the right child of the root is larger than the root
        if (right < n && arr[right] > arr[MAX]) {
            MAX = right;
        }

        //repeat the procedure for finding the largest element in the heap
        if (MAX != i) {
            temp = arr[i];
            arr[i] = arr[MAX];
            arr[MAX] = temp;
            heapify(arr, n, MAX);
        }
    }
}
