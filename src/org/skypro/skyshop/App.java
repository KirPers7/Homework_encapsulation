package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.search.Article;
import org.skypro.skyshop.product.search.BestResultNotFound;
import org.skypro.skyshop.product.search.SearchEngine;
import org.skypro.skyshop.product.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

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
        System.out.println();

        Article article1 = new Article("Техника для кухни", "На современной кухне много приборов в помощь кулинарам");
        Article article2 = new Article("Медиа техника", "Практически в каждом доме можно увидеть какой-то траслятор" +
                "изображени и/или звука");
        Article article3 = new Article("Техника для наведения чистоты", "Пылесосы, стиральные машины, утюги");
        Article article4 = new Article("Туризм и рыбалка", "Фонарики, компасы, часы, барометры, эхолоты");
        Article article5 = new Article("Туризм и рыбалка 2", "Скутеры, лодки");
        Article article6 = new Article("Техника для кухни 2 (техника)", "Аэрогрили, тостеры, микроволновые печи");
        Product product1 = new SimpleProduct("Телевизор", 50_000);
        Product product2 = new SimpleProduct("Холодильник (кухня)", 60_000);
        Product product3 = new DiscountedProduct("Аэрогриль (кухня)", 5_200, 10);
        Product product4 = new FixPriceProduct("Фонарик");
        Product product5 = new SimpleProduct("Пылесос", 30_500);
        Product product6 = new SimpleProduct("Телевизор", 50_000);
        Product product7 = new SimpleProduct("Холодильник 2 (кухня)", 62_000);
        Product product8 = new SimpleProduct("Мультиварка (кухня)", 15_800);
        Product product9 = new SimpleProduct("Яндекс станция", 12_300);


        SearchEngine searchEngine = new SearchEngine(20);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);
        searchEngine.add(article6);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(product7);
        searchEngine.add(product8);
        searchEngine.add(product9);

        System.out.println("Весь список результатов поиска:");
        List<Searchable> searchResults = searchEngine.search("кухн");

        for (Searchable searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println(searchResult.getStringRepresentation());
            }
        }
        System.out.println();

        try {
            new SimpleProduct("Кофемолка", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new DiscountedProduct("Сигвей", -5000, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new DiscountedProduct("Сигвей", 12_000, 105);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();


        System.out.println(searchEngine.getMostSuitableOfIdenticalPhrases("техн").getStringRepresentation());
        System.out.println();

        try {
            searchEngine.getMostSuitableOfIdenticalPhrases("свет");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        productBasket2.getBasketContents();
        System.out.println();
        System.out.println("Удаление продукта из корзины по наименованию");
        System.out.println(productBasket2.removeProductByNameFromBasket("Холодильник"));
        System.out.println();
        System.out.println("Удаление несуществующего продукта из корзины по наименованию");
        productBasket2.removeProductByNameFromBasket("Холодильник");
        System.out.println();
        productBasket2.getBasketContents();
    }
}