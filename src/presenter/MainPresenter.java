package presenter;


import model.Inventory;
import persistence.Persistence;

import views.mainviews.LogInView;
import views.mainviews.View;
import views.mainviews.ViewAdministrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPresenter implements ActionListener {
    protected View view;
    protected Persistence pr;
    protected Inventory inv;

    protected ViewAdministrator viewAdm;
    protected LogInView viewLogin;


    public MainPresenter() {
        view = new View(this);
        pr = new Persistence();
        inv=new Inventory();
        viewAdm = new ViewAdministrator(this);
        viewLogin = new LogInView(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}