package fp.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {

    private static final String FILE_PATH = "src/fp/sales/sales-data.csv";

    private DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");

    private Entry createEntry (String line) {
        Entry e = new Entry();
        String[] splitLine = line.split("\t");

        e.setDate(LocalDate.parse(splitLine[0], formatter));
        e.setState(splitLine[1]);
        e.setProductId(splitLine[2]);
        e.setCategory(splitLine[3]);
        e.setAmount(Double.parseDouble(String.join(".", splitLine[5].split(","))));

        return e;
    }

    public List<Entry> getEntries() {

        // reads lines form the file and creates entry objects for each line.

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            return lines.stream()
                    .skip(1)
                    .map(this::createEntry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Repository().getEntries());

        var check1 = new Repository().getEntries()
                .stream().
                filter(x -> Objects.equals(x.getProductId(), "OFF-BI-10003527")
                        || Objects.equals(x.getProductId(), "TEC-MA-10000822")
                        || Objects.equals(x.getProductId(), "TEC-MA-10004125"))
                .sorted(Comparator.comparing(Entry::getAmount))
                .skip(1)
                .peek(System.out::println)
                .map(Entry::getProductId)
                .sorted() // need to sort by ID. (previously were sorted by amount/sum)
                .peek(System.out::println)
                .toList();

        System.out.println(check1 + "\n");


        var check2 = new Repository().getEntries()
                .stream()
                .collect(
                        Collectors.toMap(
                                Entry::getState, // each -> each.getState
                                Entry::getAmount,
                                Double::sum)) // (a, b) -> a + b))
                .entrySet();
        var check3 = check2.stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .limit(3)  // there I get Ca,T,NY where NY is the smallest one. Klamo wanted this order.
                .sorted(Map.Entry.comparingByValue())
                .skip(check2.size() - 3) // why this doesn't work? get nothing instead
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // need this line to work
                .map(Map.Entry::getKey)                 // because I get NY,T,Ca where Ca is the biggest one
                .peek(System.out::println)
                .collect(Collectors.joining(", "));

        System.out.println(check3);

    }
}
