
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;
    
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerce {
    private ArrayList<Product> products; 
    private ArrayList<Product> sortedProducts; 

    public ECommerce() {
        products = new ArrayList<>();
        sortedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        // Maintain sorted array for binary search (by productId)
        sortedProducts.add(product);
        Collections.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));
    }
    
    public Product linearSearch(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
    public Product binarySearch(int productId) {
        int left = 0;
        int right = sortedProducts.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = sortedProducts.get(mid).getProductId();

            if (midId == productId) {
                return sortedProducts.get(mid);
            } else if (midId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ECommerce searchEngine = new ECommerce();

        Product[] sampleProducts = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Headphones", "Electronics"),
                new Product(103, "T-Shirt", "Clothing"),
                new Product(104, "Sneakers", "Footwear")
        };

        for (Product product : sampleProducts) {
            searchEngine.addProduct(product);
        }

        Product result = searchEngine.linearSearch(102);
        System.out.println("Linear Search Result: " + (result != null ? result : "Not found"));
        result = searchEngine.binarySearch(103);
        System.out.println("Binary Search Result: " + (result != null ? result : "Not found"));
    }
}
