package ua.ithillel.lesson14;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1111L,"Toy",20, LocalDate.of(2021, Month.DECEMBER, 11)));
        products.add(new Product(1112L,"Toy",100, LocalDate.of(2022, Month.JULY, 12)));
        products.add(new Product(3111L,"Stationery",15, LocalDate.of(2022, Month.AUGUST, 1)));
        products.add(new Product(3112L,"Stationery",5, LocalDate.of(2022, Month.SEPTEMBER, 11)));
        products.add(new Product(2111L,"Book",260, LocalDate.of(2022, Month.SEPTEMBER, 12), true));
        products.add(new Product(2112L,"Book",60, LocalDate.of(2022, Month.SEPTEMBER, 13)));
        products.add(new Product(2113L,"Book", 40, LocalDate.of(2022, Month.SEPTEMBER, 14)));
        products.add(new Product(2114L,"Book", 70, LocalDate.of(2022, Month.SEPTEMBER, 15)));


        List<Product> emptyList = new ArrayList<>();

        System.out.println(filterByPrice(products));
        System.out.println();

        System.out.println(booksWithDiscount(products, 10));
        System.out.println();

        try {
            System.out.println(minimalPriceBook(products, "Book"));
        } catch (ProductNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            System.out.println(minimalPriceBook(emptyList, "Book"));
        } catch (ProductNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println(threeLastProduct(products));
        System.out.println();

        System.out.println(sumOfPrductsPrices(products));
        System.out.println();

        System.out.println(productGroups(products));
    }

    public static List<Product> filterByPrice(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .toList();
    }

    public static List<Product> booksWithDiscount(List<Product> products, int diccount) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .peek(product -> product.applyDiscount(diccount))
                .toList();
    }

    public static Product minimalPriceBook(List<Product> products, String productType) throws ProductNotFoundException {
        Optional<Product> book = products.stream()
                .filter(product -> product.getType().equals(productType))
                .min(Comparator.comparingDouble(Product::getPrice));
        if (book.isEmpty())
            throw new ProductNotFoundException("Product with type \"" + productType + "\"  not found");

        return book.get();
    }

    public static List<Product> threeLastProduct(List<Product> products) {
       return products.stream()
                .skip(products.size() - 3)
                .toList();
    }

    public static double sumOfPrductsPrices(List<Product> products) {
        LocalDate localDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() <= 75 && product.getCreateDate().getYear() == localDate.getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> productGroups(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
