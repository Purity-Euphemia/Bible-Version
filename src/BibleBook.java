import java.util.ArrayList;
import java.util.List;

public class BibleBook {
    private String name;
    private int number;
    private String shortName;
    private List<Chapter> chapters = new ArrayList<>();

    public BibleBook(int number, String name, String shortName){
        this.number = number;
        this.name = name;
        this.shortName = shortName;
    }
    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public String getShortName() {
        return shortName;
    }
    public List<Chapter> getChapters() {
        return chapters;
    }
    @Override
    public String toString() {
        return "Book: " + name + " (" + chapters.size() + " chapters)";
    }
}
