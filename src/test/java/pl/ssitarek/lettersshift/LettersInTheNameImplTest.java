package pl.ssitarek.lettersshift;

import org.junit.Test;

import static org.junit.Assert.*;

public class LettersInTheNameImplTest {

    @Test
    public void testSignleLetter() {

        String string01 = "a";
        String string02 = "a";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(0, result);
    }

    @Test
    public void testTheSame() {

        String string01 = "a";
        String string02 = "a";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(0, result);
    }

    @Test
    public void testTwoLettersInversed() {

        String string01 = "ab";
        String string02 = "ba";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(1, result);
    }

    @Test
    public void testAbc() {

        String string01 = "abc";
        String string02 = "cba";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(3, result);
    }

    @Test
    public void testAbcd() {

        String string01 = "abcd";
        String string02 = "dcba";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(6, result);
    }

    @Test
    public void testAlamakota() {

        String string01 = "AlaMaKota";
        String string02 = "taAaoMalK";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(16, result);
    }

    @Test
    public void testAllLettersFirstReplaced() {

        String string01 = "abcdefghijklmnopqrstuvw";
        String string02 = "wbcdefghijklmnopqrstuva";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(43, result);
    }

    @Test
    public void testAllLettersInversed() {

        String string01 = "abcdefghijklmnopqrstuvw";
        String string02 = "wvutsrqponmlkjihgfedcba";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(calcSumOfRangeZeroToX(string01.length()), result);
    }

    @Test
    public void testAllLettersAndDigitsInversed() {

        String string01 = "abcdefghijklmnopqrstuvw0123456789";
        String string02 = "9876543210wvutsrqponmlkjihgfedcba";
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl(string01, string02);
        int result = lettersInTheName.calculateNumberOfShift();
        assertEquals(calcSumOfRangeZeroToX(string01.length()), result);
    }

    private int calcSumOfRangeZeroToX(int x) {
        int sum = 0;
        for (int i = 1; i < x; i++) {
            sum = sum + x - i;
        }
        return sum;
    }
}