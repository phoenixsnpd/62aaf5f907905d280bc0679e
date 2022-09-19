package ua.ithillel.lesson14;

import java.time.LocalDate;

public class Product {
    private String type;
    private double price;
    private LocalDate createDate;
    private boolean discount;

    public Product(String type, int price, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.createDate = createDate;
    }

    public Product(String type, int price, LocalDate createDate, boolean discount) {
        this.type = type;
        this.price = price;
        this.createDate = createDate;
        this.discount = discount;
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
