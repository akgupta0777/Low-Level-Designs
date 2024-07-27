package Models;

import Constants.Coins;
import Interfaces.VendingMachineState;

public class ReadyState implements VendingMachineState {
    public final VendingMachine vendingMachine;

    public ReadyState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    public void selectProduct(Product product){
        System.out.println("Product already selected, Discard selected product first.");
    }

    public void insertCoin(Coins coin){
        vendingMachine.addCoin(coin);
        System.out.println(coin.name()+" coin inserted with value of "+coin.getValue());
        System.out.println("Balance remaining : "+ (vendingMachine.getSelectedProduct().getProductPrice()-vendingMachine.getTotalPayment()));
        checkPaymentStatus();
    }
}
