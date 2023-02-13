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

        System.out.println(mode("abccbc")); // c

        System.out.println(squareDigits("a9b2")); // a81b4

        System.out.println(isolatedSquareCount());
    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double average(int[] numbers) {
        return Double.valueOf(sum(numbers)) / numbers.length;
    }

    public static Integer minimumElement(int[] integers) {
        if (integers.length == 0){
            return null;
        }
        int minValue = integers[0];
        for (int integer : integers) {
            if (integer < minValue) {
                minValue = integer;
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
                result += ", " + elements[i];
            }
        }
        return result;
    }

    public static Character mode(String input) {
        if (input == null) {
            return null;
        } else {
            Character ch = null;
            int chCount = 0;
            for (int i = 0; i < input.length(); i++) {
                int count = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == input.charAt(i)){
                        count++;
                    }
                }
                if (count > chCount){
                    ch = input.charAt(i);
                    chCount = count;
                }
            }
            return ch;
        }
    }

    public static String squareDigits(String s) {
        if (s.length() == 0){
            return s;
        }
        char[] separatedString = s.toCharArray();
        String result = "";
        for (char character : separatedString){
            if (Character.isDigit(character)){
                int newInt = Integer.parseInt(String.valueOf(character));
                int sqrt = newInt * newInt;
                result += sqrt;
            } else {
                result += character;
            }
        }
        return result;
    }

    public static int isolatedSquareCount() {
        boolean[][] matrix = getSampleMatrix();

        printMatrix(matrix);

        int isolatedCount = 0;

        // count isolates squares here
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // was inspired by this: https://www.geeksforgeeks.org/find-safe-cells-in-a-matrix/
                int counter = 0;

                counter += checkCell(i - 1, j - 1, matrix);
                counter += checkCell(i - 1, j, matrix);
                counter += checkCell(i - 1, j + 1, matrix);
                counter += checkCell(i, j + 1, matrix);
                counter += checkCell(i + 1, j + 1, matrix);
                counter += checkCell(i + 1, j, matrix);
                counter += checkCell(i + 1, j - 1, matrix);
                counter += checkCell(i, j - 1, matrix);

                if (counter == 8) {
                    isolatedCount++;
                }
            }
        }
        return isolatedCount;
    }

    public static int checkCell (int i, int j, boolean[][] matrix){ // return 0 or 1
        if (i < 0 || j < 0 || i > 9 || j > 9){
            return 1;   // if a cell is out of matrix
        } else if (!matrix[i][j]) {
            return 1;   // if a cell is in matrix
        }
        return 0;
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

    /*
    public static int isolatedSquareCount() {
    boolean[][] matrix = getSampleMatrix();

    printMatrix(matrix);

    int isolatedCount = 0;

    // count isolates squares here
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            int counter = 0;
            if (i - 1 < 0 || j - 1 < 0){    // if a cell is out of matrix
                counter++;
            } else if (!matrix[i - 1][j - 1]) { // if a cell is in matrix
                counter++;
            }

            if (i - 1 < 0){
                counter++;
            } else if (!matrix[i - 1][j]) {
                counter++;
            }

            if (i - 1 < 0 || j + 1 > 9){
                counter++;
            } else if (!matrix[i - 1][j + 1]) {
                counter++;
            }

            if (j + 1 > 9){
                counter++;
            } else if (!matrix[i][j + 1]) {
                counter++;
            }

            if (i + 1 > 9 || j + 1 > 9){
                counter++;
            } else if (!matrix[i + 1][j + 1]) {
                counter++;
            }

            if (i + 1 > 9){
                counter++;
            } else if (!matrix[i + 1][j]) {
                counter++;
            }

            if (i + 1 > 9 || j - 1 < 0){
                counter++;
            } else if (!matrix[i + 1][j - 1]) {
                counter++;
            }

            if (j - 1 < 0){
                counter++;
            } else if (!matrix[i][j - 1]) {
                counter++;
            }

            if (counter == 8) {
                isolatedCount++;
            }
        }
        return isolatedCount;
    }
     */
