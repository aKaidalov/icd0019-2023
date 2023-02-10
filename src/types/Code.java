package types;

import java.util.Arrays;
import java.util.Random;
// Hello
public class Code {

    public static void main(String[] args) {

        int[] numbers1 = {1, 3, -2, 9};
        int[] numbers2 = {1, 2, 3};

        System.out.println(sum(numbers1)); // 11
        System.out.println(sum(numbers2));

        System.out.println(average(numbers1)); // 2.75
        System.out.println(average(numbers2));

        System.out.println(minimumElement(numbers1)); // -2
        System.out.println(minimumElement(numbers2));

        System.out.println(asString(numbers1));
        System.out.println(asString(numbers2));

    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static double average(int[] numbers) {
        double average = Double.valueOf(sum(numbers)) / numbers.length;
        return average;
    }

    public static Integer minimumElement(int[] integers) {
        if (integers.length == 0){
            return null;
        }
        int minValue = integers[0];
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < minValue){
                minValue = integers[i];
            }
        }
        return minValue;
    }

    public static String asString(int[] elements) {
        if (elements.length == 0){
            return "";
        }
        String result = "";
        for (int i = 0; i < elements.length; i++) {
            if (i == 0){
                result += String.valueOf(elements[i]);
            } else {
                result += ", " + String.valueOf(elements[i]);
            }
        }
        return result;
    }

    public static Character mode(String input) {
        if (input == null) {
            return null;
        }
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
