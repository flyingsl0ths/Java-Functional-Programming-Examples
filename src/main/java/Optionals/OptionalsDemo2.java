package Optionals;

import java.util.Optional;

public class OptionalsDemo2 {
    public static void main(String[] args) {
        Optional<Object> empty1 = Optional.empty();

        // Used when value might be empty
        Optional<String> empty2 = Optional.of("Hello");

        // Used when value will be null
        Optional<String> empty3 = Optional.ofNullable(null);

        System.out.println(empty1.isEmpty());
        System.out.println(empty2.isPresent());
        System.out.println(empty3.isEmpty());

        String orElse2 = empty3
                .map(String::toUpperCase).orElseGet(() -> {
                    return "GOT: Hello World!";
                });

        // String orElse3 = empty3.map(String::toUpperCase).orElseThrow(IllegalStateException::new);

        empty3.ifPresent(System.out::println);

        empty3.ifPresentOrElse(System.out::println, () -> {
            System.out.println("NOT PRESENT");
        });

        Person james = new Person("James", "randomemail124@email.com");

        Person jacob = new Person("Jacob", null);

        String email = james.getEmail().map(String::toLowerCase).orElse("email not provided");
        System.out.println(email);

        // Optionals can be used in if-statements as well
        if (jacob.getEmail().isPresent()) {
            String email1 = jacob.getEmail().get().toLowerCase();
            System.out.println(email1);
        } else {
            System.out.println("email not provided for: " + jacob.getName());
        }
    }
}

class Person {
    private final String name;
    private final String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

}