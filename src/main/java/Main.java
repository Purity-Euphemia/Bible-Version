package main.java;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\OneDrive\\Documents\\BibleVersion\\src\\main\\resources\\kjv.xml";
        Bible bible = BibleXmlReader.readBible(filePath);

        if (bible == null) {
            System.out.println(" Failed to load Bible file!");
            return;
        }

        System.out.println("✅ Bible loaded successfully: " + bible.getBiblename());
        System.out.println("Version: " + bible.getVersion());
        System.out.println("Books found: " + bible.getBooks().size());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to search in the Bible (or 'exit' to quit):");

        while (true) {
            System.out.print("> ");
            String query = scanner.nextLine();
            if (query.equalsIgnoreCase("exit")) break;

            List<Verse> results = bible.searchBySentence(query);

            if (results.isEmpty()) {
                System.out.println("No verses found for: " + query);
            } else {
                System.out.println("Found " + results.size() + " verse(s):");
                for (Verse v : results) {
                    System.out.println(v);
                }
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
