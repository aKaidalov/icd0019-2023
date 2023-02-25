package oo.hide;

public class Timer {

    private long start = System.currentTimeMillis();

    public String getPassedTime() {
        double difference = System.currentTimeMillis() - start;
        System.out.println(difference / 1000);
        return null;
    }
}
