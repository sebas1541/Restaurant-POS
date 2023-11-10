package presenter;

import model.Ingredient;
import model.Inventory;
import views.InventoryView;

public class InventoryPresenter {
    private Inventory  in;
    private InventoryView io;
    public InventoryPresenter(){
        in = new Inventory();
        io = new InventoryView();
    }
    public void menu(){
        int opt=0;
        do {
            opt=io.readMenu();
            switch (opt){
                case 1:in.modifyQuantityIngredients("Pan",io.readInt("Ingrese la cantidad"));
                    break;
                case 2:in.modifyQuantityIngredients("Salchicha",io.readInt("Ingrese la cantidad"));
                    break;
                case 3:in.modifyQuantityIngredients("Cebolla",io.readInt("Ingrese la cantidad"));
                    break;
                case 4:in.modifyQuantityIngredients("Tomate",io.readInt("Ingrese la cantidad"));
                    break;
                case 5:in.modifyQuantityIngredients("Papas Cabello de Angel",io.readInt("Ingrese la cantidad"));
                    break;
                case 6:in.modifyQuantityIngredients("Jalapenos",io.readInt("Ingrese la cantidad"));
                    break;
                case 7:in.modifyQuantityIngredients("Tostacos",io.readInt("Ingrese la cantidad"));
                    break;
                case 8:in.modifyQuantityIngredients("Pepinillos",io.readInt("Ingrese la cantidad"));
                    break;
                case 9:in.modifyQuantityIngredients("Salsa de Tomate",io.readInt("Ingrese la cantidad"));
                    break;
                case 10:in.modifyQuantityIngredients("Salsa BBQ",io.readInt("Ingrese la cantidad"));
                    break;
                case 11:in.modifyQuantityIngredients("Salsa Rosada",io.readInt("Ingrese la cantidad"));
                    break;
                case 12:in.modifyQuantityIngredients("Salsa de Pina",io.readInt("Ingrese la cantidad"));
                    break;
                case 13:in.modifyQuantityIngredients("Mostaza",io.readInt("Ingrese la cantidad"));
                    break;
                case 14:in.modifyQuantityIngredients("Salsa Tartara",io.readInt("Ingrese la cantidad"));
                    break;
                case 15:in.modifyQuantityIngredients("Salsa Mayo Mostaza",io.readInt("Ingrese la cantidad"));
                    break;
                case 16:in.modifyQuantityIngredients("Mayonesa",io.readInt("Ingrese la cantidad"));
                    break;
                case 17:in.modifyQuantityIngredients("Huevo Codorniz",io.readInt("Ingrese la cantidad"));
                    break;
                case 18:in.modifyQuantityIngredients("Pina",io.readInt("Ingrese la cantidad"));
                    break;
                case 19:in.modifyQuantityIngredients("Maiz Tierno",io.readInt("Ingrese la cantidad"));
                    break;
                case 20:in.modifyQuantityIngredients("Queso Derretido",io.readInt("Ingrese la cantidad"));
                    break;
                case 21:in.modifyQuantityIngredients("Queso Chedar",io.readInt("Ingrese la cantidad"));
                    break;
                case 22:in.modifyQuantityIngredients("Pollo",io.readInt("Ingrese la cantidad"));
                    break;
                case 23:in.modifyQuantityIngredients("Tocineta",io.readInt("Ingrese la cantidad"));
                    break;
                case 24:in.modifyQuantityIngredients("Chile con Carne",io.readInt("Ingrese la cantidad"));
                    break;
                case 25:in.modifyQuantityIngredients("Pepperoni",io.readInt("Ingrese la cantidad"));
                    break;
                case 26:io.showMessage("Modificaciones realizadas");
                    break;
            }
        }while (opt!=26);
    }
}
