package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java11 {

    /**
     * Adds each String before \n as a separate item in a list
     */
    public void newStringMethods () {
        String multilineString = "Intertec helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        System.out.println(multilineString);
        System.out.println(lines);
    }

    /**
     * New file write and read methods
     */
    public void newFileMethods () throws IOException {
        Path filePath = Files.writeString(Files.createTempFile("file", ".txt"), "Intertec.io");
        String fileContent = Files.readString(filePath);
        System.out.println(fileContent);
    }

    /**
     * Showcase of 'var' local variable for lambda
     */
    public void localVariableSyntaxForLambda () {
        var arrInteger = new Integer[]{5, 9, 3, 6, 2, 4, 8, 7, 1};
        long cnt = Arrays.stream(arrInteger).filter(
                (var a) -> (a != null && a > 5)).count();
        System.out.println(cnt);
    }

    /**
     * HTTP client initializer
     */
    public void HTTPClientImprovements () throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.google.com"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
    }
}
