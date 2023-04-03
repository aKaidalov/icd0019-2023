package fp;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Persons {

    private List<Person> persons = List.of(
            new Person(1, "Alice", 22),
            new Person(2, "Bob", 20),
            new Person(3, "Carol", 21));

    @Test
    public void findsPersonById() {
        var person = persons.stream()
                .filter(x -> x.getId().equals(2))
                .collect(Collectors.toList());

        System.out.println(person);
    }

    @Test
    public void removePersonById() {
        var person = persons.stream()
                .filter(x -> !x.getId().equals(2))
                .collect(Collectors.toList());

        System.out.println(person);
    }

    @Test
    public void findsPersonNames() {
        String names = persons.stream()
                .map(p -> p.getName())
                .collect(Collectors.joining(", "));

        System.out.println(names);
    }

    @Test
    public void reverseSortedByAge() {
        List<Person> storedByAged = persons.stream()
                .sorted(Collections.reverseOrder(
                        Comparator.comparing(each -> each.getAge())))
                .toList();

        List<Person> result = persons.stream()
                .sorted((a, b) -> b.getAge().compareTo(a.getAge()))
                .toList();

        System.out.println(storedByAged);
        System.out.println(result);
    }

}
