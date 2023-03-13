package inheritance.analyser;

import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractSalesAnalyser {

    public FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            totalSales += record.getItemsSold() * record.getProductPrice() / 1.2;
        }
        return totalSales;
    }

    @Override
    protected Double getTotalSalesByProductId(String id) {
        double tx = getTaxRate();
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            String currentProductId = record.getProductId();
            if (currentProductId.equals(id)) {
                totalSales += record.getItemsSold() * record.getProductPrice() / tx;
            }
        }
        return totalSales;
    }
}
