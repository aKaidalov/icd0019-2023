package junit;

import java.util.Arrays;

public class Code {

    public static boolean isSpecial(int candidate) {
        return candidate % 11 <= 3;
    }

    public static int longestStreak(String inputString) {
        if (inputString.length() == 1){
            return 1;
        }
        int maxCount = 0;
        int counter = 1;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == inputString.charAt(i + 1)) {
                counter++;
                if (i + 1 == inputString.length() - 1) {
                    return counter;
                }
            } else if (counter > maxCount) {
                maxCount = counter;
                counter = 1;
            }
        }
        return maxCount;
    }

    public static Character mode(String inputString) {
        if (inputString == null) {
            return null;
        } else {
            Character ch = null;
            int chCount = 0;
            for (int i = 0; i < inputString.length(); i++) {
                int count = getCharacterCount(inputString, inputString.charAt(i));
                if (count > chCount) {
                    ch = inputString.charAt(i);
                    chCount = count;
                }
            }
            return ch;
        }
    }

    public static int getCharacterCount(String allCharacters, char targetCharacter) {
        int counter = 0;
        for (int i = 0; i < allCharacters.length(); i++) {
            if (targetCharacter == allCharacters.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    // -----------------------------------------------------

    public static int[] removeDuplicates(int[] integers) {
        int[] integers2 = arrayCopy(integers);
        int duplicate = -10000;
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = i + 1; j < integers2.length; j++) {
                if (integers[i] == integers2[j]){
                    integers2[j] = duplicate;
                }
            }
        }
        int[] result = filterArray(integers2, duplicate);
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static int[] arrayCopy(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] filterArray(int[] arr, int duplicate){
        int counter = 0;
        for (int a1 : arr) {
            if (a1 == duplicate) {
                counter++;
            }
        }
        int[] newArr = new int[arr.length - counter];
        int j = 0;
        for (int a2 : arr) {
            if (a2 != duplicate) {
                newArr[j] = a2;
                j++;
            }
        }
        return newArr;
    }

    // -----------------------------------------------------

    public static int sumIgnoringDuplicates(int[] integers) {
        int[] newIntegers = removeDuplicates(integers);
        int sum = 0;
        for (int item: newIntegers) {
            sum += item;
        }
        return sum;
    }

//    public static void main(String[] args) {
//        System.out.println(longestStreak("aaaabvvvvv"));
//        // longestStreak("aaaabvvvvv");
//        int[] a = new int[] {1, 2, 1, 3, 2};
//        removeDuplicates(a);
//    }

}
