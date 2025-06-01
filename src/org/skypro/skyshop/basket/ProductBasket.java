package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final LinkedList<Product> products = new LinkedList<>();
    private int counter = 0;

    public void addProduct(Product product) {
        products.add(product);
        counter++;
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
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                counter--;
            }
        }
        return removedProducts;
    }
}


