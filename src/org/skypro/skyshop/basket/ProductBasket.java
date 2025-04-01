package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    List<Product> productsList = new LinkedList<>();
    Map<String, List<Product>> productsMap = new HashMap<>();

    //1. Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(String productName, Product product) {
        if (!productsMap.containsKey(productName)) {
            productsMap.put(productName, productsList);
            productsList.add(product);
        } else {
            productsList.add(product);
        }
    }

    //2. Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : productsList) {
            if (product != null) {
                totalCost = totalCost + product.getProductPrice();
            }
        }
        return totalCost;
    }

    //Метод получения количества специальных товаров
    public int getQuantityOfSpecialGoods() {
        int specialGoodsCount = 0;
        for (Product product : productsList) {
            if (product != null && product.isSpecial()) {
                specialGoodsCount++;
            }
        }
        return specialGoodsCount;
    }

    //3. Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает,
    // но печатает в консоль сообщение вида: <имя продукта>: <стоимость> и Итого: <общая стоимость корзины>
    public void getBasketContents() {
        for (Product product : productsList) {
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
    public boolean checkProductByName(String productName) {
        boolean result = false;
        if (productsMap.containsKey(productName)) {
            for (Product product : productsList) {
                if (product != null && product.getProductName().equals(productName)) {
                    result = true;
                    break;
                }
            }
        } else {
            System.out.println("Продукт не найден");
        }
        return result;
    }


    //5. Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        productsList.clear();
        productsMap.clear();
    }

    //Метод удаления продукта по имени из корзины-списка
    public List<Product> removeProductByNameFromBasket(String name) {
        Iterator<Product> iterator = productsList.iterator();
        List<Product> removedProductsList = new LinkedList<>();
        if (productsMap.containsKey(name)) {
            while (iterator.hasNext()) {
                Product element = iterator.next();
                if (element.getProductName().equals(name)) {
                    removedProductsList.add(element);
                    iterator.remove();
                }
            }
            if (removedProductsList.isEmpty()) {
                System.out.println("Список пуст");
            }
        } else {
            System.out.println("Корзина пуста");
        }
        return removedProductsList;
    }

}
