import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class ECommerceSearch {

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId)
                return mid;
            else if (products[mid].productId < targetId)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Exercise 2: E-commerce Search ===");

        Product[] products = {
                new Product(103, "T-shirt", "Fashion"),
                new Product(101, "Keyboard", "Electronics"),
                new Product(104, "Shoes", "Fashion"),
                new Product(102, "Mouse", "Electronics")
        };

        int targetId = 104;

        int linearIndex = linearSearch(products, targetId);
        if (linearIndex != -1)
            System.out.println("Linear Search: Found -> " + products[linearIndex]);
        else
            System.out.println("Linear Search: Product not found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int binaryIndex = binarySearch(products, targetId);
        if (binaryIndex != -1)
            System.out.println("Binary Search: Found -> " + products[binaryIndex]);
        else
            System.out.println("Binary Search: Product not found");
    }
}
