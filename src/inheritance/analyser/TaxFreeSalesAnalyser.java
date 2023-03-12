package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractSalesAnalyser {

    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    public Double getTotalSales() {
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            totalSales += (record.getItemsSold() * record.getProductPrice());
        }
        return totalSales;
    }

    public Double getTotalSalesByProductId(String id) {
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            String currentProductId = record.getProductId();
            if (currentProductId.equals(id))
                totalSales += (record.getItemsSold() * record.getProductPrice());
        }
        return totalSales;
    }

    public String getIdOfMostPopularItem() {
        throw new RuntimeException("not implemented yet");
    }

    public String getIdOfItemWithLargestTotalSales() {
        throw new RuntimeException("not implemented yet");
    }

}
