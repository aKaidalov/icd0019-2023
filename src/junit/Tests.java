package junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@SuppressWarnings("PMD")
public class Tests {

    @Test
    public void equalityExamples() {
        assertTrue(1 == 1);
        assertFalse(1 == 2);

        Integer x1 = 1;
        Integer y1 = 1;
        assertEquals(x1, y1);

        Integer x2 = 128;
        Integer y2 = 128;
        assertFalse(x2 == y2); // assertNotSame() also works. False because x and y are above 127
        assertTrue(x2.equals(y2));
        assertEquals(x2, y2);   // less preferred method to control
        assertThat(x2, is(y2)); // better to use. Construction gives more understanding

        assertTrue("abc" == "abc");
        assertTrue("abc" == "a" + "bc");
        Character a = 'a';
        assertFalse("abc" == a + "bc"); // because char and str are different types
        String ab = "ab";
        assertFalse("abbc" == ab + "bc");   // False because ab is different object. Need to use .equals() or
        assertTrue("abbc".equals(ab + "bc"));
        assertEquals("abbc", ab + "bc");    // or assertEquals()
    }

    @Test
    public void assertThatAndAssertEqualsExample() {
        assertEquals(1 + 2, 3);
        assertThat(1 + 2, not(4));  // assertNotEquals()
        assertThat(new int[] {1, 2, 3}, is(equalTo(new int[] {1, 2, 3})));
        assertThat(new int[] {1, 2, 3}, is(not(new int[] {1, 2})));
    }

    @Test
    public void findsSpecialNumbers() {
        assertTrue(Code.isSpecial(0));

        // other test cases for isSpecial() method
        assertTrue(Code.isSpecial(1));
        assertTrue(Code.isSpecial(2));
        assertTrue(Code.isSpecial(3));
        assertFalse(Code.isSpecial(4));

        assertTrue(Code.isSpecial(11));
        assertFalse(Code.isSpecial(15));

        assertTrue(Code.isSpecial(36));
        assertFalse(Code.isSpecial(37));
    }

    @Test
    public void findsLongestStreak() {
        assertThat(Code.longestStreak(""), is(0));

        // other test cases for longestStreak() method
    }

    @Test
    public void findsModeFromCharactersInString() {

        assertThat(Code.mode(null), is(nullValue()));

        // other test cases for mode() method
        assertThat(Code.mode(""), is(nullValue()));
        assertThat(Code.mode("abcb"), is('b'));
        assertThat(Code.mode("cbbc"), is('c'));
    }

    @Test
    public void findsCharacterCount(){
        assertThat(Code.getCharacterCount("abbcaa", 'a'), is(3));
        assertThat(Code.getCharacterCount("abbcaa", 'b'), is(2));
        assertThat(Code.getCharacterCount("abbcaa", 'c'), not(2));
        assertThat(Code.getCharacterCount("AbbcaAaaa", 'A'), is(2));
    }

    @Test
    public void removesDuplicates() {
        assertThat(Code.removeDuplicates(arrayOf(1, 1)), is(arrayOf(1)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 1, 3, 2)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 3)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(100, 0, 3, 100, 0, 4, 562, 4)),
                is(arrayOf(100, 0, 3, 4, 562)));
    }

    @Test
    public void sumsIgnoringDuplicates() {
        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 1)), is(1));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 1, 3, 2)), is(6));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 3)), is(6));
    }

    private int[] arrayOf(int... numbers) {
        return numbers;
    }

}
