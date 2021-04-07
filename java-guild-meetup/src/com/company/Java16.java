package com.company;

public class Java16 {
    /**
     * Sealed interface with records showcase
     */
    sealed interface Person permits Person.Worker, Person.Manager, Person.Director {
        
        final record Worker(String name, String lastname) implements Person {
        }

        final record Manager(String name, String lastname) implements Person {
        }

        final record Director(String name, String lastname) implements Person {
        }
    }
}


