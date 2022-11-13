package coffee.order;

public class CofeeOrderBoardAplication {

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Alen");
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-van");
        coffeeOrderBoard.add("John Snow");
        coffeeOrderBoard.add("Donald Duck");

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(1000);

        coffeeOrderBoard.add("Dunkan McLeod");
    }
}

