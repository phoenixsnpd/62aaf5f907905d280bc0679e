package it.hillel.homework.lesson20;

public class CheckArray {
    public static int[] returnNumbersAfter4(int[] numbers) {
        int checkNumber4 = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 4) {
                checkNumber4 = i;
            }
        }
        if (checkNumber4 == 0) {
            throw new RuntimeException("This array doesn't contain number 4");
        }

        int[] arrayForReturn = new int[numbers.length - checkNumber4 - 1];

        for (int i = checkNumber4 + 1, j = 0; i < numbers.length; i++, j++) {
            arrayForReturn[j] = numbers[i];
        }
        return arrayForReturn;
    }

    public static boolean checkArrayWith4And1(int[] numbers) {
        int counterFor1 = 0;
        int counterFor4 = 0;

        for (int numb : numbers) {
            if (numb != 1 && numb != 4) {
                return false;
            } else if (numb == 1) {
                counterFor1++;
            } else if (numb == 4) {
                counterFor4++;
            }
        }
        return counterFor1 != 0 && counterFor4 != 0;
    }
}
