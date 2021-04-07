package com.company;

public class Java13 {

    /**
     * Switch case with the yield functionality
     */
    public void switchCaseYield() {
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                yield me * 2;
            }
            case "squareMe" -> {
                yield me * me;
            }
            default -> me;
        };
        System.out.println(result);
    }

    /**
     * Old way of json String formatting
     */
    public void jsonString() {
        String JSON_STRING
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";
        System.out.println(JSON_STRING);
    }

    /**
     * New way of json String formatting with text block
     */
    public void textBlockJson() {
        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;
        System.out.println(TEXT_BLOCK_JSON);
    }

    /**
     * Another example of multiline text block
     */
    public void textBlock() {
        String multiline = """
    A quick brown fox jumps over a lazy dog; 
    the lazy dog howls loudly.""";
        System.out.println(multiline);
    }

}
