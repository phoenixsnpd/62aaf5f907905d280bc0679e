package coffee.order;

public class Order {
    private String name;
    private int idOrder;

    public Order(String name, int idOrder) {
        this.name = name;
        this.idOrder = idOrder;
    }

    public String getName() {
        return name;
    }

    public int getIdOrder() {
        return idOrder;
    }

    @Override
    public String toString() {
        return idOrder + "  |  " + name;
    }
}
