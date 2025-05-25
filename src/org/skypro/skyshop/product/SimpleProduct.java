package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Неправильная цена ");
        }
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
        }
@Override
public boolean isSpecial() {
    return false;
}
@Override
    public String toString() {
        return getName() + ": " + getPrice();
}
}
