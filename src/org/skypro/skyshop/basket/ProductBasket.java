package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] productsBasket = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size < productsBasket.length) {
            productsBasket[size] = product;
            size++;
        } else {
            System.out.println("Невозможно добавить продукт " + product.getNameOfTheProduct());
        }
    }

    public int getTotalPrice() {
        int cost = 0;
        for (int i = 0; i < size; i++) {
            cost = cost + productsBasket[i].getPriceOfTheProduct();
        }
        return cost;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("Корзина пуста.");
            return;
        }

        System.out.println("Содержимое корзины:");
        for (int i = 0; i < size; i++) {
            System.out.println(productsBasket[i]);
        }
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < size; i++) {
            if (productsBasket[i].getNameOfTheProduct().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < productsBasket.length; i++) {
            productsBasket[i] = null;
        }
        size = 0;
    }
}