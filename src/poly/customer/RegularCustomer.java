package poly.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class RegularCustomer extends AbstractCustomer {

    private LocalDate localDate;
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints);

        setLocalDate(lastOrderDate);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public String asString() {
        return "REGULAR;" + id + ";" + name + ";" + bonusPoints + ";" + localDate.format(formatter);
    }

}