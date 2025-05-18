package org.skypro.skyshop.product.search;

import java.util.Objects;

public class Article implements Searchable {

    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    void toString(String name, String text) {
        System.out.println(name);
        System.out.println(text);
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String getSearchTerm() {
        return getArticleName() + " - " + getArticleText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

    @Override
    public String toString() {
        return '\'' + articleName + '\'' +
                " - '" + articleText + '\'';
    }
}
