package ua.ithillel.lesson7.figurearea;

public class Square implements CalculateFigureArea {
    private double side;

    public Square (double side) {
        this.side = side;
        if (side <= 0){
            System.out.println("Shape could not be created");
        }
    }

    public double calculate() {
        return side * side;
    }

    public double getSide() {
        return side;
    }
}
