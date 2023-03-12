package inheritance.calc;

public class PayCalculator {

    public static final Double OVERTIME_RATE = 1.5;
    public static final Integer HOUR_RATE = 15;
    public static final Double TAX_RATE = 0.2;

    public boolean taxNeeded(){
        return true;
    }

    private Double calculateWeeklyPay(Integer hoursWorked) {
        Integer straightTime = Math.min(40, hoursWorked);
        Integer overTime = Math.max(0, hoursWorked - straightTime);
        Integer straightPay = straightTime * HOUR_RATE;
        Double overtimePay = overTime * OVERTIME_RATE;
        return straightPay + overtimePay;
    }

    public Double getWeeklyPayAfterTaxes(Integer hoursWorked) {
        boolean needTax = taxNeeded();
        if (needTax) {
            return calculateWeeklyPay(hoursWorked) * (1 - TAX_RATE);
        } else {
            return calculateWeeklyPay(hoursWorked);
        }
    }


//    Second solution:

//    public Double getWeeklyPayAfterTaxes(Integer hoursWorked) {
//        return calculateWeeklyPay(hoursWorked) * (1 - getTaxRate());
//    }
//
//    protected Double getTaxRate() { // override this method in TaxFreePayCalculator
//        return TAX_RATE;
//    }
}
