package main.java;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private int number;
    private List<Verse> verses = new ArrayList<>();

   public Chapter(int number) {
       this.number = number;
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
   @Override
   public String toString() {
       return "main.java.Chapter " + number + " (" + verses.size() + " verses)";
   }
}
