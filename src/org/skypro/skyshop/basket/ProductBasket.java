package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> productMap = new TreeMap<>();

    public void addProduct(Product product) {

            if (product == null) {
                return;
            }

            List<Product> products;
            if (!productMap.containsKey(product.getName())) {
                products = new LinkedList<>();
                productMap.put(product.getName(), products);
            } else {
                products = productMap.get(product.getName());
            }
            products.add(product);
        }

    public int getTotalPrice() {
        int cost = 0;
        for (List<Product> products : productMap.values()) {
            for (Product product : products) {
                if (product != null) {
                    cost += product.getPrice();
                }
            }
        }
        return cost;
    }

    public void printBasket() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> products : productMap.values()) {
            allProducts.addAll(products);
        }

        if (allProducts.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        System.out.println("Содержимое корзины:");
        int specialCount = 0;
        for (Product product : allProducts) {
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
        for (List<Product> products : productMap.values()) {
            for (Product product : products) {
                if (product.getName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        productMap.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        for (List<Product> products : productMap.values()) {
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    removedProducts.add(product);
                    iterator.remove();
                }
            }
        }
        return removedProducts;
    }
}


