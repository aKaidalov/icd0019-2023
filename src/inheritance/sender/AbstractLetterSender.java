package inheritance.sender;

import java.time.LocalTime;

public class AbstractLetterSender {
    private final LocalTime currentTime;
    private String letterType;

    public AbstractLetterSender(LocalTime currentTime) {
        this.currentTime = currentTime;
        this.letterType = "letter";
    }
    public void sendLetter() {
        String type = getLetterType();
        String greeting = "Good " + getTimeOfDayString();
        String contents = "Dead customer, ...";

        System.out.println("Sending " + type +  " ...");
        System.out.println("Title: " + greeting);
        System.out.println("Text: " + contents);
    }

    private String getTimeOfDayString() {

        int hour = currentTime.getHour();

        if (hour > 5 && hour <= 11) {
            return "morning";
        } else if (hour > 11 && hour <= 17) {
            return "afternoon";
        } else if (hour > 17 && hour <= 20) {
            return "evening";
        } else {
            return "night";
        }
    }

    protected String getLetterType() {
        return letterType;
    }
}
