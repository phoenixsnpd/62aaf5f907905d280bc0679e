package ua.ithillel.lesson7.figurearea;

public class Main {
    public static void main(String[] args) {
        CalculateFigureArea[] figures = {new Triangle(), new Circle(10), new Square(10), new Circle(20), new Square(16)};
        System.out.println("The total area of the figures is " + allFigureArea(figures) + " centimeters.");

    }

    public static double allFigureArea(CalculateFigureArea[] figures) {
        double result = 0;
        for (int i = 0; i < figures.length; i++) {
            result += figures[i].calculate();
        }
        return result;
    }
}
