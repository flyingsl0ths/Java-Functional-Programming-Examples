package Combinator;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNo;
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNo, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public LocalDate getDob() {
        return dob;
    }
}
