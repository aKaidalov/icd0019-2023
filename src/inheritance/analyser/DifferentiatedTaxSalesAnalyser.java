package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractSalesAnalyser {

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double getTotalSales() {
        double rtx = getRedusedTaxRate();
        double tx = getTaxRate();
        double totalSales = 0.0;
        for (SalesRecord record : records) {
            int sold = record.getItemsSold();
            int price = record.getProductPrice();
            if (record.hasReducedRate()) {
                totalSales += sold * price / rtx;
            } else {
                totalSales += sold * price / tx;
            }
        }

        return totalSales;
    }
    @Override
    protected Double getTotalSalesByProductId(String id) {
        double rtx = getRedusedTaxRate();
        double tx = getTaxRate();
        double totalSales = 0.0;
        for (SalesRecord record : records) {
            String currentProductId = record.getProductId();
            if (currentProductId.equals(id)) {
                int sold = record.getItemsSold();
                int price = record.getProductPrice();
                if (record.hasReducedRate()) {
                    totalSales += sold * price / rtx;
                } else {
                    totalSales += sold * price / tx;
                }
            }
        }

        return totalSales;
    }
}
