package exceptions.numbers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberConverterTests {

    @Test(expected = MissingLanguageFileException.class)
    public void selectingMissingLanguageThrows() {
        new NumberConverter("ru");
    }

    @Test(expected = BrokenLanguageFileException.class)
    public void selectingBrokenLanguageFileThrows() {
        new NumberConverter("fr");
    }

    @Test(expected = MissingTranslationException.class)
    public void missingEssentialTranslationThrows() {
        new NumberConverter("es").numberInWords(1);
    }

    @Test
    public void canConvertNumbersToEnglish() {
        NumberConverter converter = new NumberConverter("en");

        assertThat(converter.numberInWords(0), is("zero"));

        assertThat(converter.numberInWords(1), is("one"));

        assertThat(converter.numberInWords(13), is("thirteen"));

        assertThat(converter.numberInWords(123), is("one hundred twenty-three"));

        assertThat(converter.numberInWords(12), is("twelve"));
        assertThat(converter.numberInWords(56), is("fifty-six"));
        assertThat(converter.numberInWords(77), is("seventy-seven"));
        assertThat(converter.numberInWords(100), is("one hundred"));
        assertThat(converter.numberInWords(118), is("one hundred eighteen"));
        assertThat(converter.numberInWords(126), is("one hundred twenty-six"));

        assertThat(converter.numberInWords(60), is("sixty"));
    }

    @Test
    public void canConvertNumbersToEstonian() {
        NumberConverter converter = new NumberConverter("et");

        assertThat(converter.numberInWords(0), is("null"));

        assertThat(converter.numberInWords(1), is("üks"));

        assertThat(converter.numberInWords(13), is("kolmteist"));

        assertThat(converter.numberInWords(123), is("ükssada kakskümmend kolm"));

        assertThat(converter.numberInWords(12), is("kaksteist"));
        assertThat(converter.numberInWords(59), is("viiskümmend üheksa"));
        assertThat(converter.numberInWords(77), is("seitsekümmend seitse"));
        assertThat(converter.numberInWords(100), is("ükssada"));
        assertThat(converter.numberInWords(101), is("ükssada üks"));
        assertThat(converter.numberInWords(118), is("ükssada kaheksateist"));
        assertThat(converter.numberInWords(126), is("ükssada kakskümmend kuus"));
    }

    @Test
    public void canConvertNumbersUpTo130ToEnglish() {
        assertCanConvertNumbersUpTo(130, "en");
    }

    @Test
    public void canConvertNumbersUpTo130ToEstonian() {
        assertCanConvertNumbersUpTo(130, "et");
    }

    @Test
    public void canConvertNumbersUpTo130ToCustomLanguage() {
        assertCanConvertNumbersUpTo(130, "cu");
    }

    private void assertCanConvertNumbersUpTo(int upperBound, String lang) {
        for (int i = 0; i <= upperBound; i++) {
            String numberInWords = new NumberConverter(lang).numberInWords(i);

            assertThat(numberInWords, is(getExpected(lang, i)));
        }
    }

    private String getExpected(String lang, int index) {
        List<String> strings = map.get(lang);

        if (strings == null) {
            throw new RuntimeException("unexpected language: " + lang);
        }

        if (index < 0 || index >= strings.size()) {
            throw new RuntimeException("no test data for number: " + index);
        }

        return strings.get(index);
    }

    private Map<String, List<String>> map = new HashMap<>();

    @Before
    public void setUp() throws IOException {
        String template = "src/exceptions/numbers/expected-%s.txt";

        map.put("en", Files.readAllLines(Paths.get(String.format(template, "en"))));
        map.put("et", Files.readAllLines(Paths.get(String.format(template, "et"))));
        map.put("cu", Files.readAllLines(Paths.get(String.format(template, "cu"))));
    }
}
