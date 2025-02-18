package org.skypro.skyshop.product.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();
    }
}
