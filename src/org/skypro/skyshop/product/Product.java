package org.skypro.skyshop.product;

import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.info.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable, Comparable<Product> {
    private final String name;
    public static final String PRODUCT = "PRODUCT";
    public boolean isSpecial;


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Нет имени продукта ");
        }
        this.name = name;
        this.isSpecial = isSpecial;
    }

    public Product(String name, String name1) {
        this.name = name1;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Product other) {
        if (other == null) return -1;
        if (this.name == null && other.name == null) return -1;
        if (this.name == null) return 1;
        if (other.name == null) return -1;
        int lengthCompare = Integer.compare(other.name.length(), this.name.length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return this.name.compareTo(other.name);
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





