package com.company;

public record Java15(String name, int age) {
    /**
     * Override constructor
     */
    public Java15 {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }


}

/**
 * Sealed classes 
 */
sealed class Vehicle permits Car, Boat {

}
final class Car extends Vehicle {

}
non-sealed class Boat extends Vehicle {

}
//class Plane extends Vehicle {
//
//}

