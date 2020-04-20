package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        // FUNCTION EXAMPLE
        int incremented = incrementByOne(1);
        System.out.println(incremented);

        // FUNCTION INTERFACE: TAKES 1 ARGUMENT AND PRODUCES 1 RESULT
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply10 = multiplyBy10Function.apply(increment2);

        System.out.println(multiply10);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        // BIFUNCTION INTERFACE: TAKES 2 ARGUMENTS AND PRODUCES 1 RESULT
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyFunction.apply(4, 100));

    }

    // FUNCTION INTERFACE: ACCEPTS AN INPUT/OUTPUT TYPE AND A LAMBDA
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    // BI-FUNCTION: TAKES IN 2 INPUTS AND PRODUCES 1 OUTPUT
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
