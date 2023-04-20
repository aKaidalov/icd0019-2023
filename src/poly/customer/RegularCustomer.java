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

    @Override
    public void collectBonusPointsFrom(Order order) {

        Double totalPrice = order.getTotal();

        if (lastOrderIsLessThanAMonthAgo(order) && totalPrice >= MINIMUM_TOTAL_FOR_BONUS_POINTS) {
            Double calculatedBonusPoints = totalPrice * 1.5;
            bonusPoints = calculatedBonusPoints.intValue();
        } else if (totalPrice >= MINIMUM_TOTAL_FOR_BONUS_POINTS) {
            bonusPoints = totalPrice.intValue();
        }
    }

    public boolean lastOrderIsLessThanAMonthAgo(Order order) {
        return this.getLocalDate().isAfter(order.getDate().minusMonths(1));
    }

    @Override
    public String asString() {
        return "REGULAR;" + id + ";" + name + ";" + bonusPoints + ";" + localDate.format(formatter);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

}