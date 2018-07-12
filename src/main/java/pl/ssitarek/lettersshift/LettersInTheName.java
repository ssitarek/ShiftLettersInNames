package pl.ssitarek.lettersshift;

import java.io.FileNotFoundException;

public interface LettersInTheName {

    int calculateNumberOfShift();

    void loadFromFile(String fileName) throws FileNotFoundException;

    void saveToFile(String fileName) throws FileNotFoundException;
}
