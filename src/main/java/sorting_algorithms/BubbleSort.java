package sorting_algorithms;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] unsorted = {6, 4, 5, 3, 2, 1};
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedArray = bubbleSort(unsorted);
        printArray(sortedArray);
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

    static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
