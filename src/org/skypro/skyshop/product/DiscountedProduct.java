package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    protected int basePrice;
    protected int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Цена товара должна быть > 0");
        }
        this.basePrice = basePrice;
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Величина скидки может быть только в диапазоне от 0 до 100 включительно");
        }
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
