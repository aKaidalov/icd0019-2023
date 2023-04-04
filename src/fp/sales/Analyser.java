package fp.sales;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyser {

    private Repository repository;

    public Analyser(Repository repository) {
        this.repository = repository;
    }

    public Double getTotalSales() {
        return repository.getEntries().stream()
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesByCategory(String category) {
        return repository.getEntries().stream()
                .filter(x -> Objects.equals(x.getCategory(), category))
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesBetween(LocalDate start, LocalDate end) {
        return repository.getEntries().stream()
                .filter(x -> x.getDate().isEqual(start) || x.getDate().isAfter(start))
                .filter(x -> x.getDate().isEqual(end) || x.getDate().isBefore(end))
                .mapToDouble(Entry::getAmount)
                .sum();

    }

    public String mostExpensiveItems() {
        return repository.getEntries().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Entry::getAmount)))
                .limit(3)
                .map(Entry::getProductId)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public String statesWithBiggestSales() {
        return repository.getEntries().stream()
                .collect(
                        Collectors.toMap(
                                Entry::getState, // each -> each.getState
                                Entry::getAmount,
                                Double::sum)) // (a, b) -> a + b))
                .entrySet() // -> Set<Map.Entry>(Map.Entry<String state, Double amount>, Map.Entry<...>, ...)
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // -> order of keys: Ca, T, NY, ...
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        // there are some hints and previous attempts in the Repository class.
    }
}
