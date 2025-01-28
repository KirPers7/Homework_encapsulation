package org.skypro.skyshop.product;

public class FixPriceProduct {
//К слову, в задании не было требования наследовать этот класс от Product.
    private static final int FIX_PRICE_PRODUCT = 1_500;
    private final String productName;
    private final int price;

    public FixPriceProduct(String productName) {
        this.productName = productName;
        this.price = getProductPrice();
    }

    public int getProductPrice() {
        return FIX_PRICE_PRODUCT;
    }

    public String getProductName() {
        return productName;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return productName + ": Фиксированная цена " + price;
    }
}
