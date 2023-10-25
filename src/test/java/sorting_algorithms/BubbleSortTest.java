package sorting_algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static sorting_algorithms.BubbleSort.bubbleSort;

class BubbleSortTest {
    @Test
    void bubbleSortTest() {
        Assertions.assertArrayEquals(
                new int[]{11, 12, 22, 25, 34, 64, 90}, bubbleSort(new int[]{64, 34, 25, 12, 22, 11, 90}));
        Assertions.assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6}, bubbleSort(new int[]{6, 4, 5, 3, 2, 1}));
    }
}