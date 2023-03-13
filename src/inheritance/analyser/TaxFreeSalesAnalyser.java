package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractSalesAnalyser {

    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            totalSales += record.getItemsSold() * record.getProductPrice();
        }
        return totalSales;
    }

    @Override
    protected Double getTotalSalesByProductId(String id) {
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            String currentProductId = record.getProductId();
            if (currentProductId.equals(id)) {
                totalSales += record.getItemsSold() * record.getProductPrice();
            }
        }
        return totalSales;
    }
}
