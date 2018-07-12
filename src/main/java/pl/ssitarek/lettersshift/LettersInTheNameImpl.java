package pl.ssitarek.lettersshift;

public class LettersInTheNameImpl implements LettersInTheName {

    private String name1;
    private String name2;

    public LettersInTheNameImpl(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public int calculateNumberOfShift() {

        return -1;
    }
}
