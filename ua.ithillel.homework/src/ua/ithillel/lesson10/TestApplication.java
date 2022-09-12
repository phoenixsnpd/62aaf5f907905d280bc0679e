package ua.ithillel.lesson10;

public class TestApplication {
    public static void main(String[] args) {
        String[][] array = {{"6", "3", "2", "5"}, {"2", "3", "2", "5"}, {"2", "2", "2", "5"}, {"2", "3", "2", "7"}};
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        try {
            arrayValueCalculator.doCalc(array);
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }
}
