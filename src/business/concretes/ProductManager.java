package business.concretes;

import java.util.Comparator;
import java.util.List;

import entity.Product;

public class ProductManager {

    // Sorting by price
    public static Comparator<Product> compareByPrice() {
        return Comparator.comparingDouble(Product::getPrice);
    }

    // Sorting by stock
    public static Comparator<Product> compareByStock() {
        return Comparator.comparingInt(Product::getStock);
    }

    // Listing and writing products
    public static void printProducts(List<? extends Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
