package inheritance.sender;

import java.time.LocalTime;

public class SmsLetterSender extends AbstractLetterSender {

    public SmsLetterSender(LocalTime currentTime) {
        super(currentTime);
    }

    @Override
    protected String getLetterType() {
        return "sms";
    }


}
