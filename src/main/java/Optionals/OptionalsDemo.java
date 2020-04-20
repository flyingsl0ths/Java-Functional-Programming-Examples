package Optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalsDemo {
    public static void main(String[] args) {
         Object orElseGet = Optional.ofNullable("null").orElseGet(() -> "default value");

         Supplier<IllegalStateException> empty_value1 = () -> new IllegalStateException("Empty value");
         Object empty_value = Optional.ofNullable("Hello").orElseThrow(empty_value1);

         Optional.ofNullable(null).ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email"));


    }
}
