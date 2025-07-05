package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    Set<Product> products = new TreeSet<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public int getTotalPrice() {
        return products.stream()
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return products.stream()
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины");
        products.stream()
                .filter(Objects::nonNull)
                .forEach(product -> System.out.println(product.getName() + " " + "рублей"));

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean containsProduct(String productName) {
        return products.stream()
                .filter(Objects::nonNull)
                .anyMatch(product -> product.getName().equals(productName));
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());

        products.removeAll(removedProducts);
        return removedProducts;
    }
}

