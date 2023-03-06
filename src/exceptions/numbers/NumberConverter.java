package exceptions.numbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class NumberConverter {

    private String language;
    private Properties properties;
    private String result;


    // init
    public NumberConverter(String lang) {
        this.language = lang;
        this.properties = readProperties();
        this.result = "";
    }

    public String numberInWords(Integer number) {

        if (checkKeyFromInt(number)) {
            return getValueFromIntKey(number);
        } else {
            if (100 <= number && number <= 999) {
               number = getHundredsAndReturnNewNumber(number);
            }
            if (20 <= number && number <= 99) {
                number = getTensAndReturnNewNumber(number);
            }
            if (11 <= number && number <= 19) {
                number = getTeenAndReturnNewNumber(number);
            }
            if (0 <= number && number <= 10) {
                number = getNumberFromProperties(number);
            }
            if (number != 0){
                throw new RuntimeException("Something was calculated wrong...");
            }
        }
        String numberInString = result;
        return numberInString;
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

    public Integer getHundredsAndReturnNewNumber(Integer number){
        int hundreds = number / 100;
        String hundredsInStr = getValueFromIntKey(hundreds) + getValueFromStrKey("hundreds-before-delimiter") + getValueFromStrKey("hundred") + getValueFromStrKey("hundreds-after-delimiter");
        result += hundredsInStr;
        number -= hundreds * 100;

        return number;
    }
    public Integer getTensAndReturnNewNumber(Integer number){
        int tens = number / 10;
        int fullTens = tens * 10;

        if (checkKeyFromInt(fullTens)) {
            result += getValueFromIntKey(fullTens);
        } else {
            String tensInStr = getValueFromIntKey(tens) + getValueFromStrKey("tens-suffix");
            result += tensInStr;
        }
        number -= fullTens;
        result += getValueFromStrKey("tens-after-delimiter");

        return number;
    }
    public Integer getTeenAndReturnNewNumber(Integer number){
        if (checkKeyFromInt(number)) {
            number = getNumberFromProperties(number);
        } else {
            int ones = number % 10;
            String teenInStr = getValueFromIntKey(ones) + getValueFromStrKey("teen");
            result += teenInStr;
            number -= ones - 10;
        }

        return number;
    }

    public Integer getNumberFromProperties(Integer number){
        result += getValueFromIntKey(number);
        number -= number;

        return number;
    }
}
