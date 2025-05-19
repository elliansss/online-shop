package org.skypro.skyshop.product;

import org.skypro.skyshop.info.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    public static final String PRODUCT = "PRODUCT";


    public Product(String name) {
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




