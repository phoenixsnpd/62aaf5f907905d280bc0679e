package ua.ithillel.lesson13;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {
    public static void main(String[] args) {

        // Testing Predicate

        Predicate<String> voidString = s -> s.length() != 0;

        System.out.println(voidString.test("Hello"));
        System.out.println(voidString.test(""));
        System.out.println(voidString.test("World"));
        System.out.println();

        Predicate<String> checkString = s -> s.endsWith("A") && s.startsWith("N") || s.startsWith("J");

        System.out.println(checkString.test("John and NorA"));
        System.out.println(checkString.test("NorA and John"));
        System.out.println(checkString.test("Never go to BORA-BORA"));
        System.out.println();

        // Testing Consumer

        CargoBox cargoBox = new CargoBox(10);
        Consumer<CargoBox>getCargoBox = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight() + " kg.");
        Consumer<CargoBox> sendCargoBox = box -> System.out.println("Отправляем ящик с весом " + box.getWeight() + " kg.");
        getCargoBox.andThen(sendCargoBox).accept(cargoBox);
        System.out.println();

        // Testing Function

        Function<Integer, Double> function = Math::sqrt;
        System.out.println(function.apply(100));
        System.out.println();

        // Testing Supplier

        Supplier<Integer> supplier = () -> (int) (Math.random() * 11);
            System.out.println(supplier.get());
    }
}
