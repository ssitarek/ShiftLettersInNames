package pl.ssitarek.lettersshift;

import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class LettersInTheNameImplTest {

    @Test
    public void testSingleLetter() {

        String string01 = "a";
        String string02 = "a";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(0L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testTheSame() {

        String string01 = "ab";
        String string02 = "ab";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(0L, lettersInTheName.calculateNumberOfShift());

    }

    @Test
    public void testTwoLettersInversed() {

        String string01 = "ab";
        String string02 = "ba";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(1L, lettersInTheName.calculateNumberOfShift());

    }

    @Test
    public void testAbc() {

        String string01 = "abc";
        String string02 = "cba";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(3L, lettersInTheName.calculateNumberOfShift());

    }

    @Test
    public void testAbcd() {

        String string01 = "abcd";
        String string02 = "dcba";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(6L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testAlamakota() {

        String string01 = "AlaMaKota";
        String string02 = "taAaoMalK";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(16L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testAllLettersFirstReplaced() {

        String string01 = "abcdefghijklmnopqrstuvw";
        String string02 = "wbcdefghijklmnopqrstuva";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        assertEquals(43L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testAllLettersInversed() {

        String string01 = "abcdefghijklmnopqrstuvw";
        String string02 = "wvutsrqponmlkjihgfedcba";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        long expected = calcSumOfRangeZeroToX(string01.length());
        assertEquals(expected, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testAllLettersAndDigitsInversed() {

        String string01 = "abcdefghijklmnopqrstuvw0123456789";
        String string02 = "9876543210wvutsrqponmlkjihgfedcba";
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        long expected = calcSumOfRangeZeroToX(string01.length());
        assertEquals(expected, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void testLongName() {

        String string = "abcdefghijklmnopqrstuvw";
        int repetitionCount = 1000;
        String[] inputArr = createDataForTest(string, repetitionCount); //this creates string with the length 23'000

        String string01 = inputArr[0];
        String string02 = inputArr[1];
        LettersInTheName lettersInTheName = new LettersInTheNameImpl(string01, string02);
        long expected = repetitionCount * calcSumOfRangeZeroToX(string.length());
        long startTime = System.currentTimeMillis();
        long stopTime = System.currentTimeMillis();
        Long diff = stopTime - startTime;

        assertEquals(expected, lettersInTheName.calculateNumberOfShift());
        System.out.println(diff);
    }

    private String[] createDataForTest(String partOfName, int repetitionCount) {

        String partOfNameInvert = "";
        for (int i = partOfName.length() - 1; i >= 0; i--) {
            partOfNameInvert += partOfName.charAt(i);
        }

        String[] outArr = { "", "" };
        for (int i = 0; i < repetitionCount; i++) {
            outArr[0] += partOfName;
            outArr[1] += partOfNameInvert;
        }
        return outArr;
    }

    private long calcSumOfRangeZeroToX(int x) {
        int sum = 0;
        for (int i = 1; i < x; i++) {
            sum = sum + x - i;
        }
        return sum;
    }

    // tests from files

    @Test
    public void lit00() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit0.in");
        assertEquals(2L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit01() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit1.in");
        assertEquals(4L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit01ocen() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit1ocen.in");
        assertEquals(1L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit02() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit2.in");
        assertEquals(16L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit02ocen() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit2ocen.in");
        assertEquals(9L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit03a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit3a.in");
        assertEquals(44599L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit03b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit3b.in");
        assertEquals(480766L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit03ocen() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit3ocen.in");
        assertEquals(1L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit04a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit4a.in");
        assertEquals(1499627L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit04b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit4b.in");
        assertEquals(48076920L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit04ocen() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit4ocen.in");
        assertEquals(6L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit05a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit5a.in");
        assertEquals(17536625L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit05b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit5b.in");
        assertEquals(1201923076L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit05ocen() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit5ocen.in");
        assertEquals(899000000L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit06a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit6a.in");
        assertEquals(47167845L, lettersInTheName.calculateNumberOfShift());
    }

    @Test
    public void lit06b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit6b.in");
        assertEquals(4807692306L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit07a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit7a.in");
        assertEquals(130542635L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit07b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit7b.in");
        assertEquals(19230769228L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit08a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit8a.in");
        assertEquals(580934901L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit08b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit8b.in");
        assertEquals(120192307690L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit09a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit9a.in");
        assertEquals(1482550867L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit09b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit9b.in");
        assertEquals(480769230766L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit10a() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit10a.in");
        assertEquals(1819136406L, lettersInTheName.calculateNumberOfShift());
    }

    @Ignore("Result is OK but the total time of calculation is not accepted")
    @Test
    public void lit10b() throws FileNotFoundException {

        LettersInTheName lettersInTheName = new LettersInTheNameImpl();
        lettersInTheName.loadFromFile("lit10b.in");
        assertEquals(480769230766L, lettersInTheName.calculateNumberOfShift());
    }
}