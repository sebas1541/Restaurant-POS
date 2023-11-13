package presenter;

import model.Inventory;
import persistence.Persistence;

public class Run {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Persistence persistence = new Persistence();
        inv.splitIngredients(persistence);
        inv.totalDatos();
    }
}
