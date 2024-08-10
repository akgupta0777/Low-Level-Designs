package Models;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product,Integer> products;

    public Inventory(){
        products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product,int qty){
        products.put(product,products.getOrDefault(product,0)+qty);
    }

    public boolean isAvailable(Product product){
        return products.containsKey(product) && products.get(product)>0;
    }

    public void updateQuantity(Product product,int quantity){
        products.put(product,quantity);
    }

    public int getQuantity(Product product){
        return products.get(product);
    }
}
