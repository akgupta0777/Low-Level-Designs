package Models;

import Constants.Coins;
import Constants.Notes;
import Interfaces.VendingMachineState;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already dispensed! Please collect change(if any)");
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Payment already done. No need to put additional money.");
    }

    @Override
    public void insertNote(Notes note) {
        System.out.println("Payment already done. No need to put additional money.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product is already dispensed...");
    }

    @Override
    public void returnChange() {
        double remainingChange = vendingMachine.getChange();
        if(remainingChange>0){
            System.out.println("Please collect "+remainingChange+" from the machine.");
        }
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
