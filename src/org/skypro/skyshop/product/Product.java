package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
