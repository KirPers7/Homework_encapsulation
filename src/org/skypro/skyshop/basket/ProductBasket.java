package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class ProductBasket {

    static final int LENGTH = 5;
    static final int LENGTH_DISC = 2;
    static final int LENGTH_FIX = 1;

    private final SimpleProduct[] simpleProducts = new SimpleProduct[LENGTH];
    private final DiscountedProduct[] discountedProducts = new DiscountedProduct[LENGTH_DISC];
    private final FixPriceProduct[] fixPriceProducts = new FixPriceProduct[LENGTH_FIX];

    //1. Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(String name, int price) {
        int count = 0;
        for (int i = 0; i < simpleProducts.length; i++) {
            if (simpleProducts[i] == null) {
                simpleProducts[i] = new SimpleProduct(name, price);
                break;
            } else if (simpleProducts[i] != null) {
                count++;
            }
        }
        if (count == LENGTH) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    //1.2 Метод добавления продукта со скидкой в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProductWithDiscount(String name, int price, int discountPercent) {
        int count = 0;
        for (int i = 0; i < discountedProducts.length; i++) {
            if (discountedProducts[i] == null) {
                discountedProducts[i] = new DiscountedProduct(name, price, discountPercent);
                break;
            } else if (discountedProducts[i] != null) {
                count++;
            }
        }
        if (count == LENGTH_DISC) {
            System.out.println("Невозможно добавить продукт со скидкой");
        }
    }

    //1.3 Метод добавления продукта с фиксированной ценой в корзину: метод принимает в себя продукт
    // и ничего не возвращает.
    public void addFixPriceProduct(String name) {
        int count = 0;
        for (int i = 0; i < fixPriceProducts.length; i++) {
            if (fixPriceProducts[i] == null) {
                fixPriceProducts[i] = new FixPriceProduct(name);
                break;
            } else if (fixPriceProducts[i] != null) {
                count++;
            }
        }
        if (count == LENGTH_FIX) {
            System.out.println("Невозможно добавить продукт с фиксированной ценой");
        }
    }

    //Общий метод добавления продукта в корзину
    public void addProductGeneral(String name, int price, int discountPercent) {
        if (price == 0 && discountPercent == 0) {
            addFixPriceProduct(name);
        } else if (discountPercent == 0) {
            addProduct(name, price);
        } else {
            addProductWithDiscount(name, price, discountPercent);
        }
    }

    //2. Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalCost() {
        int totalCost = 0;
        for (SimpleProduct simpleProduct : simpleProducts) {
            if (simpleProduct != null) {
                totalCost = totalCost + simpleProduct.getProductPrice();
            }
        }
        for (DiscountedProduct discountedProduct : discountedProducts) {
            if (discountedProduct != null) {
                totalCost = totalCost + discountedProduct.getProductPrice();
            }
        }
        for (FixPriceProduct fixPriceProduct : fixPriceProducts) {
            if (fixPriceProduct != null) {
                totalCost = totalCost + fixPriceProduct.getProductPrice();
            }
        }
        return totalCost;
    }

    //Метод получения количества специальных товаров
    public int getQuantityOfSpecialGoods() {
        int specialGoodsCount = 0;
        for (DiscountedProduct discountedProduct : discountedProducts) {
            if (discountedProduct != null && discountedProduct.isSpecial()) {
                specialGoodsCount++;
            }
        }
        for (FixPriceProduct fixPriceProduct : fixPriceProducts) {
            if (fixPriceProduct != null && fixPriceProduct.isSpecial()) {
                specialGoodsCount++;
            }
        }
        return specialGoodsCount;
    }

    //3. Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает,
    // но печатает в консоль сообщение вида: <имя продукта>: <стоимость> и Итого: <общая стоимость корзины>
    public void getBasketContents() {
        for (SimpleProduct simpleProduct : simpleProducts) {
            if (simpleProduct != null) {
                System.out.println(simpleProduct);
            }
        }
        for (DiscountedProduct discountedProduct : discountedProducts) {
            if (discountedProduct != null) {
                System.out.println(discountedProduct);
            }
        }
        for (FixPriceProduct fixPriceProduct : fixPriceProducts) {
            if (fixPriceProduct != null) {
                System.out.println(fixPriceProduct);
            }
        }
        if (getTotalCost() == 0) {
            System.out.println("в корзине пусто");
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + getQuantityOfSpecialGoods());
    }

    //4. Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает
    //boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean checkProductByName(String name) {
        boolean result = false;
        for (SimpleProduct simpleProduct : simpleProducts) {
            if (simpleProduct != null && simpleProduct.getProductName().equals(name)) {
                result = true;
                break;
            }
        }
        for (DiscountedProduct discountedProduct : discountedProducts) {
            if (discountedProduct != null && discountedProduct.getProductName().equals(name)) {
                result = true;
                break;
            }
        }
        for (FixPriceProduct fixPriceProduct : fixPriceProducts) {
            if (fixPriceProduct != null && fixPriceProduct.getProductName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }


    //5. Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        for (int i = 0; i < simpleProducts.length; i++) {
            if (simpleProducts[i] != null) {
                simpleProducts[i] = null;
            }
        }
        for (int i = 0; i < discountedProducts.length; i++) {
            if (discountedProducts[i] != null) {
                discountedProducts[i] = null;
            }
        }
        for (int i = 0; i < fixPriceProducts.length; i++) {
            if (fixPriceProducts[i] != null) {
                fixPriceProducts[i] = null;
            }
        }
    }

}
