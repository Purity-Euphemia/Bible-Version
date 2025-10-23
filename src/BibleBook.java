import java.util.ArrayList;
import java.util.List;

public class BibleBook {
    private String BookName;
    private int number;
    private String shortName;
    private List<Chapter> chapters = new ArrayList<>();

    public BibleBook(int number, String BookName, String shortName){
        this.number = number;
        this.BookName = BookName;
        this.shortName = shortName;
    }
    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
    public int getNumber() {
        return number;
    }
    public String getBookName() {
        return BookName;
    }
    public String getShortName() {
        return shortName;
    }
    public List<Chapter> getChapters() {
        return chapters;
    }
    @Override
    public String toString() {
        return "Book: " + BookName + " (" + chapters.size() + " chapters)";
    }
}
