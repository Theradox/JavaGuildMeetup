package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;

public class Java12 {

    /**
     * String methods for indentation and transformation of a String
     */
    public void newStringClassMethods() {
        String text = "Hello Intertec!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        String text2 = "Intertec";
        String transformedText = text2
                .transform(value -> new StringBuilder(value).reverse().toString());

        System.out.printf("Untransformed string: %s%n", text2);
        System.out.printf("Transformed string: %s%n", transformedText);
    }

    /**
     * Returns the position from where is the first character mismatch between the files
     */
    public void fileMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "J2va 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch);
    }

    /**
     * Formats the number based on which country (Locale)
     */
    public void compactNumberFormatting() {

        NumberFormat likesShort = NumberFormat
                .getCompactNumberInstance(new Locale("mk", "MK"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(1234));

        NumberFormat likesShort2 = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort2.format(1234));

        NumberFormat likesLong = NumberFormat
                .getCompactNumberInstance(new Locale("mk", "MK"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong.format(1234));

        NumberFormat likesLong2 = NumberFormat
                .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong2.format(1234));

    }

    /**
     * Old representation of switch case
     */
    public void oldSwitchCase() {

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                typeOfDay = "Working Day";
                break;
            case SATURDAY:
            case SUNDAY:
                typeOfDay = "Day Off";
        }
        System.out.println(typeOfDay);
    }

    /**
     * New representation of switch case - Preview feature
     */
    public void newSwitchCase() {

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";
        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("What type of day it is?");
                System.out.println("Working day");
            }
            case SATURDAY, SUNDAY -> System.out.println("Day Off");
        }
    }

    /**
     * Old representation of pattern matching
     */
    public void oldPatternMatching() {
        Object obj = "Hello World!";
        if (obj instanceof String) {
            String s = (String) obj; // No need for this line
            int length = s.length();
            System.out.println(length);
        }
    }

    /**
     * New representation of pattern matching
     */
    public void newPatternMatching() {
        Object obj = "Hello World!";
        if (obj instanceof String s && s.contains("Hello")) {
            int length = s.length();
            System.out.println(length);
        }
    }


}
