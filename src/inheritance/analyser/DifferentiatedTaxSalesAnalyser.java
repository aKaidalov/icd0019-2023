package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractSalesAnalyser {

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    public Double getTotalSales() {
        double rtx = getRedusedTaxRate();
        double tx = getTaxRate();
        double totalSales = 0.0;
        for (SalesRecord record : records) {
            int sold = record.getItemsSold();
            int price = record.getProductPrice();
            if (record.hasReducedRate()){
                totalSales += (sold * price / rtx);
            }else {
                totalSales += (sold * price / tx);
            }
        }
        return totalSales;
    }

    public Double getTotalSalesByProductId(String id) {
        double rtx = getRedusedTaxRate();
        double tx = getTaxRate();
        Double totalSales = 0.0;
        for (SalesRecord record : records) {
            String currentProductId = record.getProductId();
            if (currentProductId.equals(id))
                totalSales += (record.getItemsSold() * record.getProductPrice() / tx);
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
