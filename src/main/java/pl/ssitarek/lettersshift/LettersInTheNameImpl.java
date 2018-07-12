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

        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();
        System.out.println(name2);
        int countShift = 0;
        for (int i = 0; i < name1.length(); i++) {
            countShift += moveSingleLetterInSecondName(i);
        }
        return countShift;
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
        System.out.println(name2 + " " + beforeNextApperance.length());
        return beforeNextApperance.length();
    }
}
