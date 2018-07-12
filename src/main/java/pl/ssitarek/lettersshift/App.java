package pl.ssitarek.lettersshift;

public class App 
{
    public static void main( String[] args )
    {
        LettersInTheNameImpl lettersInTheName = new LettersInTheNameImpl("abcd", "dcba");
        System.out.println(lettersInTheName.calculateNumberOfShift());
    }
}
