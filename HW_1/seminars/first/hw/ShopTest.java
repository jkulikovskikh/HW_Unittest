package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {
        /**
         1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
         2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
         3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
         */
        checkingProductList();
    }
    public static void checkingProductList() {
        Shop products = new Shop();
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setCost(100);
        product1.setTitle("Молоко");
        productList.add(product1);

        Product product2 = new Product();
        product2.setCost(50);
        product2.setTitle("Хлеб");
        productList.add(product2);

        Product product3 = new Product();
        product3.setCost(150);
        product3.setTitle("Бананы");
        productList.add(product3);

        products.setProducts(productList);

        /**
         * Проверки, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
         */
        assertThat(products.getProducts().size()).isEqualTo(3);
        assertThat(products.getProducts().get(0).getTitle()).isEqualTo("Молоко");
        assertThat(products.getProducts().get(0).getCost()).isEqualTo(100);
        assertThat(products.getProducts().get(1).getTitle()).isEqualTo("Хлеб");
        assertThat(products.getProducts().get(1).getCost()).isEqualTo(50);
        assertThat(products.getProducts().get(2).getTitle()).isEqualTo("Бананы");
        assertThat(products.getProducts().get(2).getCost()).isEqualTo(150);

        /**
         * Проверка, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
         */
        assertThat(products.getMostExpensiveProduct().getTitle()).isEqualTo("Бананы");
        assertThat(products.getMostExpensiveProduct().getCost()).isEqualTo(150);

        /**
         * Проверка, что магазин возвращает верный отсортированный по цене список продуктов
         */
        assertThat(products.getSortedListProducts().get(0).getTitle()).isEqualTo("Хлеб");
        assertThat(products.getSortedListProducts().get(0).getCost()).isEqualTo(50);
        assertThat(products.getSortedListProducts().get(1).getTitle()).isEqualTo("Молоко");
        assertThat(products.getSortedListProducts().get(1).getCost()).isEqualTo(100);
        assertThat(products.getSortedListProducts().get(2).getTitle()).isEqualTo("Бананы");
        assertThat(products.getSortedListProducts().get(2).getCost()).isEqualTo(150);
    }
}









