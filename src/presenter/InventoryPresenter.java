package presenter;
import java.awt.event.ActionEvent;

public class InventoryPresenter extends MainPresenter {

    public void modifyInventory() {
        inv.menu(Integer.parseInt(viewAdm.optionModify()), Integer.parseInt(viewAdm.quantity()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Modificar")) {
            modifyInventory();
        }
        if (e.getActionCommand().equals("Volver")) {
            view.createPanelLogin(this);
        }

    }
}