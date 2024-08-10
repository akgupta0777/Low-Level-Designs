package Models;

import Constants.Coins;
import Constants.Notes;
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
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        System.out.println("Product : "+product.getProductName()+" is selected.");
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Please select product first.");
    }

    @Override
    public void insertNote(Notes note) {
        System.out.println("Please select product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select product first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select product first.");
    }
}
