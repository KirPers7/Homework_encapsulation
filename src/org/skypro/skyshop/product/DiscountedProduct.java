package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    protected int basePrice;
    protected int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice * discountPercent) / 100;
    }

    @Override
    public String toString() {
        return productName + ": " + basePrice + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
