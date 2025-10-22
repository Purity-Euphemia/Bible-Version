import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private int number;
    private List<Verse> verses;

   public Chapter(int number) {
       this.number = number;
       this.verses = new ArrayList<>();
   }
   public void addVerse(Verse verse) {
       verses.add(verse);
   }
   public int getNumber() {
       return number;
   }
   public List<Verse> getVerses() {
       return verses;
   }
}
