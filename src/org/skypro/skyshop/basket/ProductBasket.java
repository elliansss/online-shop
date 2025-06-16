package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    Set<Product> products = new TreeSet<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }


    public int getTotalPrice() {
        int cost = 0;
        for (Product product : products) {
            if (product != null) {
                cost += product.getPrice();
            }
        }
        return cost;
    }

    public void printBasket() {
        for (Product product : products) {
            System.out.println(product);
        }

        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        System.out.println("Содержимое корзины:");
        int specialCount = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " " + product.getPrice() + " " + "рублей");
                if (product.isSpecial()) {
                    specialCount++;
                }
            } else {
                System.out.println("Продукта нет!");
            }

        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (removedProducts == null) {
            return Collections.emptyList();
        }
        return removedProducts;
    }
}


