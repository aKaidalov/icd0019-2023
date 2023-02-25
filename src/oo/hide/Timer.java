package oo.hide;

public class Timer {

    public long start = System.currentTimeMillis();

    public String getPassedTime() {
        long difference = System.currentTimeMillis() - start;
        System.out.println(difference);
        return null;
    }
}
