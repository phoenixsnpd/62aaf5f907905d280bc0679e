package coffee.order;

public class TestCofeeOrderBoard {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Alen");
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-van");
        coffeeOrderBoard.add("John Snow");
        coffeeOrderBoard.add("Donald Duck");

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.diliverByNumber(5);

        coffeeOrderBoard.add("Dunkan McLeod");

        coffeeOrderBoard.draw();
    }
}
