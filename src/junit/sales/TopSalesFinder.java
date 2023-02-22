package junit.sales;

import java.util.Arrays;

public class TopSalesFinder {

    private SalesRecord[] productsArr = new SalesRecord[0];
    private SalesRecord[] uniqueProducts = new SalesRecord[0];

//    Kogda sozdaju konstruktor, to podrazumevajetsja, chto budu pri sozdanii peredavat' kakieto parametr6.
//    public TopSalesFinder(SalesRecord[] products) {
//        this.products = products;
//    }


    public void registerSale(SalesRecord record) {

        // store sales record for later analyses by findItemsSoldOver()
        SalesRecord[] modifiedArrCopy = new SalesRecord[productsArr.length + 1];
        for (int i = 0; i < modifiedArrCopy.length; i++) {
            if (i == modifiedArrCopy.length - 1) {
                modifiedArrCopy[i] = record;
            } else {
                modifiedArrCopy[i] = productsArr[i];
            }
        }
        productsArr = modifiedArrCopy;
    }

    public String[] findItemsSoldOver(int amount) {

        // find ids of records that sold over specified amount.
        getUniqueProducts();

        String[] result = new String[0];
        for (SalesRecord element : uniqueProducts) {
            if (element.getProductPrice() > amount) {
                result = addStringToArray(result, element.getProductId());
            }
        }
        productsArr = new SalesRecord[0];
        System.out.println("list start");
        System.out.println(Arrays.toString(uniqueProducts));
        System.out.println("list end");
        System.out.println(Arrays.toString(result));
        return result;
    }

    // ---------------------------------------------------------------------------
    public void getUniqueProducts() {
//        System.out.println(Arrays.toString(productsArr));
        for (int i = 0; i < productsArr.length; i++) {
            if (productsArr[i] != null){
                String id = productsArr[i].getProductId();
                int sold = productsArr[i].getItemsSold();
                int price = productsArr[i].getProductPrice() * sold;    // become an overall price (not for a unit)
                if (i < productsArr.length - 1){    // if loop reaches the last element, and it's not null
                    for (int j = i + 1; j < productsArr.length; j++) {      // than it's a unique element.
                        if (productsArr[j] != null) {
                            if (productsArr[i].getProductId().equals(productsArr[j].getProductId())) {
                                price += productsArr[j].getProductPrice() * productsArr[j].getItemsSold();
                                sold += productsArr[j].getItemsSold();
                                productsArr[j] = null;
                            }
                        }
                    }
                }
                SalesRecord sr = new SalesRecord(id,price,sold);
                addToRemovedDuplicateProducts(sr);
            }
        }
    }

    public void addToRemovedDuplicateProducts(SalesRecord record) {

        SalesRecord[] modifiedArrCopy = new SalesRecord[uniqueProducts.length + 1];
        for (int i = 0; i < modifiedArrCopy.length; i++) {
            if (i == modifiedArrCopy.length - 1) {
                modifiedArrCopy[i] = record;
            } else {
                modifiedArrCopy[i] = uniqueProducts[i];
            }
        }
        uniqueProducts = modifiedArrCopy;
    }

    public String[] addStringToArray(String[] arr, String s) {
        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == newArr.length - 1) {
                newArr[i] = s;
            } else {
                newArr[i] = arr[i];
            }
        }
        return newArr;
    }

    // ---------------------------------------------------------------------------

    public static void main(String[] args) {
        TopSalesFinder tsf = new TopSalesFinder();

        tsf.registerSale(new SalesRecord("p0", 49, 2));
        tsf.registerSale(new SalesRecord("p7", 16, 3));
        tsf.registerSale(new SalesRecord("p1", 12, 5));
        tsf.registerSale(new SalesRecord("p4", 28, 3));
        tsf.registerSale(new SalesRecord("p3", 13, 8));
        tsf.registerSale(new SalesRecord("p4", 35, 1));
        tsf.registerSale(new SalesRecord("p1", 21, 3));
        tsf.registerSale(new SalesRecord("p8", 25, 3));
        tsf.registerSale(new SalesRecord("p2", 11, 1));
        tsf.registerSale(new SalesRecord("p2", 43, 1));

        tsf.findItemsSoldOver(100);

        System.out.println(Arrays.toString(tsf.findItemsSoldOver(100)));
    }
}


