import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Название продукта", 0);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product);

        Product[] productsBasket;

        Product pear = new Product("Груша", 100);
        Product grape = new Product("Виноград", 190);
        Product mango = new Product("Манго", 300);
        Product apple = new Product("Яблоко", 80);
        Product strawberry = new Product("Клубника", 250);
        Product cucumber = new Product("Огурец", 160);

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
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());
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
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());
        System.out.println();

        // поиск товара по имени в пустой корзине
        System.out.println("10. Поиск товара по имени в пустой корзине:");
        System.out.println("В корзине есть яблоко: " + basket.containsProduct("Яблоко"));
    }
}