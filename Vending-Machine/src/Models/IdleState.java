package Models;

import Interfaces.VendingMachineState;

public class IdleState implements VendingMachineState {
    public final VendingMachine vendingMachine;

    public IdleState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    public void selectProduct(Product product){
        if(!vendingMachine.getInventory().isAvailable(product)){
            System.out.println("Product : "+product.getProductName()+" isn't available.");
            return ;
        }
        vendingMachine.setSelectedProduct(product);
        vendingMachine.setCurrentState(readyState);
        System.out.println("Product : "+product.getProductName()+" is selected.");
    }
}
