import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderManager {
    private List<Product> products;

    public OrderManager(List<Product> products) {
        this.products = products;
    }

    public void sortProducts() {
        Collections.sort(products, Comparator
                .comparing(Product::calculateTotalPrice)
                .thenComparing(Product::getName)
                .thenComparing(Product::getQuantity));
    }

    public List<Product> getProducts() {
        return products;
    }
}
