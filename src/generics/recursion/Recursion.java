package generics.recursion;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion {

    public List<String> getParts(Path path) {
        List<String> list = new ArrayList<>();

        Path runner = path;
        while (runner != null) {
            System.out.println("FN:" + runner.getFileName().toString());
            // getFileName() is a method that returns the name of the file or directory denoted by the path.
            // In the given code snippet, runner.getFileName().toString() retrieves the name of the file or directory
            // pointed by the runner variable and converts it to a string, which is then added to the list of parts.
            list.add(runner.getFileName().toString());
            // getParent() is a method that returns the parent path of the current path.
            // In the given code snippet, runner.getParent() retrieves the parent directory of the runner variable
            // and assigns it to the runner variable. This continues until the runner variable becomes null, meaning
            // that the root directory has been reached. The name of each directory or file encountered along the way
            // is added to the list of parts.
            System.out.println("Pa:" + runner.getParent());
            runner = runner.getParent();
        }

        Collections.reverse(list);
        return list;
    }

    public List<String> getParts2(Path path) {

        if (path.getParent() != null) {
            getParts2(path.getParent());
        }
        System.out.println(path.getFileName());

        return null;
    }

    public List<String> getParts3(Path path, List<String> parts) {

        if (path != null) {
            System.out.println(path.getFileName().toString());
            getParts3(path.getParent(), parts);
            parts.add(path.getFileName().toString());
        }

        return null;
    }

    public List<String> getParts4(Path path) {

        if (path == null) {
            return new  ArrayList<>();
        }

        List<String> result = getParts4(path.getParent());

        result.add(path.getFileName().toString());

        return result;
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        Path path = Paths.get("a/b/c/d.txt");
        System.out.println(r.getParts2(path));

        List<String> parts = new ArrayList<>();
        System.out.println(r.getParts3(path, parts));
    }
}
