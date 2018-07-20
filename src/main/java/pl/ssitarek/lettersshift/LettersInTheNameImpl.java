package pl.ssitarek.lettersshift;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LettersInTheNameImpl implements LettersInTheName {

    private String name1;
    private String name2;
    private int nameLength;
    private int numberOfShifts;

    public LettersInTheNameImpl(String name1, String name2) {
        this.name1 = name1.toUpperCase();
        this.name2 = name2.toUpperCase();
    }

    /**
     * method calculates the number of the neighbours letter shift to reach by the letter the first position
     *
     * @return number of shifts
     */

    @Override
    public int calculateNumberOfShift() {

        numberOfShifts = 0;
        for (int i = 0; i < name1.length(); i++) {
            numberOfShifts += moveSingleLetterInSecondName(i);
        }
        return numberOfShifts;
    }

    private int moveSingleLetterInSecondName(int i) {

        Character letterAnalyzed = name1.charAt(i);
        Character letterName2 = name2.charAt(i);
        if (letterName2.equals(letterAnalyzed)) {
            return 0;
        }

        int letterIndex = name2.indexOf(letterAnalyzed, i);
        String fixedPart = name2.substring(0, i);
        String beforeNextApperance = name2.substring(i, letterIndex);
        String afterNextApperance = name2.substring(letterIndex + 1, name2.length());
        name2 = fixedPart + letterAnalyzed + beforeNextApperance + afterNextApperance;
        return beforeNextApperance.length();
    }


    /**
     * method loads the *.txt file
     *
     * @param fileName name of the file
     * @throws FileNotFoundException in case of no file found
     */
    @Override
    public void loadFromFile(String fileName) throws FileNotFoundException {

        Scanner s = new Scanner(new File(fileName));
        String singleLine = s.nextLine();
        nameLength = Integer.parseInt(singleLine);
        name1 = s.nextLine().toUpperCase();
        name2 = s.nextLine().toUpperCase();
    }


    /**
     * method saves the result into *.txt file
     *
     * @param fileName file name
     * @throws FileNotFoundException in case of no file found
     */
    @Override
    public void saveToFile(String fileName) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println(numberOfShifts);
        printWriter.close();
    }

    public int getNumberOfShifts() {
        return numberOfShifts;
    }
}
