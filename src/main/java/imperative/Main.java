package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Marissa", Gender.FEMALE),
                new Person("Jacob", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        // Imperative Approach
        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();

        for (Person p : people) {
            if (p.gender.equals(Gender.FEMALE))
                females.add(p);
        }

        for (Person female : females) {
            System.out.println(female);
        }

        /*  Declarative Approach:
            STREAM: AN ABSTRACTION THAT ALLOWS AGGREGATED
            FUNCTIONS TO BE PERFORMED ON SETS OF DATA
        */
        // PREDICATE: ACTION/STATEMENT
        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);

        System.out.println("\nDeclarative Approach");
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females2.forEach(System.out::println);


    }

    public static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
