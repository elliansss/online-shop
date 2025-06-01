import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.info.SearchEngine;
import org.skypro.skyshop.info.Searchable;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.info.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFoundException {
        SimpleProduct product = new SimpleProduct("Название продукта", 1);
        SimpleProduct pear = new SimpleProduct("Груша", 100);
        DiscountedProduct grape = new DiscountedProduct("Виноград", 190, 10);
        SimpleProduct mango = new SimpleProduct("Манго", 300);
        SimpleProduct apple = new SimpleProduct("Яблоко", 80);
        SimpleProduct strawberry = new SimpleProduct("Клубника", 250);
        SimpleProduct cucumber = new SimpleProduct("Огурец", 160);
        SimpleProduct fish = null;
        try {
            fish = new SimpleProduct(" ", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ProductBasket productList = new ProductBasket();
        productList.addProduct(product);
        productList.addProduct(pear);
        productList.addProduct(grape);
        productList.addProduct(mango);
        productList.addProduct(apple);
        productList.addProduct(strawberry);
        productList.addProduct(cucumber);
        if (fish != null) {
            productList.addProduct(fish);
        }

        productList.printBasket();

        // удаление существующего продукта
        List<Product> removed = productList.removeProductByName("Клубника");
        System.out.println("Удалено продуктов: " + removed);
        productList.printBasket();

        // удаление несуществующего продукта
        List<Product> removedNonExistent = productList.removeProductByName("Апельсин");
        System.out.println("Удалено продуктов (Апельсин): " + removedNonExistent);
        if (removedNonExistent.isEmpty()) {
            System.out.println("Список пуст");
        }
        productList.printBasket();
        productList.clearBasket();
        System.out.println("Корзина очищена.");
        productList.printBasket();


        int totalPrice = productList.getTotalPrice();
        System.out.println("Общая стоимость: " + totalPrice);

        // статьи
        Article article = new Article("Как понять, что манго сладкое?", "Лучшие манго этого сезона");
        Article article1 = new Article("Груша - чем полезна?", "Одна груша - доктор не нужен");

        // продукты для поиска
        List<Product> allProducts = new ArrayList<>();
        SearchEngine searchEngine = new SearchEngine(allProducts);
        searchEngine.add(pear);
        searchEngine.add(grape);
        searchEngine.add(mango);
        Searchable searchResults = searchEngine.searchWord("манго");
        System.out.println("Результаты поиска (манго): " + searchResults);


        Product[] productsBasket;
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product);

        //добавление продукта в корзину
        System.out.println("1. Добавление продукта в корзину");
        basket.addProduct(pear);
        basket.addProduct(fish);
        basket.addProduct(mango);
        basket.printBasket();
        System.out.println();

        //заполненная корзина
        System.out.println("2. Заполненная корзина, добавление продуктов");
        basket.addProduct(strawberry);
        basket.addProduct(apple);
        basket.addProduct(cucumber);
        basket.printBasket();
        System.out.println();

        //печать содержимого
        System.out.println("3. Печать содержимого корзины с несколькими товарами");
        basket.printBasket();
        System.out.println();

        // получение стоимости корзины с несколькими товарами
        System.out.println("4. Получение стоимости корзины с несколькими товарами:");
        System.out.println("Итого: " + basket.getTotalPrice());
        System.out.println();

        //поиск товара в корзине
        System.out.println("5. Поиск товара в корзине");
        System.out.println("В корзине есть манго " + basket.containsProduct("Манго"));
        System.out.println();

        //поиск отсутствующего товара в корзине
        System.out.println("6. Поиск товара, которого нет в корзине");
        System.out.println("В корзине есть огурец " + basket.containsProduct("Огурец"));
        System.out.println();

        //очистка корзины
        System.out.println("7. Очистка корзины");
        basket.clearBasket();
        System.out.println();

        //печать содержимого пустой корзины
        System.out.println("8. Печать содержимого пустой корзины:");
        basket.printBasket();
        System.out.println();

        //получение стоимости пустой корзины
        System.out.println("9. Получение стоимости пустой корзины:");
        System.out.println("Итого: " + basket.getTotalPrice());
        System.out.println();

        // поиск товара по имени в пустой корзине
        System.out.println("10. Поиск товара по имени в пустой корзине:");
        System.out.println("В корзине есть яблоко: " + basket.containsProduct("Яблоко"));
    }
}