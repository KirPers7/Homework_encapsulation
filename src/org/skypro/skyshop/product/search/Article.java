package org.skypro.skyshop.product.search;

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
}
