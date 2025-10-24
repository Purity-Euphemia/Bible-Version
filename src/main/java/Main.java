package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/kjv.xml";
        Bible bible = BibleXmlReader.readBible(filePath);

        if (bible == null) {
            System.out.println("Failed to load Bible file!");
            return;
        }

        System.out.println("✅ " + bible.getBiblename() + " loaded successfully!");
        System.out.println("Type a verse reference (e.g., John 3:16 or Genesis 1:1)");
        System.out.println("Type 'exit' to quit.\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;
            if (input.isEmpty()) continue;

            try {

                int lastSpace = input.lastIndexOf(' ');
                if (lastSpace == -1 || !input.contains(":")) {
                    System.out.println("⚠️ Invalid format! Use Book Chapter:Verse (e.g., John 3:16)");
                    continue;
                }

                String bookName = input.substring(0, lastSpace);
                String[] parts = input.substring(lastSpace + 1).split(":");
                int chapterNumber = Integer.parseInt(parts[0]);
                int verseNumber = Integer.parseInt(parts[1]);

                Verse verse = bible.getVerse(bookName, chapterNumber, verseNumber);

                if (verse != null) {
                    System.out.println(bookName + " " + chapterNumber + ":" + verseNumber + " → " + verse.getText());
                } else {
                    System.out.println(" Verse not found: " + input);
                }

            } catch (Exception e) {
                System.out.println("⚠️ Invalid input! Use format like 'John 3:16'");
            }
        }

        scanner.close();
        System.out.println("👋 Goodbye!");
    }
}
