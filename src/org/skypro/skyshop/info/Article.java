package org.skypro.skyshop.info;

public class Article implements Searchable {
    private final String title;
    private final String text;
    public static final String ARTICLE = "ARTICLE";

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getName() {
        return getTitle();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return ARTICLE;
    }

    @Override
    public String toString() {
        return "Название статьи " + getTitle() + "\n" + "Текст статьи " + getText();

    }
}

