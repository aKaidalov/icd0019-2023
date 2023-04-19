package poly.customer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private static final String FILE_PATH = "src/poly/customer/data.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    private List<AbstractCustomer> customers = createCustomersFromFile();

    private List<AbstractCustomer> createCustomersFromFile() {

        try {
            List<String> fileLines = Files.readAllLines(Paths.get(FILE_PATH));
            return fileLines.stream()
                    .map(this::createCustomer)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AbstractCustomer createCustomer (String fileLine) {
        String[] splitLine = fileLine.split(";");

        String id = splitLine[1];
        String name = splitLine[2];
        int bonusPoints = Integer.parseInt(splitLine[3]);

        if (splitLine[0].equals("REGULAR")){
            LocalDate lastOrderDate = LocalDate.parse(splitLine[4], formatter);
            return new RegularCustomer(
                    id,
                    name,
                    bonusPoints,
                    lastOrderDate
            );
        } else {
            return new GoldCustomer(
                    id,
                    name,
                    bonusPoints
            );
        }
    }

    private void writeToFile () {

        try {
            FileWriter output = new FileWriter(FILE_PATH);

            for (AbstractCustomer customer : customers) {
                output.write(customer.asString() + "\n");
            }

            output.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<AbstractCustomer> getCustomerById(String id) {
        return customers.stream()
                .filter(x -> id.equals(x.getId()))
                .findAny();
    }

    public void remove(String id) {
        customers = customers.stream()
                .filter(x -> !id.equals(x.getId()))
                .toList();
    }

    public void save(AbstractCustomer customer) {
        customers.add(customer);
    }

    public int getCustomerCount() {
        return customers.size();
    }
}
