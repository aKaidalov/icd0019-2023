package fp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private List<Integer> numbers = Arrays.asList(1, 3, 4, 51, 24, 5);

    @Test
    public void findsOddNumbers() {

        List<Integer> oddNumbers = numbers.stream()
                // add filter here
                .toList();

        System.out.println(oddNumbers);
    }

    @Test
    public void findsOddNumbersOver10() {

    }

    @Test
    public void findsSquaredOddNumbers() {

    }

    @Test
    public void findsSumOfOddNumbers() {

    }

}
