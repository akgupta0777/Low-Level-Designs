package Models;

public class Product {
    private final String productName;
    private final int productPrice;

    public Product(String name,int price){
        productName = name;
        productPrice = price;
    }

    public String getProductName(){
        return productName;
    }

    public int getProductPrice(){
        return productPrice;
    }
}
