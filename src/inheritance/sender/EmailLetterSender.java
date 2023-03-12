package inheritance.sender;

import java.time.LocalTime;

public class EmailLetterSender extends AbstractLetterSender {
    public EmailLetterSender(LocalTime currentTime) {
        super(currentTime);
    }

    @Override
    protected String getLetterType() {
        return "email";
    }
}