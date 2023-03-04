package exceptions.bad;

public class BadTryCatch {

    public boolean containsSingleLetters(String input) {

        int index = 0;

        try {
            while (index < input.length()) {
                if (input.charAt(index) == input.charAt(index + 1)) {
                    return false;
                }

                index++;
            }
        } catch (Exception e) {
            return true;
        }

        return true;
    }


}
