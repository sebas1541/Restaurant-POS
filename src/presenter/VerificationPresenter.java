package presenter;


import model.*;
import persistence.Persistence;
import views.mainviews.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**Presentador principal
 * Manejo de eventos de los elementos de la vista, conexion de modelo y vista
 * @author
 *     David Lotero
 *     Miguel Avila
 *     Sebastian Cañon*/

public class VerificationPresenter implements ActionListener {

    /**Referencias de clase
     *Definimos atributos con tipo de dato clase, para luego usarlos y
     * acceder a la informacion de dichas clases */
    private View view;
    private Persistence pr;
    private Inventory inv;
    private Order order;
    private HotDogManager hotDogManager;


    public VerificationPresenter() {
        initComponents();
        view.createPanelMainWindow(this);
    }

    public void initComponents() {
        view = new View(this);
        pr = new Persistence();
        inv = new Inventory();
        order = new Order(null);
        hotDogManager = new HotDogManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Administrador")) {
            /**Si se presiona el botón "Administrador", se crea un panel
             * para la verificacion de datos*/
            view.createPanelLogin(this);
        }
        if (e.getActionCommand().equals("Enviar")) {
            /**Si se presiona el botón "Submint", se comprueba si el usuario
             * y contraseña son correctos en el metodo dataVerification*/
            dataVerification();
        }
        if (e.getActionCommand().equals("Empleado")) {
            /**Si se presiona el botón "Empleado", se crea un panel
             * para solicitar la orden del cliente*/
            view.createOrderPanel(this);
        }
        if (e.getActionCommand().equals("Modificar")) {
            /**Al presionar "Modificar", se llama al metodo modifyInventory, el cual
             * el cual se encarga de dicha lavor*/
            modifyInventory();
            cargarDatos();
            view.getPanelInfoInventory().getjTable().revalidate();
            view.getPanelInfoInventory().getjTable().repaint();
            view.getPanelInfoInventory().repaint();
            view.getPanelInfoInventory().revalidate();
        }
        if (e.getActionCommand().equals("Volver")) {
            /**Al presionar "Volver", se creará la ventana principal, con el fin de
             * solicitar una nueva orden o volver a ingresar al inventario*/
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
        if (e.getActionCommand().equals("PERROS")){
            JOptionPane.showMessageDialog(null, hotDogManager.formatHotDogsForDisplay());
        }

        if (e.getActionCommand().equals("CANCELAR")){
            order = null;
            order = new Order(null);
            view.updateEntirePanel();
            view.createOrderPanel(this);
        }

        if (e.getActionCommand().equals("PAGAR")){
            JOptionPane.showMessageDialog(null, "Estas a punto de hacer el pago y terminar la órden.\n Una vez terminado el pago dale click a ok");
            printInvoice();
            view.updateEntirePanel();
            view.createOrderPanel(this);
            order = null;
            order = new Order(null);
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
        /**Asignacion del numero y nombre de las columnas de la tabla*/
        table.addColumn("Indice");
        table.addColumn("Ingrediente");
        table.addColumn("Cantidad");
        for (Ingredient ingr : inv.getIngredientList2()) {
            /**Creacion de un arreglo de objetos, el cual contiene la informacion
             * que se mostrará en cada una de las filas de la tabla*/
            Object[] fila = new Object[3];
            counter++;
            fila[0] = counter;
            fila[1] = ingr.getName();
            fila[2] = ingr.getQuantity();
            /**Asignacion del arreglo a las filas de la tabla */
            table.addRow(fila);
        }
        /**Metodo de la vista que solicita la tabla creada, y la almacena*/
        view.getPanelInfoInventory().updateTable(table);
    }


    /**Metodo para cargar los datos de un arreglo en una DefaulTableModel*/
    /**Lectura del archivo que contiene el usuario y contraseña del administrador*/
    public void dataVerification() {
        pr.crearPropertiesFile();
        String nombreUsuario = "";
        String password = "";
        nombreUsuario = view.user();
        /**Verificacion del nombre de usuario*/
        if (pr.getDatos().get(0).equals(nombreUsuario)) {
            password = view.password();
            /**Verificacion de contraseña*/
            if (pr.getDatos().get(1).equals(password)) {
                view.createPanelInventoryAdm(this);

            } else {
                view.notifyWarning("La clave ingresada es incorrecta");
            }
        } else {
            view.notifyWarning("Información incorrecta");
        }
    }

    /**Metodo para modificar el inventario
     *@exception NumberFormatException       puede romperce el programa si entra cualquier cosa
     * que no sea un entero*/
    public void modifyInventory() {
        int quantity=0;
        int option=0;
        try {
            option = Integer.parseInt(view.optionModify());
            quantity = Integer.parseInt(view.quantity());
            if(option>0 && option<=25) {
                inv.menu(option, quantity);
            }else{
                view.notifyWarning("Ingrese un numero entero valido");
            }

        }catch (NumberFormatException e){
            view.notifyWarning("Ingrese un numero entero valido");
        }
    }


    public void printInvoice(){
        pr.writeInvoiceToFile(order.textOrder());
    }

    public Order getOrder() {
        return order;
    }


}