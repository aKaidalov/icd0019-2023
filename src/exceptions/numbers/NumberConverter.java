package exceptions.numbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class NumberConverter {

    private String language;
    private Properties properties;


    // init
    public NumberConverter(String lang) {
        this.language = lang;
        this.properties = readProperties();
    }

    public String numberInWords(Integer number) {
        String result = "";

        if (checkKeyFromInt(number)) {
            return getValueFromIntKey(number);
        } else {
            if (10 < number && number < 20) {
                String ones = getValueFromIntKey(number % 10);
                return ones + getValueFromStrKey("teen");
            } else if (number < 100 && checkKeyFromStr("tens-after-delimiter")){

            } else if (number == 100){
                return getValueFromStrKey("hundred");
            }else if (100 < number && number < 1000){

            }

        }
        return null;
    }

    // Properties ---------------------------------------------------------

    public Properties readProperties() {
        String filePath = "src/exceptions/numbers/numbers_" + language + ".properties";

        Properties properties = new Properties();
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);

            InputStreamReader reader = new InputStreamReader(
                    is, StandardCharsets.UTF_8);

            properties.load(reader);
        } catch (IOException e) {
            // handle exceptions
            System.out.println("Error reading file:" + e.getMessage());
            e.printStackTrace();
        } finally {
            close(is);
        }

//        System.out.println(properties.containsKey(String.valueOf(14)));
//        System.out.println(properties.getProperty(String.valueOf(14)));
        return properties;
    }

    private static void close(FileInputStream is) {
        if (is == null) {
            return;
        }

        try {
            is.close();
        } catch (IOException ignore) {}
    }

    // getters ---------------------------------------------------------

    public boolean checkKeyFromInt(Integer intKey) {
        return properties.containsKey(String.valueOf(intKey));
    }
    public boolean checkKeyFromStr(String strKey) {
        return properties.containsKey(String.valueOf(strKey));
    }

    public String getValueFromIntKey(Integer intKey) {
        return properties.getProperty(String.valueOf(intKey));
    }
    public String getValueFromStrKey(String strKey) {
        return properties.getProperty(String.valueOf(strKey));
    }
}
