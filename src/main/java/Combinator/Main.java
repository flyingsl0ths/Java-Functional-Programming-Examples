package Combinator;

import java.time.LocalDate;

import static Combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith", "johnsmith123@email.com", "+01234456789", LocalDate.of(2000, 1, 1));

        //CustomerValidatorService validatorService = new CustomerValidatorService();
        //System.out.println(validatorService.isValid(customer));

        // USING COMBINATOR PATTERN
        // ValidationResult validationResult = isEmail_Valid().and(isPhoneNo_Valid()).and(isAnAdult()).apply(customer);

        System.out.println("PERFORMING VALIDATIONS:");
        CustomerRegistrationValidator result = isEmail_Valid().and(isPhoneNo_Valid()).and(isAnAdult());
        ValidationResult validationResult = result.apply(customer);

        if (validationResult != ValidationResult.SUCCESS) {
            throw new IllegalStateException(validationResult.name());
        } else {
            System.out.println(validationResult);
        }
    }
}
