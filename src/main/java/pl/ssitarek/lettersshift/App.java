package pl.ssitarek.lettersshift;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {

        try {
            LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl();
            lettersInTheName.loadFromFile("inputFile.txt");
            System.out.println(lettersInTheName.calculateNumberOfShift());
            lettersInTheName.saveToFile("outputFile.txt");
        }catch (FileNotFoundException ex){
            System.out.println("file not found");
        }
    }
}
