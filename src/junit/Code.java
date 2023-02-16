package junit;

public class Code {

    public static boolean isSpecial(int candidate) {
        return candidate % 11 <= 3;
    }

    public static int longestStreak(String inputString) {
        return 0;
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
            if (targetCharacter == allCharacters.charAt(i)){
                counter++;
            }
        }
        return counter;
    }

    public static int[] removeDuplicates(int[] integers) {
        return null;
    }

    public static int sumIgnoringDuplicates(int[] integers) {
        return 0;
    }

}
