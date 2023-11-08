package presenter;

import model.Inventory;

public class Run {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.splitIngredients();
        inv.totalDatos();
    }
}
