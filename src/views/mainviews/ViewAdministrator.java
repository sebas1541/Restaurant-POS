package views.mainviews;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
/**Clase donde se maneja la actualizacion de las cantidades
 * de los productos existentes en el inventario
 * * @author
 * *     David Lotero
 * *     Miguel Avila
 * *     Sebastian Cañon*/
public class ViewAdministrator extends JPanel {
    /**
     * Definicion de atributos del panel de inventario
     */
    private JTable jTable;
    private JLabel labelOptionToModify;
    private JTextField optionToModify;
    private JLabel quantityLabel;
    private JTextField quantity;
    private JButton modify;
    private JButton goBack;
    private JLabel title;
    private GridBagConstraints gbc;
    private JScrollPane scrollPane;

    /**
     * Método constructor
     *
     * @param ac recibe un Actionlistener para asignarlo a algunos de sus componentes
     */
    public ViewAdministrator(ActionListener ac) {
        this.setBackground(Color.white);
        initComponents(ac);
    }

    /**
     * Método que inicializan los atributos del panel
     *
     * @param ac recibe un ActioListener, el cual se envia al componente que valla a manejar un evento
     */
    public void initComponents(ActionListener ac) {
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createJLabelTitle();
        createJTable();
        createJButtonSend(ac);
        createJButtonReturn(ac);
        createJLabelOptionToModify();
        createOptionNumber();
        createNewQuantity();
        createJLabelQuantity();
    }

    /**
     * Metodo que retorna la nueva cantidad de un producto
     *
     * @return quantity.getText();  retorna el contenido del JTextField
     */
    public String quantity() {
        return quantity.getText();
    }

    /**
     * Metodo que retorna el numero de producto al cual van a modificar
     *
     * @return optionToModify.getText();  retorna el dato que contiene el JTextField
     */
    public String optionModify() {
        return optionToModify.getText();
    }

    /**
     * Creación de un JTable, el cual va a contener una tabla
     * la cual almacena indice del producto, nombre del producto y cantidad
     */
    public void createJTable() {
        jTable = new JTable();
        scrollPane = new JScrollPane(jTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jTable.setBackground(Color.white);
        jTable.setFont(new Font("century", Font.BOLD, 16));
        jTable.setPreferredSize(new Dimension(500, 420));
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(scrollPane, gbc);
    }

    /**
     * Metodo donde se le envia un DefaultTableModel al JTable
     *
     * @param table DefaultTableModel
     */
    public void updateTable(DefaultTableModel table) {
        jTable.setModel(table);
    }

    /**
     * Se crea unJLabel, el cual tiene como funcionalidad informarle al usuario
     * que se encuentra dentro del inventario
     */
    public void createJLabelTitle() {
        title = new JLabel("Inventario");
        title.setFont(new Font("century", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(title, gbc);
    }

    /**
     * Metodo donde se crea un JLabel, donde, se pide al usuario que ingrese el numero de producto a modificar
     */
    public void createJLabelOptionToModify() {
        labelOptionToModify = new JLabel("Ingrese el numero del producto a modificar");
        labelOptionToModify.setFont(new Font("century", Font.BOLD, 16));
        labelOptionToModify.setPreferredSize(new Dimension(400, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(labelOptionToModify, gbc);
    }

    /**
     * Se crea un JTextField, el cual almacena el numero de producto que el usuario va a modificar
     */
    public void createOptionNumber() {
        optionToModify = new JTextField();
        optionToModify.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(optionToModify, gbc);
        ;
    }

    /**
     * Se pide al usuario que ingrese la nueva cantidad de un ingrediente
     */
    public void createJLabelQuantity() {
        quantityLabel = new JLabel("Ingrese la cantidad");
        quantityLabel.setFont(new Font("century", Font.BOLD, 16));
        quantityLabel.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(quantityLabel, gbc);
    }

    /**
     * Se crea un JTextField, para almacenar la cantidad asignada a un ingrediente
     */
    public void createNewQuantity() {
        quantity = new JTextField();
        quantity.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(quantity, gbc);
    }

    /**
     * Metodo donde se crea un boton llamado "Modificar", el cual, al ser precionado, efectua los cambios en el inventario
     *
     * @param ac ActionListener
     */
    public void createJButtonSend(ActionListener ac) {
        modify = new JButton("Modificar");
        modify.setBackground(new Color(241, 88, 46));
        modify.setPreferredSize(new Dimension(100, 50));
        modify.addActionListener(ac);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(modify, gbc);
    }

    /**
     * Metodo donde se crea un boton llamado "Volver", el cual, al precionarse, permite  que el administrador vuelva a la
     * ventana principal
     *
     * @param ac ActionListener
     */
    public void createJButtonReturn(ActionListener ac) {
        goBack = new JButton("Volver");
        goBack.setBackground(new Color(241, 88, 9));
        goBack.setPreferredSize(new Dimension(100, 50));
        goBack.addActionListener(ac);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(goBack, gbc);
    }

    /**
     * metodo que retorna el Jtable creado anteriormente
     *
     * @return jTable
     */
    public JTable getjTable() {
        return jTable;
    }
}