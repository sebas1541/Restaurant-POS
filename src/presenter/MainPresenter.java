package presenter;


import views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPresenter implements ActionListener {
    private View view;
    public MainPresenter(){
        view = new View(this);
        view.createPanelLogin(this);
    }
    public void run(){

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Administrador")) {
            view.createPanelLV(this);
        }
        if(e.getActionCommand().equals("Empleado")){

        }
        if(e.getActionCommand().equals("Submit")) {
            view.createPanelInventoryAdm(this);
        }
    }
}