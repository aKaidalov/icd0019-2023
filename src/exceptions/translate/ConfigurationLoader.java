package exceptions.translate;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationLoader {

    public String loadConfiguration(String configFilePath) throws Exception {
        return String.join("\n", Files.readAllLines(Paths.get(configFilePath)));
    }
}
