package ua.ithillel.lesson7.figurearea;

public class Circle implements CalculateFigureArea {
    private double diameter = 10;
    private double circle = Math.PI * diameter;
    private double radius = diameter / 2;

    public Circle(int diameter) {
        this.diameter = diameter;
        if (diameter <= 0){
            System.out.println("Shape could not be created");
        }
    }

    public double calculate() {
      return Math.PI * (radius * radius);
    }

    public double getDiameter() {
        return diameter;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircle()  {
        return circle;
    }
}
