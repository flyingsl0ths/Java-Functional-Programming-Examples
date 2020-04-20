package FunctionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // PREDICATE:
        // REPRESENTS A PREDICATE(BOOLEAN-VALUED FUNCTION)
        // OF ONE ARGUMENT

        // BI-PREDICATE:
        // REPRESENTS A PREDICATE(BOOLEAN-VALUED FUNCTION)
        // OF TWO ARGUMENTS

        System.out.println("JAVA FUNCTION");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700008750"));
        System.out.println(isPhoneNumberValid("09000087500"));

        System.out.println();

        System.out.println("PREDICATE INTERFACE");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000087500"));

        // CHAINING PREDICATES
        System.out.println("\nCHAINING PREDICATES");
        System.out.println(
                "Is phone number valid and contains the number 3: " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("09000087500"));

        System.out.println(
                "Is phone number valid and contains the number 3: " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("07000037500"));

        System.out.println(
                "Is phone number valid and contains the number 3: " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("09000037500"));

        // BI-PREDICATE INTERFACE
        BiPredicate<String, String> checkForEqualPhoneNoLength = (phoneNo1, phoneNo2) -> {
            return phoneNo1.length() == phoneNo2.length();
        };
        System.out.println("\nBI-PREDICATE INTERFACE");
        System.out.println("Is phoneNo1 == phoneNo2: " + checkForEqualPhoneNoLength.test("0901212212100037500", "09010037500"));
    }

    static boolean isPhoneNumberValid(String phoneNo) {
        return phoneNo.startsWith("07") && phoneNo.length() == 11;
    }

    static Predicate<String> containsNumber3 = phoneNo -> {
        return phoneNo.contains("03");
    };

    static Predicate<String> isPhoneNumberValidPredicate = phoneNo -> {
        return phoneNo.startsWith("07") && phoneNo.length() == 11;
    };
}
