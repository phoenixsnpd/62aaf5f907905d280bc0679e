package it.hillel.homework.lesson20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckArrayTest {
    @Test
    public void mustReturnAllNumbersAfterLast_4() {
        int[] numbers1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] numbers2 = {1, 2, 4, 4, 2, 3, 1, 7};
        int[] numbers3 = {1, 2, 4, 2, 3, 1, 7};

        int[] corectNumbers1 = {1, 7};
        int[] corectNumbers2 = {2, 3, 1, 7};
        int[] corectNumbers3 = {2, 3, 1, 7};

        Assertions.assertArrayEquals(corectNumbers1, CheckArray.returnNumbersAfter4(numbers1));
        Assertions.assertArrayEquals(corectNumbers2, CheckArray.returnNumbersAfter4(numbers2));
        Assertions.assertArrayEquals(corectNumbers3, CheckArray.returnNumbersAfter4(numbers3));
    }

    @Test
    public void mustReturnTrueIfArrayContainsOf_1_or_4() {
        int[] numbers1 = {1, 1, 1, 4, 4, 1, 4, 4};
        int[] numbers2 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] numbers3 = {1, 4, 4, 1, 1, 4, 3};
        int[] numbers4 = {4, 4, 4, 4};

        Assertions.assertTrue(CheckArray.checkArrayWith4And1(numbers1));
        Assertions.assertFalse(CheckArray.checkArrayWith4And1(numbers2));
        Assertions.assertFalse(CheckArray.checkArrayWith4And1(numbers3));
        Assertions.assertFalse(CheckArray.checkArrayWith4And1(numbers4));
    }
}
