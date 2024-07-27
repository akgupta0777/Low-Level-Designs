package Interfaces;

import Constants.Coins;
import Constants.Notes;
import Models.Product;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coins coin);
    void insertNote(Notes note);
    void dispenseProduct();
    void returnChange();
}
