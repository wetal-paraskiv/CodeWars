package cs106;

import java.util.Arrays;

public class ArrayMultiDimensional {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        int[][][] matrix3D = new int[5][5][5];
        int counter = 0;
        for (int i = 0; i < matrix3D.length; i++) {
            for (int j = 0; j < matrix3D[i].length; j++) {
                for (int k = 0; k < matrix3D[i][j].length; k++) {
                    matrix3D[i][j][k] = counter;
                    counter++;
                }
            }
        }
        System.out.println(counter);
        System.out.println(Arrays.deepToString(matrix3D));
    }
}
