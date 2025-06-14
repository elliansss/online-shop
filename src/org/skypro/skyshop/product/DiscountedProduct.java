package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int wholeSalePercentage;

    public DiscountedProduct(String name, int basicPrice, int wholeSalePercentage) {
        super(name);
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("Неправильная базовая цена ");
        }

        if (wholeSalePercentage < 0 || wholeSalePercentage > 100) {
            throw new IllegalArgumentException("Некорректный процент скидки ");
        }
        this.basicPrice = basicPrice;
        this.wholeSalePercentage = wholeSalePercentage;
    }

    @Override
    public int getPrice() {
        double discount = (double) wholeSalePercentage / 100;
        return (int) (basicPrice * (1 - discount));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + wholeSalePercentage + "%)";
    }
}