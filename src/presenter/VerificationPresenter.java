package presenter;


import model.Ingredient;
import model.Inventory;
import model.Order;
import persistence.Persistence;
import views.mainviews.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VerificationPresenter implements ActionListener {
    private View view;
    private Persistence pr;
    private Inventory inv;
    private ViewAdministrator viewAdm;
    private Login viewLogin;
    private MainWindow mainWindow;
    private Order order;
    private OrderView orderView;


    public VerificationPresenter() {
        initComponents();
        view.createPanelMainWindow(this);

    }

    public void initComponents() {
        view = new View(this);
        pr = new Persistence();
        inv = new Inventory();
        viewAdm = new ViewAdministrator(this);
        viewLogin = new Login(this);
        mainWindow = new MainWindow(this);
        order = new Order(null);
        orderView = new OrderView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Administrador")) {
            view.createPanelLogin(this);
        }
        if (e.getActionCommand().equals("Submit")) {
            dataVerification();
        }
        if (e.getActionCommand().equals("Empleado")) {
            view.createOrderPanel(this);
        }
        if (e.getActionCommand().equals("Modificar")) {
            modifyInventory();
        }
        if (e.getActionCommand().equals("Volver")) {
            view.createPanelMainWindow(this);

        }

        if (e.getActionCommand().equals("CLASICO")){
            order.addHotDog(1);
            orderView.getItemSummaryItemName().setText("Puta");
            showOrderTotal();


        }
        if (e.getActionCommand().equals("DOGZILLA")){
            order.addHotDog(2);
        }

        if (e.getActionCommand().equals("MEXICANO")){
            order.addHotDog(3);
        }
        if (e.getActionCommand().equals("COLOMBIANO")){
            order.addHotDog(4);
        }
        if (e.getActionCommand().equals("HAWAIANO")){
            order.addHotDog(5);
        }

        if (e.getActionCommand().equals("ITALIANO")){
            order.addHotDog(6);
        }
        if (e.getActionCommand().equals("DESGRANADO")){
            order.addHotDog(7);
        }
        if (e.getActionCommand().equals("CONFIRMAR")){
            view.createPaymentPanel(this);
        }

        showOrderTotal();
    }



    public void showOrderTotal(){
        orderView.updateRightPanel(order.total_price());
        System.out.println(order.total_price());
    }









    public void cargarDatos() {
        DefaultTableModel table = new DefaultTableModel();
        int counter=0;
        inv.splitIngredients();
        table.addColumn("Indice");
        table.addColumn("Ingrediente");
        table.addColumn("Cantidad");
        for (Ingredient ingr : inv.getIngredientList()) {
            Object[] fila = new Object[3];
            counter++;
            fila[0] = counter;
            fila[1] = ingr.getName();
            fila[2] = ingr.getQuantity();
            table.addRow(fila);
        }

        viewAdm.updateTable(table);
    }

    public void dataVerification() {
        pr.crearPropertiesFile();
        String nombreUsuario = "";
        String password = "";
        nombreUsuario = view.user();
        if (pr.getDatos().get(0).equals(nombreUsuario)) {
            password = view.password();
            if (pr.getDatos().get(1).equals(password)) {
                view.createPanelInventoryAdm(this);
            } else {
                view.notifyWarning("La clave ingresada es incorrecta");
            }
        } else {
            view.notifyWarning("Información incorrecta");
        }
    }

    public void modifyInventory() {
        inv.menu(Integer.parseInt(view.optionModify()), Integer.parseInt(view.quantity()));
    }

    public ViewAdministrator getViewAdm() {
        return viewAdm;
    }
}