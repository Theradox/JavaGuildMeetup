package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;

public class Java12 {

    public void newStringClassMethods() {
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        String text2 = "Baeldung";
        String transformed = text2.transform(value ->
                new StringBuilder(value).reverse().toString()
        );
        System.out.println(transformed);
    }

    public void fileMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "J2va 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch);
        System.out.println();
    }

    public void compactNumberFormating() {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("de", "DE"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("de", "DE"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);


        NumberFormat likesShort2 =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);

        NumberFormat likesLong2 =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);

        System.out.println(likesShort.format(1234));
        System.out.println(likesShort2.format(1234));
        System.out.println(likesLong.format(1234));
        System.out.println(likesLong2.format(1234));
    }

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
        System.out.println(dayOfWeek);
    }

    public void newSwitchCase() {

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";
        typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };
    }

    public void oldPatternMatching () {
        Object obj = "Hello World!";
        if (obj instanceof String) {
            String s = (String) obj;
            int length = s.length();
            System.out.println(length);
        }
    }

    public void newPatternMatching() {
        Object obj = "Hello World!";
        if (obj instanceof String s && s.contains("Hello")) {
            int length = s.length();
            System.out.println(length);
        }
    }


}