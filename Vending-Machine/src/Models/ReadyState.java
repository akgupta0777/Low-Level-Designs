package Models;

import Constants.Coins;
import Constants.Notes;
import Interfaces.VendingMachineState;

public class ReadyState implements VendingMachineState {
    public final VendingMachine vendingMachine;

    public ReadyState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("Product already selected, Discard selected product first.");
    }

    @Override
    public void insertCoin(Coins coin){
        vendingMachine.addCoin(coin);
        System.out.println(coin.name()+" coin inserted with value of "+coin.getValue());
        System.out.println("Balance remaining : "+ (vendingMachine.getSelectedProduct().getProductPrice()-vendingMachine.getTotalPayment()));
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Notes note){
        vendingMachine.addNote(note);
        System.out.println(note.name()+" note inserted with value of "+note.getValue());
        System.out.println("Balance remaining : "+ (vendingMachine.getSelectedProduct().getProductPrice()- vendingMachine.getTotalPayment()));
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }

    public void checkPaymentStatus(){
        if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getProductPrice()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }
}
