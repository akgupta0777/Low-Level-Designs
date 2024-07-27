package Models;

import Constants.Coins;
import Interfaces.VendingMachineState;

public class VendingMachine {
    private static VendingMachine instance = null;
    private final Inventory inventory;
    private Product selectedProduct;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final vendingMachineState currentState;
    private double totalPayment;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        currentState = idleState;
        totalPayment = 0.0;
    }

    public static VendingMachine getInstance(){
        if(instance == null){
            synchronized (VendingMachine.class){
                if(instance == null){
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setSelectedProduct(Product product){
        selectedProduct = product;
    }

    public void setCurrentState(vendingMachineState state){
        currentState = state;
    }

    public void addCoin(Coins coin){
        totalPayment+=coin.getValue();
    }

}
