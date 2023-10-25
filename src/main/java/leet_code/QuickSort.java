package leet_code;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int [] unsorted = new int[]{17, 41, 5, 22, 54, 6, 29, 3, 13};
        System.out.println(Arrays.toString(unsorted));
        qs.quickSortRecursive(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public void quickSortRecursive(int[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
    }

    private void quickSort(int[] unsorted, int lowerIndex, int upperIndex) {
        if (lowerIndex < upperIndex + 1) {
            int p = partition(unsorted, lowerIndex, upperIndex);
            quickSort(unsorted, lowerIndex, p - 1);
            quickSort(unsorted, p + 1, upperIndex);
        }
    }

    private int partition(int[] unsorted, int lowerIndex, int upperIndex) {
        swap(unsorted, lowerIndex, getPivotRand(lowerIndex, upperIndex));
        int border = lowerIndex + 1;
        for (int i = border; i <= upperIndex; i++) {
            if (unsorted[i] < unsorted[lowerIndex]) {
                swap(unsorted, i, border++);
            }
        }
        swap(unsorted, lowerIndex, border - 1);
        return border - 1;
    }

    private void swap(int[] unsorted, int lowerIndex, int upperIndex) {
        int temp = unsorted[lowerIndex];
        unsorted[lowerIndex] = unsorted[upperIndex];
        unsorted[upperIndex] = temp;
    }

    private int getPivotRand(int lowerIndex, int upperIndex) {
        Random random = new Random();
        return random.nextInt((upperIndex - lowerIndex) + 1) + lowerIndex;
    }

}
