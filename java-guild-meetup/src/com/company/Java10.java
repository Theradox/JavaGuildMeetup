package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Java10 {

    /**
     * Introduction to 'var' local variable and how not to instantiate it
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

    /**
     * Optional orElseThrow() method
     */
    public void optionalOrElseThrowMethod() {
        var numList1 = List.of(1,2,3,4);
        var numList2 = List.of(1,3,5,7);

        var firstEven = numList1.stream()
                .filter(i -> i % 2 == 0)
                .findFirst()
                .orElseThrow();
        System.out.printf("First even number is: %s%n", firstEven);

        // throwing NoSuchElementException

        var errorCheck = numList2.stream()
                .filter(i -> i % 2 == 0)
                .findFirst()
                .orElseThrow();
    }


}
