import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.info.Article;
import org.skypro.skyshop.info.SearchEngine;
import org.skypro.skyshop.info.Searchable;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct product = new SimpleProduct("Название продукта", 0);
        SimpleProduct pear = new SimpleProduct("Груша", 100);
        DiscountedProduct grape = new DiscountedProduct("Виноград", 190, 10);
        SimpleProduct mango = new SimpleProduct("Манго", 300);
        SimpleProduct apple = new SimpleProduct("Яблоко", 80);
        SimpleProduct strawberry = new SimpleProduct("Клубника", 250);
        SimpleProduct cucumber = new SimpleProduct("Огурец", 160);

        // статьи
        Article article = new Article("Как понять, что манго сладкое?", "Лучшие манго этого сезона");
        Article article1 = new Article("Груша - чем полезна?", "Одна груша - доктор не нужен");

        // поисковой движок
        SearchEngine searchEngine = new SearchEngine(10);

        // продукты для поиска
        searchEngine.add(product);
        searchEngine.add(pear);
        searchEngine.add(grape);
        searchEngine.add(mango);
        searchEngine.add(apple);
        searchEngine.add(strawberry);
        searchEngine.add(cucumber);
        searchEngine.add(article);
        searchEngine.add(article1);

        // проверка поиска
        String searchRequest = "Манго";
        Searchable[] searchResults = searchEngine.search(searchRequest);

        // вывод
        System.out.println("Результаты поиска: " + searchRequest);
        for (Searchable result : searchResults) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        Product[] productsBasket;
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product);

        //добавление продукта в корзину
        System.out.println("1. Добавление продукта в корзину");
        basket.addProduct(pear);
        basket.addProduct(grape);
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