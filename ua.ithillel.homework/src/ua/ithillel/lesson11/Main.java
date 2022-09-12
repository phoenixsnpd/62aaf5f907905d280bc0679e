package ua.ithillel.lesson11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array = {"Hello", "World", "!", "123"};
        System.out.println(toList(array));
        Apple apple = new Apple();
        Orange orange = new Orange();

        List<Orange> moreOranges = List.of(new Orange(), new Orange(), new Orange());

        List<Apple> moreAplles = List.of(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());

        Box<Orange> boxWithOrange = new Box<>();
        Box<Apple> boxWithApple = new Box<>();
        Box<Apple> boxWithAppleTwo = new Box<>();

        boxWithOrange.addOneFruit(orange);
        boxWithApple.addOneFruit(apple);

        boxWithOrange.addManyFruits(moreOranges);
        boxWithApple.addManyFruits(moreAplles);
        boxWithAppleTwo.addManyFruits(moreAplles);

        System.out.println(boxWithOrange.getWeight());
        System.out.println(boxWithApple.getWeight());

        System.out.println(boxWithOrange.compare(boxWithApple));
        System.out.println(boxWithOrange.compare(boxWithAppleTwo));

        boxWithApple.merge(boxWithAppleTwo);

        System.out.println(boxWithApple.getFruits().size());
    }

    public static <T> List toList(T[] array) {
        List<T> newList = new ArrayList<>();
        Collections.addAll(newList, array);
        return newList;
    }
}
