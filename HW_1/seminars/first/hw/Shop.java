package seminars.first.hw;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        Comparator<Product> compareByCost = new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getCost()- p2.getCost();
            }
        };
        Collections.sort(products, compareByCost);
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product expensiveProduct = null;
        for (Product product: products) {
            if (expensiveProduct == null || expensiveProduct.getCost() < product.getCost()) {
                expensiveProduct = product;
            }
        }
        return expensiveProduct;
    }
}