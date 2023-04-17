package poly.undo;

public class Calculator {

    private double value;

    public void input(double value) {
        this.value = value;
    }

    public void add(double addend) {
        value += addend;
    }

    public void multiply(double multiplier) {
        value *= multiplier;
    }

    public double getResult() {
        return value;
    }

    public void undo() {
        throw new RuntimeException("not implemented yet");
    }
}
