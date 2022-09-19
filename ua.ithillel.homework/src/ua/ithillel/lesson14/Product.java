package ua.ithillel.lesson14;

import java.time.LocalDate;

public class Product {
    private long id;
    private String type;
    private double price;
    private LocalDate createDate;
    private boolean discount;

    public Product(long ID, String type, double price, LocalDate createDate, boolean discount) {
        this.id = ID;
        this.type = type;
        this.price = price;
        this.createDate = createDate;
        this.discount = discount;
    }

    public Product(long ID, String type, double price, LocalDate createDate) {
        this.id = ID;
        this.type = type;
        this.price = price;
        this.createDate = createDate;
    }

    public void applyDiscount(double PercentDiscount) {
        if (PercentDiscount <= 100 && PercentDiscount > 0) {
            double sumofDiscount = price / 100 * PercentDiscount;
            price -= sumofDiscount;
        }
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
