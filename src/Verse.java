public class Verse {
    private int verseNumber;
    private String text;

    public Verse(int number, String text) {
        this.verseNumber = number;
        this.text = text;
    }
    public int getNumber() {
        return verseNumber;
    }
    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return verseNumber + ": " + text;
    }
}
