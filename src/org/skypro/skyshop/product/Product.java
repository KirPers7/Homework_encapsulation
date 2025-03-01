package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public abstract class Product implements Searchable {

    protected String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new NullPointerException("Не введено наименование продукта");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
