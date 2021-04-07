package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java9 {

    public void newApisCollectionFactoryMethods() {
        //Immutable Set
        Set<Integer> ints = Set.of(1, 2, 3);
        List<String> strings = List.of("first", "second");


        //Optional to Stream
        List<Optional<String>> listOfOptionals = new ArrayList<>();
        List<String> filteredList = listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

    }

    /**
     * Improvements for the stream API
     */
    public void streamApiImprovements() {
        IntStream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);

    }

    /**
     * Implemented http client
     */
    public void http2() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req =
                HttpRequest.newBuilder(URI.create("http://www.google.com"))
                        .header("User-Agent", "Java")
                        .GET()
                        .build();


        HttpResponse<String> httpResponse = client.send(req, HttpResponse.BodyHandlers.ofString());

    }

    /**
     * Can instantiate an interface with private methods
     */
    interface InterfaceWithPrivateMethods {

        private static String staticPrivate() {
            return "static private";
        }

        private String instancePrivate() {
            return "instance private";
        }

        default void check() {
            String result = staticPrivate();
            InterfaceWithPrivateMethods pvt = new InterfaceWithPrivateMethods() {
                // anonymous class
            };
            result = pvt.instancePrivate();
        }
    }
}
