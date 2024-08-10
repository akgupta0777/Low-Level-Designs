package Models;

import Constants.Coins;
import Constants.Notes;
import Interfaces.VendingMachineState;

public class VendingMachine {
    private static VendingMachine instance = null;
    private final Inventory inventory;
    private Product selectedProduct;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private double totalPayment;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
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

    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void setSelectedProduct(Product product){
        selectedProduct = product;
    }

    public Product getSelectedProduct(){
        return this.selectedProduct;
    }

    public void setCurrentState(VendingMachineState state){
        currentState = state;
    }

    public void insertCoin(Coins coin){
        currentState.insertCoin(coin);
    }

    public void insertNote(Notes note){
        currentState.insertNote(note);
    }

    public void addCoin(Coins coin){
        totalPayment+=coin.getValue();
    }

    public void addNote(Notes note){
        totalPayment+=note.getValue();
    }

    public double getTotalPayment(){
        return this.totalPayment;
    }

    public double getChange(){
        return this.getTotalPayment()-this.getSelectedProduct().getProductPrice();
    }

    public VendingMachineState getIdleState(){
        return this.idleState;
    }

    public VendingMachineState getReadyState(){
        return this.readyState;
    }

    public VendingMachineState getDispenseState(){
        return this.dispenseState;
    }

    public VendingMachineState getReturnChangeState(){
        return this.returnChangeState;
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public void returnChange(){
        currentState.returnChange();
    }
}
