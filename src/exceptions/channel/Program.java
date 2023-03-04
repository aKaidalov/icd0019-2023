package exceptions.channel;

public class Program {

    ConstantProvider provider = new ConstantProvider();

    public static void main(String[] args) {

        Program program = new Program();

//        program.provider.makeItThrowMissingConstantException();
//        program.provider.makeItThrowCorruptConfigurationException();

        program.main(7); // 7 is arbitrary value
    }

    public void main(int input) {
        double result = calculate(input);

        String formatted = format(String.valueOf(result));

        present(formatted);

    }

    private double calculate(int input) {
        // an arbitrary calculation that uses some
        // data from external source

        return (input + 42) * provider.getMultiplier();
    }

    private String format(String data) {
        return "### Result is %s ###".formatted(data);
    }

    private String formatError(String message) {
        return "### Error: %s ###".formatted(message);
    }

    private void present(String data) {
        System.out.println(data);
    }
}
