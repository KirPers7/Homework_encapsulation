package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();

        //1. Добавление продукта в корзину.
        System.out.println("Заполнение корзины 1");
        productBasket.addProduct(new SimpleProduct("Телевизор", 50_000));
        productBasket.addProduct(new SimpleProduct("Холодильник", 60_000));
        productBasket.addProduct(new DiscountedProduct("Аэрогриль", 5_200, 10));
        productBasket.addProduct(new FixPriceProduct("Фонарик"));
        System.out.println();
        System.out.println("Заполнение корзины 2");
        productBasket2.addProduct(new SimpleProduct("Пылесос", 30_500));
        productBasket2.addProduct(new SimpleProduct("Телевизор", 50_000));
        productBasket2.addProduct(new SimpleProduct("Холодильник", 60_000));
        productBasket2.addProduct(new SimpleProduct("Мультиварка", 15_800));
        productBasket2.addProduct(new SimpleProduct("Яндекс станция", 12_300));
        System.out.println();

        //2. Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("Переполнение корзины 2");
        productBasket2.addProduct(new SimpleProduct("Микроволновая печь", 25_100));
        System.out.println();

        //3. Печать содержимого корзины с несколькими товарами.
        System.out.println("Содержимое корзины 1:");
        productBasket.getBasketContents();
        System.out.println();
        System.out.println("Содержимое корзины 2:");
        productBasket2.getBasketContents();
        System.out.println();

        //4. Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость сожержимого корзины: " + productBasket.getTotalCost());
        System.out.println();

        //5. Поиск товара, который есть в корзине.
        System.out.println("В наличии: " + productBasket.checkProductByName("Холодильник"));
        System.out.println();

        //6. Поиск товара, которого нет в корзине.
        System.out.println("В наличии: " + productBasket.checkProductByName("Пылесос"));
        System.out.println();

        //7. Очистка корзины.
        System.out.println("Очистка корзины.");
        productBasket.clearBasket();
        System.out.println();

        //8. Печать содержимого пустой корзины.
        System.out.println("Печать содержимого пустой корзины.");
        productBasket.getBasketContents();
        System.out.println();

        //9. Получение стоимости пустой корзины.
        System.out.println("Получение стоимости пустой корзины.");
        System.out.println("Стоимость сожержимого корзины: " + productBasket.getTotalCost());
        System.out.println();

        //10. Поиск товара по имени в пустой корзине.
        System.out.println("Поиск товара по имени в пустой корзине.");
        System.out.println(productBasket.checkProductByName("Холодильник"));
    }
}