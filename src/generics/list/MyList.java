package generics.list;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {

    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    public void addAll(List<? extends T> elements) { // elements can represent a list of elements of type
        for (T element : elements) {                 // Integer, Double, Float, etc. but not other types.
            add(element);
        }
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
