package oo.hide;

public class Fibonacci {

    private int current = 0;
    private int next = 1;

//    static boolean firstAttempt = true;
//    static boolean secondAttempt = true;
//
//    public int nextValue() {
//        if (firstAttempt){
//            firstAttempt = false;
//            return 0;
//        } else if (secondAttempt){
//            secondAttempt = false;
//            return 1;
//        } else {
//            int n = nMinus1 + nMinus2;
//            nMinus1 = nMinus2;
//            nMinus2 = n;
//            return n;
//        }
//    }

// bollee logichn6i variant reshenija

    public int nextValue() {  // 0, 1, 1, 2, 3, 5, 8...
        int result = current;

        current = next;
        next += result;

        return result;
    }
}
