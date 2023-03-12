package inheritance.analyser;

import java.util.List;

public sealed abstract class AbstractSalesAnalyser
        permits FlatTaxSalesAnalyser, DifferentiatedTaxSalesAnalyser, TaxFreeSalesAnalyser {

    private static final Double TAX_RATE = 1.2;
    private static final Double REDUCED_TAX_RATE = 1.1;
//    private static final Double TAX_FREE_RATE = 1.0;

    public List<SalesRecord> records;
    public AbstractSalesAnalyser(List<SalesRecord> records) {
        this.records = records;
    }

    protected Double getTotalSales() {
//        double rtx = getRedusedTaxRate();
//        double tx = getTaxRate();
//        double totalSales = 0.0;
//        for (SalesRecord record : records) {
//            int sold = record.getItemsSold();
//            int price = record.getProductPrice();
//            if (record.hasReducedRate()){
//                totalSales += (sold * price / rtx);
//            }else {
//                totalSales += (sold * price / tx);
//            }
//        }
//        return totalSales;
        throw new RuntimeException("not implemented yet");
    }

    protected Double getTotalSalesByProductId(String id) {
//        Double totalSales = 0.0;
//        for (SalesRecord record : records) {
//            String currentProductId = record.getProductId();
//            if (currentProductId.equals(id))
//                totalSales += (record.getItemsSold() * record.getProductPrice() / TAX_RATE);
//        }
//        return totalSales;
        throw new RuntimeException("not implemented yet");
    }

    protected String getIdOfMostPopularItem() {
        String result = "";
        int maxItemsSold = 0;
        int len = records.size();
        for (int i = 0; i < len - 1; i++) {
            String id1 = records.get(i).getProductId();
            int totalItemsSold = records.get(i).getItemsSold();
            for (int j = i + 1; j < len; j++) {
                String id2 = records.get(j).getProductId();
                if (id1.equals(id2)) {
                    totalItemsSold += records.get(j).getItemsSold();
                }
            }
            if (totalItemsSold > maxItemsSold) {
                maxItemsSold = totalItemsSold;
                result = id1;
            }
        }
        return result;
    }

    protected String getIdOfItemWithLargestTotalSales() {
        String result = "";
        Double maxTotalItemsSales = 0.0;
        int len = records.size();
        for (int i = 0; i < len - 1; i++) {
            String id = records.get(i).getProductId();
            Double totalItemsSales = getTotalSalesByProductId(id);
            if (totalItemsSales > maxTotalItemsSales) {
                maxTotalItemsSales = totalItemsSales;
                result = id;
            }
        }
        return result;
    }

    protected Double getTaxRate() {
        return TAX_RATE;
    }
    protected Double getRedusedTaxRate() {
        return REDUCED_TAX_RATE;
    }
//    protected Double getTaxFreeRate() {
//        return TAX_FREE_RATE;
//    }
}
