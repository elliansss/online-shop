package org.skypro.skyshop.info;

public class BestResultNotFoundException extends Exception {

    public BestResultNotFoundException(String query) {
        super("Лучший результат не найден: " + query);
    }

    public BestResultNotFoundException(String query, Throwable cause) {
        super("Лучший результат не найден: " + query, cause);
    }
}