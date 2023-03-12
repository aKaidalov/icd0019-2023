package inheritance.calc;

public class TaxFreePayCalculator extends PayCalculator {
    @Override
    public boolean taxNeeded() {
        return false;
    }

//    @Override
//    protected Double getTaxRate() {
//        return 0.0;
//    }
}
