public class Main {
    public static void main(String[] args) {
        Bible bible = BibleXmlReader.readBible("kjv.xml");
        if (bible != null) {
            System.out.println(bible);
            System.out.println(bible.getInformation());


            if (!bible.getBooks().isEmpty()) {
                BibleBook firstBook = bible.getBooks().get(0);
                System.out.println("\nFirst Book: " + firstBook.getBookName());
                System.out.println(firstBook);
            }
        }
    }
}

