package presenter;
import model.Ingredient;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InventoryPresenter extends MainPresenter {

    public void modifyInventory() {
        inv.menu(Integer.parseInt(view.optionModify()), Integer.parseInt(view.quantity()));
    }
    public DefaultTableModel ingredientsData(){
        DefaultTableModel table = viewAdm.getTable();
        inv.splitIngredients();
        table.setRowCount(0);
        for (Ingredient ingr : inv.getIngredientList()) {
            Object[] fila = {ingr.getName(), ingr.getQuantity()};
            table.addRow(fila);
        }
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Modificar")) {
            ingredientsData();
            modifyInventory();
        }
        if (e.getActionCommand().equals("Volver")) {
            view.createPanelLogin(this);
        }

    }
}