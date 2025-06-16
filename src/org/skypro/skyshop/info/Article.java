package org.skypro.skyshop.info;

import java.util.Objects;

public class Article implements Searchable, Comparable<Article> {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "Название статьи " + getTitle() + "\n" + "Текст статьи " + getText();

    }

    @Override
    public int compareTo(Article other) {
        if (other == null) return -1;
        if (this.title == null && other.title == null) return -1;
        if (this.title == null) return 1;
        if (other.title == null) return -1;
        int lengthCompare = Integer.compare(other.title.length(), this.title.length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return this.title.compareTo(other.title);
    }
}

