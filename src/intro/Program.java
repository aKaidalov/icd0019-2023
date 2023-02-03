package intro;

public class Program {

    public static void main(String[] args) {

        int decimal = asDecimal("11001101");

        System.out.println(decimal); // 205

        String str = asString(decimal);

        System.out.print(str); // "11001101"
    }

    public static String asString(int input) {
        String result = "";
        while (input > 0) {
            if (input % 2 == 0){
                result = '0' + result;
            }
            else {
                result = '1' + result;
            }

            input /= 2;
        }
        return result;
    }

    public static int asDecimal(String input) {
        // 11001101
        input = reverse(input);

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                result += pow(2, i);
            }
        }

        return result;
    }

    private static String reverse(String input) {
        String reversed = "";
        for (int i = 0; i < input.length(); i++) {
            reversed = input.charAt(i) + reversed;
        }
        return reversed;
    }

    private static int pow(int arg, int power) {
        // Java has Math.pow() but this time write your own implementation.
        if (power == 0){
            return 1;
        }
        else {
            int result = 1;
            for (int i = 0; i < power; i++) {
                result *= arg;
            }
            return result;
        }
    }
}
