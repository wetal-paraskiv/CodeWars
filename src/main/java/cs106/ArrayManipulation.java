package cs106;

import java.util.Scanner;

public class ArrayManipulation {
    Scanner scan = new Scanner(System.in);

    public void intArr() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] myArray = new int[5];
        int value = 5;
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = value;
            value--;
        }
        for (int num : myArray
        ) {
            System.out.println(num);
        }
    }

    public void strArr() {
        String[] myStrArray = new String[3];
        for (int i = 0; i < myStrArray.length; i++) {
            myStrArray[i] = "stringValue";
        }
        myStrArray[2] = "changedStringValue";
        for (String s : myStrArray
        ) {
            System.out.println(s);
        }
    }

    public void actualEffectiveSizeOfArr() {
        // actual size of array and effective size of array
        final int SENTINEL = -1;
        int numScores = 0;
        try {
            System.out.println("Enter the maximum size of midTermScores Array: ");
            int maxSize = scan.nextInt();
            int[] midTermScoreArr = new int[maxSize];
            for (int i = 0; i < maxSize; i++) {
                System.out.println("(-1 to quit) or enter score N" + (i + 1));
                int midScore = scan.nextInt();
                if (midScore == SENTINEL) break;
                midTermScoreArr[numScores++] = midScore;
            }
            System.out.println("midTermScoreArr - actual size: " + maxSize);
            System.out.println("midTermScoreArr - effective size: " + numScores);
            System.out.println("The average score: " + averageScore(midTermScoreArr, numScores));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private double averageScore(int[] arr, int numScores) {
        double total = 0;
        for (int i = 0; i < numScores; i++) {
            total += arr[i];
        }
        return total / numScores;
    }

    public static void main(String[] args) {
        new ArrayManipulation().actualEffectiveSizeOfArr();
    }


}
