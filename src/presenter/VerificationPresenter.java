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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Administrador")) {
            view.createPanelLogin(this);
        }
        if (e.getActionCommand().equals("Enviar")) {
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
            view.getOrderView().addHotdogItem("CLASICO", "$12.500", "1");
            showOrderTotal();

            view.updateEntirePanel();
        }
        if (e.getActionCommand().equals("DOGZILLA")){
            order.addHotDog(2);
            view.getOrderView().addHotdogItem("DOGZILLA", "$16.500", "1");
            showOrderTotal();
        }

        if (e.getActionCommand().equals("MEXICANO")){
            order.addHotDog(3);
            view.getOrderView().addHotdogItem("MEXICANO", "$15.500", "1");
            showOrderTotal();
        }
        if (e.getActionCommand().equals("COLOMBIANO")){
            order.addHotDog(4);
            view.getOrderView().addHotdogItem("COLOMBIANO", "$14.900", "1");
            showOrderTotal();
        }
        if (e.getActionCommand().equals("HAWAIANO")){
            order.addHotDog(5);
            view.getOrderView().addHotdogItem("HAWAIANO", "$14.900", "1");
            showOrderTotal();
        }

        if (e.getActionCommand().equals("ITALIANO")){
            order.addHotDog(6);
            view.getOrderView().addHotdogItem("ITALIANO", "$14.900", "1");
            showOrderTotal();
        }
        if (e.getActionCommand().equals("DESGRANADO")){
            order.addHotDog(7);
            view.getOrderView().addHotdogItem("DESGRANADO", "$14.900", "1");
            showOrderTotal();
        }
        if (e.getActionCommand().equals("CONFIRMAR")){
            view.createPaymentPanel(this);
            updatePaymentView();
            view.updateEntirePanel();
        }
        if (e.getActionCommand().equals("INICIO")){
            view.createPanelMainWindow(this);
        }

        if (e.getActionCommand().equals("ORDEN")){
            view.createOrderPanel(this);
        }
        if (e.getActionCommand().equals("ADMIN")){
            view.createPanelLogin(this);
        }



        showOrderTotal();
    }



    private void updatePaymentView() {
        view.getPaymentView().getDogItems().setText(order.showDogs());
        view.getPaymentView().getDogPrices().setText(order.showDogPrice());
        view.getPaymentView().getSubTotal().setText(String.valueOf(order.sum_Price()));
        view.getPaymentView().getTax().setText(String.valueOf(order.getConsumption_Tax()));
        view.getPaymentView().getTotal().setText(String.valueOf(order.total_price()));
    }


    public void showOrderTotal(){
        System.out.println(order.total_price());
        view.getOrderView().updateRightPanel(order.total_price(), order.getConsumption_Tax());

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

        view.getPanelInfoInventory().updateTable(table);
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


    public Order getOrder() {
        return order;
    }

    public ViewAdministrator getViewAdm() {
        return viewAdm;
    }
}