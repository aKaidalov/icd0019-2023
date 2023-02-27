package oo.hide;

public class Counter {

    private int start;
    private int step;
//    static boolean firstAttempt = true;

    public Counter(int start, int step) {
        this.start = start;
        this.step = step;
    }

    public int nextValue() {
        int result = start;
        start += step;
        return result;
    }

//    public int nextValue() {
//        if (firstAttempt) {
//            firstAttempt = false;
//        } else {
//            start += step;
//        }
//        return start;
//    }
}
