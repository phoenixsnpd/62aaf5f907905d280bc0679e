package it.hillel.lesson23;

import java.util.Arrays;

public class SortingAndCopyApplication {
    public static void main(String[] args) {
        int[] numbers = {-10, -1, 5, 3, 100, -2, 70, 574, 1, 5000, -5000};
        System.out.println(Arrays.toString(ShakerSortingClass.sort(numbers)));

        int[] source = {1, 2, 3, 4, 5};
        int[] target = {100, 99, 98};
        System.out.println(Arrays.toString(ArraysCopyClass.arrayCopy(source, target)));
    }
}