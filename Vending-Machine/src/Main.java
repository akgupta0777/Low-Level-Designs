import Models.Product;
import Services.VendingMachineService;

public class Main {
    public static void main(String[] args) {
        VendingMachineService service = new VendingMachineService();
        Product coke = new Product("Coca Cola",40);
        Product kitkat = new Product("Kit-Kat",50);
        Product lays = new Product("Lays Magic Masala",20);

        service.addProduct(coke,10);
        service.addProduct(kitkat,20);
        service.addProduct(lays,30);

        service.selectProduct(coke);

    }
}