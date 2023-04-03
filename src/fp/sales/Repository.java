package fp.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
                    .skip(0)
                    .map(this::createEntry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
