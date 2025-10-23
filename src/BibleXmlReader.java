import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class BibleXmlReader {
    public static  Bible readBible(String filePath) {
        Bible bible = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            bible = new Bible(root.getAttribute("version"), root.getAttribute("status"), root.getAttribute("biblename"), root.getAttribute("type"), Integer.parseInt(root.getAttribute("revision")));


            Element infoElement = (Element) document.getElementsByTagName("INFORMATION").item(0);
            if (infoElement != null) {
                Information information = new Information(getText(infoElement,"title"), getText(infoElement, "subject"), getText(infoElement, "description"), getText(infoElement, "publisher"), getText(infoElement, "date"), getText(infoElement, "type"), getText(infoElement, "format"), getText(infoElement, "identifier"), getText(infoElement, "source"), getText(infoElement, "language"), getText(infoElement, "coverage"), getText(infoElement, "creactor"));
            bible.setInformation(information);
        }

            NodeList books = document.getElementsByTagName("BIBLEBOOK");
            for (int count = 0; count < books.getLength(); count++) {
                Element bookElement = (Element) books.item(count);
                BibleBook book = new BibleBook(Integer.parseInt(bookElement.getAttribute("bnumber")), bookElement.getAttribute("bname"), bookElement.getAttribute("bsname"));

                NodeList chapters = bookElement.getElementsByTagName("CHAPTER");
                for (int counter = 0; counter < chapters.getLength(); counter++) {
                    Element chapterElement = (Element) chapters.item(counter);
                    Chapter chapter = new Chapter(Integer.parseInt(chapterElement.getAttribute("cnumber")));

                    NodeList verses = chapterElement.getElementsByTagName("VERS");
                    for (int value = 0; value < verses.getLength(); value++) {
                        Element vEl = (Element) verses.item(value);
                        Verse verse = new Verse(
                                Integer.parseInt(vEl.getAttribute("vnumber")),
                                vEl.getTextContent().trim()
                        );
                        chapter.addVerse(verse);
                    }
                    book.addChapter(chapter);
                }
                bible.addBook(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bible;
    }

    private static String getText(Element parent, String tag) {
        NodeList list = parent.getElementsByTagName(tag);
        if (list.getLength() > 0)
            return list.item(0).getTextContent();
        return "";
    }
}





