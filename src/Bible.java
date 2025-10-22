import java.util.ArrayList;
import java.util.List;

public class Bible {
    private String version;
    private String status;
    private String biblename;
    private String type;
    private int revision;
    private Information information;
    private List<BibleBook> books;

    public Bible(String version, String status, String biblename, String type, int revision){
        this.version = version;
        this.status = status;
        this.biblename = biblename;
        this.type = type;
        this.revision = revision;
        this.books = new ArrayList<>();
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public void addBook(BibleBook book) {
        books.add(book);
    }
    public String getVersion() {
        return version;
    }
    public String getStatus() {
        return status;
    }
    public String getBiblename() {
        return biblename;
    }
    public String getType() {
        return type;
    }
    public int getRevision() {
        return revision;
    }
    public Information getInformation() {
        return information;
    }

    public List<BibleBook> getBooks() {
        return books;
    }
}
