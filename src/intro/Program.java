package intro;

public class Program {

    public static void main(String[] args) {

        int decimal = asDecimal("11001101");

        System.out.println(decimal); // 205
    }

    public static String asString(int input) {
        return "";
    }

    public static int asDecimal(String input) {
        // 11001101
        input = reverse(input);
        for (int i = 0; i < input.length(); i++) {

        }

        return 0;
    }

    private static String reverse(String input) {
        String reversed = "";
        return "";
    }

    private static int pow(int arg, int power) {
        // Java has Math.pow() but this time write your own implementation.

        return 0;
    }
}
