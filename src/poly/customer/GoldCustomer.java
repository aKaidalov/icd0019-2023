package poly.customer;

public final class GoldCustomer extends AbstractCustomer {

    public GoldCustomer(String id, String name, int bonusPoints) {
        super(id, name, bonusPoints);
    }

    @Override
    public void collectBonusPointsFrom(Order order) {

        Double totalPrice = order.getTotal();

        if (totalPrice >= MINIMUM_TOTAL_FOR_BONUS_POINTS) {
            Double calculatedBonusPoints = totalPrice * 1.5;
            bonusPoints = calculatedBonusPoints.intValue();
        }
    }

    @Override
    public String asString() {
        return "GOLD;" + id + ";" + name + ";" + bonusPoints + ";";
    }

}