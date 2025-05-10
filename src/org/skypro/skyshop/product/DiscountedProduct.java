package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int wholeSalePercentage;

    public DiscountedProduct(String name, int basicPrice, int wholeSalePercentage) {
        super(name);
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
    }}