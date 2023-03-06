package exceptions.translate;

import org.junit.Test;

public class ConfigurationLoaderTests {

    @Test
    public void exceptionTranslationExample() throws Exception {
        String configPath = "./hello";

        new ConfigurationLoader().loadConfiguration(configPath);
    }

}
