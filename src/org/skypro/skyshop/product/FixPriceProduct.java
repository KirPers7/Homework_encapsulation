package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 1_500;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    public int getProductPrice() {
        return FIX_PRICE_PRODUCT;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return productName + ": Фиксированная цена " + getProductPrice();
    }
}
