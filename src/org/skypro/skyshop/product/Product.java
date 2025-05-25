package org.skypro.skyshop.product;

import org.skypro.skyshop.info.Searchable;

import javax.lang.model.element.Name;

public abstract class Product implements Searchable {
    private final String name;
    public static final String PRODUCT = "PRODUCT";


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Нет имени продукта ");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return PRODUCT;
    }

    @Override

    public abstract String toString();

}





