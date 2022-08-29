package ua.ithillel.lesson7.figurearea;

public class Triangle implements CalculateFigureArea {
    private double height;
    private double sideA = 10;
    private double sideB = 3;
    private double sideC = 8;


    public double calculate() {
        return 1 / 2 * sideA * height;
    }

    public double getHeight() {
        return height;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
