package FunctionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // SUPPLIER: REPRESENTS A SUPPLIER OF RESULTS

        System.out.println("SUPPLIER INTERFACE");
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(randomNumberRange.get());
        System.out.println(getDBConnectionUrlSupplierAsList.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc:://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc:://localhost:5432/users";

    static Supplier<String> randomNumberRange = () -> {
        StringBuilder rn = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            rn.append(Integer.toString(i));
        }
        return rn.toString();
    };

    static Supplier<List<String>> getDBConnectionUrlSupplierAsList = () -> List.of(
            "jdbc:://localhost:5432/users02",
            "jdbc:://localhost:5432/users01");
}
