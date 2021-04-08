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

    /**
     * Implemented http client - It is deployed that redirected to Incubator module
     */
    public void httpClient() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req =
                HttpRequest.newBuilder(URI.create("http://www.google.com"))
                        .header("User-Agent", "Java")
                        .GET()
                        .build();


        HttpResponse<String> httpResponse = client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * New APIs and new Collection Factory methods
     */
    public void newApisCollectionFactoryMethods() {
        //Old way
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        // New way
        List<Integer> list2 = List.of(1,2);


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
