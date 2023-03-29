package fp;

import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Reduce {

    @Test
    public void reducesListToSingleResult() {

        var numbers = List.of(1, 2, 3, 4);

        assertThat(reduce(numbers, (a, b) -> a + b), is(10));

        assertThat(reduce(numbers, (a, b) -> a * b), is(24));

//        assertThat(reduce(List.of("1", "2", "3"),
//                (a, b) -> a + b), is("123"));

    }

    private Integer reduce(List<Integer> list,
                        BiFunction<Integer, Integer, Integer> func) {

        throw new RuntimeException("not implemented yet");
    }
}
