package Services;

import Models.Product;
import Models.VendingMachine;

public class VendingMachineService {
    private final VendingMachine vendingMachine = VendingMachine.getInstance();

    public VendingMachineService(){
    }
    
    public void addProduct(Product product, int qty){
        vendingMachine.getInventory().addProduct(product,qty);
        System.out.println("Product added :"+product.getProductName() + " with quantity "+qty);
    }

    public void selectProduct(Product product){
        if(!vendingMachine.getInventory().isAvailable(product)){
            System.out.println("Product :" + product.getProductName() + " is unavailable.");
            return ;
        }
        vendingMachine.setSelectedProduct(product);

    }
}
