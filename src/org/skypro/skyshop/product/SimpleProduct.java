package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    protected int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return productName + ": " + productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
