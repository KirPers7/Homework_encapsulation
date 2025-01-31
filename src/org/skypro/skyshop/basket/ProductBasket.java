package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    static final int LENGTH = 5;
    Product[] products = new Product[LENGTH];

    //1. Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(Product product) {
        int count = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            } else if (products[i] != null) {
                count++;
            }
        }
        if (count == LENGTH) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    //2. Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost = totalCost + product.getProductPrice();
            }
        }
        return totalCost;
    }

    //Метод получения количества специальных товаров
    public int getQuantityOfSpecialGoods() {
        int specialGoodsCount = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                specialGoodsCount++;
            }
        }
        return specialGoodsCount;
    }

    //3. Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает,
    // но печатает в консоль сообщение вида: <имя продукта>: <стоимость> и Итого: <общая стоимость корзины>
    public void getBasketContents() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
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
        for (Product product : products) {
            if (product != null && product.getProductName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }


    //5. Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }

}
