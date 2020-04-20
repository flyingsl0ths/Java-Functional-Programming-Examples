package Combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {
    // COMBINATOR DESIGN PATTERN:
    // TAKES IN FUNCTIONS AS INPUT AND RETURNS NEW FUNCTIONS
    static CustomerRegistrationValidator isEmail_Valid() {
        return customer -> {
            System.out.println("Running email validation");
            return customer.getEmail().contains("@") ?
                    ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNo_Valid() {
        return customer -> {
            System.out.println("Running phoneNo validation");
            return customer.getPhoneNo().startsWith("+0") ?
                    ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> {
            System.out.println("Running is adult validator");
            return Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                    ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
        };
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
