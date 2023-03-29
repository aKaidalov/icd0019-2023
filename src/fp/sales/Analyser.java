package fp.sales;

import java.time.LocalDate;

public class Analyser {

    private Repository repository;

    public Analyser(Repository repository) {
        this.repository = repository;
    }

    public Double getTotalSales() {
        throw new RuntimeException("not implemented yet");
    }

    public Double getSalesByCategory(String category) {
        throw new RuntimeException("not implemented yet");
    }

    public Double getSalesBetween(LocalDate start, LocalDate end) {
        throw new RuntimeException("not implemented yet");
    }

    public String mostExpensiveItems() {
        throw new RuntimeException("not implemented yet");
    }

    public String statesWithBiggestSales() {
        throw new RuntimeException("not implemented yet");
    }
}
