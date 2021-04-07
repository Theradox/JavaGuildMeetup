package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Java10 {

    /**
     * How not to instantiate 'var' local variable
     */
//    var asdf = "asdf";
//    public var ="hello";

    public void localVariable() {
        //cannot instantiate
//        var n;
//        var emptyList = null;
//        var p = (String s) -> s.length() > 10;
//        var arr = {1, 2, 3};


        //correct instantiation
        var asdf = "asdf";

        var empList = new ArrayList<>();

        var listOfStrings = List.of("1", "2", "3");
        var listOfIntegers = List.of(1, 2, 3);

        var listOfHashMaps = List.of(new HashMap<>(), new HashMap<>());

        var x = listOfStrings.stream()
                .findFirst()
                .map(String::length)
                .orElse(0);
    }

    /**
     * New unmodifiable collections
     */
    public void unmodifiableCollections () {
        var listOfIntegers = Arrays.asList(1, 2, 3);

        var copyList = List.copyOf(listOfIntegers);
        copyList.add(4);


        List<Integer> evenList = listOfIntegers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());
        evenList.add(4);
    }


}
