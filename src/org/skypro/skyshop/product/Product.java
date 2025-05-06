package org.skypro.skyshop.product;

public class Product {
    private String nameOfTheProduct;
    private int priceOfTheProduct;

    public Product(String name, int price) {
        this.nameOfTheProduct = name;
        this.priceOfTheProduct = price;
    }

    public int getPriceOfTheProduct() {
        return priceOfTheProduct;
    }

    public String getNameOfTheProduct() {
        return nameOfTheProduct;

    }

    @Override
    public String toString() {
        return nameOfTheProduct + ": " + priceOfTheProduct;
    }
}

