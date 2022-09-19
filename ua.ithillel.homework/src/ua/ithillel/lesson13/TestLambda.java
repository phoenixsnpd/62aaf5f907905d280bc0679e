package ua.ithillel.lesson13;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {
    public static void main(String[] args) {
        CargoBox cargoBox = new CargoBox(1000);

        System.out.println(predicateTestOne("Hello"));
        System.out.println(predicateTestOne(""));
        System.out.println(predicateTestOne("World"));
        System.out.println();

        System.out.println(predicateTestTwo("John and NorA"));
        System.out.println(predicateTestTwo("NorA and John"));
        System.out.println(predicateTestTwo("Never go to BORA-BORA"));
        System.out.println();

        consumerTest(cargoBox);
        System.out.println();

        System.out.println(functionTest(100));
        System.out.println();

        System.out.println(suplierTest());
    }

    public static boolean predicateTestOne(String str) {
        Predicate<String> voidString = s -> s.length() != 0;
        return voidString.test(str);
    }

    public static boolean predicateTestTwo(String str) {
        Predicate<String> checkString = s -> s.endsWith("A") && s.startsWith("N") || s.startsWith("J");
        return checkString.test(str);
    }

    public static void consumerTest(CargoBox cargoBox) {
        Consumer<CargoBox>getCargoBox = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight() + " kg.");
        Consumer<CargoBox> sendCargoBox = box -> System.out.println("Отправляем ящик с весом " + box.getWeight() + " kg.");
        getCargoBox.andThen(sendCargoBox).accept(cargoBox);
    }

    public static Double functionTest(Integer number) {
        Function<Integer, Double> function = Math::sqrt;
        return function.apply(number);
    }

    public static Integer suplierTest() {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 11);
        return supplier.get();
    }
}
