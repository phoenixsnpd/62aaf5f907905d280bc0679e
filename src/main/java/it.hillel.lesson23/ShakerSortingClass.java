package it.hillel.lesson23;

public final class ShakerSortingClass {
    private ShakerSortingClass() {}
    public static int[] sort(int[] numbersForSorting) {
        int startIndex = 0;
        int finishIndex = numbersForSorting.length - 1;
        int cycleCheck = 0;

        while (cycleCheck >= 0) {
            int biggestNumber = Integer.MIN_VALUE;
            int lowestNumber = Integer.MAX_VALUE;
            int indexPoint = -1;

            for (int i = startIndex; i < finishIndex; i++) {
                if (numbersForSorting[i] > biggestNumber) {
                    biggestNumber = numbersForSorting[i];
                    indexPoint = i;
                }
            }

            if (indexPoint != -1 && numbersForSorting[finishIndex] < biggestNumber) {
                numbersForSorting[indexPoint] = numbersForSorting[finishIndex];
                numbersForSorting[finishIndex] = biggestNumber;
            }
            finishIndex--;

            for (int i = finishIndex; i > startIndex; i--) {
                if (numbersForSorting[i] < lowestNumber) {
                    lowestNumber = numbersForSorting[i];
                    indexPoint = i;
                }
            }

            if (indexPoint != -1 && numbersForSorting[startIndex] > lowestNumber) {
                numbersForSorting[indexPoint] = numbersForSorting[startIndex];
                numbersForSorting[startIndex] = lowestNumber;
            }
            cycleCheck  = indexPoint;
        }
        return numbersForSorting;
    }
}
