package pl.ssitarek.lettersshift;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LettersInTheNameImpl implements LettersInTheName {

    private String name1;
    private String name2;
    private long nameLength;
    private long numberOfShifts;

    public LettersInTheNameImpl(){

    }

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
    public long calculateNumberOfShift() {

        numberOfShifts = 0;
        while (name2.length()>0){
            numberOfShifts += moveSingleLetterInSecondName();
        }
        return numberOfShifts;
    }

    private long moveSingleLetterInSecondName() {

        if (name1.charAt(0)==name2.charAt(0)) {
            name1 = name1.substring(1);
            name2= name2.substring(1);
            return 0;
        }

        int letterIndex = name2.indexOf(name1.charAt(0));
        name1 = name1.substring(1);
        String beforeNextApperance = name2.substring(0, letterIndex);
        String afterNextApperance = name2.substring(letterIndex + 1);
        name2 = beforeNextApperance+afterNextApperance;
        return letterIndex;
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

    @Override
    public long getNumberOfShifts() {
        return numberOfShifts;
    }
}
