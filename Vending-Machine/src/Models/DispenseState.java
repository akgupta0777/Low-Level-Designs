package Models;

import Constants.Coins;
import Constants.Notes;
import Interfaces.VendingMachineState;

public class DispenseState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected! Please collect the product.");
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Payment already made! Please collect the product.");
    }

    @Override
    public void insertNote(Notes note) {
        System.out.println("Payment already made! Please collect the product.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().updateQuantity(product,vendingMachine.getInventory().getQuantity(product)-1);
        System.out.println("Product "+product.getProductName()+" dispensed. Please collect it.");
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect change after collecting the product.");
    }
}
