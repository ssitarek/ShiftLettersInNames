package pl.ssitarek.lettersshift;

import java.io.FileNotFoundException;

public class App {

    public static final String INPUT_FILE = "inputFile.txt";
    public static final String OUTPUT_FILE = "outputFile.txt";

    public static void main(String[] args) throws FileNotFoundException {

        try {
            LettersInTheName lettersInTheName = new LettersInTheNameImpl("", "");
            lettersInTheName.loadFromFile(INPUT_FILE);

            lettersInTheName.calculateNumberOfShift();

            lettersInTheName.saveToFile(OUTPUT_FILE);
            System.out.println("Result: " + lettersInTheName.getNumberOfShifts() + " has been saved in: " + OUTPUT_FILE);

        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}
