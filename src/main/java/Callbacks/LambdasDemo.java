package Callbacks;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdasDemo {
    public static void main(String[] args) {
        // LAMBDAS: '->'

        Service service = new Service();

        System.out.println(service.upperCaseName1.apply("Maria"));
        System.out.println(service.upperCaseName2.apply("John"));

        /*  PRIMITIVES & FUNCTIONAL INTERFACES:
            PRIMITIVES ARE NOT ALLOWED WITHIN THE
            INTERFACES THEMSELVES DUE TO PRIMITIVES
            NOT BEING ABLE TO STORE 'NULL' AS A VALUE
        */
        System.out.println(service.upperCaseName3.apply("John", 20));


        service.printName.accept("Hello");
    }

    static class Service {
        // FUNCTIONAL INTERFACES SHOULD BE STORED WITHIN A CLASS

        // IMMEDIATE RETURN EXAMPLE: USING METHOD REFERENCING
        Function<String, String> upperCaseName1 = String::toUpperCase;

        // METHOD-BODY EXAMPLE:
        // 'parameter -> { <code> };' | '(parameter) -> { <code> };'
        Function<String, String> upperCaseName2 = name -> {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Name is blank");
            }
            return name;
        };

        // BI-FUNCTIONS EXAMPLE: '(parameter1, parameter2) -> { <code> };'
        BiFunction<String, Integer, String> upperCaseName3 = (name, age) -> {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Can't perform operation");
            }
            System.out.println("Age is: " + age);
            return name.toUpperCase();
        };

        Consumer<String> printName = System.out::println;

    }
}
