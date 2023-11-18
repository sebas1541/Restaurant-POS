package presenter;


import model.Inventory;
import persistence.Persistence;

import views.mainviews.Login;
import views.mainviews.MainWindow;
import views.mainviews.View;
import views.mainviews.ViewAdministrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPresenter implements ActionListener{
    protected View view;
    protected Persistence pr;
    protected Inventory inv;
    protected ViewAdministrator viewAdm;
    protected Login viewLogin;
    protected MainWindow mainWindow;

    public MainPresenter() {
        view = new View(this);
        pr = new Persistence();
        inv=new Inventory();
        viewAdm = new ViewAdministrator(this);
        viewLogin = new Login(this);
        mainWindow = new MainWindow(this);
        view.createPanelMainWindow(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}