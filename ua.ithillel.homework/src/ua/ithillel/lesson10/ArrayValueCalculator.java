package ua.ithillel.lesson10;


public class ArrayValueCalculator {
    public int doCalc(String[][] stringArray) throws ArraySizeException, ArrayDataException {
        int[][] intArray = new int[4][4];
        int result = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (stringArray.length != intArray.length || stringArray[i].length != intArray[i].length) {
                throw  new ArraySizeException("Wrong size. Array size must be 4x4!");
            }
            for (int j = 0; j < stringArray.length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                    result += intArray[i][j];
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Sring in the cell " + "[" + i + "]" + "[" + j + "]" + " isn't a number", e);
                }
            }
        }
        System.out.println(result);
        return result;
    }

}
