package FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerDemo {
    public static void main(String[] args) {
        /*  CONSUMER: REPRESENTS AN OPERATION THAT ACCEPTS
            A SINGLE INPUT ARGUMENT AND RETURNS NO RESULT
        */
        Customer m = new Customer("Maria", "123 456 7890");

        // NORMAL JAVA FUNCTION
        greetCustomer(m);

        // CONSUMER FUNCTIONAL INTERFACE
        greetCustomerConsumer.accept(m);
        greetCustomerConsumerV2.accept(m, false);
        greetCustomerConsumerV3.accept(m, true);


    }

    static String formatPhoneNumber(String phoneNo) {
        return phoneNo.replace(" ", "-");
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV3 = (customer, formatNumber) ->
            System.out.println("Hello " + customer.customerName + ", thanks for" +
                    " registering phone number " + (formatNumber ? formatPhoneNumber(customer.customerPhoneNumber): customer.customerPhoneNumber));


    // BI-CONSUMER: TAKES IN 2 INPUTS AND PRODUCES NO RESULT
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", thanks for" +
                    " registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "***-***-****"));


    // CONSUMER(FUNCTIONAL) APPROACH
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for" +
                    " registering phone number " + customer.customerPhoneNumber);


    // NORMAL JAVA FUNCTION
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for" +
                " registering phone number " + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
