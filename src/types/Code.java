package types;

import java.util.Arrays;
import java.util.Random;
// Hello
public class Code {

    public static void main(String[] args) {

        int[] numbers = {1, 3, -2, 9};

        System.out.println(sum(numbers)); // 11
    }

    public static int sum(int[] numbers) {
        return 0;
    }

    public static double average(int[] numbers) {
        return 0.0;
    }

    public static Integer minimumElement(int[] integers) {
        return null;
    }

    public static String asString(int[] elements) {
        return "";
    }

    public static Character mode(String input) {
        return null;
    }

    public static String squareDigits(String s) {
        return "";
    }

    public static int isolatedSquareCount() {
        boolean[][] matrix = getSampleMatrix();

        printMatrix(matrix);

        int isolatedCount = 0;

        // count isolates squares here

        return isolatedCount;
    }

    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean[][] getSampleMatrix() {
        boolean[][] matrix = new boolean[10][10];

        Random r = new Random(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = r.nextInt(5) < 2;
            }
        }

        return matrix;
    }
}
