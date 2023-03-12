package inheritance.constructor;

public class Raven extends Bird{
    public Raven() {
        super("black"); // Write this line because the Bird class doesn't have an empty constructor.
        System.out.println("This is a Raven");
    }
}
